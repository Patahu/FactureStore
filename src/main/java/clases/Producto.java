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
public class Producto {
    private int idProducto;
    private String codigoBarras;
    private double precioEntrada;
    private double precioSalida;
    private String unidad;
    private Date fechaCreacion;
    private int idCategoria;
    private int idVariante;
    private byte[] imagen;
    private String nombre;
    private Double cantidad;
    private Double cantidadMinima;

    public Producto(int idProducto, 
            String codigoBarras, 
            double precioEntrada,
            double precioSalida, 
            String unidad, 
            Date fechaCreacion, 
            int idCategoria, 
            byte[] imagen, 
            String nombre) {
        this.idProducto = idProducto;
        this.codigoBarras = codigoBarras;
        this.precioEntrada = precioEntrada;
        this.precioSalida = precioSalida;
        this.unidad = unidad;
        this.fechaCreacion = fechaCreacion;
        this.idCategoria = idCategoria;
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public Producto(int idProducto, 
            String codigoBarras, 
            double precioEntrada, 
            double precioSalida, 
            String unidad, 
            Date fechaCreacion,
            int idCategoria, 
            String nombre, 
            Double cantidad,
            Double cantidadMinima
            ) {
        this.idProducto = idProducto;
        this.codigoBarras = codigoBarras;
        this.precioEntrada = precioEntrada;
        this.precioSalida = precioSalida;
        this.unidad = unidad;
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public Producto(String codigoBarras, double precioEntrada, double precioSalida, String unidad, int idCategoria, String nombre, Double cantidad,Double cantidadMinima) {
        this.codigoBarras = codigoBarras;
        this.precioEntrada = precioEntrada;
        this.precioSalida = precioSalida;
        this.unidad = unidad;
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.cantidadMinima=cantidadMinima;
    }

    public Producto(int idProducto, 
            String codigoBarras, 
            double precioEntrada, 
            double precioSalida, 
            String unidad, 
            Date fechaCreacion, 
            int idCategoria, 
            int idVariante, 
            String nombre, 
            Double cantidad,
            Double cantidadMinima) {
        this.idProducto = idProducto;
        this.codigoBarras = codigoBarras;
        this.precioEntrada = precioEntrada;
        this.precioSalida = precioSalida;
        this.unidad = unidad;
        this.fechaCreacion = fechaCreacion;
        this.idCategoria = idCategoria;
        this.idVariante = idVariante;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.cantidadMinima=cantidadMinima;
    }

    public Producto() {
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }
    
    
    public static Producto productoFROMDB(ResultSet snapshop) throws SQLException{
        return new Producto(
                snapshop.getInt("idProducto"),
                snapshop.getString("codigoBarras"),
                snapshop.getDouble("precioEntrada"),
                snapshop.getDouble("precioSalida"),
                snapshop.getString("unidad"),
                snapshop.getDate("fechaCreacion"),
                snapshop.getInt("idCategoria"),
                snapshop.getInt("idVariante"),
                snapshop.getString("nombre"),
                snapshop.getDouble("stock"),
                snapshop.getDouble("inventarioMinimo"));
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public double getPrecioSalida() {
        return precioSalida;
    }

    public String getUnidad() {
        return unidad;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public int getIdVariante() {
        return idVariante;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public Double getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public void setPrecioSalida(double precioSalida) {
        this.precioSalida = precioSalida;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setIdVariante(int idVariante) {
        this.idVariante = idVariante;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidadMinima(Double cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }
    
    
    
}
