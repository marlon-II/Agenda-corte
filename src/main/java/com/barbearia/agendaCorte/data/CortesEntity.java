package com.barbearia.agendaCorte.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tipo_corte")

public class CortesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_tipoCorte;
    private String nome;
    private Double valor;
}
