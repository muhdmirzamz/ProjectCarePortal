CREATE TABLE `Application`.`productdetails` (
  `productId` INT NULL,
  `productName` VARCHAR(45) NULL,
  `category` VARCHAR(45) NULL,
  `quantity` DOUBLE NULL,
  `productUnitPrice` DOUBLE NULL,
  PRIMARY KEY (`productId`),
  UNIQUE INDEX `productId_UNIQUE` (`productId` ASC));
