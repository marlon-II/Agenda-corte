package com.barbearia.agendaCorte.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CortesRepository extends JpaRepository<CortesEntity, Integer>{

    CortesEntity findByNome(String nome);
}