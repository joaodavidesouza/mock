package org.example;

public class Contato {
    private Long id;
    private String nome;
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }
    public Contato(Long id, String nome, String email) {

        this.id = id;
        this.nome = nome;
        this.email = email;
    }
}
