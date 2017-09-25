-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema rentcar
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `rentcar` ;

-- -----------------------------------------------------
-- Schema rentcar
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rentcar` DEFAULT CHARACTER SET utf8 ;
USE `rentcar` ;

-- -----------------------------------------------------
-- Table `rentcar`.`bairro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentcar`.`bairro` ;

CREATE TABLE IF NOT EXISTS `rentcar`.`bairro` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rentcar`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentcar`.`cliente` ;

CREATE TABLE IF NOT EXISTS `rentcar`.`cliente` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(11) NOT NULL,
  `endereco` VARCHAR(150) NOT NULL,
  `cidade` VARCHAR(100) NOT NULL,
  `bairro` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cliente_bairro_idx` (`bairro` ASC),
  CONSTRAINT `fk_cliente_bairro`
    FOREIGN KEY (`bairro`)
    REFERENCES `rentcar`.`bairro` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rentcar`.`locadora`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentcar`.`locadora` ;

CREATE TABLE IF NOT EXISTS `rentcar`.`locadora` (
  `id` INT(11) NOT NULL,
  `nome` VARCHAR(45) NULL,
  `endereco` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rentcar`.`carro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentcar`.`carro` ;

CREATE TABLE IF NOT EXISTS `rentcar`.`carro` (
  `id` INT(11) NOT NULL,
  `marca` VARCHAR(100) NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `placa` VARCHAR(10) NOT NULL,
  `chassi` VARCHAR(45) NULL,
  `ano` INT(4) NOT NULL,
  `locadora` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_carro_locadora1_idx` (`locadora` ASC),
  CONSTRAINT `fk_carro_locadora1`
    FOREIGN KEY (`locadora`)
    REFERENCES `rentcar`.`locadora` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rentcar`.`aluguel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentcar`.`aluguel` ;

CREATE TABLE IF NOT EXISTS `rentcar`.`aluguel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `carro` INT(11) NOT NULL,
  `cliente` INT(11) NOT NULL,
  `retirada` DATETIME NOT NULL,
  `devolucao` DATETIME NOT NULL,
  `valor_total` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_aluguel_carro1_idx` (`carro` ASC),
  INDEX `fk_aluguel_cliente1_idx` (`cliente` ASC),
  CONSTRAINT `fk_aluguel_carro1`
    FOREIGN KEY (`carro`)
    REFERENCES `rentcar`.`carro` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluguel_cliente1`
    FOREIGN KEY (`cliente`)
    REFERENCES `rentcar`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
