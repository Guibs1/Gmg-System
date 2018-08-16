package br.com.gestaodeestoque.dao;

import br.com.gestaodeestoque.Models.ItensPedidosModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItensPedidosDAO {
    
    private Connection conexao;
    
    public ItensPedidosDAO(){
        this.conexao = new ConnectionFactory().getConnection(); 
    }
    
    public void cadastraItensPedidos(ItensPedidosModelo itenspedidomodelo)
    {
        try {
            String cmdsql = "insert into tb_item_pedido(pedido_id, produto_id, item_pedido_qtd, item_pedido_valor_unitario, item_pedido_desconto, item_pedido_valor_subtotal)"
                    + "values(?,?,?,?,?,? )";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setInt(1, itenspedidomodelo.getPedido().getPedido_id());
            stmt.setInt(2, itenspedidomodelo.getProduto().getIdProduto());
            stmt.setInt(3, itenspedidomodelo.getItem_pedido_qtd());
            stmt.setDouble(4, itenspedidomodelo.getItem_pedido_valor_unitario());
            stmt.setDouble(5, itenspedidomodelo.getItem_pedido_valor_desconto());
            stmt.setDouble(6, itenspedidomodelo.getItem_pedido_valor_subtotal());
            
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
}
