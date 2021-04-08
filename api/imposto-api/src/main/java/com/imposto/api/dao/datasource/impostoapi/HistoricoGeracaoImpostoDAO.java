package com.imposto.api.dao.datasource.impostoapi;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imposto.api.entidade.impostoapi.Exemplo;
import com.imposto.api.entidade.impostoapi.HistoricoGeracaoImposto;

public interface HistoricoGeracaoImpostoDAO extends JpaRepository<HistoricoGeracaoImposto, Long> {

}
