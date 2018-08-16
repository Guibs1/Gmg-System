/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaodeestoque.Views;

import br.com.gestaodeestoque.Models.PagamentoModelo;
import br.com.gestaodeestoque.Models.PedidosModelo;
import br.com.gestaodeestoque.Models.TiposDePagamentoModelo;
import br.com.gestaodeestoque.Models.VendaModelo;
import br.com.gestaodeestoque.Utilities.Utilidades;
import br.com.gestaodeestoque.dao.PagamentoDAO;
import br.com.gestaodeestoque.dao.PedidosDAO;
import br.com.gestaodeestoque.dao.TiposDePagamentoDAO;
import br.com.gestaodeestoque.dao.VendasDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FrmDialogPagamento extends javax.swing.JDialog {

    public FrmDialogPagamento(java.awt.Frame parent, boolean modal, PedidosModelo pedidomodelo, VendaModelo vendamodelo) {
        super(parent, modal);
        initComponents();

        if (vendamodelo == null && pedidomodelo != null) {
            this.pedidomodelo = pedidomodelo;
            valorVenda = pedidomodelo.getTotal();

            txtTotalVendaComDesconto.setText(String.valueOf(pedidomodelo.getTotal()));
            txtVenda.setText(String.valueOf(pedidomodelo.getPedido_id()));
        } else {
            this.vendamodelo = vendamodelo;
            valorVenda = vendamodelo.getVenda_total();

            txtTotalVendaComDesconto.setText(String.valueOf(vendamodelo.getVenda_total()));
            txtVenda.setText(String.valueOf(vendamodelo.getVenda_id()));
        }
    }
    static PedidosModelo pedidomodelo;
    double valorVenda;
    static VendaModelo vendamodelo;

    public Boolean checaVendaPaga() {
        PagamentoDAO dao = new PagamentoDAO();
        PagamentoModelo pagos = dao.checarSeVendaFoiPaga(vendamodelo);
        Boolean tf;
//        double qtd[i];
        if (vendamodelo.getVenda_total() == pagos.getValor_pago() || pagos.getValor_pago() > vendamodelo.getVenda_total()) {
            tf = true;
        } else {
            tf = false;
        }
        return tf;
    }

    public Boolean checaPedidoPago() {
        PagamentoDAO dao = new PagamentoDAO();
        PagamentoModelo pagos = dao.checarSePedidoFoiPagoTotalmente(pedidomodelo);
//        JOptionPane.showMessageDialog(null, "Pedido pago : " + pa);
        Boolean tf;
//        double qtd[i];
        if (pedidomodelo.getTotal() == pagos.getValor_pago() || pagos.getValor_pago() > pedidomodelo.getTotal()) {
            tf = true;
        } else {
            tf = false;
        }
        return tf;
    }

    public void salvarPedidos() {
        try {
            PagamentoModelo pagamentomodelo = new PagamentoModelo();
            pedidomodelo.setStatusPago(1);
            pagamentomodelo.setPedido(pedidomodelo);
            pagamentomodelo.setTipo_pagamento((TiposDePagamentoModelo) cmbTiposDePagamento.getSelectedItem());
            pagamentomodelo.setValor_total(pedidomodelo.getTotal());
            pagamentomodelo.setValor_pago(Double.parseDouble(txtPago.getText().replace(",", ".")));

            PagamentoDAO pagamentodao = new PagamentoDAO();
            pagamentodao.inserirPagamentoPedido(pagamentomodelo);
            JOptionPane.showMessageDialog(null, "Valor Pago inserido com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        try {
//            PagamentoDAO dao = new PagamentoDAO();
//            PagamentoModelo pagos = dao.checarSeVendaFoiPaga(vendamodelo);
////        double qtd[i];
//            if (Double.parseDouble(txtTotalVendaComDesconto.getText()) == pagos.getValor_pago() || pagos.getValor_pago() > Double.parseDouble(txtTotalVendaComDesconto.getText())) {
//                JOptionPane.showMessageDialog(null, "Venda totalmente paga!");
//                this.dispose();
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Erro ao checar se venda foi totalmente paga!" + e);
//        }
    }

    public void salvarVendas() {
        try {
            PagamentoModelo pagamentomodelo = new PagamentoModelo();
            pagamentomodelo.setVenda(vendamodelo);
            pagamentomodelo.setTipo_pagamento((TiposDePagamentoModelo) cmbTiposDePagamento.getSelectedItem());
            pagamentomodelo.setValor_total(vendamodelo.getVenda_total());
            pagamentomodelo.setValor_pago(Double.parseDouble(txtPago.getText().replace(",", ".")));

            PagamentoDAO pagamentodao = new PagamentoDAO();
            pagamentodao.inserirPagamentoVenda(pagamentomodelo);
            JOptionPane.showMessageDialog(null, "Valor Pago inserido com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o Pagamento!" + e);
        }

        try {
            PagamentoDAO dao = new PagamentoDAO();
            PagamentoModelo pagos = dao.checarSeVendaFoiPaga(vendamodelo);
//        double qtd[i];
            if (Double.parseDouble(txtTotalVendaComDesconto.getText()) == pagos.getValor_pago() || pagos.getValor_pago() > Double.parseDouble(txtTotalVendaComDesconto.getText())) {
                JOptionPane.showMessageDialog(null, "Venda totalmente paga!");
                this.dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao checar se venda foi totalmente paga!" + e);
        }
    }

    public void ListarTiposDePagamento() {
        try {
            List<TiposDePagamentoModelo> listatipos = new ArrayList<>();
            TiposDePagamentoDAO dao = new TiposDePagamentoDAO();
            listatipos = dao.listarTiposDePagamento();
            cmbTiposDePagamento.removeAllItems();
            cmbTiposDePagamento.addItem("");
            for (TiposDePagamentoModelo obj : listatipos) {
                cmbTiposDePagamento.addItem(obj);
            }
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtVenda = new javax.swing.JTextField();
        txtTotalVendaComDesconto = new javax.swing.JTextField();
        txtPago = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbTiposDePagamento = new javax.swing.JComboBox();
        btnFinalizar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();
        txtTroco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblImagemFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pagamento");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Valor");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        jLabel2.setText("Código Venda ou Pedido");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        txtVenda.setEnabled(false);
        txtVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVendaActionPerformed(evt);
            }
        });
        getContentPane().add(txtVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 347, -1));

        txtTotalVendaComDesconto.setEnabled(false);
        getContentPane().add(txtTotalVendaComDesconto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 347, -1));

        txtPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPagoKeyReleased(evt);
            }
        });
        getContentPane().add(txtPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 347, -1));

        jLabel4.setText("Valor Pago");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        jLabel5.setText("Tipo de Pagamento");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        getContentPane().add(cmbTiposDePagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 347, -1));

        btnFinalizar.setText("Salvar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, -1, 30));

        btnVoltar.setText("Voltar");
        btnVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVoltarMouseClicked(evt);
            }
        });
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 70, 30));

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton3.setText("Novo Tipo de Pagamento");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 50));

        txtTroco.setEnabled(false);
        getContentPane().add(txtTroco, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 347, -1));

        jLabel6.setText("Troco");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        lblImagemFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesteste/fundo_opaco.png"))); // NOI18N
        getContentPane().add(lblImagemFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 600, 420));

        setSize(new java.awt.Dimension(569, 447));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVendaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        ListarTiposDePagamento();
