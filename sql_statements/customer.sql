CREATE TABLE `Application`.`Customer` (
  `fName` VARCHAR(45) NULL COMMENT '',
  `lName` VARCHAR(45) NULL COMMENT '',
  `username` VARCHAR(45) NULL COMMENT '',
  `password` VARCHAR(45) NULL COMMENT '',
  `address` VARCHAR(45) NULL COMMENT '',
  `reason` VARCHAR(45) NULL COMMENT '',
  `status` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`username`)  COMMENT '',
  UNIQUE INDEX `username_UNIQUE` (`username` ASC)  COMMENT '');
