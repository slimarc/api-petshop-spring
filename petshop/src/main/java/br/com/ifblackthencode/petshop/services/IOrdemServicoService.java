package br.com.ifblackthencode.petshop.services;

import br.com.ifblackthencode.petshop.model.OrdemServico;


public interface IOrdemServicoService {
	public OrdemServico inserirNovo(OrdemServico novo);
	public OrdemServico recuperarPeloNum(Integer num_ordem);
}
