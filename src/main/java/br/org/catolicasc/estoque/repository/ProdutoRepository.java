package br.org.catolicasc.estoque.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.org.catolicasc.estoque.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}
