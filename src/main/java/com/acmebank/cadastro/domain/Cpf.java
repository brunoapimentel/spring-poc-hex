package com.acmebank.cadastro.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cpf {
    private String numero;
    private String fotoUrl;
}
