/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.caja;

import GUI_Tienda.principal.*;
import GUIingresarProductoFacturaBoleta.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author fell
 */
public class OpereacionCaja extends javax.swing.JPanel {

    /**
     * Creates new form ProductoBuscados
     */
    private Color colorDefecto=new Color(255, 255, 204);
    public OpereacionCaja() {
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

        fecha = new javax.swing.JTextField();
        nombreUsuario = new javax.swing.JTextField();
        tipo = new javax.swing.JTextField();
        razon = new javax.swing.JTextField();
        precioTotal = new javax.swing.JTextField();
        botonImprimir = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));
        setForeground(new java.awt.Color(255, 255, 0));
        setMaximumSize(new java.awt.Dimension(150, 180));
        setMinimumSize(new java.awt.Dimension(150, 180));
        setLayout(new java.awt.GridLayout(0, 1));

        fecha.setEditable(false);
        fecha.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        fecha.setForeground(new java.awt.Color(0, 0, 0));
        fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fecha.setText("fecha");
        fecha.setBorder(null);
        fecha.setMaximumSize(new java.awt.Dimension(64, 21));
        fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaActionPerformed(evt);
            }
        });
        add(fecha);

        nombreUsuario.setEditable(false);
        nombreUsuario.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        nombreUsuario.setForeground(new java.awt.Color(0, 0, 0));
        nombreUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombreUsuario.setText("nombreUsuario");
        nombreUsuario.setBorder(null);
        nombreUsuario.setMaximumSize(new java.awt.Dimension(64, 21));
        nombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreUsuarioActionPerformed(evt);
            }
        });
        add(nombreUsuario);

        tipo.setEditable(false);
        tipo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tipo.setForeground(new java.awt.Color(0, 0, 0));
        tipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tipo.setText("tipo");
        tipo.setBorder(null);
        tipo.setMaximumSize(new java.awt.Dimension(64, 21));
        add(tipo);

        razon.setEditable(false);
        razon.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        razon.setForeground(new java.awt.Color(0, 0, 0));
        razon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        razon.setText("razon");
        razon.setBorder(null);
        razon.setMaximumSize(new java.awt.Dimension(64, 21));
        add(razon);

        precioTotal.setEditable(false);
        precioTotal.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        precioTotal.setForeground(new java.awt.Color(0, 0, 0));
        precioTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        precioTotal.setText("precioTotal");
        precioTotal.setBorder(null);
        precioTotal.setMaximumSize(new java.awt.Dimension(64, 21));
        add(precioTotal);

        botonImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/imprimir.png"))); // NOI18N
        botonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonImprimirActionPerformed(evt);
            }
        });
        add(botonImprimir);
    }// </editor-fold>//GEN-END:initComponents

    private void fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_fechaActionPerformed

    private void nombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreUsuarioActionPerformed

    private void botonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonImprimirActionPerformed
    @Override
    protected void paintComponent(Graphics g) {
           super.paintComponent(g);
           Dimension arcs = new Dimension(16,16); //Border corners arcs {width,height}, change this to whatever you want
           int width = getWidth();
           int height = getHeight();
           Graphics2D graphics = (Graphics2D) g;
           graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


  
           //Draws the rounded panel with borders.
           graphics.setColor(colorDefecto);//37,31,52
           graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
           graphics.setColor(colorDefecto);
           graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
    };

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton botonImprimir;
    protected javax.swing.JTextField fecha;
    protected javax.swing.JTextField nombreUsuario;
    protected javax.swing.JTextField precioTotal;
    protected javax.swing.JTextField razon;
    protected javax.swing.JTextField tipo;
    // End of variables declaration//GEN-END:variables
}
