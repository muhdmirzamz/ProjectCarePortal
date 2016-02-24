-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bambang_default
-- ------------------------------------------------------
-- Server version	5.6.22-log

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
INSERT INTO `workshop` VALUES (1,'Art & Craft','To learn and create art masterpieces through admiring and applying techniques of art and craft','14/12/2015','Ang Mo Kio Community Club Auditorium','1200','1400','14/11/2015',30),(2,'Clay Pottery Craft','To craft pottery out of clay into beautiful work of art using pottery machines.','10/12/2015','Seng Kang Community Club Auditorium','1200','1500','10/11/2015',25),(3,'Kite Making','Learn to make kites out of materials that are light-weight, suitable for kites to minimise air drag.','1/2/2016','Seng Kang Community Club Auditorium','1200','1500','30/12/2015',20),(4,'Cloth Sewing','Learn to sew using sewing machine to make variety of brand-new clothings. ','5/4/2016','Choa Chu Kang Community Club Auditorium','1400','1600','03/02//2015',35),(5,'Wood Crafting','Craft simple furnitures out of wooden materials.','20/4/2016','Hougang Community Club Auditorium','1300','1400','05/03//2015',25);
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
INSERT INTO `workshopregistration` VALUES ('s','s','s','s','s');
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

-- Dump completed on 2015-08-10 21:02:25
