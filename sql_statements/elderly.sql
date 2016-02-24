CREATE TABLE `Application`.`Elderly` (
  `accPassword` VARCHAR(20) NOT NULL COMMENT '',
  `accStatus` VARCHAR(45) NOT NULL COMMENT '',
  `fname` VARCHAR(45) NOT NULL COMMENT '',
  `lname` VARCHAR(45) NOT NULL COMMENT '',
  `elderlyID` VARCHAR(45) NOT NULL COMMENT '',
  `phoneNum` INT NOT NULL COMMENT '',
  `gender` VARCHAR(45) NOT NULL COMMENT '',
  `address` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`elderlyID`)  COMMENT '');
