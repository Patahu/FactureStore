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
import clases.Cuadre;
import clases.Producto;
import clases.ProductoVendido;
import clasesJDBC.CategoriaJDBC;
import clasesJDBC.CuadreJDBC;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import tickets.Impresor;
import tickets.ImprimirCuadre;
import tickets.ImprimirEgresoIngreso;

/**
 *
 * @author fell
 */
public class poolProductosVenta implements Callable<String>{


    private ControladorTiendaReportes controladorTiendaReportes;
    public poolProductosVenta(ControladorTiendaReportes controladorTiendaReportes) {
        this.controladorTiendaReportes=controladorTiendaReportes;
   
    }
    
    @Override
    public String call() throws Exception {
        mostrarHorarios();
        return "poolBuscarProductos Terminado";
    }
    
    
    public void mostrarHorarios(){
        
  
        CuadreJDBC productoBuscado= new CuadreJDBC();

        String idVentaBuscada=controladorTiendaReportes.getVentaSeleccionada().getIdVenta();
        ArrayList<Cuadre> productosBuscados=productoBuscado.buscarProductosVentas(idVentaBuscada);

    }
 
}
