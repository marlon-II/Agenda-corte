package com.barbearia.agendaCorte.data;

public class LoginResponse {

    private String tipo;
    private Object usuario;

    // Construtor
    public LoginResponse(String tipo, Object usuario) {
        this.tipo = tipo;
        this.usuario = usuario;
    }

    // Getters e Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Object getUsuario() {
        return usuario;
    }

    public void setUsuario(Object usuario) {
        this.usuario = usuario;
    }
}
