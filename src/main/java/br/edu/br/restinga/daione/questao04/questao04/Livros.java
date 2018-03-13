/*
 /*
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.br.restinga.daione.questao04.questao04;

import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 10070269
 */
@RestController
public class Livros {

    Livro livro = new Livro("","",0);    
    ArrayList<Livro> livros = new ArrayList<Livro>();    
    int i = 0;
    
    

    public Livros() {
        livros.add(1, new Livro("lUIZA", "SONHANDO ACORDADO", 1.0));
        livros.add(2, new Livro("PEDRO", "SONHANDO DORMINDO", 2.8));
        livros.add(3, new Livro("MARIA", "SONHANDO COM AS FERIAS", 3.9));
        livros.add(4, new Livro("PAULO", "ACORDANDO", 4.6));
        livros.add(5, new Livro("RAFAEL", "HORA DO HORROR", 5.1));
        livros.add(6, new Livro("DUDU", "TITANIC", 1.6));
        
        i = livros.size(); 
        
        
    }
    
    @RequestMapping(path = "/lista/adicionar/{item}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)    
    public Livro adicionar(@PathVariable String titulo, @PathVariable String autor, @PathVariable double valor) {
        livro.setId(i++);
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setPreco(valor);
        livros.add(livro);        
        
        return livro;
        
    }
    
    @RequestMapping("/lista")
    public ArrayList<Livro> listar() {
        return livros;
    }
    
}
