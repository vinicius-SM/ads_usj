package br.edu.usj.ads.lp2.crudcontatos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContatoControle {

    @Autowired
    ContatoRepo contatoRepository;

    @GetMapping(value = "/")
    public ModelAndView getTodos() {
        List<Contato> lista = contatoRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }

    @GetMapping(value = "/mostrar/{id}")
    public ModelAndView getMostrar(@PathVariable Long id) {
        Contato contato = contatoRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("mostrar");
        modelAndView.addObject("contato", contato);
        return modelAndView;
    }

    @GetMapping(value = "/cadastrar")
    public ModelAndView getCadastrar() {
        Contato contato = new Contato();
        ModelAndView modelAndView = new ModelAndView("cadastrar");
        modelAndView.addObject("contato", contato);
        return modelAndView;
    }

    @PostMapping(value = "/cadastrar")
    public ModelAndView postCadastrar(Contato contato) {
        // grava o formulario no banco
        contatoRepository.save(contato);
        ModelAndView modelAndView = new ModelAndView("mostrar");
        modelAndView.addObject("contato", contato);
        return modelAndView;
    }
    

    @GetMapping(value = "/deletar/{id}")
    public ModelAndView getDeletar(@PathVariable final Long id) {
        contatoRepository.deleteById(id);
        List<Contato> lista = contatoRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }

    @GetMapping(value = "/editar/{id}")
    public ModelAndView getEditar(@PathVariable final Long id) {
        Contato contato = contatoRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("cadastrar");
        modelAndView.addObject("contato", contato);
        return modelAndView;
    }

}