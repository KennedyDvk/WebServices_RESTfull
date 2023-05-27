package br.com.restfull.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.restfull.domain.Carrinho;
import br.com.restfull.repository.CarrinhoRepository;

@RestController
@RequestMapping("carrinho")
public class CarrinhoController {
	
	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	@GetMapping
	public List<Carrinho> listar() {
		return carrinhoRepository.findAll();
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public Carrinho cadastrar(@RequestBody Carrinho carrinho) {
		return carrinhoRepository.save(carrinho);
	}
	
	@DeleteMapping("{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable int codigo) {
		carrinhoRepository.deleteById(codigo);
	}

}
