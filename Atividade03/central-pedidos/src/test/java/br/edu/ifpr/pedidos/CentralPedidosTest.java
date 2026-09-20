package br.edu.ifpr.pedidos;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class CentralPedidosTest {
    private ItemPedido item(long preco, int qtd, int estoque, int peso, boolean fragil) {
        return new ItemPedido("SKU", preco, qtd, estoque, peso, fragil);
    }
    private Pedido pedido(String uf, boolean expresso, String cupom, ItemPedido... itens) {
        return new Pedido(List.of(itens), uf, expresso, cupom);
    }

    @Test void entidadesValidamEntradasETotais() {
        ItemPedido ativo = item(1_000, 2, 2, 500, false);
        assertAll(() -> assertEquals(2_000, ativo.totalCentavos()), () -> assertTrue(ativo.disponivel()),
            () -> assertThrows(IllegalArgumentException.class, () -> new Cliente(false, false, -1)),
            () -> assertThrows(IllegalArgumentException.class, () -> item(0, 1, 1, 1, false)),
            () -> assertThrows(IllegalArgumentException.class, () -> new Pedido(List.of(), "pr", false, null)));
    }

    @Test void pedidoCobreLinhasAtivasFragilEEstoque() {
        Pedido p = pedido("PR", false, null, item(1_000, 2, 2, 500, false), item(500, 0, 0, 700, true), item(300, 1, 0, 200, true));
        assertAll(() -> assertEquals(2_300, p.subtotalCentavos()), () -> assertEquals(1_200, p.pesoGramas()),
            () -> assertTrue(p.temFragil()), () -> assertFalse(p.estoqueSuficiente()),
            () -> assertEquals(0, pedido("SP", false, null).subtotalCentavos()));
    }

    @Test void descontosCobremTiposCuponsELimites() {
        PoliticaDesconto d = new PoliticaDesconto();
        Cliente novo = new Cliente(false, false, 0);
        assertAll(() -> assertEquals(0, d.calcular(novo, 49_999, null)),
            () -> assertEquals(2_500, d.calcular(new Cliente(false, false, 1), 50_000, " ")),
            () -> assertEquals(2_000, d.calcular(novo, 10_000, " bemvindo ")),
            () -> assertEquals(0, d.calcular(novo, 19_999, "EXTRA10")),
            () -> assertEquals(4_000, d.calcular(new Cliente(true, false, 2), 20_000, "EXTRA10")),
            () -> assertThrows(IllegalArgumentException.class, () -> d.calcular(novo, 10_000, "OUTRO")),
            () -> assertThrows(IllegalArgumentException.class, () -> d.calcular(novo, -1, null)));
    }

    @Test void freteCobreUfsPesoGratuidadeVipExpressoEFragil() {
        CalculadoraFrete f = new CalculadoraFrete(); Cliente comum = new Cliente(false, false, 1);
        assertAll(() -> assertEquals(1_200, f.calcular(pedido("PR", false, null, item(1, 1, 1, 2_000, false)), comum, 1)),
            () -> assertEquals(2_300, f.calcular(pedido("SP", false, null, item(1, 1, 1, 2_001, false)), comum, 1)),
            () -> assertEquals(3_600, f.calcular(pedido("MG", false, null, item(1, 1, 1, 4_001, false)), comum, 1)),
            () -> assertEquals(0, f.calcular(pedido("RJ", false, null, item(1, 1, 1, 1, false)), comum, 30_000)),
            () -> assertEquals(2_000, f.calcular(pedido("PR", true, null, item(1, 1, 1, 1, true)), new Cliente(true, false, 1), 30_000)),
            () -> assertThrows(IllegalArgumentException.class, () -> f.calcular(pedido("PR", false, null), comum, -1)));
    }

    @Test void riscoCobreRecusaRevisaoEAprovacao() {
        AnaliseRisco r = new AnaliseRisco();
        assertAll(() -> assertEquals("RECUSADO", r.avaliar(new Cliente(false, true, 0), 0, false)),
            () -> assertEquals("REVISAO", r.avaliar(new Cliente(false, false, 0), 100_001, false)),
            () -> assertEquals("REVISAO", r.avaliar(new Cliente(false, false, 0), 1, true)),
            () -> assertEquals("REVISAO", r.avaliar(new Cliente(false, false, 1), 500_001, false)),
            () -> assertEquals("APROVADO", r.avaliar(new Cliente(true, false, 1), 600_000, false)),
            () -> assertThrows(IllegalArgumentException.class, () -> r.avaliar(new Cliente(false, false, 1), -1, false)));
    }

    @Test void pagamentoCobreAprovacaoRecusaRetentativasEValidacao() {
        AtomicInteger chamadas = new AtomicInteger();
        PagamentoService tenta = new PagamentoService(total -> { if (chamadas.getAndIncrement() < 2) throw new IllegalStateException(); return true; });
        assertAll(() -> assertTrue(tenta.pagar(100, 3)), () -> assertEquals(3, chamadas.get()),
            () -> assertFalse(new PagamentoService(total -> false).pagar(100, 1)),
            () -> assertFalse(new PagamentoService(total -> { throw new IllegalStateException(); }).pagar(100, 2)),
            () -> assertThrows(IllegalArgumentException.class, () -> tenta.pagar(0, 1)),
            () -> assertThrows(IllegalArgumentException.class, () -> tenta.pagar(1, 4)));
    }

    @Test void fechamentoCobreRetornosAntecipadosRevisaoEPagamento() {
        AtomicInteger chamadas = new AtomicInteger(); PedidoService s = new PedidoService(total -> { chamadas.incrementAndGet(); return true; });
        ItemPedido disponivel = item(10_000, 1, 1, 1_000, false);
        assertAll(() -> assertEquals("BLOQUEADO", s.fechar(pedido("PR", false, "INVALIDO"), new Cliente(false, true, 0)).status()),
            () -> assertEquals("SEM_ESTOQUE", s.fechar(pedido("PR", false, null, item(100, 1, 0, 1, false)), new Cliente(false, false, 1)).status()),
            () -> assertThrows(IllegalArgumentException.class, () -> s.fechar(pedido("PR", false, null, item(10, 0, 0, 1, false)), new Cliente(false, false, 1))),
            () -> assertEquals("REVISAO", s.fechar(pedido("PR", true, null, disponivel), new Cliente(false, false, 0)).status()));
        ResultadoPedido pago = s.fechar(pedido("PR", false, null, disponivel), new Cliente(false, false, 1));
        assertAll(() -> assertEquals("PAGO", pago.status()), () -> assertEquals(11_200, pago.totalCentavos()), () -> assertEquals(1, chamadas.get()));
    }
}
