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
import clasesJDBC.ProductoVendidoJDBC;
import clasesJDBC.VentaJDBC;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import org.jfree.ui.RectangleInsets;
import tickets.Impresor;
import tickets.ImprimirEgresoIngreso;

/**
 *
 * @author fell
 */
public class poolGraficaVentasDia implements Callable<String>,ActionListener {

    
    private ControladorTiendaReportes controladorTiendaCaja;
    
    private HashMap<String, Venta> operacionesRealizadas= new HashMap<String, Venta>();
    private HashMap<String, OpereacionVenta> contenedores= new HashMap<String, OpereacionVenta>();
  
    public poolGraficaVentasDia(ControladorTiendaReportes controladorTiendaCaja) {
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
        ProductoVendidoJDBC operacionVentas= new ProductoVendidoJDBC();
        Date fecha=new Date();
        ArrayList<ProductoVendido> productosOperaciones=operacionVentas.buscarProductoxdia(fecha);
         DefaultCategoryDataset datos=new DefaultCategoryDataset();
        double total=0;
        for(ProductoVendido ur: productosOperaciones){
            datos.setValue(ur.getCantidadVendida(),ur.getIdVenta(),ur.getNombre());
            total+=ur.getCantidadVendida();
          
        }
        //controladorTiendaCaja.getGestionarTiendaCaja().totalPrecio.setText(""+total);
        JFreeChart grafico_barras=ChartFactory.createBarChart3D("Productos vendidos, TOTAL="+total, "productos", "Soles", datos,PlotOrientation.VERTICAL,true,true,false);
        grafico_barras.setBackgroundPaint(new Color(37,31,52));
        grafico_barras.getTitle().setPaint(new Color(255,255,255));
      
        ChartPanel panel=new ChartPanel(grafico_barras);
        System.out.println("AUI--------------");
        
        controladorTiendaCaja.setPanelControladorProducto(panel,  new Dimension(516, 500)); 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        

    }    
}
