package com.example.vector.api.repository.filter;

import java.time.LocalDateTime;
import java.time.Year;
import java.lang.Long;

public class DocumentoFilter {
	
	private Long numeroOficio;
	
	private Year ano;
	
	private String descricao;

	private String nomeSolicitante;
	
	private LocalDateTime dataArmazenamento;

	public Long getNumeroOficio() {
		return numeroOficio;
	}

	public void setNumeroOficio(Long numeroOficio) {
		this.numeroOficio = numeroOficio;
	}

	public Year getAno() {
		return ano;
	}

	public void setAno(Year ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeSolicitante() {
		return nomeSolicitante;
	}

	public void setNomeSolicitante(String nomeSolicitante) {
		this.nomeSolicitante = nomeSolicitante;
	}

	public LocalDateTime getDataArmazenamento() {
		return dataArmazenamento;
	}

	public void setDataArmazenamento(LocalDateTime dataArmazenamento) {
		this.dataArmazenamento = dataArmazenamento;
	}
	
}
