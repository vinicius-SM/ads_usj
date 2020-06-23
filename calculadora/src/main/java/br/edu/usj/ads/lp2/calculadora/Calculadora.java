package br.edu.usj.ads.lp2.calculadora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Calculadora {

    @Autowired
    OperaRepo operaRepo;

    @PostMapping(value = "/calcula")
    public ModelAndView postCalcula(@RequestParam String N1, @RequestParam String N2) {

        Double resultado = 0.0;
        Double n1 = Double.parseDouble(N1);
        Double n2 = Double.parseDouble(N2);
        resultado = n1 + n2;
        String operacaoString = N1 + "+" + N2 + "=" + resultado;

        Operacao operacao = new Operacao();
        operacao.setOperacao(operacaoString);

        operaRepo.save(operacao);

        String texto = "o resultado é:" + resultado;
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("mensagem", texto);
        modelAndView.addObject("historico", operaRepo.findAll());
        return modelAndView;
    }

    @GetMapping(value = "/deleta/{id}")
    public ModelAndView getDeleta(@PathVariable Long id) {
        operaRepo.deleteById(id);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("historico", operaRepo.findAll());
        return modelAndView;
    }

    @GetMapping(value= "/mostrar/{id}")
    public ModelAndView getMostrar(@PathVariable Long id) {

        String texto = "";
        if (operaRepo.findById(id).isPresent()) {
            Operacao operacao = operaRepo.findById(id).get();
            texto = operacao.getId() + ": " + operacao.getOperacao();
        }

        ModelAndView modelAndView = new ModelAndView("mostra-opera");
        modelAndView.addObject("historico", texto);
        return modelAndView;
    }

}