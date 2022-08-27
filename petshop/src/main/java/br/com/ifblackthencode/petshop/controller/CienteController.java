package br.com.ifblackthencode.petshop.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifblackthencode.petshop.model.Cliente;
import br.com.ifblackthencode.petshop.services.IClienteService;

@RestController 
public class CienteController {
	
	@Autowired
	private IClienteService service;
	
	@GetMapping("/cliente")
	public ArrayList<Cliente> recuperarTodos(){
		return service.buscarTodos();
	}
	
	@PostMapping("/cliente")
	public ResponseEntity<Cliente> incluirNovo(@RequestBody Cliente novo) {
		Cliente res = service.criarNovo(novo);
		if (res!=null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/cliente")
	public ResponseEntity<Cliente> alterar(@RequestBody Cliente dados) {
		Cliente res = service.atualizarDados(dados);
		if (res!=null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/cliente/{id}")
	public ResponseEntity<Cliente> excluir(@PathVariable Integer id) {
		service.excluirCliente(id);
		return ResponseEntity.ok(null);
	}
	
	@GetMapping("/cliente/{id}")
	public ResponseEntity<Cliente> buscarPeloID(@PathVariable Integer id) {
		Cliente res = service.buscarPeloID(id);
		if (res!=null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}
}
