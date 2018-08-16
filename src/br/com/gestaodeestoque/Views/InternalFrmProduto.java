package br.com.gestaodeestoque.Views;

import br.com.gestaodeestoque.Models.CategoriaModelo;
import br.com.gestaodeestoque.Models.ProdutoModelo;
import br.com.gestaodeestoque.Models.SubCategoriaModelo;
import br.com.gestaodeestoque.Utilities.Utilidades;
import br.com.gestaodeestoque.dao.CategoriaDAO;
import br.com.gestaodeestoque.dao.ProdutoDAO;
import br.com.gestaodeestoque.dao.SubCategoriaDAO;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InternalFrmProduto extends javax.swing.JInternalFrame {

    public InternalFrmProduto() {
        initComponents();

    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);

    }
    CategoriaModelo cat = new CategoriaModelo();
//    List<ProdutoModelo> listadeestoque;
    DefaultTableModel tabela;
//Pega o objeto do combobox categoria
    //            cat = (CategoriaModelo) cmbCategoria.getSelectedItem();
    //
    //            prod.setNomeProduto(txtNomeProd.getText());
    //
    //            prod.setCategoria(cat);

    public DefaultTableModel ListarProdutos() {
        try {
            ProdutoDAO novodao = new ProdutoDAO();
            List<ProdutoModelo> listadeestoque = novodao.listarProdutos();
//            this.listadeestoque = listadeestoque;
            DefaultTableModel modelo = (DefaultTableModel) tabelaCadProd.getModel();
            modelo.setNumRows(0);
            DefaultTableModel modelo1 = (DefaultTableModel) tabelaCadProd1.getModel();
            modelo1.setNumRows(0);
            int i = 0;
            for (ProdutoModelo prodModel : listadeestoque) {
//                CategoriaModelo categoria = new CategoriaModelo();
//                SubCategoriaModelo subcategoria = new SubCategoriaModelo();
                modelo.addRow(new Object[]{
                    prodModel.getIdProduto(),
                    prodModel.getSubCategoria().getCategoria(),
                    prodModel.getSubCategoria(),
                    prodModel.getNomeProduto(), // STATUS EX: EM ESTOQUE
                    prodModel.getDescricaoProduto(),
                    prodModel.getPrecoCusto(),
                    prodModel.getPrecoVenda(),
                    prodModel.getComissao()
                });

                modelo1.addRow(new Object[]{
                    prodModel.getIdProduto(),
                    prodModel.getSubCategoria().getCategoria(),
                    prodModel.getSubCategoria(),
                    prodModel.getNomeProduto(), // STATUS EX: EM ESTOQUE
                    prodModel.getDescricaoProduto(),
                    prodModel.getPrecoCusto(),
                    prodModel.getPrecoVenda(),
                    prodModel.getComissao()
                });
//                modelo1.removeRow(i);
//                i++;
            }
            return modelo1;
        } catch (Exception e) {
            throw new RuntimeException("Ops, ocorreu um erro ao listar os Produtos" + e);
        }
    }

    public void ProcuradeProdutos() {
//        try {
//            ProdutoDAO novodao = new ProdutoDAO();
//            List<ProdutoModelo> listadeestoque = novodao.listarProdutos();
//
//            DefaultTableModel modelo = (DefaultTableModel) tabelaCadProd.getModel();
//            modelo.setNumRows(0);
//
//            modelo.addRow(new Object[]{
//                prodModel.getIdProduto(),
//                prodModel.getNomeProduto(),
//                prodModel.getCategoria(),
//                prodModel.getUnidadeMedida(),
//                prodModel.getQtdLote(),
//                prodModel.getQtdMax(),
//                prodModel.getQtdMin(),
//                prodModel.getPrecoCusto(),
//                prodModel.getPrecoVenda(),
//                prodModel.getComissao(), // STATUS EX: EM ESTOQUE
//            });
//
//
//        } catch (Exception e) {
//            throw new RuntimeException("Ops, ocorreu um erro ao listar os Produtos" + e);
//        }
    }

