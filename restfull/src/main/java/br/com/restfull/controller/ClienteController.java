package br.com.restfull.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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

import br.com.restfull.domain.Cliente;
import br.com.restfull.repository.ClienteRepository;

@RestController
@RequestMapping("cliente")
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	@GetMapping("{codigo}")
	@ResponseStatus(HttpStatus.OK)
	public Cliente buscar(@PathVariable int codigo) {
		return clienteRepository.findById(codigo).get();
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public Cliente cadastrar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@PutMapping("{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable int codigo, @RequestBody Cliente cliente) {
		if (!clienteRepository.existsById(codigo)) {
			throw new ResourceNotFoundException("Cliente não encontrado com o código " + codigo);
		}
		cliente.setCodigo(codigo);
		clienteRepository.save(cliente);
	}

	@DeleteMapping("{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable int codigo) {
		clienteRepository.deleteById(codigo);
	}

	@GetMapping("pesquisa")
	public Cliente buscarPorId(@RequestParam int codigo) {
	    Optional<Cliente> cliente = clienteRepository.findById(codigo);
	    if (cliente.isPresent()) {
	        return cliente.get();
	    } else {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
	    }
	}
}
