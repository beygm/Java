/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.OrderController;
import Controller.PedidoController;
import Controller.PizzaController;
import Controller.RegisterController;
import Model.Login;
import Model.Order_item;
import Model.Pedido;
import Model.Pizza;
import Model.PizzaDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jdeav
 */
public class SistemaView extends javax.swing.JFrame {

    Object[][] res;
    public String header[] = {"id", "Nombre", "Descripcion", "Precio", "cantidad", "Vegetarian", "vegan", "available"};
    public String header2[] = {"id", "Nombre", "cantidad", "precio", "total"};
    public String header3[] = {"id", "idCliente", "total", "metodo", "Nota Adicional", "estado"};
    public String header4[] = {"id", "idOrder", "idPizza", "cantidad", "precio"};
    public DefaultTableModel tableModel;
    public PizzaController controladorPizza;
    public PedidoController controladorPedido;
    public OrderController controladorOrder;
    ArrayList<Pizza> lista = new ArrayList();

    public ArrayList<Pizza> pizzas = new ArrayList();
    public ArrayList<Pedido> pedido = new ArrayList();
    public PizzaDao pizzaDAO;

    /**
     * Creates new form Sistema
     */
    public SistemaView() {
        initComponents();
    }

    public SistemaView(Login lg) {
        initComponents();
        idUserEnt.setText(String.valueOf(lg.getIdUser()));
        UsuarioTxtlg.setText(String.valueOf(lg.getNombre()));
        // idUserEnt.setText(String.valueOf(log.getIdUser()));
    }

    public void pedido() {
        System.out.println(lista);

        pizzaDAO = new PizzaDao();
        lista = pizzaDAO.select();

        System.out.println("TAMAÑO PERTENENCIAS " + lista);

        for (int i = 0; i < lista.size(); i++) {

            CMBPizza.addItem(lista.get(i).getId_piza() + "-" + lista.get(i).getNombre() + "-" + lista.get(i).getPrecio());
        }

    }

    public void RegistrarPedido() {

        int resp = 0;

        int idCustomer = Integer.parseInt(idUserEnt.getText());
        //double Total = Double.parseDouble(txtTotal.getText());
        double Total = 1;
        this.controladorPedido = new PedidoController();
        String Method = String.valueOf(CMBMerhod.getSelectedItem());
        String additional_notes = txtNotta.getText();
        String estado = "Activo";

        if (idCustomer == 0 || Total == 0.0 || Method.equals("") || additional_notes.equals("")) {
            JOptionPane.showInternalMessageDialog(null, "Llene todos los campos");
        } else {
            resp = controladorPedido.insert(new Pedido(idCustomer, Total, Method, additional_notes, estado));
            if (resp == 0) {
                JOptionPane.showMessageDialog(null, "error al registrar orden");
            } else {
                // cleanDataTable();

                JOptionPane.showMessageDialog(null, "Registro de cliente exitoso", "Guardar cliente", JOptionPane.INFORMATION_MESSAGE);

            }
        }

    }

    public void tablaPedidos() {
        this.controladorPedido = new PedidoController();
        Object[][] content = controladorPedido.loadDataforTableModel();
        tableModel = new DefaultTableModel(content, header3);
        TablePe.setModel(tableModel);
    }

    public void MostrarProductos() {
        int idOrder = Integer.parseInt(idPedido.getText());
        if (idOrder > 0) {

            System.out.println("esta es la orden N:" + idOrder);
            this.controladorOrder = new OrderController();
            Object[][] content2 = controladorOrder.loadDataforTableModel(new Order_item(idOrder));
            tableModel = new DefaultTableModel(content2, header4);
            tableDe.setModel(tableModel);

        } else {
            JOptionPane.showMessageDialog(null, "seleccione un pedido");
        }

    }

    public void MostrarPro() {
        int idOrder = Integer.parseInt(idPed.getText());
        if (idOrder > 0) {

            System.out.println("esta es la orden N:" + idOrder);
            this.controladorOrder = new OrderController();
            Object[][] content2 = controladorOrder.loadDataforTableModel(new Order_item(idOrder));
            tableModel = new DefaultTableModel(content2, header4);
            tableDet.setModel(tableModel);

        } else {
            JOptionPane.showMessageDialog(null, "seleccione un pedido");
        }
    }

