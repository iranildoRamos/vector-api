CREATE TABLE documento (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	numero_oficio BIGINT(50) NOT NULL,
	ano BIGINT(4) NOT NULL,
	descricao VARCHAR(200) NOT NULL,
	nome_solicitante VARCHAR(200),
    data_armazenamento DATETIME NOT NULL

) ENGINE=InnoDB DEFAULT CHARSET=utf8;