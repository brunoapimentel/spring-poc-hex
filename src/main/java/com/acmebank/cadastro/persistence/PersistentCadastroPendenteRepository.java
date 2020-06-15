package com.acmebank.cadastro.persistence;

import com.acmebank.cadastro.domain.CadastroPendente;
import com.acmebank.cadastro.domain.CadastroPendenteRepository;
import com.acmebank.cadastro.domain.Cpf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersistentCadastroPendenteRepository implements CadastroPendenteRepository {
    @Autowired
    private ClienteJpaRepository repository;

    @Override
    public CadastroPendente adicionar(CadastroPendente cadastro) {
        ClienteEntity entity = repository.save(new ClienteEntity(cadastro));
        return entity.getCadastroPendente();
    }

    @Override
    public CadastroPendente recuperar(Cpf cpf) {
        Optional<ClienteEntity> optional = repository.findByCpfNumero(cpf.getNumero());
        return optional.get().getCadastroPendente();
    }
}
