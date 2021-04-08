package com.imposto.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.imposto.api.core.BusinessException;
import com.imposto.api.dao.datasource.impostoapi.ExemploDAO;
import com.imposto.api.dto.ExemploDTO;
import com.imposto.api.entidade.impostoapi.Exemplo;

@Service
@Transactional(readOnly = true)
public class ExemploService implements IExemploService {

	@Autowired
	private ExemploDAO dao;

	@Autowired
	private MessageSource messageSource;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public ExemploDTO salvar(ExemploDTO dto) {

		if (StringUtils.isBlank(dto.getNome())) {
			throw new BusinessException(messageSource.getMessage("mensagem.campo.obrigatorio", null, LocaleContextHolder.getLocale()));
		}

		// @formatter:off
		dao.save(Exemplo.builder()
					.id(dto.getId())
					.nome(dto.getNome())
					.build());
		// @formatter:on

		return dto;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public ExemploDTO alterar(ExemploDTO dto) {

		if (dto.getId() == null) {
			throw new IllegalArgumentException();
		}

		if (StringUtils.isBlank(dto.getNome())) {
			throw new BusinessException(messageSource.getMessage("mensagem.campo.obrigatorio", null, LocaleContextHolder.getLocale()));
		}

		Optional<Exemplo> exemplo = dao.findById(dto.getId());
		if (!exemplo.isPresent()) {
			throw new IllegalArgumentException();
		}

		// @formatter:off
		dao.save(Exemplo.builder()
				.id(dto.getId())
				.nome(dto.getNome())
				.build());
		// @formatter:on

		return dto;

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void excluir(Long id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ExemploDTO> listar() {
		return dao.findAll().stream().map(item ->

		// @formatter:off
			ExemploDTO.builder()
			.id(item.getId())
			.nome(item.getNome())
			.build()
		// @formatter:on

		).collect(Collectors.toList());
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public ExemploDTO pesquisaPorId(Long id) {
		Optional<Exemplo> exemplo = dao.findById(id);

		if (exemplo.isPresent()) {
			// @formatter:off
			return ExemploDTO.builder()
					.id(exemplo.get().getId())
					.nome(exemplo.get().getNome())
					.build();
			// @formatter:on

		}

		return null;
	}
}
