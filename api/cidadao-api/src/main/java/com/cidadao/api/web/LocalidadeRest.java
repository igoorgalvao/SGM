package com.cidadao.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cidadao.api.client.ConsultaViaCepClient;
import com.cidadao.api.client.EnderecoDTO;

@RestController
@RequestMapping("/localidade")
public class LocalidadeRest {

	@Autowired
	private ConsultaViaCepClient service;

	@GetMapping("/consultaPorCep/{cep}")
	public EnderecoDTO gerarImpostoPorTipoPessoa(@PathVariable String cep) {
		return service.obterEnderecoPorCep(cep);
	}

}
