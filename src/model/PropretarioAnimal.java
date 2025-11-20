package model;

import java.util.ArrayList;
import java.util.List;

public class PropretarioAnimal extends Pessoa{

    private Endereco endereco;
    private String email;
    private String cpf;
    private List<Animal> animais;

    public PropretarioAnimal(String nome, String cpf, String telefone, String email, Endereco endereco) {
        super(nome, telefone);
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.animais = new ArrayList<>();
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

    public List<Animal> getAnimais() {
        return animais;
    }


}
