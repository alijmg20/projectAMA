
package views;

import model.MProveedores;
import javax.swing.JOptionPane;
import Controler.Conexion;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import views.MainMenu;
import javax.swing.JOptionPane;
import views.MainMenu;


public class VProveedores extends javax.swing.JFrame {

    private final Conexion conexion = new Conexion();
    private final MProveedores prov = new MProveedores(conexion.conectar());
    
    //Atributos de la clase2222
    private int tipo;
    private String username;
    DefaultListModel<String> model = new DefaultListModel<>();

    public VProveedores() {       
        initComponents();

         this.tableProveedores.setModel(prov.mostrarDatosProveedor()); 
    }
    
    //sobrecarga del constructor principal
    public VProveedores(int tipo, String username) {
        initComponents();
        this.tipo = tipo;
        this.username = username;
        prov.obtenerLinea(LineaSuminist1);
        prov.obtenerLinea(LineaSuminist2);
        prov.obtenerLinea(LineaSuminist3);
      this.tableProveedores.setModel(prov.mostrarDatosProveedor()); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        JpaneUnidades = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        FieldRIF = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        FieldRS = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        FieldDirec = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        FieldMail1 = new javax.swing.JTextField();
        FieldMail2 = new javax.swing.JTextField();
        FieldMail3 = new javax.swing.JTextField();
        MasMail = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        FieldTlf1 = new javax.swing.JTextField();
        FieldTlf2 = new javax.swing.JTextField();
        FieldTlf3 = new javax.swing.JTextField();
        MasTlf = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        LineaSuminist1 = new javax.swing.JComboBox<String>();
        LineaSuminist2 = new javax.swing.JComboBox<String>();
        LineaSuminist3 = new javax.swing.JComboBox<String>();
        jPanel6 = new javax.swing.JPanel();
        Guardar = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        LimpiarTodo = new javax.swing.JButton();
        Nuevo = new javax.swing.JButton();
        VerInfo = new javax.swing.JButton();
        btnVolver1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProveedores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setAutoscrolls(true);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(500, 720));

        jPanel11.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Proveedores");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jLabel1)
                .addContainerGap(176, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(153, 153, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Informacion Proveedor"));

        FieldRIF.setEnabled(false);
        FieldRIF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldRIFActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("RIF:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("RAZÓN SOCIAL:");

        FieldRS.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("DIRECCION:");

        FieldDirec.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("E-MAIL:");

        FieldMail1.setEnabled(false);

        FieldMail2.setEnabled(false);

        FieldMail3.setEnabled(false);

        MasMail.setText("+");
        MasMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MasMailActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("TELEFONO:");

        FieldTlf1.setEnabled(false);

        FieldTlf2.setEnabled(false);
        FieldTlf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldTlf2ActionPerformed(evt);
            }
        });

        FieldTlf3.setEnabled(false);

        MasTlf.setText("+");
        MasTlf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MasTlfActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("LINEA DE SUMINISTRO:");

