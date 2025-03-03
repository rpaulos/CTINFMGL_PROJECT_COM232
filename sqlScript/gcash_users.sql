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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `phone_number` varchar(15) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email_address` varchar(50) DEFAULT NULL,
  `PIN` char(4) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('091122334000','Scaramouche','Wanderer','scaramouche.wanderer@gmail.com','3941','2001-01-03','Japan','Inazuma'),('091122334455','Veronica','Rivera','veronica.rivera@gmail.com','9871','2005-11-14','Philippines','Cavite'),('091234098765','Lucas','Domingo','lucas.domingo@gmail.com','6784','2003-04-27','Philippines','Pasig'),('091234567101','Jon','Snow','jon.snow@gmail.com','1001','1992-12-03','United Kingdom','Winterfell'),('091234567111','Kazuha','Kaedehara','kazuha.kaedehara@gmail.com','1023','2000-10-29','Japan','Inazuma'),('091234567890','Sophia','Gonzales','sophia.gonzales@icloud.com','9876','2006-07-12','Philippines','Taguig'),('091698231945','Jared','Pilapil','jared.pilapil@example.com','4352','2005-03-09','Philippines','Quezon'),('092122334000','Nahida','Buer','nahida.buer@yahoo.com','0013','2002-10-27','Iran','Sumeru'),('092209876543','Angelica','Ramos','angelica.ramos@outlook.com','6543','2005-11-10','Philippines','General Santos'),('092233445111','Hu','Tao','hu.tao@yahoo.com','1124','2001-07-15','China','Liyue'),('092345678202','Daenerys','Targaryen','daenerys.targaryen@yahoo.com','2002','1990-07-20','United Kingdom','Dragonstone'),('092345678222','Xiao','Alatus','xiao.alatus@yahoo.com','5674','2000-04-17','China','Liyue'),('092345678901','Andrea','Reyes','andrea.reyes@yahoo.com','6789','2005-08-30','Philippines','Cebu'),('093234566741','Rae','Paulos','r.paulos@admin-gcash.com','1989','2004-07-05','Philippines','Quezon'),('093344556222','Eula','Lawrence','eula.lawrence@outlook.com','2235','2000-10-25','Germany','Mondstadt'),('093456789303','Tyrion','Lannister','tyrion.lannister@outlook.com','3003','1989-06-02','United Kingdom','Casterly Rock'),('093456789321','Marco','Sorriano','marco.deleon@outlook.com','1298','2004-01-09','Philippines','San Juan'),('093456789333','Zhongli','Morax','zhongli.morax@outlook.com','9876','1999-12-31','China','Liyue'),('094512346789','Miguel','Santos','miguel.santos@gmail.com','5678','2003-11-21','Philippines','Makati'),('094567890404','Arya','Stark','arya.stark@gmail.com','4004','1995-03-11','United Kingdom','Winterfell'),('094567890444','Raiden','Shogun','ElectroArchon@gmail.com','1234','2000-06-26','Inazuma','Narukami'),('094567890654','Jasmine','Villanueva','jasmine.villanueva@gmail.com','8763','2006-08-22','Philippines','Tagaytay'),('0955441386','Marsh','Gambol','marshe@gmail.com','1234','2002-02-21','Philippines','Filipino'),('095566778444','Yelan','Guo','yelan.guo@yahoo.com','4457','1998-02-19','China','Liyue'),('095678901234','Isabella','Lazaro','isabella.lazaro@yahoo.com','4321','2005-09-19','Philippines','Baguio'),('095678901505','Sansa','Stark','sansa.stark@yahoo.com','5005','1993-02-23','United Kingdom','Winterfell'),('095678901555','Childe','Tartaglia','childe.tartaglia@yahoo.com','4532','2000-07-20','Russia','Snezhnaya'),('095678901987','Darren','Flores','darren.flores@yahoo.com','5439','2003-12-02','Philippines','Pampanga'),('096334891432','RJ','Cruz','juancruz@gmail.com','1979','2006-05-14','Philippines','Calamba'),('096677889555','Ayaka','Kamisato','ayaka.kamisato@outlook.com','5568','2000-09-28','Japan','Inazuma'),('096789012345','Christine','Salazar','christine.salazar@outlook.com','7812','2005-07-18','Philippines','Lucena'),('096789012606','Jaime','Lannister','jaime.lannister@outlook.com','6006','1987-12-12','United Kingdom','Casterly Rock'),('096789012666','Albedo','Rhein','albedo.rhein@outlook.com','1345','2000-09-13','Germany','Mondstadt'),('09690651899','Juan','Dela Cruz','juan@gmail.com','5678','1995-08-12','Philippines','Manila'),('097198231945','Carl','Anastacio','carl.og@example.com','1234','2004-09-22','Philippines','Angeles'),('097462530945','Jersey','Marisga','j.marisga@example.com','2032','2005-12-16','Philippines','Pasay'),('09763088831','Amy','Sosa','amy@cloud9@gmail.com','1234','1982-02-11','Philippines','Quezon'),('097788990666','Ayato','Kamisato','ayato.kamisato@gmail.com','6679','1999-03-26','Japan','Inazuma'),('097890123456','Nathan','Valdez','nathan.valdez@outlook.com','8765','2004-12-25','Philippines','Legazpi'),('097890123707','Cersei','Lannister','cersei.lannister@gmail.com','7007','1986-10-17','United Kingdom','King\'s Landing'),('097890123777','Diluc','Ragnvindr','diluc.ragnvindr@gmail.com','8742','1998-04-30','Germany','Mondstadt'),('097890123890','Patrick','Luna','patrick.luna@gmail.com','3921','2004-09-29','Philippines','Tarlac'),('09876543210','Sabrina','Carpenter','sabrinacarp@gmail.com','5678','1999-05-11','Philippines','Quezon'),('098899001777','Yoimiya','Naganohara','yoimiya.naganohara@yahoo.com','7780','2000-06-21','Japan','Inazuma'),('098901234567','Alexa','Bautista','alexa.bautista@yahoo.com','2507','2006-02-05','Philippines','Laguna'),('098901234808','Bran','Stark','bran.stark@yahoo.com','8008','1998-05-14','United Kingdom','Winterfell'),('098901234888','Kaeya','Alberich','kaeya.alberich@yahoo.com','5623','1999-11-30','Germany','Mondstadt'),('099012345876','Sean','Torres','sean.torres@outlook.com','6348','2003-06-30','Philippines','Bulacan'),('099012345909','Brienne','Tarth','brienne.tarth@outlook.com','9009','1985-04-08','United Kingdom','Tarth'),('099012345999','Venti','Barbatos','venti.barbatos@outlook.com','7890','1997-06-16','Germany','Mondstadt'),('099876543210','Paolo','Del Rosario','paolo.rosario@outlook.com','3456','2004-02-17','Philippines','Davao'),('099900112888','Tighnari','Ormos','tighnari.ormos@outlook.com','8891','2001-08-28','Iran','Sumeru'),('Admin','Rae','Paulos','rpaulos@gcash-admin.com','0000','2004-07-05','Philippines','Manila');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
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
