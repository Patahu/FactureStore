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
import tickets.Impresor;
import tickets.ImprimirEgresoIngreso;

/**
 *
 * @author fell
 */
public class poolGraficadiaRangoNombreVentas implements Callable<String>,ActionListener {

    
    private ControladorTiendaReportes controladorTiendaCaja;
    
    private HashMap<String, Venta> operacionesRealizadas= new HashMap<String, Venta>();
    private HashMap<String, OpereacionVenta> contenedores= new HashMap<String, OpereacionVenta>();
  
    public poolGraficadiaRangoNombreVentas(ControladorTiendaReportes controladorTiendaCaja) {
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
        Date fecha1=controladorTiendaCaja.getGestionarTiendaCaja().calendarioPrimero.getDate();
        Date fecha2=controladorTiendaCaja.getGestionarTiendaCaja().calendarioFinal.getDate();
        String nombreBuscar=controladorTiendaCaja.getGestionarTiendaCaja().cambioTexto.getText();
        ArrayList<ProductoVendido> productosOperaciones=operacionVentas.buscardiaRangoNombreVentas(fecha1,fecha2,nombreBuscar);
         DefaultCategoryDataset datos=new DefaultCategoryDataset();
        double total=0;
        for(ProductoVendido ur: productosOperaciones){
            datos.setValue(ur.getCantidadVendida(),ur.getNombre(),ur.getIdVenta());
            total+=ur.getCantidadVendida();
        }
        //controladorTiendaCaja.getGestionarTiendaCaja().totalPrecio.setText(""+total);
        JFreeChart grafico_barras=ChartFactory.createBarChart3D("Ventas por día de la semana, TOTAL="+total, "Día", "Soles", datos,PlotOrientation.VERTICAL,true,true,false);
        grafico_barras.setBackgroundPaint(new Color(37,31,52));
        grafico_barras.getTitle().setPaint(new Color(255,255,255));
        ChartPanel panel=new ChartPanel(grafico_barras);
        controladorTiendaCaja.setPanelControladorProducto(panel,  new Dimension(516, 500)); 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        

    }    
}
