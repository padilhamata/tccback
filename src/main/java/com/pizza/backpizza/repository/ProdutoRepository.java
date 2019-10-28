package com.pizza.backpizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizza.backpizza.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	Produto findById(long id);
	
}
