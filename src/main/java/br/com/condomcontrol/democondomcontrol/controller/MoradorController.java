package br.com.condomcontrol.democondomcontrol.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.condomcontrol.democondomcontrol.model.Morador;
import br.com.condomcontrol.democondomcontrol.service.CondominioService;
import br.com.condomcontrol.democondomcontrol.service.MoradorService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/moradores")
public class MoradorController {

    private final Logger logger = LoggerFactory.getLogger(MoradorController.class);

    @Autowired
    private MoradorService moradorService;

    @Autowired
    private CondominioService condominioService;

    @GetMapping
    public String index(Model model) {
        logger.info("Listando todos os moradores");
        model.addAttribute("moradores", moradorService.findAll());
        return "moradores/index";
    }

    @GetMapping("/new")
    public String newMorador(Model model) {
        logger.info("Exibindo formulário de novo morador");
        model.addAttribute("morador", new Morador());
        model.addAttribute("condominios", condominioService.findAll());
        return "moradores/new";
    }

    @PostMapping
    public String create(@Valid Morador morador, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            logger.warn("Erro de validação ao criar morador: {}", result.getAllErrors());
            model.addAttribute("condominios", condominioService.findAll());
            return "moradores/new";
        }
        
        moradorService.save(morador);
        logger.info("Morador criado com sucesso: {}", morador.getNome());
        redirectAttributes.addFlashAttribute("message", "Morador cadastrado com sucesso!");
        return "redirect:/moradores";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        logger.info("Editando morador com ID: {}", id);
        Morador morador = moradorService.findById(id);
        if (morador == null) {
            logger.error("Morador não encontrado com ID: {}", id);
            return "redirect:/moradores";
        }
        model.addAttribute("morador", morador);
        model.addAttribute("condominios", condominioService.findAll());
        return "moradores/edit";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @Valid Morador morador, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            logger.warn("Erro de validação ao atualizar morador: {}", result.getAllErrors());
            model.addAttribute("condominios", condominioService.findAll());
            return "moradores/edit";
        }

        morador.setId(id);
        moradorService.save(morador);
        logger.info("Morador atualizado com sucesso: {}", morador.getNome());
        redirectAttributes.addFlashAttribute("message", "Morador atualizado com sucesso!");
        return "redirect:/moradores";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        moradorService.deleteById(id);
        return "redirect:/moradores";
    }
}
