-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_estoque
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `tb_estoque_produto`
--

DROP TABLE IF EXISTS `tb_estoque_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_estoque_produto` (
  `data_entrada` date DEFAULT NULL,
  `produto_id` int(11) NOT NULL,
  `estoque_qtd` int(11) NOT NULL,
  `estoque_qtd_min` int(11) NOT NULL,
  `estoque_qtd_max` int(11) DEFAULT NULL,
  `produto_validade` date NOT NULL,
  PRIMARY KEY (`produto_id`,`produto_validade`),
  CONSTRAINT `tb_estoque_produto_ibfk_1` FOREIGN KEY (`produto_id`) REFERENCES `tb_produto` (`produto_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_estoque_produto`
--

LOCK TABLES `tb_estoque_produto` WRITE;
/*!40000 ALTER TABLE `tb_estoque_produto` DISABLE KEYS */;
INSERT INTO `tb_estoque_produto` VALUES ('2018-05-09',1,0,10,100,'2017-06-05'),('2018-06-28',1,49,10,100,'2017-06-30'),('2018-08-06',2,18,30,100,'2017-06-30'),('2017-06-20',6,3,1,50,'2017-06-30'),('2017-06-20',7,-82,10,100,'2017-06-30');
/*!40000 ALTER TABLE `tb_estoque_produto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-30 17:22:50
