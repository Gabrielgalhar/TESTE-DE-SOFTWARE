package br.edu.exemplo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ContaBancariaTest {

    private static final double DELTA = 0.0001;

    @Test
    void contaNovaTemSaldoZero() {
        assertEquals(0.0, new ContaBancaria().getSaldo(), DELTA);
    }

    @Test
    void depositoAumentaSaldo() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100);
        assertEquals(100.0, conta.getSaldo(), DELTA);
    }

    @Test
    void depositosSaoAcumulados() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100);
        conta.depositar(50);
        assertEquals(150.0, conta.getSaldo(), DELTA);
    }

    @Test
    void saqueDiminuiSaldo() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100);
        conta.sacar(40);
        assertEquals(60.0, conta.getSaldo(), DELTA);
    }

    @Test
    void saqueMaiorQueSaldoEhRecusado() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100);
        conta.sacar(150);
        assertEquals(100.0, conta.getSaldo(), DELTA);
    }

    @Test
    void saqueDoSaldoTotalEhPermitido() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100);
        conta.sacar(100);
        assertEquals(0.0, conta.getSaldo(), DELTA);
    }

    @Test
    void valoresNaoPositivosSaoIgnorados() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100);
        conta.depositar(0);
        conta.depositar(-10);
        conta.sacar(0);
        conta.sacar(-10);
        assertEquals(100.0, conta.getSaldo(), DELTA);
    }
}
