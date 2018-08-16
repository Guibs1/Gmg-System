package br.com.gestaodeestoque.Models;

public class ClientesModelo {
    private int cliente_id;
    private String cliente_nome;
    private String rg;

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getCliente_nome() {
        return cliente_nome;
    }

    public void setCliente_nome(String cliente_nome) {
        this.cliente_nome = cliente_nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

        @Override
    public String toString(){
        return this.getCliente_nome();
    }
}
