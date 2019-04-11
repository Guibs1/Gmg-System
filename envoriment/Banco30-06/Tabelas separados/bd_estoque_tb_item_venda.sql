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
-- Table structure for table `tb_item_venda`
--

DROP TABLE IF EXISTS `tb_item_venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_item_venda` (
  `item_venda_id` int(11) NOT NULL AUTO_INCREMENT,
  `venda_id` int(11) NOT NULL,
  `produto_id` int(11) NOT NULL,
  `item_venda_produto_qtd` int(11) NOT NULL,
  `item_venda_valor_unitario` decimal(6,2) NOT NULL,
  `item_venda_desconto` decimal(6,2) DEFAULT NULL,
  `item_venda_valor_subtotal` decimal(6,2) NOT NULL,
  PRIMARY KEY (`item_venda_id`,`venda_id`),
  KEY `venda_id` (`venda_id`),
  KEY `produto_id` (`produto_id`),
  CONSTRAINT `tb_item_venda_ibfk_1` FOREIGN KEY (`venda_id`) REFERENCES `tb_venda` (`venda_id`),
  CONSTRAINT `tb_item_venda_ibfk_2` FOREIGN KEY (`produto_id`) REFERENCES `tb_produto` (`produto_id`)
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_item_venda`
--

LOCK TABLES `tb_item_venda` WRITE;
/*!40000 ALTER TABLE `tb_item_venda` DISABLE KEYS */;
INSERT INTO `tb_item_venda` VALUES (117,250,6,1,16.00,NULL,16.00),(118,251,6,1,16.00,NULL,14.40),(119,253,1,2,5.00,1.00,9.00),(120,259,1,1,5.00,0.00,5.00),(121,260,1,1,5.00,0.00,5.00),(122,261,6,1,16.00,0.00,16.00),(123,261,6,2,16.00,0.00,32.00),(124,261,6,1,16.00,0.00,16.00),(125,262,6,1,16.00,0.00,16.00),(126,263,6,1,16.00,0.00,16.00),(127,264,7,41,7.00,0.00,287.00),(130,265,2,3,5.20,0.00,15.60),(131,280,6,1,16.00,0.00,16.00),(135,285,2,1,5.20,0.00,5.20),(136,286,6,1,16.00,0.00,16.00),(137,287,2,1,5.20,0.00,5.20),(138,288,2,1,5.20,0.00,5.20),(140,291,2,1,5.20,0.00,5.20),(142,294,1,1,5.00,0.00,5.00),(145,310,1,5,10.00,0.00,50.00),(146,316,1,1,10.00,0.00,10.00),(147,317,1,1,10.00,0.00,10.00);
/*!40000 ALTER TABLE `tb_item_venda` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER Tgr_ItensVenda_Insert AFTER INSERT
ON tb_item_venda
FOR EACH ROW
BEGIN
    UPDATE tb_estoque_produto 
    SET tb_estoque_produto.estoque_qtd 
    = tb_estoque_produto.estoque_qtd 
    - NEW.item_venda_produto_qtd
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER Tgr_ItensVenda_Delete AFTER DELETE
ON tb_item_venda
FOR EACH ROW
BEGIN
    UPDATE tb_estoque_produto SET tb_estoque_produto.estoque_qtd  =  tb_estoque_produto.estoque_qtd 
    + OLD.item_venda_produto_qtd
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
