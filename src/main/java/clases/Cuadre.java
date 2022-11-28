/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fell
 */
public class Cuadre {
    private String nombre;
    private double precioVenta;
    private double cantidadVendida;
    private double precioTotal;

    public Cuadre() {
    }
    public static Cuadre productoFROMDB(ResultSet snapshop) throws SQLException{
        return new Cuadre(
                snapshop.getString("nombre"),
                snapshop.getDouble("precioVenta"),
                snapshop.getDouble("cantidadVendida"),
                snapshop.getDouble("precioTotal"));
    }

    public Cuadre(String nombre, double precioVenta, double cantidadVendida, double precioTotal) {
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.cantidadVendida = cantidadVendida;
        this.precioTotal = precioTotal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(double cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
    
}
