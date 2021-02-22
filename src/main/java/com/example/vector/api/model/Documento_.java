package com.example.vector.api.model;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Documento.class)
public abstract class Documento_ {

	public static volatile SingularAttribute<Documento, Integer> ano;
	public static volatile SingularAttribute<Documento, LocalDateTime> dataArmazenamento;
	public static volatile SingularAttribute<Documento, Long> numeroOficio;
	public static volatile SingularAttribute<Documento, String> nomeSolicitante;
	public static volatile SingularAttribute<Documento, Long> id;
	public static volatile SingularAttribute<Documento, String> descricao;

	public static final String ANO = "ano";
	public static final String DATA_ARMAZENAMENTO = "dataArmazenamento";
	public static final String NUMERO_OFICIO = "numeroOficio";
	public static final String NOME_SOLICITANTE = "nomeSolicitante";
	public static final String ID = "id";
	public static final String DESCRICAO = "descricao";

}

