package br.edu.usj.ads.lp2.calculadora;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculadora {

    @PostMapping(value = "/calcula")
    public ModelAndView postCalcula(@RequestParam String N1, @RequestParam String symbol, @RequestParam String N2) {

        ModelAndView modelAndView = new ModelAndView("index");
        System.out.println("passei por aqui");
        System.out.println(N1);
        System.out.println(symbol);
        System.out.println(N2);
        Double resultado = 0.0;
        if (symbol.equals("+")) {
            resultado = Double.parseDouble(N1) + Double.parseDouble(N2);
        } else if (symbol.equals("-")) {
            resultado = Double.parseDouble(N1) - Double.parseDouble(N2);
        } else if (symbol.equals("/")) {
            resultado = Double.parseDouble(N1) / Double.parseDouble(N2);
        } else if (symbol.equals("*")) {
            resultado = Double.parseDouble(N1) * Double.parseDouble(N2);
        }
        String texto = "o resultado é:" + resultado;
        modelAndView.addObject("mensagem", texto);

        return modelAndView;
    }

}
