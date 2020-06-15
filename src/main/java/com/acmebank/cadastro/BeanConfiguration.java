package com.acmebank.cadastro;

import com.acmebank.cadastro.domain.CadastroFacade;
import com.acmebank.cadastro.persistence.PersistentCadastroPendenteRepository;
import com.acmebank.cadastro.persistence.PersistentClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Autowired
    private PersistentCadastroPendenteRepository cadastroPendenteRepository;
    @Autowired
    private PersistentClienteRepository clienteRepository;

    @Bean
    public CadastroFacade clienteService(){
        return new CadastroFacade(cadastroPendenteRepository, clienteRepository);
    }
}
