package br.com.gestaodeestoque.Views;

import br.com.gestaodeestoque.Models.FuncionarioModelo;
import br.com.gestaodeestoque.Utilities.Utilidades;
import br.com.gestaodeestoque.dao.FuncionarioDAO;
import br.com.gestaodeestoque.dao.ProdutoDAO;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class FrmTelaInicial extends javax.swing.JFrame {

    public static FuncionarioModelo funcionariomodeloo;
    
    public FrmTelaInicial(FuncionarioModelo funcionariomodeloo) {
        initComponents();
        this.funcionariomodeloo = funcionariomodeloo;
        this.setUndecorated(true); 
        
        URL url = this.getClass().getResource("/imagesteste/logo controle de estoque.png");  
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImage = new javax.swing.JLabel();
        //ImageIcon icon = new ImageIcon(getClass().getResource("/imagesteste/planodefundo.png"));
        //Image image = icon.getImage();
        Desktop6 = new javax.swing.JDesktopPane(){

            //    public void paintComponent(Graphics g){
                //        g.drawImage(image, 0, 0, getWidth(),getHeight(), this);
                //    }
        }
        ;
        jPanel6 = new javax.swing.JPanel();
        lblStatusUsuario5 = new javax.swing.JLabel();
        lblStatusHora5 = new javax.swing.JLabel();
        lblStatusData5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastros = new javax.swing.JMenu();
        menuCadProd = new javax.swing.JMenuItem();
        menuCadUsu = new javax.swing.JMenuItem();
        menuEstoque = new javax.swing.JMenu();
        menuChamaEstoque = new javax.swing.JMenuItem();
        menuConsultas = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuSeparador2 = new javax.swing.JMenu();
        menuVender = new javax.swing.JMenu();
        menuCalendario = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuCalc = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        menuAvisos = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        menuAjuda = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesteste/hamburguer.png"))); // NOI18N
        lblImage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Tela Inicial");
        setExtendedState(4);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 102, 51));
        jPanel6.setForeground(new java.awt.Color(255, 153, 153));
        jPanel6.setFocusable(false);

        lblStatusUsuario5.setText("Usuário");

        lblStatusHora5.setText("Hora");

        lblStatusData5.setText("Data");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("|");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("|");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStatusData5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatusHora5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addGap(3, 3, 3)
                .addComponent(lblStatusUsuario5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1248, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblStatusUsuario5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblStatusHora5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblStatusData5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        Desktop6.setLayer(jPanel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout Desktop6Layout = new javax.swing.GroupLayout(Desktop6);
        Desktop6.setLayout(Desktop6Layout);
        Desktop6Layout.setHorizontalGroup(
            Desktop6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Desktop6Layout.setVerticalGroup(
            Desktop6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Desktop6Layout.createSequentialGroup()
                .addContainerGap(806, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        menuCadastros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Plus_39px_1.png"))); // NOI18N
        menuCadastros.setText("Cadastros");
        menuCadastros.setFont(new java.awt.Font("Segoe UI Emoji", 0, 19)); // NOI18N
        menuCadastros.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        menuCadProd.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        menuCadProd.setText("Produto");
        menuCadProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadProdActionPerformed(evt);
            }
        });
        menuCadastros.add(menuCadProd);

        menuCadUsu.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        menuCadUsu.setText("Funcionário");
        menuCadUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadUsuActionPerformed(evt);
            }
        });
        menuCadastros.add(menuCadUsu);

        jMenuBar1.add(menuCadastros);

        menuEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Move by Trolley_39px.png"))); // NOI18N
        menuEstoque.setText("Estoque");
        menuEstoque.setFont(new java.awt.Font("Segoe UI Emoji", 0, 19)); // NOI18N
        menuEstoque.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        menuChamaEstoque.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        menuChamaEstoque.setText("Atualização");
        menuChamaEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuChamaEstoqueActionPerformed(evt);
            }
        });
        menuEstoque.add(menuChamaEstoque);

        jMenuBar1.add(menuEstoque);

        menuConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Combo Chart_39px.png"))); // NOI18N
        menuConsultas.setText("Relatórios");
        menuConsultas.setFont(new java.awt.Font("Segoe UI Emoji", 0, 19)); // NOI18N
        menuConsultas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItem2.setText("Clientes");
        menuConsultas.add(jMenuItem2);

        jMenuItem9.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItem9.setText("Funcionários");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        menuConsultas.add(jMenuItem9);

        jMenuItem6.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItem6.setText("Produtos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menuConsultas.add(jMenuItem6);

        jMenuItem10.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItem10.setText("Vendas");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        menuConsultas.add(jMenuItem10);

        jMenuItem5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItem5.setText("Saldo do Estoque");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuConsultas.add(jMenuItem5);
        menuConsultas.add(jSeparator1);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItem3.setText("Comissão");
        menuConsultas.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItem4.setText("Finanças");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuConsultas.add(jMenuItem4);

        jMenuBar1.add(menuConsultas);

        menuSeparador2.setText("|");
        menuSeparador2.setEnabled(false);
        menuSeparador2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        menuSeparador2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenuBar1.add(menuSeparador2);

        menuVender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Paid_39px.png"))); // NOI18N
        menuVender.setText("Vendas");
        menuVender.setFont(new java.awt.Font("Segoe UI Emoji", 0, 19)); // NOI18N
        menuVender.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        menuVender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuVenderMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuVender);

        menuCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Event Accepted Tentatively_39px.png"))); // NOI18N
        menuCalendario.setText("Eventos");
        menuCalendario.setFont(new java.awt.Font("Segoe UI Emoji", 0, 19)); // NOI18N
        menuCalendario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        menuCalendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCalendarioMouseClicked(evt);
            }
        });
        menuCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCalendarioActionPerformed(evt);
            }
        });

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItem1.setText("Novo Evento");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuCalendario.add(jMenuItem1);

        jMenuBar1.add(menuCalendario);

        menuCalc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Administrative Tools_39px.png"))); // NOI18N
        menuCalc.setText("Ferramentas");
        menuCalc.setFont(new java.awt.Font("Segoe UI Emoji", 0, 19)); // NOI18N
        menuCalc.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        menuCalc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCalcMouseClicked(evt);
            }
        });

        jMenuItem11.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItem11.setText("Calculadora");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        menuCalc.add(jMenuItem11);

        jMenuItem12.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItem12.setText("Calendário");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        menuCalc.add(jMenuItem12);

        jMenuBar1.add(menuCalc);

        menuAvisos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesteste/Error_39px.png"))); // NOI18N
        menuAvisos.setText("Avisos");
        menuAvisos.setFont(new java.awt.Font("Segoe UI Emoji", 0, 19)); // NOI18N
        menuAvisos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAvisosMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuAvisos);

        jMenu2.setText("|");
        jMenu2.setEnabled(false);
        jMenu2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jMenuBar1.add(jMenu2);

        menuAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Info_39px.png"))); // NOI18N
        menuAjuda.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        menuAjuda.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenuBar1.add(menuAjuda);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Exit_39px.png"))); // NOI18N
        jMenu4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jMenu4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jMenuItem8.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesteste/icone perfil.png"))); // NOI18N
        jMenuItem8.setText("Trocar de Usuário");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem7.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesteste/Shutdown_18px_2.png"))); // NOI18N
        jMenuItem7.setText("Sair");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop6)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop6)
        );

        setSize(new java.awt.Dimension(1608, 920));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    class hora implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar now = Calendar.getInstance();
            lblStatusHora5.setText(String.format("%1$tH: %1$tM: %1$tS", now));
        }
    }
    
    public JList checaAvisos()
    {
        JList lista = new JList();
        try {
//
//        ProdutoDAO;

        } catch (Exception e) {
        }
        return lista;
    }
