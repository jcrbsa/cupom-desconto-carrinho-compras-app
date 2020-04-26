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

import com.facilit.cupom.model.CupomProgressivo;
import com.facilit.cupom.repository.CupomProgressivoRepository;
import com.facilit.cupom.service.CadastroCupomProgressivoService;


@RestController
public class CupomProgressivoController {

	
	@Autowired
	private CupomProgressivoRepository cupomProgressivoRepository;
	
	@Autowired
	private CadastroCupomProgressivoService cadastroCupomProgressivo;
	
	@GetMapping("cupom_progressivos")
	public List<CupomProgressivo> listar() {
		return  cupomProgressivoRepository.findByTipo("P");
	}
	
	@GetMapping("cupom_progressivo/buscar/{cupom_progressivoId}")
	public ResponseEntity<CupomProgressivo> buscar(@PathVariable Long cupomProgressivoId) {
		Optional<CupomProgressivo> cupomProgressivo = cupomProgressivoRepository.findById(cupomProgressivoId);
		
		if (cupomProgressivo.isPresent()) {
			return ResponseEntity.ok(cupomProgressivo.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("cupom_progressivo/adicionar")
	@ResponseStatus(HttpStatus.CREATED)
	public CupomProgressivo adicionar(@Valid @RequestBody CupomProgressivo cupomProgressivo) throws Exception {
		cupomProgressivo.setTipo("P");
		return cadastroCupomProgressivo.salvar(cupomProgressivo);
	}
	
	@PutMapping("cupom_progressivo/atualizar/{cupom_progressivoId}")
	public ResponseEntity<CupomProgressivo> atualizar(@Valid @PathVariable Long cupomProgressivoId,
			@RequestBody CupomProgressivo cupomProgressivo) throws Exception {
		
		if (!cupomProgressivoRepository.existsById(cupomProgressivoId)) {
			return ResponseEntity.notFound().build();
		}
		
		cupomProgressivo.setId(cupomProgressivoId);
		cupomProgressivo = cadastroCupomProgressivo.salvar(cupomProgressivo);
		
		return ResponseEntity.ok(cupomProgressivo);
	}
	
	@DeleteMapping("cupom_progressivo/excluir/{cupom_progressivoId}")
	public ResponseEntity<Void> remover(@PathVariable Long cupomProgressivoId) {
		if (!cupomProgressivoRepository.existsById(cupomProgressivoId)) {
			return ResponseEntity.notFound().build();
		}
		
		cadastroCupomProgressivo.excluir(cupomProgressivoId);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
}
