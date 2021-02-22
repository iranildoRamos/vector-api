package com.example.vector.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.example.vector.api.model.Documento;
import com.example.vector.api.repository.DocumentoRepository;
import com.example.vector.api.service.DocumentoService;

@RestController
@RequestMapping("/documentos")
public class DocumentoResource {
	
	@Autowired
	private DocumentoRepository documentoRepository;
	
	@Autowired
	private DocumentoService documentoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_DOCUMENTO') and #oauth2.hasScope('read')")
	public List<Documento> listar(){
		return documentoRepository.findAll();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_DOCUMENTO') and #oauth2.hasScope('write')")
	public void remover(@PathVariable Long id) {
	    Documento documento = new Documento();
	    documento.setId(id);
	    this.documentoRepository.delete(documento);
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_DOCUMENTO') and #oauth2.hasScope('write')")
	public ResponseEntity<Documento> criar(@Validated @RequestBody Documento documento, HttpServletResponse response) {
		Documento documentoSalvo = documentoRepository.save(documento);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, documentoSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(documentoSalvo);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_DOCUMENTO') and #oauth2.hasScope('write')")
	public ResponseEntity<Documento> atualizar(@PathVariable Long id, @Validated @RequestBody Documento documento) {
		Documento documentoSalvo = documentoService.atualizar(id, documento);
		return ResponseEntity.ok(documentoSalvo);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_DOCUMENTO') and #oauth2.hasScope('read')")
	public Documento buscarPeloId(@PathVariable Long id) {
		 return this.documentoRepository.findById(id).orElse(null);
		 // return documento != null ? ResponseEntity.ok(documento) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/por-oficio")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_DOCUMENTO') and #oauth2.hasScope('read')")
	public ResponseEntity<byte[]> documentoPorNumeroOficio() throws Exception{
		byte[] documento = documentoService.gerarDocumentoDto();
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
				.body(documento);
	}
}

