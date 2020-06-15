package com.acmebank.cadastro.persistence;

import com.acmebank.cadastro.domain.Cliente;
import com.acmebank.cadastro.domain.ClienteRepository;
import com.acmebank.cadastro.domain.Cpf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersistentClienteRepository implements ClienteRepository {
    @Autowired
    private ClienteJpaRepository repository;

    @Override
    public Cliente adicionar(Cliente cliente) {
        ClienteEntity entity = repository.save(new ClienteEntity(cliente));
        return entity.getCliente();
    }

    @Override
    public Cliente recuperar(Cpf cpf) {
        Optional<ClienteEntity> optional = repository.findByCpfNumero(cpf.getNumero());
        return optional.get().getCliente();
    }
}
