package br.com.gestaodeestoque.Views;

import br.com.gestaodeestoque.Models.EstoqueModelo;
import br.com.gestaodeestoque.Models.ProdutoModelo;
import br.com.gestaodeestoque.dao.EstoqueDAO;
import br.com.gestaodeestoque.dao.ProdutoDAO;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InternalFrmEstoque extends javax.swing.JInternalFrame {

    public InternalFrmEstoque(Date dataEntrada) {
        initComponents();
        txtDataEntrada.setDate(dataEntrada);
    }

    ProdutoModelo produtomodelo;
    DefaultTableModel tabela;

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);

    }

    public ProdutoModelo clicaNaLista() {

        ProdutoModelo produtomodelo = (ProdutoModelo) listDePesquisa.getSelectedValue();
        txtNomeProd.setText(listDePesquisa.getSelectedValuesList().toString().replace("[", "").replace("]", ""));

        EstoqueDAO estoquedao = new EstoqueDAO();
        EstoqueModelo estoquemodelo = estoquedao.pegarQtdMaxEMin(produtomodelo.getIdProduto(), produtomodelo);

        if (estoquemodelo == null) {

        } else {
            txtQtdMax.setText(String.valueOf(estoquemodelo.getEstoque_qtd_max()));
            txtQtdMin.setText(String.valueOf(estoquemodelo.getEstoque_qtd_min()));
        }

        if ("".equals(txtQtdMax.getText()) && "".equals(txtQtdMin.getText())) {
        } else {
            txtQtdMax.setEnabled(false);
            txtQtdMin.setEnabled(false);
        }
        listDePesquisa.setVisible(false);
        listDePesquisaDescricao.setVisible(false);
        return produtomodelo;
    }

    public void ListarEstoque() {
        try {
            EstoqueDAO novodao = new EstoqueDAO();
            List<EstoqueModelo> listadeestoque = novodao.UltimasAtualizacoes();

            DefaultTableModel modelo = (DefaultTableModel) tabelaCadEstoque.getModel();
            modelo.setNumRows(0);
            DefaultTableModel modelo1 = (DefaultTableModel) tabelaCadEstoque1.getModel();
            modelo1.setNumRows(0);

            for (EstoqueModelo estoqModel : listadeestoque) {

                modelo.addRow(new Object[]{
                    dataParaNetBeans(estoqModel.getData_entrada()),
                    estoqModel.getProduto(),
                    estoqModel.getEst_produto_qtd(),
                    estoqModel.getEstoque_qtd_min(),
                    estoqModel.getEstoque_qtd_max(),
                    dataParaNetBeans(estoqModel.getDatavalidade())
                });
                modelo1.addRow(new Object[]{
                    dataParaNetBeans(estoqModel.getData_entrada()),
                    estoqModel.getProduto(),
                    estoqModel.getEst_produto_qtd(),
                    estoqModel.getEstoque_qtd_min(),
                    estoqModel.getEstoque_qtd_max(),
                    dataParaNetBeans(estoqModel.getDatavalidade())
                });

            }
            tabela = modelo1;
        } catch (Exception e) {
            throw new RuntimeException("Ops, ocorreu um erro ao listar o Estoque" + e);
        }
    }

    public void ListarProdutoList() {
        try {

            ProdutoDAO novodao = new ProdutoDAO();
            String campo = "produto_nome";
            List<ProdutoModelo> listadeprodutos = novodao.buscarProdutoPorNome(campo, txtNomeProd);

            DefaultListModel lista = new DefaultListModel();
            lista.removeAllElements();

            DefaultListModel lista2 = new DefaultListModel();
            lista2.removeAllElements();

            for (ProdutoModelo prodModel : listadeprodutos) {
                lista.addElement(prodModel);
                lista2.addElement(prodModel.getDescricaoProduto());
            }
            listDePesquisa.setModel(lista);
            listDePesquisaDescricao.setModel(lista2);
            txtQtdMax.setEditable(false);
            txtQtdMin.setEditable(false);
        } catch (Exception e) {
            throw new RuntimeException("Ops, ocorreu um erro ao listar os Produtos no ComboBox" + e);
        }
    }

