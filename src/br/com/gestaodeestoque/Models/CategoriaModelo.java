/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaodeestoque.Models;

/**
 *
 * @author Guibs
 */
public class CategoriaModelo {
    
    private int idcategoria;
    private String categoria_desc;

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getCategoria_desc() {
        return categoria_desc;
    }

    public void setCategoria_desc(String categoria_desc) {
        this.categoria_desc = categoria_desc;
    }
    
    @Override
    public String toString(){
        return this.getCategoria_desc();
    }
    
}
