package com.barbearia.agendaCorte.data;

public class AgendamentoRequest {

    private Integer id_cliente;
    private String data_marcada;
    private String hora;
    private Integer idTipoCorte; 
    private Integer id_barbeiro;

    private String nome_cliente;
    private String nome_barbeiro;
    private String nome_servico;

    
    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getData_marcada() {
        return data_marcada;
    }

    public void setData_marcada(String data_marcada) {
        this.data_marcada = data_marcada;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getIdTipoCorte() {
        return idTipoCorte;
    }

    public void setIdTipoCorte(Integer idTipoCorte) {
        this.idTipoCorte = idTipoCorte;
    }

    public Integer getId_barbeiro() {
        return id_barbeiro;
    }

    public void setId_barbeiro(Integer id_barbeiro) {
        this.id_barbeiro = id_barbeiro;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getNome_barbeiro() {
        return nome_barbeiro;
    }

    public void setNome_barbeiro(String nome_barbeiro) {
        this.nome_barbeiro = nome_barbeiro;
    }

    public String getNome_servico() {
        return nome_servico;
    }

    public void setNome_servico(String nome_servico) {
        this.nome_servico = nome_servico;
    }

    
}



