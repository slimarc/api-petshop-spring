package br.com.ifblackthencode.petshop.services;

import java.util.ArrayList;

import br.com.ifblackthencode.petshop.model.Cliente;

public interface IClienteService {
	public Cliente criarNovo(Cliente novo);
	public Cliente atualizarDados(Cliente dados);
	public ArrayList<Cliente> buscarTodos();
	public Cliente buscarPeloID(Integer id);
	public void excluirCliente(Integer id);

}
