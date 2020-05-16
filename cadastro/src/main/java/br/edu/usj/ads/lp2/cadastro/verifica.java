package br.edu.usj.ads.lp2.cadastro;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class verifica {
    List<String> listaOp = new ArrayList<>();

    @PostMapping(value = "/verifica")
    public ModelAndView postCalcula(@RequestParam final String nome, @RequestParam final String idade,
            @RequestParam final String email, @RequestParam final String senha) {
        final ModelAndView modelAndView = new ModelAndView("index");
        String resultado;
        resultado = "nome: " + nome + " idade: " + idade + " email: " + email + " senha: " + senha;
        listaOp.add(resultado);
        final String texto = resultado;
        modelAndView.addObject("mensagem", texto);
        modelAndView.addObject("historico", listaOp);
        return modelAndView;
    }
}