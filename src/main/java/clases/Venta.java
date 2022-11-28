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
public class Venta {
    private String idVenta;
    private double precioTotal;
    private double descuento;
    private Date fechaCreacion;
    private String idCaja;
    private int voucher;
    private int idUsuario;
    private String nombreUsuario;

    public Venta() {
    }

    public Venta(String idVenta, 
            double precioTotal, 
            double descuento, 
            String idCaja, 
            int idUsuario) {
        this.idVenta = idVenta;
        this.precioTotal = precioTotal;
        this.descuento = descuento;
        this.idCaja = idCaja;
        this.idUsuario = idUsuario;
    }
    public Venta(String idVenta, double precioTotal, double descuento, Date fechaCreacion, String idCaja, int voucher, int idUsuario) {
        this.idVenta = idVenta;
        this.precioTotal = precioTotal;
        this.descuento = descuento;
        this.fechaCreacion = fechaCreacion;
        this.idCaja = idCaja;
        this.voucher = voucher;
        this.idUsuario = idUsuario;
    }
    public Venta(String idVenta, double precioTotal, double descuento, Date fechaCreacion, String idCaja, int voucher, String nombreUsuario) {
        this.idVenta = idVenta;
        this.precioTotal = precioTotal;
        this.descuento = descuento;
        this.fechaCreacion = fechaCreacion;
        this.idCaja = idCaja;
        this.voucher = voucher;
        this.nombreUsuario = nombreUsuario;
    }
    static public Venta ventaFromDB(ResultSet snapshot) throws SQLException{
        return new Venta(snapshot.getString("idVenta"),
                snapshot.getDouble("precioTotal"),
                snapshot.getDouble("descuento"),
                snapshot.getDate("fechaCreacion"),
                snapshot.getString("idCaja"),
                0,
                snapshot.getInt("idUsuario"));
        
    }
    static public Venta ventaFromDB1(ResultSet snapshot) throws SQLException{
        return new Venta(snapshot.getString("idVenta"),
                snapshot.getDouble("precioTotal"),
                snapshot.getDouble("descuento"),
                snapshot.getDate("fechaCreacion"),
                snapshot.getString("idCaja"),
                0,
                snapshot.getString("idUsuario"));
        
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public String getIdVenta() {
        return idVenta;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public String getIdCaja() {
        return idCaja;
    }

    public int getVoucher() {
        return voucher;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
    
}
