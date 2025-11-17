package model;

public class Consulta {

    private String dataHora;
    private Animal animalAtendido;
    private Veterinario veterinarioResponsavel;
    private String diagnostico;
    private double valor;

    public Consulta(String dataHora, Animal animalAtendido, Veterinario veterinarioResponsavel, String diagnostico, double valor) {
        this.dataHora = dataHora;
        this.animalAtendido = animalAtendido;
        this.veterinarioResponsavel = veterinarioResponsavel;
        this.diagnostico = diagnostico;
        this.valor = valor;
    }

    public String getDataHora() {
        return dataHora;
    }

    public Animal getAnimalAtendido() {
        return animalAtendido;
    }

    public Veterinario getVeterinarioResponsavel() {
        return veterinarioResponsavel;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public double getValor() {
        return valor;
    }
}
