/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atv1_pi.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author marlon
 */
public class Conexao {
    private Connection conn;
    public Connection getConn() {
        return conn;
    }
    
     public void conectar(){
       conn = null;
       try{
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/barbearia_db_marlon","root","root");
             System.out.println("Conectado");         
       }
       catch(SQLException sqle){
           JOptionPane.showMessageDialog(null,"erro ao conectar "+ sqle.getMessage());
       }
       
   
    }
   
   public void desconectar(){
      try{
          conn.close();
          System.out.println("fechado");
          
      }
      catch(SQLException  | NullPointerException ex){
          System.out.println(ex);
      }
   }
   
}
