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
public class TurnoRegistrado {
    private String idTurnoRegistrado;
    private int idUsuario;
    private int idHorario;
    private Date fechaRealizada;
    private Date horarioEntrada;
    private Date horarioSalida;
    private String idCaja;
    private Double totalCierre;
    private Double totalEntrada;
    private boolean isClose;
    
    
    private int respuesta;
    public TurnoRegistrado() {
    }
    public TurnoRegistrado(String idTurnoRegistrado, int idUsuario, int idHorario, Date fechaRealizada, Date horarioEntrada, Date horarioSalida, Double totalCierre, String idCaja,boolean isClose,Double totalEntrada) {
        this.idTurnoRegistrado = idTurnoRegistrado;
        this.idUsuario = idUsuario;
        this.idHorario = idHorario;
        this.fechaRealizada = fechaRealizada;
        this.horarioEntrada = horarioEntrada;
        this.horarioSalida = horarioSalida;
        this.idCaja = idCaja;
        this.isClose=isClose;
        this.totalCierre=totalCierre;
        this.totalCierre=totalCierre;
    }
    public TurnoRegistrado(String idTurnoRegistrado, int idUsuario, int idHorario, Date fechaRealizada, Date horarioEntrada, Date horarioSalida, Double totalCierre, String idCaja,boolean isClose,Double totalEntrada,int respuesta) {
        this.idTurnoRegistrado = idTurnoRegistrado;
        this.idUsuario = idUsuario;
        this.idHorario = idHorario;
        this.fechaRealizada = fechaRealizada;
        this.horarioEntrada = horarioEntrada;
        this.horarioSalida = horarioSalida;
        this.idCaja = idCaja;
        this.isClose=isClose;
        this.totalCierre=totalCierre;
        this.totalCierre=totalCierre;
        this.respuesta=respuesta;
    }

    public TurnoRegistrado(int idUsuario, int idHorario, String idCaja, Double totalCierre) {
        this.idUsuario = idUsuario;
        this.idHorario = idHorario;
        this.idCaja = idCaja;
        this.totalCierre = totalCierre;
    }

    public int getRespuesta() {
        return respuesta;
    }
    

    public Double getTotalCierre() {
        return totalCierre;
    }

    public Double getTotalEntrada() {
        return totalEntrada;
    }

    public boolean isIsClose() {
        return isClose;
    }



    public String getIdTurnoRegistrado() {
        return idTurnoRegistrado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public Date getFechaRealizada() {
        return fechaRealizada;
    }

    public Date getHorarioEntrada() {
        return horarioEntrada;
    }

    public Date getHorarioSalida() {
        return horarioSalida;
    }

    public String getIdCaja() {
        return idCaja;
    }
    
    
}
