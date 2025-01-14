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

    CortesRepository cortesRepository;

    public CortesEntity criarCortes(CortesEntity cortes){
       cortes.setId_tipoCorte(null);
        CortesEntity corteSalvo = cortesRepository.save(cortes);
        return corteSalvo;
    }

    public CortesEntity getcortesId(Integer cortesId) {
        return cortesRepository.findById(cortesId)
            .orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado com id " + cortesId));
    }

    public List<CortesEntity> listarTdcortes(){
        return cortesRepository.findAll();
    }
}
