/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Tienda.principal;

import clases.Caja;
import clases.ProductoVendido;
import clases.Venta;
import clasesJDBC.CajaJDBC;
import clasesJDBC.OperacionCajaJDBC;
import clasesJDBC.ProductoVendidoJDBC;
import clasesJDBC.VentaJDBC;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.time.Year;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import tickets.Impresor;
import tickets.ImprimirVenta;

/**
 *
 * @author fell
 */
public class poolIngresarOperacionCaja implements Callable<String>{
    private ControladorTiendaPrincipal controladorProductos;
 
    public poolIngresarOperacionCaja(ControladorTiendaPrincipal controladorProductos) {
        this.controladorProductos=controladorProductos;

    }
    
    @Override
    public String call() throws Exception {
        mostrarHorarios();
        return "poolIngresoOperacionCaja Terminado";
    }
    
    
    public void mostrarHorarios(){
        OperacionCajaJDBC operacion=new OperacionCajaJDBC();
        double cantida=Double.valueOf(controladorProductos.getPanelEgresoIngreso().cantidad.getText());
        String razon=controladorProductos.getPanelEgresoIngreso().razon.getText();
        Date dato=new Date();
        String idOperacion=controladorProductos.getUsuario().getIdUsuario()+""+dato.getTime();
        String nombreUsuario=controladorProductos.getUsuario().getNombreUsuario();
        String tipo=controladorProductos.getTipo();//insertaOperacionProducto
        if(tipo.equals("Egreso")){
            cantida=cantida*(-1);
        }
        operacion.insertaOperacionProducto(idOperacion,nombreUsuario,tipo,cantida,razon);
       JOptionPane.showMessageDialog(null, tipo+" ingresado");
    }


   
}

