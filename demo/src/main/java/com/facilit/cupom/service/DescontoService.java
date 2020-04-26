package com.facilit.cupom.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facilit.cupom.model.Carrinho;
import com.facilit.cupom.model.Cupom;
import com.facilit.cupom.model.CupomNaoProgressivo;
import com.facilit.cupom.model.CupomProgressivo;
import com.facilit.cupom.model.Produto;
import com.facilit.cupom.repository.CarrinhoRepository;
import com.facilit.cupom.repository.CupomNaoProgressivoRepository;
import com.facilit.cupom.repository.CupomProgressivoRepository;
import com.facilit.cupom.repository.CupomRepository;
import com.facilit.cupom.repository.ProdutoRepository;

@Service
public class DescontoService {

	@Autowired
	private ProdutoRepository produtoeRepository;

	@Autowired
	private CupomRepository cupomRepository;
	
	
	@Autowired
	private CupomNaoProgressivoRepository cupomNaoProgressivoRepository;
	
	@Autowired
	private CarrinhoRepository carrinhoRepository;

	@Autowired
	private CupomProgressivoRepository cupomProgressivoRepository;
	
	

	
	public Carrinho salvar(Carrinho carrinho) throws Exception {
		

		
		return carrinhoRepository.save(carrinho);
	}

	public List<Produto> existeProduto(List<Produto> produtos) throws Exception {

		List <Produto> produtos_confirmados = new ArrayList<Produto>();
		
		for (Produto produto : produtos) {
			Produto produto_encontrado = null;
			try {
			 produto_encontrado = produtoeRepository.findById(produto.getId()).get();
			}catch (Exception e) {
				// TODO: handle exception
			}
			if (produto_encontrado == null) {
				//throw new Exception("O produto não identificado.");
				System.err.println("O produto não identificado.");
			}else {
				//Produto produto_encontrado = existeProduto.get();
				Produto produto_temp = new Produto();
				produto_temp.setId(produto_encontrado.getId());
				produto_temp.setNome(produto_encontrado.getNome());
				produto_temp.setPreco(produto_encontrado.getPreco());
				produto_temp.setTipo(produto_encontrado.getTipo());
				
				produtos_confirmados.add(produto_temp);
			}

		}
		
		return produtos_confirmados; 

	}


	public List<Cupom> existeCupom(List<Cupom> cupons) throws Exception {

		List <Cupom> cupons_confirmados = new ArrayList<Cupom>();
		for (Cupom cupom : cupons) {
			Cupom cupom_encontrado = null;
			try {
		     cupom_encontrado = cupomRepository.findByNome(cupom.getNome());
			}catch (Exception e) {
				// TODO: handle exception
			}
			

			if (cupom_encontrado == null) {
				///throw new Exception("Esse cupom não é válido.");
				System.err.println("Esse cupom não é válido.");
			}else {
				Cupom cupom_temp = new Cupom();
				cupom_temp.setId(cupom_encontrado.getId());
				cupom_temp.setNome(cupom_encontrado.getNome());
				cupom_temp.setTipo(cupom_encontrado.getTipo());
				cupom_temp.setDesconto(cupom_encontrado.getDesconto());
				cupons_confirmados.add(cupom_temp);
			}

		}
		
		return cupons_confirmados;

	}

	public HashMap<String, Float> calculaDesconto(List<Produto> produtos, List<Cupom> cupons) throws Exception {
		Float soma = 0.00F;
		HashMap<String, Float> precos_tipo = new HashMap<>();
		HashMap<String, Integer> quantidade_tipo = new HashMap<>();

		for (Produto produto : produtos) {

			Float preco = produto.getPreco().floatValue();
			soma += preco;

			if (precos_tipo.containsKey(produto.getTipo())) {
				preco = precos_tipo.get(produto.getTipo());
				preco = preco + produto.getPreco();
				precos_tipo.put(produto.getTipo(), preco);

				Integer quantidade = quantidade_tipo.get(produto.getTipo());
				quantidade = quantidade + 1;
				quantidade_tipo.put(produto.getTipo(), quantidade);

			} else {

				precos_tipo.put(produto.getTipo(), preco);

				quantidade_tipo.put(produto.getTipo(), 1);
			}

		}

		precos_tipo.put("total", soma);

		List<CupomNaoProgressivo> cupons_nao_progressivos = identificaCuponsNaoProgressivo(cupons);
		List<CupomProgressivo> cupons_progressivos = identificaCuponsProgressivo(cupons);
		List <Cupom> cupons_aser_salvos = new ArrayList();
		CupomNaoProgressivo cupom_nao_progressigo_candidato = analisaSituacaoQuantidadeProdutos(quantidade_tipo,
				cupons_nao_progressivos);
		
		if(cupom_nao_progressigo_candidato != null) {
			cupons_aser_salvos.add(cupom_nao_progressigo_candidato);
		}
		CupomProgressivo cupom_progressivo_candadato = analisaSituacaoPreco(soma, cupons_progressivos);
		if(cupom_progressivo_candadato != null) {
			cupons_aser_salvos.add(cupom_progressivo_candadato);
		}
		HashMap<String, Float> precos_descontos = aplicaDescontoCupomNaoProgressivoPorTipo(precos_tipo, cupom_nao_progressigo_candidato,cupom_progressivo_candadato);
		
		List <Produto> precos_produtos_atualizados = atualizaValorProdutosTipoCupomNaoProgressivo(quantidade_tipo, produtos);
		Carrinho carrinho = new Carrinho();
		carrinho.setCupom(cupons_aser_salvos);
		carrinho.setProduto(precos_produtos_atualizados);
		carrinho.setTotal(precos_descontos.get("total"));
		carrinhoRepository.save(carrinho);
		

		return precos_descontos;
	}


	

