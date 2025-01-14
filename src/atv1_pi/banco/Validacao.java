/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atv1_pi.banco;

import atv1_pi.Usuario;
import atv1_pi.cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author marlon
 */
public class Validacao {
    
    public Usuario encher(Usuario us)throws SQLException{
        Conexao conn = new Conexao();
        conn.conectar();
        cliente c = new cliente();
        
        String sql = "INSERT INTO Usuario (login,senha ,) VALUES (?,?)";
        
        PreparedStatement query = conn.getConn().prepareStatement(sql);
        
        query.setString(1, c.getNome());
        query.setString(2, c.getSenha());
        
       
        
        query.execute();
        
        conn.desconectar();
        
        
        
        return us;
    }
    
    public static Usuario validarUsuarioSeguro(Usuario usuario) {
                              // Criando consulta parametrizada
                              String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
                              Usuario usuarioEncontrado = null;
                      
                              try {
                                  Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/barbearia_db_marlon", "root", "root");
                                  PreparedStatement statement = conexao.prepareStatement(sql);
                                  
                                  // Atribuindo os valores na consulta
                                  cliente c = new cliente();
                                  usuario.setNome(c.getNome());
                                  usuario.setSenha(c.getSenha());
                                  statement.setString(1, usuario.getNome());
                                  statement.setString(2, usuario.getSenha());
                                  ResultSet rs = statement.executeQuery();
                      
                                  while (rs.next()) {
                                      usuarioEncontrado = new Usuario();
                                      usuarioEncontrado.setId(rs.getInt("id"));
                                      usuarioEncontrado.setNome(rs.getString("nome"));
                                      usuarioEncontrado.setSenha(rs.getString("senha"));
                                     
                                  }
                              } catch (SQLException ex) {
                                  System.out.println("Sintaxe de comando invalida");
                              }
                              
                              return usuarioEncontrado;
                          }
}