//    private void dataParaMysql(String data) {
//        
//        String dia = data.substring(0, 2);
//        String mes = data.substring(3, 5);
//        String ano = data.substring(6);
//
//        return ano+"-"+mes+"-"+dia;
//    }
    private String dataParaMysql(String data) {

        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);

        return ano + "-" + mes + "-" + dia;
    }

    private String dataParaNetBeans(String data) {

        String ano = data.substring(0, 4);
        String mes = data.substring(5, 7);
        String dia = data.substring(8);

        return dia + "-" + mes + "-" + ano;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnNovo = new javax.swing.JButton();
        btnInserir = new javax.swing.JButton();
        btnAlterar1 = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtQtd = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtQtdMax = new javax.swing.JFormattedTextField();
        txtQtdMin = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        txtdatacalendar = new com.toedter.calendar.JDateChooser();
        txtDataEntrada = new com.toedter.calendar.JDateChooser();
        listDePesquisa = new javax.swing.JList();
        txtNomeProd = new javax.swing.JTextField();
        listDePesquisaDescricao = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCadEstoque = new javax.swing.JTable();
        chkExibirT = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaCadEstoque1 = new javax.swing.JTable();
        chkExibirT1 = new javax.swing.JCheckBox();

        setClosable(true);
        setTitle("Estoque");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jToolBar1.setFloatable(false);

        btnNovo.setText("Novo");
        btnNovo.setFocusable(false);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNovo);

        btnInserir.setText("Salvar");
        btnInserir.setFocusable(false);
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnInserir);

        btnAlterar1.setText("Alterar");
        btnAlterar1.setFocusable(false);
        btnAlterar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterar1ActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAlterar1);

        btnExcluir.setText("Excluir");
        btnExcluir.setFocusable(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnExcluir);

        jButton3.setText("Procurar");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 50));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Atualização de Estoque", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("Nome do Produto");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        txtQtd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.###"))));
        txtQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdActionPerformed(evt);
            }
        });
        jPanel1.add(txtQtd, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 80, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setText("Qtd (Unid.)");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Qtd Max");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("*");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 20, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setText("*");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 10, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel10.setText("Data de Entrada");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel15.setText("Qtd Min");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        txtQtdMax.setEditable(false);
        txtQtdMax.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.###"))));
        txtQtdMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdMaxActionPerformed(evt);
            }
        });
        jPanel1.add(txtQtdMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 110, -1));

        txtQtdMin.setEditable(false);
        txtQtdMin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.###"))));
        txtQtdMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdMinActionPerformed(evt);
            }
        });
        jPanel1.add(txtQtdMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 80, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel13.setText("Validade");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, -1));
        jPanel1.add(txtdatacalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 140, -1));
        jPanel1.add(txtDataEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 190, -1));

        listDePesquisa.setBorder(new javax.swing.border.MatteBorder(null));
        listDePesquisa.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        listDePesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listDePesquisaMouseClicked(evt);
            }
        });
        jPanel1.add(listDePesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 190, -1));

        txtNomeProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeProdKeyReleased(evt);
            }
        });
        jPanel1.add(txtNomeProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 170, -1));

        listDePesquisaDescricao.setBorder(new javax.swing.border.MatteBorder(null));
        listDePesquisaDescricao.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        listDePesquisaDescricao.setEnabled(false);
        listDePesquisaDescricao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listDePesquisaDescricaoMouseClicked(evt);
            }
        });
        jPanel1.add(listDePesquisaDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        jTabbedPane1.addTab("Nova Atualização", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaCadEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data Atualização", "Nome Produto", "Quantidade", "Qtd Min.", "Qtd Máx", "Validade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCadEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCadEstoqueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCadEstoque);
        if (tabelaCadEstoque.getColumnModel().getColumnCount() > 0) {
            tabelaCadEstoque.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 750, 160));

        chkExibirT.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        chkExibirT.setSelected(true);
        chkExibirT.setText("Exibir Apenas Produtos em Estoque");
        chkExibirT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkExibirTItemStateChanged(evt);
            }
        });
        jPanel2.add(chkExibirT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 268, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel14.setText("Pesquisar por nome");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        tabelaCadEstoque1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data Atualização", "Nome Produto", "Quantidade", "Qtd Min.", "Qtd Máx.", "Validade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaCadEstoque1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCadEstoque1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaCadEstoque1);
        if (tabelaCadEstoque1.getColumnModel().getColumnCount() > 0) {
            tabelaCadEstoque1.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 750, 160));

        chkExibirT1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        chkExibirT1.setSelected(true);
        chkExibirT1.setText("Exibir Todos");
        chkExibirT1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkExibirT1ItemStateChanged(evt);
            }
        });
        jPanel2.add(chkExibirT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jTabbedPane1.addTab("Últimas atualizações", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 780, 250));
        jTabbedPane1.getAccessibleContext().setAccessibleName("Formulario");
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LimparDados() {
        txtNomeProd.setText("");
        txtDataEntrada.setDate(null);
        txtQtdMax.setText(null);
        txtQtdMin.setText(null);
        txtQtd.setText(null);
        txtdatacalendar.setDate(null);
    }

    private void tabelaCadEstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCadEstoqueMouseClicked
        // TODO add your handling code here:
        /*txtAttEstId.setText(tabelaCadEstoque.getValueAt(tabelaCadEstoque.getSelectedRow(), 0).toString());
        txtCadEstNome.setText(tabelaCadEstoque.getValueAt(tabelaCadEstoque.getSelectedRow(), 1).toString());
        txtCadEstQtd.setText(tabelaCadEstoque.getValueAt(tabelaCadEstoque.getSelectedRow(), 2).toString());
        txtCadEstQtdMax.setText(tabelaCadEstoque.getValueAt(tabelaCadEstoque.getSelectedRow(), 3).toString());
        txtCadEstQtdMin.setText(tabelaCadEstoque.getValueAt(tabelaCadEstoque.getSelectedRow(), 4).toString());*/
    }//GEN-LAST:event_tabelaCadEstoqueMouseClicked

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // limpar
        LimparDados();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        //cadastrar só O ESTOQUE E PEGAR O PROD OCM O NOME MAS NOS COD PELO ID
        //if (cmbNomeProd.getSelectedItem().equals("")|| txtValProd.getText().equals(""))
        //{
