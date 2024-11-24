package com.example.sigeapi.controller;

import com.example.sigeapi.model.UsuarioWeb;
import com.example.sigeapi.repository.UsuarioWebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cadastro")
public class CadUsuarioWebController {

    @Autowired
    private UsuarioWebRepository usuarioRepository;

    @GetMapping
    public String exibirFormulario() {
        return "cadastro";
    }

    @PostMapping("/cadastrar-usuario")
    public String cadastrarUsuario(@RequestParam String email, @RequestParam String senha, RedirectAttributes redirectAttributes) {
        try {
            UsuarioWeb usuario = new UsuarioWeb(email, senha);
            usuarioRepository.save(usuario);

            redirectAttributes.addFlashAttribute("message", "Usuário cadastrado com sucesso!");

            return "redirect:/SIGE";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erro ao cadastrar usuário.");
            return "redirect:/cadastro";
        }
    }
}
