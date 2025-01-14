/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.barbearia.agendaCorte.data;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Shirley
 */
@Data
@Entity 
@Table(name = "usuario")

public class UsuarioEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String login;
    private String senha;
    private String tipo;
}
