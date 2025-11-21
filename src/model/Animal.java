package model;

import java.util.Date;

public class Animal {

    private String nome;
    private String especie;
    private String raca;
    private Date dataNascimento;
    private double peso;
    private ProprietarioAnimal proprietario;

    public Animal(String nome, String especie, String raca, Date dataNascimento, double peso, ProprietarioAnimal proprietario) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.dataNascimento = dataNascimento;
        this.peso = peso;
        this.proprietario = proprietario;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaca() {
        return raca;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public double getPeso() {
        return peso;
    }

    public ProprietarioAnimal getProprietario() {
        return proprietario;
    }
}

