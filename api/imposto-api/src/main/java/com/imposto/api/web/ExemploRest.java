package com.imposto.api.web;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.imposto.api.core.BusinessException;
import com.imposto.api.dto.ExemploDTO;
import com.imposto.api.service.IExemploService;

@RestController
@RequestMapping("/exemplo")
public class ExemploRest {

	@Autowired
	private IExemploService service;

	@Autowired
	private MessageSource messageSource;

	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody ExemploDTO dto) {

		if (StringUtils.isBlank(dto.getNome())) {
			throw new BusinessException(
					messageSource.getMessage("mensagem.campo.obrigatorio", null, LocaleContextHolder.getLocale()));
		}

		ExemploDTO exemplo = service.salvar(dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(exemplo);
	}

	@PutMapping("/alterar")
	public ResponseEntity<?> alterar(@RequestBody ExemploDTO dto) {

		if (StringUtils.isBlank(dto.getNome())) {
			throw new BusinessException(
					messageSource.getMessage("mensagem.campo.obrigatorio", null, LocaleContextHolder.getLocale()));
		}

		ExemploDTO exemplo = service.alterar(dto);

		return ResponseEntity.ok(exemplo);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long id) {
		service.excluir(id);
	}

	@GetMapping("/{id}")
	public ExemploDTO pesquisaPorId(@PathVariable Long id) {
		return service.pesquisaPorId(id);
	}

	@GetMapping("/listar")
	public List<ExemploDTO> listar() {
		return service.listar();
	}

}
