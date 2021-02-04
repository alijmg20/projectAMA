package views;

public class MainMenu extends javax.swing.JFrame {

    private int tipo;
    private String username;

    public MainMenu() {
        initComponents();
    }

    public MainMenu(int tipo, String username) {
        initComponents();
        this.tipo = tipo;
        this.username = username;
        this.jLabel3.setText("Bienvenido al sistema AMA " + username);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        PanelUnidades = new javax.swing.JButton();
        PanelLineas = new javax.swing.JButton();
        PanelItems = new javax.swing.JButton();
        PanelProveedores = new javax.swing.JButton();
        PanelJefe = new javax.swing.JButton();
        PanelDirectores = new javax.swing.JButton();
        PanelRequisiciones = new javax.swing.JButton();
        PanelCotizaciones = new javax.swing.JButton();
        PanelOrdenes = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btn_unidades = new javax.swing.JButton();
        lbUnidades = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btn_Lineas = new javax.swing.JButton();
        lbUnidades1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btn_items = new javax.swing.JButton();
        lbUnidades2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btn_Orden = new javax.swing.JButton();
        lbUnidades3 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        btn_proveedores = new javax.swing.JButton();
        lbUnidades10 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        btn_jefes_unidad = new javax.swing.JButton();
        lbUnidades11 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        btn_directores = new javax.swing.JButton();
        lbUnidades12 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        btn_requisicion = new javax.swing.JButton();
        lbUnidades13 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        btn_cotizaciones = new javax.swing.JButton();
        lbUnidades15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setResizable(false);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Bienvenido al sistema AMA username");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(43, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 137, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        jPanel6.setBackground(new java.awt.Color(153, 153, 255));

        btnSalir.setBackground(new java.awt.Color(153, 153, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/designs/Cerrar_Sesion.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setContentAreaFilled(false);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSalir))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/designs/P_control.png"))); // NOI18N
        jLabel1.setText("Panel de Control");

        jPanel10.setBackground(new java.awt.Color(153, 153, 255));

        PanelUnidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/designs/IUnidad.png"))); // NOI18N
        PanelUnidades.setText("UNIDADES");
        PanelUnidades.setContentAreaFilled(false);
        PanelUnidades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PanelUnidadesActionPerformed(evt);
            }
        });

        PanelLineas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/designs/ILinea.png"))); // NOI18N
        PanelLineas.setText("LINEA DE SUMINISTROS");
        PanelLineas.setContentAreaFilled(false);
        PanelLineas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelLineas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PanelLineasActionPerformed(evt);
            }
        });

        PanelItems.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/designs/IItem.png"))); // NOI18N
        PanelItems.setText("ITEMS");
        PanelItems.setContentAreaFilled(false);
        PanelItems.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PanelItemsActionPerformed(evt);
            }
        });

        PanelProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/designs/IProveedor.png"))); // NOI18N
        PanelProveedores.setText("PROVEEDORES");
        PanelProveedores.setContentAreaFilled(false);
        PanelProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PanelProveedoresActionPerformed(evt);
            }
        });

        PanelJefe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/designs/IJefe.png"))); // NOI18N
        PanelJefe.setText("JEDES DE UNIDAD");
        PanelJefe.setContentAreaFilled(false);
        PanelJefe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelJefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PanelJefeActionPerformed(evt);
            }
        });

        PanelDirectores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/designs/IDirector.png"))); // NOI18N
        PanelDirectores.setText("DIRECTORES");
        PanelDirectores.setContentAreaFilled(false);
        PanelDirectores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelDirectores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PanelDirectoresActionPerformed(evt);
            }
        });

        PanelRequisiciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/designs/IRequisicion.png"))); // NOI18N
        PanelRequisiciones.setText("REQUISICIONES");
        PanelRequisiciones.setContentAreaFilled(false);
        PanelRequisiciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelRequisiciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PanelRequisicionesActionPerformed(evt);
            }
        });

        PanelCotizaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/designs/ICotizacion.png"))); // NOI18N
        PanelCotizaciones.setText("COTIZACIONES");
        PanelCotizaciones.setContentAreaFilled(false);
        PanelCotizaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelCotizaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PanelCotizacionesActionPerformed(evt);
            }
        });

        PanelOrdenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/designs/IOrden.png"))); // NOI18N
        PanelOrdenes.setText("ORDEN DE COMPRA");
        PanelOrdenes.setContentAreaFilled(false);
        PanelOrdenes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelOrdenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PanelOrdenesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelUnidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelLineas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelJefe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelDirectores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelRequisiciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelCotizaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelOrdenes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(PanelUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelLineas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelItems, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelJefe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelDirectores, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelRequisiciones, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelCotizaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        btn_unidades.setBackground(new java.awt.Color(255, 255, 255));
        btn_unidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/designs/unidades.png"))); // NOI18N
        btn_unidades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_unidades.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_unidades.setIconTextGap(6);
        btn_unidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_unidadesActionPerformed(evt);
            }
        });

        lbUnidades.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbUnidades.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUnidades.setText("Unidades");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbUnidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btn_unidades, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_unidades, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));

        btn_Lineas.setBackground(new java.awt.Color(255, 255, 255));
        btn_Lineas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/designs/Linea.png"))); // NOI18N
        btn_Lineas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Lineas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Lineas.setIconTextGap(6);
        btn_Lineas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LineasActionPerformed(evt);
            }
        });

        lbUnidades1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbUnidades1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUnidades1.setText("Lineas de Suministros");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbUnidades1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btn_Lineas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbUnidades1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Lineas, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jPanel8.setBackground(new java.awt.Color(204, 204, 255));

        btn_items.setBackground(new java.awt.Color(255, 255, 255));
        btn_items.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/designs/Item.png"))); // NOI18N
        btn_items.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_items.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_items.setIconTextGap(6);
        btn_items.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_itemsActionPerformed(evt);
            }
        });

        lbUnidades2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbUnidades2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUnidades2.setText("Items");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbUnidades2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btn_items, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbUnidades2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_items, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jPanel9.setBackground(new java.awt.Color(204, 204, 255));

        btn_Orden.setBackground(new java.awt.Color(255, 255, 255));
        btn_Orden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/designs/Orden.png"))); // NOI18N
        btn_Orden.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Orden.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Orden.setIconTextGap(6);
        btn_Orden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_OrdenActionPerformed(evt);
            }
        });

        lbUnidades3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbUnidades3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUnidades3.setText("Orden de Compra");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btn_Orden, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
            .addComponent(lbUnidades3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbUnidades3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Orden, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jPanel16.setBackground(new java.awt.Color(204, 204, 255));

        btn_proveedores.setBackground(new java.awt.Color(255, 255, 255));
        btn_proveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/designs/Proveedor.png"))); // NOI18N
        btn_proveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_proveedores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_proveedores.setIconTextGap(6);
        btn_proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_proveedoresActionPerformed(evt);
            }
        });

        lbUnidades10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbUnidades10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUnidades10.setText("Proveedores");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbUnidades10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbUnidades10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jPanel17.setBackground(new java.awt.Color(204, 204, 255));

        btn_jefes_unidad.setBackground(new java.awt.Color(255, 255, 255));
        btn_jefes_unidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/designs/Jefe.png"))); // NOI18N
        btn_jefes_unidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_jefes_unidad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_jefes_unidad.setIconTextGap(6);
        btn_jefes_unidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jefes_unidadActionPerformed(evt);
            }
        });

        lbUnidades11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbUnidades11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUnidades11.setText("Jefes de unidad");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbUnidades11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btn_jefes_unidad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbUnidades11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_jefes_unidad, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jPanel18.setBackground(new java.awt.Color(204, 204, 255));

        btn_directores.setBackground(new java.awt.Color(255, 255, 255));
        btn_directores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/designs/Director.png"))); // NOI18N
        btn_directores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_directores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_directores.setIconTextGap(6);
        btn_directores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_directoresActionPerformed(evt);
            }
        });

        lbUnidades12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbUnidades12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUnidades12.setText("Directores");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbUnidades12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(btn_directores, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbUnidades12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_directores, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jPanel19.setBackground(new java.awt.Color(204, 204, 255));

        btn_requisicion.setBackground(new java.awt.Color(255, 255, 255));
        btn_requisicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/designs/Requisicion.png"))); // NOI18N
        btn_requisicion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_requisicion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_requisicion.setIconTextGap(6);
        btn_requisicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_requisicionActionPerformed(evt);
            }
        });

        lbUnidades13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbUnidades13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUnidades13.setText("Requisiciones");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbUnidades13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btn_requisicion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbUnidades13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_requisicion, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jPanel21.setBackground(new java.awt.Color(204, 204, 255));

        btn_cotizaciones.setBackground(new java.awt.Color(255, 255, 255));
        btn_cotizaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/designs/Cotizacion.png"))); // NOI18N
        btn_cotizaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cotizaciones.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_cotizaciones.setIconTextGap(6);
        btn_cotizaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cotizacionesActionPerformed(evt);
            }
        });

        lbUnidades15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbUnidades15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUnidades15.setText("Cotizaciones");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbUnidades15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(btn_cotizaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbUnidades15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cotizaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        new Login(tipo).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void PanelUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PanelUnidadesActionPerformed
        this.dispose();
        new VUnidades(tipo,username).setVisible(true);
    }//GEN-LAST:event_PanelUnidadesActionPerformed

    private void PanelLineasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PanelLineasActionPerformed
        new VLineas(tipo, username).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PanelLineasActionPerformed

    private void PanelItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PanelItemsActionPerformed
        new VItems(tipo, username).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PanelItemsActionPerformed

    private void PanelProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PanelProveedoresActionPerformed
        this.dispose();
        new VProveedores(tipo,username).setVisible(true);
    }//GEN-LAST:event_PanelProveedoresActionPerformed

    private void PanelJefeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PanelJefeActionPerformed
        this.dispose();
        new VJefesUnidad(tipo,username).setVisible(true);
    }//GEN-LAST:event_PanelJefeActionPerformed

    private void PanelDirectoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PanelDirectoresActionPerformed
        this.dispose();
        new VDirectores(tipo,username).setVisible(true);
    }//GEN-LAST:event_PanelDirectoresActionPerformed

    private void PanelRequisicionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PanelRequisicionesActionPerformed
        new VRequisicion(tipo,username).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PanelRequisicionesActionPerformed

    private void PanelCotizacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PanelCotizacionesActionPerformed
        new VCotizacion(tipo,username).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PanelCotizacionesActionPerformed

    private void PanelOrdenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PanelOrdenesActionPerformed
        this.dispose();
        new VOrden(tipo,username).setVisible(true);
    }//GEN-LAST:event_PanelOrdenesActionPerformed

    private void btn_cotizacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cotizacionesActionPerformed
        new VCotizacion(tipo,username).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cotizacionesActionPerformed

    private void btn_requisicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_requisicionActionPerformed
        new VRequisicion(tipo,username).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_requisicionActionPerformed

    private void btn_directoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_directoresActionPerformed
        this.dispose();
        new VDirectores(tipo,username).setVisible(true);
    }//GEN-LAST:event_btn_directoresActionPerformed

    private void btn_jefes_unidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jefes_unidadActionPerformed
        this.dispose();
        new VJefesUnidad(tipo,username).setVisible(true);
    }//GEN-LAST:event_btn_jefes_unidadActionPerformed

    private void btn_proveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_proveedoresActionPerformed
        this.dispose();
        new VProveedores(tipo,username).setVisible(true);
    }//GEN-LAST:event_btn_proveedoresActionPerformed

    private void btn_OrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_OrdenActionPerformed
        this.dispose();
        new VOrden(tipo,username).setVisible(true);
    }//GEN-LAST:event_btn_OrdenActionPerformed

    private void btn_itemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_itemsActionPerformed
        new VItems(tipo, username).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_itemsActionPerformed

    private void btn_LineasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LineasActionPerformed

        new VLineas(tipo, username).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_LineasActionPerformed

    private void btn_unidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_unidadesActionPerformed
        this.dispose();
        new VUnidades(tipo,username).setVisible(true);
    }//GEN-LAST:event_btn_unidadesActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PanelCotizaciones;
    private javax.swing.JButton PanelDirectores;
    private javax.swing.JButton PanelItems;
    private javax.swing.JButton PanelJefe;
    private javax.swing.JButton PanelLineas;
    private javax.swing.JButton PanelOrdenes;
    private javax.swing.JButton PanelProveedores;
    private javax.swing.JButton PanelRequisiciones;
    private javax.swing.JButton PanelUnidades;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btn_Lineas;
    private javax.swing.JButton btn_Orden;
    private javax.swing.JButton btn_cotizaciones;
    private javax.swing.JButton btn_directores;
    private javax.swing.JButton btn_items;
    private javax.swing.JButton btn_jefes_unidad;
    private javax.swing.JButton btn_proveedores;
    private javax.swing.JButton btn_requisicion;
    private javax.swing.JButton btn_unidades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbUnidades;
    private javax.swing.JLabel lbUnidades1;
    private javax.swing.JLabel lbUnidades10;
    private javax.swing.JLabel lbUnidades11;
    private javax.swing.JLabel lbUnidades12;
    private javax.swing.JLabel lbUnidades13;
    private javax.swing.JLabel lbUnidades15;
    private javax.swing.JLabel lbUnidades2;
    private javax.swing.JLabel lbUnidades3;
    // End of variables declaration//GEN-END:variables
}