    public void RegistrarItem() {

        controladorOrder = new OrderController();
        int resp = 0;
        int idUsuario = Integer.parseInt(idUserEnt.getText());

        int id_orden = controladorPedido.select(new Pedido(idUsuario));

//        int id = controladorIng.select(new Ingreso(idUsuario));
        for (int i = 0; i < tablePedido.getRowCount(); i++) {

            int idPizza = Integer.parseInt(tablePedido.getValueAt(i, 0).toString());
            double cantidad = Double.parseDouble(tablePedido.getValueAt(i, 2).toString());
            double precio = Double.parseDouble(tablePedido.getValueAt(i, 3).toString());
            resp = controladorOrder.insert(new Order_item(id_orden, idPizza, cantidad, precio));

//            resp = controladorIngPer.insert(new IngPertenecia(id, serial));
            if (resp == 0) {
                JOptionPane.showMessageDialog(null, "Error al insertar las pertenencias");
            } else {
                JOptionPane.showMessageDialog(null, "pertenencias agregadas");
            }

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        UsuarioTxtlg = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        CMBPizza = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        CMBMerhod = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNotta = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablePedido = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TablePe = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableDe = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        idPedido = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        BTNAgre = new javax.swing.JButton();
        BTNEdit = new javax.swing.JButton();
        BTNElim = new javax.swing.JButton();
        BTNCan = new javax.swing.JButton();
        txtNomPiz = new javax.swing.JTextField();
        txtDescPiz = new javax.swing.JTextField();
        txtPrecPiz = new javax.swing.JTextField();
        CMBveget = new javax.swing.JComboBox<>();
        CMBVegan = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDatosPizz = new javax.swing.JTable();
        idPizza = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtCant = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePed = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableDet = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        idPed = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        idUserEnt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Bienvenido ");

        UsuarioTxtlg.setText("jLabel2");

        CMBPizza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CMBPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMBPizzaActionPerformed(evt);
            }
        });

        jLabel2.setText("Pizza");

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        jButton5.setText("Agregar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Pedir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel11.setText("metodo");

        CMBMerhod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Paypal", "Nequi", " " }));

        jLabel12.setText("Nota Adicional");

        txtNotta.setColumns(20);
        txtNotta.setRows(5);
        jScrollPane3.setViewportView(txtNotta);

        tablePedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tablePedido);
        if (tablePedido.getColumnModel().getColumnCount() > 0) {
            tablePedido.getColumnModel().getColumn(0).setHeaderValue("Title 1");
            tablePedido.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            tablePedido.getColumnModel().getColumn(2).setHeaderValue("Title 3");
            tablePedido.getColumnModel().getColumn(3).setHeaderValue("Title 4");
        }

        jLabel3.setText("cantidad");

        TablePe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablePe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePeMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(TablePe);

        tableDe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tableDe);

        jButton8.setText("Cancelar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CMBPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(jButton5))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton6)
                            .addComponent(CMBMerhod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jButton8))
                    .addComponent(idPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CMBPizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(idPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(CMBMerhod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(63, 63, 63)
                                        .addComponent(jButton6))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(jButton8)
                        .addGap(131, 131, 131))))
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        jLabel4.setText("Pizza");

        jLabel5.setText("nombre");

        jLabel6.setText("Descripcion");

        jLabel7.setText("Precio");

        jLabel8.setText("vegetarian");

        jLabel9.setText("vegan");

        jLabel10.setText("available");

        BTNAgre.setText("Agregar");
        BTNAgre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNAgreActionPerformed(evt);
            }
        });

        BTNEdit.setText("Editar");
        BTNEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNEditActionPerformed(evt);
            }
        });

        BTNElim.setText("Eliminar");
        BTNElim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNElimActionPerformed(evt);
            }
        });

        BTNCan.setText("Cancelar");

        CMBveget.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "t", "f" }));
        CMBveget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMBvegetActionPerformed(evt);
            }
        });

        CMBVegan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "t", "f" }));
        CMBVegan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMBVeganActionPerformed(evt);
            }
        });

        tablaDatosPizz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaDatosPizz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDatosPizzMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaDatosPizz);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jLabel13.setText("Cantidad");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(36, 36, 36)
                                .addComponent(idPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(BTNAgre)
                                .addGap(25, 25, 25)
                                .addComponent(BTNEdit))
                            .addComponent(CMBVegan, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel13)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtCant, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(CMBveget, javax.swing.GroupLayout.Alignment.LEADING, 0, 147, Short.MAX_VALUE)
                                .addComponent(txtPrecPiz, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDescPiz, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNomPiz, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(4, 4, 4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BTNElim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTNCan)))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(idPizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomPiz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescPiz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecPiz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(CMBveget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(CMBVegan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNEdit)
                    .addComponent(BTNAgre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNElim)
                    .addComponent(BTNCan))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        tablePed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablePed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePedMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePed);

        tableDet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tableDet);

        jButton7.setText("En proceso");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setText("Enviado");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Cancelado");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idPed))
                .addContainerGap(473, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(idPed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9)
                        .addGap(18, 18, 18)
                        .addComponent(jButton10)))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", jPanel3);

        jButton1.setText("Pedido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("CrudPizza");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Administrador");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        idUserEnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idUserEntActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(UsuarioTxtlg)
                .addGap(18, 18, 18)
                .addComponent(idUserEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jTabbedPane1)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(UsuarioTxtlg)
                    .addComponent(idUserEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(74, 74, 74))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void CMBvegetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMBvegetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CMBvegetActionPerformed

    private void BTNAgreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNAgreActionPerformed
        // TODO add your handling code here:
        controladorPizza = new PizzaController();
        int resp = 0;
        double precio;
        String nombre = txtNomPiz.getText();
        String desc = txtDescPiz.getText();
        if (txtPrecPiz.getText().equals("")) {
            precio = 0.0;
        } else {
            precio = Double.parseDouble(txtPrecPiz.getText());
        }
        int cantidad = Integer.parseInt(txtCant.getText());

        String vegetarian = (String) CMBveget.getSelectedItem();
        String vegan = (String) CMBVegan.getSelectedItem();
        String available = (String) CMBAvail.getSelectedItem();

        if (nombre.equals("") || desc.equals("") || precio == 0.0 || cantidad == 0) {
            JOptionPane.showMessageDialog(null, "campos vacios");
        } else {
            JOptionPane.showMessageDialog(null, "Procesando Registro...");

            resp = controladorPizza.insert(new Pizza(nombre, desc, precio, cantidad, vegetarian, vegan, available));
            if (resp == 0) {
                JOptionPane.showMessageDialog(null, "Error al insertar datos");
            } else {
                Object[][] content = controladorPizza.loadDataforTableModel();
                tableModel = new DefaultTableModel(content, header);
                tablaDatosPizz.setModel(tableModel);
            }
        }
    }//GEN-LAST:event_BTNAgreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        jTabbedPane1.setSelectedIndex(0);
        CMBPizza.removeAllItems();
        pedido();
        tablaPedidos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
        this.controladorPizza = new PizzaController();
        Object[][] content = controladorPizza.loadDataforTableModel();
        tableModel = new DefaultTableModel(content, header);
        tablaDatosPizz.setModel(tableModel);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);

        this.controladorPedido = new PedidoController();
        Object[][] content = controladorPedido.loadDataforTableModel();
        tableModel = new DefaultTableModel(content, header3);
        tablePed.setModel(tableModel);
        //tablaPedidos();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void tablaDatosPizzMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDatosPizzMouseClicked
        // TODO add your handling code here:

        // TODO add your handling code here:
        int seleccionar = tablaDatosPizz.rowAtPoint(evt.getPoint());
        idPizza.setText(String.valueOf(tablaDatosPizz.getValueAt(seleccionar, 0)));

        txtNomPiz.setText(String.valueOf(tablaDatosPizz.getValueAt(seleccionar, 1)));
        txtDescPiz.setText(String.valueOf(tablaDatosPizz.getValueAt(seleccionar, 2)));
        txtPrecPiz.setText(String.valueOf(tablaDatosPizz.getValueAt(seleccionar, 3)));
        txtCant.setText(String.valueOf(tablaDatosPizz.getValueAt(seleccionar, 4)));
        CMBveget.setSelectedIndex((Integer) tablaDatosPizz.getValueAt(seleccionar, 5));
        CMBVegan.setSelectedIndex((Integer) tablaDatosPizz.getValueAt(seleccionar, 6));
        CMBAvail.setSelectedIndex((Integer) tablaDatosPizz.getValueAt(seleccionar, 7));

        BTNAgre.setEnabled(false);
        BTNEdit.setEnabled(true);
        BTNElim.setEnabled(true);
        BTNCan.setEnabled(true);

    }//GEN-LAST:event_tablaDatosPizzMouseClicked

    private void BTNEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEditActionPerformed
        // TODO add your handling code here:

        // TODO add your handling code here:
        controladorPizza = new PizzaController();
        int resp = 0;
        double precio;
        String nombre = txtNomPiz.getText();
        String desc = txtDescPiz.getText();
        if (txtPrecPiz.getText().equals("")) {
            precio = 0.0;
        } else {
            precio = Double.parseDouble(txtPrecPiz.getText());
        }
        int cantidad = Integer.parseInt(txtCant.getText());

        String vegetarian = (String) CMBveget.getSelectedItem();
        String vegan = (String) CMBVegan.getSelectedItem();
        String available = (String) CMBAvail.getSelectedItem();
        int id_Pizza = Integer.parseInt(this.idPizza.getText());

        if (nombre.equals("") || desc.equals("") || precio == 0.0 || cantidad == 0) {
            JOptionPane.showMessageDialog(null, "campos vacios");
        } else {
            JOptionPane.showMessageDialog(null, "Procesando Registro...");

            resp = controladorPizza.edit(new Pizza(id_Pizza, nombre, desc, precio, cantidad, vegetarian, vegan, available));
            if (resp == 0) {
                JOptionPane.showMessageDialog(null, "Error al insertar datos");
            } else {
                Object[][] content = controladorPizza.loadDataforTableModel();
                tableModel = new DefaultTableModel(content, header);
                tablaDatosPizz.setModel(tableModel);
            }
        }
    }//GEN-LAST:event_BTNEditActionPerformed

    private void BTNElimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNElimActionPerformed
        // TODO add your handling code here
        // TODO add your handling code here:

        // TODO add your handling code here:
        controladorPizza = new PizzaController();
        int resp = 0;
        int id_Pizza = Integer.parseInt(this.idPizza.getText());

        resp = controladorPizza.delete(new Pizza(id_Pizza));
        if (resp == 0) {
            JOptionPane.showMessageDialog(null, "Error al eliminar datos");
        } else {
            Object[][] content = controladorPizza.loadDataforTableModel();
            tableModel = new DefaultTableModel(content, header);
            tablaDatosPizz.setModel(tableModel);
        }

    }//GEN-LAST:event_BTNElimActionPerformed

    private void CMBPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMBPizzaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CMBPizzaActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        controladorPizza = new PizzaController();
        String ingreso = CMBPizza.getSelectedItem().toString();
        String[] Parts = ingreso.split("-");
