package br.com.ifblackthencode.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifblackthencode.petshop.model.OrdemServico;
import br.com.ifblackthencode.petshop.services.IOrdemServicoService;

@RestController
public class OrdemServicoController { 
	
	
	@Autowired
	private IOrdemServicoService service;
	
	@GetMapping("/ordemservico/{id}")
	public ResponseEntity<OrdemServico> recuperarPeloId(@PathVariable Integer id){
		OrdemServico res = service.recuperarPeloNum(id);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();   
	} 
	
	@PostMapping("/ordemservico")
	public ResponseEntity<OrdemServico> inserirNovaOrdem(@RequestBody OrdemServico novo){
		OrdemServico res = service.inserirNovo(novo);
		if (res!=null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
}
