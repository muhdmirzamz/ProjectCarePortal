CREATE TABLE `proddb`.`inventory` (
  `id` INT NOT NULL,
  `quantity` INT NULL,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));
