-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`users` (
  `id_user` BIGINT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `telephone_number` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `birth_date` DATE NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`categories_products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`categories_products` (
  `id_category_post` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id_category_post`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`products` (
  `id_products` BIGINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `dogo_name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NULL,
  `price` DECIMAL(9,2) NOT NULL,
  `quantity` INT NOT NULL,
  `image_URL` VARCHAR(200) NOT NULL,
  `id_category_product` BIGINT NOT NULL,
  PRIMARY KEY (`id_products`, `id_category_product`),
  UNIQUE INDEX `dogo_name_UNIQUE` (`dogo_name` ASC) VISIBLE,
  INDEX `fk_products_categories_products1_idx` (`id_category_product` ASC) VISIBLE,
  CONSTRAINT `fk_products_categories_products1`
    FOREIGN KEY (`id_category_product`)
    REFERENCES `mydb`.`categories_products` (`id_category_post`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`reviews`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`reviews` (
  `id_review` BIGINT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(150) NOT NULL,
  `rating` INT NOT NULL,
  `date` DATE NOT NULL,
  `validation` TINYINT NOT NULL,
  `id_user` BIGINT NOT NULL,
  PRIMARY KEY (`id_review`),
  INDEX `fk_reviews_users1_idx` (`id_user` ASC) VISIBLE,
  CONSTRAINT `fk_reviews_users1`
    FOREIGN KEY (`id_user`)
    REFERENCES `mydb`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`categories_posts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`categories_posts` (
  `id_category_post` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id_category_post`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`posts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`posts` (
  `id_post` BIGINT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `content` TEXT NOT NULL,
  `date` DATE NOT NULL,
  `id_user` BIGINT NOT NULL,
  `id_category_post` BIGINT NOT NULL,
  PRIMARY KEY (`id_post`, `id_category_post`),
  UNIQUE INDEX `title_UNIQUE` (`title` ASC) VISIBLE,
  INDEX `fk_posts_users1_idx` (`id_user` ASC) VISIBLE,
  INDEX `fk_posts_categories_posts1_idx` (`id_category_post` ASC) VISIBLE,
  CONSTRAINT `fk_posts_users1`
    FOREIGN KEY (`id_user`)
    REFERENCES `mydb`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_posts_categories_posts1`
    FOREIGN KEY (`id_category_post`)
    REFERENCES `mydb`.`categories_posts` (`id_category_post`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`orders` (
  `id_order` BIGINT NOT NULL AUTO_INCREMENT,
  `date_order` TIMESTAMP NOT NULL,
  `id_user` BIGINT NOT NULL,
  `id_review` BIGINT NOT NULL,
  PRIMARY KEY (`id_order`),
  INDEX `fk_orders_users1_idx` (`id_user` ASC) VISIBLE,
  INDEX `fk_orders_reviews1_idx` (`id_review` ASC) VISIBLE,
  CONSTRAINT `fk_orders_users1`
    FOREIGN KEY (`id_user`)
    REFERENCES `mydb`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_reviews1`
    FOREIGN KEY (`id_review`)
    REFERENCES `mydb`.`reviews` (`id_review`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`privileges`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`privileges` (
  `id_privilege` BIGINT NOT NULL AUTO_INCREMENT,
  `privilege` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_privilege`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`users_has_privileges`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`users_has_privileges` (
  `id_user_has_privilage` BIGINT NOT NULL AUTO_INCREMENT,
  `id_user` BIGINT NOT NULL,
  `id_privilege` BIGINT NOT NULL,
  PRIMARY KEY (`id_user_has_privilage`, `id_user`, `id_privilege`),
  INDEX `fk_users_has_privileges_privileges1_idx` (`id_privilege` ASC) VISIBLE,
  INDEX `fk_users_has_privileges_users_idx` (`id_user` ASC) VISIBLE,
  CONSTRAINT `fk_users_has_privileges_users`
    FOREIGN KEY (`id_user`)
    REFERENCES `mydb`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_has_privileges_privileges1`
    FOREIGN KEY (`id_privilege`)
    REFERENCES `mydb`.`privileges` (`id_privilege`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`orders_has_products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`orders_has_products` (
  `id_order_has_product` BIGINT NOT NULL AUTO_INCREMENT,
  `id_order` BIGINT NOT NULL,
  `id_product` BIGINT NOT NULL,
  `amount` INT NOT NULL,
  PRIMARY KEY (`id_order_has_product`, `id_order`, `id_product`),
  INDEX `fk_orders_has_products_products1_idx` (`id_product` ASC) VISIBLE,
  INDEX `fk_orders_has_products_orders1_idx` (`id_order` ASC) VISIBLE,
  CONSTRAINT `fk_orders_has_products_orders1`
    FOREIGN KEY (`id_order`)
    REFERENCES `mydb`.`orders` (`id_order`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_has_products_products1`
    FOREIGN KEY (`id_product`)
    REFERENCES `mydb`.`products` (`id_products`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
