package com.cidadao.api.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@Builder(builderClassName = "Builder")
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
public class Erro {

	private String mensagemErro;
	private String mensagemDesenvolvedor;

}
