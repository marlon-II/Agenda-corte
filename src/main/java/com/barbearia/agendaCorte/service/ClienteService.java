package com.barbearia.agendaCorte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbearia.agendaCorte.data.ClienteEntity;
import com.barbearia.agendaCorte.data.ClienteRepository;
import com.barbearia.agendaCorte.exeption.ResourceNotFoundException;

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
    
}
