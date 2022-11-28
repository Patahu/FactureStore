/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIingresarProductoFacturaBoleta;

import GUI_Tienda.principal.*;
import GUI_Tienda.ControladorTienda;
import GUI_Tienda.producto.ControladorTiendaProducto;
import clases.OperacionProducto;

import clases.Producto;
import clases.ProductoVendido;
import clases.Usuario;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import javax.swing.JPanel;


/**
 *
 * @author fell
 */
public class ControladorFacturaBoleta implements ActionListener {
    private ControladorTiendaProducto controladorTiendaProducto;
    private ExecutorCompletionService<String> exec;
    private volatile GestionarProductoFactura gestionarProductoFactura;
    private volatile PanelProductosFacturaBoleta panelProductosFacturaBoleta;
    private volatile GestionarProductosFacturasBoletas gestionarProductosFacturasBoletas;
    private Producto productoSeleccionado;
    private OperacionProducto operacionProducto;
    private HashMap<String, Producto> productoIngresarFactura= new HashMap<String, Producto>();
    private HashMap<String, PanelProductoIngresar> contenedoresIngresarFactura= new HashMap<String, PanelProductoIngresar>();
    private Usuario usuario;
    public ControladorFacturaBoleta(ControladorTiendaProducto controladorTiendaProducto,Usuario usuario) {
        this.controladorTiendaProducto=controladorTiendaProducto;
        this.exec=controladorTiendaProducto.getControladorTienda().getControladorPrincipal().getExec();
        this.usuario=usuario;
 
   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("cambioText")){
            proceso("cambioText");
  
        }else if(e.getActionCommand().equals("cambioRecalcular")){
            proceso("cambioRecalcular");//recalcularTodo
        }else if(e.getActionCommand().equals("ingresarOperacion")){
            proceso("ingresarOperacion");
    
        }else if(e.getActionCommand().equals("ingresarCodigoBarras")){
            proceso("ingresarCodigoBarras");
        }else if(e.getActionCommand().equals("ingresarFactura")){
            proceso("ingresarFactura");
        }
        //ingresarFactura
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public HashMap<String, Producto> getProductosIngresar() {
    
        return productoIngresarFactura;
    }
    
    public double getPrecioVoucher(){
        double precioTotal=0;
        for(Producto value : productoIngresarFactura.values()) {
            precioTotal+=value.getPrecioEntrada()*value.getCantidad();
        }
        return precioTotal;
    }


    public HashMap<String, PanelProductoIngresar> getContenedoresVender() {
        return contenedoresIngresarFactura;
    }
    public void setProducto( Producto producto) {

        this.productoIngresarFactura.put(""+this.productoIngresarFactura.size(),producto);
       
        proceso("BotonIngresarProducto");
    }
    public void setProductosVender(HashMap<String, Producto> productosVender) {
        this.productoIngresarFactura = productosVender;
    }

    public void setContenedoresVender(HashMap<String, PanelProductoIngresar> contenedoresVender) {
        this.contenedoresIngresarFactura = contenedoresVender;
    }


