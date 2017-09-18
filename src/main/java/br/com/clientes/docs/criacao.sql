-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.7.19-log - MySQL Community Server (GPL)
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura do banco de dados para clientes
DROP DATABASE IF EXISTS `clientes`;
CREATE DATABASE IF NOT EXISTS `clientes` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `clientes`;


-- Copiando estrutura para tabela clientes.bairro
DROP TABLE IF EXISTS `bairro`;
CREATE TABLE IF NOT EXISTS `bairro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela clientes.bairro: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `bairro` DISABLE KEYS */;
INSERT INTO `bairro` (`id`, `nome`) VALUES
	(1, 'Campina de Icoaraci'),
	(2, 'Cruzeiro'),
	(3, 'Jurunas'),
	(4, 'Castanheira'),
	(5, 'Pratinha'),
	(6, 'Guamá'),
	(7, 'Guanabara');
/*!40000 ALTER TABLE `bairro` ENABLE KEYS */;


-- Copiando estrutura para tabela clientes.cliente
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `endereco` varchar(150) NOT NULL,
  `cidade` varchar(100) NOT NULL,
  `bairro` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cliente_bairro_idx` (`bairro`),
  CONSTRAINT `fk_cliente_bairro` FOREIGN KEY (`bairro`) REFERENCES `bairro` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela clientes.cliente: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`id`, `nome`, `telefone`, `endereco`, `cidade`, `bairro`) VALUES
	(1, 'José Maria', '91985741450', 'Rua Sgto Resende', 'Belém', 1),
	(3, 'João Paulo', '91996857414', 'Berredos', 'Belém', 7);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
