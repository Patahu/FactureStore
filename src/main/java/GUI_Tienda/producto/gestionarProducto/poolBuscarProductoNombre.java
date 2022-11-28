/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.producto.gestionarProducto;

import GUILoading.Cargando;
import clases.Producto;
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
public class poolBuscarProductoNombre implements Callable<String>,ActionListener{
    
    private ControladorProducto controladorProductos;
    
    private HashMap<String, Producto> productosDefecto= new HashMap<String, Producto>();
    private HashMap<String, PanelTiendaProducto> contenedores= new HashMap<String, PanelTiendaProducto>();
    private PanelProductosTienda panelProductosTienda;
    public poolBuscarProductoNombre(ControladorProducto controladorProductos) {
        this.controladorProductos=controladorProductos;
    }
    
    @Override
    public String call() throws Exception {
        Cargando cargando= new Cargando();
        controladorProductos.setPanelControladorProducto(cargando,new Dimension(850,450));

        mostrarHorarios();
        return "poolBuscarProductos Terminado";
    }
    
    
    public void mostrarHorarios(){

        panelProductosTienda= new PanelProductosTienda();
        int contador=0;
        ProductoJDBC productoBuscado= new ProductoJDBC();
        String nombreBuscar=controladorProductos.getGestionarProductos().cambioText.getText();
        ArrayList<Producto> productosBuscados=productoBuscado.buscarProductosNombre(nombreBuscar);
        for(int a=0;a<2;a++){
            panelProductosTienda.panelD.add(new javax.swing.JPanel(),0);
            panelProductosTienda.panelD.updateUI();
        }
        for(Producto pa: productosBuscados){
            
            String indice=""+contador;

            PanelTiendaProducto c=new PanelTiendaProducto();   
            c.botonEliminar.setActionCommand("BotonEliminar,"+indice);
            c.botonModificar.setActionCommand("BotonModificar,"+indice);
            c.botonEliminar.addActionListener(this);
            c.botonModificar.addActionListener(this);
          
            contenedores.put(indice,c);
            c.codigoBarras.setText(""+pa.getCodigoBarras());
            c.nombreProducto.setText(""+pa.getNombre());
            c.precioSalida.setText(""+pa.getPrecioSalida());
            c.precioCompra.setText(""+pa.getPrecioEntrada());
            c.categoria.setText(""+pa.getIdProducto());
            c.unidades.setText(""+pa.getUnidad());
            c.precioCompra.setText(""+pa.getPrecioEntrada());
            c.variante.setText(""+pa.getIdVariante());
            c.fechaCreacion.setText(""+pa.getFechaCreacion());
            this.productosDefecto.put(indice, pa);
            contador++;
            panelProductosTienda.panelD.add(c,0);
            panelProductosTienda.panelD.updateUI();
        }
        
        controladorProductos.setPanelControladorProducto(panelProductosTienda,  new Dimension(850,450));

         
        
    }
    public void eliminarProductos(String id){
        controladorProductos.setProductoSeleccionado(productosDefecto.get(id));
        panelProductosTienda.panelD.remove(contenedores.get(id));
        contenedores.remove(id);
        productosDefecto.remove(id);
        panelProductosTienda.panelD.updateUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String evento[]= e.getActionCommand().split(",");
        System.out.println(" Evento"+evento[0]);
        if(evento[0].equals("BotonEliminar")){
            String id= evento[1];
            controladorProductos.setProductoSeleccionado(productosDefecto.get(id));
            controladorProductos.proceso("Eliminar Producto");
            System.out.println(" ELIMINAR "+ id);
        }else if(evento[0].equals("BotonModificar")){
            String id= evento[1];
            controladorProductos.setProductoSeleccionado(productosDefecto.get(id));
            controladorProductos.proceso("ingresarModificar");
            System.out.println(" MODIFICAR "+id);
        
        }
    }    
     
}
