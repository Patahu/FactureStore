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
public class OperacioCaja {
    private String idOperacionCaja;
    private String nombreUsuario;
    private String tipo;
    private Date fechaOperacion;
    private double precioTotal;
    private String idCaja;
    private String razon;

    public OperacioCaja() {
    }
    public OperacioCaja(String idOperacionCaja, String nombreUsuario, String tipo, double precioTotal, String idCaja, String razon) {
        this.idOperacionCaja = idOperacionCaja;
        this.nombreUsuario = nombreUsuario;
        this.tipo = tipo;
        this.precioTotal = precioTotal;
        this.idCaja = idCaja;
        this.razon = razon;
    } 
    public static OperacioCaja operacionFROMDB(ResultSet snapshop) throws SQLException{
        return new OperacioCaja(
                snapshop.getString("idOperacion"),            
                snapshop.getString("nombreUsuario"),
                snapshop.getString("tipo"),
                snapshop.getDate("fechaOperacion"),
                snapshop.getDouble("precioTotal"),
                snapshop.getString("idCaja"),
                snapshop.getString("razon"));
    }

    public OperacioCaja(String idOperacionCaja, String nombreUsuario, String tipo, Date fechaOperacion, double precioTotal, String idCaja, String razon) {
        this.idOperacionCaja = idOperacionCaja;
        this.nombreUsuario = nombreUsuario;
        this.tipo = tipo;
        this.fechaOperacion = fechaOperacion;
        this.precioTotal = precioTotal;
        this.idCaja = idCaja;
        this.razon = razon;
    }


    public String getIdOperacionCaja() {
        return idOperacionCaja;
    }

    public void setIdOperacionCaja(String idOperacionCaja) {
        this.idOperacionCaja = idOperacionCaja;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(String idCaja) {
        this.idCaja = idCaja;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }
    
}
