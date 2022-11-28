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
public class OperacionProducto {
    private String idOperacionProducto;
    private Date fechaCreacion;
    private int idUsuario;
    private String idOperacion;
    private String numeroSerie;
    private double precioTotal;
    private String tipo;
    
    public static OperacionProducto operacionFROMDB(ResultSet snapshop) throws SQLException{
        return new OperacionProducto(
                snapshop.getString("idOperacionProducto"),
                snapshop.getDate("fechaCreacion"),
                snapshop.getInt("idUsuario"),
                snapshop.getString("idOperacion"),
                snapshop.getString("numeroSerie"),
                Double.valueOf(String.format("%.2f",snapshop.getFloat("precioTotal"))),
                snapshop.getString("tipo"));
    }

    public OperacionProducto(String idOperacionProducto, 
            Date fechaCreacion, 
            int idUsuario, 
            String idOperacion, 
            String numeroSerie, 
            double precioTotal, 
            String tipo) {
        this.idOperacionProducto = idOperacionProducto;
        this.fechaCreacion = fechaCreacion;
        this.idUsuario = idUsuario;
        this.idOperacion = idOperacion;
        this.numeroSerie = numeroSerie;
        this.precioTotal = precioTotal;
        this.tipo = tipo;
    }

    public OperacionProducto() {
    }

    public String getIdOperacionProducto() {
        return idOperacionProducto;
    }

    public void setIdOperacionProducto(String idOperacionProducto) {
        this.idOperacionProducto = idOperacionProducto;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(String idOperacion) {
        this.idOperacion = idOperacion;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
