package com.imposto.api.service;

import com.imposto.api.dto.DownloadFileDTO;
import com.imposto.api.dto.GerarImpostoDTO;

public interface IImpostoService {

	DownloadFileDTO gerarImpostoPorTipoPessoa(GerarImpostoDTO dto);

}
