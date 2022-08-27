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

import br.com.ifblackthencode.petshop.model.Animal;
import br.com.ifblackthencode.petshop.services.IAnimalService;

@RestController
public class AnimalController {
	
	@Autowired
	private IAnimalService service;
	
	@GetMapping("/animal")
	public ArrayList<Animal> recuperarTodos(){
		return service.recuperarTodos();
	}
	
	@PostMapping("/animal")
	public ResponseEntity<Animal> incluirNovo(@RequestBody Animal novo) {
		Animal res = service.cadastrarNovo(novo);
		if (res!=null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/animal")
	public ResponseEntity<Animal> alterar(@RequestBody Animal dados) {
		Animal res = service.atualizarCadastro(dados);
		if (res!=null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/animal/{id}")
	public ResponseEntity<Animal> excluir(@PathVariable Integer id) {
		service.excluirAnimal(id);
		return ResponseEntity.ok(null);
	}
	
	@GetMapping("/animal/{id}")
	public ResponseEntity<Animal> buscarPeloID(@PathVariable Integer id) {
		Animal res = service.recuperarPeloID(id);
		if (res!=null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	
}
