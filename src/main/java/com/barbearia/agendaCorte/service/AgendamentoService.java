package com.barbearia.agendaCorte.service;

import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbearia.agendaCorte.data.AgendamentoEntity;
import com.barbearia.agendaCorte.data.AgendamentoRepository;
import com.barbearia.agendaCorte.data.ClienteEntity;
import com.barbearia.agendaCorte.data.CortesEntity;
import com.barbearia.agendaCorte.data.FuncionarioEntity;
import com.barbearia.agendaCorte.exeption.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service

public class AgendamentoService {
    @Autowired

    AgendamentoRepository agendamentoRepository;

 @Autowired
    private ClienteService clienteService;

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private CortesService cortesService;

    public AgendamentoEntity criarAgendamento(Integer clienteId, Integer barbeiroId, Integer tipoCorteId, String dataMarcada, String hora) {
        // Buscar cliente, barbeiro e tipo de corte
        ClienteEntity cliente = clienteService.findById(clienteId);
        FuncionarioEntity barbeiro = funcionarioService.findById(barbeiroId);
        CortesEntity tipoCorte = cortesService.findById(tipoCorteId);

        if (cliente == null || barbeiro == null || tipoCorte == null) {
            throw new EntityNotFoundException("Cliente, barbeiro ou tipo de corte não encontrado.");
        }

        // Criar o agendamento
        AgendamentoEntity agendamento = new AgendamentoEntity();
        agendamento.setCliente(cliente);
        agendamento.setFuncionario(barbeiro);
        agendamento.setCorte(tipoCorte);
        agendamento.setData_marcada(dataMarcada);
        agendamento.setHora(hora);

        // Salvar o agendamento no banco de dados
        return agendamentoRepository.save(agendamento);
    }

    public AgendamentoEntity getAgendamentoById(Integer agendamentoId) {
        return agendamentoRepository.findById(agendamentoId)
                .orElseThrow(() -> new ResourceNotFoundException("Agendamento não encontrado com ID " + agendamentoId));
    }

    public AgendamentoEntity getAgendametoId(Integer agendamentoId) {
        return agendamentoRepository.findById(agendamentoId)
            .orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado com id " + agendamentoId));
    }

    public List<AgendamentoEntity> listarTdAgendamentos(){
        return agendamentoRepository.findAll();
    }


}
