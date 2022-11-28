/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.reportes;

import GUI_Tienda.caja.*;
import GUI_Tienda.principal.*;
import GUI_Tienda.producto.gestionarProducto.*;
import GUILoading.Cargando;
import clases.Categoria;
import clases.OperacioCaja;
import clases.Producto;
import clases.ProductoVendido;
import clases.Venta;
import clasesJDBC.CategoriaJDBC;
import clasesJDBC.OperacionCajaJDBC;
import clasesJDBC.ProductoJDBC;
import clasesJDBC.VentaJDBC;
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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import tickets.Impresor;
import tickets.ImprimirEgresoIngreso;

/**
 *
 * @author fell
 */
public class poolBuscarOperacionVentas implements Callable<String>,ActionListener {

    
    private ControladorTiendaReportes controladorTiendaCaja;
    
    private HashMap<String, Venta> operacionesRealizadas= new HashMap<String, Venta>();
    private HashMap<String, OpereacionVenta> contenedores= new HashMap<String, OpereacionVenta>();
  
    public poolBuscarOperacionVentas(ControladorTiendaReportes controladorTiendaCaja) {
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
        PanelVentasSub operacionesPanel= new PanelVentasSub();
        int contador=0;
        VentaJDBC operacionesCaja= new VentaJDBC();

        ArrayList<Venta> productosOperaciones=operacionesCaja.buscarVentas();
     
        for(Venta pa: productosOperaciones){
            
            String indice=""+contador;

            OpereacionVenta c=new OpereacionVenta();   
            c.setBackground(new Color(37,31,52));
            c.botonImprimir.setActionCommand("botonImprimir,"+indice);
            c.botonImprimir.addActionListener(this);
   
            c.botonModificar.setActionCommand("botonModificar,"+indice);
            c.botonModificar.addActionListener(this);
            
               
            c.botonEliminar.setActionCommand("botonEliminar,"+indice);
            c.botonEliminar.addActionListener(this);
            
            
            
            contenedores.put(indice,c);
            c.fecha.setText(""+pa.getFechaCreacion());
            c.nombreUsuario.setText(""+pa.getNombreUsuario());
            c.precioTotal.setText(""+pa.getPrecioTotal());
            c.idVenta.setText(""+pa.getIdVenta());
            this.operacionesRealizadas.put(indice, pa);
            contador++;
            operacionesPanel.productosSub.add(c,0);
            operacionesPanel.productosSub.updateUI();
        }
        controladorTiendaCaja.setPanelControladorProducto(operacionesPanel,  new Dimension(1180, 475)); 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String evento[]= e.getActionCommand().split(",");
        System.out.println(" Evento"+evento[0]);
        if(evento[0].equals("botonImprimir")){
            String id= evento[1];
            Venta ope= operacionesRealizadas.get(id);
            controladorTiendaCaja.setVentaSeleccionada(ope);
            controladorTiendaCaja.proceso("botonImprimir");
            /*String imprimirEgresoIngreso=ImprimirEgresoIngreso.ingresarDocumentoImprimir(ope);
            Impresor imp=new Impresor();
            try {
                imp.imprimir(imprimirEgresoIngreso);
            } catch (PrinterException | IOException ex) {
                JOptionPane.showMessageDialog(null, "Error de impresion", "Error", JOptionPane.ERROR_MESSAGE);

            }   */ 
        } else if(evento[0].equals("botonModificar")){
            String id= evento[1];
            Venta ope= operacionesRealizadas.get(id);
            controladorTiendaCaja.setVentaSeleccionada(ope);
            controladorTiendaCaja.proceso("botonModificar");
            /*String imprimirEgresoIngreso=ImprimirEgresoIngreso.ingresarDocumentoImprimir(ope);
            Impresor imp=new Impresor();
            try {
                imp.imprimir(imprimirEgresoIngreso);
            } catch (PrinterException | IOException ex) {
                JOptionPane.showMessageDialog(null, "Error de impresion", "Error", JOptionPane.ERROR_MESSAGE);

            }   */ 
        }else if(evento[0].equals("botonEliminar")){
            String id= evento[1];
            Venta ope= operacionesRealizadas.get(id);
            controladorTiendaCaja.setVentaSeleccionada(ope);
            controladorTiendaCaja.proceso("botonEliminar");
            /*String imprimirEgresoIngreso=ImprimirEgresoIngreso.ingresarDocumentoImprimir(ope);
            Impresor imp=new Impresor();
            try {
                imp.imprimir(imprimirEgresoIngreso);
            } catch (PrinterException | IOException ex) {
                JOptionPane.showMessageDialog(null, "Error de impresion", "Error", JOptionPane.ERROR_MESSAGE);

            }   */ 
        }
    }    
}
