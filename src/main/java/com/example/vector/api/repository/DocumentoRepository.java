package com.example.vector.api.repository;

import java.util.Optional;
import java.lang.Long;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vector.api.model.Documento;
import com.example.vector.api.repository.documento.DocumentoRepositoryQuery;

public interface DocumentoRepository extends JpaRepository<Documento, Long>, DocumentoRepositoryQuery{
	
	public Optional<Documento> findByNomeSolicitante(String nomeDosolicitante);
}
