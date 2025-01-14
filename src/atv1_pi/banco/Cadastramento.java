/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atv1_pi.banco;

import atv1_pi.agendamento;
import atv1_pi.cliente;
import atv1_pi.cortes;
import atv1_pi.funcionarios;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author marlon
 */
public class Cadastramento {
     public static boolean CadastrarC(cliente c)throws SQLException{
        try{
        Conexao conn = new Conexao();
        
        conn.conectar();
        
        String sql = "INSERT INTO cliente (nome,cpf , email, telefone, senha) VALUES (?,?,?,?,?)";
        
        PreparedStatement query = conn.getConn().prepareStatement(sql);
        
        query.setString(1, c.getNome());
        query.setString(2, c.getCpf());
        query.setString(3, c.getEmail());
        query.setString(4, c.getTelefone());
        query.setString(5, c.getSenha());
        
        query.execute();
        
        conn.desconectar();
        
        JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso!");
        
        return true;
        
    }
        catch(SQLException se) {
            System.out.println("Erro ao cadastrar registro no banco de dados" + se);
           
            return false;
        }
}
     
       public static boolean Agendar(agendamento ag)throws SQLException, ParseException{
        try{
        Conexao conn = new Conexao();
        Datas d = new Datas();
        
        conn.conectar();
        
        String sql = "INSERT INTO agendamento (id_cliente,data_marcada, hora, id_tipoCorte, id_barbeiro) VALUES (?,?,?,?,?)";
        
        PreparedStatement query = conn.getConn().prepareStatement(sql);
       
        
        query.setInt(1, ag.getIDCliente());
        query.setDate(2, d.ConverterSQL(ag.getData()));               
        query.setString(3, ag.getHora());
        query.setInt(4, ag.getCorte());
        query.setInt(5, ag.getIDFuncionario());
        
        query.execute();
        
        conn.desconectar();
        
        JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso!");
        
        return true;
        
    }
        catch(SQLException se) {
            System.out.println("Erro ao cadastrar registro no banco de dados" + se);
           
            return false;
        }
}
       
        public static boolean CadastrarCorte(cortes co)throws SQLException{
        try{
        Conexao conn = new Conexao();
        
        conn.conectar();
        
        String sql = "INSERT INTO tipo_corte (nome, valor) VALUES (?,?)";
        
        PreparedStatement query = conn.getConn().prepareStatement(sql);
        
        query.setString(1, co.getNomecorte());
        query.setInt(2,co.getValor() );
      
        query.execute();
        
        conn.desconectar();
        
        JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso!");
        
        return true;
        
    }
        catch(SQLException se) {
            System.out.println("Erro ao cadastrar registro no banco de dados" + se);
           
            return false;
        }
        }
        
  public static boolean CadastrarFuncionario(funcionarios f)throws SQLException{
        try{
        Conexao conn = new Conexao();
        
        conn.conectar();
        
        String sql = "INSERT INTO barbeiro (nome, area) VALUES (?,?)";
        
        PreparedStatement query = conn.getConn().prepareStatement(sql);
        
        query.setString(1, f.getNome());
        query.setString(2, f.getArea() );
      
        query.execute();
        
        conn.desconectar();
        
        JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso!");
        
        return true;
        
    }
        catch(SQLException se) {
            System.out.println("Erro ao cadastrar registro no banco de dados" + se);
           
            return false;
        }
        }  
}
