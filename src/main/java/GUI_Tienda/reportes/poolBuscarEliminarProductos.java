/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.reportes;

import GUI_Tienda.principal.*;
import GUI_Tienda.producto.gestionarProducto.*;
import GUILoading.Cargando;
import clases.Categoria;
import clases.Producto;
import clases.ProductoVendido;
import clasesJDBC.CategoriaJDBC;
import clasesJDBC.ProductoJDBC;
import clasesJDBC.VentaJDBC;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;
import javax.swing.JPanel;

/**
 *
 * @author fell
 */
public class poolBuscarEliminarProductos implements Callable<String> {

    
    private ControladorTiendaReportes controladorProductos;
    
    private HashMap<String, Producto> productosDefecto= new HashMap<String, Producto>();
    private HashMap<String, ProductoBuscadosVendido> contenedores= new HashMap<String, ProductoBuscadosVendido>();
  
    public poolBuscarEliminarProductos(ControladorTiendaReportes controladorProductos) {
        this.controladorProductos=controladorProductos;
   
    }
    
    @Override
    public String call() throws Exception {
        Cargando cargando= new Cargando();
        controladorProductos.setPanelControladorProducto(cargando,  new Dimension(516, 420));
        mostrarHorarios();
        return "poolBuscarProductos Terminado";
    }
    
    
    public void mostrarHorarios(){
        PanelProductosSub panelProductosTienda= new PanelProductosSub();
        int contador=0;
        ProductoJDBC productoBuscado= new ProductoJDBC();
        String idVenta=this.controladorProductos.getVentaSeleccionada().getIdVenta();
        ArrayList<Producto> productosBuscados=productoBuscado.buscarProductosVendidos(idVenta);
        ProductoJDBC productoBus= new ProductoJDBC();
        for(Producto pa:productosBuscados){
            productoBus.insertaProductoModificarCantidad(pa.getCodigoBarras(),pa.getCantidad());
        }
      
        productoBus.deleteAll(idVenta);
 

        controladorProductos.proceso("BuscarVentas");
        
    }
  
}
