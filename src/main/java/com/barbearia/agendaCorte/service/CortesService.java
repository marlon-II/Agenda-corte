package com.barbearia.agendaCorte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbearia.agendaCorte.data.CortesEntity;
import com.barbearia.agendaCorte.data.CortesRepository;
import com.barbearia.agendaCorte.exeption.ResourceNotFoundException;

@Service
public class CortesService {

    @Autowired
    private CortesRepository cortesRepository;

    public CortesEntity criarCortes(CortesEntity cortes) {
        // Não precisa setar o id como null, o Hibernate cuida disso
        return cortesRepository.save(cortes);
    }

    public CortesEntity getCortePorId(Integer cortesId) {
        return cortesRepository.findById(cortesId)
            .orElseThrow(() -> new ResourceNotFoundException("Corte não encontrado com id " + cortesId));
    }

    public List<CortesEntity> listarTodosCortes() {
        return cortesRepository.findAll();
    }
}
