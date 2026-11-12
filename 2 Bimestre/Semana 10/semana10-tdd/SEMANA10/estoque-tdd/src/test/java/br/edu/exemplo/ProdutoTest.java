package br.edu.exemplo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ProdutoTest {

    @Test
    void estoqueInicialEhZero() {
        assertEquals(0, new Produto("Teclado").getQuantidade());
    }

    @Test
    void adicionaUnidades() {
        Produto p = new Produto("Teclado");
        p.adicionarEstoque(10);
        assertEquals(10, p.getQuantidade());
    }

    @Test
    void acumulaEntradas() {
        Produto p = new Produto("Teclado");
        p.adicionarEstoque(10);
        p.adicionarEstoque(5);
        assertEquals(15, p.getQuantidade());
    }

    @Test
    void retiraUnidades() {
        Produto p = new Produto("Teclado");
        p.adicionarEstoque(10);
        p.retirarEstoque(3);
        assertEquals(7, p.getQuantidade());
    }

    @Test
    void naoPermiteRetiradaMaiorQueEstoque() {
        Produto p = new Produto("Teclado");
        p.adicionarEstoque(10);
        p.retirarEstoque(15);
        assertEquals(10, p.getQuantidade());
    }

    @Test
    void retiradaDoEstoqueTotalEhPermitida() {
        Produto p = new Produto("Teclado");
        p.adicionarEstoque(10);
        p.retirarEstoque(10);
        assertEquals(0, p.getQuantidade());
    }

    @Test
    void naoPermiteEntradaNegativaOuZero() {
        Produto p = new Produto("Teclado");
        p.adicionarEstoque(-10);
        p.adicionarEstoque(0);
        assertEquals(0, p.getQuantidade());
    }

    @Test
    void retiradaNaoPositivaNaoAlteraEstoque() {
        Produto p = new Produto("Teclado");
        p.adicionarEstoque(10);
        p.retirarEstoque(0);
        p.retirarEstoque(-2);
        assertEquals(10, p.getQuantidade());
    }
}
