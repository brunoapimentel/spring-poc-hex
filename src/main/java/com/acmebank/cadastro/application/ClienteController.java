package com.acmebank.cadastro.application;

import com.acmebank.cadastro.domain.CadastroPendente;
import com.acmebank.cadastro.domain.CadastroFacade;
import com.acmebank.cadastro.domain.Cliente;
import com.acmebank.cadastro.domain.Cpf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {
    @Autowired
    private CadastroFacade cadastroFacade;

    @PostMapping
    public CadastroPendente cadastrar(@RequestBody DadosCadastrais dados){
        CadastroPendente cadastroPendente = dados.getCadastroPendente();
        return cadastroFacade.cadastrar(cadastroPendente);
    }

    @PatchMapping("/{numeroCpf}/efetivar")
    public Cliente efetivar(@PathVariable String numeroCpf){
        Cpf cpf = new Cpf(numeroCpf, null);
        return cadastroFacade.efetivar(cpf);
    }

    @GetMapping("/{numeroCpf}")
    public Cliente consultar(@PathVariable String numeroCpf){
        Cpf cpf = new Cpf(numeroCpf, null);
        return cadastroFacade.consultar(cpf);
    }
}
