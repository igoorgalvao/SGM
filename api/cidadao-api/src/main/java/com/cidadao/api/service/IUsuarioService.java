package com.cidadao.api.service;

import java.util.List;

import com.cidadao.api.dto.UsuarioDTO;

public interface IUsuarioService {

	UsuarioDTO salvar(UsuarioDTO dto);

	UsuarioDTO alterar(UsuarioDTO dto);

	void excluir(Long id);

	UsuarioDTO pesquisaPorId(Long id);

	List<UsuarioDTO> listar();

}
