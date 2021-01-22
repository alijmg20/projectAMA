package views;

import com.placeholder.PlaceHolder;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    private PlaceHolder pl;
    private int tipo;

    //Usuario Jefe
    public Login() {
        initComponents();
        pl = new PlaceHolder(this.txtUsuario, "Ficha");
        pl = new PlaceHolder(this.txtPassword, "******");
        this.jLabel4.setText("Bienvenido al sistema AMA Jefe/director");
        tipo = 0;
    }

    public Login(int tipo) {
        initComponents();
        
        //Usuario proveedor
        if (tipo == 1) {
            this.tipo = tipo;
            pl = new PlaceHolder(this.txtUsuario, "RIF ");
            pl = new PlaceHolder(this.txtPassword, "******");
            this.jLabel2.setText("RIF : ");
            this.txtPassword.setEnabled(false);
            this.LabelRegistrar.setVisible(false);
            this.LabelOlvidoPassword.setVisible(false);
            this.jLabel4.setText("Bienvenido al sistema AMA Proveedor");
            this.lbAdministrador.setText("Ventana Proveedor");
            
            //Usuario administrador    
        } else if (tipo == 2) {
            this.tipo = tipo;
            this.jPanel2.setBackground(java.awt.Color.decode("#d7fec5"));
            pl = new PlaceHolder(this.txtUsuario, "admin");
            pl = new PlaceHolder(this.txtPassword, "******");
            this.lbAdministrador.setText("Modo Administrador");
            this.lbAdministrador.setForeground(java.awt.Color.black);
            this.jLabel4.setText("Bienvenido al sistema AMA Administrador");
            this.LabelOlvidoPassword.setVisible(false);
            this.lbAdministrador.setText("Modo Administrador");
            this.LabelRegistrar.setForeground(java.awt.Color.black);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        LabelRegistrar = new javax.swing.JLabel();
        LabelOlvidoPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        lbAdministrador = new javax.swing.JLabel();
        btn_volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ingresar Usuario");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 417));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/designs/login.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Usuario :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Password :");

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        LabelRegistrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LabelRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        LabelRegistrar.setText("Registrar como Jefe o Director");
        LabelRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabelRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelRegistrarMouseClicked(evt);
            }
        });

        LabelOlvidoPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LabelOlvidoPassword.setForeground(new java.awt.Color(255, 255, 255));
        LabelOlvidoPassword.setText("¿Has olvidado tu password?");
        LabelOlvidoPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabelOlvidoPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelOlvidoPasswordMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Bienvenido al sistema AMA");

        lbAdministrador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbAdministrador.setForeground(new java.awt.Color(255, 255, 255));

        btn_volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/designs/Volver.png"))); // NOI18N
        btn_volver.setContentAreaFilled(false);
        btn_volver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lbAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(270, 270, 270))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(396, 396, 396)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(57, 57, 57)
                                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(547, 547, 547))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelOlvidoPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(541, 541, 541))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEnviar))
                            .addComponent(jLabel2))
                        .addGap(77, 77, 77))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPassword)
                            .addComponent(jLabel3))
                        .addGap(20, 20, 20)))
                .addComponent(LabelRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(lbAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(LabelOlvidoPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LabelRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelRegistrarMouseClicked
        this.dispose();
            
    }//GEN-LAST:event_LabelRegistrarMouseClicked

    private void LabelOlvidoPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelOlvidoPasswordMouseClicked
        this.dispose();

    }//GEN-LAST:event_LabelOlvidoPasswordMouseClicked

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed

    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        
        if (this.tipo == 0) { //0 = usuario jefe
            
        } else if (this.tipo == 1) { //1 = proveedor

        } else if (this.tipo == 2) { //2 = Administrador
            
            if(this.txtUsuario.getText().equals("admin") && this.txtPassword.getText().equals("password")){
                new MainMenu(tipo,"Admin").setVisible(true);
                this.txtUsuario.setText("");
                this.txtPassword.setText("");
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Las credenciales ingresadas son erroneas","Invalido",JOptionPane.ERROR_MESSAGE);
            }
            
        }


    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        this.dispose();
        new TipoUsuario().setVisible(true);
    }//GEN-LAST:event_btn_volverActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelOlvidoPassword;
    private javax.swing.JLabel LabelRegistrar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbAdministrador;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
