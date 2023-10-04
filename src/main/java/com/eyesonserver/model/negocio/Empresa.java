package com.eyesonserver.model.negocio;

public class Empresa {
    private Integer id;
    private String nomeFantasia;
    private String cnpj;
    private String email;
    private String cep;

    public Empresa(Integer id, String nomeFantasia, String cnpj, String email, String cep) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.email = email;
        this.cep = cep;
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
