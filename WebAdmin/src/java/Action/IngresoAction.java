/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorUsuario;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author YURY
 */
public class IngresoAction extends ActionSupport{
    private String usuario;
    private String contrasenia;
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
            //ControladorEgresado controladorEgresado = new ControladorEgresado(usuario);
            //controladorEgresado.consultar();
            return SUCCESS;
        }
        else {
            addActionError("Usuario o contraseña incorrectos.");
            return ERROR;
        }
    }

    @Override
    public void validate() {
        if (usuario == null || usuario.isEmpty()) {
            addFieldError("usuario", "Digite un Usuario");
        }
        if (contrasenia == null || contrasenia.isEmpty()) {
            addFieldError("contrasenia", "Digite una Contraseña");
        }
    }
}