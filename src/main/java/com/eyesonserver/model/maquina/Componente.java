package com.eyesonserver.model.maquina;

import com.eyesonserver.model.metrica.Registro;

import java.util.ArrayList;
import java.util.List;

public class Componente {
    private Integer id;
    private String nome;
    private List<Registro> registros;

    public Componente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
        this.registros = new ArrayList<>();
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
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
}
