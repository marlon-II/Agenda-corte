-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: barbearia_db_marlon
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `agendamento`
--

DROP TABLE IF EXISTS `agendamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agendamento` (
  `id_agendamento` int NOT NULL AUTO_INCREMENT,
  `data_marcada` varchar(255) DEFAULT NULL,
  `id_cliente` int NOT NULL,
  `id_barbeiro` int NOT NULL,
  `id_tipo_corte` int NOT NULL,
  `hora` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_agendamento`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_barbeiro` (`id_barbeiro`),
  KEY `id_tipo_corte` (`id_tipo_corte`),
  CONSTRAINT `agendamento_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `agendamento_ibfk_2` FOREIGN KEY (`id_barbeiro`) REFERENCES `barbeiro` (`id_barbeiro`),
  CONSTRAINT `agendamento_ibfk_3` FOREIGN KEY (`id_tipo_corte`) REFERENCES `tipo_corte` (`id_tipo_corte`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agendamento`
--

LOCK TABLES `agendamento` WRITE;
/*!40000 ALTER TABLE `agendamento` DISABLE KEYS */;
INSERT INTO `agendamento` VALUES (1,'2023-05-10',1,3,4,NULL),(2,'2023-05-11',4,2,1,NULL),(3,'2023-05-15',2,1,2,NULL),(4,'2023-05-16',3,2,3,NULL),(7,'2024-07-10',1,2,2,'15:00'),(8,'2024-07-11',5,4,5,'15:00'),(9,'2024-12-05',5,4,2,'8:30'),(10,'2025-01-17',5,4,4,'13:56'),(11,'2025-01-24',9,2,4,'14:34'),(12,'2025-01-30',5,4,4,'15:02');
/*!40000 ALTER TABLE `agendamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `barbeiro`
--

DROP TABLE IF EXISTS `barbeiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `barbeiro` (
  `id_barbeiro` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_barbeiro`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barbeiro`
--

LOCK TABLES `barbeiro` WRITE;
/*!40000 ALTER TABLE `barbeiro` DISABLE KEYS */;
INSERT INTO `barbeiro` VALUES (1,'Thiago',NULL,NULL),(2,'Sandra',NULL,NULL),(3,'Marcos',NULL,NULL),(4,'Pedro','Barbeiro',NULL),(5,'Leonnardo','Limpeza',NULL),(6,'Áurea','faxineira',NULL),(7,'André','Balconista','123'),(8,'Anna','Barbeira','321');
/*!40000 ALTER TABLE `barbeiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Carlos','(31)389458823',NULL,NULL,NULL),(2,'Gabriel','(31)199987659',NULL,NULL,NULL),(3,'Marcos','(31)666789543',NULL,NULL,NULL),(4,'Daniel','(31)77678913',NULL,NULL,NULL),(5,'Marlon','(31)8562475','456987123','marlonpeixe@email.com',NULL),(6,'pedro','12443','1234','asdf',NULL),(7,'pedro2','634568','64589','ewfretg',NULL),(8,'pedro3','1234','1234','asdf',NULL),(9,'Ana','(22)854123658','36541258','ana55@email',NULL),(10,'Ludmila','(31)941687452',NULL,'lud@email.com','123'),(11,'Ronald','(31) 905582697',NULL,'ronald@email.com','456'),(12,'Fernanda','(32) 999999982',NULL,'fernanda@email.com','789'),(13,'Leandro','(31)945237516',NULL,'leandro@email.com','admin'),(14,'Marlon','23213',NULL,'marlon@e-mail','123');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_corte`
--

DROP TABLE IF EXISTS `tipo_corte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_corte` (
  `id_tipo_corte` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  PRIMARY KEY (`id_tipo_corte`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_corte`
--

LOCK TABLES `tipo_corte` WRITE;
/*!40000 ALTER TABLE `tipo_corte` DISABLE KEYS */;
INSERT INTO `tipo_corte` VALUES (1,'Disfarsado',30),(2,'Degrade',35),(3,'Americano',33),(4,'Customizado',40),(5,'Moicano',20),(6,'Aparar as pontas',10),(7,'Nevou',175),(8,'Nevou',175),(9,'Mullet',55);
/*!40000 ALTER TABLE `tipo_corte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-03-18 19:42:38
