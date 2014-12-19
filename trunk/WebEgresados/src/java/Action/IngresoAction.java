/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorEgresado;
import Controlador.ControladorUsuario;
import Controlador.ControlardorEncuesta;
import Modelo.Egresado;
import Modelo.Encuesta;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author YURY
 */
public class IngresoAction extends ActionSupport{
    private String usuario;
    private String contrasenia;
    private ArrayList<Encuesta> listaEncuestas;
    private boolean primeraVez;
    private String nombre;

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * @param contrasenia the contrasenia to set
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * @return the listaEncuestas
     */
    public ArrayList<Encuesta> getListaEncuestas() {
        return listaEncuestas;
    }

    /**
     * @param listaEncuestas the listaEncuestas to set
     */
    public void setListaEncuestas(ArrayList<Encuesta> listaEncuestas) {
        this.listaEncuestas = listaEncuestas;
    }
    
    /**
     * @return the primeraVez
     */
    public boolean isPrimeraVez() {
        return primeraVez;
    }

    /**
     * @param primeraVez the primeraVez to set
     */
    public void setPrimeraVez(boolean primeraVez) {
        this.primeraVez = primeraVez;
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String execute() throws Exception {
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        if (controladorUsuario.login(usuario, contrasenia)) {
            Map session = ActionContext.getContext().getSession();
            session.put("usuario", usuario);
            
            ControlardorEncuesta controlardorEncuesta = new ControlardorEncuesta();
            this.listaEncuestas = controlardorEncuesta.consultarEncuestas();
            ControladorEgresado controladorEgresado = new ControladorEgresado(usuario);
            Egresado egresado = controladorEgresado.consultar();
            this.setNombre(String.format("%s %s %s", egresado.getNombres(), egresado.getPrimerApellido(), egresado.getSegundoApellido()));
            if (egresado != null && egresado.getFechaUltimaAct() == null){
                this.primeraVez = true;
            }
            
            return SUCCESS;
        }
        else {
            addActionError("Usuario o contraseña incorrectos.");
            return ERROR;
        }
    }

    @Override
    public void validate() {
        if (usuario.equals("")) {
            addFieldError("usuario", "Digite un Usuario");
        }
        if (contrasenia.equals("")) {
            addFieldError("contrasenia", "Digite una Contraseña");
        }
    }
}
