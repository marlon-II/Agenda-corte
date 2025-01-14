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

import com.barbearia.agendaCorte.data.CortesEntity;
import com.barbearia.agendaCorte.service.CortesService;

@RestController
@RequestMapping("/cortes")
public class CortesController {
 @Autowired

    CortesService cortesService;

    @PostMapping("/adicionar")
    public ResponseEntity<CortesEntity> addCorte (@RequestBody CortesEntity corte){
        var novoCorte = cortesService.criarCortes(corte);
        return new ResponseEntity<>(novoCorte, HttpStatus.CREATED);
    }

    @SuppressWarnings("rawtypes")
    @GetMapping("/listar")
   public ResponseEntity<List> getAllFilmes() { 

        List<CortesEntity> corte = cortesService.listarTdcortes();

        return new ResponseEntity<>(corte, HttpStatus.OK); 

 } 
}
