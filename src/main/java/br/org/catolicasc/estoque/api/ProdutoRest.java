package br.org.catolicasc.estoque.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.catolicasc.estoque.model.Produto;
import br.org.catolicasc.estoque.repository.ProdutoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/service/produtos")
public class ProdutoRest {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> getProdutos(Model model) {
        List<Produto> produtos = (List<Produto>) produtoRepository.findAll();
        if (produtos == null || produtos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(produtos);
    }

    @PostMapping
    public ResponseEntity<Produto> postProduto(@RequestBody Produto produto) {
        Produto novoProduto = produtoRepository.save(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    @GetMapping("/{id}")
    public Produto getProdutoById(@PathVariable Long id) {
        Optional<Produto> resultado = produtoRepository.findById(id);
        if (resultado.isEmpty()) {
            throw new RuntimeException("Produto não encontrado com id: " + id);
        }

        return resultado.get();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);

        if (optionalProduto.isPresent()) {
            produtoAtualizado.setId(id);
            Produto updatedProduto = produtoRepository.save(produtoAtualizado);

            return ResponseEntity.ok(updatedProduto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);

        if (optionalProduto.isPresent()) {
            produtoRepository.delete(optionalProduto.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
