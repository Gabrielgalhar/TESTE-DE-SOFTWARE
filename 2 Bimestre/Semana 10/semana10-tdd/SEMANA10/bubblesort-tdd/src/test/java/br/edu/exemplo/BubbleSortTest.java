package br.edu.exemplo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class BubbleSortTest {

    private int[] ordenar(int... entrada) {
        BubbleSort bs = new BubbleSort(entrada);
        bs.ordenar();
        return bs.getNumeros();
    }

    @Test
    void ordenaVetorDesordenado() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, ordenar(5, 3, 1, 4, 2));
    }

    @Test
    void mantemVetorJaOrdenado() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, ordenar(1, 2, 3, 4, 5));
    }

    @Test
    void ordenaValoresRepetidos() {
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, ordenar(3, 1, 3, 2, 1));
    }

    @Test
    void ordenaOrdemInversa() {
        assertArrayEquals(new int[]{1, 2, 3, 4}, ordenar(4, 3, 2, 1));
    }

    @Test
    void ordenaNegativos() {
        assertArrayEquals(new int[]{-5, -1, 0, 2}, ordenar(2, -1, 0, -5));
    }

    @Test
    void vetorVazioEUnitario() {
        assertArrayEquals(new int[]{}, ordenar());
        assertArrayEquals(new int[]{7}, ordenar(7));
    }
}
