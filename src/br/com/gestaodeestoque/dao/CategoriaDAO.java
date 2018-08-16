/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaodeestoque.dao;

import br.com.gestaodeestoque.Models.CategoriaModelo;
import br.com.gestaodeestoque.Models.EstoqueModelo;
import br.com.gestaodeestoque.Models.SubCategoriaModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guibs
 */
public class CategoriaDAO {

    private Connection conexao;

    public CategoriaDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }//FimCONEXAO

    public List<CategoriaModelo> listarCategorias() {
        try {
            List<CategoriaModelo> lista = new ArrayList<CategoriaModelo>();

            String cmdSql = "select * from tb_categoria";

            PreparedStatement stmt = conexao.prepareStatement(cmdSql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                CategoriaModelo obj = new CategoriaModelo();
                obj.setIdcategoria(rs.getInt("categoria_id"));
                obj.setCategoria_desc(rs.getString("categoria_nome"));
                lista.add(obj);
            }
            return lista;
        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao Listar Categoria: " + erro);
        }
    }
    
        public void cadastraCategoria(CategoriaModelo categoriamodelo) {
        try {
            String cmdsql = "insert into tb_categoria(categoria_nome)values(?)";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setString(1, categoriamodelo.getCategoria_desc());

            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }//fim do try
    }//fimMetodCad
}
