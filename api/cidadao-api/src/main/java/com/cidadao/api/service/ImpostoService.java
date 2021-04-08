package com.cidadao.api.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cidadao.api.core.BusinessException;
import com.cidadao.api.dao.datasource.stur.ImpostoSturDAO;
import com.cidadao.api.dto.DownloadFileDTO;
import com.cidadao.api.dto.GerarImpostoDTO;
import com.cidadao.api.entidade.stur.ImpostoMunicipal;
import com.cidadao.api.enuns.TipoPessoaEnum;

import net.sf.jasperreports.engine.JRParameter;

@Service
@Transactional(readOnly = true)
public class ImpostoService implements IImpostoService {

	Logger logger = LoggerFactory.getLogger(ImpostoService.class);

	@Autowired
	private ImpostoSturDAO dao;

	@Autowired
	private IRelatorioService relatorioService;

	@Autowired
	private MessageSource messageSource;

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public DownloadFileDTO gerarImpostoPorTipoPessoa(GerarImpostoDTO gerarImpostoDTO) {
		DownloadFileDTO dto = new DownloadFileDTO();

		/* Prepara dados para realizar a consulta */
		gerarImpostoDTO.setCepSemMascara(Long.valueOf(gerarImpostoDTO.getCep().replaceAll("\\D+", "")));
		gerarImpostoDTO.setCpfCnpjSemMascara(Long.valueOf(gerarImpostoDTO.getCpfCnpj().replaceAll("\\D+", "")));

		Optional<ImpostoMunicipal> impostoMunicipal = dao.consultarImpostoMunicipal(gerarImpostoDTO);

		if (!impostoMunicipal.isPresent()) {
			throw new BusinessException(messageSource.getMessage("mensagem.campo.obrigatorio", null, LocaleContextHolder.getLocale()));
		}

		if (gerarImpostoDTO.getTipoPessoa().equals(TipoPessoaEnum.RURAL.getId())) {
			dto.setNomeArquivo("ITR.pdf");
		} else {
			dto.setNomeArquivo("IPTU.pdf");
		}

		List<ImpostoMunicipal> lista = new ArrayList<>();
		lista.add(impostoMunicipal.get());

		Map<String, Object> parametros = new HashMap<>();
		parametros.put(JRParameter.REPORT_LOCALE, new Locale("pt", "BR"));

		byte[] bytes = relatorioService.gerarRelatorioPdf("/relatorios/iptu.jasper", parametros, lista);

		dto.setBytes(bytes);
		return dto;

	}

}
