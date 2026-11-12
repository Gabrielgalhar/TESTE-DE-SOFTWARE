package br.edu.exemplo;

public class Produto {

    private final String nome;
    private int quantidade;

    public Produto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void adicionarEstoque(int unidades) {
        if (unidades > 0) {
            quantidade += unidades;
        }
    }

    public void retirarEstoque(int unidades) {
        if (unidades > 0 && unidades <= quantidade) {
            quantidade -= unidades;
        }
    }
}
