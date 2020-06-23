package br.com.usj.ads.lp2.drinkstore.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Drinkcontrole {

  @Autowired
  DrinkRepo DrinkRepository;

  @GetMapping(value = "/")
  public ModelAndView getListar() {
    // listar drinks
    List<Drink> lista = DrinkRepository.findAll();
    ModelAndView modelAndView = new ModelAndView("index");
    modelAndView.addObject("lista", lista);
    return modelAndView;
  }

  @GetMapping(value = "/mostar/{id}")
  public ModelAndView getMostrar(@PathVariable Long id) {
    // listar drinks
    Drink drink = DrinkRepository.findById(id).get();
    ModelAndView modelAndView = new ModelAndView("mostra");
    modelAndView.addObject("drink", drink);
    return null;
  }

  @GetMapping(value = "/cadastrar")
  public ModelAndView getCadastrar() {
    ModelAndView modelAndView = new ModelAndView("cadastrar");
    // mostrar formulario
    return modelAndView;
  }

  @PostMapping(value = "/cadastrar")
  public ModelAndView postCadastrar(Drink drink) {
    // grava o formulario no banco
    DrinkRepository.save(drink);
    ModelAndView modelAndView = new ModelAndView("mostra");
    modelAndView.addObject("drink", drink);
    return modelAndView;
  }

  @GetMapping(value = "/deletar/{id}")
  public ModelAndView getDeletar(@PathVariable Long id) {
    // mostrar bebida especifica
    return null;
  }

  @GetMapping(value = "/editar/{id}")
  public ModelAndView getEditar(@PathVariable Long id) {
    // mostrar bebida especifica
    return null;
  }
}