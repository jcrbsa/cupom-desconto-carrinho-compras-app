package com.facilit.cupom.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.facilit.cupom.model.Carrinho;
import com.facilit.cupom.model.Cupom;
import com.facilit.cupom.model.Produto;
import com.facilit.cupom.repository.CarrinhoRepository;
import com.facilit.cupom.service.DescontoService;

@RestController
public class DescontoController {

	@Autowired
	private DescontoService descontoService;
	
	@Autowired
	private CarrinhoRepository carrinhoRepository;

	@PostMapping("/desconto")
	public HashMap<String, Float> calcularCupomDesconto(@RequestBody Carrinho carrinho) throws Exception {
		
		List<Produto> produtos_validos = descontoService.existeProduto(carrinho.getProduto()); 
		List<Cupom> cupons_validos = descontoService.existeCupom(carrinho.getCupom());
		
		
		
		
		//return ResponseEntity.ok().build();
		
		return descontoService.calculaDesconto(produtos_validos, cupons_validos);

	}
	
	@GetMapping("carrinhos")
	public List<Carrinho> listar() {
		return carrinhoRepository.findAll();
	}
	

	/*
	 * @GetMapping("/desconto") public Map<String, Object> []
	 * calcularCupomDesconto( @RequestBody Map<String, Object> stuffs [] ) throws
	 * Exception {
	 * 
	 * for (Map<String, Object> map : stuffs) {
	 * 
	 * } return stuffs;
	 * 
	 * }
	 */
	/*
	 * @GetMapping("/desconto") public HashMap< String, Float>
	 * calcularCupomDesconto(@RequestBody(value = "produtos", required = true) List
	 * <Produto> produtos, @RequestBody(value = "cupons", required = true) List
	 * <Cupom> cupons) throws Exception {
	 * 
	 * descontoService.existeProduto(produtos); descontoService.existeCupom(
	 * cupons);
	 * 
	 * return descontoService.calculaDesconto(produtos, cupons); }
	 */

}
