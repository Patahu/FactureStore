/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_limbo.gestionar_usuarios;

import GUILoading.Cargando;
import clases.Horario;
import clases.Usuario;
import clasesJDBC.HorarioJDBC;
import clasesJDBC.UsuarioJDBC;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;

/**
 *
 * @author fell
 */
public class poolBuscarUsuarios implements Callable<String>,ActionListener {

    
    private ControladorUsuarios controladorUsuarios;
    
    private HashMap<String, Usuario> usuariosDefecto= new HashMap<String, Usuario>();
    private HashMap<String, PanelUsuario> contenedores= new HashMap<String, PanelUsuario>();
    private PanelUsuarios panelUsuarios;
    private int usuarioActivo;// seleccionar activos o inactivos
    public poolBuscarUsuarios(ControladorUsuarios controladorUsuarios,int usuario) {
        this.controladorUsuarios=controladorUsuarios;
        this.usuarioActivo=usuario;
    }
    
    @Override
    public String call() throws Exception {
        Cargando cargando= new Cargando();
        controladorUsuarios.setPanelUsuarios(cargando,new Dimension(700,460));

        mostrarHorarios();
        return "poolBuscarUsuarios Terminado";
    }
    
    
    public void mostrarHorarios(){
        UsuarioJDBC usuarioJDBC= new UsuarioJDBC();
        ArrayList<Usuario> usuariosBuscados;
        
        // si es 1 son activos
        if(usuarioActivo==1){
            usuariosBuscados=usuarioJDBC.buscarUsuariosActivos();
        }else{
        
            usuariosBuscados=usuarioJDBC.buscarUsuariosInactivos();
        }
        HorarioJDBC horarioJDBC=new HorarioJDBC();
        panelUsuarios= new PanelUsuarios();
        int contador=0;
        for(int a=0;a<2;a++){
            panelUsuarios.listHorarios.add(new javax.swing.JPanel(),0);
            panelUsuarios.listHorarios.updateUI();
        }
        for(Usuario pa: usuariosBuscados){
            
            if(pa.getNombreUsuario().equals("admin")){
            
                continue;
            }
            String indice=""+contador;

            PanelUsuario c=new PanelUsuario();   
            c.botonEliminar.setActionCommand("BotonEliminar,"+indice);
            c.botonModificar.setActionCommand("BotonModificar,"+indice);
            c.botonEliminar.addActionListener(this);
            c.botonModificar.addActionListener(this);

            contenedores.put(indice,c);
            Horario horarioBusc=horarioJDBC.buscarHorario(pa.getIdHorario());
            c.turno.setText(""+horarioBusc.getNombre());
            c.fechaCreacion.setText(""+pa.getFechaCreacion());
            c.nombre.setText(pa.getNombreUsuario());
            if(pa.getIsAdmin()==1){
              c.rol.setText("Administrador");
            }else{
              c.rol.setText("Vendedor"); 
            }          
            this.usuariosDefecto.put(indice, pa);
            if(pa.getIsActive()==1){
                c.activo.setText("SI");
            }else{
                c.activo.setText("NO");
            }
            contador++;
            panelUsuarios.listHorarios.add(c,0);
            panelUsuarios.listHorarios.updateUI();
        }
        
        controladorUsuarios.setPanelUsuarios(panelUsuarios,  new Dimension(700,460));

         
        
    }
    public void eliminarHorarios(String id){
        controladorUsuarios.ingresarUsuario(usuariosDefecto.get(id));
        panelUsuarios.listHorarios.remove(contenedores.get(id));
        contenedores.remove(id);
        usuariosDefecto.remove(id);
        panelUsuarios.listHorarios.updateUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String evento[]= e.getActionCommand().split(",");
        System.out.println(" Evento"+evento[0]);
        if(evento[0].equals("BotonEliminar")){
            String id= evento[1];
            controladorUsuarios.ingresarUsuario(usuariosDefecto.get(id));
            controladorUsuarios.proceso("Eliminar Usuario");
            System.out.println(" ELIMINAR "+ id);
           
        }else if(evento[0].equals("BotonModificar")){
            String id= evento[1];
            controladorUsuarios.ingresarUsuario(usuariosDefecto.get(id));
            controladorUsuarios.proceso("Modificar Usuario");
            System.out.println(" MODIFICAR "+id);
        
        }
    }    
    
    
    
}
