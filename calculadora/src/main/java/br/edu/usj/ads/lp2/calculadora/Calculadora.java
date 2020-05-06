package br.edu.usj.ads.lp2.calculadora;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculadora {

    List<String> listaOp = new ArrayList<>();

    @PostMapping(value = "/calcula")
    public ModelAndView postCalcula(@RequestParam String N1, @RequestParam String symbol, @RequestParam String N2) {

        ModelAndView modelAndView = new ModelAndView("index");
        Double resultado = 0.0;
        String operacao;
        if (symbol.equals("+")) {
            resultado = Double.parseDouble(N1) + Double.parseDouble(N2);
            operacao = N1 + "+" + N2 + "=" + resultado;
            listaOp.add(operacao);
        } else if (symbol.equals("-")) {
            resultado = Double.parseDouble(N1) - Double.parseDouble(N2);
             operacao = N1 + "-" + N2 + "=" + resultado;
             listaOp.add(operacao);
        } else if (symbol.equals("/")) {
            resultado = Double.parseDouble(N1) / Double.parseDouble(N2);
             operacao = N1 + "/" + N2 + "=" + resultado;
             listaOp.add(operacao);
        } else if (symbol.equals("*")) {
            resultado = Double.parseDouble(N1) * Double.parseDouble(N2);
             operacao = N1 + "*" + N2 + "=" + resultado;
             listaOp.add(operacao);
        }

        
        
        String texto = "o resultado é:" + resultado;
        modelAndView.addObject("mensagem", texto);
        modelAndView.addObject("historico", listaOp);
        return modelAndView;
    }

}
