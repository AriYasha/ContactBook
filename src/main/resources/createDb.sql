CREATE DATABASE  IF NOT EXISTS `addressbooknote` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `addressbooknote`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: addressbooknote
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `history` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `IdPerson` int(11) NOT NULL,
  `Operation` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CreateAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES (1,31,'insert','2020-11-12 10:00:02'),(2,37,'Inserted contact','2020-11-12 10:24:08'),(3,38,'ГНОЙНЫЙ','2020-11-12 10:26:28'),(4,13,'Deleted contact ','2020-11-12 10:29:32'),(5,15,'Deleted contact ','2020-11-12 10:30:14'),(6,26,'Deleted contact ','2020-11-12 10:30:14'),(7,38,'Deleted contact ','2020-11-12 10:31:18'),(8,21,'Deleted contact ','2020-11-12 10:32:14'),(9,22,'Deleted contact ','2020-11-12 10:32:14'),(10,23,'Deleted contact ','2020-11-12 10:32:14'),(11,27,'Deleted contact ','2020-11-12 10:32:14'),(12,29,'Deleted contact ','2020-11-12 10:32:14'),(13,31,'Updated contact ','2020-11-12 10:32:54'),(14,37,'Updated contact ','2020-11-12 10:33:28'),(15,31,'Updated contact ','2020-11-12 11:06:10'),(16,31,'Updated contact ','2020-11-12 11:08:19'),(17,39,'Inserted contact ','2020-11-12 11:10:09'),(18,40,'Inserted contact ','2020-11-12 11:15:05'),(19,31,'Updated contact ','2020-11-12 11:16:01'),(20,39,'Deleted contact ','2020-11-12 11:20:21');
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historyphonenumbers`
--

DROP TABLE IF EXISTS `historyphonenumbers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `historyphonenumbers` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `idPhoneNumber` int(11) NOT NULL,
  `Operation` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CreateAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historyphonenumbers`
--

LOCK TABLES `historyphonenumbers` WRITE;
/*!40000 ALTER TABLE `historyphonenumbers` DISABLE KEYS */;
INSERT INTO `historyphonenumbers` VALUES (1,49,'Updated phone number ','2020-11-12 11:08:20'),(2,50,'Updated phone number ','2020-11-12 11:08:20'),(3,53,'Inserted phone number ','2020-11-12 11:08:20'),(4,54,'Inserted phone number ','2020-11-12 11:10:09'),(5,55,'Inserted phone number ','2020-11-12 11:10:09'),(6,56,'Inserted phone number ','2020-11-12 11:15:06'),(7,57,'Inserted phone number ','2020-11-12 11:15:06'),(8,53,'Deleted phone number ','2020-11-12 11:15:58'),(9,49,'Updated phone number ','2020-11-12 11:16:01'),(10,50,'Updated phone number ','2020-11-12 11:16:01');
/*!40000 ALTER TABLE `historyphonenumbers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loginform`
--

DROP TABLE IF EXISTS `loginform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `loginform` (
  `id_login` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  PRIMARY KEY (`id_login`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loginform`
--

LOCK TABLES `loginform` WRITE;
/*!40000 ALTER TABLE `loginform` DISABLE KEYS */;
INSERT INTO `loginform` VALUES (1,'karina','12345'),(2,'irina','1234'),(3,'yaroslau','1234'),(4,'yaroslau','1234'),(5,'yaroslau','1234'),(6,'eret','rtrg'),(7,'yana','yana1'),(8,'yasha','1q2w3e'),(9,'wenya','fdgf'),(10,'nina','1234'),(11,'nima','1234'),(12,'poly','1234'),(13,'nina','1234'),(14,'nina','1234'),(15,'nina','1234'),(16,'nina','1234'),(17,'nina','132424'),(18,'karinas','1234'),(19,'katya','123');
/*!40000 ALTER TABLE `loginform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `person` (
  `id_person` int(11) NOT NULL AUTO_INCREMENT,
  `surname` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `patronymic` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id_person`),
  UNIQUE KEY `id_person_UNIQUE` (`id_person`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (6,'ИЛЬЯ','ГУЛИС','ОЛЕГОВИЧ','ЛИДА','2020-11-10'),(31,'СУДЕНЦОВ','ИГ','АЛЕКСАНДРОВИЧ','КИЕВ','2020-11-12'),(37,'КИРОВА','КРИСТИНА','ГЕНАДЬЕВНА','КИНО','2020-11-12'),(40,'ЛИБ','КАРИНА','ЯНОВНА','СТАМБУЛ','2020-11-12');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `person_AFTER_INSERT` AFTER INSERT ON `person` FOR EACH ROW BEGIN
	INSERT INTO history
    SET operation = 'Inserted contact ' ,
        IdPerson = NEW.id_person,
        CreateAt = NOW();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `person_AFTER_UPDATE` AFTER UPDATE ON `person` FOR EACH ROW BEGIN
	INSERT INTO history
    SET operation = 'Updated contact ',
        IdPerson = OLD.id_person,
        CreateAt = NOW();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `person_AFTER_DELETE` AFTER DELETE ON `person` FOR EACH ROW BEGIN
	INSERT INTO history
    SET operation = 'Deleted contact ',
        IdPerson = OLD.id_person,
        CreateAt = NOW();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `phonenumbers`
--

DROP TABLE IF EXISTS `phonenumbers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `phonenumbers` (
  `id_phoneNumbers` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(45) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `id_person` int(11) NOT NULL,
  PRIMARY KEY (`id_phoneNumbers`),
  KEY `id_person_idx` (`id_person`),
  CONSTRAINT `id_person` FOREIGN KEY (`id_person`) REFERENCES `person` (`id_person`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phonenumbers`
--

LOCK TABLES `phonenumbers` WRITE;
/*!40000 ALTER TABLE `phonenumbers` DISABLE KEYS */;
INSERT INTO `phonenumbers` VALUES (14,'45435','work',6),(49,'2345698','Home',31),(50,'8761206','Work',31),(51,'5478017','Fax',37),(56,'3543','Work',40),(57,'345454','Home',40);
/*!40000 ALTER TABLE `phonenumbers` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `phonenumbers_AFTER_INSERT` AFTER INSERT ON `phonenumbers` FOR EACH ROW BEGIN
INSERT INTO historyphonenumbers
    SET operation = 'Inserted phone number ' ,
        IdPhoneNumber = NEW.id_phoneNumbers,
        CreateAt = NOW();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `phonenumbers_AFTER_UPDATE` AFTER UPDATE ON `phonenumbers` FOR EACH ROW BEGIN
INSERT INTO historyphonenumbers
    SET operation = 'Updated phone number ' ,
        IdPhoneNumber = OLD.id_phoneNumbers,
        CreateAt = NOW();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `phonenumbers_AFTER_DELETE` AFTER DELETE ON `phonenumbers` FOR EACH ROW BEGIN
INSERT INTO historyphonenumbers
    SET operation = 'Deleted phone number ' ,
        IdPhoneNumber = OLD.id_phoneNumbers,
        CreateAt = NOW();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-12 15:15:40
