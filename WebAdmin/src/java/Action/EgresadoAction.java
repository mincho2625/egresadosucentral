/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorCrud;
import Controlador.ControladorEgresado;
import Modelo.Egresado;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author YURY
 */
public class EgresadoAction extends ActionSupport {
    private List<Object> listaEgresados = null;
    private final ControladorCrud controladorCrud;
    
    public EgresadoAction()
    {
        this.controladorCrud = new ControladorCrud();
    }

    /**
     * @return the listaEgresados
     */
    public List<Object> getListaEgresados() {
        return listaEgresados;
    }

    /**
     * @param listaEgresados the listaEgresados to set
     */
    public void setListaEgresados(List<Object> listaEgresados) {
        this.listaEgresados = listaEgresados;
    }
    
    public String desplegar() throws Exception {
        this.listaEgresados = controladorCrud.consultarLista("Egresado.findByUsuarios", Egresado.class.getName());
        return SUCCESS;
    }
    
    public String activar() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        long idEgresado = Long.parseLong(request.getParameter("idEgresado"));
        
        ControladorEgresado controladorEgresado = new ControladorEgresado();
        if (controladorEgresado.activar(idEgresado, true))
            return SUCCESS;
        else {
            addActionError("Ha ocurrido un error al activar egresado. Por favor intente nuevamente.");
            return ERROR;
        }
    }
    
    public String inactivar() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        long idEgresado = Long.parseLong(request.getParameter("idEgresado"));
        
        ControladorEgresado controladorEgresado = new ControladorEgresado();
        if (controladorEgresado.activar(idEgresado, false))
            return SUCCESS;
        else {
            addActionError("Ha ocurrido un error al inactivar egresado. Por favor intente nuevamente.");
            return ERROR;
        }
    }
}
