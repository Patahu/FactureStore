/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.reportes;

import GUI_Tienda.caja.*;
import GUI_Tienda.ControladorTienda;
import clases.Producto;
import clases.Venta;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import javax.swing.JPanel;

/**
 *
 * @author fell
 */
public class ControladorTiendaReportes implements ActionListener {
    private ControladorTienda controladorTienda;
    private ExecutorCompletionService<String> exec;
    private volatile GestionarTiendaReportes gestionarTiendaCaja;
    private Venta ventaSeleccionada;
    private ArrayList<Producto> productosEliminar;
    public ControladorTiendaReportes(ControladorTienda controladorTienda) {
        this.controladorTienda = controladorTienda;
        this.exec=controladorTienda.getControladorPrincipal().getExec();
    }

    public GestionarTiendaReportes getGestionarTiendaCaja() {
        return gestionarTiendaCaja;
    }

    public void setGestionarTiendaCaja(GestionarTiendaReportes gestionarTiendaCaja) {
        this.gestionarTiendaCaja = gestionarTiendaCaja;
    }

    public Venta getVentaSeleccionada() {
        return ventaSeleccionada;
    }

    public void setVentaSeleccionada(Venta ventaSeleccionada) {
        this.ventaSeleccionada = ventaSeleccionada;
    }
    
    public void iniciar(){
        this.gestionarTiendaCaja= new GestionarTiendaReportes(this);
        this.gestionarTiendaCaja.cuadre.addActionListener(this);
        this.gestionarTiendaCaja.productosVendidos.addActionListener(this);
        this.gestionarTiendaCaja.buscar.addActionListener(this);
        this.gestionarTiendaCaja.ventasDia.addActionListener(this);
        this.gestionarTiendaCaja.historial.addActionListener(this);
        this.gestionarTiendaCaja.historialVentas.addActionListener(this);
        controladorTienda.setPanelControladorTienda(gestionarTiendaCaja,  new Dimension(1100,620)); 
        proceso("BuscarVentas");

    }
    
