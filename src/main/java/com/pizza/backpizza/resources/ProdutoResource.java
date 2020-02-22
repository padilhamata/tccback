package com.pizza.backpizza.resources;

import com.pizza.backpizza.models.Produto;
import com.pizza.backpizza.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/produtos")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> listaProdutos() {
		System.out.println("estou listando");
		return produtoRepository.findAll();
	}

	@GetMapping("/{id}")
	public Produto listaProdutosUnico(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
	}

	@PostMapping
	public Produto salvaProduto(@RequestBody Produto produto) {
		System.out.println("estou salvando o produto");
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/{id}")
	public void deletaProduto(@PathVariable(value = "id") long id) {
		System.out.println("Estou deletnado com id"+id);
		produtoRepository.deleteById(id);
	}
	
	@PutMapping
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
