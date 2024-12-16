-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: spring_jpa
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Dumping data for table `corsi`
--

LOCK TABLES `corsi` WRITE;
/*!40000 ALTER TABLE `corsi` DISABLE KEYS */;
INSERT INTO `corsi` VALUES (1,'java'),(2,'html'),(3,'db'),(4,'javascript');
/*!40000 ALTER TABLE `corsi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `iscrizioni`
--

LOCK TABLES `iscrizioni` WRITE;
/*!40000 ALTER TABLE `iscrizioni` DISABLE KEYS */;
INSERT INTO `iscrizioni` VALUES (1,'2024-12-16',15.00,0,1,1),(2,'2024-12-15',10.00,0,2,2),(3,'2024-12-10',17.00,0,3,1),(4,NULL,NULL,0,NULL,NULL);
/*!40000 ALTER TABLE `iscrizioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `macchine`
--

LOCK TABLES `macchine` WRITE;
/*!40000 ALTER TABLE `macchine` DISABLE KEYS */;
INSERT INTO `macchine` VALUES (1,'fiat','panda','ab123cd',1),(2,'fiat','punto','cd123fv',1),(3,'bmw','m3','gh456fd',2);
/*!40000 ALTER TABLE `macchine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `utenti`
--

LOCK TABLES `utenti` WRITE;
/*!40000 ALTER TABLE `utenti` DISABLE KEYS */;
INSERT INTO `utenti` VALUES (1,'carlo','verdi','carlo76@email.it','abc123',34,123456.78),(2,'mario','rossi','rossi@email.it','def456',55,1024.00),(3,'franco','baresi','franco@email.com','3333fffggg',61,4500.00),(9,'ciao','cognome2','18nome@emal.it','1234rf',18,NULL);
/*!40000 ALTER TABLE `utenti` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-16 18:25:20
