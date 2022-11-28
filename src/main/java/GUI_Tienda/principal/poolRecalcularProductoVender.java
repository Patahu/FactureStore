/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.principal;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author fell
 */
public class poolRecalcularProductoVender implements Callable<String>,ActionListener{

   private ControladorTiendaPrincipal controladorProductos;
    
    private HashMap<String, ProductoVendido> productosDefecto= new HashMap<String, ProductoVendido>();
    private HashMap<String, PanelProductoVender> contenedores= new HashMap<String, PanelProductoVender>();

    public poolRecalcularProductoVender(ControladorTiendaPrincipal controladorProductos) {
        this.controladorProductos=controladorProductos;
   
    }
    
    @Override
    public String call() throws Exception {
        Cargando cargando= new Cargando();
        controladorProductos.setPanelVenderProducto(cargando,  new Dimension(536, 475));
        try{
                  mostrarHorarios();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Hello World");
                System.out.println("ERROR HILO--------------------------------------------------------------------------------");
        }

        return "poolBuscarProductos Terminado";
    }
    
    
    public void mostrarHorarios() {
        PanelProductosVender panelProductosVender= new PanelProductosVender();
        int contador=0;
        HashMap<String, ProductoVendido> valores=controladorProductos.getProductosVender();
        ArrayList<ProductoVendido> productosBuscados=new ArrayList<ProductoVendido>();
        valores.values().forEach(tab -> {
            productosBuscados.add(tab);
       });
        
        
        
        
        HashMap<String, PanelProductoVender> panelesVender=controladorProductos.getContenedoresVender();
        ArrayList<String> productosBuscadosContenedores=new ArrayList<String>();
        valores.keySet().forEach(ta -> {
         productosBuscadosContenedores.add(ta);
        });
        /*if(panelesVender.size()<6){
            for(int a=0;a<6;a++){
                JPanel pane=new javax.swing.JPanel();
                pane.setBackground(new Color(37,31,52));
                panelProductosVender.productosVen.add(pane,0);
                panelProductosVender.productosVen.updateUI();
            }
        }*/

        System.out.println(" producto "+(productosBuscados.size()));
        
        for(int n=0;n<valores.size();n++){
            String indice=""+contador;
            ProductoVendido pa=productosBuscados.get(n);
            PanelProductoVender c=new PanelProductoVender(pa.getCantidadMinima()>pa.getCantidad(),pa.getUnidad(),controladorProductos,contador,pa);   
            c.botonEliminar.setActionCommand("eliminar,"+indice);
            c.botonEliminar.addActionListener(this);
            c.codigoBarras.setText(""+pa.getCodigoBarras());
            contenedores.put(indice,c);
            productosDefecto.put(indice, pa);
            c.precioProducto.setText("S/ "+pa.getPrecioSalida());
            c.nombreProducto.setText(""+pa.getNombre());
            Double cantidadd=pa.getCantidadVendida();

       
            
            String precioTotalunitario=String.format("%.2f",pa.getPrecioSalida()*cantidadd);
            c.precioTotal.setText(precioTotalunitario);

            contador++;
            panelProductosVender.productosVen.add(c,0);
            panelProductosVender.productosVen.updateUI();
        }

        controladorProductos.setContenedoresVender(contenedores);
        controladorProductos.setProductosVender(productosDefecto);
   



        controladorProductos.setPanelVenderProducto(panelProductosVender,  new Dimension(536, 475));
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        String evento[]= e.getActionCommand().split(",");

        if(evento[0].equals("eliminar")){
            String id= evento[1];
            controladorProductos.getProductosVender().remove(id);
            controladorProductos.getContenedoresVender().remove(id);
            controladorProductos.proceso("BotonIngresarProducto");
            
        }
    }    
    
    
}
