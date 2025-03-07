-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema 2827_tienda
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema 2827_tienda
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `2827_tienda` DEFAULT CHARACTER SET utf8mb4 ;
USE `2827_tienda` ;

-- -----------------------------------------------------
-- Table `2827_tienda`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `2827_tienda`.`productos` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `precio` DECIMAL(19,2) NOT NULL,
  `caducidad` DATE NULL,
  `descripcion` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `2827_tienda`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `2827_tienda`.`clientes` (
  `id` BIGINT NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `nif` CHAR(9) NOT NULL,
  `nif_diferencial` TINYINT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nif_con_diferencial` (`nif` ASC, `nif_diferencial` ASC) INVISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `2827_tienda`.`empleados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `2827_tienda`.`empleados` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `jefe_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_empleados_empleados1_idx` (`jefe_id` ASC) VISIBLE,
  CONSTRAINT `fk_empleados_empleados1`
    FOREIGN KEY (`jefe_id`)
    REFERENCES `2827_tienda`.`empleados` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `2827_tienda`.`facturas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `2827_tienda`.`facturas` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `numero` CHAR(14) NOT NULL COMMENT 'numero: SERV-2025-0001',
  `fecha` DATE NOT NULL,
  `clientes_id` BIGINT NOT NULL,
  `empleados_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `numero_UNIQUE` (`numero` ASC) VISIBLE,
  INDEX `fk_facturas_clientes_idx` (`clientes_id` ASC) VISIBLE,
  INDEX `fk_facturas_empleados1_idx` (`empleados_id` ASC) VISIBLE,
  CONSTRAINT `fk_facturas_clientes`
    FOREIGN KEY (`clientes_id`)
    REFERENCES `2827_tienda`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_facturas_empleados1`
    FOREIGN KEY (`empleados_id`)
    REFERENCES `2827_tienda`.`empleados` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `2827_tienda`.`facturas_tienen_productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `2827_tienda`.`facturas_tienen_productos` (
  `facturas_id` BIGINT NOT NULL,
  `productos_id` BIGINT NOT NULL,
  `cantidad` INT NOT NULL,
  PRIMARY KEY (`facturas_id`, `productos_id`),
  INDEX `fk_facturas_tiene_productos_productos1_idx` (`productos_id` ASC) VISIBLE,
  INDEX `fk_facturas_tiene_productos_facturas1_idx` (`facturas_id` ASC) VISIBLE,
  CONSTRAINT `fk_facturas_tiene_productos_facturas1`
    FOREIGN KEY (`facturas_id`)
    REFERENCES `2827_tienda`.`facturas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_facturas_tiene_productos_productos1`
    FOREIGN KEY (`productos_id`)
    REFERENCES `2827_tienda`.`productos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `2827_tienda`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `2827_tienda`.`usuarios` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `clientes_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_usuarios_clientes1_idx` (`clientes_id` ASC) VISIBLE,
  CONSTRAINT `fk_usuarios_clientes1`
    FOREIGN KEY (`clientes_id`)
    REFERENCES `2827_tienda`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `2827_tienda`.`hoteles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `2827_tienda`.`hoteles` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `2827_tienda`.`habitaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `2827_tienda`.`habitaciones` (
  `hoteles_id` BIGINT NOT NULL,
  `numero` CHAR(3) NOT NULL,
  PRIMARY KEY (`numero`, `hoteles_id`),
  CONSTRAINT `fk_habitaciones_hoteles1`
    FOREIGN KEY (`hoteles_id`)
    REFERENCES `2827_tienda`.`hoteles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
