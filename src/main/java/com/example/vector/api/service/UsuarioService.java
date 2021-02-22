package com.example.vector.api.service;

import java.lang.Long;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.vector.api.model.Usuario;
import com.example.vector.api.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario atualizar(Long id, Usuario usuario) {
		Usuario usuarioSalvo = this.usuarioRepository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));

		BeanUtils.copyProperties(usuario, usuarioSalvo, "id");

		return usuarioRepository.save(usuarioSalvo);
	}
	
}
