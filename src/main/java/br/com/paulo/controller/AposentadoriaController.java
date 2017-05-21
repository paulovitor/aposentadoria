package br.com.paulo.controller;

import br.com.paulo.model.Contribuicao;
import br.com.paulo.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AposentadoriaController {

    @GetMapping("/")
    public String index(Model model) {
        Contribuicao contribuicao = new Contribuicao();
        contribuicao.setUsuario(new Usuario());
        model.addAttribute("contribuicao", contribuicao);
        return "index";
    }

    @PostMapping("/simular")
    public String simular(@ModelAttribute Contribuicao contribuicao, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "index";

        contribuicao.simula();
        return "index";
    }
}
