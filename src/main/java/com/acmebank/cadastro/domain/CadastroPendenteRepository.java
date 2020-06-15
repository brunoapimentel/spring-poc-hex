package com.acmebank.cadastro.domain;

public interface CadastroPendenteRepository {
    public CadastroPendente adicionar(CadastroPendente cadastroPendente);
    public CadastroPendente recuperar(Cpf cpf);
}
