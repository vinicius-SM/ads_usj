package br.edu.usj.ads.lp2.cadastro;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class verifica {

    @Autowired
    OperaRepo operaRepo;

    @PostMapping(value = "/verifica")
    public ModelAndView postCalcula(@RequestParam final String nome, @RequestParam final String idade, @RequestParam final String email, @RequestParam final String senha) {
        
        final ModelAndView modelAndView = new ModelAndView("index");
        String resultado;
        resultado = "Nome: " + nome + " Idade: " + idade + " Email: " + email + " Senha: " + senha;
        
        OperaString operaString = new OperaString();
        operaString.setOperacaosString(resultado);

        operaRepo.save(operaString);

        modelAndView.addObject("historico", operaRepo.findAll());
        return modelAndView;
    }
}