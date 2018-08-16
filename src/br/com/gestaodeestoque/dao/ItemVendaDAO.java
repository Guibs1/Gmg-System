package br.com.gestaodeestoque.dao;

import br.com.gestaodeestoque.Models.ItensVendaModelo;
import br.com.gestaodeestoque.Models.VendaModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemVendaDAO {

    private Connection conexao;
    
    public ItemVendaDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }
    
    public void inserir(ItensVendaModelo itemvenda) {
        try {//rs.last
                String cmdsql = "INSERT INTO tb_item_venda( "
                + "venda_id, "
                + "produto_id, "
                + "item_venda_produto_qtd, "
                + "item_venda_valor_unitario, "
                + "item_venda_desconto,"
                + "item_venda_valor_subtotal)values(?,?,?,?,?,?);";
            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setInt(1, itemvenda.getVenda().getVenda_id());
            stmt.setInt(2, itemvenda.getProduto().getIdProduto());
            stmt.setInt(3, itemvenda.getQtd());
            stmt.setDouble(4, itemvenda.getValorUni());
            stmt.setDouble(5, itemvenda.getDesconto());
            stmt.setDouble(6, itemvenda.getSubtotal());
            stmt.execute();
            stmt.close();
                    
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
        
    public void apagarItensVenda(VendaModelo itemvendamodelo)
    {
        try {
//            if(tabelapedidotiveralgo, da dois delete else um só em venda)
            String cmdsql = "delete from tb_item_venda where venda_id = ?";
            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setInt(1, itemvendamodelo.getVenda_id());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
