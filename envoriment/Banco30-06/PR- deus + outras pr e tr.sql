CREATE DATABASE BD_TESTE;
USE BD_TESTE;


#DELIMITER ;;
#CREATE  PROCEDURE `pr_DEUS`()
#Begin

CREATE TABLE `tb_categoria` (
  `categoria_id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria_nome` varchar(50) NOT NULL,
  PRIMARY KEY (`categoria_id`)
);

CREATE TABLE `tb_subcategoria` (
  `subcategoria_id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria_id` int(11) NOT NULL,
  `subcategoria_nome` varchar(50) NOT NULL,
  PRIMARY KEY (`subcategoria_id`),
  KEY `categoria_id` (`categoria_id`),
  CONSTRAINT `tb_subcategoria_ibfk_1` FOREIGN KEY (`categoria_id`) REFERENCES `tb_categoria` (`categoria_id`)
);


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
) ;
CREATE TABLE `tb_estoque_produto` (
  `data_entrada` date DEFAULT NULL,
  `produto_id` int(11) NOT NULL,
  `estoque_qtd` int(11) NOT NULL,
  `estoque_qtd_min` int(11) NOT NULL,
  `estoque_qtd_max` int(11) DEFAULT NULL,
  `produto_validade` date NOT NULL,
  PRIMARY KEY (`produto_id`,`produto_validade`),
  CONSTRAINT `tb_estoque_produto_ibfk_1` FOREIGN KEY (`produto_id`) REFERENCES `tb_produto` (`produto_id`)
);
CREATE TABLE `tb_eventos` (
  `eventos_id` int(11) NOT NULL AUTO_INCREMENT,
  `evento_titulo` varchar(50) NOT NULL,
  `evento_data_inicio` date NOT NULL,
  `evento_desc` varchar(75) DEFAULT NULL,
  `evento_data_termino` date NOT NULL,
  PRIMARY KEY (`eventos_id`)
);
CREATE TABLE `tb_funcionario` (
  `funcionario_id` int(11) NOT NULL AUTO_INCREMENT,
  `funcionario_nome` varchar(60) NOT NULL,
  `funcionario_email` varchar(75) NOT NULL,
  `funcionario_celular` char(14) DEFAULT NULL,
  `funcionario_login` varchar(40) NOT NULL,
  `funcionario_senha` varchar(40) NOT NULL,
  `tipo_de_funcionario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`funcionario_id`)
) ;
CREATE TABLE `tb_venda` (
  `venda_id` int(11) NOT NULL AUTO_INCREMENT,
  `funcionario_id` int(11) NOT NULL,
  `venda_data` date NOT NULL,
  `venda_sem_desconto` decimal(6,2) DEFAULT NULL,
  `venda_desconto` decimal(6,2) DEFAULT NULL,
  `venda_total` decimal(6,2) DEFAULT NULL,
  `venda_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`venda_id`),
  KEY `funcionario_id` (`funcionario_id`),
  CONSTRAINT `tb_venda_ibfk_1` FOREIGN KEY (`funcionario_id`) REFERENCES `tb_funcionario` (`funcionario_id`)
);
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
);

CREATE TABLE `tb_cliente` (
  `cliente_id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_nome` varchar(60) DEFAULT NULL,
  `cliente_rg` char(9) DEFAULT 'null',
  PRIMARY KEY (`cliente_id`)
);
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
);
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
);


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
);

END ;;
DELIMITER ;


DELIMITER ;;
CREATE PROCEDURE `cadastro_Estoque_Produto`(in data_entrada date, in id_produto integer, in est_produto_qtd integer, in estoque_qtd_min integer,
 in estoque_qtd_max integer, in produto_validade date)
BEGIN
INSERT INTO tb_estoque_produto(
data_entrada,
produto_id,
estoque_qtd,
estoque_qtd_min,
estoque_qtd_max,
produto_validade
)values(
data_entrada,
id_produto,
est_produto_qtd,
estoque_qtd_min,
estoque_qtd_max,
produto_validade
);
end ;;
DELIMITER ;

DELIMITER ;;
CREATE PROCEDURE `cadastro_Evento`(in evento_titulo varchar(50), in evento_data_inicio date, in evento_desc varchar(75),in evento_data_termino date)
BEGIN
INSERT INTO tb_evento(
evento_titulo,
evento_data_inicio,
evento_desc,
evento_data_termino
)values(
evento_titulo,
evento_data_inicio,
evento_desc,
evento_data_termino
);
end ;;
DELIMITER ;