//     
//     public void ChamaEstoque(){
//       Date dataSistema = new Date();
//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//        InternalFrmEstoque cadEstoque = new InternalFrmEstoque(formato.format(dataSistema));
//        cadEstoque.setVisible(true);
//        Desktop6.add(cadEstoque);
//     }
    
    private void menuCadProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadProdActionPerformed
        InternalFrmProduto cadProduto = new InternalFrmProduto();
        cadProduto.setVisible(true);
        this.Desktop6.add(cadProduto);
        cadProduto.setPosicao();
//        lblinicial.setVisible(false);
    }//GEN-LAST:event_menuCadProdActionPerformed
    
    private void menuCadUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadUsuActionPerformed
        /*frmCadastrodeUsuario frmCadUSu= new frmCadastrodeUsuario();
        frmCadUSu.setVisible(true);
        this.setVisible(false);*/
                InternalFrmFuncionario cadUsuario = new InternalFrmFuncionario();
                cadUsuario.setVisible(true);
                this.Desktop6.add(cadUsuario);
                cadUsuario.setPosicao();
         //       lblIcon.setVisible(false);
       // lblinicial.setVisible(false);
    }//GEN-LAST:event_menuCadUsuActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void menuVenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuVenderMouseClicked
        // TODO add your handling code here:
        try {
            FuncionarioDAO funcionarioAtual = new FuncionarioDAO();
            String login = funcionariomodeloo.getFuncionario_login();
            FuncionarioModelo funcionario = funcionarioAtual.funcionarioAtual(login);
            
            FrmVendasEPedidos vendasepedidos = new FrmVendasEPedidos(funcionario);
            vendasepedidos.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_menuVenderMouseClicked

    private void menuCalendarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCalendarioMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_menuCalendarioMouseClicked

    private void menuCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCalendarioActionPerformed
        // TODO add your handling code here:
//        InternalFrmEventos novoseventos = new InternalFrmEventos();
//        novoseventos.setVisible(true);
//        this.Desktop6.add(novoseventos);
        //lblinicial.setVisible(false);
    }//GEN-LAST:event_menuCalendarioActionPerformed

    private void menuCalcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCalcMouseClicked
        //Utilidades.abrirCalculadora();

    }//GEN-LAST:event_menuCalcMouseClicked

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        FrmTelaInicial.this.setVisible(false);
        FrmLogin telalogin = new FrmLogin();
        telalogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        Utilidades.sairSimNao();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Utilidades.sairSimNao();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
