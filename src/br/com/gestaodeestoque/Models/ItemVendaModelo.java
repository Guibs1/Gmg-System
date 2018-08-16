package br.com.gestaodeestoque.Models;

public class ItemVendaModelo {
    private VendaModelo venda;
    private ProdutoModelo produto;
    private int qtd;
    private double valorUni;
    private double desconto;
    private double subtotal;

    public VendaModelo getVenda() {
        return venda;
    }

    public void setVenda(VendaModelo venda) {
        this.venda = venda;
    }

    public ProdutoModelo getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModelo produto) {
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getValorUni() {
        return valorUni;
    }

    public void setValorUni(double valorUni) {
        this.valorUni = valorUni;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    
}
