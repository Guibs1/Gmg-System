/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaodeestoque.Utilities;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Guibs
 */
public class Utilidades {
    
    public static void sairSimNao(){
        
        if( JOptionPane.showConfirmDialog(null, "Deseja realmente sair","Fechar Gestor de Estoque",0)== JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    public static void abrirCalculadora(){
        try {  
            Runtime.getRuntime().exec("calc");  
        } catch (IOException exc) {  
            exc.printStackTrace(); 
            JOptionPane.showMessageDialog(null, "Ops, ocorreu um erro ao abrir a Calculadora!");
        }  
    }
    
    public static void setIcon(JFrame tela){
        URL url = tela.getClass().getResource("/imagesteste/logo controle de estoque.png");  
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        tela.setIconImage(iconeTitulo);
    }
    
    public static void loginAutomatico(boolean debug){
        
    }
    
    public static void setInvisible(JComponent itens){
        itens.setVisible(false);
        
    }
    /*public static void limparCampos(){
    foreach()
    {
    if(JTextField != null){
    
    }
    }
//    }*/
//    public void soma7aData(Date dataAtual)
////    {
////        
////        for (int i = 0 ; i<7; i++)
////        {   
////            dataAtual.setDate(i);
////            if()
////        }
//    }
//    
//    public static boolean consistenciaDeDadosCadCliente()
//    {
//    
//    return false;
//    }
    
}