    public void proceso(String tipo){
        if(tipo.equals("BuscarVentas")){ // Operaciones o historial de ventas
            // La 0 en el comboBox es 1     
                         System.out.println("SOLICITADOOOOOOOOOOOOOOO");
            gestionarTiendaCaja.buscar.setActionCommand("buscarI");
            //Future<String> task1= exec.submit(new poolBuscarOperacionVentas(this)); 
            Future<String> task1= exec.submit(new poolBuscarOperacionVentasRango(this)); 
  
        }else if(tipo.equals("ventasDia")){ // precio total de vental por dia de la semana

            gestionarTiendaCaja.buscar.setActionCommand("buscarT");
            Future<String> task1= exec.submit(new poolGraficadia(this)); 
        }else if(tipo.equals("productosVendidos")){ // productos vendidos del dia
            gestionarTiendaCaja.buscar.setActionCommand("buscarP");
            Future<String> task1= exec.submit(new poolGraficaVentasDia(this)); 
        
        }else if(tipo.equals("buscarP")){ // Producto vendios total por rango
            if(gestionarTiendaCaja.activoNombre.isSelected() && gestionarTiendaCaja.activoRangoFecha.isSelected()){
                Future<String> task1= exec.submit(new poolGraficadiaRangoNombreVentas(this)); 
            }else if(gestionarTiendaCaja.activoNombre.isSelected()){
                //poolGraficadiaNombreVentas
                Future<String> task1= exec.submit(new poolGraficadiaNombreVentas(this)); 
            }else if(gestionarTiendaCaja.activoRangoFecha.isSelected()){
              Future<String> task1= exec.submit(new poolGraficaVentasRango(this)); 
            }else{
              Future<String> task1= exec.submit(new poolGraficaVentasDia(this)); 
            }
            

        }else if(tipo.equals("botonImprimir")){// imprimir cuadre o productos vendidos en el dia
          
            Future<String> task1= exec.submit(new poolCuadre(this)); //poolBuscarProducto
        }else if(tipo.equals("botonModificar")){// imprimir cuadre o productos vendidos en el dia
          
            Future<String> task1= exec.submit(new poolBuscarProducto(this)); //poolBuscarProducto
        }else if(tipo.equals("botonEliminar")){// imprimir cuadre o productos vendidos en el dia
           
            Future<String> task1= exec.submit(new poolBuscarEliminarProductos(this)); //poolBuscarProducto
        }else if(tipo.equals("buscarT")){ // grafico buscar nombre por dia de la semana
            if(gestionarTiendaCaja.activoNombre.isSelected() && gestionarTiendaCaja.activoRangoFecha.isSelected()){
               Future<String> task1= exec.submit(new poolGraficadiaRangoNombre(this)); 
            }else if(gestionarTiendaCaja.activoNombre.isSelected()){
        
                Future<String> task1= exec.submit(new poolGraficadiaNombre(this)); 
            }else if(gestionarTiendaCaja.activoRangoFecha.isSelected()){
                Future<String> task1= exec.submit(new poolGraficadiaRango(this)); 
            }else{
                Future<String> task1= exec.submit(new poolGraficadia(this)); 
            }
            
        }else if(tipo.equals("botonHistorial")){ // grafico historial de productos
            gestionarTiendaCaja.buscar.setActionCommand("buscarH");
            Future<String> task1= exec.submit(new poolGraficaProductoHistorial(this)); 
        }else if(tipo.equals("buscarH")){ // grafico buscar nombre por dia de la semana
            if(gestionarTiendaCaja.activoNombre.isSelected() && gestionarTiendaCaja.activoRangoFecha.isSelected()){
               Future<String> task1= exec.submit(new poolGraficaProductoHistorialRangoNombre(this)); 
            }else if(gestionarTiendaCaja.activoNombre.isSelected()){
        
                Future<String> task1= exec.submit(new poolGraficaProductoHistorialSoloNombre(this)); 
            }else if(gestionarTiendaCaja.activoRangoFecha.isSelected()){
                Future<String> task1= exec.submit(new poolGraficaProductoHistorialRango(this)); 
            }else{
                Future<String> task1= exec.submit(new poolGraficaProductoHistorial(this)); 
            }
            
        }else if(tipo.equals("buscarI")){ // grafico buscar nombre por dia de la semana
            if(gestionarTiendaCaja.activoNombre.isSelected() && gestionarTiendaCaja.activoRangoFecha.isSelected()){
               Future<String> task1= exec.submit(new poolBuscarOperacionVentasNombreRango(this)); 
            }else if(gestionarTiendaCaja.activoNombre.isSelected()){
        
                Future<String> task1= exec.submit(new poolBuscarOperacionVentasNombre(this)); 
            }else if(gestionarTiendaCaja.activoRangoFecha.isSelected()){
                Future<String> task1= exec.submit(new poolBuscarOperacionVentasRango(this)); 
            }else{
                Future<String> task1= exec.submit(new poolBuscarOperacionVentas(this)); 
            }
            
        }

    }
     public void setPanelControladorProducto(JPanel panel, Dimension dimension){
        Dimension dim= new Dimension(1100, 450);
        gestionarTiendaCaja.productosSub.removeAll();
        gestionarTiendaCaja.productosSub.setSize(dim);
        panel.setSize(dim);
       
    
        gestionarTiendaCaja.productosSub.add(panel,GridLayout.class);
        gestionarTiendaCaja.productosSub.revalidate();
        gestionarTiendaCaja.productosSub.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("cuadre")){
            proceso(e.getActionCommand());
        }else if(e.getActionCommand().equals("productosVendidos")){//productosVendidos
             proceso(e.getActionCommand());
        }else if(e.getActionCommand().equals("buscarP")){//productosVendidos
             proceso(e.getActionCommand());
        }else if(e.getActionCommand().equals("ventasDia")){//productosVendidos
             proceso(e.getActionCommand());
        }else if(e.getActionCommand().equals("buscarT")){//productosVendidos
             proceso(e.getActionCommand());
        }else if(e.getActionCommand().equals("botonHistorial")){//productosVendidos
             proceso(e.getActionCommand());
        }else if(e.getActionCommand().equals("buscarH")){//productosVendidos
             proceso(e.getActionCommand());
        }else if(e.getActionCommand().equals("buscarI")){//productosVendidos
             proceso(e.getActionCommand());
        }else if(e.getActionCommand().equals("historialVentas")){//productosVendidos
             proceso("BuscarVentas");
        }
       //historialVentas

    }
}
