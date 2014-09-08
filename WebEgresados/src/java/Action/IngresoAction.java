/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorUsuario;
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

    
    @Override
    public String execute() throws Exception {
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        if (controladorUsuario.login(usuario, contrasenia)) {
            Map session = ActionContext.getContext().getSession();
            session.put("usuario", usuario);
            return SUCCESS;
        }
        else {
            addActionError("Usuario o contraseña incorrectos. Si desea registrarse haga click en Registro");
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
