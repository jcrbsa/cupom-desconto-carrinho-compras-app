package com.facilit.cupom.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.facilit.cupom.model.Produto;
import com.facilit.cupom.repository.ProdutoRepository;
import com.facilit.cupom.service.CadastroProdutoService;

@RestController
public class ProdutoController {


	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CadastroProdutoService cadastroProduto;
	
	@GetMapping("produtos")
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}
	
	@GetMapping("produto/buscar/{produtoId}")
	public ResponseEntity<Produto> buscar(@PathVariable Long produtoId) {
		Optional<Produto> produto = produtoRepository.findById(produtoId);
		
		if (produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("produto/adicionar")
	@ResponseStatus(HttpStatus.CREATED)
	public Produto adicionar(@Valid @RequestBody Produto produto) throws Exception {
		return cadastroProduto.salvar(produto);
	}
	
	@PutMapping("produto/atualizar/{produtoId}")
	public ResponseEntity<Produto> atualizar(@Valid @PathVariable Long produtoId,
			@RequestBody Produto produto) throws Exception {
		
		if (!produtoRepository.existsById(produtoId)) {
			return ResponseEntity.notFound().build();
		}
		
		produto.setId(produtoId);
		produto = cadastroProduto.salvar(produto);
		
		return ResponseEntity.ok(produto);
	}
	
	@DeleteMapping("produto/excluir/{produtoId}")
	public ResponseEntity<Void> remover(@PathVariable Long produtoId) {
		if (!produtoRepository.existsById(produtoId)) {
			return ResponseEntity.notFound().build();
		}
		
		cadastroProduto.excluir(produtoId);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
}
