package com.facilit.cupom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facilit.cupom.model.Produto;
import com.facilit.cupom.repository.ProdutoRepository;

@Service
public class CadastroProdutoService {

	@Autowired
	private ProdutoRepository produtoeRepository;
	
	public Produto salvar(Produto produtoe) throws Exception {
		
		List<Produto> produtos = produtoeRepository.findByNome(produtoe.getNome());
		
		if(produtos.size() > 0) {
		Produto produtoeExistente = produtos.get(0);
		
		if (produtoeExistente != null && !produtoeExistente.equals(produtoe)) {
			throw new Exception("Já existe um produtoe cadastrado com este nome.");
		}
		}
		
		return produtoeRepository.save(produtoe);
	}
	
	public void excluir(Long produtoeId) {
		produtoeRepository.deleteById(produtoeId);
	}
	
}
