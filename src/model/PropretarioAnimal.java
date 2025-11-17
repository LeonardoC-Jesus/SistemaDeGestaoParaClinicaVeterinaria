package model;

public class PropretarioAnimal extends Pessoa{

    private Endereco endereco;
    private String email;
    private String cpf;

    public PropretarioAnimal(String nome, String cpf, String telefone, String email, Endereco endereco) {
        super(nome, telefone);
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }
}
