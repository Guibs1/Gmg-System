package br.com.gestaodeestoque.Views;

import br.com.gestaodeestoque.Models.ClientesModelo;
import br.com.gestaodeestoque.Models.EstoqueModelo;
import br.com.gestaodeestoque.Models.FuncionarioModelo;
import br.com.gestaodeestoque.Models.ItensVendaModelo;
import br.com.gestaodeestoque.Models.PagamentoModelo;
import br.com.gestaodeestoque.Models.PedidosModelo;
import br.com.gestaodeestoque.Models.ProdutoModelo;
import br.com.gestaodeestoque.Models.VendaModelo;
//import br.com.gestaodeestoque.Utilities.CriaObjetos;
import static br.com.gestaodeestoque.Views.FrmDialogPagamento.vendamodelo;
import br.com.gestaodeestoque.dao.EstoqueDAO;
import br.com.gestaodeestoque.dao.ItemVendaDAO;
import br.com.gestaodeestoque.dao.PagamentoDAO;
import br.com.gestaodeestoque.dao.PedidosDAO;
import br.com.gestaodeestoque.dao.ProdutoDAO;
import br.com.gestaodeestoque.dao.VendasDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class FrmVendasEPedidos extends javax.swing.JFrame {

    public FrmVendasEPedidos(FuncionarioModelo idfuncionario) {
        initComponents();
        this.funcionariomodelo = idfuncionario;
        btnFinalizar.setEnabled(false);
        txtconsulta.setEnabled(false);
        btnAdicionar.setEnabled(false);
        listDePesquisa.setVisible(false);
        btnCancelarVenda.setEnabled(false);
        txtDesconto.setEnabled(false);
        txtqtd.setEnabled(false);
        cmbOpcoes.setEnabled(false);
        listDePesquisaDescricao.setVisible(false);
        tabela_itens_venda.setFocusable(false);
    }

    int linha = 0;
    double total = 0;
    static FuncionarioModelo funcionariomodelo;
    VendaModelo vendamodelo;
    ItensVendaModelo itemvendamodelo;

    public void limpar() {
        // IMPORTANTEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
        vendamodelo = null;
        DefaultTableModel modelo = (DefaultTableModel) tabela_itens_venda.getModel();
        modelo.setNumRows(0);
        txtconsulta.setText(null);
        txtCodProd.setText(null);
        txtDescProd.setText(null);
        txtDesconto.setText(null);
        txtqtd.setText(null);
        txtTotal.setText(null);
        txtValorProd.setText(null);
        txtNomeProd.setText(null);
        linha = 0;
        total = 0;
        btnCancelarVenda.setEnabled(false);
        txtqtd.setEnabled(false);
        txtDesconto.setEnabled(false);
        btnAdicionar.setEnabled(false);
        btnFinalizar.setEnabled(false);
    }

    public void checaVendaPaga() {
        if (vendamodelo != null) {
            if (!"".equals(txtTotal.getText())) {
                PagamentoDAO dao = new PagamentoDAO();
                PagamentoModelo pagos = dao.checarSeVendaFoiPaga(vendamodelo);

                if (pagos.getValor_pago() != 0) {
                    if (vendamodelo.getVenda_total() == pagos.getValor_pago() || pagos.getValor_pago() > vendamodelo.getVenda_total()) {

                        VendasDAO vendadao = new VendasDAO();
                        vendamodelo.setVendaStatus(1);
                        vendadao.fecharVenda(vendamodelo);
                        limpar();
                    }
                }
            }
        }
    }
//
//    public Boolean checaVendaPagaParcialmente()
//    {
//        try {
//            PagamentoModelo pagamentomodelo = new PagamentoModelo();
//            pagamentomodelo.setPedido(vendamodelo);
//            PagamentoDAO dao = new PagamentoDAO();
//            dao.checarSePedidoFoiPaga(pedidosmodelo);
//        } catch (Exception e) {
//            throw new Exception(e);
//        }
//    }
    
    public void cancelarVenda() {
        int qtdLinhas = tabela_itens_venda.getRowCount();
        
        if (qtdLinhas == 0) {
            try {
                //FUNCIONA, SÓ CANCELA A VENDA
                VendasDAO vendadao = new VendasDAO();
                vendadao.cancelarVenda(this.vendamodelo);
                btnFinalizar.setEnabled(false);
                txtconsulta.setEnabled(false);
                btnAdicionar.setEnabled(false);
                txtDesconto.setEnabled(false);
                txtqtd.setEnabled(false);
                cmbOpcoes.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Venda cancelada com sucesso!");
                limpar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erro" + e);
            }
        } else {
            try {//pra cancela a venda precisa cancela os itens primeiro.
//                itemvendamodelo.setVenda(vendamodelo);
                ItemVendaDAO itemvendadao = new ItemVendaDAO();
                itemvendadao.apagarItensVenda(this.vendamodelo);
                VendasDAO vendadao = new VendasDAO();
                vendadao.cancelarVenda(vendamodelo);
                btnFinalizar.setEnabled(false);
                txtconsulta.setEnabled(false);
                btnAdicionar.setEnabled(false);
                txtDesconto.setEnabled(false);
                txtqtd.setEnabled(false);
                cmbOpcoes.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Vendas e itens venda canceladas com sucesso!");
                limpar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erro" + e);
            }
        }
    }

    public VendaModelo novaVenda() {
        VendaModelo venda = new VendaModelo();
        FuncionarioModelo funcionario = new FuncionarioModelo();

        Date dataSistema = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        String dataformatada = formatador.format(dataSistema);
        venda.setData(dataformatada);

        funcionario.setFuncionario_id(funcionariomodelo.getFuncionario_id());
        venda.setFuncionario(funcionario);

        return venda;
    }

    public void listaPedidos() {
        PedidosDAO dao = new PedidosDAO();
        List<PedidosModelo> listadepedidos = dao.listarPedidos();

        DefaultTableModel modelo = (DefaultTableModel) tabela_pedidos.getModel();
        modelo.setNumRows(0);

        for (PedidosModelo pedidos : listadepedidos) {
            String pago = "Não";
            if (pedidos.getStatusPago() == 1) {
                pago = "Sim";
            }
            if(pedidos.getStatus() == 0){
                        modelo.addRow(new Object[]{
                pedidos.getPedido_id(),
                pedidos.getFuncionariomodelo().getFuncionario_id(),
                pedidos.getCliente().getCliente_id(),
                pedidos.getHorario_retirada(),
                pedidos.getDesconto(),
                pedidos.getTotal(),
                pago,
                "Pedido em aberto"
            });
            }

        }
    }

    public void desconto() {
        if (cmbOpcoes.getSelectedIndex() == 1) {
            String desconto = JOptionPane.showInputDialog(null, "Digite o valor do desconto em porcentagem. Sem o caracter''%''.").toString();
            if (desconto.isEmpty() == true) {

            } else {
                try {
//                    VendaModelo vendamodelo = new VendaModelo();
                    VendasDAO dao = new VendasDAO();
                    double Desconto, total;
                    Desconto = Double.parseDouble(desconto) / 100;
                    total = Double.parseDouble(txtTotal.getText()) - (Double.parseDouble(txtTotal.getText()) * Desconto);
//                    VendaModelo venda = dao.idVendaEmAberta();
//                    vendamodelo.setVenda_id(vendamodelo.getVenda_id());
                    vendamodelo.setVenda_desconto(Desconto);
                    vendamodelo.setVenda_sem_desconto(Double.parseDouble(txtTotal.getText()));
                    vendamodelo.setVenda_total(total);

                    dao.setaDescontoETotal(vendamodelo);

                    txtTotal.setText(String.valueOf(total));
                    JOptionPane.showMessageDialog(null, "Desconto Aplicado!");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "erro" + e);
                }
            }
        }
    }

