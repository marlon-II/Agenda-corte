package com.barbearia.agendaCorte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.barbearia.agendaCorte.data.ClienteEntity;
import com.barbearia.agendaCorte.data.FuncionarioEntity;
import com.barbearia.agendaCorte.data.LoginRequest;
import com.barbearia.agendaCorte.data.LoginResponse;
import com.barbearia.agendaCorte.service.ClienteService;
import com.barbearia.agendaCorte.service.FuncionarioService;

@RequestMapping("/logar")
public class LoginController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        
        // Autentica o cliente
        ClienteEntity cliente = clienteService.autenticarCliente(loginRequest.getNome(), loginRequest.getSenha());
        if (cliente != null) {
            return ResponseEntity.ok(new LoginResponse("cliente", cliente)); // Retorna tipo 'cliente' e dados do cliente
        }

        // Autentica o funcionário
        FuncionarioEntity funcionario = funcionarioService.autenticarFuncionario(loginRequest.getNome(), loginRequest.getSenha());
        if (funcionario != null) {
            return ResponseEntity.ok(new LoginResponse("funcionario", funcionario)); // Retorna tipo 'funcionario' e dados do funcionário
        }

        // Caso não encontre nenhum usuário
        return ResponseEntity.status(401).body("Nome de usuário ou senha incorretos.");
    }
}
