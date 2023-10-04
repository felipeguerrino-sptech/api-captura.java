package com.eyesonserver.model.metrica;

import java.time.LocalDateTime;

public class Registro {
    private Integer id;
    private String nomeComponente;
    private String nomeMedida;
    private String simbolo;
    private String valorRegistro;
    private LocalDateTime momentoRegistro;

    public Registro(Integer id, String nomeComponente, String nomeMedida, String simbolo, String valorRegistro, LocalDateTime momentoRegistro) {
        this.id = id;
        this.nomeComponente = nomeComponente;
        this.nomeMedida = nomeMedida;
        this.simbolo = simbolo;
        this.valorRegistro = valorRegistro;
        this.momentoRegistro = momentoRegistro;
    }

    public Integer getId() {
        return id;
    }

    public String getNomeComponente() {
        return nomeComponente;
    }

    public void setNomeComponente(String nomeComponente) {
        this.nomeComponente = nomeComponente;
    }

    public String getNomeMedida() {
        return nomeMedida;
    }

    public void setNomeMedida(String nomeMedida) {
        this.nomeMedida = nomeMedida;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getValorRegistro() {
        return valorRegistro;
    }

    public void setValorRegistro(String valorRegistro) {
        this.valorRegistro = valorRegistro;
    }

    public LocalDateTime getMomentoRegistro() {
        return momentoRegistro;
    }

    public void setMomentoRegistro(LocalDateTime momentoRegistro) {
        this.momentoRegistro = momentoRegistro;
    }
}
