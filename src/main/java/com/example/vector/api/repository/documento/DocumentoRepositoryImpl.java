package com.example.vector.api.repository.documento;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.example.vector.api.dto.DocumentoDto;
import com.example.vector.api.model.Documento;
import com.example.vector.api.model.Documento_;

public class DocumentoRepositoryImpl implements DocumentoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<DocumentoDto> findDocumento() {

		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();

		CriteriaQuery<DocumentoDto> criteriaQuery = criteriaBuilder.createQuery(DocumentoDto.class);

		Root<Documento> root = criteriaQuery.from(Documento.class);

		criteriaQuery.select(criteriaBuilder.construct(DocumentoDto.class,
				root.get(Documento_.ID),
				root.get(Documento_.NUMERO_OFICIO),
				root.get(Documento_.ANO),
				root.get(Documento_.DESCRICAO),
				root.get(Documento_.NOME_SOLICITANTE),
				root.get(Documento_.DATA_ARMAZENAMENTO)
				));

//		Predicate[] predicates = criarRestricoes(numeroOficio, criteriaBuilder, root);
//		criteriaQuery.where(predicates);

		TypedQuery<DocumentoDto> typedQuery = manager.createQuery(criteriaQuery);

		return typedQuery.getResultList();
	}

	private Predicate[] criarRestricoes(Long numeroOficio, CriteriaBuilder builder, Root<Documento> root) {

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (numeroOficio != null) {
			predicates.add(builder.like(builder.lower(root.get(Documento_.NUMERO_OFICIO)), "%" + numeroOficio + "%"));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