//    @Override
//    public String toString(){
//        CategoriaModelo categoriamodelo = new CategoriaModelo();
//        return categoriamodelo.getCategoria_desc();
//    }
//    public void ListarCategoriaNoCMB() {
//        try {
//            List<CategoriaModelo> listacategoria = new ArrayList<>();
//            CategoriaDAO dao = new CategoriaDAO();
//            listacategoria = dao.listarCategorias();
//            cmbCategoria.removeAllItems();
//            cmbCategoria.addItem("");
//            for (CategoriaModelo obj : listacategoria) {
//                cmbCategoria.addItem(obj);
//            }
//        } catch (Exception e) {
//        }
//    }
    public void ListarSubCategoriaNoCMB() {
        try {
            List<SubCategoriaModelo> listacategoria = new ArrayList<>();
            SubCategoriaDAO dao = new SubCategoriaDAO();
            listacategoria = dao.listarSubCategorias();
            cmbSubCategoria.removeAllItems();
            cmbSubCategoria.addItem("");
            for (SubCategoriaModelo obj : listacategoria) {
                cmbSubCategoria.addItem(obj);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar subcategoria." + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnNovo = new javax.swing.JButton();
        btnInserir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        btnGerenciarCategoria = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNomeProd = new javax.swing.JTextField();
        txtDescricaoProd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPrecoVenda = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtComissao = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cmbSubCategoria = new javax.swing.JComboBox();
        txtPrecoCusto = new javax.swing.JFormattedTextField();
        txtCodBarra = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        imagemfundo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCadProd = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaCadProd1 = new javax.swing.JTable();
        chkExibirT = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        txtNomeProcura = new javax.swing.JTextField();
        cmbPropriedades = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("Cadastro de Produto");
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
                formInternalFrameIconified(evt);
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setFloatable(false);

        btnNovo.setText("Novo");
        btnNovo.setFocusable(false);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNovo);

        btnInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/salvarproduto.png"))); // NOI18N
        btnInserir.setText("Salvar");
        btnInserir.setFocusable(false);
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnInserir);

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/alterarproduto.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setFocusable(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAlterar);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excluirproduto.png"))); // NOI18N
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

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel16.setText("|");
        jLabel16.setEnabled(false);
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel16.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jToolBar1.add(jLabel16);

        btnGerenciarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Ingredients_39px.png"))); // NOI18N
        btnGerenciarCategoria.setText("Gerenciar Categorias");
        btnGerenciarCategoria.setFocusable(false);
        btnGerenciarCategoria.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGerenciarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciarCategoriaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGerenciarCategoria);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 50));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações do Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setText("Nome do Produto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setText("Preço Custo");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setText("*");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));
        jPanel1.add(txtNomeProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 650, -1));
        jPanel1.add(txtDescricaoProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 650, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Descrição");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        txtPrecoVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtPrecoVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPrecoVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecoVendaFocusLost(evt);
            }
        });
        jPanel1.add(txtPrecoVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 150, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel11.setText("Preço Venda");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 51));
        jLabel20.setText("*");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 10, -1));

        txtComissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtComissao.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtComissao.setEnabled(false);
        jPanel1.add(txtComissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 150, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel17.setText("Comissão");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("SubCategoria");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 51));
        jLabel18.setText("*");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        cmbSubCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbSubCategoriaMouseClicked(evt);
            }
        });
        jPanel1.add(cmbSubCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 140, -1));

        txtPrecoCusto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtPrecoCusto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPrecoCusto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecoCustoFocusLost(evt);
            }
        });
        jPanel1.add(txtPrecoCusto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 150, -1));
        jPanel1.add(txtCodBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 190, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Código de Barra");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        imagemfundo.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        imagemfundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesteste/fundo_opaco.png"))); // NOI18N
        jPanel1.add(imagemfundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 20, 870, 240));

        jTabbedPane1.addTab("Cadastrar", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaCadProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód Prod", "Categoria", "SubCategoria", "Nome", "Descrição", "Preço de Custo", "Preço de Venda", "Comissão"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCadProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCadProdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCadProd);
        if (tabelaCadProd.getColumnModel().getColumnCount() > 0) {
            tabelaCadProd.getColumnModel().getColumn(0).setPreferredWidth(35);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 790, 190));

        tabelaCadProd1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód Prod", "Categoria", "SubCategoria", "Nome", "Descrição", "Preço de Custo", "Preço de Venda", "Comissão"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCadProd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCadProd1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaCadProd1);
        if (tabelaCadProd1.getColumnModel().getColumnCount() > 0) {
            tabelaCadProd1.getColumnModel().getColumn(0).setPreferredWidth(35);
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 790, 190));

        chkExibirT.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        chkExibirT.setSelected(true);
        chkExibirT.setText("Exibir Todos");
        chkExibirT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkExibirTItemStateChanged(evt);
            }
        });
        jPanel2.add(chkExibirT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel14.setText("Procurar por");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));
        jPanel2.add(txtNomeProcura, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 268, -1));

        cmbPropriedades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Id", "Descrição", "Preço de Custo", "Preço de Venda" }));
        jPanel2.add(cmbPropriedades, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 75, -1));

        jTabbedPane1.addTab("Produtos Cadastrados", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 820, -1));

        setBounds(0, 0, 834, 358);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        //cadastrar produto

        try {
//            CategoriaModelo cat = new CategoriaModelo();
//            SubCategoriaModelo subcat = new SubCategoriaModelo();
            //Pega o objeto do combobox categoria
//            cat = (CategoriaModelo) cmbCategoria.getSelectedItem();
            ProdutoModelo prod = new ProdutoModelo();
            prod.setNomeProduto(txtNomeProd.getText());
            prod.setPrecoCusto(Double.parseDouble(txtPrecoCusto.getText().replace(",", ".")));
            prod.setPrecoVenda(Double.parseDouble(txtPrecoVenda.getText().replace(",", ".")));
            prod.setComissao(Double.parseDouble(txtComissao.getText().replace(",", ".")));
            prod.setDescricaoProduto(txtDescricaoProd.getText());
            prod.setSubCategoria((SubCategoriaModelo) cmbSubCategoria.getSelectedItem());

            ProdutoDAO dao = new ProdutoDAO();
            prod.setCodBarraProduto(Long.parseLong(txtCodBarra.getText()));
            
            dao.cadastraProduto(prod);

//            if(txtCodBarra.getText().equals(null))
//            {
//            dao.cadastraProduto(prod);
//            }else{
//            prod.setCodBarraProduto(Integer.parseInt(txtCodBarra.getText()));
//            dao.cadastraProduto(prod);
//            }
            JOptionPane.showMessageDialog(null, "Produto cadastro com sucesso");
            ListarProdutos();
        } catch (Exception e) {
                        ProdutoModelo prod = new ProdutoModelo();
            prod.setNomeProduto(txtNomeProd.getText());
            prod.setPrecoCusto(Double.parseDouble(txtPrecoCusto.getText().replace(",", ".")));
            prod.setPrecoVenda(Double.parseDouble(txtPrecoVenda.getText().replace(",", ".")));
            prod.setComissao(Double.parseDouble(txtComissao.getText().replace(",", ".")));
            prod.setDescricaoProduto(txtDescricaoProd.getText());
            prod.setSubCategoria((SubCategoriaModelo) cmbSubCategoria.getSelectedItem());

            ProdutoDAO dao = new ProdutoDAO();
            dao.cadastraProdutoSemCodBarra(prod);
            JOptionPane.showMessageDialog(null, "Produto cadastro com sucesso");
            ListarProdutos();

        }

        /* verificação if (txtNomeProd.getText().equals("")|| cmbCategoria.getSelectedIndex() == 0 || txtCadEstQtdMax.getText().equals("")|| txtCadEsttxtValorUnid).equals(""))
        { 
            String nomeDoDado;
            if(txtNomeProd.getText().equals("")){
            nomeDoDado = "Nome do Produto.";
            JOptionPane.showMessageDialog(null, "Impossivel realizar cadastro, seguintes dados vazios: " +nomeDoDado);
            }else if (cmbCategoria.getSelectedIndex()==0){
            nomeDoDado = "Categoria.";
            JOptionPane.showMessageDialog(null, "Impossivel realizar cadastro, seguintes dados vazios: " +nomeDoDado);
            }else if(txtCadEstQtdMax.getText().equals("")){
         txtValorUnid "Quantidade Máxima.";
            JOptionPane.showMessageDialog(null, "Impossivel realizar cadastro, seguintes dados vazios: " +nomeDoDado);
            }else if(txtCadEstQtdMin.getText().equals("")){
            nomeDoDado = "Quantidade Minima.";
            JOptionPane.showMessageDialog(null, "Impossivel realizar cadastro, seguintes dados vazios: " +nomeDoDado);
            }
            
        } 
        else {*/

    }//GEN-LAST:event_btnInserirActionPerformed

    //for (; cmbcategoria <= cmbCategoria.getSelectedIndex(); cmbcategoria++) {
    //if (cmbcategoria == cmbCategoria.getSelectedIndex()) {
    private void LimparDados() {
//        txtProdId.setText(null);
        txtNomeProd.setText(null);
        cmbSubCategoria.setSelectedIndex(0);
        txtDescricaoProd.setText(null);
        txtPrecoCusto.setText(null);
        txtPrecoVenda.setText(null);
        txtComissao.setText(null);
//        txtdatacalendar.setCalendar("");
    }

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // limpar
        LimparDados();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // alterar
