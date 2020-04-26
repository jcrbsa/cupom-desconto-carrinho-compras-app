CREATE DATABASE  IF NOT EXISTS `carrinhocompra` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `carrinhocompra`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: carrinhocompra
-- ------------------------------------------------------
-- Server version	5.6.25

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
-- Table structure for table `carrinho`
--

DROP TABLE IF EXISTS `carrinho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrinho` (
  `id` bigint(20) NOT NULL,
  `total` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrinho`
--

LOCK TABLES `carrinho` WRITE;
/*!40000 ALTER TABLE `carrinho` DISABLE KEYS */;
INSERT INTO `carrinho` VALUES (12,9196.16),(22,16565.9),(23,16565.9),(24,16565.9),(25,16565.9);
/*!40000 ALTER TABLE `carrinho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrinho_tem_cupom`
--

DROP TABLE IF EXISTS `carrinho_tem_cupom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrinho_tem_cupom` (
  `carrinho_id` bigint(20) NOT NULL,
  `cupom_id` bigint(20) NOT NULL,
  KEY `FK5blv9bp5j5i9fufbu9wbmivvb` (`cupom_id`),
  KEY `FKlvwv942nls8ekqg1g43cxra1t` (`carrinho_id`),
  CONSTRAINT `FK5blv9bp5j5i9fufbu9wbmivvb` FOREIGN KEY (`cupom_id`) REFERENCES `cupom` (`id`),
  CONSTRAINT `FKlvwv942nls8ekqg1g43cxra1t` FOREIGN KEY (`carrinho_id`) REFERENCES `carrinho` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrinho_tem_cupom`
--

LOCK TABLES `carrinho_tem_cupom` WRITE;
/*!40000 ALTER TABLE `carrinho_tem_cupom` DISABLE KEYS */;
INSERT INTO `carrinho_tem_cupom` VALUES (12,3),(22,4),(22,3),(23,4),(23,3),(24,4),(24,3),(25,4),(25,3);
/*!40000 ALTER TABLE `carrinho_tem_cupom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrinho_tem_produto`
--

DROP TABLE IF EXISTS `carrinho_tem_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrinho_tem_produto` (
  `carrinho_id` bigint(20) NOT NULL,
  `produto_id` bigint(20) NOT NULL,
  KEY `FK113c25t654j4nhb8ot2u6moh3` (`produto_id`),
  KEY `FKcjn6h12befwwelgae2r70lmh2` (`carrinho_id`),
  CONSTRAINT `FK113c25t654j4nhb8ot2u6moh3` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`),
  CONSTRAINT `FKcjn6h12befwwelgae2r70lmh2` FOREIGN KEY (`carrinho_id`) REFERENCES `carrinho` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrinho_tem_produto`
--

LOCK TABLES `carrinho_tem_produto` WRITE;
/*!40000 ALTER TABLE `carrinho_tem_produto` DISABLE KEYS */;
INSERT INTO `carrinho_tem_produto` VALUES (12,1),(12,2),(12,3),(12,4),(12,5),(12,6),(22,1),(22,2),(22,3),(22,4),(22,5),(22,6),(22,7),(22,9),(22,10),(22,11),(22,12),(22,13),(22,14),(22,15),(23,3),(23,6),(23,7),(23,9),(23,10),(23,11),(23,12),(23,13),(23,14),(23,15),(24,1),(24,2),(24,3),(24,4),(24,5),(24,6),(24,7),(24,9),(24,10),(24,11),(24,12),(24,13),(24,14),(24,15),(25,1),(25,2),(25,3),(25,4),(25,5),(25,6),(25,7),(25,9),(25,10),(25,11),(25,12),(25,13),(25,14),(25,15);
/*!40000 ALTER TABLE `carrinho_tem_produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cupom`
--

DROP TABLE IF EXISTS `cupom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cupom` (
  `id` bigint(20) NOT NULL,
  `desconto` int(11) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cupom`
--

LOCK TABLES `cupom` WRITE;
/*!40000 ALTER TABLE `cupom` DISABLE KEYS */;
INSERT INTO `cupom` VALUES (1,5,'#MilValorCincoDesc','P'),(2,7,'#CincoMilValorSetDesc','P'),(3,10,'#DezMilValorDezDesc','P'),(4,10,'#DezQuantDezDesc2','NP');
/*!40000 ALTER TABLE `cupom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cupom_nao_progressivo`
--

DROP TABLE IF EXISTS `cupom_nao_progressivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cupom_nao_progressivo` (
  `quantidadeprodutos` int(11) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK8s38y6sfmb8thny0cfepcgx56` FOREIGN KEY (`id`) REFERENCES `cupom` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cupom_nao_progressivo`
--

LOCK TABLES `cupom_nao_progressivo` WRITE;
/*!40000 ALTER TABLE `cupom_nao_progressivo` DISABLE KEYS */;
INSERT INTO `cupom_nao_progressivo` VALUES (10,4);
/*!40000 ALTER TABLE `cupom_nao_progressivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cupom_progressivo`
--

DROP TABLE IF EXISTS `cupom_progressivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cupom_progressivo` (
  `valorcompras` float DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKs2ypi5dlhlahkbgf474hhq705` FOREIGN KEY (`id`) REFERENCES `cupom` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cupom_progressivo`
--

LOCK TABLES `cupom_progressivo` WRITE;
/*!40000 ALTER TABLE `cupom_progressivo` DISABLE KEYS */;
INSERT INTO `cupom_progressivo` VALUES (1000,1),(5000,2),(10000,3);
/*!40000 ALTER TABLE `cupom_progressivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (26),(26),(26),(26);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_produto`
--

DROP TABLE IF EXISTS `item_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_produto` (
  `id` bigint(20) NOT NULL,
  `produto_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkgvdc5b44jprr61880fn53wdt` (`produto_id`),
  CONSTRAINT `FKkgvdc5b44jprr61880fn53wdt` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_produto`
--

LOCK TABLES `item_produto` WRITE;
/*!40000 ALTER TABLE `item_produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `preco` float DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'produtoA',99.99,'A'),(2,'produtoB',66.99,'B'),(3,'produtC',33.99,'C'),(4,'produtD',11.99,'A'),(5,'produtE',3.99,'B'),(6,'produtF',10001,'C'),(7,'02produtoF',0.99,'C'),(8,'03produtoF',0.99,'C'),(9,'04produtoF',0.99,'C'),(10,'05produtoF',0.99,'C'),(11,'06produtoF',0.99,'C'),(12,'07produtoF',0.99,'C'),(13,'08produtoF',0.99,'C'),(14,'09produtoF',0.99,'C'),(15,'10produtoF',0.99,'C');
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-25 23:07:01
