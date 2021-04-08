package com.imposto.api.entidade.stur;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "IMPOSTO_MUNICIPAL", schema = "STUR_IMPOSTO")
@Data
@Builder(builderClassName = "Builder")
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
public class ImpostoMunicipal {

	@Id
	@Column(name = "NU_IMPOSTO_MUNICIPAL")
	private Long id;

	@javax.persistence.ManyToOne(fetch = FetchType.LAZY)
	@javax.persistence.JoinColumn(name = "NU_PAGADOR", referencedColumnName = "NU_PAGADOR")
	private Pagador pagador;

	@Column(name = "NU_CEP")
	private Long cep;

	@Column(name = "NU_RESIDENCIA")
	private String numero;

	@Column(name = "VL_DOCUMENTO")
	private BigDecimal valorDocumento;

	@Column(name = "VL_MULTA")
	private BigDecimal valorMulta;

	@Temporal(TemporalType.DATE)
	@javax.persistence.Column(name = "DT_VENCIMENTO")
	private Date dataVencimento;

	@Temporal(TemporalType.TIMESTAMP)
	@javax.persistence.Column(name = "DT_GERACAO")
	private Date dataGeracao;

}