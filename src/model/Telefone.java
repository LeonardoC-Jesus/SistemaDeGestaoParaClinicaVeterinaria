package model;

public class Telefone {
    private Integer ddi;
    private Integer ddd;
    private Integer prefixo;
    private Integer numero;

    public Telefone(Integer ddi, Integer ddd, Integer prefixo, Integer numero){
        this.ddi = ddi;
        this.ddd = ddd;
        this.prefixo = prefixo;
        this.numero = numero;
    }

    public Integer getDdd() {
        return ddd;
    }

    public Integer getDdi() {
        return ddi;
    }

    public Integer getPrefixo() {
        return prefixo;
    }

    public Integer getNumero() {
        return numero;
    }
}