//        if (txtProdId.getText().equals("") || txtProdId.getText().equals(null)) {
        JOptionPane.showMessageDialog(null, this.tabela.getValueAt(0, 3));

        DefaultTableModel modelo1 = (DefaultTableModel) tabelaCadProd.getModel();
        try {
            int linhas = modelo1.getRowCount();
            for (int l = 0; l < linhas; l++) {
                int colunas = modelo1.getColumnCount();
                for (int c = 0; c < colunas; c++) {

                    if (this.tabela.getValueAt(l, c).equals(modelo1.getValueAt(l, c))) {
                    } else {

                        ProdutoModelo produtomodelo = new ProdutoModelo();
                        ProdutoDAO produtodao = new ProdutoDAO();
                        produtomodelo.setIdProduto(Integer.parseInt(tabelaCadProd.getValueAt(l, 0).toString()));
                        switch (c) {
                            case 3:
                                produtomodelo.setNomeProduto(tabelaCadProd.getValueAt(l, c).toString());
                                produtodao.alterarNomeProduto(produtomodelo);
                                JOptionPane.showMessageDialog(null, "Nome alterado com sucesso!");
                                break;
                            case 4:
                                produtomodelo.setDescricaoProduto(tabelaCadProd.getValueAt(l, c).toString());
                                produtodao.alterarDescricaoProduto(produtomodelo);
                                JOptionPane.showMessageDialog(null, "Descrição alterada com sucesso!");
                                break;
                            case 5:
                                produtomodelo.setPrecoCusto(Double.parseDouble(tabelaCadProd.getValueAt(l, c).toString()));
                                produtomodelo.setComissao(Double.parseDouble(tabelaCadProd.getValueAt(l, 6).toString()) - Double.parseDouble(tabelaCadProd.getValueAt(l, c).toString()));
                                produtodao.alterarPrecoCustoProduto(produtomodelo);
                                JOptionPane.showMessageDialog(null, "Preço de Custo alterado com sucesso!");
                                break;
                            case 6:
                                produtomodelo.setPrecoVenda(Double.parseDouble(tabelaCadProd.getValueAt(l, c).toString()));
                                produtomodelo.setComissao(Double.parseDouble(tabelaCadProd.getValueAt(l, c).toString()) - Double.parseDouble(tabelaCadProd.getValueAt(l, 5).toString()));
                                produtodao.alterarPrecoVendaProduto(produtomodelo);
                                JOptionPane.showMessageDialog(null, "Preço de Venda alterado com sucesso!");
                                break;
                        }

                    }

                }

            }
            ListarProdutos();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        /*        JOptionPane.showMessageDialog(null, "Campo ID produto vazio, tente selecionar a tabela novamente.");
//        } else {
        if (JOptionPane.showConfirmDialog(null, "Deseja realmente alterar campo?", "Alteração de Campos", 2) == JOptionPane.OK_OPTION) {
            try {

                ProdutoModelo prod = new ProdutoModelo();
                CategoriaModelo cat = new CategoriaModelo();

                //Pega o objeto do combobox categoria
//                    cat = (CategoriaModelo) cmbCategoria.getSelectedItem();
//                    prod.setIdProduto(Integer.parseInt(txtProdId.getText()));
                prod.setNomeProduto(txtNomeProd.getText());
//                    prod.setCategoria(cat);
                prod.setPrecoCusto(Double.parseDouble(txtPrecoCusto.getText()));
                prod.setPrecoVenda(Double.parseDouble(txtPrecoVenda.getText()));
                prod.setComissao(Double.parseDouble(txtComissao.getText()));
                prod.setDescricaoProduto(txtDescricaoProd.getText());

//                    //Formatando a data
//                    SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
//                    String dataformatada = formatador.format(txtdatacalendar.getDate());
//
//                    prod.setData(dataformatada);
                ProdutoDAO dao = new ProdutoDAO();
                dao.alterarProduto(prod);

                JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso");
                ListarProdutos();
            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "Ops, ocorreu um erro ao alterar os dados do produto: " + e);
            }
//            }
        }
         */
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // exclui

        try {
            ProdutoModelo produtomodelo = new ProdutoModelo();

            if (tabelaCadProd.getSelectedRow() == -1) {

                JOptionPane.showMessageDialog(null, "Nenhum produto selecionado, por favor tente selecionar a tabela novamente.");
            } else {
                //verificaçao
//             if (JOptionPane.showConfirmDialog(null, "A venda não foi totalmente paga, deseja sair mesmo assim ?", "Fechar tela de Pagamento", 0) == JOptionPane.YES_OPTION) {
//                this.dispose();
//            }
                produtomodelo.setIdProduto(Integer.parseInt(tabelaCadProd.getValueAt(tabelaCadProd.getSelectedRow(), 0).toString()));
                ProdutoDAO dao = new ProdutoDAO();
                dao.excluirProduto(produtomodelo);

                JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
                ListarProdutos();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ops, ocorreu um erro ao excluir os dados: " + e);
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tabelaCadProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCadProdMouseClicked
        // TODO add your handling code here:
//        txtProdId.setText(tabelaCadProd.getValueAt(tabelaCadProd.getSelectedRow(), 0).toString());
//        txtNomeProd.setText(tabelaCadProd.getValueAt(tabelaCadProd.getSelectedRow(), 2).toString());
//        txtDescricaoProd.setText(tabelaCadProd.getValueAt(tabelaCadProd.getSelectedRow(), 3).toString());
//        txtPrecoCusto.setText(tabelaCadProd.getValueAt(tabelaCadProd.getSelectedRow(), 4).toString());
//        txtPrecoVenda.setText(tabelaCadProd.getValueAt(tabelaCadProd.getSelectedRow(), 5).toString());
//        txtComissao.setText(tabelaCadProd.getValueAt(tabelaCadProd.getSelectedRow(), 6).toString());
//
//        String dataStr = (String) tabelaCadProd.getValueAt(tabelaCadProd.getSelectedRow(), 7).toString();
//        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
//        Date data = new Date(0);
//        try {
//            data = formatador.parse(dataStr);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        txtdatacalendar.setDate(data);
    }//GEN-LAST:event_tabelaCadProdMouseClicked

    private void btnGerenciarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenciarCategoriaActionPerformed

//        String novacategoria = JOptionPane.showInputDialog(null, "digite o nome da categoria").toString();
//            CategoriaModelo categoriamodelo = new CategoriaModelo();
//            categoriamodelo.setCategoria_desc(novacategoria);
//            ProdutoDAO dao = new ProdutoDAO();
//            dao.cadastraCategoria(categoriamodelo);
//
//            JOptionPane.showMessageDialog(null, "Categoria Cadastrada!");
        FrmCategoria categoria = new FrmCategoria();
        categoria.setVisible(true);
    }//GEN-LAST:event_btnGerenciarCategoriaActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        tabela = ListarProdutos();
//        ListarCategoriaNoCMB();
        ListarSubCategoriaNoCMB();
    }//GEN-LAST:event_formInternalFrameOpened

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            String campo = "";
            switch (cmbPropriedades.getSelectedIndex()) {
                case 0:
                    campo = "produto_nome";
                    break;
                case 1:
                    campo = "produto_id";
                    break;
                case 2:
                    campo = "produto_desc";
                    break;
                case 3:
                    campo = "produto_preco_custo";
                    break;
                case 4:
                    campo = "produto_preco_venda";
                    break;
            }

            ProdutoDAO dao = new ProdutoDAO();
            List<ProdutoModelo> listadeprodutos = dao.buscarProdutoPorNome(campo, txtNomeProcura);

            DefaultTableModel modelo = (DefaultTableModel) tabelaCadProd.getModel();
            modelo.setNumRows(0);

            for (ProdutoModelo prodModel : listadeprodutos) {
//                CategoriaModelo categoria = new CategoriaModelo();
//                SubCategoriaModelo subcategoria = new SubCategoriaModelo();
                modelo.addRow(new Object[]{
                    prodModel.getIdProduto(),
                    prodModel.getSubCategoria().getCategoria(),
                    prodModel.getSubCategoria(),
                    prodModel.getNomeProduto(), // STATUS EX: EM ESTOQUE
                    prodModel.getDescricaoProduto(),
                    prodModel.getPrecoCusto(),
                    prodModel.getPrecoVenda(),
                    prodModel.getComissao()
                });
            }

