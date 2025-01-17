package com.barbearia.agendaCorte.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbearia.agendaCorte.data.FuncionarioEntity;
import com.barbearia.agendaCorte.data.FuncionarioRepository;
import com.barbearia.agendaCorte.exeption.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FuncionarioService {

    @Autowired

    FuncionarioRepository funcionarioRepository;

    public FuncionarioEntity criarFuncionario(FuncionarioEntity funcionario){
       funcionario.setId_barbeiro(null);
       FuncionarioEntity funcionarioSalvo = funcionarioRepository.save(funcionario);
        return funcionarioSalvo;
    }

    public FuncionarioEntity getfuncionarioId(Integer funcionarioId) {
        return funcionarioRepository.findById(funcionarioId)
            .orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado com id " + funcionarioId));
    }

    public List<FuncionarioEntity> listarTdfuncionarios(){
        return funcionarioRepository.findAll();
    }

    public Optional<FuncionarioEntity> findByNome(String nome) {
        return funcionarioRepository.findByNome(nome);
    }

    public FuncionarioEntity findById(Integer barbeiroId) {
        return funcionarioRepository.findById(barbeiroId)
                .orElseThrow(() -> new EntityNotFoundException("Barbeiro não encontrado com ID " + barbeiroId));
    }
}
