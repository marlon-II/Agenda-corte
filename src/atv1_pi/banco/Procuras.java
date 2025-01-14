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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author marlon
 */
public class Procuras {
    public cliente ProcurarCliente(cliente c) throws SQLException{
        Conexao conn = new Conexao();
        
        conn.conectar();
        
        String sql ="SELECT * FROM cliente WHERE nome = ?";
        
         PreparedStatement stmt = conn.getConn().prepareStatement(sql);
            stmt.setString(1, c.getNome());
            ResultSet rs = stmt.executeQuery();
            
            rs.next();
        
            c.setNome(rs.getString("nome"));
            c.setID(rs.getInt("id_cliente"));
            c.setCpf(rs.getString("CPF"));
            c.setEmail(rs.getString("email"));
            c.setTelefone(rs.getString("telefone"));
            
            
        return c;      
    }
    
    public List<cliente> ProcurarTdCliente() throws SQLException{
        List<cliente> clientes = new ArrayList<>();
        Conexao conn = new Conexao();
        
        conn.conectar();
        
        String sql ="SELECT * FROM cliente";
        
         PreparedStatement stmt = conn.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
           while( rs.next()){
               
            cliente c = new cliente();
            
            c.setNome(rs.getString("nome"));
            c.setID(rs.getInt("id_cliente"));
            c.setCpf(rs.getString("CPF"));
            c.setEmail(rs.getString("email"));
            c.setTelefone(rs.getString("telefone"));
            
            clientes.add(c);
           }
        return clientes;      
    }
    
    public cortes ProcurarCorte(cortes co) throws SQLException{
        Conexao conn = new Conexao();
        
        conn.conectar();
        
        String sql ="SELECT * FROM tipo_corte WHERE nome = ?";
        
         PreparedStatement stmt = conn.getConn().prepareStatement(sql);
            stmt.setString(1, co.getNomecorte());
            ResultSet rs = stmt.executeQuery();
            
            rs.next();
            
            co.setID(rs.getInt("id_tipoCorte"));
            co.setNomecorte(rs.getString("nome"));
            co.setValor(rs.getInt("valor"));
            
        return co;
            
    }
    
    public List<cortes> ProcurarTdCorte() throws SQLException{
        List<cortes> corte = new ArrayList<>();
        
        Conexao conn = new Conexao();
        
        conn.conectar();
        
        String sql ="SELECT * FROM tipo_corte";
        
         PreparedStatement stmt = conn.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
            cortes co =new cortes();
            
            co.setID(rs.getInt("id_tipoCorte"));
            co.setNomecorte(rs.getString("Nomecorte"));
            co.setValor(rs.getInt("valor"));
            
            corte.add(co);
            }
        return corte;
            
    }
    
    public funcionarios ProcurarFuncionario(funcionarios f) throws SQLException{
         Conexao conn = new Conexao();
        
        conn.conectar(); 
        
        String sql ="SELECT * FROM barbeiro WHERE nome = ?";
        
         PreparedStatement stmt = conn.getConn().prepareStatement(sql);
            stmt.setString(1, f.getNome());
            ResultSet rs = stmt.executeQuery();
            
            rs.next();
            
            f.setID(rs.getInt("id_barbeiro"));
            f.setNome(rs.getString("nome"));
            f.setArea(rs.getString("area"));
            
        
            return f;
    }
    
    public List<funcionarios> ProcurarTdFuncionario() throws SQLException{
        List<funcionarios> funcionario = new ArrayList<>();
        
         Conexao conn = new Conexao();
        
        conn.conectar(); 
        
        String sql ="SELECT * FROM barbeiro ";
        
         PreparedStatement stmt = conn.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
            funcionarios f = new funcionarios();
            
            f.setID(rs.getInt("id_barbeiro"));
            f.setNome(rs.getString("nome"));
            f.setArea(rs.getString("area"));
            
            funcionario.add(f);
            }
        
            return funcionario;
    }
    
    public List<agendamento> ProcurarAgendamento() throws SQLException{
        List<agendamento> agendamentos = new ArrayList<>();
        
        Conexao conn = new Conexao();
        
        conn.conectar(); 
        
        String sql ="SELECT * FROM agendamento ";
        
         PreparedStatement stmt = conn.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                agendamento ag = new agendamento();
                
                ag.setID(rs.getInt("id_agendamento"));
                ag.setIDFuncionario(rs.getInt("id_barbeiro"));
                ag.setIDCliente(rs.getInt("id_cliente"));
                ag.setCorte(rs.getInt("id_tipoCorte"));
                ag.setHora(rs.getString("hora"));
                ag.setData(rs.getString("data_marcada"));
                
                agendamentos.add(ag);
            }
            return agendamentos;
}
}
