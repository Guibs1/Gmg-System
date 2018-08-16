package br.com.gestaodeestoque.Models;

public class ItensPedidosModelo {
    
    private ProdutoModelo produto;
    private PedidosModelo pedido;
    private int item_pedido_qtd;
    private double item_pedido_valor_unitario;
    private double item_pedido_valor_desconto;
    private double item_pedido_valor_subtotal;

    public ProdutoModelo getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModelo produto) {
        this.produto = produto;
    }

    public PedidosModelo getPedido() {
        return pedido;
    }

    public void setPedido(PedidosModelo pedido) {
        this.pedido = pedido;
    }

    public int getItem_pedido_qtd() {
        return item_pedido_qtd;
    }

    public void setItem_pedido_qtd(int item_pedido_qtd) {
        this.item_pedido_qtd = item_pedido_qtd;
    }

    public double getItem_pedido_valor_unitario() {
        return item_pedido_valor_unitario;
    }

    public void setItem_pedido_valor_unitario(double item_pedido_valor_unitario) {
        this.item_pedido_valor_unitario = item_pedido_valor_unitario;
    }

    public double getItem_pedido_valor_desconto() {
        return item_pedido_valor_desconto;
    }

    public void setItem_pedido_valor_desconto(double item_pedido_valor_desconto) {
        this.item_pedido_valor_desconto = item_pedido_valor_desconto;
    }

    public double getItem_pedido_valor_subtotal() {
        return item_pedido_valor_subtotal;
    }

    public void setItem_pedido_valor_subtotal(double item_pedido_valor_subtotal) {
        this.item_pedido_valor_subtotal = item_pedido_valor_subtotal;
    }
    
    
}
