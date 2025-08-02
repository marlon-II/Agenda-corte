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

import com.barbearia.agendaCorte.data.FuncionarioEntity;
import com.barbearia.agendaCorte.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionariosController {
    @Autowired

    FuncionarioService funcionarioService;

    @PostMapping("/adicionar")
    public ResponseEntity<FuncionarioEntity> addFuncionario (@RequestBody FuncionarioEntity funcionario){
        var novoFuncionario = funcionarioService.criarFuncionario(funcionario);
        return new ResponseEntity<>(novoFuncionario, HttpStatus.CREATED);
    }

    @SuppressWarnings("rawtypes")
    @GetMapping("/listar")
   public ResponseEntity<List> getAllFilmes() { 

        List<FuncionarioEntity> funcionario = funcionarioService.listarTdfuncionarios();

        return new ResponseEntity<>(funcionario, HttpStatus.OK); 

 } 

  @GetMapping("/id/{nomeF}")
    public ResponseEntity<Integer> buscarIdPorFuncionario(@PathVariable("nomeF") String nomeF) {
        try {
            Integer idBarbeiro = funcionarioService.buscarIdPorFuncionario(nomeF); 
              
            if (idBarbeiro != null) {
                return ResponseEntity.ok(idBarbeiro);
            } else {
              
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
           
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    
}