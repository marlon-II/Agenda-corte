/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atv1_pi;

import atv1_pi.Telas.TelaCDcorte;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author marlon
 */
public class cortes {
  private int ID;
  private String Nomecorte;
  private int Valor;
  
  public cortes(){
      
  }

  
public cortes(int ID, String Nomecorte, int Valor) {
    this.ID = ID;
    this.Nomecorte = Nomecorte;
    this.Valor = Valor;
    }

    public void setNomecorte(String Nomecorte) {
        this.Nomecorte = Nomecorte;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }

public String getNomecorte() {
        return Nomecorte;
    }

    public int getValor() {
        return Valor;
    }
    
public int getID() {
        return ID;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
//        ArrayList corte = new ArrayList();
//        ArrayList preco = new ArrayList();
//
//        public void setCorte(ArrayList corte) {
//            this.corte = corte;
//        }
//
//        public void setPreco(ArrayList preco) {
//            this.preco = preco;
//        }
//
//           public ArrayList getCorte() {
//            return corte;
//        }
//
//        public ArrayList getPreco() {
//            return preco;
//        }
//    
//    
//        public void cadastrarCorte(String nome, String valor){
//            
//           
//            
//                
//                String nomeCorte = nome;
//                String valorCorte = valor;
//                
//                corte.add(nomeCorte);
//                preco.add(valorCorte);
//                
//                
//            }
//           
//        
//        public void tabelaCortes (){
//             
//
// 
//    }

    

    

   
}