//            JOptionPane.showMessageDialog(null, "Dados importantes vazios.");
        //}/*else { como trocar virgula por ponto
        try {
            EstoqueModelo estoquemodelo = new EstoqueModelo();
//            ProdutoModelo produto = new ProdutoModelo();
//            prod
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
            String dataformatada = formatador.format(txtDataEntrada.getDate());
            estoquemodelo.setData_entrada(dataformatada);

//                produto = (ProdutoModelo) txtNomeProd.getSelectedItem();
            estoquemodelo.setProduto(this.produtomodelo);

            //Formatando a data
            SimpleDateFormat formatador2 = new SimpleDateFormat("yyyy-MM-dd");
            String dataformatada2 = formatador2.format(txtdatacalendar.getDate());
            estoquemodelo.setDatavalidade(dataformatada2);

            estoquemodelo.setEstoque_qtd_max(Integer.parseInt(txtQtdMax.getText()));
            estoquemodelo.setEstoque_qtd_min(Integer.parseInt(txtQtdMin.getText()));
            estoquemodelo.setEst_produto_qtd(Integer.parseInt(txtQtd.getText()));

            EstoqueDAO dao = new EstoqueDAO();
            dao.AtualizacaoDeEstoque(estoquemodelo);
            JOptionPane.showMessageDialog(null, "Informações de estoque salvas!");
            /*if (dataParaMysql(txtDataEntrada.getText()).equals("20  -  -  ")) {
                    JOptionPane.showMessageDialog(null, "Data invalida.");
                } else {
                    produtomodelo.setValidadeProduto(dataParaMysql(txtCadVal.getText()));

                    ProdutoDAO dao = new ProdutoDAO();
                    dao.cadastraProduto(produtomodelo);

                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
             */
            ListarEstoque();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ops, ocorreu um erro " + e);
        }
        //}
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnAlterar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterar1ActionPerformed

        DefaultTableModel modelo1 = (DefaultTableModel) tabelaCadEstoque.getModel();
        try {
            int linhas = modelo1.getRowCount();
            for (int l = 0; l < linhas; l++) {
                int colunas = modelo1.getColumnCount();
                for (int c = 0; c < colunas; c++) {

                    if (this.tabela.getValueAt(l, c).equals(modelo1.getValueAt(l, c))) {
                    } else {

                        EstoqueModelo estoquemodelo = new EstoqueModelo();
                        EstoqueDAO estoquedao = new EstoqueDAO();

                        estoquemodelo.setDatavalidade(dataParaMysql(modelo1.getValueAt(l, 5).toString()));
                        estoquemodelo.setProduto((ProdutoModelo) modelo1.getValueAt(l, 1));

                        switch (c) {
                            case 0:
                                estoquemodelo.setData_entrada(dataParaMysql(modelo1.getValueAt(l, c).toString()));
                                estoquedao.alterDataEntradaEstoque(estoquemodelo);
                                JOptionPane.showMessageDialog(null, "Data de alterada com sucesso!");
                                break;
                            case 2:
                                estoquemodelo.setEst_produto_qtd(Integer.parseInt(modelo1.getValueAt(l, c).toString()));
                                estoquedao.alterQuantidadeEstoque(estoquemodelo);
                                JOptionPane.showMessageDialog(null, "Quantidade alterada com sucesso!");
                                break;
                            case 3:
                                estoquemodelo.setEstoque_qtd_min(Integer.parseInt(modelo1.getValueAt(l, c).toString()));
                                estoquedao.alterQuantidadeMinEstoque(estoquemodelo);
                                JOptionPane.showMessageDialog(null, "Quantidade mínima alterada com sucesso!");
                                break;
                            case 4:
                                estoquemodelo.setEstoque_qtd_max(Integer.parseInt(modelo1.getValueAt(l, c).toString()));
                                estoquedao.alterQuantidadeMaxEstoque(estoquemodelo);
                                JOptionPane.showMessageDialog(null, "Quantidade máxima alterada com sucesso!");
                                break;
                        }

                    }

                }

            }
            ListarEstoque();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        /* alterar
        if (txtCadProdId.getText().equals("") || txtCadProdId.getText().equals(null)) {

            JOptionPane.showMessageDialog(null, "Campo ID produto vazio, tente selecionar a tabela novamente.");
        } else {
            if (JOptionPane.showConfirmDialog(null, "Deseja realmente alterar campo?","Alteração de Campos",2)== JOptionPane.OK_OPTION) {
                try {
                    ProdutoModelo produtomodelo = new ProdutoModelo();
                    produtomodelo.setNomeProduto(txtCadNome.getText());
                    produtomodelo.setDescProduto(txtCadDesc.getText());

                    produtomodelo.setValidadeProduto(dataParaMysql(txtCadVal.getText()));

                    produtomodelo.setIdProduto(Integer.parseInt(txtCadProdId.getText()));

                    //metodo
                    ProdutoDAO dao = new ProdutoDAO();
                    dao.alterarProduto(produtomodelo);

                    JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
                    ListarProdutos();
                    LimparDados();
                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "Ops, ocorreu um erro ao alterar os dados do produto: " + e);
                }
            }
        }*/
    }//GEN-LAST:event_btnAlterar1ActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            EstoqueModelo estoquemodelo = new EstoqueModelo();
            if (tabelaCadEstoque.getSelectedRow() == -1) {

                JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada selecionado, por favor tente selecionar a tabela novamente.");
            } else {
                //verificaçao
//             if (JOptionPane.showConfirmDialog(null, "A venda não foi totalmente paga, deseja sair mesmo assim ?", "Fechar tela de Pagamento", 0) == JOptionPane.YES_OPTION) {
//                this.dispose();
//            }

                estoquemodelo.setDatavalidade(dataParaMysql(tabelaCadEstoque.getValueAt(tabelaCadEstoque.getSelectedRow(), 5).toString()));
                estoquemodelo.setProduto((ProdutoModelo) tabelaCadEstoque.getValueAt(tabelaCadEstoque.getSelectedRow(), 1));
                EstoqueDAO dao = new EstoqueDAO();
                dao.excluirAtualizacao(estoquemodelo);

                JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
                ListarEstoque();
                //LimparDados();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ops, ocorreu um erro ao excluir os dados: " + e);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        ListarEstoque();
//        ListarProdutoCmb();
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdActionPerformed

    private void txtQtdMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdMaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdMaxActionPerformed

    private void txtQtdMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdMinActionPerformed

    private void chkExibirTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkExibirTItemStateChanged
        // TODO add your handling code here:
        if (chkExibirT.isSelected() == false) {
            DefaultTableModel modelo = (DefaultTableModel) tabelaCadEstoque.getModel();
            modelo.setNumRows(0);
        } else {
            ListarEstoque();
        }
    }//GEN-LAST:event_chkExibirTItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

