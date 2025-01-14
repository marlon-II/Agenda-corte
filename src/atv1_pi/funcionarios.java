/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atv1_pi;

/**
 *
 * @author marlon
 */
public class funcionarios {
    private int ID;
    private String nome;
    private String area;
    
    public funcionarios() {
    
}

    public funcionarios(int ID, String nome, String area) {
        this.nome = nome;
        this.area = area;
    }

    public String getNome() {
        return nome;
    }

    public int getID() {
        return ID;
    }

    public String getArea() {
        return area;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
 
    
}

