/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.principal;

import GUI_Tienda.ControladorTienda;

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
public class ControladorTiendaPrincipal implements ActionListener {
    private ControladorTienda controladorTienda;
    private ExecutorCompletionService<String> exec;
    private volatile GestionarTiendaPrincipal gestionarTiendaPrincipal;
    private Producto productoSeleccionado;
    private HashMap<String, ProductoVendido> productosVender= new HashMap<String, ProductoVendido>();
    private HashMap<String, PanelProductoVender> contenedoresVender= new HashMap<String, PanelProductoVender>();
    private Usuario usuario;
    private PanelEgresoIngreso panelEgresoIngreso;
    private String tipo="";
    public ControladorTiendaPrincipal(ControladorTienda controladorTienda,Usuario usuario) {
        this.controladorTienda=controladorTienda;
        this.exec=controladorTienda.getControladorPrincipal().getExec();
        this.usuario=usuario;
        panelEgresoIngreso=new PanelEgresoIngreso(this);
  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("cambioText")){
            proceso("cambioText");
  
        }else if(e.getActionCommand().equals("cambioRecalcular")){
            proceso("cambioRecalcular");//recalcularTodo
        }else if(e.getActionCommand().equals("recalcularTodo")){
            hacerSeleccionTodos();
            proceso("cambioRecalcular");//recalcularTodo
        }else if(e.getActionCommand().equals("Vender")){
            proceso("Vender");
    
        }else if(e.getActionCommand().equals("ingresarCodigoBarras")){
            proceso("ingresarCodigoBarras");
        }else if(e.getActionCommand().equals("Egreso")){
            proceso("Egreso");
        }else if(e.getActionCommand().equals("Ingreso")){
            proceso("Ingreso");
        }else if(e.getActionCommand().equals("ingresarEgresoIngreso")){
            proceso("ingresarEgresoIngreso");
        }
        
        
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public HashMap<String, ProductoVendido> getProductosVender() {
    
        return productosVender;
    }
    
    public double getPrecioVoucher(){
        double precioTotal=0;
        for (HashMap.Entry<String, ProductoVendido> entry : productosVender.entrySet()) {
            precioTotal=precioTotal+entry.getValue().getPrecioTotal();
        }
     
        return precioTotal;
    }
    private void hacerSeleccionTodos(){
       boolean valor=gestionarTiendaPrincipal.todosSelected.isSelected();
       contenedoresVender.values().forEach(tab -> {
            tab.seleccion.setSelected(valor);
       });
    }

    public HashMap<String, PanelProductoVender> getContenedoresVender() {
        return contenedoresVender;
    }
    public void setProducto( ProductoVendido productosVender) {
        this.productosVender.put(""+this.productosVender.size(),productosVender);
       
        proceso("BotonIngresarProducto");
    }
    public void setProductosVender(HashMap<String, ProductoVendido> productosVender) {
        this.productosVender = productosVender;
    }

    public void setContenedoresVender(HashMap<String, PanelProductoVender> contenedoresVender) {
        this.contenedoresVender = contenedoresVender;
    }


    public void proceso(String tipo){
        if(tipo.equals("BuscarProductos")){
            // La 0 en el comboBox es 1    
            Future<String> task1= exec.submit(new poolBuscarCategoria(this)); 
            Future<String> task2= exec.submit(new poolBuscarProducto(this)); 
  
        }else if(tipo.equals("cambioText")){
            if(gestionarTiendaPrincipal.categori.isSelected()){
               
                Future<String> task1= exec.submit(new poolBuscarProductoNombreCategoria(this)); 
            }else{
                Future<String> task1= exec.submit(new poolBuscarProductoNombre(this)); 
            }
            
        }else if(tipo.equals("BotonIngresarProducto") ){
           String poner=String.format("%.2f",getPrecioVoucher());
           this.gestionarTiendaPrincipal.totalPrecio.setText(poner);
            Future<String> task1= exec.submit(new poolRecalcularProductoVender(this)); 
        
            
        }else if(tipo.equals("Vender")){
            Future<String> task1= exec.submit(new poolIngresarVenda(this)); 
        
        }else if(tipo.equals("cambioRecalcular")){
         
            Future<String> task1= exec.submit(new poolRecalculoPrecio(this)); 

        }else if(tipo.equals("ingresarCodigoBarras")){
          
            Future<String> task1= exec.submit(new poolbuscarProductoBarras(this,gestionarTiendaPrincipal.codigoBarras.getText())); 
            gestionarTiendaPrincipal.codigoBarras.setText("");
        }else if(tipo.equals("Egreso")){
            this.tipo="Egreso";
            panelEgresoIngreso=new PanelEgresoIngreso(this);
            panelEgresoIngreso.tipo.setText(this.tipo);
    
            setPanelControladorProducto(panelEgresoIngreso,new Dimension(516, 420));
        }else if(tipo.equals("Ingreso")){
            this.tipo="Ingreso";
            panelEgresoIngreso=new PanelEgresoIngreso(this);
            panelEgresoIngreso.tipo.setText(this.tipo);
           
            setPanelControladorProducto(panelEgresoIngreso,new Dimension(516, 420));
        }if(tipo.equals("ingresarEgresoIngreso")){
            
            Future<String> task1= exec.submit(new poolIngresarOperacionCaja(this)); 
            

        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public PanelEgresoIngreso getPanelEgresoIngreso() {
        return panelEgresoIngreso;
    }

    public void setPanelEgresoIngreso(PanelEgresoIngreso panelEgresoIngreso) {
        this.panelEgresoIngreso = panelEgresoIngreso;
    }
    
    public void iniciar(){
        this.gestionarTiendaPrincipal= new GestionarTiendaPrincipal(this);
        this.gestionarTiendaPrincipal.vender.addActionListener(this);
        this.gestionarTiendaPrincipal.jButton2.addActionListener(this);
        this.gestionarTiendaPrincipal.egreso.addActionListener(this);
        this.gestionarTiendaPrincipal.ingreso.addActionListener(this);
        continuar();
    }
    public void continuar(){
        controladorTienda.setPanelControladorTienda(gestionarTiendaPrincipal,  new Dimension(1100,620)); 
        if(gestionarTiendaPrincipal.cambioTexto.getText().isEmpty()){
            proceso("BuscarProductos");
        }else{
            proceso("cambioText");
        }
        
    }

 
    
    public Producto getProductoSeleccionado() {
        return productoSeleccionado;
    }
    public void setProductoSeleccionado(Producto productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }
    public void setPanelControladorProducto(JPanel panel, Dimension dimension){
        gestionarTiendaPrincipal.productosSub.removeAll();

        gestionarTiendaPrincipal.productosSub.setSize(dimension);
        panel.setSize(dimension);
        gestionarTiendaPrincipal.productosSub.add(panel,GridLayout.class);
        gestionarTiendaPrincipal.productosSub.revalidate();
        gestionarTiendaPrincipal.productosSub.repaint();
    }
    public void setPanelVenderProducto(JPanel panel, Dimension dimension){
        gestionarTiendaPrincipal.productosVender.removeAll();
   
        gestionarTiendaPrincipal.productosVender.setSize(dimension);
        panel.setSize(dimension);
        
        
        gestionarTiendaPrincipal.productosVender.add(panel,GridLayout.class);
        gestionarTiendaPrincipal.productosVender.revalidate();
        gestionarTiendaPrincipal.productosVender.repaint();
    }

    public GestionarTiendaPrincipal getGestionarTiendaPrincipal() {
        return gestionarTiendaPrincipal;
    }
   
}
