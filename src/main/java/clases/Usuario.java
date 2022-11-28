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
public class Usuario {
    private int idUsuario;
    private String nombreUsuario;
    private String passwordUsuario;
    private int isActive;
    private int isAdmin;
    private Date fechaCreacion;
    private int idHorario;

    public Usuario() {
    }
    
    public Usuario(String nombreUsuario, String passwordUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario = passwordUsuario;
    }

    public Usuario(int idUsuario, int isActive, int isAdmin) {
        this.idUsuario = idUsuario;
        this.isActive = isActive;
        this.isAdmin = isAdmin;
    }

    public Usuario(int idUsuario, String nombreUsuario, 
            int isActive, int isAdmin, Date fechaCreacion, int idHorario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.isActive = isActive;
        this.isAdmin = isAdmin;
        this.fechaCreacion = fechaCreacion;
        this.idHorario=idHorario;
    }

    public Usuario(int idUsuario, String nombreUsuario,
            String passwordUsuario, int isActive, int isAdmin,
            Date fechaCreacion, int idHorario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario = passwordUsuario;
        this.isActive = isActive;
        this.isAdmin = isAdmin;
        this.fechaCreacion = fechaCreacion;
        this.idHorario = idHorario;
    }
    
    

    public Usuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(int idUsuario, String nombreUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
    }

    public Usuario(String nombreUsuario,
            String passwordUsuario, int isAdmin, int idHorario) {
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario = passwordUsuario;
        this.isAdmin = isAdmin;
        this.idHorario = idHorario;
    }

    public Usuario(int idUsuario, String nombreUsuario,
            String passwordUsuario, int isActive, int isAdmin, int idHorario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario = passwordUsuario;
        this.isActive = isActive;
        this.isAdmin = isAdmin;
        this.idHorario = idHorario;
    }
    
    
    
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(byte isActive) {
        this.isActive = isActive;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(byte isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdHorario() {
        return idHorario;
    }
    
}
