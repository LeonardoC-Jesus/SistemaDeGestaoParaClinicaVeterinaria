package model;

public class Endereco {

    private String rua;
    private String bairro;
    private String cidade;
    private Integer numero_casa;

    public Endereco(String rua, String bairro, String cidade, Integer numero_casa) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero_casa = numero_casa;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public Integer getNumero_casa() {
        return numero_casa;
    }
}
