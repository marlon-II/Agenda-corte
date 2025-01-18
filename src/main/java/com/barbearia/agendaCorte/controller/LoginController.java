package com.barbearia.agendaCorte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbearia.agendaCorte.data.ClienteEntity;
import com.barbearia.agendaCorte.data.ClienteRepository;
import com.barbearia.agendaCorte.data.FuncionarioEntity;
import com.barbearia.agendaCorte.data.FuncionarioRepository;
import com.barbearia.agendaCorte.data.LoginRequest;
import com.barbearia.agendaCorte.data.LoginResponse;
import com.barbearia.agendaCorte.exeption.ErrorResponse;

@RestController
@RequestMapping("/login")
public class LoginController {

   @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @PostMapping
    public ResponseEntity<?> verificarLogin(@RequestBody LoginRequest loginRequest) {
        String nome = loginRequest.getNome();
        String senha = loginRequest.getSenha();

      
        ClienteEntity cliente = clienteRepository.findByNomeAndSenha(nome, senha);
        if (cliente != null) {
            return ResponseEntity.ok(new LoginResponse("cliente"));
        }

        
        FuncionarioEntity funcionario = funcionarioRepository.findByNomeAndSenha(nome, senha);
        if (funcionario != null) {
            return ResponseEntity.ok(new LoginResponse("funcionario"));
        }

      
        return ResponseEntity.status(401).body(new ErrorResponse("Credenciais incorretas"));
    }
}