//        txtPago.setText(String.valueOf(Double.parseDouble(txtTotalVendaComDesconto.getText())));
    }//GEN-LAST:event_formWindowOpened

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String novoTipo = JOptionPane.showInputDialog(null, "digite o nome do novo Tipo de Pagamento :");
        try {
            TiposDePagamentoModelo tipodepagamentomodelo = new TiposDePagamentoModelo();
            tipodepagamentomodelo.setPagamento_nome(novoTipo);
            TiposDePagamentoDAO dao = new TiposDePagamentoDAO();
            dao.cadastraCategoria(tipodepagamentomodelo);

            JOptionPane.showMessageDialog(null, "Tipo de pagamento Cadastrado!");
//            ListarCategoria();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Tipo de pagamento!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        // TODO add your handling code here:
        if (cmbTiposDePagamento.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um Tipo de Pagamento!");
        } else {

            if (null == vendamodelo) {
                salvarPedidos();
                if (checaPedidoPago() == true) {
                    this.pedidomodelo.setStatus(1);
                    PedidosDAO dao = new PedidosDAO();
                    dao.fecharPedido(pedidomodelo);
                    try {
                        pedidomodelo.setTotal(pedidomodelo.getTotal() - Double.parseDouble(txtPago.getText()));
                        txtTotalVendaComDesconto.setText(String.valueOf(pedidomodelo.getTotal()));
                    } catch (Exception e) {
                        pedidomodelo.setTotal(pedidomodelo.getTotal() - Double.parseDouble(txtPago.getText().replace(",", ".")));
                        txtTotalVendaComDesconto.setText(String.valueOf(pedidomodelo.getTotal()));
                    }
                }
            } else {
                salvarVendas();
                if (checaVendaPaga() == true) {
                    this.vendamodelo.setVendaStatus(1);
                    VendasDAO dao = new VendasDAO();
                    dao.fecharVenda(vendamodelo);
                    
                    try {
                        vendamodelo.setVenda_total(vendamodelo.getVenda_total() - Double.parseDouble(txtPago.getText()));
                        txtTotalVendaComDesconto.setText(String.valueOf(vendamodelo.getVenda_total()));
                    } catch (Exception e) {
                        vendamodelo.setVenda_total(vendamodelo.getVenda_total() - Double.parseDouble(txtPago.getText().replace(",", ".")));
                        txtTotalVendaComDesconto.setText(String.valueOf(vendamodelo.getVenda_total()));
                    }
                }

            }
        }
//        vendamodelo.setVenda_desconto(Double.parseDouble(txtDesconto.getText()));
//        vendamodelo.setVenda_total(Double.parseDouble(txtTotalVendaComDesconto.getText()));
//        VendasDAO vendadao = new VendasDAO();
//        vendadao.fecharVenda(vendamodelo);;

        //reescrever o focus da tela venda
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnVoltarMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (txtTotalVendaComDesconto.getText().equals("0")) {
            this.dispose();
        } else {
            if (JOptionPane.showConfirmDialog(null, "A venda não foi totalmente paga, deseja sair mesmo assim ?", "Fechar tela de Pagamento", 0) == JOptionPane.YES_OPTION) {
                this.dispose();
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void txtPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyReleased
        // TODO add your handling code here:
        try {
            if (null == vendamodelo) {
                if (txtPago.getText().equals("")) {
                    txtTotalVendaComDesconto.setText(String.valueOf(pedidomodelo.getTotal()));
                    txtTroco.setText("0");
                } else if (Double.parseDouble(txtPago.getText()) > pedidomodelo.getTotal()) {

                    txtTotalVendaComDesconto.setText("0");
                    txtTroco.setText(String.valueOf(Double.parseDouble(txtPago.getText()) - pedidomodelo.getTotal()));

                } else if (Double.parseDouble(txtPago.getText()) < pedidomodelo.getTotal()) {
                    txtTotalVendaComDesconto.setText(String.valueOf(pedidomodelo.getTotal() - Double.parseDouble(txtPago.getText())));
                    txtTroco.setText("0");

                } else if (Double.parseDouble(txtPago.getText()) == pedidomodelo.getTotal()) {
                    txtTotalVendaComDesconto.setText("0");
                    txtTroco.setText("0");
                }

            } else {
                if (txtPago.getText().equals("")) {
                    txtTotalVendaComDesconto.setText(String.valueOf(vendamodelo.getVenda_total()));
                    txtTroco.setText("0");
                } else if (Double.parseDouble(txtPago.getText()) > vendamodelo.getVenda_total()) {

                    txtTotalVendaComDesconto.setText("0");
                    txtTroco.setText(String.valueOf(Double.parseDouble(txtPago.getText()) - vendamodelo.getVenda_total()));

                } else if (Double.parseDouble(txtPago.getText()) < vendamodelo.getVenda_total()) {
                    txtTotalVendaComDesconto.setText(String.valueOf(vendamodelo.getVenda_total() - Double.parseDouble(txtPago.getText())));
                    txtTroco.setText("0");

                } else if (Double.parseDouble(txtPago.getText()) == vendamodelo.getVenda_total()) {
                    txtTotalVendaComDesconto.setText("0");
                    txtTroco.setText("0");
                }
            }
        } catch (Exception e) {

            if (null == vendamodelo) {
                if (txtPago.getText().replace(",", ".").equals("")) {
                    txtTotalVendaComDesconto.setText(String.valueOf(pedidomodelo.getTotal()));
                    txtTroco.setText("0");
                } else if (Double.parseDouble(txtPago.getText().replace(",", ".")) > pedidomodelo.getTotal()) {

                    txtTotalVendaComDesconto.setText("0");
                    txtTroco.setText(String.valueOf(Double.parseDouble(txtPago.getText().replace(",", ".")) - pedidomodelo.getTotal()));

                } else if (Double.parseDouble(txtPago.getText().replace(",", ".")) < pedidomodelo.getTotal()) {
                    txtTotalVendaComDesconto.setText(String.valueOf(pedidomodelo.getTotal() - Double.parseDouble(txtPago.getText().replace(",", "."))));
                    txtTroco.setText("0");

                } else if (Double.parseDouble(txtPago.getText().replace(",", ".")) == pedidomodelo.getTotal()) {
                    txtTotalVendaComDesconto.setText("0");
                    txtTroco.setText("0");
                }

            } else {
                if (txtPago.getText().replace(",", ".").equals("")) {
                    txtTotalVendaComDesconto.setText(String.valueOf(vendamodelo.getVenda_total()));
                    txtTroco.setText("0");
                } else if (Double.parseDouble(txtPago.getText().replace(",", ".")) > vendamodelo.getVenda_total()) {

                    txtTotalVendaComDesconto.setText("0");
                    txtTroco.setText(String.valueOf(Double.parseDouble(txtPago.getText()) - vendamodelo.getVenda_total()));

                } else if (Double.parseDouble(txtPago.getText().replace(",", ".")) < vendamodelo.getVenda_total()) {
                    txtTotalVendaComDesconto.setText(String.valueOf(vendamodelo.getVenda_total() - Double.parseDouble(txtPago.getText().replace(",", "."))));
                    txtTroco.setText("0");

                } else if (Double.parseDouble(txtPago.getText().replace(",", ".")) == vendamodelo.getVenda_total()) {
                    txtTotalVendaComDesconto.setText("0");
                    txtTroco.setText("0");
                }
            }
        }
    }//GEN-LAST:event_txtPagoKeyReleased

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowGainedFocus

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        if (txtTotalVendaComDesconto.getText().equals("0")) {
            this.dispose();
        } else {
            if (JOptionPane.showConfirmDialog(null, "O valor da venda não foi pago por completo, deseja mesmo fechar?", "Fechar Tela de Pagamento", 0) == JOptionPane.YES_OPTION) {
                this.dispose();
            }
        }

    }//GEN-LAST:event_btnVoltarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmDialogPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDialogPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDialogPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDialogPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmDialogPagamento dialog = new FrmDialogPagamento(new javax.swing.JFrame(), true, pedidomodelo, vendamodelo);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cmbTiposDePagamento;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblImagemFundo;
    private javax.swing.JTextField txtPago;
    private javax.swing.JTextField txtTotalVendaComDesconto;
    private javax.swing.JTextField txtTroco;
    private javax.swing.JTextField txtVenda;
    // End of variables declaration//GEN-END:variables
}
