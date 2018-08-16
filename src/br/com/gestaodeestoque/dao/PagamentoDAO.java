package br.com.gestaodeestoque.dao;

import br.com.gestaodeestoque.Models.PagamentoModelo;
import br.com.gestaodeestoque.Models.PedidosModelo;
import br.com.gestaodeestoque.Models.VendaModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PagamentoDAO {

    private Connection conexao;

    public PagamentoDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    public void inserirPagamentoPedido(PagamentoModelo pagamento) {
        try {
            String cmdsql = "INSERT INTO tb_pagamento (pedido_id, tipo_pagamento_id, valor_pago, valor_total_com_desconto) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setInt(1, pagamento.getPedido().getPedido_id());
            stmt.setInt(2, pagamento.getTipo_pagamento().getPagamentoid());
            stmt.setDouble(3, pagamento.getValor_pago());
            stmt.setDouble(4, pagamento.getValor_total());
            stmt.execute();
            stmt.close();

            String cmdsql2 = "update tb_pedido set pedido_pago=? where pedido_id = ?";
            PreparedStatement stmt2 = conexao.prepareStatement(cmdsql2);
            stmt2.setInt(1, pagamento.getPedido().getStatusPago());
            stmt2.setInt(2, pagamento.getPedido().getPedido_id());

            stmt2.execute();
            stmt2.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void inserirPagamentoVenda(PagamentoModelo pagamento) {
        try {
            String cmdsql = "INSERT INTO tb_pagamento (venda_id, tipo_pagamento_id, valor_pago, valor_total_com_desconto) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setInt(1, pagamento.getVenda().getVenda_id());
            stmt.setInt(2, pagamento.getTipo_pagamento().getPagamentoid());
            stmt.setDouble(3, pagamento.getValor_pago());
            stmt.setDouble(4, pagamento.getValor_total());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PagamentoModelo checarSeVendaFoiPaga(VendaModelo vendamodelo) {
        try {

            String cmdsql = "select sum(valor_pago) as valor_pago  from tb_pagamento where venda_id = ?";
            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setInt(1, vendamodelo.getVenda_id());
            ResultSet rs = stmt.executeQuery();

            rs.next();
            PagamentoModelo qtdpago = new PagamentoModelo();
            qtdpago.setValor_pago(rs.getDouble("valor_pago"));

            return qtdpago;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public PagamentoModelo checarSePedidoFoiPagoTotalmente(PedidosModelo pedidosmodelo) {
        try {

            String cmdsql = "select sum(valor_pago) as valor_pago  from tb_pagamento where pedido_id = ?";
            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setInt(1, pedidosmodelo.getPedido_id());
            ResultSet rs = stmt.executeQuery();

            rs.next();
            PagamentoModelo qtdpago = new PagamentoModelo();
            qtdpago.setValor_pago(rs.getDouble("valor_pago"));

            return qtdpago;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
//
//        public void cancelarPagamento(PagamentoModelo pagamento) {
//        try {
////            if(tabelapedidotiveralgo, da dois delete else um só em venda)
//            String cmdsql = "delete from tb_pagamento where pagamento_id = ?";
//            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
//            stmt.setInt(1, pagamento.getPagamento_id());
//            stmt.execute();
//            stmt.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
        
    public void alterarPagamento(PagamentoModelo pagamento) {

    }

    public void deletarPagamento(PagamentoModelo pagamento) {

    }

    public void ListarPagamentos(PagamentoModelo pagamento) {

    }
}
