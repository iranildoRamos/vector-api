package com.example.vector.api.repository.documento;

import java.util.List;

import com.example.vector.api.dto.DocumentoDto;

public interface DocumentoRepositoryQuery {
	public List<DocumentoDto> findDocumento();
}
