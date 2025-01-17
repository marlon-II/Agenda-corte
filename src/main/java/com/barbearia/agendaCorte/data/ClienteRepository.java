package com.barbearia.agendaCorte.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer>{

    Optional<ClienteEntity> findByNome(String nome);
}
