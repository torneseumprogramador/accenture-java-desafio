package com.gama.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gama.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	boolean existsByLogin(String login);
}
