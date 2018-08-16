package br.com.gestaodeestoque.Models;

public class PedidosModelo {
    private int pedido_id;
    private FuncionarioModelo funcionariomodelo;
    private ClientesModelo cliente;
    private String horario_retirada;
    private String data;
    private double desconto;
    private double total;
    private int statusPago;
    private int status;

    public int getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(int pedido_id) {
        this.pedido_id = pedido_id;
    }

    public FuncionarioModelo getFuncionariomodelo() {
        return funcionariomodelo;
    }

    public void setFuncionariomodelo(FuncionarioModelo funcionariomodelo) {
        this.funcionariomodelo = funcionariomodelo;
    }

    public ClientesModelo getCliente() {
        return cliente;
    }

    public void setCliente(ClientesModelo cliente) {
        this.cliente = cliente;
    }

    public String getHorario_retirada() {
        return horario_retirada;
    }

    public void setHorario_retirada(String horario_retirada) {
        this.horario_retirada = horario_retirada;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getStatusPago() {
        return statusPago;
    }

    public void setStatusPago(int status) {
        this.statusPago = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