DELIMITER ;;
CREATE PROCEDURE `cadastro_Funcionario`(in funcionario_nome varchar(50), in funcionario_email varchar(75), in funcionario_celular char(14),
in funcionario_login varchar(40), in funcionario_senha varchar(40))
BEGIN
INSERT INTO tb_funcionario(
funcionario_nome,
funcionario_email,
funcionario_celular,
funcionario_login,
funcionario_senha
)values(
funcionario_nome,
funcionario_email,
funcionario_celular,
funcionario_login,
funcionario_senha
);
end ;;
DELIMITER ;

DELIMITER ;;
CREATE  PROCEDURE `cadastro_Produto`(in subcategoria_id int(6), in produto_nome varchar(50), in produto_preco_custo decimal(6,2),
 in produto_preco_venda decimal(6,2), in produto_comissao decimal(6,2), in produto_desc varchar(75))
BEGIN
INSERT INTO tb_produto(
subcategoria_id,
produto_nome,
produto_desc,
produto_preco_custo,
produto_preco_venda,
produto_comissao
)values(
subcategoria_id,
produto_nome,
produto_desc,
produto_preco_custo,
produto_preco_venda,
produto_comissao
);
end ;;
DELIMITER ;

DELIMITER ;;
CREATE  PROCEDURE `excluir_categoria`(in id_categoria integer)
BEGIN

delete from tb_categoria where categoria_id = id_categoria;

end ;;
DELIMITER ;

DELIMITER ;;
CREATE PROCEDURE `Pr_ChecaValidade`(in dataatual date)
BEGIN
   select tb_produto.produto_nome, produto_validade, DATEDIFF( produto_validade ,dataatual) as 'DiasValidade'
   from tb_estoque_produto inner join tb_produto on tb_produto.produto_id = tb_estoque_produto.produto_id 
   order by 'DiasValidade' desc;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE  PROCEDURE `pr_condicoes_estoque`()
select tb_produto.produto_nome AS 'NOME DO PRODUTO', tb_produto.produto_desc AS 'DESCRIÇÃO', estoque_qtd as 'QUANTIDADE',
 if (estoque_qtd_min > estoque_qtd,'baixo' ,'alto') as 'SITUAÇÃO'
from tb_estoque_produto inner join tb_produto
 on tb_produto.produto_id = tb_estoque_produto.produto_id 
 where estoque_qtd_min > estoque_qtd ;;
DELIMITER ;

DELIMITER ;;
CREATE PROCEDURE `pr_Dias_Para_Eventos`(in dataatual date)
select evento_titulo, evento_data_inicio, evento_data_termino ,
DATEDIFF( evento_data_inicio ,dataatual) as 'DiasRestante'
from tb_eventos ;;
DELIMITER ;

DELIMITER ;;
CREATE PROCEDURE `Pr_Valida_qtd_desejada`(in qtddesejada int, in produtoid int)
BEGIN
select if (estoque_qtd < qtddesejada, 'Sem Estoque', 'Em Estoque.') as'Resultado'
from tb_estoque_produto where produto_id = produtoid && estoque_qtd>0;
end ;;
DELIMITER ;

# TRIGGERS
DELIMITER ;;

 CREATE TRIGGER Tgr_ItensVenda_Delete AFTER DELETE
ON tb_item_venda
FOR EACH ROW
BEGIN
    UPDATE tb_estoque_produto SET tb_estoque_produto.estoque_qtd  =  tb_estoque_produto.estoque_qtd 
    + OLD.item_venda_produto_qtd
WHERE tb_estoque_produto.produto_id = OLD.produto_id;
END ;;
DELIMITER ;


DELIMITER ;;
CREATE TRIGGER Tgr_ItensVenda_Insert AFTER INSERT
ON `tb_item_venda`
FOR EACH ROW
BEGIN
    UPDATE tb_estoque_produto 
    SET tb_estoque_produto.estoque_qtd 
    = tb_estoque_produto.estoque_qtd 
    - NEW.item_venda_produto_qtd
WHERE tb_estoque_produto.produto_id = new.produto_id;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE TRIGGER Tgr_ItensPedid_Insert AFTER INSERT
ON tb_item_pedido
FOR EACH ROW
BEGIN
    UPDATE tb_estoque_produto 
    SET tb_estoque_produto.estoque_qtd 
    = tb_estoque_produto.estoque_qtd 
    - NEW.item_pedido_qtd
WHERE tb_estoque_produto.produto_id = new.produto_id;
END ;;
DELIMITER ;
DELIMITER ;;
CREATE TRIGGER Tgr_ItensPedido_Delete AFTER DELETE
ON tb_item_pedido
FOR EACH ROW
BEGIN
    UPDATE tb_estoque_produto SET tb_estoque_produto.estoque_qtd  =  tb_estoque_produto.estoque_qtd 
    + OLD.item_pedido_qtd
WHERE tb_estoque_produto.produto_id = OLD.produto_id;
#END ;;
#DELIMITER ;
