package br.com.ifblackthencode.petshop.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.ifblackthencode.petshop.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

}
