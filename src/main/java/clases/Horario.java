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
public class Horario {
    private int idHorario;
    private Date horaEntrada;
    private Date horaSalida;
    private Date fechaCreacion;
    private String nombre;
    private int isActive;

    public Horario() {
    }

    public Horario(int idHorario, Date horaEntrada,
            Date horaSalida,
            Date fechaCreacion, String nombre,int isActive) {
        this.idHorario = idHorario;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.fechaCreacion = fechaCreacion;
        this.nombre = nombre;
        this.isActive=isActive;
    }

    public Horario(Date horaEntrada, Date horaSalida, String nombre) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.nombre = nombre;
    }

    public Horario(int idHorario, Date horaEntrada, Date horaSalida, String nombre, int isActive) {
        this.idHorario = idHorario;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.nombre = nombre;
        this.isActive = isActive;
    }

    public Horario(int idHorario) {
        this.idHorario = idHorario;
    }

    public Horario(int idHorario, int isActive) {
        this.idHorario = idHorario;
        this.isActive = isActive;
    }
    
    
    
    public int getIdHorario() {
        return idHorario;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIsActive() {
        return isActive;
    }
    
    
}
