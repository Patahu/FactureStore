/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.producto.gestionarCategoria;

import clasesJDBC.ScrollBarCustom;

/**
 *
 * @author fell
 */
public class PanelCategoriasTienda extends javax.swing.JPanel {

    /**
     * Creates new form PanelProductosTienda
     */
    public PanelCategoriasTienda() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        panelD = new javax.swing.JPanel();

        setBackground(new java.awt.Color(37, 31, 52));

        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());

        panelD.setBackground(new java.awt.Color(37, 31, 52));
        panelD.setLayout(new java.awt.GridLayout(0, 1, 10, 10));
        jScrollPane1.setViewportView(panelD);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JPanel panelD;
    // End of variables declaration//GEN-END:variables
}
