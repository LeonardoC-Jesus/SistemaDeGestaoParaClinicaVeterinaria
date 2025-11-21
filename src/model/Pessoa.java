package model;

public class Pessoa  {
    private String nome;
    private Telefone telefone;

    public Pessoa(String nome, Telefone telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public Pessoa() {

    }

    public String getNome() {
        return nome;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int anInt) {
    }
}
