/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaodeestoque.dao;

import br.com.gestaodeestoque.Models.EstoqueModelo;
import br.com.gestaodeestoque.Models.ProdutoModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guibs
 */
public class EstoqueDAO {

    private Connection conexao;

    public EstoqueDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }
    
    public String valida_qtd_desejada(EstoqueModelo estoquemodelo)
    {
        try {
        String cmdsql= "call Pr_Valida_qtd_desejada(?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(cmdsql);
        stmt.setInt(1, estoquemodelo.getEst_produto_qtd());
        stmt.setInt(2, estoquemodelo.getProduto().getIdProduto());
        ResultSet rs = stmt.executeQuery();
        if(rs.next())
        {
//            while(rs.next()){
        String resultado = rs.getString("Resultado");
        resultado.equals("Em Estoque.");
        return resultado;
//            }
        }
        return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } 
    }

    public List<EstoqueModelo> checaSituacaoEstoque() {
        try {
            List<EstoqueModelo> lista = new ArrayList<EstoqueModelo>();
            String cmdsql = "call pr_condicoes_estoque()";
            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ProdutoModelo produtomodelo = new ProdutoModelo();
                produtomodelo.setNomeProduto(rs.getString("NOME DO PRODUTO"));
                produtomodelo.setDescricaoProduto(rs.getString("DESCRIÇÃO"));
                EstoqueModelo estoque = new EstoqueModelo();
                estoque.setProduto(produtomodelo);
                estoque.setEst_produto_qtd(rs.getInt("QUANTIDADE"));
                estoque.setStatus(rs.getString("SITUAÇÃO"));
                lista.add(estoque);
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    
    public List<EstoqueModelo> checaValidadeProdutos(EstoqueModelo estoquemodelo) {
        try {
            List<EstoqueModelo> lista = new ArrayList<EstoqueModelo>();
            String cmdsql = "call Pr_ChecaValidade(?)";
            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setString(1, estoquemodelo.getData_entrada());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                EstoqueModelo estoque = new EstoqueModelo();
                ProdutoModelo produtomodelo = new ProdutoModelo();
                produtomodelo.setNomeProduto(rs.getString("produto_nome"));
                estoque.setProduto(produtomodelo);
                estoque.setDatavalidade(rs.getString("produto_validade"));
                estoque.setEst_produto_qtd(rs.getInt("DiasValidade"));
                
                lista.add(estoque);
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void AtualizacaoDeEstoque(EstoqueModelo estoqueModelo) {
        try {
            /*String nomedoproduto = estoqueModelo.getNomeproduto();
            String cmdsql1 = "select id_produto from tb_produto where produto_nome like '"+nomedoproduto+"'";
            
            PreparedStatement stmt1 = conexao.prepareStatement(cmdsql1);

            ResultSet rs= stmt1.executeQuery();
            rs.first();
             */
            String cmdsql = "insert into tb_estoque_produto (data_entrada, produto_id, estoque_qtd, estoque_qtd_max, estoque_qtd_min, produto_validade) values (?,?,?,?,?,?)";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setString(1, estoqueModelo.getData_entrada());
            stmt.setInt(2, estoqueModelo.getProduto().getIdProduto());
            stmt.setInt(3, estoqueModelo.getEst_produto_qtd());
            stmt.setInt(4, estoqueModelo.getEstoque_qtd_max());
            stmt.setInt(5, estoqueModelo.getEstoque_qtd_min());
            stmt.setString(6, estoqueModelo.getDatavalidade());

            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar estoque" + e);
        }
    }

    public EstoqueModelo pegarQtdMaxEMin(int id,ProdutoModelo produtomodelo) {
        try {
            EstoqueModelo estoquemodelo = new EstoqueModelo();
            String cmdSql1 = "select * from tb_estoque_produto where produto_id = ?";
            PreparedStatement stmt1 = conexao.prepareStatement(cmdSql1);
            stmt1.setInt(1, id);

            ResultSet rs1 = stmt1.executeQuery();
            if (rs1.next()) {
                String cmdSql = "select tb_estoque_produto.estoque_qtd_max, tb_estoque_produto.estoque_qtd_min from tb_estoque_produto where produto_id = ?";
                PreparedStatement stmt = conexao.prepareStatement(cmdSql);
                stmt.setInt(1, produtomodelo.getIdProduto());
                ResultSet rs = stmt.executeQuery();
                rs.next();
                estoquemodelo.setEstoque_qtd_max(rs.getInt("estoque_qtd_max"));
                estoquemodelo.setEstoque_qtd_min(rs.getInt("estoque_qtd_min"));
                return estoquemodelo;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;

    }

    public List<EstoqueModelo> UltimasAtualizacoes() {
        try {
            List<EstoqueModelo> lista = new ArrayList<EstoqueModelo>();

            String cmdSql = "select tb_estoque_produto.data_entrada, tb_estoque_produto.produto_id, tb_produto.produto_nome, tb_estoque_produto.estoque_qtd,"
                    + " tb_estoque_produto.estoque_qtd_max, tb_estoque_produto.estoque_qtd_min, produto_validade "
                    + " from tb_estoque_produto"
                    + " inner join tb_produto"
                    + " on tb_estoque_produto.produto_id = tb_produto.produto_id";

            PreparedStatement stmt = conexao.prepareStatement(cmdSql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                EstoqueModelo estoque = new EstoqueModelo();
                ProdutoModelo produto = new ProdutoModelo();
                estoque.setData_entrada(rs.getString("data_entrada"));
                
                produto.setIdProduto(rs.getInt("tb_estoque_produto.produto_id"));
                produto.setNomeProduto(rs.getString("produto_nome"));
                estoque.setProduto(produto);

                estoque.setEst_produto_qtd(rs.getInt("estoque_qtd"));
                estoque.setEstoque_qtd_max(rs.getInt("estoque_qtd_max"));
                estoque.setEstoque_qtd_min(rs.getInt("estoque_qtd_min"));
                estoque.setDatavalidade(rs.getString("produto_validade"));

                lista.add(estoque);
            }
            return lista;
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
    
    public void alterDataEntradaEstoque(EstoqueModelo estoquemodelo)
    {
            try {
            String cmdsql = "UPDATE tb_estoque_produto SET "
                    + " data_entrada=?"
                    + " WHERE produto_id=? and produto_validade=?";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setString(1, estoquemodelo.getData_entrada());
            stmt.setInt(2, estoquemodelo.getProduto().getIdProduto());
            stmt.setString(3, estoquemodelo.getDatavalidade());

            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }//fim do try
    }
    
        public void alterQuantidadeEstoque(EstoqueModelo estoquemodelo)
    {
            try {
            String cmdsql = "UPDATE tb_estoque_produto SET estoque_qtd=? "
                    + " WHERE produto_id=? and produto_validade=?";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setInt(1, estoquemodelo.getEst_produto_qtd());
            stmt.setInt(2, estoquemodelo.getProduto().getIdProduto());
            stmt.setString(3, estoquemodelo.getDatavalidade());
            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }//fim do try
    }
        
    public void alterQuantidadeMinEstoque(EstoqueModelo estoquemodelo)
    {
            try {
            String cmdsql = "UPDATE tb_estoque_produto SET "
                    + " estoque_qtd_min=?"
                    + " WHERE produto_id=? and produto_validade=?";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setInt(1, estoquemodelo.getEstoque_qtd_min());
            stmt.setInt(2, estoquemodelo.getProduto().getIdProduto());
            stmt.setString(3, estoquemodelo.getDatavalidade());

            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }//fim do try
    }
    
            
    public void alterQuantidadeMaxEstoque(EstoqueModelo estoquemodelo)
    {
            try {
            String cmdsql = "UPDATE tb_estoque_produto SET "
                    + " estoque_qtd_max=?"
                    + " WHERE produto_id=? and produto_validade=?";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setInt(1, estoquemodelo.getEstoque_qtd_max());
            stmt.setInt(2, estoquemodelo.getProduto().getIdProduto());
            stmt.setString(3, estoquemodelo.getDatavalidade());

            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }//fim do try
    }

    public void excluirAtualizacao(EstoqueModelo estoquemodelo) {
        try {
            String cmdsql = "delete from tb_estoque_produto where data_entrada=? and produto_id=?";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setString(1, estoquemodelo.getData_entrada());
            stmt.setInt(2, estoquemodelo.getProduto().getIdProduto());
            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }//fim do try
    }

    public List<ProdutoModelo> listarProdutosNoCmb() {
        try {
            List<ProdutoModelo> lista = new ArrayList<ProdutoModelo>();

            String cmdSql = "SELECT produto_nome from tb_produto";

            PreparedStatement stmt = conexao.prepareStatement(cmdSql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ProdutoModelo produtos = new ProdutoModelo();
                produtos.setIdProduto(rs.getInt("produto_id"));

                lista.add(produtos);
            }
            return lista;
        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao listar produtos no cmb" + erro);
        }
    }
}
