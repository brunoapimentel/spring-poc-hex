package com.acmebank.cadastro.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CadastroFacade {
    private CadastroPendenteRepository cadastroPendenteRepository;
    private ClienteRepository clienteRepository;

    public CadastroPendente cadastrar(CadastroPendente cadastroPendente){
        cadastroPendenteRepository.adicionar(cadastroPendente);
        return cadastroPendente;
    }

    public Cliente efetivar(Cpf cpf){
        CadastroPendente cadastroPendente = cadastroPendenteRepository.recuperar(cpf);
        return cadastroPendente.efetivar();
    }

    public Cliente consultar(Cpf cpf){
        return clienteRepository.recuperar(cpf);
    }
}
