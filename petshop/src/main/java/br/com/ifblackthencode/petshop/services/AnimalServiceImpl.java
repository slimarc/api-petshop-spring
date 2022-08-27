package br.com.ifblackthencode.petshop.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifblackthencode.petshop.model.Animal;
import br.com.ifblackthencode.petshop.repository.AnimalRepository;

@Service
public class AnimalServiceImpl implements IAnimalService {

	@Autowired
	private AnimalRepository repository;
	
	@Override
	public ArrayList<Animal> recuperarTodos() {
		// TODO Auto-generated method stub
		return (ArrayList<Animal>)repository.findAll();
	}

	@Override
	public Animal recuperarPeloID(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public Animal cadastrarNovo(Animal novo) {
		// TODO Auto-generated method stub
		if(novo.getNome()!=null) {
			return repository.save(novo);
		}
		return null;
	}

	@Override
	public void excluirAnimal(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Animal atualizarCadastro(Animal dados) {
		// TODO Auto-generated method stub
		if(dados.getId()!=null && dados.getNome()!=null) {
			return repository.save(dados);
		}
		return null;
	}
	
	

}
