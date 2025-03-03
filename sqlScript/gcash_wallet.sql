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
-- Table structure for table `wallet`
--

DROP TABLE IF EXISTS `wallet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wallet` (
  `phone_number` varchar(15) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `balance` decimal(10,2) DEFAULT '0.00',
  `currency` varchar(50) DEFAULT 'Philippine Peso (₱)',
  PRIMARY KEY (`phone_number`),
  CONSTRAINT `wallet_ibfk_1` FOREIGN KEY (`phone_number`) REFERENCES `users` (`phone_number`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wallet`
--

LOCK TABLES `wallet` WRITE;
/*!40000 ALTER TABLE `wallet` DISABLE KEYS */;
INSERT INTO `wallet` VALUES ('091122334000','Scaramouche','Wanderer',9032.50,'Philippine Peso (₱)'),('091122334455','Veronica','Rivera',5229.98,'Philippine Peso (₱)'),('091234098765','Lucas','Domingo',5631.24,'Philippine Peso (₱)'),('091234567101','Jon','Snow',8725.71,'Philippine Peso (₱)'),('091234567111','Kazuha','Kaedehara',10719.12,'Philippine Peso (₱)'),('091234567890','Sophia','Gonzales',13028.40,'Philippine Peso (₱)'),('091698231945','Jared','Pilapil',3667.35,'Philippine Peso (₱)'),('092122334000','Nahida','Buer',9151.76,'Philippine Peso (₱)'),('092209876543','Angelica','Ramos',63.57,'Philippine Peso (₱)'),('092233445111','Hu','Tao',13356.45,'Philippine Peso (₱)'),('092345678202','Daenerys','Targaryen',9497.33,'Philippine Peso (₱)'),('092345678222','Xiao','Alatus',6755.65,'Philippine Peso (₱)'),('092345678901','Andrea','Reyes',9654.06,'Philippine Peso (₱)'),('093234566741','Rae','Paulos',31019.50,'Philippine Peso (₱)'),('093344556222','Eula','Lawrence',9500.00,'Philippine Peso (₱)'),('093456789303','Tyrion','Lannister',17000.23,'Philippine Peso (₱)'),('093456789321','Marco','Sorriano',10250.00,'Philippine Peso (₱)'),('093456789333','Zhongli','Morax',9600.00,'Philippine Peso (₱)'),('094512346789','Miguel','Santos',13800.00,'Philippine Peso (₱)'),('094567890404','Arya','Stark',8439.30,'Philippine Peso (₱)'),('094567890444','Raiden','Shogun',7300.00,'Philippine Peso (₱)'),('094567890654','Jasmine','Villanueva',12000.00,'Philippine Peso (₱)'),('0955441386','Marsh','Gambol',0.00,'Philippine Peso (₱)'),('095566778444','Yelan','Guo',6400.00,'Philippine Peso (₱)'),('095678901234','Isabella','Lazaro',7780.00,'Philippine Peso (₱)'),('095678901505','Sansa','Stark',11500.00,'Philippine Peso (₱)'),('095678901555','Childe','Tartaglia',11000.00,'Philippine Peso (₱)'),('095678901987','Darren','Flores',9500.00,'Philippine Peso (₱)'),('096334891432','RJ','Cruz',19700.25,'Philippine Peso (₱)'),('096677889555','Ayaka','Kamisato',10700.00,'Philippine Peso (₱)'),('096789012345','Christine','Salazar',11200.00,'Philippine Peso (₱)'),('096789012606','Jaime','Lannister',9000.00,'Philippine Peso (₱)'),('096789012666','Albedo','Rhein',9800.00,'Philippine Peso (₱)'),('09690651899','Juan','Dela Cruz',9300.00,'Philippine Peso (₱)'),('097198231945','Carl','Anastacio',110400.00,'Philippine Peso (₱)'),('097462530945','Jersey','Marisga',11250.00,'Philippine Peso (₱)'),('09763088831','Amy','Sosa',0.00,'Philippine Peso (₱)'),('097788990666','Ayato','Kamisato',10200.00,'Philippine Peso (₱)'),('097890123456','Nathan','Valdez',10800.00,'Philippine Peso (₱)'),('097890123707','Cersei','Lannister',7900.00,'Philippine Peso (₱)'),('097890123777','Diluc','Ragnvindr',4200.00,'Philippine Peso (₱)'),('097890123890','Patrick','Luna',10100.00,'Philippine Peso (₱)'),('09876543210','Sabrina','Carpenter',13501.50,'Philippine Peso (₱)'),('098899001777','Yoimiya','Naganohara',10700.00,'Philippine Peso (₱)'),('098901234567','Alexa','Bautista',11600.00,'Philippine Peso (₱)'),('098901234808','Bran','Stark',9100.00,'Philippine Peso (₱)'),('098901234888','Kaeya','Alberich',10500.00,'Philippine Peso (₱)'),('099012345876','Sean','Torres',9800.00,'Philippine Peso (₱)'),('099012345909','Brienne','Tarth',10000.00,'Philippine Peso (₱)'),('099012345999','Venti','Barbatos',10900.00,'Philippine Peso (₱)'),('099876543210','Paolo','Del Rosario',10486.75,'Philippine Peso (₱)'),('099900112888','Tighnari','Ormos',10300.00,'Philippine Peso (₱)'),('Admin','Rae','Paulos',21230.00,'Philippine Peso (₱)');
/*!40000 ALTER TABLE `wallet` ENABLE KEYS */;
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
