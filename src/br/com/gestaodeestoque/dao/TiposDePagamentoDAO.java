package br.com.gestaodeestoque.dao;

import br.com.gestaodeestoque.Models.TiposDePagamentoModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class TiposDePagamentoDAO {
    
    private Connection conexao;

    public TiposDePagamentoDAO() {
        
        this.conexao = new ConnectionFactory().getConnection();
        
    }
    
        public void cadastraCategoria(TiposDePagamentoModelo tiposdepagamentomodelo) {
        try {
            String cmdsql = "insert into tb_tipo_pagamento(tipo_pagamento_nome)values(?)";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setString(1, tiposdepagamentomodelo.getPagamento_nome());

            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }//fim do try
    }
        
        public List<TiposDePagamentoModelo> listarTiposDePagamento() {
        try {
            List<TiposDePagamentoModelo> lista = new ArrayList<TiposDePagamentoModelo>();

            String cmdSql = "select * from tb_tipo_pagamento";

            PreparedStatement stmt = conexao.prepareStatement(cmdSql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                TiposDePagamentoModelo obj = new TiposDePagamentoModelo();
                obj.setPagamentoid(rs.getInt("tipo_pagamento_id"));
                obj.setPagamento_nome(rs.getString("tipo_pagamento_nome"));
                lista.add(obj);
            }
            return lista;
        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao Listar Tipos de Pagamento: " + erro);
        }
    }
}
