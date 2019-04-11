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
-- Table structure for table `tb_item_pedido`
--

DROP TABLE IF EXISTS `tb_item_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_item_pedido` (
  `item_pedido_id` int(11) NOT NULL AUTO_INCREMENT,
  `pedido_id` int(11) NOT NULL,
  `produto_id` int(11) NOT NULL,
  `item_pedido_qtd` int(11) NOT NULL,
  `item_pedido_valor_unitario` decimal(6,2) NOT NULL,
  `item_pedido_desconto` decimal(6,2) NOT NULL,
  `item_pedido_valor_subtotal` decimal(6,2) NOT NULL,
  PRIMARY KEY (`item_pedido_id`),
  KEY `pedido_id` (`pedido_id`),
  KEY `produto_id` (`produto_id`),
  CONSTRAINT `tb_item_pedido_ibfk_1` FOREIGN KEY (`pedido_id`) REFERENCES `tb_pedido` (`pedido_id`),
  CONSTRAINT `tb_item_pedido_ibfk_2` FOREIGN KEY (`produto_id`) REFERENCES `tb_produto` (`produto_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_item_pedido`
--

LOCK TABLES `tb_item_pedido` WRITE;
/*!40000 ALTER TABLE `tb_item_pedido` DISABLE KEYS */;
INSERT INTO `tb_item_pedido` VALUES (29,32,2,1,5.20,0.00,5.20),(30,33,6,1,10.00,0.00,10.00),(31,34,1,1,10.00,0.00,10.00),(32,35,2,1,5.20,0.00,5.20),(33,36,1,1,10.00,0.00,10.00),(34,37,1,1,10.00,0.00,10.00),(35,38,8,1,20.00,0.00,20.00),(36,39,1,1,10.00,0.00,10.00),(37,40,1,1,10.00,0.00,10.00),(38,41,1,1,10.00,0.00,10.00),(39,42,1,1,10.00,0.00,10.00),(40,43,1,1,10.00,0.00,10.00),(41,44,1,1,10.00,0.00,10.00);
/*!40000 ALTER TABLE `tb_item_pedido` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER Tgr_ItensPedid_Insert AFTER INSERT
ON tb_item_pedido
FOR EACH ROW
BEGIN
    UPDATE tb_estoque_produto 
    SET tb_estoque_produto.estoque_qtd 
    = tb_estoque_produto.estoque_qtd 
    - NEW.item_pedido_qtd
WHERE tb_estoque_produto.produto_id = new.produto_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER Tgr_ItensPedido_Delete AFTER DELETE
ON tb_item_pedido
FOR EACH ROW
BEGIN
    UPDATE tb_estoque_produto SET tb_estoque_produto.estoque_qtd  =  tb_estoque_produto.estoque_qtd 
    + OLD.item_pedido_qtd
WHERE tb_estoque_produto.produto_id = OLD.produto_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-30 17:22:49
