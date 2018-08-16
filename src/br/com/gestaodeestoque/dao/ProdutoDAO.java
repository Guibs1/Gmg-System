package br.com.gestaodeestoque.dao;

import br.com.gestaodeestoque.Models.CategoriaModelo;
import br.com.gestaodeestoque.Models.ProdutoModelo;
import br.com.gestaodeestoque.Models.SubCategoriaModelo;
//import com.mxrck.autocompleter.TextAutoCompleter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.view.JasperViewer;

public class ProdutoDAO {

    private Connection conexao;

    //AbriCONEXAO
    public ProdutoDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }//FimCONEXAO

    public List<ProdutoModelo> buscarProdutoPorNome(String campo, JTextField txtcampo) {
        try {
//            ProdutoModelo venda = new ProdutoModelo();
            List<ProdutoModelo> lista = new ArrayList<ProdutoModelo>();

            //2 Passo - ciar o comando sql
            String cmdSql = "select tb_produto.produto_id, tb_subcategoria.subcategoria_nome, "
                    + "        tb_produto.produto_nome, tb_produto.produto_desc, tb_produto.produto_preco_custo, "
                    + "        tb_produto.produto_preco_venda, tb_produto.produto_comissao "
                    + "        from tb_produto inner join tb_subcategoria on "
                    + "        tb_subcategoria.subcategoria_id = tb_produto.subcategoria_id "
                    + "  where " + campo + " like '%" + txtcampo.getText() + "%'";
            //fim comando

            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            ResultSet rs = stmt.executeQuery();

            SubCategoriaModelo subcategoria = new SubCategoriaModelo();

            while (rs.next()) {
                //Define qual campo vai ser autocompletar
//                lista.add(rs.getString("tb_produto.produto_nome"));
//                modelo.addElement(rs.getString("produto_nome"));
                ProdutoModelo produto = new ProdutoModelo();
                produto.setIdProduto((rs.getInt("tb_produto.produto_id")));
                subcategoria.setSubcategoria_nome((rs.getString("tb_subcategoria.subcategoria_nome")));
                produto.setSubCategoria(subcategoria);
                produto.setNomeProduto((rs.getString("tb_produto.produto_nome")));
                produto.setDescricaoProduto((rs.getString("tb_produto.produto_desc")));
                produto.setPrecoCusto((rs.getDouble("tb_produto.produto_preco_custo")));
                produto.setPrecoVenda((rs.getDouble("tb_produto.produto_preco_venda")));
                produto.setComissao((rs.getDouble("tb_produto.produto_comissao")));
//                venda.setProduto(produto);
                lista.add(produto);
            }
//            stmt.close();
            return lista;
        } catch (SQLException erro) {

            throw new RuntimeException(erro);
        }
    }

    public ProdutoModelo ProcurarProdutoPorQlqCampo(String campo, Object procura) {
        try {
            String cmdsql = "select tb_subcategoria.subcategoria_nome,tb_produto.* from tb_produto inner join tb_subcategoria on tb_subcategoria.subcategoria_id = tb_produto.subcategoria_id "
                    + "where " + campo + " = ?";
            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setObject(1, procura);
            ResultSet rs = stmt.executeQuery();

            ProdutoModelo produtomodelo = new ProdutoModelo();
            SubCategoriaModelo subcategoriamodelo = new SubCategoriaModelo();
//            CategoriaModelo categoriamodelo = new CategoriaModelo();
            if(rs.next()){
            produtomodelo.setIdProduto(rs.getInt("produto_id"));
            produtomodelo.setNomeProduto(rs.getString("produto_nome"));
//            subcategoriamodelo.setSubcategoria_nome(rs.getString("subcategoria_nome"));
            subcategoriamodelo.setSubcategoria_nome(rs.getString("subcategoria_nome"));
            produtomodelo.setSubCategoria(subcategoriamodelo);
            produtomodelo.setDescricaoProduto(rs.getString("produto_desc"));
            produtomodelo.setPrecoVenda(rs.getDouble("produto_preco_venda"));
            produtomodelo.setPrecoCusto(rs.getDouble("produto_preco_custo"));
            produtomodelo.setComissao(rs.getDouble("produto_comissao"));
            stmt.close();
            rs.close();
            }
            return produtomodelo;
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

//    public void pesquisar(String campo, JTextField txtpesquisa, ProdutoModelo p){
//        TextAutoCompleter pes = new TextAutoCompleter(txtpesquisa);
//        try {
//            PreparedStatement stmt = this.conexao.prepareStatement("Select * from tb_produto where " + campo+ "like '%"+ txtpesquisa.getText()+"%'");
//            
//            ResultSet rs = stmt.executeQuery();
//            
//            while (rs.next())
//            {
//            pes.addItem(rs.getString("produto_nome"));
////            p.setIdProduto(rs.getInt("produto_id"));
//            
//            }
//        } catch (Exception e) {
//        }
//    }
    public void cadastraProduto(ProdutoModelo obj) {
        try {

            //String nomedacategoria = produtoModelo.getCategoria().getIdcategoria();
            // String cmdsql1 = "select id_categoria from tb_categoria where categoria_nome like '" + nomedacategoria + "'";
            String sql = "INSERT INTO tb_produto (subcategoria_id, "
                    + "                           produto_nome, "
                    + "                           produto_preco_custo,"
                    + "                           produto_preco_venda,"
                    + "                           produto_comissao,"
                    + "                           produto_desc,"
                    + "                           codigo_barra) "
                    + "                           VALUES (?, ?, ?, ?, ?, ?,?)";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, obj.getSubCategoria().getIdsubcategoria());
            stmt.setString(2, obj.getNomeProduto());
            stmt.setDouble(3, obj.getPrecoCusto());
            stmt.setDouble(4, obj.getPrecoVenda());
            stmt.setDouble(5, obj.getComissao());
            stmt.setString(6, obj.getDescricaoProduto());
            stmt.setLong(7, obj.getCodBarraProduto());

            stmt.execute();

            stmt.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
    }
    public void cadastraProdutoSemCodBarra(ProdutoModelo obj) {
        try {

            //String nomedacategoria = produtoModelo.getCategoria().getIdcategoria();
            // String cmdsql1 = "select id_categoria from tb_categoria where categoria_nome like '" + nomedacategoria + "'";
            String sql = "INSERT INTO tb_produto (subcategoria_id, "
                    + "                           produto_nome, "
                    + "                           produto_preco_custo,"
                    + "                           produto_preco_venda,"
                    + "                           produto_comissao,"
                    + "                           produto_desc) "
                    + "                           VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, obj.getSubCategoria().getIdsubcategoria());
            stmt.setString(2, obj.getNomeProduto());
            stmt.setDouble(3, obj.getPrecoCusto());
            stmt.setDouble(4, obj.getPrecoVenda());
            stmt.setDouble(5, obj.getComissao());
            stmt.setString(6, obj.getDescricaoProduto());

            stmt.execute();

            stmt.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
    }
    
    public List<ProdutoModelo> listarProdutos() {
        try {
            List<ProdutoModelo> lista = new ArrayList<ProdutoModelo>();

            String cmdSql = "SELECT tb_produto.produto_id, tb_categoria.categoria_nome, tb_subcategoria.subcategoria_nome, "
                    + "tb_produto.produto_nome, tb_produto.produto_desc, tb_produto.produto_preco_custo, tb_produto.produto_preco_venda, "
                    + "tb_produto.produto_comissao from bd_estoque.tb_produto inner join tb_subcategoria on "
                    + "tb_subcategoria.subcategoria_id = tb_produto.subcategoria_id "
                    + "inner join tb_categoria on tb_categoria.categoria_id = tb_subcategoria.categoria_id";

            PreparedStatement stmt = conexao.prepareStatement(cmdSql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ProdutoModelo produtos = new ProdutoModelo();
                produtos.setIdProduto(rs.getInt("produto_id"));
                SubCategoriaModelo submodelo = new SubCategoriaModelo();
                submodelo.setSubcategoria_nome(rs.getString("tb_subcategoria.subcategoria_nome"));
                produtos.setSubCategoria(submodelo);
                CategoriaModelo modelo = new CategoriaModelo();
                modelo.setCategoria_desc(rs.getString("tb_categoria.categoria_nome"));
                produtos.getSubCategoria().setCategoria(modelo);
                produtos.setNomeProduto(rs.getString("produto_nome"));
                produtos.setPrecoCusto(rs.getDouble("produto_preco_custo"));
                produtos.setPrecoVenda(rs.getDouble("produto_preco_venda"));
                produtos.setComissao(rs.getDouble("produto_comissao"));
                produtos.setDescricaoProduto(rs.getString("produto_desc"));

                lista.add(produtos);
            }
            return lista;
        } catch (SQLException erro) {
            throw new RuntimeException("Erro NO BANCO" + erro);
        }
    }

    public void alterarProduto(ProdutoModelo produtomodelo) {
        try {
            String cmdsql = "UPDATE tb_produto SET "
                    + " produto_nome=?,"
                    + " produto_preco_custo=?,"
                    + " produto_preco_venda=?,"
                    + " produto_desc=?"
                    + " WHERE produto_id=?";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
//            stmt.setInt(1, produtomodelo.getSubCategoria().getIdsubcategoria());
            stmt.setString(1, produtomodelo.getNomeProduto());
            stmt.setDouble(2, produtomodelo.getPrecoCusto());
            stmt.setDouble(3, produtomodelo.getPrecoVenda());
            stmt.setString(4, produtomodelo.getDescricaoProduto());

            stmt.setInt(5, produtomodelo.getIdProduto());

            stmt.execute();

            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }//fim do try
    }
        public void alterarNomeProduto(ProdutoModelo produtomodelo) {
        try {
            String cmdsql = "UPDATE tb_produto SET "
                    + " produto_nome=?"
                    + " WHERE produto_id=?";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
//            stmt.setInt(1, produtomodelo.getSubCategoria().getIdsubcategoria());
            stmt.setString(1, produtomodelo.getNomeProduto());


            stmt.setInt(2, produtomodelo.getIdProduto());

            stmt.execute();

            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }//fim do try
    }
            public void alterarPrecoCustoProduto(ProdutoModelo produtomodelo) {
        try {
            String cmdsql = "UPDATE tb_produto SET "
                    + " produto_preco_custo=?,"
                    + " produto_comissao=?"
                    + " WHERE produto_id=?";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setDouble(1, produtomodelo.getPrecoCusto());
            stmt.setDouble(2, produtomodelo.getComissao());

            stmt.setInt(3, produtomodelo.getIdProduto());

            stmt.execute();

            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }//fim do try
    }
                public void alterarPrecoVendaProduto(ProdutoModelo produtomodelo) {
        try {
            String cmdsql = "UPDATE tb_produto SET "
                    + " produto_preco_venda=?,"
                    + " produto_comissao=?"
                    + " WHERE produto_id=?";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setDouble(1, produtomodelo.getPrecoVenda());
            stmt.setDouble(2, produtomodelo.getComissao());
            stmt.setInt(3, produtomodelo.getIdProduto());

            stmt.execute();

            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }//fim do try
    }
                    public void alterarDescricaoProduto(ProdutoModelo produtomodelo) {
        try {
            String cmdsql = "UPDATE tb_produto SET "
                    + " produto_desc=?"
                    + " WHERE produto_id=?";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setString(1, produtomodelo.getDescricaoProduto());

            stmt.setInt(2, produtomodelo.getIdProduto());

            stmt.execute();

            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }//fim do try
    }

    public void excluirProduto(ProdutoModelo produtomodelo) {
        try {
            String cmdsql = "delete from tb_produto where produto_id=?";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setInt(1, produtomodelo.getIdProduto());

            stmt.execute();

            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }//fim do try
    }
    
//        public void criarRelatorio() {
//        String src = "RelatorioProdutos.jasper";
//
//        JasperPrint jasperPrint = null;
//        
//        try {
//        jasperPrint = JasperFillManager.fillReport(src, null, conexao);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "erro" + e);
//        }
//
//        JasperViewer view = new JasperViewer(jasperPrint, false);
//        view.setVisible(true);
//    }

}
