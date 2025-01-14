package com.barbearia.agendaCorte.data;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity 
@Table(name = "agendamento")

public class AgendamentoEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id_agendamento;
    private Date data_marcada;
    private Integer id_cliente;
    private Integer id_barbeiro;
    private Integer id_tipoCorte;
    private String hora;
}
