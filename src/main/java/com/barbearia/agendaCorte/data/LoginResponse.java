package com.barbearia.agendaCorte.data;

public class LoginResponse {

    private String tipo;
    

    
    public LoginResponse(String tipo) {
        this.tipo = tipo;
   
    }

    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
}