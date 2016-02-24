-- MySQL dump 10.13  Distrib 5.6.24, for osx10.8 (x86_64)
--
-- Host: localhost    Database: Application
-- ------------------------------------------------------
-- Server version	5.6.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Customer` (
  `fName` varchar(45) DEFAULT NULL,
  `lName` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL DEFAULT '',
  `password` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `reason` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
INSERT INTO `Customer` VALUES ('mirza','mirza','muhd','mirza','cck','','active');
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Elderly`
--

DROP TABLE IF EXISTS `Elderly`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Elderly` (
  `accPassword` varchar(20) NOT NULL,
  `accStatus` varchar(45) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `elderlyID` varchar(45) NOT NULL,
  `phoneNum` int(11) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  PRIMARY KEY (`elderlyID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Elderly`
--

LOCK TABLES `Elderly` WRITE;
/*!40000 ALTER TABLE `Elderly` DISABLE KEYS */;
INSERT INTO `Elderly` VALUES ('123','active','andy','ng','122323',32321313,'Male','cssdc'),('123','active','tr','s','123',1,'Female','t'),('23123','active','andy','ng','2323424',4928734,'Male','tpy'),('123','active','andy','ng','297064402',12121323,'Male','tge'),('999','active','mary','tan','999',12345678,'Female','nyp'),('123','active','andy','ng','s12345678a',123,'Male','tpy');
/*!40000 ALTER TABLE `Elderly` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PurchasedProductDetail`
--

DROP TABLE IF EXISTS `PurchasedProductDetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PurchasedProductDetail` (
  `productName` varchar(45) NOT NULL,
  `category` varchar(45) NOT NULL,
  `quantity` int(11) NOT NULL,
  `productUnitPrice` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PurchasedProductDetail`
--

LOCK TABLES `PurchasedProductDetail` WRITE;
/*!40000 ALTER TABLE `PurchasedProductDetail` DISABLE KEYS */;
INSERT INTO `PurchasedProductDetail` VALUES ('Mat','Home Accessories',50,50),('Brush','Home Accessories',50,20),('Camera lens','Photography',50,200),('Shampoo','Home Accessories',50,20);
/*!40000 ALTER TABLE `PurchasedProductDetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productdetails`
--

DROP TABLE IF EXISTS `productdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productdetails` (
  `productName` varchar(45) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `productUnitPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productdetails`
--

LOCK TABLES `productdetails` WRITE;
/*!40000 ALTER TABLE `productdetails` DISABLE KEYS */;
INSERT INTO `productdetails` VALUES ('Mat','Home Accessories',50,50),('Brush','Home Accessories',50,20),('Nutella','Food',50,10),('Wax','Home Accessories',50,5),('Camera lens','Photography',50,200),('Shampoo','Home Accessories',50,20),('pencil','stationery',55,2);
/*!40000 ALTER TABLE `productdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES ('staff1','staffpassword'),('staff2','staffpassword2');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workshop`
--

DROP TABLE IF EXISTS `workshop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workshop` (
  `wsId` int(110) NOT NULL,
  `wsTitle` varchar(45) DEFAULT NULL,
  `wsDescription` varchar(100) DEFAULT NULL,
  `wsDate` varchar(45) DEFAULT NULL,
  `wsVenue` varchar(45) DEFAULT NULL,
  `sTime` varchar(45) DEFAULT NULL,
  `eTime` varchar(45) DEFAULT NULL,
  `closingRegDate` varchar(45) DEFAULT NULL,
  `maxCap` int(30) DEFAULT NULL,
  PRIMARY KEY (`wsId`),
  UNIQUE KEY `wsId_UNIQUE` (`wsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workshop`
--

LOCK TABLES `workshop` WRITE;
/*!40000 ALTER TABLE `workshop` DISABLE KEYS */;
INSERT INTO `workshop` VALUES (0,'Computer programming','Training to be coders','15/12/2015','Ang Mo Kio','1200','1400','10/12/2015',30),(1,'Art & Craft','To learn and create art masterpieces through admiring and applying techniques of art and craft','14/12/2015','Ang Mo Kio Community Club Auditorium','1200','1400','14/11/2015',30),(2,'Clay Pottery Craft','To craft pottery out of clay into beautiful work of art using pottery machines.','10/12/2015','Seng Kang Community Club Auditorium','1200','1500','10/11/2015',25),(3,'Kite Making','Learn to make kites out of materials that are light-weight, suitable for kites to minimise air drag.','1/2/2016','Seng Kang Community Club Auditorium','1200','1500','30/12/2015',20),(4,'Cloth Sewing','Learn to sew using sewing machine to make variety of brand-new clothings. ','5/4/2016','Choa Chu Kang Community Club Auditorium','1400','1600','03/02//2015',35),(5,'Wood Crafting','Craft simple furnitures out of wooden materials.','20/4/2016','Hougang Community Club Auditorium','1300','1400','05/03//2015',25),(7,'reading','reading a book','12/5/15','Choa Chu Kang community centre','1200','1300','10/5/2015',30);
/*!40000 ALTER TABLE `workshop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workshopregistration`
--

DROP TABLE IF EXISTS `workshopregistration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workshopregistration` (
  `nric` varchar(45) NOT NULL,
  `fName` varchar(45) DEFAULT NULL,
  `emailAdd` varchar(45) DEFAULT NULL,
  `mNo` varchar(45) DEFAULT NULL,
  `hNo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nric`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workshopregistration`
--

LOCK TABLES `workshopregistration` WRITE;
/*!40000 ALTER TABLE `workshopregistration` DISABLE KEYS */;
INSERT INTO `workshopregistration` VALUES ('s','s','s','s','s'),('S8695992i','zahid','zahid@gmail.com','83624573','64573382');
/*!40000 ALTER TABLE `workshopregistration` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-11  2:05:10
