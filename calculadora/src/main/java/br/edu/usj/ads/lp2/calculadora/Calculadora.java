package br.edu.usj.ads.lp2.calculadora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculadora {

    @Autowired
    OperaRepo operaRepo;

    @PostMapping(value = "/calcula")
    public ModelAndView postCalcula(@RequestParam String N1, @RequestParam String N2) {

        ModelAndView modelAndView = new ModelAndView("index");
        Double resultado = 0.0;
        Double n1 = Double.parseDouble(N1);
        Double n2 = Double.parseDouble(N2);
        resultado = n1 + n2 ;
        String operacaoString = N1 + "+" + N2 + "=" + resultado;

        Operacao operacao = new Operacao();
        operacao.setOperacao(operacaoString);

        operaRepo.save(operacao);

        String texto = "o resultado é:" + resultado;
        modelAndView.addObject("mensagem", texto);
        modelAndView.addObject("historico", operaRepo.findAll());
        return modelAndView;
    }

}