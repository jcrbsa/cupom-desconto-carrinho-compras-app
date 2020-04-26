package com.facilit.cupom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facilit.cupom.model.Cupom;
import com.facilit.cupom.model.CupomProgressivo;
import com.facilit.cupom.repository.CupomProgressivoRepository;

@Service
public class CadastroCupomProgressivoService {

	@Autowired
	private CupomProgressivoRepository cupomeRepository;
	
	public CupomProgressivo salvar(CupomProgressivo cupome) throws Exception {
		
		List<CupomProgressivo> cupoms = cupomeRepository.findByNome(cupome.getNome());
		
		if(cupoms.size() > 0) {
		Cupom cupomeExistente = cupoms.get(0);
		
		if (cupomeExistente != null && !cupomeExistente.equals(cupome)) {
			throw new Exception("Já existe um cupome cadastrado com este nome.");
		}
		}
		
		return cupomeRepository.save(cupome);
	}
	
	public void excluir(Long cupomeId) {
		cupomeRepository.deleteById(cupomeId);
	}
	
}
