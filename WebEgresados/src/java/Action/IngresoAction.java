/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorUsuario;
import Controlador.ControlardorEncuesta;
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
    private ControlardorEncuesta controlardorEncuesta = new ControlardorEncuesta();

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
    
    @Override
    public String execute() throws Exception {
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        if (controladorUsuario.login(usuario, contrasenia)) {
            Map session = ActionContext.getContext().getSession();
            session.put("usuario", usuario);
            this.listaEncuestas = controlardorEncuesta.consultarEncuestas();
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
