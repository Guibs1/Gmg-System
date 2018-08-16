package br.com.gestaodeestoque.dao;

import br.com.gestaodeestoque.Models.FuncionarioModelo;
import br.com.gestaodeestoque.Models.ItensVendaModelo;
import br.com.gestaodeestoque.Models.ProdutoModelo;
import br.com.gestaodeestoque.Models.SubCategoriaModelo;
import br.com.gestaodeestoque.Models.VendaModelo;
//import com.mxrck.autocompleter.TextAutoCompleter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VendasDAO {

    private Connection conexao;

    public VendasDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    public VendaModelo abrirVenda(VendaModelo venda) {
        try {
            String cmdsql = "INSERT INTO tb_venda(funcionario_id,venda_data)values(?,?)";
            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setInt(1, venda.getFuncionario().getFuncionario_id());
            stmt.setString(2, venda.getData());
            stmt.execute();
            stmt.close();
            String cmdsql2 = "Select * from tb_venda order by venda_id desc limit 1";
            PreparedStatement stmt2 = conexao.prepareStatement(cmdsql2);
            ResultSet rs = stmt2.executeQuery();
            rs.next();
            venda.setVenda_id(rs.getInt("venda_id"));
            venda.setData(rs.getString("venda_data"));
//            stmt2.close();
//            rs.close();
            return venda;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void setaDescontoETotal(VendaModelo vendamodelo) {
        try {
            String cmdsql = "update tb_venda set venda_sem_desconto=?, venda_desconto=?, venda_total=?  where venda_id = ?";
            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setDouble(1, vendamodelo.getVenda_sem_desconto());
            stmt.setDouble(2, vendamodelo.getVenda_desconto());
            stmt.setDouble(3, vendamodelo.getVenda_total());
            stmt.setInt(4, vendamodelo.getVenda_id());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void fecharVenda(VendaModelo venda) {
        try {
            String cmdsql = "update tb_venda set venda_status=? where venda_id = ?";
            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setInt(1, venda.getVendaStatus());
            stmt.setInt(2, venda.getVenda_id());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cancelarVenda(VendaModelo venda) {
        try {
//            if(tabelapedidotiveralgo, da dois delete else um só em venda)
            String cmdsql = "delete from tb_venda where venda_id = ?";
            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setInt(1, venda.getVenda_id());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void  coisas(){
        //aprimora
//    public VendaModelo idVendaEmAberta() {
//        try {
//            String cmdsql = "SELECT venda_id, venda_data, funcionario_id FROM tb_venda where venda_total IS NULL order by venda_id desc";
//            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
//            ResultSet rs = stmt.executeQuery();
//            rs.last();
//            VendaModelo venda = new VendaModelo();
//            venda.setVenda_id(rs.getInt("venda_id"));
//            venda.setData(rs.getString("venda_data"));
//            FuncionarioModelo funcionario = new FuncionarioModelo();
//            funcionario.setFuncionario_id(rs.getInt("funcionario_id"));
//            venda.setFuncionario(funcionario);
//            return venda;
//        } catch (Exception e) {
//            throw new RuntimeException("Erro NO BANCO" + e);
//        }
//        // return ;
//    }

    }

    
    
}
