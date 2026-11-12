package br.edu.exemplo;

// Versão inicial (RED): estoque ainda não implementado.
public class Produto {
    private final String nome;
    public Produto(String nome) { this.nome = nome; }
    public String getNome() { return nome; }
    public int getQuantidade() { return -1; }
    public void adicionarEstoque(int unidades) { }
    public void retirarEstoque(int unidades) { }
}
