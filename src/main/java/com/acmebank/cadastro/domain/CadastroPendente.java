package com.acmebank.cadastro.domain;

import lombok.Getter;

import java.time.LocalDate;

public class CadastroPendente {
    @Getter
    private Cpf cpf;
    @Getter
    private String nome;
    @Getter
    private LocalDate cadastradoEm;

    public CadastroPendente(Cpf cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
        this.cadastradoEm = LocalDate.now();
    }

    public CadastroPendente(Cpf cpf, String nome, LocalDate cadastradoEm){
        this.cpf = cpf;
        this.nome = nome;
        this.cadastradoEm = cadastradoEm;
    }

    public Cliente efetivar(){
        return new Cliente(this);
    }
}
