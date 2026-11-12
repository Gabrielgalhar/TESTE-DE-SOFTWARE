package br.edu.exemplo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CarrinhoTest {

    private static final double DELTA = 0.0001;

    private double totalComUmProduto(double preco) {
        Carrinho c = new Carrinho();
        c.adicionar(new Produto("Item", preco));
        return c.getTotal();
    }

    @Test
    void carrinhoVazioTemTotalZero() {
        assertEquals(0.0, new Carrinho().getTotal(), DELTA);
    }

    @Test
    void adicionaUmProduto() {
        assertEquals(100.0, totalComUmProduto(100.0), DELTA);
    }

    @Test
    void somaVariosProdutos() {
        Carrinho c = new Carrinho();
        c.adicionar(new Produto("Teclado", 100.0));
        c.adicionar(new Produto("Mouse", 50.0));
        assertEquals(150.0, c.getTotal(), DELTA);
    }

    @Test
    void removeProduto() {
        Carrinho c = new Carrinho();
        Produto teclado = new Produto("Teclado", 100.0);
        Produto mouse = new Produto("Mouse", 50.0);
        c.adicionar(teclado);
        c.adicionar(mouse);
        c.remover(mouse);
        assertEquals(100.0, c.getTotal(), DELTA);
    }

    @Test
    void precoNegativoLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> new Produto("Teclado", -100.0));
    }

    @Test
    void descontoDeDezPorCentoAcimaDoLimite() {
        assertEquals(540.0, totalComUmProduto(600.0), DELTA);
    }

    @Test
    void semDescontoEm499e99() {
        assertEquals(499.99, totalComUmProduto(499.99), DELTA);
    }

    @Test
    void descontoExatamenteEm500() {
        assertEquals(450.0, totalComUmProduto(500.0), DELTA);
    }

    @Test
    void descontoEm500e01() {
        assertEquals(450.009, totalComUmProduto(500.01), DELTA);
    }

    @Test
    void removerReavaliaODesconto() {
        Carrinho c = new Carrinho();
        Produto caro = new Produto("Monitor", 450.0);
        c.adicionar(caro);
        c.adicionar(new Produto("Mouse", 100.0));
        assertEquals(495.0, c.getTotal(), DELTA);
        c.remover(caro);
        assertEquals(100.0, c.getTotal(), DELTA);
    }
}
