package model;

import java.util.ArrayList;
import java.util.List;

public class ProprietarioAnimal extends Pessoa{

    private Endereco endereco;
    private Email email;
    private Telefone telefone;
    private String cpf;
    private List<Animal> animais;

    public ProprietarioAnimal(String nome, String cpf, Telefone telefone, Email email, Endereco endereco) {
        super(nome, telefone);
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.animais = new ArrayList<>();
    }

    public ProprietarioAnimal(String nome, Telefone telefone, Email email, String cpf, Endereco end) {
        super();
    }

    public ProprietarioAnimal(long id, String cpf, String nome) {
    }

    public static void inserirPropietario() {
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Telefone getTelefone(){
        return telefone;
    }

    public Email getEmail() {
        return getEmail();
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

}
