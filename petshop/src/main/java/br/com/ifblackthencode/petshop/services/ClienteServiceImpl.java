package br.com.ifblackthencode.petshop.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifblackthencode.petshop.model.Cliente;
import br.com.ifblackthencode.petshop.repository.ClienteRepository;

@Service 
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private ClienteRepository repository;

	
	public Cliente criarNovo(Cliente novo) {
		if(novo.getNome()!=null) {
			return repository.save(novo);
		}
		return null;
	}

	
	public Cliente atualizarDados(Cliente dados) {
		// TODO Auto-generated method stub
		if(dados.getId()!=null && dados.getNome()!=null) {
			return repository.save(dados);
		}
		return null;
	}

	
	public ArrayList<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return (ArrayList<Cliente>)repository.findAll();
	}

	
	public Cliente buscarPeloID(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}


	public void excluirCliente(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	
}
