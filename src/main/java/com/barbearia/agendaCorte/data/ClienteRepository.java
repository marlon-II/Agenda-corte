package com.barbearia.agendaCorte.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer>{

    ClienteEntity findByNome(String nome);
    ClienteEntity findByNomeAndSenha(String nome, String senha);
}
