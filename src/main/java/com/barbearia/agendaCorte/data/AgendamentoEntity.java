package com.barbearia.agendaCorte.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity 
@Table(name = "agendamento")

public class AgendamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_agendamento;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "id_barbeiro", nullable = false)
    private FuncionarioEntity funcionario;

    @ManyToOne
    @JoinColumn(name = "id_tipo_corte", nullable = false)
    private CortesEntity servico;

    @Column(name = "data_marcada", nullable = false)
    private String dataMarcada;

    @Column(name = "hora", nullable = false)
    private String hora;

   
}
