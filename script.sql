CREATE DATABASE  IF NOT EXISTS `mejorcocina` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `mejorcocina`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mejorcocina
-- ------------------------------------------------------
-- Server version	5.5.24-log

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
-- Table structure for table `camarero`
--

DROP TABLE IF EXISTS `camarero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `camarero` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Apellido1` varchar(255) DEFAULT NULL,
  `Apellido2` varchar(255) DEFAULT NULL,
  `Nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `camarero`
--

LOCK TABLES `camarero` WRITE;
/*!40000 ALTER TABLE `camarero` DISABLE KEYS */;
INSERT INTO `camarero` VALUES (1,'Padilla','Martin','Pablo'),(2,'Sanchez','Perea','Isabel'),(3,'Parada','Padilla','Pedrina'),(4,'Eufemides','Paragaricutirimicuaro','Alvaro'),(5,'Uribe','Pedraza','Eustaquio');
/*!40000 ALTER TABLE `camarero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Apellido1` varchar(255) DEFAULT NULL,
  `Apellido2` varchar(255) DEFAULT NULL,
  `Nombre` varchar(255) DEFAULT NULL,
  `Observaciones` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Perea','Ramirez','Pedro','El de gafas'),(2,'Martinez','Camacho','Aida','La churca'),(3,'Casas','Robles','Armando','El arquitecto'),(4,'Jimenez','Lopez','Miguel','El profesor');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cocinero`
--

DROP TABLE IF EXISTS `cocinero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cocinero` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Apellido1` varchar(255) DEFAULT NULL,
  `Apellido2` varchar(255) DEFAULT NULL,
  `Nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cocinero`
--

LOCK TABLES `cocinero` WRITE;
/*!40000 ALTER TABLE `cocinero` DISABLE KEYS */;
INSERT INTO `cocinero` VALUES (1,'Marin','Alvarado','Arquimedes'),(2,'Lozano','Morcote','Alba Q'),(3,'Pinto','Florez','Aquiles'),(4,'Espinosa','Carvajal','Rosa'),(5,'Morales','Chipata','Gervasio'),(6,'Bahat','Mamat','Al');
/*!40000 ALTER TABLE `cocinero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallefactura`
--

DROP TABLE IF EXISTS `detallefactura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallefactura` (
  `IdDetalleFactura` bigint(20) NOT NULL,
  `Importe` double DEFAULT NULL,
  `IdFactura` bigint(20) NOT NULL,
  `IdCocinero` bigint(20) DEFAULT NULL,
  `Plato` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdFactura`,`IdDetalleFactura`),
  KEY `FK6w9r3v8k7xbt1bkbxjfv50nk5` (`IdCocinero`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `IdFactura` bigint(20) NOT NULL AUTO_INCREMENT,
  `FechaFactura` datetime DEFAULT NULL,
  `IdCamarero` bigint(20) NOT NULL,
  `IdCliente` bigint(20) NOT NULL,
  `IdMesa` bigint(20) NOT NULL,
  PRIMARY KEY (`IdFactura`),
  KEY `FKfkr7fuu537qyqdqv7opv5ch4i` (`IdCamarero`),
  KEY `FKsimsa9sf3nwbsmi8960a6n00t` (`IdCliente`),
  KEY `FKe2w3er2wai07kocld8s0kd0g2` (`IdMesa`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `mesa`
--

DROP TABLE IF EXISTS `mesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mesa` (
  `IdMesa` bigint(20) NOT NULL AUTO_INCREMENT,
  `NumMaxComensales` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdMesa`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesa`
--

LOCK TABLES `mesa` WRITE;
/*!40000 ALTER TABLE `mesa` DISABLE KEYS */;
INSERT INTO `mesa` VALUES (1,4),(2,6),(3,9),(4,10),(5,5),(6,9);
/*!40000 ALTER TABLE `mesa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-11 13:34:20
