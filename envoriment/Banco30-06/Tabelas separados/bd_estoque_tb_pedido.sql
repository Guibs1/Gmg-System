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
-- Table structure for table `tb_pedido`
--

DROP TABLE IF EXISTS `tb_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_pedido` (
  `pedido_id` int(11) NOT NULL AUTO_INCREMENT,
  `funcionario_id` int(11) NOT NULL,
  `cliente_id` int(11) NOT NULL,
  `pedido_horario_retirada` char(5) DEFAULT NULL,
  `pedido_data` date DEFAULT NULL,
  `pedido_desconto` double DEFAULT NULL,
  `pedido_total` decimal(6,2) NOT NULL,
  `pedido_status` bit(1) DEFAULT NULL,
  `pedido_pago` bit(1) DEFAULT NULL,
  PRIMARY KEY (`pedido_id`),
  KEY `funcionario_id` (`funcionario_id`),
  KEY `cliente_id` (`cliente_id`),
  CONSTRAINT `tb_pedido_ibfk_1` FOREIGN KEY (`funcionario_id`) REFERENCES `tb_funcionario` (`funcionario_id`),
  CONSTRAINT `tb_pedido_ibfk_2` FOREIGN KEY (`cliente_id`) REFERENCES `tb_cliente` (`cliente_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pedido`
--

LOCK TABLES `tb_pedido` WRITE;
/*!40000 ALTER TABLE `tb_pedido` DISABLE KEYS */;
INSERT INTO `tb_pedido` VALUES (32,2,1,'21:00','2017-06-29',0,5.20,NULL,NULL),(33,2,1,'22:00','2017-06-29',0,10.00,NULL,NULL),(34,2,1,'21:00','2017-06-29',0,10.00,NULL,NULL),(35,2,1,'21:00','2017-06-29',0,5.20,NULL,NULL),(36,2,1,'12:00','2017-06-29',0,10.00,'',''),(37,2,1,'21:40','2017-06-29',0,10.00,NULL,NULL),(38,2,1,'6:00','2017-06-29',0,20.00,NULL,''),(39,2,1,'12:00','2017-06-29',0,10.00,'',''),(40,2,1,'8:00','2017-06-29',0,10.00,'',''),(41,2,1,'32:03','2017-06-29',0,10.00,'',''),(42,2,1,'22:22','2017-06-29',0,10.00,'',''),(43,2,1,'1','2017-06-29',0,10.00,'',''),(44,2,1,'23:00','2017-06-29',0,10.00,'','');
/*!40000 ALTER TABLE `tb_pedido` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-30 17:22:49
