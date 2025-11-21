package model;

public class Veterinario extends Pessoa{

    private Telefone telefone;
    private String CRMV;
    private String especialidade;

    public Veterinario(String nome, Telefone telefone, String Crmv, String especialidade) {
        super(nome, telefone);
        this.telefone = telefone;
        this.CRMV = Crmv;
        this.especialidade = especialidade;
    }

    public Telefone getTelefone() {
        return telefone;
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
