package br.com.gestaodeestoque.dao;

import br.com.gestaodeestoque.Models.FuncionarioModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/*import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;*/

public class FuncionarioDAO {

    private Connection conexao;

    //AbriCONEXAO
    public FuncionarioDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }//FimCONEXAO
    
    public void lembrarLogin(String login){
        try {
            String cmdsql = "insert lembrarLogin (login) values (?)";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();
            rs.first();
            FuncionarioModelo funcionarioAtual = new FuncionarioModelo();
            funcionarioAtual.setFuncionario_login(rs.getString("funcionario_login"));
            stmt.close();
            rs.close();           
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public FuncionarioModelo funcionarioAtual(String login) {
        try {
            String cmdsql = "select * from tb_funcionario where funcionario_login = ?";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();
            rs.first();
            FuncionarioModelo funcionarioAtual = new FuncionarioModelo();
            funcionarioAtual.setFuncionario_id(rs.getInt("funcionario_id"));
            funcionarioAtual.setFuncionario_nome(rs.getString("funcionario_nome"));
            funcionarioAtual.setFuncionario_celular(rs.getString("funcionario_celular"));
            funcionarioAtual.setFuncionario_email(rs.getString("funcionario_email"));
            funcionarioAtual.setFuncionario_login(rs.getString("funcionario_login"));
            stmt.close();
            rs.close();
            return funcionarioAtual;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public FuncionarioModelo procurarFuncionarioEspecificoPor(String campo, JTextField nome) {
        try {
            String cmdsql = "select * from tb_funcionario where " + campo + " like '%" + nome.getText() + "%'";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);

            ResultSet rs = stmt.executeQuery();

            rs.next();
                FuncionarioModelo c = new FuncionarioModelo();
                c.setFuncionario_id(rs.getInt("funcionario_id"));
                c.setFuncionario_nome(rs.getString("funcionario_nome"));
                c.setFuncionario_email(rs.getString("funcionario_email"));
                c.setFuncionario_celular(rs.getString("funcionario_celular"));
                c.setFuncionario_login(rs.getString("funcionario_login"));
                c.setFuncionario_senha(rs.getString("funcionario_senha"));
            
            rs.close();
            stmt.close();

            return c;
        } catch (Exception e) {

            throw new RuntimeException(e);

        }
    }

    public List<FuncionarioModelo> procurarFuncionariosPor(String campo, JTextField nome) {
        try {
            List<FuncionarioModelo> lista = new ArrayList<FuncionarioModelo>();

            String cmdsql = "select * from tb_funcionario where " + campo + " like '%" + nome.getText() + "%'";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                FuncionarioModelo c = new FuncionarioModelo();
                c.setFuncionario_id(rs.getInt("funcionario_id"));
                c.setFuncionario_nome(rs.getString("funcionario_nome"));
                c.setFuncionario_email(rs.getString("funcionario_email"));
                c.setFuncionario_celular(rs.getString("funcionario_celular"));
                c.setFuncionario_login(rs.getString("funcionario_login"));
                lista.add(c);
            }
            rs.close();
            stmt.close();

            return lista;
        } catch (Exception e) {

            throw new RuntimeException(e);

        }
    }

    public String recuperarLogin(String email, String senha) {
        String nada = "Funcionário não encontrado";
        try {
            String cmdsql = "select funcionario_login from tb_funcionario where funcionario_email=? and funcionario_senha=?";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            rs.first();
            nada = rs.getString("funcionario_login");

            stmt.close();

            return nada;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
        }
        return nada;
    }

    public boolean efetuarLogin(String Login, String Senha) {
        try {
            String cmdsql = "select * from tb_funcionario where funcionario_login=? and funcionario_senha=?";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);

            stmt.setString(1, Login);
            stmt.setString(2, Senha);

            ResultSet rs = stmt.executeQuery();

            //verificar se foi encontrado um registro
            if (rs.first()) {//encontro
                return true;
            }
            rs.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao logar");
        }
        return false;
    }

    public void modificarLogin(String email, String novologin) {
        try {
            String cmdsql = "select funcionario_id from tb_funcionario where funcionario_email =?";
            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            rs.first();

            String cmdsql1 = "UPDATE tb_funcionario SET funcionario_login=? WHERE funcionario_id=?";
            PreparedStatement stmt1 = conexao.prepareStatement(cmdsql1);
            stmt1.setString(1, novologin);
            stmt1.setString(2, rs.getString("funcionario_id"));
            stmt1.execute();
            stmt1.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
        }
    }

    public void cadastraFuncionario(FuncionarioModelo funcionariomodelo) {
        try {
            String cmdsql = "call cadastro_Funcionario(?,?,?,?,?)";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setString(1, funcionariomodelo.getFuncionario_nome());
            stmt.setString(2, funcionariomodelo.getFuncionario_email());
            stmt.setString(3, funcionariomodelo.getFuncionario_celular());
            stmt.setString(4, funcionariomodelo.getFuncionario_login());
            stmt.setString(5, funcionariomodelo.getFuncionario_senha());

            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }//fim do try
    }//fimMetodCad

    public List<FuncionarioModelo> listarFuncionarios() {
        try {
            List<FuncionarioModelo> lista = new ArrayList<FuncionarioModelo>();

            String cmdSql = "select * from tb_funcionario";

            PreparedStatement stmt = conexao.prepareStatement(cmdSql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                FuncionarioModelo modelo = new FuncionarioModelo();
                modelo.setFuncionario_id(rs.getInt("funcionario_id"));
                modelo.setFuncionario_nome(rs.getString("funcionario_nome"));
                modelo.setFuncionario_email(rs.getString("funcionario_email"));
                modelo.setFuncionario_celular(rs.getString("funcionario_celular"));
                modelo.setFuncionario_login(rs.getString("funcionario_login"));

                lista.add(modelo);
            }
            return lista;
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    public void alterarUsuario(FuncionarioModelo funcionariomodelo) {
        try {
            String cmdsql = "update tb_funcionario set funcionario_nome=?, funcionario_email=?, funcionario_celular=?,"
                    + " funcionario_login=? where funcionario_id=?";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setString(1, funcionariomodelo.getFuncionario_nome());
            stmt.setString(2, funcionariomodelo.getFuncionario_email());
            stmt.setString(3, funcionariomodelo.getFuncionario_celular());
            stmt.setString(4, funcionariomodelo.getFuncionario_login());
            stmt.setInt(5, funcionariomodelo.getFuncionario_id());

            stmt.execute();

            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }//fim do try
    }

    public void alterarNomeUsuario(FuncionarioModelo funcionariomodelo) {
        try {
            String cmdsql = "update tb_funcionario set funcionario_nome=?"
                    + " where funcionario_id=?";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setString(1, funcionariomodelo.getFuncionario_nome());
            stmt.setInt(2, funcionariomodelo.getFuncionario_id());

            stmt.execute();

            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }//fim do try
    }

    public void alterarEmailUsuario(FuncionarioModelo funcionariomodelo) {
        try {
            String cmdsql = "update tb_funcionario set funcionario_email=?"
                    + " where funcionario_id=?";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setString(1, funcionariomodelo.getFuncionario_email());
            stmt.setInt(2, funcionariomodelo.getFuncionario_id());

            stmt.execute();

            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }//fim do try
    }

    public void alterarCelularUsuario(FuncionarioModelo funcionariomodelo) {
        try {
            String cmdsql = "update tb_funcionario set funcionario_celular=? where funcionario_id=?";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setString(1, funcionariomodelo.getFuncionario_celular());
            stmt.setInt(2, funcionariomodelo.getFuncionario_id());

            stmt.execute();

            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }//fim do try
    }

    public void alterarLoginUsuario(FuncionarioModelo funcionariomodelo) {
        try {
            String cmdsql = "update tb_funcionario set funcionario_login=? where funcionario_id=?";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setString(1, funcionariomodelo.getFuncionario_login());
            stmt.setInt(2, funcionariomodelo.getFuncionario_id());

            stmt.execute();

            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }//fim do try
    }

    public void excluirUsuario(FuncionarioModelo funcionariomodelo) {
        try {
            String cmdsql = "delete from tb_funcionario where funcionario_id=?";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setInt(1, funcionariomodelo.getFuncionario_id());

            stmt.execute();

            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }//fim do try
    }
/*
    public void criarRelatorio() {
        String src = "reportFuncionarios.jasper";

        JasperPrint jasperPrint = null;
        
        try {
        jasperPrint = JasperFillManager.fillReport(src, null, conexao);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro" + e);
        }

        JasperViewer view = new JasperViewer(jasperPrint, false);
        view.setVisible(true);
    }*/
}
