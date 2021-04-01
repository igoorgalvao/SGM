package com.cidadao.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cidadao.api.dao.UsuarioDAO;
import com.cidadao.api.dto.UsuarioDTO;
import com.cidadao.api.entidade.Usuario;

@Service
@Transactional(readOnly = true)
public class UsuarioService implements IUsuarioService {

	@Autowired
	private UsuarioDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public UsuarioDTO salvar(UsuarioDTO dto) {
		// @formatter:off
		dao.save(Usuario.builder()
					.id(dto.getId())
					.nome(dto.getNome())
					.build());
		// @formatter:on

		return dto;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public UsuarioDTO alterar(UsuarioDTO dto) {

		if (dto.getId() == null) {
			throw new IllegalArgumentException();
		}

		Optional<Usuario> usuario = dao.findById(dto.getId());
		if (!usuario.isPresent()) {
			throw new IllegalArgumentException();
		}

		// @formatter:off
		dao.save(Usuario.builder()
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
	public List<UsuarioDTO> listar() {
		return dao.findAll().stream().map(item ->

		// @formatter:off
			UsuarioDTO.builder()
			.id(item.getId())
			.nome(item.getNome())
			.build()
		// @formatter:on

		).collect(Collectors.toList());
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public UsuarioDTO pesquisaPorId(Long id) {
		Optional<Usuario> usuario = dao.findById(id);

		if (usuario.isPresent()) {
			// @formatter:off
			return UsuarioDTO.builder()
					.id(usuario.get().getId())
					.nome(usuario.get().getNome())
					.build();
			// @formatter:on

		}

		return null;
	}
}
