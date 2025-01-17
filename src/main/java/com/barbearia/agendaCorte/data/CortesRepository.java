package com.barbearia.agendaCorte.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CortesRepository extends JpaRepository<CortesEntity, Integer>{

    Optional<CortesEntity> findByNome(String nome);
}