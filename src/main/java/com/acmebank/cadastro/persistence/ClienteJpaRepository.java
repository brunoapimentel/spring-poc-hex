package com.acmebank.cadastro.persistence;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClienteJpaRepository extends CrudRepository<ClienteEntity, Long> {
    Optional<ClienteEntity> findByCpfNumero(String numero);
}