//        String nomedaProcura = txtNomeProcura.getText();
//        try {
//            ProdutoModelo modelo = new ProdutoModelo();
//            modelo.setNomeProduto(nomedaProcura);
//            ProdutoDAO dao = new ProdutoDAO();
//            String produtoprocurado = dao.ProcurarProduto(modelo).toString();
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Erro ao Procurar Produto: " + e);
//        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void listDePesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listDePesquisaMouseClicked
        // TODO add your handling code here:
//        //COMPLETAR OS CAMPOS PRINCIPAIS
        this.produtomodelo = clicaNaLista();
        // PREPARAR O OBJ PARA COMPLETAR A TABELA
        //        int selecionado = listDePesquisa.getSelectedIndex();
    }//GEN-LAST:event_listDePesquisaMouseClicked

    private void txtNomeProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeProdKeyReleased
        // TODO add your handling code here:
        if (txtNomeProd.getText().equals("")) {
            listDePesquisa.setVisible(false);
            listDePesquisaDescricao.setVisible(false);
            txtQtdMax.setEditable(true);
            txtQtdMin.setEditable(true);
        } else {
            ListarProdutoList();
            listDePesquisa.setVisible(true);
            listDePesquisaDescricao.setVisible(true);
//            txtQtdMax.setEditable(false);
//            txtQtdMin.setEditable(false);
        }
    }//GEN-LAST:event_txtNomeProdKeyReleased

    private void listDePesquisaDescricaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listDePesquisaDescricaoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_listDePesquisaDescricaoMouseClicked

    private void tabelaCadEstoque1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCadEstoque1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaCadEstoque1MouseClicked

    private void chkExibirT1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkExibirT1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_chkExibirT1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar1;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JCheckBox chkExibirT;
    private javax.swing.JCheckBox chkExibirT1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JList listDePesquisa;
    private javax.swing.JList listDePesquisaDescricao;
    private javax.swing.JTable tabelaCadEstoque;
    private javax.swing.JTable tabelaCadEstoque1;
    private com.toedter.calendar.JDateChooser txtDataEntrada;
    private javax.swing.JTextField txtNomeProd;
    private javax.swing.JFormattedTextField txtQtd;
    private javax.swing.JFormattedTextField txtQtdMax;
    private javax.swing.JFormattedTextField txtQtdMin;
    private com.toedter.calendar.JDateChooser txtdatacalendar;
    // End of variables declaration//GEN-END:variables
}
