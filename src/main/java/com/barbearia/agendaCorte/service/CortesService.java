package com.barbearia.agendaCorte.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbearia.agendaCorte.data.CortesEntity;
import com.barbearia.agendaCorte.data.CortesRepository;
import com.barbearia.agendaCorte.exeption.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CortesService {

    @Autowired
    private CortesRepository cortesRepository;

    public CortesEntity criarCortes(CortesEntity cortes) {
        
        return cortesRepository.save(cortes);
    }

    public CortesEntity getCortePorId(Integer cortesId) {
        return cortesRepository.findById(cortesId)
            .orElseThrow(() -> new ResourceNotFoundException("Corte não encontrado com id " + cortesId));
    }

    public List<CortesEntity> listarTodosCortes() {
        return cortesRepository.findAll();
    }


    public CortesEntity findById(Integer tipoCorteId) {
        return cortesRepository.findById(tipoCorteId)
                .orElseThrow(() -> new EntityNotFoundException("Tipo de corte não encontrado com ID " + tipoCorteId));
    }

    public Integer buscarIdPorCorte(String corte) {
        CortesEntity tipoCorte = cortesRepository.findByNome(corte);  

        if (tipoCorte != null) {
            return tipoCorte.getIdTipoCorte();  
        }
        return null;  
    }
}