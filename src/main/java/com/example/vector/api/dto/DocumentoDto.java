package com.example.vector.api.dto;

import java.time.LocalDateTime;

public class DocumentoDto {

	private Long id;

	private Long numeroOficio;

	private Integer ano;
	
	private String descricao;

	private String nomeSolicitante;

	private LocalDateTime dataArmazenamento;

	public DocumentoDto(Long id, Long numeroOficio, Integer ano, String descricao, String nomeSolicitante,
			LocalDateTime dataArmazenamento) {
		this.id = id;
		this.numeroOficio = numeroOficio;
		this.ano = ano;
		this.descricao = descricao;
		this.nomeSolicitante = nomeSolicitante;
		this.dataArmazenamento = dataArmazenamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeroOficio() {
		return numeroOficio;
	}

	public void setNumeroOficio(Long numeroOficio) {
		this.numeroOficio = numeroOficio;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
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
