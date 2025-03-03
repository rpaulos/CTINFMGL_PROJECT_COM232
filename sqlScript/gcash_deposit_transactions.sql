-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: gcash
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `deposit_transactions`
--

DROP TABLE IF EXISTS `deposit_transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deposit_transactions` (
  `deposit_transaction_ID` int NOT NULL AUTO_INCREMENT,
  `depositor_number` varchar(15) NOT NULL,
  `depositor_name` varchar(50) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `transaction_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`deposit_transaction_ID`),
  KEY `depositor_number` (`depositor_number`),
  CONSTRAINT `deposit_transactions_ibfk_1` FOREIGN KEY (`depositor_number`) REFERENCES `users` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deposit_transactions`
--

LOCK TABLES `deposit_transactions` WRITE;
/*!40000 ALTER TABLE `deposit_transactions` DISABLE KEYS */;
INSERT INTO `deposit_transactions` VALUES (1,'093456789333','Zhongli Morax',220.00,'2025-03-02 02:30:42'),(2,'091122334000','Scaramouche Wanderer',200.20,'2025-03-02 13:19:29'),(3,'092122334000','Nahida Buer',259.72,'2025-03-02 13:23:04'),(4,'092345678202','Daenerys Targaryen',78.45,'2025-03-02 13:25:04'),(5,'093456789303','Tyrion Lannister',5000.23,'2025-03-02 13:27:07'),(6,'09876543210','Sabrina Carpenter',2500.75,'2025-03-02 13:28:28'),(7,'09876543210','Sabrina Carpenter',2500.75,'2025-03-02 13:28:34'),(8,'091234567111','Kazuha Kaedehara',50.00,'2025-03-02 13:30:12'),(9,'091698231945','Jared Pilapil',80.00,'2025-03-02 13:30:39'),(10,'096334891432','RJ Cruz',7500.25,'2025-03-02 13:32:28'),(11,'091122334000','Scaramouche Wanderer',500.00,'2025-03-02 20:29:28'),(12,'099876543210','Paolo Del Rosario',156.00,'2025-03-02 22:30:32'),(13,'099876543210','Paolo Del Rosario',670.25,'2025-03-02 22:33:39'),(14,'091122334455','Veronica Rivera',252.00,'2025-03-03 08:04:56'),(15,'097198231945','Carl Anastacio',100000.00,'2025-03-03 13:28:01'),(16,'093234566741','Rae Paulos',200.00,'2025-03-03 15:58:28'),(17,'093234566741','Rae Paulos',1500.25,'2025-03-03 16:00:00');
/*!40000 ALTER TABLE `deposit_transactions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-03 22:26:39
