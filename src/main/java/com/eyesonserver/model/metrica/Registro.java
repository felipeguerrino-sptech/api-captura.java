package com.eyesonserver.model.metrica;

import com.eyesonserver.model.maquina.Componente;

import java.time.LocalDateTime;

public class Registro {
    private Integer id;
    private Medida medida;
    private String simbolo;
    private String valor;
    private LocalDateTime momento;

    public Registro(Integer id, Medida medida, String simbolo, String valor, LocalDateTime momento) {
        this.id = id;
        this.medida = medida;
        this.simbolo = simbolo;
        this.valor = valor;
        this.momento = momento;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Medida getMedida() {
        return medida;
    }

    public void setMedida(Medida medida) {
        this.medida = medida;
    }

    public Integer getId() {
        return id;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public LocalDateTime getMomento() {
        return momento;
    }

    public void setMomento(LocalDateTime momento) {
        this.momento = momento;
    }
}
