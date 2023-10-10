package com.eyesonserver.model.negocio;

import com.eyesonserver.model.maquina.Servidor;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private Integer id;
    private String nomeFantasia;
    private String cnpj;
    private String email;
    private String cep;
    private List<Servidor> servidores;

    public Empresa(Integer id, String nomeFantasia, String cnpj, String email, String cep) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.email = email;
        this.cep = cep;
        this.servidores = new ArrayList<>();
    }

    public List<Servidor> getServidores() {
        return servidores;
    }

    public void setServidores(List<Servidor> servidores) {
        this.servidores = servidores;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