	private List<Produto> atualizaValorProdutosTipoCupomNaoProgressivo(HashMap<String, Integer> quantidade_tipo, List<Produto> produtos) {
		// TODO Auto-generated method stub
		List<Produto> produtos_atualizados = new ArrayList<Produto>();
		Produto produto_atualizado = null;
		for (Map.Entry<String, Integer> entry : quantidade_tipo.entrySet()) {
			if(entry.getKey() == "total" ) {
				continue;
			}else {
				if (entry.getValue() >=10 ) {
					for (Produto produto : produtos) {
						if (produto.getTipo().equals(entry.getKey())){
							float valor_desconto = produto.getPreco() * (float)0.01;
							float novo_valor = produto.getPreco() - valor_desconto;													
							produto_atualizado = new Produto();
							produto_atualizado.setId(produto.getId());
							produto_atualizado.setNome(produto.getNome());
							produto_atualizado.setPreco(novo_valor);
							produto_atualizado.setTipo(produto.getTipo());
								
							produtos_atualizados.add(produto_atualizado);
						}else {
							produtos_atualizados.add(produto);
						}
						
					}
				}
			}
		}
		return produtos_atualizados;
	}

	private HashMap<String, Float> aplicaDescontoCupomNaoProgressivoPorTipo(HashMap<String, Float> precos_tipo,
			CupomNaoProgressivo cupom_nao_progressigo, CupomProgressivo cupon_progressivo) {
		// TODO Auto-generated method stub
		if(cupom_nao_progressigo != null) {
			float soma =  0;
			for (Map.Entry<String, Float> entry : precos_tipo.entrySet()) {
				float valor_desconto = ( entry.getValue() *( cupom_nao_progressigo.getDesconto()/ (float)100.0));
				float novo_valor = entry.getValue() - valor_desconto;
				precos_tipo.put(entry.getKey(), novo_valor); 
				soma = soma +  novo_valor;
			}
			precos_tipo.put("total", soma);
			
		}
		
		if(cupon_progressivo != null) {
			float total = precos_tipo.get("total");
			float desconto = total * ( cupon_progressivo.getDesconto()/ (float)100.0);
			total = total - desconto ;
			precos_tipo.put("total", total);
		} 
		return precos_tipo;
	}

	private CupomProgressivo analisaSituacaoPreco(Float soma, List<CupomProgressivo> cupons_progressivos) {
		// TODO Auto-generated method stub
		CupomProgressivo cupomescolhido = null;
		for (CupomProgressivo cupomProgressivo : cupons_progressivos) {

			if (soma >= cupomProgressivo.getValorcompras()) {
				cupomescolhido = new CupomProgressivo();
				cupomescolhido.setId(cupomProgressivo.getId());
				cupomescolhido.setNome(cupomProgressivo.getNome());
				cupomescolhido.setTipo(cupomProgressivo.getTipo());
				cupomescolhido.setDesconto(cupomProgressivo.getDesconto());
				cupomescolhido.setValorcompras(cupomProgressivo.getValorcompras());
			}
		}

		return cupomescolhido;
	}

	private CupomNaoProgressivo analisaSituacaoQuantidadeProdutos(HashMap<String, Integer> quantidade_tipo,
			List<CupomNaoProgressivo> cupons_nao_progressivos) {
		// TODO Auto-generated method stub
		CupomNaoProgressivo cupomescolhido = null;
		for (Map.Entry<String, Integer> entry : quantidade_tipo.entrySet()) {

			for (CupomNaoProgressivo cupomProgressivo : cupons_nao_progressivos) {

				if (entry.getValue() >= cupomProgressivo.getQuantidadeprodutos()) {
					cupomescolhido = new CupomNaoProgressivo();
					cupomescolhido.setId(cupomProgressivo.getId());
					cupomescolhido.setNome(cupomProgressivo.getNome());
					cupomescolhido.setTipo(cupomProgressivo.getTipo());
					cupomescolhido.setDesconto(cupomProgressivo.getDesconto());
					cupomescolhido.setQuantidadeprodutos(cupomProgressivo.getQuantidadeprodutos());
				}
			}

		}

		return cupomescolhido;
	}

	private List<CupomProgressivo> identificaCuponsProgressivo(List<Cupom> cupons) {
		// TODO Auto-generated method stub
		List<CupomProgressivo> listaCupomProgressivo = new ArrayList<CupomProgressivo>();
		for (Cupom cupom : cupons) {
			List<CupomProgressivo> cupons_armazenados = cupomProgressivoRepository.findByNome(cupom.getNome());
			if ( cupons_armazenados.size() > 0 ) {
				CupomProgressivo cupom_atual = cupons_armazenados.get(0);
				listaCupomProgressivo.add( cupom_atual);
			}
			
		}
		return listaCupomProgressivo;
	}

	private List<CupomNaoProgressivo> identificaCuponsNaoProgressivo(List<Cupom> cupons) {
		// TODO Auto-generated method stub
		List<CupomNaoProgressivo> listaCupomNaoProgressivo = new ArrayList<CupomNaoProgressivo>();
		for (Cupom cupom : cupons) {
			
			List<CupomNaoProgressivo> cupons_armazenados = cupomNaoProgressivoRepository.findByNome(cupom.getNome());
			if ( cupons_armazenados.size() > 0 ) {
				CupomNaoProgressivo cupom_atual = cupons_armazenados.get(0);
				listaCupomNaoProgressivo.add( cupom_atual);
			}
			
		}
		return listaCupomNaoProgressivo;
	}

}
