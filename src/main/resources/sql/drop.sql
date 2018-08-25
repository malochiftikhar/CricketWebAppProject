-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema cricketprojectdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `cricketprojectdb` ;

-- -----------------------------------------------------
-- Schema cricketprojectdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cricketprojectdb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Player` (
  `player_ID` INT NOT NULL,
  `first_name` VARCHAR(55) NOT NULL,
  `last_name` VARCHAR(55) NOT NULL,
  `dob` DATE NULL,
  `postcode` VARCHAR(14) NULL,
  PRIMARY KEY (`player_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Account` (
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `profile_picture` BLOB NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`club`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`club` (
  `club_ID` INT NOT NULL,
  `club_name` VARCHAR(55) NULL,
  `phone_number` VARCHAR(20) NULL,
  PRIMARY KEY (`club_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Location` (
  `location_ID` INT NOT NULL,
  `country` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `postcode` VARCHAR(14) NULL,
  `property_number` INT NULL,
  PRIMARY KEY (`location_ID`))
ENGINE = InnoDB;

USE `cricketprojectdb` ;

-- -----------------------------------------------------
-- Table `cricketprojectdb`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cricketprojectdb`.`address` (
  `postcode` VARCHAR(45) NOT NULL,
  `street_name` VARCHAR(45) NULL DEFAULT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`postcode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cricketprojectdb`.`club`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cricketprojectdb`.`club` (
  `club_id` INT(11) NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `phone_number` VARCHAR(45) NULL DEFAULT NULL,
  `address1` VARCHAR(45) NULL DEFAULT NULL,
  `fk_postcode` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`club_id`),
  INDEX `fk_clubPostcode_idx` (`fk_postcode` ASC),
  CONSTRAINT `fk_clubPostcode`
    FOREIGN KEY (`fk_postcode`)
    REFERENCES `cricketprojectdb`.`address` (`postcode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cricketprojectdb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cricketprojectdb`.`user` (
  `user_id` INT(11) NOT NULL,
  `fname` VARCHAR(45) NULL DEFAULT NULL,
  `lname` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `dob` DATE NULL DEFAULT NULL,
  `fk_club_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  INDEX `fk_userClub_idx` (`fk_club_id` ASC),
  CONSTRAINT `fk_userClub`
    FOREIGN KEY (`fk_club_id`)
    REFERENCES `cricketprojectdb`.`club` (`club_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cricketprojectdb`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cricketprojectdb`.`product` (
  `product_id` INT(11) NOT NULL,
  `price` INT(11) NULL DEFAULT NULL,
  `product_name` VARCHAR(45) NULL DEFAULT NULL,
  `seller_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  INDEX `fk_productSeller_idx` (`seller_id` ASC),
  CONSTRAINT `fk_productSeller`
    FOREIGN KEY (`seller_id`)
    REFERENCES `cricketprojectdb`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cricketprojectdb`.`chat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cricketprojectdb`.`chat` (
  `chat_id` INT(11) NOT NULL,
  `fk_seller_id` INT(11) NULL DEFAULT NULL,
  `fk_buyer_id` INT(11) NULL DEFAULT NULL,
  `message_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`chat_id`),
  INDEX `fk_sellerChat_idx` (`fk_seller_id` ASC),
  INDEX `fk_buyerChat_idx` (`fk_buyer_id` ASC),
  CONSTRAINT `fk_buyerChat`
    FOREIGN KEY (`fk_buyer_id`)
    REFERENCES `cricketprojectdb`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sellerChat`
    FOREIGN KEY (`fk_seller_id`)
    REFERENCES `cricketprojectdb`.`product` (`seller_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
