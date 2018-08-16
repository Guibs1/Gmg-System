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
public class SubCategoriaModelo {
    
    private int idsubcategoria;
    private CategoriaModelo categoria;
    private String subcategoria_nome;

    public CategoriaModelo getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModelo categoria) {
        this.categoria = categoria;
    }

    public int getIdsubcategoria() {
        return idsubcategoria;
    }

    public void setIdsubcategoria(int idsubcategoria) {
        this.idsubcategoria = idsubcategoria;
    }

    public String getSubcategoria_nome() {
        return subcategoria_nome;
    }

    public void setSubcategoria_nome(String subcategoria_nome) {
        this.subcategoria_nome = subcategoria_nome;
    }
    
    @Override
    public String toString(){
        return this.getSubcategoria_nome();
    }
}
