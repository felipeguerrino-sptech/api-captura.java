package com.eyesonserver.model.metrica;

import java.time.LocalDateTime;

public class Registro {
    private Integer id;
    private Integer fkMedida;
    private Integer fkComponente;
    private String fkServidor;
    private String valor;
    private LocalDateTime momento;

    public Registro(Integer fkMedida, Integer fkComponente, String fkServidor, String valor, LocalDateTime momento) {
        this.fkMedida = fkMedida;
        this.fkComponente = fkComponente;
        this.fkServidor = fkServidor;
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

    public String getFkServidor() {
        return fkServidor;
    }

    public void setFkServidor(String simbolo) {
        this.fkServidor = simbolo;
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