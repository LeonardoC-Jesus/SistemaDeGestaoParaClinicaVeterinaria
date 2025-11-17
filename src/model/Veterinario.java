package model;

public class Veterinario extends Pessoa{

    private String CRMV;
    private String especialidade;

    public Veterinario(String nome, String telefone, String Crmv, String especialidade) {
        super(nome, telefone);
        this.CRMV = Crmv;
        this.especialidade = especialidade;
    }

    public String getCRMV() {
        return CRMV;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
