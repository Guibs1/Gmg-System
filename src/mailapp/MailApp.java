package mailapp;

import br.com.gestaodeestoque.Models.FuncionarioModelo;
import br.com.gestaodeestoque.dao.FuncionarioDAO;
import javax.swing.*;

public class MailApp extends JFrame
{
            public static void recuperação(String campo, JTextField login)
        {
            FuncionarioDAO funcionariodao = new FuncionarioDAO();
            FuncionarioModelo funcionariomodelo = funcionariodao.procurarFuncionarioEspecificoPor(campo, login);
                String to = funcionariomodelo.getFuncionario_email();
                String subject = "Recuperação de Senha";
                String message =  "A sua senha é: " + funcionariomodelo.getFuncionario_senha();
                
                String user = "gmgsystem1@gmail.com";
                String pass = "";

                SendMail.send(to,subject, message, user, pass);
                     
        }
}
    