        LineaSuminist1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LineaSuminist1ActionPerformed(evt);
            }
        });

        LineaSuminist2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LineaSuminist2ActionPerformed(evt);
            }
        });

        LineaSuminist3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LineaSuminist3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FieldRIF, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FieldRS, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FieldDirec, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(72, 72, 72)
                        .addComponent(MasMail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FieldMail1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addGap(72, 72, 72)
                        .addComponent(MasTlf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FieldTlf1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LineaSuminist3, javax.swing.GroupLayout.Alignment.TRAILING, 0, 245, Short.MAX_VALUE)
                            .addComponent(LineaSuminist2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FieldMail2)
                            .addComponent(FieldMail3)
                            .addComponent(FieldTlf2)
                            .addComponent(FieldTlf3)
                            .addComponent(LineaSuminist1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FieldRIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FieldRS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FieldDirec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FieldMail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MasMail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FieldMail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FieldMail3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FieldTlf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MasTlf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FieldTlf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FieldTlf3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LineaSuminist1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LineaSuminist2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LineaSuminist3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(153, 153, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Opciones: "));

        Guardar.setText("GUARDAR");
        Guardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        Actualizar.setText("ACTUALIZAR");
        Actualizar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        Eliminar.setText("ELIMINAR");
        Eliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        LimpiarTodo.setText("LIMPIAR TODO");
        LimpiarTodo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LimpiarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarTodoActionPerformed(evt);
            }
        });

        Nuevo.setText("NUEVO");
        Nuevo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });

        VerInfo.setText("VER + INFO");
        VerInfo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        VerInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VerInfoMouseClicked(evt);
            }
        });
        VerInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LimpiarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LimpiarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btnVolver1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/designs/Volver.png"))); // NOI18N
        btnVolver1.setContentAreaFilled(false);
        btnVolver1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVolver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolver1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        tableProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProveedoresMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableProveedores);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 50, Short.MAX_VALUE))
        );

        JpaneUnidades.setViewportView(jPanel4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpaneUnidades, javax.swing.GroupLayout.DEFAULT_SIZE, 1181, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpaneUnidades, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 
    private void FieldMail2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldMail2ActionPerformed
        // TODO add your handling code here:
       // FieldMail2.setVisible(true);
    }//GEN-LAST:event_FieldMail2ActionPerformed

    private void FieldMail3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldMail3ActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_FieldMail3ActionPerformed

    private void FieldTlf3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldTlf3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldTlf3ActionPerformed

    private void LineaSumiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void tableProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProveedoresMouseClicked
        //Copiado de VUnidades.
        this.FieldRIF.disable();
        this.FieldRS.enable();
        this.FieldDirec.enable();
        this.FieldMail1.enable();
        this.FieldMail2.enable();
        this.FieldMail3.enable();
        this.FieldTlf1.enable();
        this.FieldTlf2.enable();
        this.FieldTlf3.enable(); 
        this.FieldMail1.enable(); 
        this.FieldMail2.enable(); 
        this.FieldMail3.enable(); 
        int filaSeleccionada = this.tableProveedores.rowAtPoint(evt.getPoint());
        this.FieldRIF.setText(this.tableProveedores.getValueAt(filaSeleccionada, 0).toString());
        this.FieldRS.setText(this.tableProveedores.getValueAt(filaSeleccionada, 1).toString());
        this.FieldDirec.setText(this.tableProveedores.getValueAt(filaSeleccionada, 2).toString());
        int[] data= new int[5];
        data= prov.datalineas(Integer.parseInt(this.FieldRIF.getText()));
        LineaSuminist1.setSelectedIndex(data[0]);
        LineaSuminist2.setSelectedIndex(data[1]);
        LineaSuminist3.setSelectedIndex(data[2]);
        String [] telefonos= new String [3];
        telefonos=prov.datatlf(Integer.parseInt(this.FieldRIF.getText()));
        FieldTlf1.setText(telefonos[0]);
        FieldTlf2.setText(telefonos[1]);
        FieldTlf3.setText(telefonos[2]);
        String [] correos = new String [3];
        correos=prov.dataemail(Integer.parseInt(this.FieldRIF.getText()));
        FieldMail1.setText(correos[0]);
        FieldMail2.setText(correos[1]);
        FieldMail3.setText(correos[2]);
    }//GEN-LAST:event_tableProveedoresMouseClicked

    private void btnVolver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolver1ActionPerformed
        new MainMenu(2,"Admin").setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolver1ActionPerformed

    private void VerInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VerInfoActionPerformed

    private void VerInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VerInfoMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Los datos del poveedor son\nRif: "+FieldRIF.getText()+"\n\n***Correo(s)*** "+
            prov.arreglocorreo(Integer.parseInt(this.FieldRIF.getText()))+"\n\n***Telefono(s)*** "+
            prov.arreglotlf(Integer.parseInt(this.FieldRIF.getText()))+"\n\n***Linea(s) a la(s) que suministran productos*** "+
            prov.arreglolineas(Integer.parseInt(this.FieldRIF.getText())));
    }//GEN-LAST:event_VerInfoMouseClicked

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed

        this.FieldRIF.enable();
        this.FieldRS.enable();
        this.FieldDirec.enable();
        this.FieldMail1.enable();
        this.FieldTlf1.enable();
        this.LineaSuminist1.enable();
    }//GEN-LAST:event_NuevoActionPerformed

    private void LimpiarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarTodoActionPerformed

        this.FieldRIF.setText("");
        this.FieldRS.setText("");
        this.FieldDirec.setText("");
        this.FieldMail1.setText("");
        this.FieldMail2.setText("");
        this.FieldMail3.setText("");
        this.FieldTlf1.setText("");
        this.FieldTlf2.setText("");
        this.FieldTlf3.setText("");
    }//GEN-LAST:event_LimpiarTodoActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int filaSeleccionada = this.tableProveedores.getSelectedRow();
        // prov.eliminarDatosProveedores(Integer.parseInt(this.FieldRIF.getText(filaSeleccionada,0)));
        int decision = JOptionPane.showConfirmDialog(null, "Seguro que desea elimimnar el Proveedor? ");
        if (decision == 0) {
            this.prov.eliminarDatosProveedores(Integer.parseInt(this.tableProveedores.getValueAt(filaSeleccionada, 0).toString()));
            this.tableProveedores.setModel(prov.mostrarDatosProveedor());
            }
            
    }//GEN-LAST:event_EliminarActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
                if (!(this.FieldRIF.getText().equals("")) && !(this.FieldRS.getText().equals("")) && !(this.FieldDirec.getText().equals(""))) {
            //Se toman los valores de los fields para convertirlos en datos para el campo:
            
            int RIF = Integer.parseInt(this.FieldRIF.getText());
            String RS = this.FieldRS.getText();
            String DIREC = this.FieldDirec.getText();    
            String MAIL1 = this.FieldMail1.getText();
            String MAIL2 = this.FieldMail2.getText();
            String MAIL3 = this.FieldMail3.getText();
            String TLF1 = this.FieldTlf1.getText();
            String TLF2 = this.FieldTlf2.getText();
            String TLF3 = this.FieldTlf3.getText();
            String CODL1 = this.LineaSuminist1.getSelectedItem().toString();
            String CODL2 = this.LineaSuminist2.getSelectedItem().toString();
            String CODL3 = this.LineaSuminist3.getSelectedItem().toString();
            

            int decision = JOptionPane.showConfirmDialog(null, "seguro que Desea Actualizar la Linea de Suministros ? ");
            if (decision == 0) { //Caso que se acepte.
                //Se actualizan los datos: (Funcion no creada aun)
                
                prov.actualizarDatosProveedores(RIF, RS, DIREC);
                prov.actualizarDatosCorreos(RIF,MAIL1);
                prov.actualizarDatosCorreos(RIF,MAIL2);
                prov.actualizarDatosCorreos(RIF,MAIL3);
                prov.actualizarDatosTelefonos(RIF, TLF1);
                prov.actualizarDatosTelefonos(RIF, TLF2);
                prov.actualizarDatosTelefonos(RIF, TLF3);
                prov.actualizarDatosLineas(RIF, CODL1);
                prov.actualizarDatosLineas(RIF, CODL1);
                prov.actualizarDatosLineas(RIF, CODL1);
                //Se vuelve a mostrar la tabla actualizada:
                
                this.tableProveedores.setModel(prov.mostrarDatosProveedor());
            }
        }else {
            JOptionPane.showMessageDialog(null, "Por favor rellene los campos faltantes", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_ActualizarActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        if (!(this.FieldRIF.getText().equals("")) && !(this.FieldRS.getText().equals("")) && !(this.FieldDirec.getText().equals("")) && !(this.LineaSuminist1.getSelectedItem().toString().equals("")) && !(this.LineaSuminist2.getSelectedItem().toString().equals("")) && !(this.LineaSuminist3.getSelectedItem().toString().equals(""))) {
            //Se toman los valores de los fields para convertirlos en datos para el campo:
            int RIF = Integer.parseInt(this.FieldRIF.getText());
            String RS = this.FieldRS.getText();
            String DIREC = this.FieldDirec.getText();
            String MAIL1 = this.FieldMail1.getText();
            String MAIL2 = this.FieldMail2.getText();
            String MAIL3 = this.FieldMail3.getText();
            String TLF1 = this.FieldTlf1.getText();
            String TLF2 = this.FieldTlf2.getText();
            String TLF3 = this.FieldTlf3.getText();
            String CODL1 = this.LineaSuminist1.getSelectedItem().toString();
            String CODL2 = this.LineaSuminist2.getSelectedItem().toString();
            String CODL3 = this.LineaSuminist3.getSelectedItem().toString();
            prov.insertarDatosProveedores(RIF, RS, DIREC, 'A');
            
            if(!(this.FieldMail1.getText().equals(""))){
               prov.insertarDatosCORREOS(RIF, MAIL1);
               } 
            if(!(this.FieldMail2.getText().equals(""))){
                prov.insertarDatosCORREOS(RIF, MAIL2);
            }
            if(!(this.FieldMail3.getText().equals(""))){
                prov.insertarDatosCORREOS(RIF, MAIL3);
                }
            if(!(this.FieldTlf1.getText().equals(""))){
                prov.insertarDatosTelefonos(RIF, TLF1);
                }
            if(!(this.FieldTlf2.getText().equals(""))){
             prov.insertarDatosTelefonos(RIF, TLF2);
            }
            if(!(this.FieldTlf3.getText().equals(""))){
            prov.insertarDatosTelefonos(RIF, TLF3);
            }
            if(!(this.LineaSuminist1.getSelectedItem().toString().equals(""))){
            prov.insertarDatossuministran(RIF,CODL1);
            }
            
            if(!(this.LineaSuminist2.getSelectedItem().toString().equals(""))){
            prov.insertarDatossuministran(RIF,CODL2);
                 }       
            if(!(this.LineaSuminist3.getSelectedItem().toString().equals(""))){
            prov.insertarDatossuministran(RIF,CODL3);
            }
            //Se insertan la fila nueva en la bd: (Funcion no hecha aun)
            //lineas.insertarDatosLineas(codlineas, descripcionl);

            //Se colocan los cambios deshabilitados de nuevo
            this.FieldRIF.disable();
            this.FieldRS.disable();
            this.FieldDirec.disable();
            this.FieldMail1.disable();
            this.FieldMail2.disable();
            this.FieldMail3.disable();
            this.FieldTlf1.disable();
            this.FieldTlf2.disable();
            this.FieldTlf3.disable();

            //Se vuelve a mostrar la tabla actualizada: (Funcion no hecha aun)
            //this.tableLineas.setModel(lineas.mostrarDatosLineas());

           
            this.FieldRIF.setText("");
            this.FieldRS.setText("");
            this.FieldDirec.setText("");

        } else {
            JOptionPane.showMessageDialog(null, "Por favor rellene los campos faltantes", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        
        this.tableProveedores.setModel(prov.mostrarDatosProveedor());
    }//GEN-LAST:event_GuardarActionPerformed

    private void LineaSuminist3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LineaSuminist3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LineaSuminist3ActionPerformed

    private void LineaSuminist2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LineaSuminist2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LineaSuminist2ActionPerformed

    private void LineaSuminist1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LineaSuminist1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LineaSuminist1ActionPerformed

    private void MasTlfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MasTlfActionPerformed
        if (this.FieldTlf2.isEnabled()==false && !(this.FieldTlf1.getText().equals(""))){
            FieldTlf2.setVisible(true);
            this.FieldTlf2.enable();
        }

        if (this.FieldTlf3.isEnabled()==false && !(this.FieldTlf2.getText().equals(""))){
            FieldTlf3.setVisible(true);
            this.FieldTlf3.enable();
        }
    }//GEN-LAST:event_MasTlfActionPerformed

    private void FieldTlf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldTlf2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldTlf2ActionPerformed

    private void MasMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MasMailActionPerformed
        if (this.FieldMail2.isEnabled()==false && !(this.FieldMail1.getText().equals(""))){
            this.FieldMail2.enable();
            FieldMail2.setVisible(true);
        }
        if (this.FieldMail3.isEnabled()==false && !(this.FieldMail2.getText().equals(""))){
            this.FieldMail3.enable();
            FieldMail3.setVisible(true);
        }

    }//GEN-LAST:event_MasMailActionPerformed

    private void FieldRIFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldRIFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldRIFActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VProveedores().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JTextField FieldDirec;
    private javax.swing.JTextField FieldMail1;
    private javax.swing.JTextField FieldMail2;
    private javax.swing.JTextField FieldMail3;
    private javax.swing.JTextField FieldRIF;
    private javax.swing.JTextField FieldRS;
    private javax.swing.JTextField FieldTlf1;
    private javax.swing.JTextField FieldTlf2;
    private javax.swing.JTextField FieldTlf3;
    private javax.swing.JButton Guardar;
    public static javax.swing.JScrollPane JpaneUnidades;
    private javax.swing.JButton LimpiarTodo;
    private javax.swing.JComboBox<String> LineaSuminist1;
    private javax.swing.JComboBox<String> LineaSuminist2;
    private javax.swing.JComboBox<String> LineaSuminist3;
    private javax.swing.JButton MasMail;
    private javax.swing.JButton MasTlf;
    private javax.swing.JButton Nuevo;
    private javax.swing.JButton VerInfo;
    private javax.swing.JButton btnVolver1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableProveedores;
    // End of variables declaration//GEN-END:variables
}