//    public void inserirItemVenda() {
//        ItensVendaModelo itemvendamodelo = new ItensVendaModelo();
//        VendaModelo vendaEmAberto = new VendasDAO().idVendaEmAberta();
//        itemvendamodelo.setVenda(vendaEmAberto);
////        vendamodelo.setProduto(produto);
////        vendamodelo.setQtd();
//
//    }
    public void adicionarItemVenda(int idproduto) {
        //CALCULO DO DESCONTO
        ProdutoDAO produtodao = new ProdutoDAO();
        double desconto = 0;
        try {
            ProdutoModelo produtomodelo = produtodao.ProcurarProdutoPorQlqCampo("tb_produto.produto_id", idproduto);
            double subtotal = Double.parseDouble(txtqtd.getText()) * produtomodelo.getPrecoVenda();
            if (txtDesconto.getText().equals("")) {

            } else {
                desconto = Double.parseDouble(txtDesconto.getText());
                desconto = desconto / 100;
                desconto = subtotal * desconto;
                subtotal = subtotal - desconto;
            }

            //FIM CALCULO DO DESCOTO
            DefaultTableModel modelo = (DefaultTableModel) tabela_itens_venda.getModel();

            modelo.addRow(new Object[]{
                produtomodelo.getIdProduto(),
                produtomodelo.getSubCategoria().toString(),
                produtomodelo.getNomeProduto(),
                produtomodelo.getDescricaoProduto(),
                txtqtd.getText(),
                produtomodelo.getPrecoVenda(),
                desconto,
                subtotal
            });
            //}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar Produto." + e);
        }
    }

    public void Consulta(String campo) {
        if (txtconsulta.getText().equals("")) {
            listDePesquisa.setVisible(false);
            listDePesquisaDescricao.setVisible(false);
        } else {

            ProdutoDAO dao = new ProdutoDAO();
            List<ProdutoModelo> listadeprodutos = dao.buscarProdutoPorNome(campo, txtconsulta);

            DefaultListModel modelo = new DefaultListModel();
            modelo.removeAllElements();

            DefaultListModel modelo2 = new DefaultListModel();
            modelo2.removeAllElements();
//            List<VendaModelo> lista = dao.buscarProdutoPorNome("produto_nome", txtCodProd);  
//            int i =0;
            for (ProdutoModelo produtomodelo : listadeprodutos) {
                modelo.addElement(produtomodelo);
                modelo2.addElement(produtomodelo.getDescricaoProduto());
            }
            listDePesquisa.setModel(modelo);
            listDePesquisaDescricao.setModel(modelo2);
            int v = modelo.getSize();
            if (v != 0) {
                listDePesquisa.setVisible(true);
                listDePesquisaDescricao.setVisible(true);
            } else if (v == 0) {
                listDePesquisa.setVisible(false);
                listDePesquisaDescricao.setVisible(false);
            }
//            txtCodProd.setText(String.valueOf(v.getProduto().getIdProduto()));
//            txtNomeProd.setText(v.getProduto().getNomeProduto());
//            txtDescProd.setText(v.getProduto().getDescricaoProduto());
            //Mostrando a pesquisa nos campos de texto
            //txtconsulta.setText(p.getNomeProduto());

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        TabbledVendas = new javax.swing.JPanel();
        listDePesquisa = new javax.swing.JList();
        listDePesquisaDescricao = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_itens_venda = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        painelAcoes = new javax.swing.JPanel();
        btnCancelarVenda = new javax.swing.JButton();
        btnNovaVenda = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtconsulta = new javax.swing.JTextField();
        btnFinalizar = new javax.swing.JButton();
        painelProduto = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtDescProd = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodProd = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDesconto = new javax.swing.JTextField();
        txtqtd = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        txtNomeProd = new javax.swing.JTextField();
        txtValorProd = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cmbOpcoes = new javax.swing.JComboBox<>();
        txtTotal = new javax.swing.JTextField();
        lblImagemFundo = new javax.swing.JLabel();
        TabbledPedidos = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnNovoPedido = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnCancelarPedido = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnVoltarAcao = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_pedidos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        lblImagemFundo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Vendas");
        setResizable(false);
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

        TabbledVendas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TabbledVendasFocusGained(evt);
            }
        });
        TabbledVendas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listDePesquisa.setBorder(new javax.swing.border.MatteBorder(null));
        listDePesquisa.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        listDePesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listDePesquisaMouseClicked(evt);
            }
        });
        TabbledVendas.add(listDePesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 430, -1));

        listDePesquisaDescricao.setBorder(new javax.swing.border.MatteBorder(null));
        listDePesquisaDescricao.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        listDePesquisaDescricao.setEnabled(false);
        listDePesquisaDescricao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listDePesquisaDescricaoMouseClicked(evt);
            }
        });
        TabbledVendas.add(listDePesquisaDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, -1, -1));

        tabela_itens_venda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabela_itens_venda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód do Produto", "SubCategoria", "Nome", "Desc", "Qtd", "Valor Unit.", "Desconto", "SubTotal", "Ações"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabela_itens_venda);
        if (tabela_itens_venda.getColumnModel().getColumnCount() > 0) {
            tabela_itens_venda.getColumnModel().getColumn(0).setResizable(false);
            tabela_itens_venda.getColumnModel().getColumn(1).setResizable(false);
            tabela_itens_venda.getColumnModel().getColumn(2).setResizable(false);
            tabela_itens_venda.getColumnModel().getColumn(3).setResizable(false);
            tabela_itens_venda.getColumnModel().getColumn(4).setResizable(false);
            tabela_itens_venda.getColumnModel().getColumn(5).setResizable(false);
            tabela_itens_venda.getColumnModel().getColumn(6).setResizable(false);
            tabela_itens_venda.getColumnModel().getColumn(7).setResizable(false);
            tabela_itens_venda.getColumnModel().getColumn(8).setResizable(false);
        }

        TabbledVendas.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 138, 600, 400));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Total R$:");
        TabbledVendas.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 470, -1, -1));

        painelAcoes.setBackground(new java.awt.Color(49, 71, 104));
        painelAcoes.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        painelAcoes.setForeground(new java.awt.Color(51, 102, 255));
        painelAcoes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelarVenda.setText("Cancelar");
        btnCancelarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVendaActionPerformed(evt);
            }
        });
        painelAcoes.add(btnCancelarVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, 79, 74));

        btnNovaVenda.setText("Nova Venda");
        btnNovaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaVendaActionPerformed(evt);
            }
        });
        painelAcoes.add(btnNovaVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, -1, 74));

        TabbledVendas.add(painelAcoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 1090, 90));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Código de barra ou Nome  do Item");
        TabbledVendas.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        txtconsulta.setBackground(new java.awt.Color(102, 153, 255));
        txtconsulta.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtconsulta.setForeground(new java.awt.Color(255, 255, 255));
        txtconsulta.setToolTipText("");
        txtconsulta.setBorder(null);
        txtconsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtconsultaKeyReleased(evt);
            }
        });
        TabbledVendas.add(txtconsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 1010, 60));

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });
        TabbledVendas.add(btnFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 480, 79, 40));

        painelProduto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações do Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        painelProduto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Código");
        painelProduto.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        txtDescProd.setEnabled(false);
        painelProduto.add(txtDescProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 170, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Descrição");
        painelProduto.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Quantidade");
        painelProduto.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        txtCodProd.setEnabled(false);
        painelProduto.add(txtCodProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 170, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Nome");
        painelProduto.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Desconto no Item");
        painelProduto.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, -1));
        painelProduto.add(txtDesconto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 150, 30));
        painelProduto.add(txtqtd, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 150, 30));

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        painelProduto.add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 87, 30));

        txtNomeProd.setEnabled(false);
        painelProduto.add(txtNomeProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 170, 30));

        txtValorProd.setEnabled(false);
        painelProduto.add(txtValorProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 170, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Valor do produto");
        painelProduto.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        TabbledVendas.add(painelProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, 390, 320));

        cmbOpcoes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Opções", "Desconto" }));
        TabbledVendas.add(cmbOpcoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 470, 80, -1));

        txtTotal.setEnabled(false);
        TabbledVendas.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, 210, 30));

        lblImagemFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesteste/fundo_opaco.png"))); // NOI18N
        TabbledVendas.add(lblImagemFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 1120, 560));

        jTabbedPane1.addTab("Vendas", TabbledVendas);

        TabbledPedidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TabbledPedidosFocusGained(evt);
            }
        });
        TabbledPedidos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnNovoPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Create Document_39px.png"))); // NOI18N
        btnNovoPedido.setText("Novo Pedido");
        btnNovoPedido.setFocusable(false);
        btnNovoPedido.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNovoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoPedidoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNovoPedido);

        btnAlterar.setText("Alterar Pedido");
        btnAlterar.setFocusable(false);
        btnAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnAlterar);

        btnCancelarPedido.setText("Cancelar Pedido");
        btnCancelarPedido.setFocusable(false);
        btnCancelarPedido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelarPedido.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnCancelarPedido);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("|");
        jToolBar1.add(jLabel2);

        btnVoltarAcao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Sort Left_39px.png"))); // NOI18N
        btnVoltarAcao.setText("Voltar Ação");
        btnVoltarAcao.setFocusable(false);
        btnVoltarAcao.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jToolBar1.add(btnVoltarAcao);

        TabbledPedidos.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1083, 51));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pedidos Pendentes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabela_pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód Pedido", "Cód Funcionário", "Cód Cliente", "Horário de Retirada", "Desconto", "Total", "Pago", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Double.class, java.lang.Float.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabela_pedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_pedidosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_pedidos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 1000, 450));

        jButton1.setText("Concluir Pedido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 480, -1, -1));

        TabbledPedidos.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 1020, 520));

        lblImagemFundo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesteste/fundo do sftware.png"))); // NOI18N
        TabbledPedidos.add(lblImagemFundo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1090, 600));

        jTabbedPane1.addTab("Pedidos", TabbledPedidos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        setSize(new java.awt.Dimension(1101, 710));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        // TODO add your handling code here:
        if (txtTotal.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "nenhum item a ser vendido.");
        } else {
            int linhasdatabela = tabela_itens_venda.getRowCount();

            ItensVendaModelo itensmodelo = new ItensVendaModelo();
//            VendaModelo venda = new VendasDAO().idVendaEmAberta();
            //CADASTRAR OS ITENS DA TABELA
            for (int l = 0; l < linhasdatabela; l++) {

                itensmodelo.setVenda(vendamodelo);
                ProdutoModelo produto = new ProdutoModelo();
                produto.setIdProduto(Integer.parseInt(tabela_itens_venda.getValueAt(l, 0).toString()));
                itensmodelo.setProduto(produto);
                itensmodelo.setQtd(Integer.parseInt(tabela_itens_venda.getValueAt(l, 4).toString()));
                itensmodelo.setValorUni(Double.parseDouble(tabela_itens_venda.getValueAt(l, 5).toString()));
                itensmodelo.setDesconto(Double.parseDouble(tabela_itens_venda.getValueAt(l, 6).toString()));
                itensmodelo.setSubtotal(Double.parseDouble(tabela_itens_venda.getValueAt(l, 7).toString()));

                ItemVendaDAO itemvendadao = new ItemVendaDAO();
                itemvendadao.inserir(itensmodelo);
            } // FIM DO CADASTRO DOS ITENS

            //CHECA SE O DESCONTO TA SELECIONADO 
            if (cmbOpcoes.getSelectedIndex() == 1) {
                //CADASTRA SE O DESCONTO ESTIVER SELECIONADO
                desconto();
                //       JOptionPane.showMessageDialog(null, "desconto selecionado");
            } else {
                //CADASTRA SE O DESCONTO NÃO ESTIVER SELECIONADO.
                try {
                    vendamodelo.setVenda_sem_desconto(Double.parseDouble(txtTotal.getText()));
                    vendamodelo.setVenda_total(Double.parseDouble(txtTotal.getText()));
                    VendasDAO vendasdao = new VendasDAO();
                    vendasdao.setaDescontoETotal(vendamodelo);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro" + e);
                }

            }
            //abir form        
            FrmDialogPagamento pagamento = new FrmDialogPagamento(this, true, null, vendamodelo);
            pagamento.setVisible(true);
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

// arrumar depoiis

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // TODO add your handling code here:
        //puxar do click os dados do produto.
        EstoqueModelo estoquemodelo = new EstoqueModelo();
        ProdutoModelo produtomodelo = new ProdutoModelo();
        produtomodelo.setIdProduto(Integer.parseInt(txtCodProd.getText()));
        estoquemodelo.setProduto(produtomodelo);
        estoquemodelo.setEst_produto_qtd(Integer.parseInt(txtqtd.getText()));

        EstoqueDAO estoquedao = new EstoqueDAO();
        try {
            if (estoquedao.valida_qtd_desejada(estoquemodelo).equals("Em Estoque.")) {
                JOptionPane.showMessageDialog(null, "Produto em estoque.");
                adicionarItemVenda(Integer.parseInt(txtCodProd.getText()));
                double valoritem = Double.parseDouble(tabela_itens_venda.getValueAt(linha, 7).toString());
                total += valoritem;
                txtTotal.setText(String.valueOf(total));
                linha++;
            } else {
                JOptionPane.showMessageDialog(null, "Produto sem estoque ou não cadastrado!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Produto sem estoque ou não cadastrado!");
        }

        //checa se produto tem a qtd no estoque

    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
//        VendaModelo teste = new VendaModelo();
        if (vendamodelo != null) {
            if (JOptionPane.showConfirmDialog(null, "Deseja realmente sair da Tela de Vendas, contendo uma venda em aberto?", "Fechar Tela de Vendas", 0) == JOptionPane.YES_OPTION) {
                try {
                    cancelarVenda();
                    this.dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "erro" + e);
                }
            }
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnCancelarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVendaActionPerformed
        // TODO add your handling code here:
        cancelarVenda();
    }//GEN-LAST:event_btnCancelarVendaActionPerformed

    private void btnNovaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaVendaActionPerformed
        // TODO add your handling code here:
        try {

            VendasDAO vendadao = new VendasDAO();
            this.vendamodelo = vendadao.abrirVenda(novaVenda());

            btnFinalizar.setEnabled(true);
            txtconsulta.setEnabled(true);
            btnAdicionar.setEnabled(true);
            txtDesconto.setEnabled(true);
            txtqtd.setEnabled(true);
            btnCancelarVenda.setEnabled(true);
            cmbOpcoes.setEnabled(true);
            btnCancelarVenda.setEnabled(true);
            txtqtd.setEnabled(true);
            txtDesconto.setEnabled(true);
            btnAdicionar.setEnabled(true);
            btnFinalizar.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro" + e);
        }
    }//GEN-LAST:event_btnNovaVendaActionPerformed

    private void txtconsultaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtconsultaKeyReleased
        // TODO add your handling code here:
        try {
            long codbarra = Long.parseLong(txtconsulta.getText());
            try {

                ProdutoDAO produtodao = new ProdutoDAO();
                ProdutoModelo produtomodelo = produtodao.ProcurarProdutoPorQlqCampo("codigo_barra", codbarra);

                txtCodProd.setText(String.valueOf(produtomodelo.getIdProduto()));
                txtNomeProd.setText(String.valueOf(produtomodelo.getNomeProduto()));
                txtDescProd.setText(String.valueOf(produtomodelo.getDescricaoProduto()));
                txtValorProd.setText(String.valueOf(produtomodelo.getPrecoVenda()));
//                if(!txtCodProd.getText().equals(""))
//                {
//                txtqtd.grabFocus();
//                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erro: " + e);
            }

        } catch (Exception e) {
            Consulta("produto_nome");
        }
    }//GEN-LAST:event_txtconsultaKeyReleased

    private void listDePesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listDePesquisaMouseClicked
        // TODO add your handling code here:
        VendaModelo vendaproduto = new VendaModelo();
        vendaproduto.setProduto((ProdutoModelo) listDePesquisa.getSelectedValue());

        //COMPLETAR OS CAMPOS PRINCIPAIS
        txtconsulta.setText(listDePesquisa.getSelectedValuesList().toString().replace("[", "").replace("]", ""));
        txtCodProd.setText(String.valueOf(vendaproduto.getProduto().getIdProduto()));
        txtNomeProd.setText(String.valueOf(vendaproduto.getProduto().getNomeProduto()));
        txtDescProd.setText(String.valueOf(vendaproduto.getProduto().getDescricaoProduto()));
        listDePesquisa.setVisible(false);
        listDePesquisaDescricao.setVisible(false);
        txtValorProd.setText(String.valueOf(vendaproduto.getProduto().getPrecoVenda()));
        txtqtd.grabFocus();
        // PREPARAR O OBJ PARA COMPLETAR A TABELA
