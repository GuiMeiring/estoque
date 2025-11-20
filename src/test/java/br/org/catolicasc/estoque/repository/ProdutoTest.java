package br.org.catolicasc.estoque.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.org.catolicasc.estoque.model.Produto;

@SpringBootTest
public class ProdutoTest {

    @Autowired
    private ProdutoRepository produtoRepository;

    @BeforeEach
    public void setup() {
        produtoRepository.deleteAll();
    }

    @AfterEach
    public void teardown() {
        produtoRepository.deleteAll();
    }

    @Test
    public void salvaProdutoTest() {
        Produto p = new Produto("Produto A", "Descrição Produto A", "Categoria Produto A", 10.0, 20.0, 5);
        produtoRepository.save(p);
        assertNotNull(p.getId());
    }

    @Test
    public void buscaTodosProdutosTest() {
        produtoRepository.save(new Produto("Produto B", "Descrição Produto B", "Categoria Produto B", 15.0, 25.0, 3));
        produtoRepository.save(new Produto("Produto C", "Descrição Produto C", "Categoria Produto C", 30.0, 40.0, 7));

        List<Produto> produtos = (List<Produto>) produtoRepository.findAll();
        assertFalse(produtos.isEmpty());
        assertEquals(2, produtos.size());
    }

    @Test
    public void deletaProdutoTest() {
        Produto p = produtoRepository.save(new Produto("Produto Exclusão", "Descrição Produto", "Categoria Produto", 12.0, 22.0, 4));
        Long id = p.getId();
        produtoRepository.deleteById(id);

        Optional<Produto> result = produtoRepository.findById(id);
        assertFalse(result.isPresent());
    }

    @Test
    public void buscaProdutoPorIdTest() {
        Produto p = produtoRepository.save(new Produto("Produto", "Descrição Produto", "Categoria Produto", 50.0, 60.0, 10));
        Long id = p.getId();

        Optional<Produto> result = produtoRepository.findById(id);

        assertTrue(result.isPresent());
        assertEquals("Produto", result.get().getNome());
    }

    @Test
    public void atualizaProdutoTest() {
        Produto p = produtoRepository.save(new Produto("Produto Atualiza", "Descrição Atualiza", "Categoria Atualiza", 18.0, 28.0, 6));
        Long id = p.getId();

        Optional<Produto> result = produtoRepository.findById(id);
        result.get().setNome("Produto Atualizado");
        produtoRepository.save(result.get());

        result = produtoRepository.findById(id);

        assertNotEquals("Produto Atualiza", result.get().getNome());
        assertEquals("Produto Atualizado", result.get().getNome());
    }
}