//        int idUser = Integer.parseInt(idUserEnt.getText());
        int part1 = Integer.parseInt(Parts[0]);
        String part2 = Parts[1];
        double part3 = Double.parseDouble(Parts[2]);
        int Cantidad = Integer.parseInt(txtCantidad.getText());

//        if(part1==0 && part2.equals("") && Cantidad == 0){
//        JOptionPane.showInternalMessageDialog(null, "Error al ingresar pedido");
//        }else{
        pizzas = controladorPizza.agregarLista(new Pizza(part1, part2, part3, Cantidad));
        System.out.println("Tamaño de la lista: " + pizzas.size());

        res = controladorPizza.agregarListaV(pizzas);
//}
//        //        for (int i = TableIng.getRowCount() - 1; i >= 0; i--) {
        //            TableIng.remove(i);
        //        }
        tableModel = new DefaultTableModel(res, header2);
        tablePedido.setModel(tableModel);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:

        RegistrarPedido();
        RegistrarItem();
        tablaPedidos();

    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void idUserEntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idUserEntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idUserEntActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        controladorPedido = new PedidoController();
        int resp = 0;
        double precio;
        int id = Integer.parseInt(idPed.getText());
        String Estado = "Cancelado";

        if (id < 1) {
            JOptionPane.showMessageDialog(null, "campos vacios");
        } else {
            JOptionPane.showMessageDialog(null, "Procesando Registro...");

            resp = controladorPedido.edit(new Pedido(id, Estado));
            if (resp == 0) {
                JOptionPane.showMessageDialog(null, "Error al insertar datos");
            } else {
                Object[][] content = controladorPedido.loadDataforTableModel();
                tableModel = new DefaultTableModel(content, header3);
                tablePed.setModel(tableModel);
            }
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void tablePedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePedMouseClicked
        // TODO add your handling code here:
        int seleccionar = tablePed.rowAtPoint(evt.getPoint());
        idPed.setText(String.valueOf(tablePed.getValueAt(seleccionar, 0)));
        MostrarPro();

    }//GEN-LAST:event_tablePedMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:

        // TODO add your handling code here:
        controladorPedido = new PedidoController();
        int resp = 0;
        double precio;
        int id = Integer.parseInt(idPed.getText());
        String Estado = "En Proceso";

        if (id < 1) {
            JOptionPane.showMessageDialog(null, "campos vacios");
        } else {
            JOptionPane.showMessageDialog(null, "Procesando Registro...");

            resp = controladorPedido.edit(new Pedido(id, Estado));
            if (resp == 0) {
                JOptionPane.showMessageDialog(null, "Error al insertar datos");
            } else {
                Object[][] content = controladorPedido.loadDataforTableModel();
                tableModel = new DefaultTableModel(content, header3);
                tablePed.setModel(tableModel);
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        controladorPedido = new PedidoController();
        int resp = 0;
        double precio;
        int id = Integer.parseInt(idPed.getText());
        String Estado = "Enviado";

        if (id < 1) {
            JOptionPane.showMessageDialog(null, "campos vacios");
        } else {
            JOptionPane.showMessageDialog(null, "Procesando Registro...");

            resp = controladorPedido.edit(new Pedido(id, Estado));
            if (resp == 0) {
                JOptionPane.showMessageDialog(null, "Error al insertar datos");
            } else {
                Object[][] content = controladorPedido.loadDataforTableModel();
                tableModel = new DefaultTableModel(content, header3);
                tablePed.setModel(tableModel);
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void TablePeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePeMouseClicked
        // TODO add your handling code here:

        int seleccionar = TablePe.rowAtPoint(evt.getPoint());
        idPedido.setText(String.valueOf(TablePe.getValueAt(seleccionar, 0)));

        MostrarProductos();

    }//GEN-LAST:event_TablePeMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        controladorPedido = new PedidoController();
        int resp = 0;

        int id = Integer.parseInt(idPedido.getText());
        String Estado = "Cancelado";

        if (id < 1) {
            JOptionPane.showMessageDialog(null, "campos vacios");
        } else {
            JOptionPane.showMessageDialog(null, "Procesando Registro...");

            resp = controladorPedido.edit(new Pedido(id, Estado));
            if (resp == 0) {
                JOptionPane.showMessageDialog(null, "Error al insertar datos");
            } else {
                Object[][] content = controladorPedido.loadDataforTableModel();
                tableModel = new DefaultTableModel(content, header3);
                TablePe.setModel(tableModel);
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void CMBVeganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMBVeganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CMBVeganActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(SistemaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SistemaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SistemaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SistemaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SistemaView().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNAgre;
    private javax.swing.JButton BTNCan;
    private javax.swing.JButton BTNEdit;
    private javax.swing.JButton BTNElim;
    private javax.swing.JComboBox<String> CMBMerhod;
    private javax.swing.JComboBox<String> CMBPizza;
    private javax.swing.JComboBox<String> CMBVegan;
    private javax.swing.JComboBox<String> CMBveget;
    private javax.swing.JTable TablePe;
    private javax.swing.JLabel UsuarioTxtlg;
    private javax.swing.JTextField idPed;
    private javax.swing.JTextField idPedido;
    private javax.swing.JTextField idPizza;
    private javax.swing.JTextField idUserEnt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaDatosPizz;
    private javax.swing.JTable tableDe;
    private javax.swing.JTable tableDet;
    private javax.swing.JTable tablePed;
    private javax.swing.JTable tablePedido;
    private javax.swing.JTextField txtCant;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescPiz;
    private javax.swing.JTextField txtNomPiz;
    private javax.swing.JTextArea txtNotta;
    private javax.swing.JTextField txtPrecPiz;
    // End of variables declaration//GEN-END:variables
}
