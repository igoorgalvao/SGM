package com.cidadao.api.entidade.stur;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "PAGADOR", schema = "STUR_IMPOSTO")
@Data
@Builder(builderClassName = "Builder")
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
public class Pagador {

	@Id
	@Column(name = "NU_PAGADOR")
	private Long id;

	@Column(name = "NU_CPF_CNPJ")
	private Long cpfCnpj;

	@Column(name = "NO_PAGADOR")
	private String nomePagador;

	@javax.persistence.ManyToOne(fetch = FetchType.LAZY)
	@javax.persistence.JoinColumn(name = "NU_TIPO_PESSOA", referencedColumnName = "NU_TIPO_PESSOA")
	private TipoPessoa tipoPessoa;
}