//            chkExibirT.setSelected(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Procurar Produto: " + e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void chkExibirTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkExibirTItemStateChanged
        // TODO add your handling code here:
        if (chkExibirT.isSelected() == false) {
            DefaultTableModel modelo = (DefaultTableModel) tabelaCadProd.getModel();
            modelo.setNumRows(0);
        } else {
            ListarProdutos();
        }
    }//GEN-LAST:event_chkExibirTItemStateChanged

    private void formInternalFrameIconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameIconified
        // TODO add your handling code here:
//        if(this.isIconifiable() ==true ){
//        this.
//        }
        this.setBounds(422, 0, 635, 383);
    }//GEN-LAST:event_formInternalFrameIconified

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:

    }//GEN-LAST:event_formComponentResized

    private void cmbSubCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbSubCategoriaMouseClicked
        // TODO add your handling code here:
        ListarSubCategoriaNoCMB();
    }//GEN-LAST:event_cmbSubCategoriaMouseClicked

    private void txtPrecoVendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecoVendaFocusLost
        if (txtPrecoCusto.getText().equals("") && txtPrecoVenda.getText().equals("")) {

        } else {
            txtComissao.setText(String.valueOf(Double.parseDouble(txtPrecoVenda.getText().replace(",", ".")) - Double.parseDouble(txtPrecoCusto.getText().replace(",", "."))));
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoVendaFocusLost

    private void txtPrecoCustoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecoCustoFocusLost
        if (txtPrecoCusto.getText().equals("") && txtPrecoVenda.getText().equals("")) {

        } else if (!txtPrecoCusto.getText().equals("") && txtPrecoVenda.getText().equals("")) {

        } else {

            txtComissao.setText(String.valueOf(Double.parseDouble(txtPrecoVenda.getText().replace(",", ".")) - Double.parseDouble(txtPrecoCusto.getText().replace(",", "."))).replace(".", ","));
        } // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoCustoFocusLost

    private void tabelaCadProd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCadProd1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaCadProd1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnGerenciarCategoria;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JCheckBox chkExibirT;
    private javax.swing.JComboBox<String> cmbPropriedades;
    private javax.swing.JComboBox cmbSubCategoria;
    private javax.swing.JLabel imagemfundo;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tabelaCadProd;
    private javax.swing.JTable tabelaCadProd1;
    private javax.swing.JTextField txtCodBarra;
    private javax.swing.JFormattedTextField txtComissao;
    private javax.swing.JTextField txtDescricaoProd;
    private javax.swing.JTextField txtNomeProcura;
    private javax.swing.JTextField txtNomeProd;
    private javax.swing.JFormattedTextField txtPrecoCusto;
    private javax.swing.JFormattedTextField txtPrecoVenda;
    // End of variables declaration//GEN-END:variables
}
