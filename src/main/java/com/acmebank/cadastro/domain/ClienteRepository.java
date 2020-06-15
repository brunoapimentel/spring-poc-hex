package com.acmebank.cadastro.domain;

public interface ClienteRepository {
    public Cliente adicionar(Cliente cliente);
    public Cliente recuperar(Cpf cpf);
}
