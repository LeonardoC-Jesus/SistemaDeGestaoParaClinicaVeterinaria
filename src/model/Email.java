package model;

public class Email {
    private Long id;
    private String enderecoEmail;
    private boolean validado;

    public Email(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
        this.validado = false;
    }

    public Long getId() {
        return id;
    }

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEnderecoEmail(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }
}

