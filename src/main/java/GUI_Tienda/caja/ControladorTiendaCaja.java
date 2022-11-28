/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.caja;

import GUI_Tienda.ControladorTienda;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import javax.swing.JPanel;

/**
 *
 * @author fell
 */
public class ControladorTiendaCaja implements ActionListener {
    private ControladorTienda controladorTienda;
    private ExecutorCompletionService<String> exec;
    private volatile GestionarTiendaCaja gestionarTiendaCaja;

    public ControladorTiendaCaja(ControladorTienda controladorTienda) {
        this.controladorTienda = controladorTienda;
        this.exec=controladorTienda.getControladorPrincipal().getExec();
    }
    
    public void iniciar(){
        this.gestionarTiendaCaja= new GestionarTiendaCaja(this);
        this.gestionarTiendaCaja.egreso.addActionListener(this);
        controladorTienda.setPanelControladorTienda(gestionarTiendaCaja,  new Dimension(1100,620)); 
        proceso("BuscarProductos");

    }

    public GestionarTiendaCaja getGestionarTiendaCaja() {
        return gestionarTiendaCaja;
    }
    
    
    public void proceso(String tipo){
        if(tipo.equals("BuscarProductos")){
            // La 0 en el comboBox es 1     
            Future<String> task1= exec.submit(new poolBuscarOperacionCaja(this)); 
        }else if(tipo.equals("cambioText")){
            Future<String> task1= exec.submit(new poolBuscarOperacionCajaId(this)); 
        }else if(tipo.equals("BotonIngresarProducto") ){
           //String poner=String.format("%.2f",getPrecioVoucher());
           //this.gestionarTiendaPrincipal.totalPrecio.setText(poner);
            //Future<String> task1= exec.submit(new poolRecalcularProductoVender(this)); 
        
            
        }else if(tipo.equals("Vender")){
            //Future<String> task1= exec.submit(new poolIngresarVenda(this)); 
        
        }else if(tipo.equals("cambioRecalcular")){
         
            //Future<String> task1= exec.submit(new poolRecalculoPrecio(this)); 

        }else if(tipo.equals("ingresarCodigoBarras")){
          
            //Future<String> task1= exec.submit(new poolbuscarProductoBarras(this,gestionarTiendaPrincipal.codigoBarras.getText())); 
        }
    }
     public void setPanelControladorProducto(JPanel panel, Dimension dimension){
        gestionarTiendaCaja.productosSub.removeAll();
        gestionarTiendaCaja.productosSub.setSize(dimension);
        panel.setSize(dimension);
      
    
        gestionarTiendaCaja.productosSub.add(panel,GridLayout.class);
        gestionarTiendaCaja.productosSub.revalidate();
        gestionarTiendaCaja.productosSub.repaint();
    }
     public void setPanelControladoregreseIngreso(JPanel panel, Dimension dimension){
        gestionarTiendaCaja.egreseIngreso.removeAll();
        gestionarTiendaCaja.egreseIngreso.setSize(dimension);
        panel.setSize(dimension);  
        gestionarTiendaCaja.egreseIngreso.add(panel,GridLayout.class);
        gestionarTiendaCaja.egreseIngreso.revalidate();
        gestionarTiendaCaja.egreseIngreso.repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("cambioText")){
                   proceso("cambioText");

        }
    }
}
