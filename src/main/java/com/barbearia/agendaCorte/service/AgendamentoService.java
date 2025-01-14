package com.barbearia.agendaCorte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbearia.agendaCorte.data.AgendamentoEntity;
import com.barbearia.agendaCorte.data.AgendamentoRepository;
import com.barbearia.agendaCorte.exeption.ResourceNotFoundException;

@Service

public class AgendamentoService {
    @Autowired

    AgendamentoRepository agendamentoRepository;

    public AgendamentoEntity criarAgendamento(AgendamentoEntity agendamento){
        agendamento.setId_agendamento(null);
        AgendamentoEntity agendamentoSalvo = agendamentoRepository.save(agendamento);
        return agendamentoSalvo;
    }

    public AgendamentoEntity getAgendametoId(Integer agendamentoId) {
        return agendamentoRepository.findById(agendamentoId)
            .orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado com id " + agendamentoId));
    }

    public List<AgendamentoEntity> listarTdAgendamentos(){
        return agendamentoRepository.findAll();
    }


}
