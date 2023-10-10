package com.eyesonserver.model.maquina;

import com.eyesonserver.model.metrica.Registro;

import java.util.ArrayList;
import java.util.List;

public class Servidor {
    private Integer id;
    private String nome;
    private String local;
    private String ipv6;
    private String so;
    private String macAdress;
    private List<Registro> registros;

    public Servidor(Integer id, String nome, String local, String ipv6, String so, String macAdress) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.ipv6 = ipv6;
        this.so = so;
        this.macAdress = macAdress;
        this.registros = new ArrayList<>();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMacAdress() {
        return macAdress;
    }

    public void setMacAdress(String macAdress) {
        this.macAdress = macAdress;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    public Integer getId() {
        return id;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getIpv6() {
        return ipv6;
    }

    public void setIpv6(String ipv6) {
        this.ipv6 = ipv6;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }
}
