package com.facilit.cupom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facilit.cupom.model.CupomProgressivo;

@Repository
public interface CupomProgressivoRepository extends JpaRepository<CupomProgressivo, Long> {

	List<CupomProgressivo> findByNome(String nome);
	List<CupomProgressivo> findByTipo(String tipo);
	
}
