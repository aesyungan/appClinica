package com.ayungan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayungan.model.Usuario;

@Repository
public interface IUsuarioDAO extends JpaRepository<Usuario, Integer> {
	//spring crea automaticamente los query solo toca poner findOneBy_campo
	Usuario findOneByUsername(String username);
}
