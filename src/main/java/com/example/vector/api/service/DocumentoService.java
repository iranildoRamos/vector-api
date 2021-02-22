package com.example.vector.api.service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.lang.Long;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.vector.api.dto.DocumentoDto;
import com.example.vector.api.model.Documento;
import com.example.vector.api.repository.DocumentoRepository;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class DocumentoService {

//	private String caminhoJasper = "C:\\Users\\thais\\Documents\\workspace-spring-tool-suite-4-4.6.2.RELEASE\\vector-api\\src\\main\\resources\\oficios\\documento.jasper";
	private String caminhoJasper2= "/oficios/documento.jasper";
	
	@Autowired
	private DocumentoRepository documentoRepository;

	public byte[] gerarDocumentoDto() throws Exception {
		List<DocumentoDto> dados = documentoRepository.findDocumento();

		Map<String, Object> parametros = new HashMap<>();
		
		parametros.put("REPORT LOCALE", new Locale("pt", "BR"));

		InputStream inputStream = this.getClass().getResourceAsStream(caminhoJasper2);

		JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parametros,
				new JRBeanCollectionDataSource(dados));

		return JasperExportManager.exportReportToPdf(jasperPrint);
	}

	public Documento atualizar(Long id, Documento documento) {
		Documento documentoSalvo = this.documentoRepository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));

		BeanUtils.copyProperties(documento, documentoSalvo, "id");

		return documentoRepository.save(documentoSalvo);
	}

}
