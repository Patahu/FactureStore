/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.producto.gestionarProducto;

import GUI_Tienda.producto.*;
import GUI_limbo.gestionar_horarios.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author fell
 */
public class GestionarProductos extends javax.swing.JPanel {

    /**
     * Creates new form Horarios
     */
    private ControladorProducto pp;
    public GestionarProductos(ControladorProducto pp) {
        initComponents();
        this.pp=pp;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aquiHor = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        ingresarProducto = new javax.swing.JButton();
        cambioText = new javax.swing.JTextField();
        buscarProducto = new javax.swing.JButton();

        setBackground(new java.awt.Color(37, 31, 52));

        aquiHor.setBackground(new java.awt.Color(37, 31, 52));
        aquiHor.setFocusable(false);
        aquiHor.setLayout(new java.awt.GridLayout(1, 0));

        jPanel4.setBackground(new java.awt.Color(37, 31, 52));

        ingresarProducto.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        ingresarProducto.setText("Ingresar producto");
        ingresarProducto.setActionCommand("ingresarProducto");

        cambioText.setBackground(new java.awt.Color(82, 75, 99));
        cambioText.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cambioText.setForeground(new java.awt.Color(255, 255, 255));
        cambioText.setActionCommand("cambioText");
        cambioText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cambioTextKeyReleased(evt);
            }
        });

        buscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/buscar.png"))); // NOI18N
        buscarProducto.setActionCommand("buscarProducto");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(cambioText, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(buscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(ingresarProducto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ingresarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buscarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cambioText, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(aquiHor, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aquiHor, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cambioTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cambioTextKeyReleased
        // TODO add your handling code here:
        int uniqueId =(int) System.currentTimeMillis();
        String commandName = "cambioText";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        pp.actionPerformed(event);
    }//GEN-LAST:event_cambioTextKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JPanel aquiHor;
    protected javax.swing.JButton buscarProducto;
    protected javax.swing.JTextField cambioText;
    protected javax.swing.JButton ingresarProducto;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}