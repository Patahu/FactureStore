/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIingresarProductoFacturaBoleta;

import GUI_Tienda.principal.*;
import GUI_Tienda.producto.gestionarProducto.*;
import GUILoading.Cargando;
import clases.Categoria;
import clases.Producto;
import clases.ProductoVendido;
import clasesJDBC.CategoriaJDBC;
import clasesJDBC.ProductoJDBC;
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
public class poolBuscarProductoNombre implements Callable<String>,ActionListener {

    
    private ControladorFacturaBoleta controladorProductos;
    
    private HashMap<String, Producto> productosDefecto= new HashMap<String, Producto>();
    private HashMap<String, ProductoBuscados> contenedores= new HashMap<String, ProductoBuscados>();
    private PanelProductosSub panelProductosTienda;
    public poolBuscarProductoNombre(ControladorFacturaBoleta controladorProductos) {
        this.controladorProductos=controladorProductos;
   
    }
    
    @Override
    public String call() throws Exception {
        Cargando cargando= new Cargando();
        controladorProductos.setPanelControladorProducto(cargando,  new Dimension(516, 500));
        mostrarHorarios();
        return "poolBuscarProductos Terminado";
    }
    
    
    public void mostrarHorarios(){
        panelProductosTienda= new PanelProductosSub();
        int contador=0;
        ProductoJDBC productoBuscado= new ProductoJDBC();

        String nombreBuscar=controladorProductos.getGestionarTiendaPrincipal().cambioTexto.getText();
        ArrayList<Producto> productosBuscados=productoBuscado.buscarProductosNombre(nombreBuscar);

        PanelProductosSubFactura panelProductosSubFactura= new PanelProductosSubFactura();
        CategoriaJDBC caterogiraJDBC= new CategoriaJDBC();
        HashMap<Integer, Categoria> productosDefecto= new HashMap<Integer, Categoria>();
        for(Categoria a: caterogiraJDBC.buscarCategoriasTodos()){
            productosDefecto.put(a.getIdCategoria(),a);
        }


        for(Producto pa: productosBuscados){
            
            String indice=""+contador;

            ProductoBuscados c=new ProductoBuscados(pa.getCantidadMinima()>pa.getCantidad());   
            c.setBackground(new Color(37,31,52));
            c.ingresar.setActionCommand("BotonIngresarProducto,"+indice);
            c.ingresar.addActionListener(this);
   

            contenedores.put(indice,c);
            c.precioSub.setText("S/ "+pa.getPrecioSalida());
            c.nombreSub.setText(""+pa.getNombre());
            c.stock.setText(""+pa.getCantidad());
            this.productosDefecto.put(indice, pa);
            contador++;
            panelProductosSubFactura.productosSub.add(c,0);
            panelProductosSubFactura.productosSub.updateUI();
        }
        controladorProductos.setPanelControladorProducto(panelProductosSubFactura,  new Dimension(516, 500));       
        

         
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String evento[]= e.getActionCommand().split(",");
        System.out.println(" Evento ----"+evento[0]);
        if(evento[0].equals("BotonIngresarProducto")){
            String id= evento[1];
            //double actual=productosDefecto.get(id).getCantidad()-1.0;
            //productosDefecto.get(id).setCantidad(actual);
            //contenedores.get(id).stock.setText(""+actual);
            controladorProductos.setProducto(new ProductoVendido(productosDefecto.get(id),1));
  
           
        }
    }    
    

}
