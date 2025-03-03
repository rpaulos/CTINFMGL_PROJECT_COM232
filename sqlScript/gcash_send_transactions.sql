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
-- Table structure for table `send_transactions`
--

DROP TABLE IF EXISTS `send_transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `send_transactions` (
  `send_transaction_id` int NOT NULL AUTO_INCREMENT,
  `sender_number` varchar(15) NOT NULL,
  `sender_name` varchar(50) NOT NULL,
  `receiver_name` varchar(50) NOT NULL,
  `receiver_number` varchar(15) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `transaction_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`send_transaction_id`),
  KEY `sender_number` (`sender_number`),
  KEY `receiver_number` (`receiver_number`),
  CONSTRAINT `send_transactions_ibfk_1` FOREIGN KEY (`sender_number`) REFERENCES `users` (`phone_number`),
  CONSTRAINT `send_transactions_ibfk_2` FOREIGN KEY (`receiver_number`) REFERENCES `users` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `send_transactions`
--

LOCK TABLES `send_transactions` WRITE;
/*!40000 ALTER TABLE `send_transactions` DISABLE KEYS */;
INSERT INTO `send_transactions` VALUES (2,'091122334455','John Doe','Scaramouche Wanderer','091122334000',100.00,'2025-03-02 01:57:48'),(3,'091122334455','Veronica Rivera','Scaramouche Wanderer','091122334000',200.00,'2025-03-02 02:02:14'),(4,'092233445111','Hu Tao','Kazuha Kaedehara','091234567111',200.00,'2025-03-02 23:02:32'),(5,'091122334000','Scaramouche Wanderer','Veronica Rivera','091122334455',1000.00,'2025-03-03 12:52:46'),(6,'091122334455','Veronica Rivera','Scaramouche Wanderer','091122334000',1000.00,'2025-03-03 12:52:46'),(7,'091122334000','Scaramouche Wanderer','Xiao Alatus','092345678222',300.00,'2025-03-03 12:53:07'),(8,'092345678222','Xiao Alatus','Scaramouche Wanderer','091122334000',300.00,'2025-03-03 12:53:07'),(9,'091698231945','Jared Pilapil','Jon Snow','091234567101',20.00,'2025-03-03 13:02:36'),(10,'091234567101','Jon Snow','Jared Pilapil','091698231945',20.00,'2025-03-03 13:02:36'),(11,'093234566741','Rae Paulos','Lucas Domingo','091234098765',2000.50,'2025-03-03 13:23:48'),(12,'091234098765','Lucas Domingo','Rae Paulos','093234566741',2000.50,'2025-03-03 13:23:48'),(13,'097890123707','Cersei Lannister','Ayaka Kamisato','096677889555',100.00,'2025-03-03 13:29:36'),(14,'096677889555','Ayaka Kamisato','Cersei Lannister','097890123707',100.00,'2025-03-03 13:29:36'),(15,'093234566741','Rae Paulos','Kazuha Kaedehara','091234567111',275.25,'2025-03-03 15:57:20'),(16,'091234567111','Kazuha Kaedehara','Rae Paulos','093234566741',275.25,'2025-03-03 15:57:20');
/*!40000 ALTER TABLE `send_transactions` ENABLE KEYS */;
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
