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
public class EstoqueModelo {
    
   private String data_entrada;
   private ProdutoModelo produto;
   private int est_produto_qtd;
   private int estoque_qtd_max;
   private int estoque_qtd_min;
   private String data_saida;
   private String datavalidade;
   private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
    public String getDatavalidade() {
        return datavalidade;
    }

    public void setDatavalidade(String datavalidade) {
        this.datavalidade = datavalidade;
    }

    public ProdutoModelo getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModelo produto) {
        this.produto = produto;
    }

    public String getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(String data_entrada) {
        this.data_entrada = data_entrada;
    }

    public int getEst_produto_qtd() {
        return est_produto_qtd;
    }

    public void setEst_produto_qtd(int est_produto_qtd) {
        this.est_produto_qtd = est_produto_qtd;
    }

    public int getEstoque_qtd_max() {
        return estoque_qtd_max;
    }

    public void setEstoque_qtd_max(int estoque_qtd_max) {
        this.estoque_qtd_max = estoque_qtd_max;
    }

    public int getEstoque_qtd_min() {
        return estoque_qtd_min;
    }

    public void setEstoque_qtd_min(int estoque_qtd_min) {
        this.estoque_qtd_min = estoque_qtd_min;
    }

    public String getData_saida() {
        return data_saida;
    }

    public void setData_saida(String data_saida) {
        this.data_saida = data_saida;
    }
   
   
}
