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
-- Table structure for table `tb_pagamento`
--

DROP TABLE IF EXISTS `tb_pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_pagamento` (
  `pagamento_id` int(11) NOT NULL AUTO_INCREMENT,
  `venda_id` int(11) DEFAULT NULL,
  `tipo_pagamento_id` int(11) NOT NULL,
  `pedido_id` int(11) DEFAULT NULL,
  `valor_pago` decimal(6,2) NOT NULL,
  `valor_total_com_desconto` decimal(6,2) NOT NULL,
  PRIMARY KEY (`pagamento_id`),
  KEY `venda_id` (`venda_id`),
  KEY `pedido_id` (`pedido_id`),
  KEY `tb_pagamento_ibfk_2` (`tipo_pagamento_id`),
  CONSTRAINT `tb_pagamento_ibfk_1` FOREIGN KEY (`venda_id`) REFERENCES `tb_venda` (`venda_id`),
  CONSTRAINT `tb_pagamento_ibfk_2` FOREIGN KEY (`tipo_pagamento_id`) REFERENCES `tb_tipo_pagamento` (`tipo_pagamento_id`),
  CONSTRAINT `tb_pagamento_ibfk_3` FOREIGN KEY (`pedido_id`) REFERENCES `tb_pedido` (`pedido_id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pagamento`
--

LOCK TABLES `tb_pagamento` WRITE;
/*!40000 ALTER TABLE `tb_pagamento` DISABLE KEYS */;
INSERT INTO `tb_pagamento` VALUES (76,316,2,NULL,10.00,10.00),(78,NULL,2,44,15.00,10.00),(79,317,1,NULL,10.00,10.00),(80,NULL,2,43,10.00,0.00),(81,NULL,2,42,10.00,10.00),(82,NULL,1,41,10.00,10.00),(83,NULL,2,39,8.00,10.00),(84,NULL,2,39,4.00,10.00),(85,NULL,2,36,1.00,10.00),(86,NULL,2,36,9.00,10.00),(87,NULL,2,40,5.00,10.00),(88,NULL,2,38,10.00,20.00),(89,318,2,NULL,2.00,5.20),(90,319,1,NULL,2.00,10.00);
/*!40000 ALTER TABLE `tb_pagamento` ENABLE KEYS */;
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
