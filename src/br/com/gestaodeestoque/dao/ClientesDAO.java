package br.com.gestaodeestoque.dao;

import br.com.gestaodeestoque.Models.ClientesModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {

    private Connection conexao;

    public ClientesDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }
    
    public void inserirCliente(ClientesModelo clientesmodelo){
        try {
            String cmdsql = "insert into tb_cliente(cliente_nome, cliente_rg)values(?,?)";
            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setString(1, clientesmodelo.getCliente_nome());
            stmt.setString(2, clientesmodelo.getRg());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<ClientesModelo> listarClientes(){
    
        try {
           List<ClientesModelo> listadeCLientes = new ArrayList<ClientesModelo>(); 
           String cmdsql = "select * from tb_cliente";
           PreparedStatement stmt = conexao.prepareStatement(cmdsql);
           ResultSet rs = stmt.executeQuery();
           while(rs.next())
           {
               ClientesModelo clientemodelo = new ClientesModelo();
               clientemodelo.setCliente_id(rs.getInt("cliente_id"));
               clientemodelo.setCliente_nome(rs.getString("cliente_nome"));
               listadeCLientes.add(clientemodelo);
           }
           return listadeCLientes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
