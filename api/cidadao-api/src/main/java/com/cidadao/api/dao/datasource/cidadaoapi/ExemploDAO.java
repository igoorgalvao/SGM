package com.cidadao.api.dao.datasource.cidadaoapi;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cidadao.api.entidade.cidadaoapi.Exemplo;

public interface ExemploDAO extends JpaRepository<Exemplo, Long> {

}