//        int selecionado = listDePesquisa.getSelectedIndex();
    }//GEN-LAST:event_listDePesquisaMouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        checaVendaPaga();
        listaPedidos();
        //metodo verifica statusda venda
//        this.vendamodelo

//        else if (pagos.getValor_pago() != 0)
//                {
//                    this.dispose();
//                }
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnNovoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoPedidoActionPerformed
        // TODO add your handling code here:
//        CriaObjetos criapainel = new CriaObjetos();
//        JPanel painel = criapainel.copiaPaineisCriados(painelAcoes);
//        painel.setName("painel1");
//        painel.setText("paineltexto1");
        FrmDialogNovoPedido novopedido = new FrmDialogNovoPedido(this, true, funcionariomodelo);
        novopedido.setVisible(true);
    }//GEN-LAST:event_btnNovoPedidoActionPerformed

    private void listDePesquisaDescricaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listDePesquisaDescricaoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_listDePesquisaDescricaoMouseClicked

    private void tabela_pedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_pedidosMouseClicked
        // TODO add your handling code here:
        //pegar id da tabela
        int id = 0; // id qualquer
        ItensDoPedido itensdopedido = new ItensDoPedido(this, true, id);
    }//GEN-LAST:event_tabela_pedidosMouseClicked

    private void TabbledVendasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TabbledVendasFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_TabbledVendasFocusGained

    private void TabbledPedidosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TabbledPedidosFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_TabbledPedidosFocusGained

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        tabela_pedidos.remove(tabela_pedidos.getSelectedRow());
        if (tabela_pedidos.getValueAt(tabela_pedidos.getSelectedRow(), 6).equals("Sim")) {
            //exclui linha
            try {
                PedidosModelo pedidosmodelo = new PedidosModelo();
                pedidosmodelo.setPedido_id(Integer.parseInt(tabela_pedidos.getValueAt(tabela_pedidos.getSelectedRow(), 0).toString()));
                pedidosmodelo.setStatus(1);
                
                PedidosDAO dao = new PedidosDAO();
                dao.fecharPedido(pedidosmodelo);
                DefaultTableModel modelo = (DefaultTableModel) tabela_pedidos.getModel();
                modelo.removeRow(tabela_pedidos.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Pedido concluido com sucesso.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } else {
            PedidosModelo pedidoselecionado = new PedidosModelo();
            ClientesModelo clientesmodelo = new ClientesModelo();
            FuncionarioModelo funcionariomodelo = new FuncionarioModelo();
            //dar os atributos
            pedidoselecionado.setPedido_id(Integer.parseInt(tabela_pedidos.getValueAt(tabela_pedidos.getSelectedRow(), 0).toString()));
            
            clientesmodelo.setCliente_id(Integer.parseInt(tabela_pedidos.getValueAt(tabela_pedidos.getSelectedRow(), 2).toString()));
            pedidoselecionado.setCliente(clientesmodelo);
            
            funcionariomodelo.setFuncionario_id(Integer.parseInt(tabela_pedidos.getValueAt(tabela_pedidos.getSelectedRow(), 1).toString()));
            pedidoselecionado.setFuncionariomodelo(funcionariomodelo);
            
            pedidoselecionado.setHorario_retirada(tabela_pedidos.getValueAt(tabela_pedidos.getSelectedRow(), 3).toString());
            pedidoselecionado.setDesconto(Double.parseDouble(tabela_pedidos.getValueAt(tabela_pedidos.getSelectedRow(), 4).toString()));
            pedidoselecionado.setTotal(Double.parseDouble(tabela_pedidos.getValueAt(tabela_pedidos.getSelectedRow(), 5).toString()));

            
            //fim atributos
            FrmDialogPagamento pagamento = new FrmDialogPagamento(this, true, pedidoselecionado, null);
            pagamento.setVisible(true);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmVendasEPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVendasEPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVendasEPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVendasEPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVendasEPedidos(funcionariomodelo).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TabbledPedidos;
    private javax.swing.JPanel TabbledVendas;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelarPedido;
    private javax.swing.JButton btnCancelarVenda;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnNovaVenda;
    private javax.swing.JButton btnNovoPedido;
    private javax.swing.JButton btnVoltarAcao;
    private javax.swing.JComboBox<String> cmbOpcoes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblImagemFundo;
    private javax.swing.JLabel lblImagemFundo1;
    private javax.swing.JList listDePesquisa;
    private javax.swing.JList listDePesquisaDescricao;
    private javax.swing.JPanel painelAcoes;
    private javax.swing.JPanel painelProduto;
    private javax.swing.JTable tabela_itens_venda;
    private javax.swing.JTable tabela_pedidos;
    private javax.swing.JTextField txtCodProd;
    private javax.swing.JTextField txtDescProd;
    private javax.swing.JTextField txtDesconto;
    private javax.swing.JTextField txtNomeProd;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtValorProd;
    private javax.swing.JTextField txtconsulta;
    private javax.swing.JTextField txtqtd;
    // End of variables declaration//GEN-END:variables
}
