package com.cidadao.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cidadao.api.entidade.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long> {

}
