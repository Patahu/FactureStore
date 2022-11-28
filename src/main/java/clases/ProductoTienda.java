/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Date;

/**
 *
 * @author fell
 */
public class ProductoTienda extends Producto{
    private Double stockMinimo;

    public ProductoTienda(int idProducto, 
            Double stockMinimo, 
            String codigoBarras, 
            double precioEntrada, 
            double precioSalida, 
            String unidad, 
            Date fechaCreacion, 
            int idCategoria, 
            String nombre, 
            Double cantidad, 
            Double cantidadMinima) {
        super(idProducto, codigoBarras, precioEntrada, precioSalida, unidad, fechaCreacion, idCategoria, nombre, cantidad, cantidadMinima);
        this.stockMinimo = stockMinimo;
    }

    public ProductoTienda(String codigoBarras,
            double precioEntrada, 
            double precioSalida, 
            String unidad, 
            int idCategoria, 
            String nombre, 
            Double cantidad, 
            Double cantidadMinima) {
        super(codigoBarras, precioEntrada, precioSalida, unidad, idCategoria, nombre, cantidad, cantidadMinima);
        stockMinimo=cantidadMinima;
    }

    


    public ProductoTienda(Double stockMinimo) {
        this.stockMinimo = stockMinimo;
    }
    

    public Double getStockMinimo() {
        return stockMinimo;
    }
    
    
}
