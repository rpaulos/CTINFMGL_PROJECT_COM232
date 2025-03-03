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
-- Table structure for table `withdraw_transactions`
--

DROP TABLE IF EXISTS `withdraw_transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `withdraw_transactions` (
  `withdraw_transaction_ID` int NOT NULL AUTO_INCREMENT,
  `withdrawer_number` varchar(15) NOT NULL,
  `withdrawer_name` varchar(50) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `transaction_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`withdraw_transaction_ID`),
  KEY `withdrawer_number` (`withdrawer_number`),
  CONSTRAINT `withdraw_transactions_ibfk_1` FOREIGN KEY (`withdrawer_number`) REFERENCES `users` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `withdraw_transactions`
--

LOCK TABLES `withdraw_transactions` WRITE;
/*!40000 ALTER TABLE `withdraw_transactions` DISABLE KEYS */;
INSERT INTO `withdraw_transactions` VALUES (1,'093234566741','Rae Paulos',800.00,'2025-03-02 02:31:57'),(2,'093234566741','Rae Paulos',250.00,'2025-03-02 10:27:51'),(3,'094567890404','Arya Stark',-560.70,'2025-03-02 13:45:21'),(4,'091122334000','Scaramouche Wanderer',-500.00,'2025-03-02 20:30:00'),(5,'099876543210','Paolo Del Rosario',299.00,'2025-03-02 22:34:43'),(6,'091122334455','Veronica Rivera',100.00,'2025-03-03 08:05:58'),(7,'093234566741','Rae Paulos',1500.25,'2025-03-03 15:59:48'),(8,'093234566741','Rae Paulos',500.00,'2025-03-03 16:00:30');
/*!40000 ALTER TABLE `withdraw_transactions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-03 22:26:38