    public void proceso(String tipo){
        if(tipo.equals("BuscarProductos")){
            // La 0 en el comboBox es 1     
            Future<String> task1= exec.submit(new poolBuscarProductoFactura(this)); 
  
        }else if(tipo.equals("cambioText")){
            Future<String> task1= exec.submit(new poolBuscarProductoNombre(this)); 
        }else if(tipo.equals("BotonIngresarProducto") ){
            Future<String> task1= exec.submit(new poolRecalcularProductoIngresar(this)); 
        }else if(tipo.equals("ingresarOperacion")){
            Future<String> task1= exec.submit(new poolIngresarOperacionTodo(this)); 
        
        }else if(tipo.equals("cambioRecalcular")){
            //Future<String> task1= exec.submit(new poolRecalculoPrecio(this)); 
        }else if(tipo.equals("BuscarFacturasBoletas")){
            this.panelProductosFacturaBoleta=new PanelProductosFacturaBoleta();
            Future<String> task1= exec.submit(new poolBuscarGestionarFactura(this)); 
      
        }else if(tipo.equals("ingresarFactura")){
            
            this.gestionarProductoFactura= new GestionarProductoFactura(this);
            this.gestionarProductoFactura.Ingresar.addActionListener(this);
            controladorTiendaProducto.setPanelControladorTiendaProducto(gestionarProductoFactura,  new Dimension(1100,620)); 
            proceso("BuscarProductos");
            //Future<String> task1= exec.submit(new poolbuscarProductoBarras(this,gestionarTiendaPrincipal.codigoBarras.getText())); 
        }else if(tipo.equals("vistaFactura")){
            //Future<String> task1= exec.submit(new poolRecalculoPrecio(this)); 
                        
            this.gestionarProductoFactura= new GestionarProductoFactura(this);
            //this.gestionarProductoFactura.Ingresar.addActionListener(this);
            this.gestionarProductoFactura.Ingresar.setVisible(false);
            this.gestionarProductoFactura.jPanel4.setVisible(false);
            controladorTiendaProducto.setPanelControladorTiendaProducto(gestionarProductoFactura,  new Dimension(1100,620)); 
            Future<String> task1= exec.submit(new poolRecalcularProductoVisualizar(this)); 

        }
    }
    public void iniciar(){

        this.gestionarProductosFacturasBoletas=new GestionarProductosFacturasBoletas(this);
        this.gestionarProductosFacturasBoletas.ingresarProducto.addActionListener(this);
        continuar();
    }
    public void continuar(){
        controladorTiendaProducto.setPanelControladorTiendaProducto(gestionarProductosFacturasBoletas,  new Dimension(1100,620)); 
        proceso("BuscarFacturasBoletas");
        /*}else{
            proceso("cambioText");
        }*/
        
    }

 
    
    public Producto getProductoSeleccionado() {
        return productoSeleccionado;
    }
    public void setProductoSeleccionado(Producto productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

    public void setOperacionProducto(OperacionProducto operacionProducto) {
        this.operacionProducto = operacionProducto;
    }

    public OperacionProducto getOperacionProducto() {
        return operacionProducto;
    }
    
    public void setPanelControladorProducto(JPanel panel, Dimension dimension){
        gestionarProductoFactura.productosSub.removeAll();
        gestionarProductoFactura.productosSub.setSize(dimension);
        panel.setSize(dimension);
        
    
        gestionarProductoFactura.productosSub.add(panel,GridLayout.class);
        gestionarProductoFactura.productosSub.revalidate();
        gestionarProductoFactura.productosSub.repaint();
    }
    public void setPanelControladorProductoFuera(JPanel panel, Dimension dimension){
        panelProductosFacturaBoleta.panelD.removeAll();
        panelProductosFacturaBoleta.panelD.setSize(dimension);
        panel.setSize(dimension);
        
    
        panelProductosFacturaBoleta.panelD.add(panel,GridLayout.class);
        panelProductosFacturaBoleta.panelD.revalidate();
        panelProductosFacturaBoleta.panelD.repaint();
    }
    public void setPanelVenderProducto(JPanel panel, Dimension dimension){
        gestionarProductoFactura.productosIngresarFacturar.removeAll();
        gestionarProductoFactura.productosIngresarFacturar.setSize(dimension);
        panel.setSize(dimension);
        
  
        gestionarProductoFactura.productosIngresarFacturar.add(panel,GridLayout.class);
        gestionarProductoFactura.productosIngresarFacturar.revalidate();
        gestionarProductoFactura.productosIngresarFacturar.repaint();
    }

    public GestionarProductoFactura getGestionarTiendaPrincipal() {
        return gestionarProductoFactura;
    }
       
    public void setPanelControladorFactura(JPanel panel, Dimension dimension){
        gestionarProductosFacturasBoletas.aquiHor.removeAll();
        gestionarProductosFacturasBoletas.aquiHor.setSize(dimension);
        panel.setSize(dimension);
        
    
        gestionarProductosFacturasBoletas.aquiHor.add(panel,GridLayout.class);
        gestionarProductosFacturasBoletas.aquiHor.revalidate();
        gestionarProductosFacturasBoletas.aquiHor.repaint();
    }
}
