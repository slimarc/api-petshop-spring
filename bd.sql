-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema petshop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema petshop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `petshop` DEFAULT CHARACTER SET utf8 ;
USE `petshop` ;

-- -----------------------------------------------------
-- Table `petshop`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petshop`.`Cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `tel` VARCHAR(20) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `petshop`.`Animal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petshop`.`Animal` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Cliente_id` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `idade` INT NULL,
  `peso` DOUBLE NULL,
  INDEX `fk_table2_Cliente_idx` (`Cliente_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_table2_Cliente`
    FOREIGN KEY (`Cliente_id`)
    REFERENCES `petshop`.`Cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `petshop`.`OrdemServico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petshop`.`OrdemServico` (
  `num_ordem` INT NOT NULL AUTO_INCREMENT,
  `valor` DOUBLE NULL,
  `hora_entrada` TIMESTAMP NULL,
  `hora_saida` TIMESTAMP NULL,
  `Animal_id` INT NOT NULL,
  PRIMARY KEY (`num_ordem`),
  INDEX `fk_OrdemServico_Animal1_idx` (`Animal_id` ASC) VISIBLE,
  CONSTRAINT `fk_OrdemServico_Animal1`
    FOREIGN KEY (`Animal_id`)
    REFERENCES `petshop`.`Animal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
