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
public class Caja {
    private String idCaja;
    private int idUsuarioCaja;
    private double inicioCaja;
    private double cierreCaja;
    private Date fechaCreacion;
    private Date fechaCierre;
    private int isClose;

    public Caja() {
    }

    public Caja(String idCaja, int idUsuarioCaja, double inicioCaja,
            double cierreCaja, Date fechaCreacion, Date fechaCierre, int isClose) {
        this.idCaja = idCaja;
        this.idUsuarioCaja = idUsuarioCaja;
        this.inicioCaja = inicioCaja;
        this.cierreCaja = cierreCaja;
        this.fechaCreacion = fechaCreacion;
        this.fechaCierre = fechaCierre;
        this.isClose = isClose;
    }

    public Caja(String idCaja, int idUsuarioCaja, double inicioCaja,
            double cierreCaja, Date fechaCreacion, int isClose) {
        this.idCaja = idCaja;
        this.idUsuarioCaja = idUsuarioCaja;
        this.inicioCaja = inicioCaja;
        this.cierreCaja = cierreCaja;
        this.fechaCreacion = fechaCreacion;
        this.isClose = isClose;
    }
    
    public Caja(String idCaja, Date fechaCreacion) {
        this.idCaja = idCaja;
        this.fechaCreacion = fechaCreacion;
    }

    public Caja(String idCaja, double inicioCaja, Date fechaCreacion) {
        this.idCaja = idCaja;
        this.inicioCaja = inicioCaja;
        this.fechaCreacion = fechaCreacion;
    }
    
    public Caja(String idCaja, int idUsuarioCaja, double inicioCaja) {
        this.idCaja = idCaja;
        this.idUsuarioCaja = idUsuarioCaja;
        this.inicioCaja = inicioCaja;
    }

    public Caja(String idCaja, int idUsuarioCaja, double inicioCaja, double cierreCaja) {
        this.idCaja = idCaja;
        this.idUsuarioCaja = idUsuarioCaja;
        this.inicioCaja = inicioCaja;
        this.cierreCaja = cierreCaja;
    }

    public Caja(double inicioCaja, double cierreCaja, Date fechaCreacion) {
        this.inicioCaja = inicioCaja;
        this.cierreCaja = cierreCaja;
        this.fechaCreacion = fechaCreacion;
    }
    

    
    
    public Date getFechaCierre() {
        return fechaCierre;
    }

    public int getIsClose() {
        return isClose;
    }



    
    public String getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(String idCaja) {
        this.idCaja = idCaja;
    }

    public int getIdUsuarioCaja() {
        return idUsuarioCaja;
    }

    public void setIdUsuarioCaja(int idUsuarioCaja) {
        this.idUsuarioCaja = idUsuarioCaja;
    }

    public double getInicioCaja() {
        return inicioCaja;
    }

    public void setInicioCaja(double inicioCaja) {
        this.inicioCaja = inicioCaja;
    }

    public double getCierreCaja() {
        return cierreCaja;
    }

    public void setCierreCaja(double cierreCaja) {
        this.cierreCaja = cierreCaja;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }



}
