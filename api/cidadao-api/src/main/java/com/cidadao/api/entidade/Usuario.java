package com.cidadao.api.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "USUARIO", schema = "CIDADAO")
@Data
@Builder(builderClassName = "Builder")
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Long id;

	@Column(name = "NOME_USUARIO")
	private String nome;

}
