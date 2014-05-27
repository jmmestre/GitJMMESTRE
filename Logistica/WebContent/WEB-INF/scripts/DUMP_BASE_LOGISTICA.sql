-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.6.17 - MySQL Community Server (GPL)
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura do banco de dados para logistica
CREATE DATABASE IF NOT EXISTS `logistica` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `logistica`;


-- Copiando estrutura para tabela logistica.cidade
CREATE TABLE IF NOT EXISTS `cidade` (
  `ID_CIDADE` int(11) NOT NULL AUTO_INCREMENT,
  `NM_CIDADE` varchar(100) NOT NULL,
  UNIQUE KEY `NM_CIDADE` (`NM_CIDADE`),
  KEY `ID_CIDADE` (`ID_CIDADE`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela logistica.cidade: ~10 rows (aproximadamente)
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
INSERT INTO `cidade` (`ID_CIDADE`, `NM_CIDADE`) VALUES
	(1, 'Araçoiaba'),
	(2, 'Sorocaba'),
	(3, 'Itu'),
	(4, 'Mairinque'),
	(5, 'São Roque'),
	(6, 'Barueri'),
	(7, 'São Paulo'),
	(8, 'Campinas'),
	(9, 'Santos'),
	(10, 'IlhaBela');
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;


-- Copiando estrutura para tabela logistica.rota
CREATE TABLE IF NOT EXISTS `rota` (
  `ID_ROTA` int(11) NOT NULL AUTO_INCREMENT,
  `ID_ORIGEM` int(11) NOT NULL,
  `ID_DESTINO` int(11) NOT NULL,
  `NR_DISTANCIA` int(11) NOT NULL,
  PRIMARY KEY (`ID_ROTA`),
  KEY `FK_ORIGEM_CIDADE` (`ID_ORIGEM`),
  KEY `FK_DESTINO_CIDADE` (`ID_DESTINO`),
  CONSTRAINT `FK_DESTINO_CIDADE` FOREIGN KEY (`ID_DESTINO`) REFERENCES `cidade` (`ID_CIDADE`),
  CONSTRAINT `FK_ORIGEM_CIDADE` FOREIGN KEY (`ID_ORIGEM`) REFERENCES `cidade` (`ID_CIDADE`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela logistica.rota: ~14 rows (aproximadamente)
/*!40000 ALTER TABLE `rota` DISABLE KEYS */;
INSERT INTO `rota` (`ID_ROTA`, `ID_ORIGEM`, `ID_DESTINO`, `NR_DISTANCIA`) VALUES
	(1, 1, 2, 15),
	(2, 2, 3, 30),
	(3, 3, 4, 25),
	(4, 4, 5, 18),
	(5, 5, 6, 10),
	(6, 6, 7, 8),
	(7, 7, 8, 70),
	(8, 8, 9, 140),
	(9, 9, 10, 90),
	(10, 2, 7, 90),
	(11, 2, 6, 80),
	(12, 2, 4, 30),
	(13, 4, 7, 12),
	(14, 1, 7, 60);
/*!40000 ALTER TABLE `rota` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
