package com.imposto.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imposto.api.dto.DownloadFileDTO;
import com.imposto.api.dto.GerarImpostoDTO;
import com.imposto.api.service.IImpostoService;

@RestController
@RequestMapping("/imposto")
public class ImpostoRest {

	@Autowired
	private IImpostoService service;

	@PostMapping("/gerarImpostoPorTipoPessoa")
	public ResponseEntity<Resource> gerarImpostoPorTipoPessoa(@RequestBody GerarImpostoDTO dto) {
		DownloadFileDTO dtoFile = service.gerarImpostoPorTipoPessoa(dto);

		Resource file = new ByteArrayResource(dtoFile.getBytes());


		// @formatter:off
		return ResponseEntity.ok()
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "teste.pdf" + "\"")
				.header("TESTE", "TESTE")
				.body(file);
		// @formatter:on

	}

}
