package com.cidadao.api.service;

import com.cidadao.api.dto.DownloadFileDTO;
import com.cidadao.api.dto.GerarImpostoDTO;

public interface IImpostoService {

	DownloadFileDTO gerarImpostoPorTipoPessoa(GerarImpostoDTO dto);

}
