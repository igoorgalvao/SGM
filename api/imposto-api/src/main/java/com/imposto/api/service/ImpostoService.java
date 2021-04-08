package com.imposto.api.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.imposto.api.core.BusinessException;
import com.imposto.api.dao.datasource.impostoapi.HistoricoGeracaoImpostoDAO;
import com.imposto.api.dao.datasource.stur.ImpostoSturDAO;
import com.imposto.api.dto.BoletoImpostoDTO;
import com.imposto.api.dto.DownloadFileDTO;
import com.imposto.api.dto.GerarImpostoDTO;
import com.imposto.api.entidade.impostoapi.HistoricoGeracaoImposto;
import com.imposto.api.entidade.stur.ImpostoMunicipal;
import com.imposto.api.enuns.TipoPessoaEnum;

import net.sf.jasperreports.engine.JRParameter;

@Service
@Transactional(readOnly = true)
public class ImpostoService implements IImpostoService {

	Logger logger = LoggerFactory.getLogger(ImpostoService.class);

	@Autowired
	private ImpostoSturDAO dao;

	@Autowired
	private HistoricoGeracaoImpostoDAO historicoGeracaoImpostoDAO;

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

		List<BoletoImpostoDTO> lista = new ArrayList<>();

		// @formatter:off
		lista.add(BoletoImpostoDTO.builder()
				.pagador(impostoMunicipal.get().getPagador().getNomePagador())
				.cep(impostoMunicipal.get().getCep().toString())
				.dataGeracao(new SimpleDateFormat("dd/MM/yyyy").format(impostoMunicipal.get().getDataGeracao()))
				.dataVencimento(new SimpleDateFormat("dd/MM/yyyy").format(impostoMunicipal.get().getDataVencimento()))
				.multa(impostoMunicipal.get().getValorMulta())
				.valor(impostoMunicipal.get().getValorDocumento())
				.build());
		// @formatter:on

		Map<String, Object> parametros = new HashMap<>();
		parametros.put(JRParameter.REPORT_LOCALE, new Locale("pt", "BR"));

		byte[] bytes = null;
		if (gerarImpostoDTO.getTipoPessoa().equals(TipoPessoaEnum.RURAL.getId())) {
			bytes = relatorioService.gerarRelatorioPdf("/relatorios/itr.jasper", parametros, lista);
		} else {
			bytes = relatorioService.gerarRelatorioPdf("/relatorios/iptu.jasper", parametros, lista);
		}
		dto.setBytes(bytes);

		// @formatter:off
		HistoricoGeracaoImposto hstSave = HistoricoGeracaoImposto.builder()
											.idImpostoMunicipal(impostoMunicipal.get().getId())
											.usuarioAcesso(gerarImpostoDTO.getUsuarioAcesso())
											.dataGeracao(new Date())
											.documentoGerado(bytes)
											.build();
		// @formatter:on\s

		/* Salva historico de geração de documento */
		historicoGeracaoImpostoDAO.save(hstSave);

		return dto;

	}

}
