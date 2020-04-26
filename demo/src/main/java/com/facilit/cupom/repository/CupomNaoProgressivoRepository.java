package com.facilit.cupom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facilit.cupom.model.CupomNaoProgressivo;

@Repository
public interface CupomNaoProgressivoRepository extends JpaRepository<CupomNaoProgressivo, Long> {

	List<CupomNaoProgressivo> findByNome(String nome);
	List<CupomNaoProgressivo> findByTipo(String tipo);
	
}
