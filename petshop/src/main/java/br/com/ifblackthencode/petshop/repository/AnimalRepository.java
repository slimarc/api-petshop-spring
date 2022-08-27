package br.com.ifblackthencode.petshop.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.ifblackthencode.petshop.model.Animal;

public interface AnimalRepository extends CrudRepository<Animal, Integer> {

}
