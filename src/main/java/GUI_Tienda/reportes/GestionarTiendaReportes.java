/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.reportes;

import GUI_Tienda.caja.*;
import GUI_Tienda.principal.*;
import clases.Validator;
import clasesJDBC.ScrollBarCustom;
import java.awt.event.ActionEvent;
import java.util.Date;

/**
 *
 * @author fell
 */
public class GestionarTiendaReportes extends javax.swing.JPanel {

    private ControladorTiendaReportes pp;
    public GestionarTiendaReportes(ControladorTiendaReportes pp) {
        initComponents();
        this.pp=pp;
        calendarioPrimero.setDate(new Date());
        calendarioFinal.setDate(new Date());
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
        productosVendidos = new javax.swing.JButton();
        historialVentas = new javax.swing.JButton();
        ventasDia = new javax.swing.JButton();
        historial = new javax.swing.JButton();
        cuadre = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        calendarioPrimero = new com.toedter.calendar.JDateChooser();
        calendarioFinal = new com.toedter.calendar.JDateChooser();
        buscar = new javax.swing.JButton();
        activoNombre = new javax.swing.JRadioButton();
        activoRangoFecha = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        cambioTexto = new javax.swing.JTextField();
        productosSub = new javax.swing.JPanel();

        setBackground(new java.awt.Color(37, 31, 52));
        setMaximumSize(new java.awt.Dimension(1100, 620));
        setMinimumSize(new java.awt.Dimension(1100, 620));
        setPreferredSize(new java.awt.Dimension(1100, 620));

        jPanel1.setBackground(new java.awt.Color(37, 31, 52));

        productosVendidos.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        productosVendidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/barra-grafica (1).png"))); // NOI18N
        productosVendidos.setText("Producto vs fecha");
        productosVendidos.setActionCommand("productosVendidos");
        productosVendidos.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        productosVendidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosVendidosActionPerformed(evt);
            }
        });

        historialVentas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        historialVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/lista-de-verificacion.png"))); // NOI18N
        historialVentas.setText("Ventas totales");
        historialVentas.setActionCommand("historialVentas");
        historialVentas.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        historialVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialVentasActionPerformed(evt);
            }
        });

        ventasDia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ventasDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/barra-grafica.png"))); // NOI18N
        ventasDia.setText("Ventas vs Dia");
        ventasDia.setActionCommand("ventasDia");
        ventasDia.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        ventasDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventasDiaActionPerformed(evt);
            }
        });

        historial.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        historial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/analitica.png"))); // NOI18N
        historial.setText("Grafica de productos");
        historial.setActionCommand("botonHistorial");
        historial.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        cuadre.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cuadre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/imprimir (2).png"))); // NOI18N
        cuadre.setActionCommand("cuadre");
        cuadre.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        cuadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuadreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ventasDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(historialVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(historial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productosVendidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cuadre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(historialVentas)
                    .addComponent(historial)
                    .addComponent(cuadre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productosVendidos)
                    .addComponent(ventasDia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(37, 31, 52));

        calendarioPrimero.setBackground(new java.awt.Color(82, 75, 99));
        calendarioPrimero.setOpaque(false);

        calendarioFinal.setBackground(new java.awt.Color(82, 75, 99));
        calendarioFinal.setOpaque(false);

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/buscar (1).png"))); // NOI18N
        buscar.setActionCommand("iniciar");

        jPanel3.setBackground(new java.awt.Color(82, 75, 99));

        cambioTexto.setBackground(new java.awt.Color(82, 75, 99));
        cambioTexto.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cambioTexto.setForeground(new java.awt.Color(255, 255, 255));
        cambioTexto.setBorder(null);
        cambioTexto.setName(""); // NOI18N
        cambioTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambioTextoActionPerformed(evt);
            }
        });
        cambioTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cambioTextoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cambioTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cambioTexto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(calendarioPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(calendarioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(activoRangoFecha)
                    .addComponent(activoNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(activoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calendarioPrimero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(activoRangoFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(calendarioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(96, 96, 96))
        );

        productosSub.setBackground(new java.awt.Color(37, 31, 52));
        productosSub.setAlignmentX(10.0F);
        productosSub.setAlignmentY(10.0F);
        productosSub.setMaximumSize(new java.awt.Dimension(1100, 450));
        productosSub.setMinimumSize(new java.awt.Dimension(1100, 450));
        productosSub.setName(""); // NOI18N
        productosSub.setPreferredSize(new java.awt.Dimension(1100, 450));
        productosSub.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(productosSub, javax.swing.GroupLayout.PREFERRED_SIZE, 1019, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productosSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cuadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuadreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cuadreActionPerformed

    private void productosVendidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosVendidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productosVendidosActionPerformed

    private void historialVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_historialVentasActionPerformed

    private void ventasDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventasDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ventasDiaActionPerformed

    private void cambioTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambioTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cambioTextoActionPerformed

    private void cambioTextoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cambioTextoKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_cambioTextoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JRadioButton activoNombre;
    protected javax.swing.JRadioButton activoRangoFecha;
    protected javax.swing.JButton buscar;
    protected com.toedter.calendar.JDateChooser calendarioFinal;
    protected com.toedter.calendar.JDateChooser calendarioPrimero;
    protected javax.swing.JTextField cambioTexto;
    protected javax.swing.JButton cuadre;
    protected javax.swing.JButton historial;
    protected javax.swing.JButton historialVentas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    protected javax.swing.JPanel productosSub;
    protected javax.swing.JButton productosVendidos;
    protected javax.swing.JButton ventasDia;
    // End of variables declaration//GEN-END:variables
}
