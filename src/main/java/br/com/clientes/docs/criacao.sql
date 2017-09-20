-- MySQL Workbench Synchronization
-- Generated: 2017-09-20 01:24
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: SHD

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

ALTER TABLE `rentcar`.`aluguel` 
DROP FOREIGN KEY `fk_aluguel_carro1`,
DROP FOREIGN KEY `fk_aluguel_cliente1`;

ALTER TABLE `rentcar`.`aluguel` 
DROP COLUMN `cliente`,
DROP COLUMN `carro`,
CHANGE COLUMN `retirada` `retirada` DATETIME NULL DEFAULT NULL ,
CHANGE COLUMN `devolucao` `devolucao` DATETIME NULL DEFAULT NULL ,
CHANGE COLUMN `valor_total` `valor_total` DECIMAL(10,2) NULL DEFAULT NULL ,
ADD COLUMN `carro` INT(11) NOT NULL AFTER `valor_total`,
ADD COLUMN `cliente` INT(11) NOT NULL AFTER `carro`,
ADD INDEX `fk_aluguel_carro1_idx` (`carro` ASC),
ADD INDEX `fk_aluguel_cliente1_idx` (`cliente` ASC),
DROP INDEX `fk_aluguel_cliente1_idx` ,
DROP INDEX `fk_aluguel_carro1_idx` ;

ALTER TABLE `rentcar`.`aluguel` 
ADD CONSTRAINT `fk_aluguel_carro1`
  FOREIGN KEY (`carro`)
  REFERENCES `rentcar`.`carro` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_aluguel_cliente1`
  FOREIGN KEY (`cliente`)
  REFERENCES `rentcar`.`cliente` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
