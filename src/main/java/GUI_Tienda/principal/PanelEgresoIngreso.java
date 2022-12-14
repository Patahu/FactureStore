/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.principal;
import clases.Validator;
import clasesJDBC.ScrollBarCustom;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
/**
 *
 * @author fell
 */
public class PanelEgresoIngreso extends javax.swing.JPanel {

    /**
     * Creates new form PanelProductosSub
     */
    private ControladorTiendaPrincipal controladorTiendaPrincipal;
    public PanelEgresoIngreso(ControladorTiendaPrincipal controladorTiendaPrincipal) {
        this.controladorTiendaPrincipal=controladorTiendaPrincipal;
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

        tipo = new javax.swing.JLabel();
        botonIngresoEgreso = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        razon = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        cantidad = new javax.swing.JTextField();

        setBackground(new java.awt.Color(37, 31, 52));
        setMaximumSize(new java.awt.Dimension(529, 427));
        setMinimumSize(new java.awt.Dimension(529, 427));
        setPreferredSize(new java.awt.Dimension(529, 427));

        tipo.setBackground(new java.awt.Color(37, 31, 52));
        tipo.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        tipo.setForeground(new java.awt.Color(255, 255, 255));
        tipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipo.setText("Egreso/Ingreso");

        botonIngresoEgreso.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        botonIngresoEgreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/salvar.png"))); // NOI18N
        botonIngresoEgreso.setText("GUARDAR");
        botonIngresoEgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresoEgresoActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(37, 31, 52));
        jPanel4.setLayout(new java.awt.GridLayout());

        jLabel5.setBackground(new java.awt.Color(37, 31, 52));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(20, 218, 226));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Raz??n");
        jPanel4.add(jLabel5);

        jPanel28.setBackground(new java.awt.Color(82, 75, 99));

        razon.setBackground(new java.awt.Color(82, 75, 99));
        razon.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        razon.setForeground(new java.awt.Color(255, 255, 255));
        razon.setBorder(null);
        razon.setName(""); // NOI18N
        razon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambioTexto1ActionPerformed(evt);
            }
        });
        razon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cambioTexto1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(razon))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(razon, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel28);

        jPanel2.setBackground(new java.awt.Color(37, 31, 52));
        jPanel2.setLayout(new java.awt.GridLayout());

        jLabel2.setBackground(new java.awt.Color(37, 31, 52));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(20, 218, 226));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cantidad");
        jPanel2.add(jLabel2);

        jPanel25.setBackground(new java.awt.Color(82, 75, 99));

        cantidad.setBackground(new java.awt.Color(82, 75, 99));
        cantidad.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cantidad.setForeground(new java.awt.Color(255, 255, 255));
        cantidad.setBorder(null);
        cantidad.setName(""); // NOI18N
        cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadActionPerformed(evt);
            }
        });
        cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cantidadKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cantidad))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(botonIngresoEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(botonIngresoEgreso)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadKeyReleased
        // TODO add your handling code here:
        
        Validator validador=new Validator();
        if(!validador.validarNumerico(cantidad.getText())){

            cantidad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Caracter Incorrecto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 10), new java.awt.Color(255, 102, 51)));
        }
        else{
            cantidad.setBorder(null);
            //cantidad.setBorder(new JTextField().getBorder());
        }
    }//GEN-LAST:event_cantidadKeyReleased

    private void cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadActionPerformed

    private void cambioTexto1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cambioTexto1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cambioTexto1KeyReleased

    private void cambioTexto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambioTexto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cambioTexto1ActionPerformed

    private void botonIngresoEgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresoEgresoActionPerformed
        // TODO add your handling code here:
        int uniqueId =(int) System.currentTimeMillis();
        String commandName = "ingresarEgresoIngreso";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        controladorTiendaPrincipal.actionPerformed(event);  
        
    }//GEN-LAST:event_botonIngresoEgresoActionPerformed

    @Override
    protected void paintComponent(Graphics g) {
           super.paintComponent(g);
           Dimension arcs = new Dimension(16,16); //Border corners arcs {width,height}, change this to whatever you want
           int width = getWidth();
           int height = getHeight();
           Graphics2D graphics = (Graphics2D) g;
           graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


  
           //Draws the rounded panel with borders.
           graphics.setColor(new java.awt.Color(126, 225, 126,70));//37,31,52
           graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
           graphics.setColor(new java.awt.Color(126, 225, 126,70));
           graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
    };

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIngresoEgreso;
    protected javax.swing.JTextField cambioTexto1;
    protected javax.swing.JTextField cambioTexto2;
    protected javax.swing.JTextField cantidad;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    protected javax.swing.JTextField razon;
    protected javax.swing.JLabel tipo;
    // End of variables declaration//GEN-END:variables
}
