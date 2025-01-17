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
import com.barbearia.agendaCorte.data.AgendamentoRequest;
// import com.barbearia.agendaCorte.data.ClienteEntity;
// import com.barbearia.agendaCorte.data.CortesEntity;
// import com.barbearia.agendaCorte.data.FuncionarioEntity;
import com.barbearia.agendaCorte.exeption.ResourceNotFoundException;
import com.barbearia.agendaCorte.service.AgendamentoService;
// import com.barbearia.agendaCorte.service.ClienteService;
// import com.barbearia.agendaCorte.service.CortesService;
// import com.barbearia.agendaCorte.service.FuncionarioService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired

    AgendamentoService agendamentoService;
//  @Autowired
    // private ClienteService clienteService;

    // @Autowired
    // private FuncionarioService funcionarioService;

    // @Autowired
    // private CortesService corteService;

   @PostMapping("/adicionar")
    public ResponseEntity<AgendamentoEntity> adicionarAgendamento(@RequestBody AgendamentoRequest request) {
        try {
            // Chama o serviço para criar o agendamento
            AgendamentoEntity agendamento = agendamentoService.criarAgendamento(
                request.getId_cliente(),
                request.getId_barbeiro(),
                request.getIdTipoCorte(),
                request.getData_marcada(),
                request.getHora()
            );

            // Retorna o agendamento criado com sucesso
            return ResponseEntity.ok(agendamento);
        } catch (EntityNotFoundException e) {
            // Caso algum dado não seja encontrado (cliente, barbeiro, tipo de corte)
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

    @SuppressWarnings("rawtypes")
    @GetMapping("/listar")
   public ResponseEntity<List> getAllFilmes() { 

        List<AgendamentoEntity> agendamento = agendamentoService.listarTdAgendamentos(); 

        return new ResponseEntity<>(agendamento, HttpStatus.OK); 

 } 
}
