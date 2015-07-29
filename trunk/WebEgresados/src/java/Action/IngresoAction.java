/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorEgresado;
import Controlador.ControladorUsuario;
import Modelo.Egresado;
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
    // <result name="next" type="redirectAction">${nextAction}</result>
    private String mensaje;

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
    
    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    @Override
    public String execute() throws Exception {
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        
        if (controladorUsuario.login(usuario, contrasenia)) {
            ControladorEgresado controladorEgresado = new ControladorEgresado();
            Egresado egresado = controladorEgresado.consultar(usuario);
            if (egresado != null){
                Map session = ActionContext.getContext().getSession();
                session.put("idEgresado", egresado.getIdUsuario());
                session.put("usuario", egresado.getNombre());

                this.setNombre(String.format("%s %s %s", egresado.getNombres(), egresado.getPrimerApellido(), egresado.getSegundoApellido()));
                
                if (!egresado.isInformacionCompleta()) {
                    this.mensaje = "Su información no está completa, por favor actualice sus datos. ";
                    
                    if (egresado.getFechaUltimaAct() == null) {
                        this.primeraVez = true;
                    }
                }
                
                return SUCCESS;
            }
            else {
                addActionError("Usuario o contraseña incorrectos.");
                return ERROR;
            }
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