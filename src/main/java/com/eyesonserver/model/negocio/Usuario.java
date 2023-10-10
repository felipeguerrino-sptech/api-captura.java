package com.eyesonserver.model.negocio;

public class Usuario {
    private Integer id;
    private Integer fkEmpresa;
    private String nome;
    private String email;
    private Integer cargo;

    public Usuario(Integer id, Integer fkEmpresa, String nome, String email, String senha, Integer cargo) {
        this.id = id;
        this.fkEmpresa = fkEmpresa;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
    }

    public Integer getCargo() {
        return cargo;
    }

    public void setCargo(Integer cargo) {
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
