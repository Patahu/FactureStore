/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIingresarProductoFacturaBoleta;

import GUI_Tienda.producto.gestionarProducto.*;
import GUILoading.Cargando;
import clases.Categoria;
import clases.OperacionProducto;
import clases.Producto;
import clasesJDBC.CategoriaJDBC;
import clasesJDBC.OperacionProductoJDBC;
import clasesJDBC.ProductoJDBC;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;

/**
 *
 * @author fell
 */
public class poolBuscarGestionarFactura implements Callable<String>,ActionListener {

    
    private ControladorFacturaBoleta controladorFacturaBoleta;
    
    private HashMap<String, OperacionProducto> productosDefecto= new HashMap<String, OperacionProducto>();
    private HashMap<String, PanelTiendaFactura> contenedores= new HashMap<String, PanelTiendaFactura>();
    private PanelProductosFacturaBoleta panelProductosTienda;
    public poolBuscarGestionarFactura(ControladorFacturaBoleta controladorFacturaBoleta) {
        this.controladorFacturaBoleta=controladorFacturaBoleta;
     
    }
    
    @Override
    public String call() throws Exception {
        Cargando cargando= new Cargando();
        System.out.println("Comenzandooooooooooo---------------1");
        controladorFacturaBoleta.setPanelControladorFactura(cargando,new Dimension(850,450));
        System.out.println("Comenzandooooooooooo---------------2");
        mostrarHorarios();
        return "poolBuscarProductos Terminado";
    }
    
    
    public void mostrarHorarios(){
        System.out.println("Comenzandooooooooooo");
        PanelProductosFacturaBoleta panelProductosTienda= new PanelProductosFacturaBoleta();
        int contador=0;
        OperacionProductoJDBC productoBuscado= new OperacionProductoJDBC();
  

        ArrayList<OperacionProducto> productosBuscados=productoBuscado.buscarFacturas();

        for(OperacionProducto pa: productosBuscados){
            
            String indice=""+contador;

            PanelTiendaFactura c=new PanelTiendaFactura();   
      
            c.botonModificar.setActionCommand("vistaFactura,"+indice);
      
            c.botonModificar.addActionListener(this);

            contenedores.put(indice,c);
            c.operacion.setText(""+pa.getIdOperacionProducto());
            c.usuario.setText(""+pa.getIdUsuario());
            c.precioTotal.setText(""+pa.getPrecioTotal());
            c.serie.setText(""+pa.getNumeroSerie());
            //c.precioCompra.setText(""+pa.getPrecioEntrada());
            //c.categoria.setText(""+productosDefecto.get(pa.getIdCategoria()).getNombre());
            //c.unidades.setText(""+pa.getUnidad());
            //c.precioCompra.setText(""+pa.getPrecioEntrada());
            c.variante.setText(""+pa.getTipo());
            c.fechaCreacion.setText(""+pa.getFechaCreacion());
            this.productosDefecto.put(indice, pa);
            contador++;
            panelProductosTienda.panelD.add(c,0);
            panelProductosTienda.panelD.updateUI();
        }
        
        controladorFacturaBoleta.setPanelControladorFactura(panelProductosTienda,  new Dimension(850,450));

         
        
    }
    public void eliminarHorarios(String id){
        controladorFacturaBoleta.setOperacionProducto(productosDefecto.get(id));
        panelProductosTienda.panelD.remove(contenedores.get(id));
        contenedores.remove(id);
        productosDefecto.remove(id);
        panelProductosTienda.panelD.updateUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String evento[]= e.getActionCommand().split(",");
        System.out.println(" Evento"+evento[0]);
        if(evento[0].equals("vistaFactura")){
            String id= evento[1];
            controladorFacturaBoleta.setOperacionProducto(productosDefecto.get(id));
            controladorFacturaBoleta.proceso("vistaFactura");
            System.out.println(" vistaFactura "+id);
        
        }
    }    
    

}
