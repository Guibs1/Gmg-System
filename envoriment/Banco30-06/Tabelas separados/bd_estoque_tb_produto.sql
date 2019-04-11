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
-- Table structure for table `tb_produto`
--

DROP TABLE IF EXISTS `tb_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_produto` (
  `produto_id` int(11) NOT NULL AUTO_INCREMENT,
  `subcategoria_id` int(11) NOT NULL,
  `produto_nome` varchar(50) NOT NULL,
  `produto_desc` varchar(75) DEFAULT NULL,
  `produto_preco_custo` decimal(6,2) DEFAULT NULL,
  `produto_preco_venda` decimal(6,2) NOT NULL,
  `produto_comissao` decimal(6,2) DEFAULT NULL,
  `codigo_barra` char(13) DEFAULT NULL,
  PRIMARY KEY (`produto_id`),
  KEY `subcategoria_id` (`subcategoria_id`),
  CONSTRAINT `tb_produto_ibfk_1` FOREIGN KEY (`subcategoria_id`) REFERENCES `tb_subcategoria` (`subcategoria_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_produto`
--

LOCK TABLES `tb_produto` WRITE;
/*!40000 ALTER TABLE `tb_produto` DISABLE KEYS */;
INSERT INTO `tb_produto` VALUES (1,1,'Coca-cola1','lata 150ml1',3.00,10.00,7.00,'null'),(2,1,'Coca-Cola2','Light2',3.20,5.20,2.00,'null'),(6,7,'x-burguer','Medio',5.00,10.00,5.00,'null'),(7,1,'Sprit','2 litros',5.00,7.00,2.00,'null'),(8,8,'Balas','',10.00,20.00,10.00,NULL),(9,9,'rexona','sadasd',1.00,1.00,0.00,'7791293022581'),(10,8,'bolacha','sabor cereal',5.00,7.00,2.00,'0'),(11,8,'bolacha','sabor cereal',5.00,7.00,2.00,'0'),(12,8,'bolacha','sabor cereal',5.00,7.00,2.00,'0'),(13,9,'controle','xbox 360',5.00,7.00,2.00,'0'),(14,9,'blaa','fds',7.00,7.00,0.00,NULL),(15,9,'blaa','fds',7.00,7.00,0.00,NULL);
/*!40000 ALTER TABLE `tb_produto` ENABLE KEYS */;
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
