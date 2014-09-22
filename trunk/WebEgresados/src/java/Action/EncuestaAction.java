/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControlardorEncuesta;
import Modelo.PreguntaEncuesta;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author YURY
 */
public class EncuestaAction extends ActionSupport {
    private ArrayList<PreguntaEncuesta> listaPreguntasEncuesta;
    private ControlardorEncuesta controlardorEncuesta = new ControlardorEncuesta();
    
    /**
     * @return the listaPreguntasEncuesta
     */
    public ArrayList<PreguntaEncuesta> getListaPreguntasEncuesta() {
        return listaPreguntasEncuesta;
    }

    /**
     * @param listaPreguntasEncuesta the listaPreguntasEncuesta to set
     */
    public void setListaPreguntasEncuesta(ArrayList<PreguntaEncuesta> listaPreguntasEncuesta) {
        this.listaPreguntasEncuesta = listaPreguntasEncuesta;
    }
    
    public String desplegar()
    {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        this.setListaPreguntasEncuesta(controlardorEncuesta.consularPreguntasEncuesta(Long.parseLong( request.getParameter("idEncuesta"))));
        return SUCCESS;
    }
    
    public String guardar()
    {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        return SUCCESS;
    }
}