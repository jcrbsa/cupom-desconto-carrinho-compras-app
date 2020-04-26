package com.facilit.cupom.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facilit.cupom.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findByNome(String nome);
	List<Produto> findByNomeContaining(String nome);
	List<Produto> findByTipoContaining(String tipo);
	Optional<Produto> findById(Long Id);
}

