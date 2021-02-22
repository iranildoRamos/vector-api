package com.example.vector.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.vector.api.event.RecursoCriadoEvent;
import com.example.vector.api.model.Usuario;
import com.example.vector.api.repository.UsuarioRepository;
import com.example.vector.api.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_USUARIO') and #oauth2.hasScope('read')")
	public List<Usuario> listar(){
		return usuarioRepository.findAll();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_USUARIO') and #oauth2.hasScope('write')")
	public void remover(@PathVariable Long id) {
	    Usuario usuario = new Usuario();
	    usuario.setId(id);
	    this.usuarioRepository.delete(usuario);
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_USUARIO') and #oauth2.hasScope('write')")
	public ResponseEntity<Usuario> criar(@Validated @RequestBody Usuario usuario, HttpServletResponse response) {
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_USUARIO') and #oauth2.hasScope('write')")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id,@Validated @RequestBody Usuario usuario) {
		Usuario usuarioSalvo = usuarioService.atualizar(id, usuario);
		return ResponseEntity.ok(usuarioSalvo);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_USUARIO') and #oauth2.hasScope('read')")
	public Usuario buscarPeloId(@PathVariable Long id) {
		 return this.usuarioRepository.findById(id).orElse(null);
		 // return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
	}
	
}
