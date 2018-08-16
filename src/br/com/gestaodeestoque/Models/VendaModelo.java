package br.com.gestaodeestoque.Models;

public class VendaModelo {
    private int venda_id;
    private FuncionarioModelo funcionario;
    private String data;
    private int qtd;
    private ProdutoModelo produto;
    private double venda_sem_desconto;
    private double venda_desconto;
    private double venda_total;
    private int vendaStatus;

    public int getVendaStatus() {
        return vendaStatus;
    }

    public void setVendaStatus(int vendaStatus) {
        this.vendaStatus = vendaStatus;
    }
    
    public int getVenda_id() {
        return venda_id;
    }

    public void setVenda_id(int venda_id) {
        this.venda_id = venda_id;
    }

    
    public FuncionarioModelo getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioModelo funcionario) {
        this.funcionario = funcionario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public ProdutoModelo getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModelo produto) {
        this.produto = produto;
    }

    public double getVenda_sem_desconto() {
        return venda_sem_desconto;
    }

    public void setVenda_sem_desconto(double venda_sem_desconto) {
        this.venda_sem_desconto = venda_sem_desconto;
    }

    public double getVenda_desconto() {
        return venda_desconto;
    }

    public void setVenda_desconto(double venda_desconto) {
        this.venda_desconto = venda_desconto;
    }

    public double getVenda_total() {
        return venda_total;
    }

    public void setVenda_total(double venda_total) {
        this.venda_total = venda_total;
    }
    
}
