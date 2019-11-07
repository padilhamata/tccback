package com.pizza.backpizza.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizza.backpizza.models.Produto;
import com.pizza.backpizza.repository.ProdutoRepository;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/produtos")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> listaProdutos() {
		return produtoRepository.findAll();
	}

	@GetMapping("/{id}")
	public Produto listaProdutosUnico(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
	}

	@PostMapping
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/{id}")
	public void deletaProduto(@PathVariable(value = "id") long id) {
		produtoRepository.deleteById(id);
	}
	
	@PutMapping
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
