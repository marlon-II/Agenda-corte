package com.barbearia.agendaCorte.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Integer>{

    FuncionarioEntity findByNome(String nome);
    FuncionarioEntity findByNomeAndSenha(String nome, String senha);

}
