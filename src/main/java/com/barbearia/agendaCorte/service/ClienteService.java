package com.barbearia.agendaCorte.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.barbearia.agendaCorte.data.ClienteEntity;
import com.barbearia.agendaCorte.data.ClienteRepository;
import com.barbearia.agendaCorte.exeption.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service

public class ClienteService {
    @Autowired

    ClienteRepository clienteRepository;

    public ClienteEntity criarCliente(ClienteEntity cliente){
       cliente.setId_cliente(null);
        ClienteEntity clienteSalvo = clienteRepository.save(cliente);
        return clienteSalvo;
    }

    public ClienteEntity getclienteId(Integer clienteId) {
        return clienteRepository.findById(clienteId)
            .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id " + clienteId));
    }


    public List<ClienteEntity> listarTdClientes(){
        return clienteRepository.findAll();
    }

    public ClienteEntity findById(Integer clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID " + clienteId));
    }

    public Integer buscarIdPorNome(String nomeC) {
        ClienteEntity cliente = clienteRepository.findByNome(nomeC);  

        if (cliente != null) {
            return cliente.getId_cliente();  
        }
        return null;  
    }
    
    public ClienteEntity autenticarCliente(String nome, String senha) {
        ClienteEntity cliente = clienteRepository.findByNome(nome);
        if (cliente != null && cliente.getSenha().equals(senha)) {
            return cliente;
        }
        return null;
    }
}