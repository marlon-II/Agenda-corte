/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atv1_pi;

import java.util.ArrayList;

/**
 *
 * @author marlon
 */
public class agendamento {
    private int ID;
    private int IDCliente;
    private String Data;
    private int Corte;
    private String Hora;
    private int IDFuncionario;
    

    public agendamento (){
        
    }

    public agendamento(int ID, int IDCliente, String Data, int Corte, String Hora, int IDFuncionario) {
        this.ID = ID;
        this.IDCliente = IDCliente;
        this.Data = Data;
        this.Corte = Corte;
        this.Hora = Hora;
        this.IDFuncionario = IDFuncionario;
    }

    public int getID() {
        return ID;
    }

    
    
    public String getHora() {
        return Hora;
    }

    public int getIDFuncionario() {
        return IDFuncionario;
    }
    
    

    public int getIDCliente() {
        return IDCliente;
    }

    public String getData() {
        return Data;
    }

    public int getCorte() {
        return Corte;
    }

    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public void setCorte(int Corte) {
        this.Corte = Corte;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public void setIDFuncionario(int IDFuncionario) {
        this.IDFuncionario = IDFuncionario;
    }
    
    
    
    
//    ArrayList ListaAgendamento  = new ArrayList();
//    
//    public void SalvarLista (agendamento ag){
//      
//        
//        ListaAgendamento.add(ag);
//    }
//    
//    public void listar (){
//        
//
//    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
