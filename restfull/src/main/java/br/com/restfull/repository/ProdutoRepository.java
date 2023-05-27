package br.com.restfull.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.restfull.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	List<Produto> findByNome(String prod);
	List<Produto> findByNovo(boolean novo);
	List<Produto> findByNomeAndNovo(String prod, boolean novo);
	List<Produto> findByPrecoGreaterThan(double preco);
}
