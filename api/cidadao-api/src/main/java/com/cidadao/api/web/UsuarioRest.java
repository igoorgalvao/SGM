package com.cidadao.api.web;

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

import com.cidadao.api.core.BusinessException;
import com.cidadao.api.dto.UsuarioDTO;
import com.cidadao.api.service.IUsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioRest {

	@Autowired
	private IUsuarioService service;

	@Autowired
	private MessageSource messageSource;

	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody UsuarioDTO dto) {

		if (StringUtils.isBlank(dto.getNome())) {
			throw new BusinessException(
					messageSource.getMessage("mensagem.campo.obrigatorio", null, LocaleContextHolder.getLocale()));
		}

		UsuarioDTO usuario = service.salvar(dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	}

	@PutMapping("/alterar")
	public ResponseEntity<?> alterar(@RequestBody UsuarioDTO dto) {

		if (StringUtils.isBlank(dto.getNome())) {
			throw new BusinessException(
					messageSource.getMessage("mensagem.campo.obrigatorio", null, LocaleContextHolder.getLocale()));
		}

		UsuarioDTO usuario = service.alterar(dto);

		return ResponseEntity.ok(usuario);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long id) {
		service.excluir(id);
	}

	@GetMapping("/{id}")
	public UsuarioDTO pesquisaPorId(@PathVariable Long id) {
		return service.pesquisaPorId(id);
	}

	@GetMapping("/listar")
	public List<UsuarioDTO> listar() {
		return service.listar();
	}

}
