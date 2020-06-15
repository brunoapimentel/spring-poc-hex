package com.acmebank.cadastro.persistence;

import com.acmebank.cadastro.domain.Cliente;
import com.acmebank.cadastro.domain.CadastroPendente;
import com.acmebank.cadastro.domain.Cpf;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpfNumero;
    private String cpfFotoUrl;
    private LocalDate cadastradoEm;
    private Boolean cadastroEfetivado;
    private LocalDate efetivadoEm;

    public ClienteEntity(CadastroPendente cliente){
        this.nome = cliente.getNome();
        this.cpfNumero = cliente.getCpf().getNumero();
        this.cpfFotoUrl = cliente.getCpf().getFotoUrl();
        this.cadastradoEm = cliente.getCadastradoEm();
        this.cadastroEfetivado = false;
    }

    public ClienteEntity(Cliente cliente){
        this.nome = cliente.getNome();
        this.cpfNumero = cliente.getCpf().getNumero();
        this.cpfFotoUrl = cliente.getCpf().getFotoUrl();
        this.cadastradoEm = cliente.getCadastradoEm();
        this.cadastroEfetivado = true;
        this.efetivadoEm = cliente.getEfetivadoEm();
    }

    public CadastroPendente getCadastroPendente(){
        Cpf cpf = new Cpf(cpfNumero, cpfFotoUrl);
        return new CadastroPendente(cpf, nome);
    }

    public Cliente getCliente(){
        Cpf cpf = new Cpf(cpfNumero, cpfFotoUrl);
        return new Cliente(cpf, nome, cadastradoEm, efetivadoEm);
    }
}
