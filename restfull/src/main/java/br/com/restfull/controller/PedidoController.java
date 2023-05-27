package br.com.restfull.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.restfull.domain.Pedido;
import br.com.restfull.repository.PedidoRepository;

@RestController 
@RequestMapping("pedido")
public class PedidoController {
	@Autowired
	private PedidoRepository pedidoRepository;
	@GetMapping
	public List<Pedido> listar() {
		return pedidoRepository.findAll();
	}
	@GetMapping("{codigo}")
	@ResponseStatus(HttpStatus.OK)
	public Pedido buscar(@PathVariable int codigo) {
		return pedidoRepository.findById(codigo).get();
	}
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public Pedido cadastrar(@RequestBody Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Pedido atualizar(@RequestBody Pedido pedido, @PathVariable int id) {
		pedido.setCodigo(id);
		return pedidoRepository.save(pedido);
	}
	@DeleteMapping("{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable int codigo) {
		pedidoRepository.deleteById(codigo);
	}
	@GetMapping("pesquisa")
	public Pedido buscarPorId(@RequestParam int codigo) {
	    Optional<Pedido> pedido = pedidoRepository.findById(codigo);
	    if (pedido.isPresent()) {
	        return pedido.get();
	    } else {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado");
	    }
	}

}
