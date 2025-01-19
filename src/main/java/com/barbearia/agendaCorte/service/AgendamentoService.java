package com.barbearia.agendaCorte.service;

import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbearia.agendaCorte.data.AgendamentoEntity;
import com.barbearia.agendaCorte.data.AgendamentoRepository;
import com.barbearia.agendaCorte.data.ClienteEntity;
import com.barbearia.agendaCorte.data.ClienteRepository;
import com.barbearia.agendaCorte.data.CortesEntity;
import com.barbearia.agendaCorte.data.CortesRepository;
import com.barbearia.agendaCorte.data.FuncionarioEntity;
import com.barbearia.agendaCorte.data.FuncionarioRepository;
import com.barbearia.agendaCorte.exeption.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service

public class AgendamentoService {
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CortesRepository cortesRepository;

    public AgendamentoEntity criarAgendamento(Integer idCliente, Integer idBarbeiro, Integer idTipoCorte, String dataMarcada, String hora) {
        
        AgendamentoEntity agendamento = new AgendamentoEntity();

        ClienteEntity cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        FuncionarioEntity barbeiro = funcionarioRepository.findById(idBarbeiro).orElseThrow(() -> new EntityNotFoundException("Barbeiro não encontrado"));
        CortesEntity corte = cortesRepository.findById(idTipoCorte).orElseThrow(() -> new EntityNotFoundException("Tipo de corte não encontrado"));

        agendamento.setCliente(cliente); 
        agendamento.setFuncionario(barbeiro); 
        agendamento.setServico(corte); 

        agendamento.setDataMarcada(dataMarcada); 
        agendamento.setHora(hora); 

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

    public List<AgendamentoEntity> findAll() {
        return agendamentoRepository.findAll();
    }


}
