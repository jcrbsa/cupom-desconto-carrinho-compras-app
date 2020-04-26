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

import com.facilit.cupom.model.CupomNaoProgressivo;
import com.facilit.cupom.repository.CupomNaoProgressivoRepository;
import com.facilit.cupom.service.CadastroCupomNaoProgressivoService;


@RestController
public class CupomNaoProgressivoController {

	
	@Autowired
	private CupomNaoProgressivoRepository cupomNaoProgressivoRepository;
	
	@Autowired
	private CadastroCupomNaoProgressivoService cadastroCupomNaoProgressivo;
	
	@GetMapping("cupom_nao_progressivos")
	public List<CupomNaoProgressivo> listar() {
		return  cupomNaoProgressivoRepository.findByTipo("NP");
	}
	
	@GetMapping("cupom_nao_progressivo/buscar/{cupom_nao_progressivoId}")
	public ResponseEntity<CupomNaoProgressivo> buscar(@PathVariable Long cupomNaoProgressivoId) {
		Optional<CupomNaoProgressivo> cupomNaoProgressivo = cupomNaoProgressivoRepository.findById(cupomNaoProgressivoId);
		
		if (cupomNaoProgressivo.isPresent()) {
			return ResponseEntity.ok(cupomNaoProgressivo.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("cupom_nao_progressivo/adicionar")
	@ResponseStatus(HttpStatus.CREATED)
	public CupomNaoProgressivo adicionar(@Valid @RequestBody CupomNaoProgressivo cupomNaoProgressivo) throws Exception {
		cupomNaoProgressivo.setTipo("NP");
		return cadastroCupomNaoProgressivo.salvar(cupomNaoProgressivo);
	}
	
	@PutMapping("cupom_nao_progressivo/atualizar/{cupom_nao_progressivoId}")
	public ResponseEntity<CupomNaoProgressivo> atualizar(@Valid @PathVariable Long cupomNaoProgressivoId,
			@RequestBody CupomNaoProgressivo cupomNaoProgressivo) throws Exception {
		
		if (!cupomNaoProgressivoRepository.existsById(cupomNaoProgressivoId)) {
			return ResponseEntity.notFound().build();
		}
		
		cupomNaoProgressivo.setId(cupomNaoProgressivoId);
		cupomNaoProgressivo = cadastroCupomNaoProgressivo.salvar(cupomNaoProgressivo);
		
		return ResponseEntity.ok(cupomNaoProgressivo);
	}
	
	@DeleteMapping("cupom_nao_progressivo/excluir/{cupom_nao_progressivoId}")
	public ResponseEntity<Void> remover(@PathVariable Long cupomNaoProgressivoId) {
		if (!cupomNaoProgressivoRepository.existsById(cupomNaoProgressivoId)) {
			return ResponseEntity.notFound().build();
		}
		
		cadastroCupomNaoProgressivo.excluir(cupomNaoProgressivoId);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
}
