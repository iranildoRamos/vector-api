package com.example.vector.api.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "documento")
public class Documento{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "numero_oficio")
	private Long numeroOficio;

	private Integer ano;
	
	@Column(name = "descricao")
	private String descricao;

	@Column(name = "nome_solicitante")
	private String nomeSolicitante;

	@Column(name = "data_armazenamento")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime dataArmazenamento;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

	public String getDescricao() {
		return descricao;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
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
