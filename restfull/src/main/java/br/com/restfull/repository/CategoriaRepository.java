package br.com.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.restfull.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
