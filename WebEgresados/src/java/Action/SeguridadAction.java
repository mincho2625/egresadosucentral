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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author YURY
 */
public class SeguridadAction extends ActionSupport {
    private String actual;
    private String nueva;
    private String confirmarNueva;
    private String usuario;
    
    public SeguridadAction()
    {
        Map session = ActionContext.getContext().getSession();
        usuario = (String) session.get("usuario");
    }

    /**
     * @return the actual
     */
    public String getActual() {
        return actual;
    }

    /**
     * @param actual the actual to set
     */
    public void setActual(String actual) {
        this.actual = actual;
    }

    /**
     * @return the nueva
     */
    public String getNueva() {
        return nueva;
    }

    /**
     * @param nueva the nueva to set
     */
    public void setNueva(String nueva) {
        this.nueva = nueva;
    }

    /**
     * @return the confirmarNueva
     */
    public String getConfirmarNueva() {
        return confirmarNueva;
    }

    /**
     * @param confirmarNueva the confirmarNueva to set
     */
    public void setConfirmarNueva(String confirmarNueva) {
        this.confirmarNueva = confirmarNueva;
    }
    
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
    
    public String cambiarContrasenia()
    {
        validar();
        if (!hasErrors()) {
            ControladorUsuario controladorUsuario = new ControladorUsuario();
            long idUsuario = controladorUsuario.login(usuario, actual);
            if (idUsuario > 0)
            {
                if (controladorUsuario.cambiarContrasenia(usuario, nueva)) {
                    addActionMessage("Contraseña cambiada exitosamente");
                    return SUCCESS;
                }
                else {
                    addActionError("Error al cambiar contraseña. Contacte al administrador del sistema.");
                    return ERROR;
                }
            }
            else
            {
                addActionError("La contraseña actual es incorrecta");
                return ERROR;
            }
        }
        else {
            return ERROR;
        }
    }

    public void validar() {
        if (actual == null || actual.isEmpty()) {
            addFieldError("actual", "Digite la contraseña actual");
        }
        if (nueva == null || nueva.isEmpty()) {
            addFieldError("nueva", "Digite una nueva contraseña");
        }else {
            Pattern pat = Pattern.compile("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$");
            Matcher mat = pat.matcher(nueva);
            if (mat.matches()) {
                System.out.println("Válido");
            } else {
                addFieldError("nueva", "La contraseña debe contener al menos una letra mayúscula, \n"
                        + "al menos una letra minúscula, \n"
                        + "al menos un número o caracter especial, \n"
                        + "cuya longitud sea como mínimo 8 caracteres, \n"
                        + "cuya longitud máxima no debe ser arbitrariamente limitada.");
            }
        }
        if (confirmarNueva == null || confirmarNueva.isEmpty()) {
            addFieldError("confirmarNueva", "Digite la confirmación de la nueva contraseña");
        }
        if (!nueva.equals(confirmarNueva)) {
            addActionError("La confirmación de contraseña es incorrecta");
        }
    }
}