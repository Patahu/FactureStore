/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.principal;

import clases.Validator;
import clasesJDBC.ScrollBarCustom;
import java.awt.Color;
import java.awt.event.ActionEvent;

/**
 *
 * @author fell
 */
public class GestionarTiendaPrincipal extends javax.swing.JPanel {

    private ControladorTiendaPrincipal pp;
    public GestionarTiendaPrincipal(ControladorTiendaPrincipal pp) {
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

        jPanel1 = new javax.swing.JPanel();
        vender = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        todosSelected = new javax.swing.JCheckBox();
        jPanel23 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        codigoBarras = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        totalPrecio = new javax.swing.JLabel();
        productosVender = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        productosSub = new javax.swing.JPanel();
        egreso = new javax.swing.JButton();
        ingreso = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        categori = new javax.swing.JRadioButton();
        categorias = new javax.swing.JComboBox<>();
        jPanel25 = new javax.swing.JPanel();
        cambioTexto = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(1100, 620));
        setMinimumSize(new java.awt.Dimension(1100, 620));
        setPreferredSize(new java.awt.Dimension(1100, 620));
        setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(37, 31, 52));

        vender.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        vender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/vender_1.png"))); // NOI18N
        vender.setText("Vender");

        jPanel3.setBackground(new java.awt.Color(37, 31, 52));

        todosSelected.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        todosSelected.setForeground(new java.awt.Color(20, 218, 226));
        todosSelected.setSelected(true);
        todosSelected.setText("todos");
        todosSelected.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                todosSelectedMouseReleased(evt);
            }
        });
        todosSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todosSelectedActionPerformed(evt);
            }
        });

        jPanel23.setBackground(new java.awt.Color(82, 75, 99));

        jLabel20.setBackground(new java.awt.Color(82, 75, 99));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/codigo-de-barras (1).png"))); // NOI18N

        codigoBarras.setBackground(new java.awt.Color(82, 75, 99));
        codigoBarras.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        codigoBarras.setForeground(new java.awt.Color(255, 255, 255));
        codigoBarras.setBorder(null);
        codigoBarras.setName(""); // NOI18N
        codigoBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoBarrasActionPerformed(evt);
            }
        });
        codigoBarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codigoBarrasKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addContainerGap(389, Short.MAX_VALUE))
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                    .addGap(0, 44, Short.MAX_VALUE)
                    .addComponent(codigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(codigoBarras, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(todosSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(156, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(todosSelected, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(10, Short.MAX_VALUE)))
        );

        jPanel5.setBackground(new java.awt.Color(37, 31, 52));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setBackground(new java.awt.Color(37, 31, 52));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 218, 226));
        jLabel1.setText("Total");
        jPanel5.add(jLabel1);

        totalPrecio.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        totalPrecio.setForeground(new java.awt.Color(0, 255, 255));
        totalPrecio.setText("0.0");
        jPanel5.add(totalPrecio);

        productosVender.setBackground(new java.awt.Color(37, 31, 52));

        javax.swing.GroupLayout productosVenderLayout = new javax.swing.GroupLayout(productosVender);
        productosVender.setLayout(productosVenderLayout);
        productosVenderLayout.setHorizontalGroup(
            productosVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
        );
        productosVenderLayout.setVerticalGroup(
            productosVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(vender, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(productosVender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productosVender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vender, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(37, 31, 52));
        jPanel2.setPreferredSize(new java.awt.Dimension(1182, 655));

        productosSub.setBackground(new java.awt.Color(37, 31, 52));
        productosSub.setAlignmentX(10.0F);
        productosSub.setAlignmentY(10.0F);

        javax.swing.GroupLayout productosSubLayout = new javax.swing.GroupLayout(productosSub);
        productosSub.setLayout(productosSubLayout);
        productosSubLayout.setHorizontalGroup(
            productosSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );
        productosSubLayout.setVerticalGroup(
            productosSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        egreso.setBackground(new Color(240, 240, 240,100));
        egreso.setForeground(new java.awt.Color(0, 0, 0));
        egreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/flujo-de-efectivo.png"))); // NOI18N
        egreso.setText("Egreso");

        ingreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/dinero.png"))); // NOI18N
        ingreso.setText("Ingreso");

        jPanel4.setBackground(new java.awt.Color(37, 31, 52));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/buscar (1).png"))); // NOI18N
        jButton2.setActionCommand("cambioText");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        categorias.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jPanel25.setBackground(new java.awt.Color(82, 75, 99));

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

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cambioTexto))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cambioTexto)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(categori))
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(categori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(categorias, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(productosSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(egreso)
                        .addGap(53, 53, 53)
                        .addComponent(ingreso)))
                .addGap(44, 44, 44))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(productosSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ingreso)
                    .addComponent(egreso))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents

    private void todosSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todosSelectedActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_todosSelectedActionPerformed

    private void todosSelectedMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_todosSelectedMouseReleased
        // TODO add your handling code here:
        
        int uniqueId =(int) System.currentTimeMillis();
        String commandName = "recalcularTodo";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        pp.actionPerformed(event);
        
    }//GEN-LAST:event_todosSelectedMouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void codigoBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoBarrasActionPerformed
        // TODO add your handling code here:
        int uniqueId =(int) System.currentTimeMillis();
        String commandName = "ingresarCodigoBarras";
        
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        pp.actionPerformed(event);
    }//GEN-LAST:event_codigoBarrasActionPerformed

    private void codigoBarrasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoBarrasKeyReleased
        // TODO add your handling code here:
        Validator validador=new Validator();
        if(!validador.validarNumerico(codigoBarras.getText())){

            codigoBarras.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Caracter Incorrecto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 10), new java.awt.Color(255, 102, 51)));
        }
        else{
            codigoBarras.setBorder(null);

            //usuarioTextField.setBorder(new JTextField().getBorder());
        }
    }//GEN-LAST:event_codigoBarrasKeyReleased

    private void cambioTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambioTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cambioTextoActionPerformed

    private void cambioTextoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cambioTextoKeyReleased
        // TODO add your handling code here:
        
        int uniqueId =(int) System.currentTimeMillis();
        String commandName = "cambioText";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        pp.actionPerformed(event);
    }//GEN-LAST:event_cambioTextoKeyReleased
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JTextField cambioTexto;
    protected javax.swing.JRadioButton categori;
    protected javax.swing.JComboBox<String> categorias;
    protected javax.swing.JTextField codigoBarras;
    protected javax.swing.JButton egreso;
    protected javax.swing.JButton ingreso;
    protected javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    protected javax.swing.JPanel productosSub;
    protected javax.swing.JPanel productosVender;
    protected javax.swing.JCheckBox todosSelected;
    protected javax.swing.JLabel totalPrecio;
    protected javax.swing.JButton vender;
    // End of variables declaration//GEN-END:variables
}