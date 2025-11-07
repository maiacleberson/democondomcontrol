package br.com.condomcontrol.democondomcontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.condomcontrol.democondomcontrol.model.Condominio;
import br.com.condomcontrol.democondomcontrol.service.CondominioService;

@Controller
@RequestMapping("/condominios")
public class CondominioController {

    @Autowired
    private CondominioService condominioService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("condominios", condominioService.findAll());
        return "condominios/index";
    }

    @GetMapping("/new")
    public String newCondominio(Model model) {
        model.addAttribute("condominio", new Condominio());
        return "condominios/new";
    }

    @PostMapping
    public String create(Condominio condominio) {
        condominioService.save(condominio);
        return "redirect:/condominios";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("condominio", condominioService.findById(id));
        return "condominios/edit";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, Condominio condominio) {
        condominio.setId(id);
        condominioService.save(condominio);
        return "redirect:/condominios";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        condominioService.deleteById(id);
        return "redirect:/condominios";
    }
}
