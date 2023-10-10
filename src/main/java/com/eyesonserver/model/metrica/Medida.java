package com.eyesonserver.model.metrica;

public class Medida {
    private Integer id;
    private String nome;
    private String simbolo;

    public Medida(Integer id, String nome, String simbolo) {
        this.id = id;
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
}
