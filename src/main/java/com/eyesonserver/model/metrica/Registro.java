package com.eyesonserver.model.metrica;

import java.time.LocalDateTime;

public class Registro {
    private Integer id;
    private Integer fkComponenteServidor;
    private String valor;
    private LocalDateTime momento;

    public Registro(Integer fkComponenteServidor, String valor, LocalDateTime momento) {
        this.fkComponenteServidor = fkComponenteServidor;
        this.valor = valor;
        this.momento = momento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Integer getFkComponenteServidor() {
        return fkComponenteServidor;
    }

    public void setFkComponenteServidor(Integer fkComponenteServidor) {
        this.fkComponenteServidor = fkComponenteServidor;
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