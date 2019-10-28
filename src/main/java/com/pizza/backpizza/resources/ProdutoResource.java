package com.pizza.backpizza.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizza.backpizza.repository.ProdutoRepository;

import com.pizza.backpizza.models.Produto;

@RestController
@RequestMapping(value="/api")
public class ProdutoResource {

		@Autowired
		ProdutoRepository produtoRepository;
		
		@GetMapping("/produtos")
		public  List<Produto> listaProdutos(){
			return produtoRepository.findAll();	
		}
		@GetMapping("/produtos/{id}")
		public  Produto listaProdutosUnico(@PathVariable(value="id") long id){
			return produtoRepository.findById(id);	
		}
		@PostMapping("/produto")
		public Produto salvaProduto(@RequestBody Produto produto) {
			return produtoRepository.save(produto);
		}
		@DeleteMapping("/produto")
		public void deletaProduto(@RequestBody Produto produto) {
			produtoRepository.delete(produto);
		}
		@PutMapping("/produto")
		public Produto atualizaProduto(@RequestBody Produto produto) {
			System.out.println(produto);
			return produtoRepository.save(produto);
		}
}
