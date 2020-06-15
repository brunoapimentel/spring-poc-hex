package com.acmebank.cadastro.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
public class Cliente {
    @Getter
    private Cpf cpf;
    @Getter
    private String nome;
    @Getter
    private LocalDate cadastradoEm;
    @Getter
    private LocalDate efetivadoEm;

    public Cliente(CadastroPendente cadastroPendente){
        this.cpf = cadastroPendente.getCpf();
        this.nome = cadastroPendente.getNome();
        this.cadastradoEm = cadastroPendente.getCadastradoEm();
        this.efetivadoEm = LocalDate.now();
    }

    public void efetivarCadastro(){
        efetivadoEm = LocalDate.now();
    }
}
