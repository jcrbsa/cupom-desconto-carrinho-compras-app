package com.facilit.cupom.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facilit.cupom.model.Cupom;
import com.facilit.cupom.model.Produto;

@Repository
public interface CupomRepository extends JpaRepository<Cupom, Long> {

	Cupom findByNome(String nome);
	List<Cupom> findByTipo(String tipo);
	Optional<Cupom> findById(Long Id);
	
}
