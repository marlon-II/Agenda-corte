package com.barbearia.agendaCorte.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Integer>{

    Optional<FuncionarioEntity> findByNome(String nome);
}
