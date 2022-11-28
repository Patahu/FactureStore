/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_InicioSesion;

import clases.Usuario;

/**
 *
 * @author fell
 */
public class EstadoInicioSesion {
    private Usuario usuario;
    private String estadoBusqueda;
    private String resultado;

    public EstadoInicioSesion() {
    }

    public EstadoInicioSesion(Usuario usuario, String estadoBusqueda, String resultado) {
        this.usuario = usuario;
        this.estadoBusqueda = estadoBusqueda;
        this.resultado = resultado;
    }

    public EstadoInicioSesion(String estadoBusqueda, String resultado) {
        this.estadoBusqueda = estadoBusqueda;
        this.resultado = resultado;
    }
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getEstadoBusqueda() {
        return estadoBusqueda;
    }

    public void setEstadoBusqueda(String estadoBusqueda) {
        this.estadoBusqueda = estadoBusqueda;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
}
