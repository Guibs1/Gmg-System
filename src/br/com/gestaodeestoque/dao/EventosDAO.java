package br.com.gestaodeestoque.dao;

import br.com.gestaodeestoque.Models.EventosModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventosDAO {

    private Connection conexao;

    public EventosDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    public void inserirEventos(EventosModelo eventosmodelo) {
        try {
            String cmdsql = "insert into tb_eventos(evento_titulo, evento_data_inicio, evento_desc, evento_data_termino)values (?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setString(1, eventosmodelo.getEvento_titulo());
            stmt.setString(2, eventosmodelo.getData_inicio());
            stmt.setString(3, eventosmodelo.getEvento_desc());
            stmt.setString(4, eventosmodelo.getEvento_data_termino());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public List<EventosModelo> listarEventos() {
        try {
            List<EventosModelo> lista = new ArrayList<EventosModelo>();

            String cmdSql = "SELECT * from tb_eventos";

            PreparedStatement stmt = conexao.prepareStatement(cmdSql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                EventosModelo eventos = new EventosModelo();
                eventos.setData_inicio(rs.getString("evento_data_inicio"));
                eventos.setEvento_data_termino(rs.getString("evento_data_termino"));
                eventos.setEvento_desc(rs.getString("evento_desc"));
                eventos.setEvento_titulo(rs.getString("evento_titulo"));

                lista.add(eventos);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar eventos." + e);
        }
    }
        
        public List<EventosModelo> listarEventosProx(String dataAtual)
        {
            try {
                List<EventosModelo> lista = new ArrayList<EventosModelo>();
                String cmdsql = "call pr_Dias_Para_Eventos(?)";
                PreparedStatement stmt = conexao.prepareStatement(cmdsql);
                stmt.setString(1, dataAtual);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                EventosModelo eventos = new EventosModelo();
                eventos.setData_inicio(rs.getString("evento_data_inicio"));
                eventos.setEvento_data_termino(rs.getString("evento_data_termino"));
                eventos.setEvento_titulo(rs.getString("evento_titulo"));
                eventos.setEventosProx(rs.getInt("DiasRestante"));

                lista.add(eventos);
            }
            return lista;
                
            } catch (Exception e) {
                throw new RuntimeException("Erro ao listar eventos próximos." + e);
            }
        }
}
