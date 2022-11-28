/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author fell
 */
public class ProductoVendido extends Producto{
    private double precioVendido=0;
    private double cantidadVendida=0;
    private double precioTotal=0.0;
    private String idVenta="";
    private Date fechaVenta;
    public ProductoVendido(){}
    public ProductoVendido(Producto producto,
            double cantidadVendida

            ) {
        super(producto.getIdProducto(), 
                producto.getCodigoBarras(), 
                producto.getPrecioEntrada(), 
                producto.getPrecioSalida(), 
                producto.getUnidad(), 
                producto.getFechaCreacion(), 
                producto.getIdCategoria(),
                producto.getIdVariante(),
                producto.getNombre(),
                producto.getCantidad(),
                producto.getCantidadMinima()
                );
        this.cantidadVendida = cantidadVendida;
   
        this.precioTotal=cantidadVendida*producto.getPrecioSalida();
        this.precioVendido=producto.getPrecioSalida();//(producto.getPrecioSalida()-producto.getPrecioEntrada())*cantidadVendida;

    }

    public ProductoVendido(String nombre,double cantidadVendida,String categoria) {
        super(nombre);
        this.cantidadVendida=cantidadVendida;
        this.idVenta=categoria;

    }

    public static ProductoVendido productoFROMDB(ResultSet snapshop) throws SQLException{
        return new ProductoVendido(
                snapshop.getString("nombre"),
                snapshop.getDouble("cantidadVendida"),
                snapshop.getString("categoria"));
    }
    public static ProductoVendido productoFROMDB2(ResultSet snapshop) throws SQLException{
        return new ProductoVendido(
                snapshop.getString("nombreProducto"),
                snapshop.getDouble("total"),
                snapshop.getString("dia")
                       
        );
    }
    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void setUtilidad(double utilidad) {
        this.precioVendido = utilidad;
    }

    public void setCantidadVendida(double cantidadVendida) {
        this.precioTotal=Double.valueOf(String.format("%.2f",cantidadVendida*getPrecioSalida()));
        //this.precioVendido=Double.valueOf(String.format("%.2f",cantidadVendida*getPrecioSalida()-cantidadVendida*getPrecioEntrada()));
        
        this.cantidadVendida = cantidadVendida;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public double getPrecioVendido() {
        return precioVendido;
    }

    public double getCantidadVendida() {
          
        return cantidadVendida;
    }

    public String getIdVenta() {
        return idVenta;
    }


    


 
}
