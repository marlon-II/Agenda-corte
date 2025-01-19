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

import com.barbearia.agendaCorte.data.ClienteEntity;
import com.barbearia.agendaCorte.service.ClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
 @Autowired

    ClienteService clienteService;

    @PostMapping("/adicionar")
    public ResponseEntity<ClienteEntity> addCorte (@RequestBody ClienteEntity cliente){
        var novoCliente = clienteService.criarCliente(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    @SuppressWarnings("rawtypes")
    @GetMapping("/listar")
   public ResponseEntity<List> getAllFilmes() { 

        List<ClienteEntity> cliente = clienteService.listarTdClientes();

        return new ResponseEntity<>(cliente, HttpStatus.OK); 

 } 

  @GetMapping("/id/{nomeC}")
    public ResponseEntity<Integer> buscarIdPorNome(@PathVariable("nomeC") String nomeC) {
        try {
            Integer idCliente = clienteService.buscarIdPorNome(nomeC);  // Chama o serviço para buscar o ID
            
            
            if (idCliente != null) {
                return ResponseEntity.ok(idCliente);
            } else {
               
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
           
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

   
}
