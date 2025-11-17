package model;

public class Endereco {

    private String rua;
    private String bairro;
    private String cidade;
    private Integer numero;

    public Endereco(String rua, String bairro, String cidade, Integer numero) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero = numero;
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

    public Integer getNumero() {
        return numero;
    }
}
