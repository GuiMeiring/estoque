package br.org.catolicasc.estoque.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.org.catolicasc.estoque.model.Produto;
import br.org.catolicasc.estoque.repository.ProdutoRepository;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public String listar(Model model) {

        model.addAttribute("produtos", produtoRepository.findAll());

        if (!model.containsAttribute("produto")) {
            model.addAttribute(new Produto());
        }

        return "produtos";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Produto produto, RedirectAttributes ra) {
        produtoRepository.save(produto);
        ra.addFlashAttribute("mensagemSucesso", "Produto salvo com sucesso!");

        return "redirect:/produtos";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable("id") Long id, RedirectAttributes ra) {
        produtoRepository.deleteById(id);
        ra.addFlashAttribute("mensagemSucesso", "Produto deletado com sucesso!");

        return "redirect:/produtos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Optional<Produto> resultado = produtoRepository.findById(id);
        if (resultado.isPresent()) {
            model.addAttribute("produto", resultado.get());
        }
        model.addAttribute("produtos", produtoRepository.findAll());

        return "/produtos";
    }
}
