package br.com.gestaodeestoque.Models;

public class ProdutoModelo {
    private int idProduto;
    private long codBarraProduto;
    private String nomeProduto;
    private SubCategoriaModelo subcategoria;
    private String descricaoProduto;
    private double precoCusto;
    private double precoVenda;
    private double comissao;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int id_produto) {
        this.idProduto = id_produto;
    }

    public long getCodBarraProduto() {
        return codBarraProduto;
    }

    public void setCodBarraProduto(long codBarraProduto) {
        this.codBarraProduto = codBarraProduto;
    }
   
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public SubCategoriaModelo getSubCategoria() {
        return subcategoria;
    }

    public void setSubCategoria(SubCategoriaModelo subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
        
    @Override
    public String toString(){
        return this.getNomeProduto();
    }
}
