package com.acmebank.cadastro.application;

import com.acmebank.cadastro.domain.CadastroPendente;
import com.acmebank.cadastro.domain.Cpf;
import lombok.Data;

@Data
public class DadosCadastrais {
    private String nome;
    private String cpfNumero;
    private String cpfFotoUrl;

    public CadastroPendente getCadastroPendente(){
        Cpf cpf = new Cpf(cpfNumero, cpfFotoUrl);
        return new CadastroPendente(cpf, nome);
    }
}
