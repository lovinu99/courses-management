CREATE DATABASE  IF NOT EXISTS `qlsv` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `qlsv`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: qlsv
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sv_monhoc`
--

DROP TABLE IF EXISTS `sv_monhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sv_monhoc` (
  `sv_MSSV` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `monhoc_MaMH` varchar(7) NOT NULL,
  `gk` int DEFAULT NULL,
  `ck` int DEFAULT NULL,
  `khac` int DEFAULT NULL,
  `tk` int DEFAULT NULL,
  PRIMARY KEY (`sv_MSSV`,`monhoc_MaMH`),
  KEY `fk_sv_monhoc_sv1_idx` (`sv_MSSV`),
  KEY `fk_sv_monhoc_monhoc1_idx` (`monhoc_MaMH`),
  CONSTRAINT `fk_sv_monhoc_monhoc1` FOREIGN KEY (`monhoc_MaMH`) REFERENCES `monhoc` (`MaMH`),
  CONSTRAINT `fk_sv_monhoc_sv1` FOREIGN KEY (`sv_MSSV`) REFERENCES `sv` (`MSSV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sv_monhoc`
--

LOCK TABLES `sv_monhoc` WRITE;
/*!40000 ALTER TABLE `sv_monhoc` DISABLE KEYS */;
/*!40000 ALTER TABLE `sv_monhoc` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-20 16:28:30
