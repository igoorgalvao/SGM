package com.cidadao.api.service;

import java.util.List;

import com.cidadao.api.dto.ExemploDTO;

public interface IExemploService {

	ExemploDTO salvar(ExemploDTO dto);

	ExemploDTO alterar(ExemploDTO dto);

	void excluir(Long id);

	ExemploDTO pesquisaPorId(Long id);

	List<ExemploDTO> listar();

}
