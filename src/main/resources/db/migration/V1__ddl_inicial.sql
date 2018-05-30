--
-- Current Database: bd_meuremedio
--
CREATE DATABASE IF NOT EXISTS bd_meuremedio DEFAULT CHARACTER SET utf8;

USE bd_meuremedio;

--
-- Table structure for table tb_comentario
--
DROP TABLE IF EXISTS tb_comentario;
CREATE TABLE tb_comentario (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  comentario longtext NOT NULL,
  data timestamp NOT NULL,
  email varchar(255) NOT NULL,
  faixa_etaria varchar(255) NOT NULL,
  nome varchar(255) NOT NULL,
  sexo varchar(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table tb_laboratorio
--
DROP TABLE IF EXISTS tb_laboratorio;
CREATE TABLE tb_laboratorio (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  cnpj varchar(255) NOT NULL,
  codigo_ggrem varchar(255) DEFAULT NULL,
  ean varchar(255) DEFAULT NULL,
  nome varchar(255) NOT NULL,
  registro varchar(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table tb_medicamento
--
DROP TABLE IF EXISTS tb_medicamento;
CREATE TABLE tb_medicamento (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  apresentacao varchar(255) NOT NULL,
  classe_terapeutica varchar(255) DEFAULT NULL,
  nome varchar(255) NOT NULL,
  preco_consumidor_0 decimal(10,2) DEFAULT NULL,
  preco_consumidor_12 decimal(10,2) DEFAULT NULL,
  preco_consumidor_17 decimal(10,2) DEFAULT NULL,
  preco_consumidor_20 decimal(10,2) DEFAULT NULL,
  preco_fabrica decimal(10,2) NOT NULL,
  principio_ativo varchar(512) NOT NULL,
  restricao_hospitalar bit(1) DEFAULT NULL,
  tarja varchar(255) NOT NULL,
  tipo varchar(255) DEFAULT NULL,
  laboratorio_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FKpewfvli2sqjo2j6n3do5xlgmb (laboratorio_id),
  CONSTRAINT FKpewfvli2sqjo2j6n3do5xlgmb FOREIGN KEY (laboratorio_id) REFERENCES tb_laboratorio (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table tb_denuncia
--
DROP TABLE IF EXISTS tb_denuncia;
CREATE TABLE tb_denuncia (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  data timestamp NOT NULL,
  email varchar(255) DEFAULT NULL,
  farmacia varchar(255) NOT NULL,
  nome varchar(255) DEFAULT NULL,
  preco decimal(10,2) DEFAULT NULL,
  texto varchar(512) DEFAULT NULL,
  medicamento_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK2mkcr1pa72l1voi1u0xs694u (medicamento_id),
  CONSTRAINT FK2mkcr1pa72l1voi1u0xs694u FOREIGN KEY (medicamento_id) REFERENCES tb_medicamento (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
