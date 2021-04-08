package com.imposto.api.dao.datasource.impostoapi;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imposto.api.entidade.impostoapi.Exemplo;

public interface ExemploDAO extends JpaRepository<Exemplo, Long> {

}
