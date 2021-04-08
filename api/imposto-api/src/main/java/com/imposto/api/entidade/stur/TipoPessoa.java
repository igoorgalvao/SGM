package com.imposto.api.entidade.stur;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "TIPO_PESSOA", schema = "STUR_IMPOSTO")
@Data
@Builder(builderClassName = "Builder")
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
public class TipoPessoa {

	@Id
	@Column(name = "NU_TIPO_PESSOA")
	private Long id;

	@Column(name = "DE_TIPO_PESSOA")
	private String nome;

}

