package com.eyesonserver.model.maquina;

public class Processo {
    private Integer id;
    private Integer pid;
    private String nome;
    private Double usoMemoria;
    private Double usoCpu;

    public Processo(Integer id, Integer pid, String nome, Double usoMemoria, Double usoCpu) {
        this.id = id;
        this.pid = pid;
        this.nome = nome;
        this.usoMemoria = usoMemoria;
        this.usoCpu = usoCpu;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPid() {
        return pid;
    }

    public String getNome() {
        return nome;
    }

    public Double getUsoMemoria() {
        return usoMemoria;
    }

    public Double getUsoCpu() {
        return usoCpu;
    }
}
