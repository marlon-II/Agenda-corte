package com.barbearia.agendaCorte.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaginaController {

    @RequestMapping("/")
    public String Inicio(){
        return "Inicio";
    }

    @RequestMapping("/Menu")
    public String Menu(){
        return "Menu";
    }

    @RequestMapping("/adicionarCliente")
    public String cadastramentoCliente(){
        return "cadastramentoCliente";
    }

    @RequestMapping("/listarCliente")
    public String ListaCliente(){
        return "ListaCliente";
    }

    @RequestMapping("/adicionarFuncionario")
    public String CadastroFuncionario(){
        return "CadastroFuncionario";
    }

    @RequestMapping("/listaFuncionario")
    public String ListaFuncionario(){
        return "ListaFuncionario";
    }

    @RequestMapping("/adicionarServico")
    public String CadastramentoCorte(){
        return "CadastramentoCorte";
    }

    @RequestMapping("/listaServico")
    public String ListaCorte(){
        return "ListaCorte";
    }
}
