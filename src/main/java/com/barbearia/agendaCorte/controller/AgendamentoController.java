package com.barbearia.agendaCorte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbearia.agendaCorte.data.AgendamentoEntity;
import com.barbearia.agendaCorte.service.AgendamentoService;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired

    AgendamentoService agendamentoService;

    @PostMapping("/adicionar")
    public ResponseEntity<AgendamentoEntity> addAgendamento (@RequestBody AgendamentoEntity agendamento){
        var novoAgendamento = agendamentoService.criarAgendamento(agendamento);
        return new ResponseEntity<>(novoAgendamento, HttpStatus.CREATED);
    }

    @SuppressWarnings("rawtypes")
    @GetMapping("/listar")
   public ResponseEntity<List> getAllFilmes() { 

        List<AgendamentoEntity> agendamento = agendamentoService.listarTdAgendamentos(); 

        return new ResponseEntity<>(agendamento, HttpStatus.OK); 

 } 
}
