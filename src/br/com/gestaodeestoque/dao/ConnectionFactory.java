/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaodeestoque.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionFactory {
    
        public Connection getConnection() {

        try {
            
            return DriverManager.getConnection("jdbc:mysql://localhost/BD_TESTE","root", "");
        } catch (SQLException erro) {

            throw new RuntimeException(erro);
                   
        }

    }
}
