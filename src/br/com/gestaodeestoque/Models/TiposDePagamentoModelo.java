package br.com.gestaodeestoque.Models;

public class TiposDePagamentoModelo {
    private int pagamentoid;
    private String pagamento_nome;

    public int getPagamentoid() {
        return pagamentoid;
    }

    public void setPagamentoid(int pagamentoid) {
        this.pagamentoid = pagamentoid;
    }

    public String getPagamento_nome() {
        return pagamento_nome;
    }

    public void setPagamento_nome(String pagamento_nome) {
        this.pagamento_nome = pagamento_nome;
    }
    
    @Override
    public String toString(){
        return this.getPagamento_nome();
    }
}
