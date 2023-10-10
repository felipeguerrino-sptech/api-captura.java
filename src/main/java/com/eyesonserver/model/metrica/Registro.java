package com.eyesonserver.model.metrica;

import com.eyesonserver.model.maquina.Componente;

import java.time.LocalDateTime;

public class Registro {
    private Integer id;
    private Integer fkMedida;
    private Integer fkComponente;
    private String simbolo;
    private String valor;
    private LocalDateTime momento;

    public Registro(Integer id, Integer fkMedida, Integer fkComponente, String simbolo, String valor, LocalDateTime momento) {
        this.id = id;
        this.fkMedida = fkMedida;
        this.fkComponente = fkComponente;
        this.simbolo = simbolo;
        this.valor = valor;
        this.momento = momento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkMedida() {
        return fkMedida;
    }

    public void setFkMedida(Integer fkMedida) {
        this.fkMedida = fkMedida;
    }

    public Integer getFkComponente() {
        return fkComponente;
    }

    public void setFkComponente(Integer fkComponente) {
        this.fkComponente = fkComponente;
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