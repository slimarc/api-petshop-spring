package br.com.ifblackthencode.petshop.services;

import java.util.ArrayList;

import br.com.ifblackthencode.petshop.model.Animal;

public interface IAnimalService {
	public ArrayList<Animal> recuperarTodos();
	public Animal recuperarPeloID(Integer id);
	public Animal cadastrarNovo(Animal novo);
	public Animal atualizarCadastro(Animal dados);
	public void excluirAnimal(Integer id);
}
