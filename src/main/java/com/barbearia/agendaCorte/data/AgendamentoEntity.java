package com.barbearia.agendaCorte.data;



import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id_agendamento;

    @ManyToOne(fetch = FetchType.LAZY)  // Relacionamento com ClienteEntity
    @JoinColumn(name = "id_cliente", nullable = false)  // Nome da coluna no banco
    private ClienteEntity cliente;

    @ManyToOne(fetch = FetchType.LAZY)  // Relacionamento com FuncionarioEntity (barbeiro)
    @JoinColumn(name = "id_barbeiro", nullable = false)  // Nome da coluna no banco
    private FuncionarioEntity funcionario;

    @ManyToOne(fetch = FetchType.LAZY)  // Relacionamento com CortesEntity (tipo de corte)
    @JoinColumn(name = "idTipoCorte", nullable = false)  // Nome da coluna no banco
    private CortesEntity corte;

    private String data_marcada;
    private String hora;
}
