/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.caja;

import GUI_Tienda.principal.*;
import GUI_Tienda.producto.gestionarProducto.*;
import GUILoading.Cargando;
import clases.Categoria;
import clases.OperacioCaja;
import clases.Producto;
import clases.ProductoVendido;
import clasesJDBC.CategoriaJDBC;
import clasesJDBC.OperacionCajaJDBC;
import clasesJDBC.ProductoJDBC;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import tickets.Impresor;
import tickets.ImprimirEgresoIngreso;

/**
 *
 * @author fell
 */
public class poolBuscarOperacionCaja implements Callable<String>,ActionListener {

    
    private ControladorTiendaCaja controladorTiendaCaja;
    
    private HashMap<String, OperacioCaja> operacionesRealizadas= new HashMap<String, OperacioCaja>();
    private HashMap<String, OpereacionCaja> contenedores= new HashMap<String, OpereacionCaja>();
  
    public poolBuscarOperacionCaja(ControladorTiendaCaja controladorTiendaCaja) {
        this.controladorTiendaCaja=controladorTiendaCaja;
   
    }
    
    @Override
    public String call() throws Exception {
        Cargando cargando= new Cargando();
        controladorTiendaCaja.setPanelControladorProducto(cargando,  new Dimension(516, 500));
        mostrarHorarios();
        return "poolBuscarOperaciones Terminado";
    }
    
    
    public void mostrarHorarios(){
        PanelOperacionesSub operacionesPanel= new PanelOperacionesSub();
        int contador=0;
        OperacionCajaJDBC operacionesCaja= new OperacionCajaJDBC();

        ArrayList<OperacioCaja> productosOperaciones=operacionesCaja.buscarOperacionCaja();

        for(OperacioCaja pa: productosOperaciones){
            
            String indice=""+contador;

            OpereacionCaja c=new OpereacionCaja();   
            c.setBackground(new Color(37,31,52));
            c.botonImprimir.setActionCommand("BotonIngresarProducto,"+indice);
            c.botonImprimir.addActionListener(this);
   

            contenedores.put(indice,c);
            c.fecha.setText(""+pa.getFechaOperacion());
            c.nombreUsuario.setText(""+pa.getNombreUsuario());
            c.tipo.setText(""+pa.getTipo());
            c.razon.setText(""+pa.getRazon());
            c.precioTotal.setText(""+pa.getPrecioTotal());
            this.operacionesRealizadas.put(indice, pa);
            contador++;
            operacionesPanel.productosSub.add(c,0);
            operacionesPanel.productosSub.updateUI();
        }
        controladorTiendaCaja.setPanelControladorProducto(operacionesPanel,  new Dimension(516, 500)); 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String evento[]= e.getActionCommand().split(",");
        System.out.println(" Evento"+evento[0]);
        if(evento[0].equals("BotonIngresarProducto")){
            String id= evento[1];
            OperacioCaja ope= operacionesRealizadas.get(id);
            String imprimirEgresoIngreso=ImprimirEgresoIngreso.ingresarDocumentoImprimir(ope);
            Impresor imp=new Impresor();
            try {
                imp.imprimir(imprimirEgresoIngreso);
            } catch (PrinterException | IOException ex) {
                JOptionPane.showMessageDialog(null, "Error de impresion", "Error", JOptionPane.ERROR_MESSAGE);

            }    
        }
    }    
}
