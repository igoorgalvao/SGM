package com.cidadao.api.service;

import java.util.Collection;
import java.util.Map;

public interface IRelatorioService {

	byte[] gerarRelatorioPdf(String caminhoRelatorio, Map<String, Object> parametros, Collection dados);

	byte[] gerarRelatorioPdf(String caminhoRelatorio, Map<String, Object> parametros, Collection dados, String nomeRelatorio);

}
