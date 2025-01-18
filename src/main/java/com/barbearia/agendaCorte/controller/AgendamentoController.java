package com.barbearia.agendaCorte.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbearia.agendaCorte.data.AgendamentoEntity;
import com.barbearia.agendaCorte.data.AgendamentoRepository;
import com.barbearia.agendaCorte.data.AgendamentoRequest;
import com.barbearia.agendaCorte.exeption.ResourceNotFoundException;
import com.barbearia.agendaCorte.service.AgendamentoService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired

    AgendamentoService agendamentoService;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @PostMapping("/adicionar")
    public ResponseEntity<AgendamentoEntity> adicionarAgendamento(@RequestBody AgendamentoRequest request) {
        try {
            
            AgendamentoEntity agendamento = agendamentoService.criarAgendamento(
                request.getId_cliente(),
                request.getId_barbeiro(),
                request.getIdTipoCorte(),
                request.getData_marcada(),
                request.getHora()
            );

            
            return ResponseEntity.ok(agendamento);
        } catch (EntityNotFoundException e) {
            
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoEntity> getAgendamento(@PathVariable("id") Integer agendamentoId) {
        try {
            AgendamentoEntity agendamento = agendamentoService.getAgendamentoById(agendamentoId);
            return ResponseEntity.ok(agendamento);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    
    @GetMapping("/listar")
    public ResponseEntity<List<AgendamentoEntity>> listarAgendamentos() {
        try {
            List<AgendamentoEntity> agendamentos = agendamentoRepository.findAll();
            if (agendamentos.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(agendamentos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
