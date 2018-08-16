package br.com.gestaodeestoque.dao;

import br.com.gestaodeestoque.Models.ClientesModelo;
import br.com.gestaodeestoque.Models.FuncionarioModelo;
import br.com.gestaodeestoque.Models.PedidosModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PedidosDAO {

    private Connection conexao;

    public PedidosDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    public PedidosModelo cadastrarPedido(PedidosModelo pedido) {
        try {
            String cmdsql = "INSERT INTO tb_pedido(funcionario_id,cliente_id, pedido_horario_retirada,pedido_data,pedido_desconto,pedido_total )values(?,?,?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setInt(1, pedido.getFuncionariomodelo().getFuncionario_id());
            stmt.setInt(2, pedido.getCliente().getCliente_id());
            stmt.setString(3, pedido.getHorario_retirada());
            stmt.setString(4, pedido.getData());
            stmt.setDouble(5, pedido.getDesconto());
            stmt.setDouble(6, pedido.getTotal());
            stmt.execute();
            stmt.close();

            String cmdsql2 = "Select pedido_id from tb_pedido order by pedido_id desc limit 1";
            PreparedStatement stmt2 = conexao.prepareStatement(cmdsql2);
//            stmt2.setInt(1, venda.getFuncionario().getFuncionario_id());
//            stmt2.setString(2, venda.getData());
            ResultSet rs = stmt2.executeQuery();

            rs.next();
            pedido.setPedido_id(rs.getInt("pedido_id"));
            //funcional JOptionPane.showMessageDialog(null,pedido.getPedido_id());
//            stmt2.close();
//            rs.close();
            return pedido;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void fecharPedido(PedidosModelo pedidosmodelo) {
        try {
            String cmdsql = "update tb_pedido set pedido_status=? where pedido_id = ?";
            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setInt(1, pedidosmodelo.getStatus());
            stmt.setInt(2, pedidosmodelo.getPedido_id());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<PedidosModelo> listarPedidos() {
        try {
            List<PedidosModelo> lista = new ArrayList<PedidosModelo>();

            String cmdSql = "SELECT * from tb_pedido";

            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                PedidosModelo pedidosmodelo = new PedidosModelo();
                ClientesModelo cliente = new ClientesModelo();
                cliente.setCliente_id(rs.getInt("cliente_id"));
                pedidosmodelo.setCliente(cliente);
                pedidosmodelo.setHorario_retirada(rs.getString("pedido_horario_retirada"));
                FuncionarioModelo funcionario = new FuncionarioModelo();
                funcionario.setFuncionario_id(rs.getInt("funcionario_id"));
                pedidosmodelo.setFuncionariomodelo(funcionario);
                pedidosmodelo.setPedido_id(rs.getInt("pedido_id"));
                pedidosmodelo.setTotal(rs.getDouble("pedido_total"));
                pedidosmodelo.setData(rs.getString("pedido_data"));
                pedidosmodelo.setDesconto(rs.getDouble("pedido_desconto"));
                pedidosmodelo.setStatusPago(rs.getInt("pedido_pago"));
                pedidosmodelo.setStatus(rs.getInt("pedido_status"));
                lista.add(pedidosmodelo);
            }
            return lista;
        } catch (SQLException erro) {
            throw new RuntimeException("Erro NO BANCO" + erro);
        }
    }
}
