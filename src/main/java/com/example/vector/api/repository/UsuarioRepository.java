package com.example.vector.api.repository;

import java.util.Optional;
import java.lang.Long;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vector.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Optional<Usuario> findByEmail(String email);
}