//        lblinicial.setText("Seja bem vindo, "+funcionariomodeloo.getFuncionario_login());
        lblStatusUsuario5.setText(funcionariomodeloo.getFuncionario_login());
        Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        lblStatusData5.setText(formato.format(dataSistema));
        
        Timer timer = new Timer(1000, new hora());
        timer.start();
        
//        checaAvisos();
    }//GEN-LAST:event_formWindowOpened

    private void menuChamaEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuChamaEstoqueActionPerformed
        // TODO add your handling code here:
        Date dataSistema = new Date();

        
        String data = dataSistema.toString();
        lblStatusData5.setText(data);
        
//        String novadata = formato.format(dataSistema);
//        Date novaadata = new Date(novadata);
        InternalFrmEstoque cadEstoque = new InternalFrmEstoque(dataSistema);
        cadEstoque.setVisible(true);
        this.Desktop6.add(cadEstoque);
        cadEstoque.setPosicao();
    }//GEN-LAST:event_menuChamaEstoqueActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void menuAvisosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAvisosMouseClicked
        // TODO add your handling code here:
        InternalFrmAvisos avisos = new InternalFrmAvisos();
        avisos.show();
        Desktop6.add(avisos);
        avisos.setPosicao();
        lblImage.setFocusable(false);
    }//GEN-LAST:event_menuAvisosMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        InternalFrmEventos eventos = new InternalFrmEventos();
        eventos.setVisible(true);
        Desktop6.add(eventos);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
                InternalFrmCalculadora calculadora = new InternalFrmCalculadora();
        Desktop6.add(calculadora);
        calculadora.setVisible(true);
        calculadora.setPosicao();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
//        FuncionarioDAO dao = new FuncionarioDAO();
//        dao.criarRelatorio();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
//        ProdutoDAO dao = new ProdutoDAO();
//        dao.criarRelatorio();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        InternalFrmCalendario calendario = new InternalFrmCalendario();
        Desktop6.add(calendario);
        calendario.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmTelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTelaInicial(funcionariomodeloo).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop6;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblStatusData5;
    private javax.swing.JLabel lblStatusHora5;
    private javax.swing.JLabel lblStatusUsuario5;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuAvisos;
    private javax.swing.JMenuItem menuCadProd;
    private javax.swing.JMenuItem menuCadUsu;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenu menuCalc;
    private javax.swing.JMenu menuCalendario;
    private javax.swing.JMenuItem menuChamaEstoque;
    private javax.swing.JMenu menuConsultas;
    private javax.swing.JMenu menuEstoque;
    private javax.swing.JMenu menuSeparador2;
    private javax.swing.JMenu menuVender;
    // End of variables declaration//GEN-END:variables
}
