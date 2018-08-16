/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaodeestoque.dao;

import br.com.gestaodeestoque.Models.CategoriaModelo;
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
public class SubCategoriaDAO {
    
    private Connection conexao;
    
        //AbriCONEXAO
    public SubCategoriaDAO()
    {
        this.conexao = new ConnectionFactory().getConnection();
    }//FimCONEXAO
    
    public void cadastraSubCategoria(SubCategoriaModelo subcategoriamodelo) {
        try {
            String cmdsql = "insert into tb_subcategoria(categoria_id, subcategoria_nome)values (?,?)";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setInt(1, subcategoriamodelo.getCategoria().getIdcategoria());
            stmt.setString(2, subcategoriamodelo.getSubcategoria_nome());

            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }//fim do try
    }//fimMetodCad
    
     public List<SubCategoriaModelo> listarSubCategorias()
    {
    try{
        List<SubCategoriaModelo> lista =new ArrayList<SubCategoriaModelo>();
        
        String cmdSql = "select * from tb_subcategoria";
        
        PreparedStatement stmt = conexao.prepareStatement(cmdSql);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
        SubCategoriaModelo subcategoria = new SubCategoriaModelo();
        subcategoria.setIdsubcategoria(rs.getInt("subcategoria_id"));
            CategoriaModelo categoria = new CategoriaModelo();
        categoria.setIdcategoria(rs.getInt("categoria_id"));
        subcategoria.setCategoria(categoria);
        subcategoria.setSubcategoria_nome(rs.getString("subcategoria_nome"));    
        
        lista.add(subcategoria);
        }
        return lista;
        }catch(SQLException erro){
            throw new RuntimeException("Erro ao Listar SubCategoria"+erro);
        }
    }
}
