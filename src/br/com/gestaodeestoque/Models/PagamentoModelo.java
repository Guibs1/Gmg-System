package br.com.gestaodeestoque.Models;

public class PagamentoModelo {
    private int pagamento_id;
    private VendaModelo venda;
    private PedidosModelo pedido;
    private TiposDePagamentoModelo tipo_pagamento;
    private double valor_pago;
    private double valor_total;

    public int getPagamento_id() {
        return pagamento_id;
    }

    public void setPagamento_id(int pagamento_id) {
        this.pagamento_id = pagamento_id;
    }

    public VendaModelo getVenda() {
        return venda;
    }

    public void setVenda(VendaModelo venda) {
        this.venda = venda;
    }

    public TiposDePagamentoModelo getTipo_pagamento() {
        return tipo_pagamento;
    }

    public void setTipo_pagamento(TiposDePagamentoModelo tipo_pagamento) {
        this.tipo_pagamento = tipo_pagamento;
    }

    public double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(double valor_pago) {
        this.valor_pago = valor_pago;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public PedidosModelo getPedido() {
        return pedido;
    }

    public void setPedido(PedidosModelo pedido) {
        this.pedido = pedido;
    }
    
}
