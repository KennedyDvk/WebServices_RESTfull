package br.com.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.restfull.domain.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer>{

}
