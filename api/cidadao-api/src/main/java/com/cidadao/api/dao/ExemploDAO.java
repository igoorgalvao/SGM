package com.cidadao.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cidadao.api.entidade.Exemplo;

public interface ExemploDAO extends JpaRepository<Exemplo, Long> {

}
