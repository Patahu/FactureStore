/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda;

import GUI_limbo.*;

/**
 *
 * @author fell
 */
public class Tienda extends javax.swing.JPanel {

    /**
     * Creates new form limbo
     */
    public Tienda() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        volver = new javax.swing.JButton();
        gestionarTienda = new javax.swing.JButton();
        gestionarCaja = new javax.swing.JButton();
        gestionarReporte = new javax.swing.JButton();
        gestionarProducto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cerrarSesion = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        rrs1 = new javax.swing.JLabel();
        rol = new javax.swing.JLabel();

        setBackground(new java.awt.Color(37, 31, 52));

        jPanel1.setBackground(new java.awt.Color(37, 31, 52));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        volver.setBackground(new java.awt.Color(100, 100, 100));
        volver.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        volver.setForeground(new java.awt.Color(255, 255, 255));
        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/volver.png"))); // NOI18N
        volver.setActionCommand("volver");
        jPanel1.add(volver);

        gestionarTienda.setBackground(new java.awt.Color(100, 100, 100));
        gestionarTienda.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        gestionarTienda.setForeground(new java.awt.Color(255, 255, 255));
        gestionarTienda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/bienes.png"))); // NOI18N
        gestionarTienda.setText("Venta");
        gestionarTienda.setActionCommand("gestionarTienda");
        jPanel1.add(gestionarTienda);

        gestionarCaja.setBackground(new java.awt.Color(100, 100, 100));
        gestionarCaja.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        gestionarCaja.setForeground(new java.awt.Color(255, 255, 255));
        gestionarCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/caja-registradora.png"))); // NOI18N
        gestionarCaja.setText("Caja");
        gestionarCaja.setActionCommand("gestionarCaja");
        jPanel1.add(gestionarCaja);

        gestionarReporte.setBackground(new java.awt.Color(100, 100, 100));
        gestionarReporte.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        gestionarReporte.setForeground(new java.awt.Color(255, 255, 255));
        gestionarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/ventas.png"))); // NOI18N
        gestionarReporte.setText("Reporte");
        gestionarReporte.setActionCommand("gestionarReporte");
        jPanel1.add(gestionarReporte);

        gestionarProducto.setBackground(new java.awt.Color(100, 100, 100));
        gestionarProducto.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        gestionarProducto.setForeground(new java.awt.Color(255, 255, 255));
        gestionarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/estar.png"))); // NOI18N
        gestionarProducto.setText("Producto");
        gestionarProducto.setActionCommand("gestionarProducto");
        jPanel1.add(gestionarProducto);

        jPanel2.setBackground(new java.awt.Color(37, 31, 52));
        jPanel2.setPreferredSize(new java.awt.Dimension(1100, 470));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setBackground(new java.awt.Color(37, 31, 52));

        cerrarSesion.setBackground(new java.awt.Color(255, 204, 204));
        cerrarSesion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cerrarSesion.setForeground(new java.awt.Color(0, 0, 0));
        cerrarSesion.setText("Cerrar Sesión");

        jPanel5.setBackground(new java.awt.Color(37, 31, 52));
        jPanel5.setLayout(new java.awt.GridLayout(0, 1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(20, 218, 226));
        jLabel2.setText("Usuario");
        jPanel5.add(jLabel2);

        user.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        user.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(user);

        rrs1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rrs1.setForeground(new java.awt.Color(20, 218, 226));
        rrs1.setText("Rol");
        jPanel5.add(rrs1);

        rol.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rol.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(rol);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(cerrarSesion)
                .addGap(18, 18, 18))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(160, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(cerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton cerrarSesion;
    protected javax.swing.JButton gestionarCaja;
    protected javax.swing.JButton gestionarProducto;
    protected javax.swing.JButton gestionarReporte;
    protected javax.swing.JButton gestionarTienda;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    protected javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    protected javax.swing.JLabel rol;
    private javax.swing.JLabel rrs1;
    protected javax.swing.JLabel user;
    protected javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}