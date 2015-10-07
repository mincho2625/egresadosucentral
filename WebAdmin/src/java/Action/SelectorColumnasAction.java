/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controlador.ControladorColumnas;
import Modelo.ItemLista;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author YURY
 */
public class SelectorColumnasAction extends ActionSupport {

    private List<ItemLista> listaColumnas;
    private List<ItemLista> listaColumnasSeleccionadas;
    private final ControladorColumnas controladorColumnas;
    private final long idUsuario;
    
    public SelectorColumnasAction()
    {
        controladorColumnas = new ControladorColumnas();
        Map session = ActionContext.getContext().getSession();
        idUsuario = (long) session.get("idUsuario");
    }

    /**
     * @return the listaColumnas
     */
    public List<ItemLista> getListaColumnas() {
        return listaColumnas;
    }

    /**
     * @param listaColumnas the listaColumnas to set
     */
    public void setListaColumnas(List<ItemLista> listaColumnas) {
        this.listaColumnas = listaColumnas;
    }

    /**
     * @return the listaColumnasSeleccionadas
     */
    public List<ItemLista> getListaColumnasSeleccionadas() {
        return listaColumnasSeleccionadas;
    }

    /**
     * @param listaColumnasSeleccionadas the listaColumnasSeleccionadas to set
     */
    public void setListaColumnasSeleccionadas(List<ItemLista> listaColumnasSeleccionadas) {
        this.listaColumnasSeleccionadas = listaColumnasSeleccionadas;
    }
    
    private void desplegar()
    {
        listaColumnas = controladorColumnas.consultarEducacionFormalUCentral();
        listaColumnasSeleccionadas = controladorColumnas.consultarEducacionFormalUCentralPorUsuario(idUsuario);
    }

    public String mostrar() throws Exception {
        desplegar();
        return "mostrar";
    }
    
    public String guardar() throws Exception {
        System.out.println("Guardar");
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        
        String[] split = request.getParameter("lista").split(",");
        List<Long> lista = new ArrayList<>();
        
        for (String item : split) {
            lista.add(Long.valueOf(item));
        }
        
        controladorColumnas.guardarEducacionFormalUCentral(lista, idUsuario);
        desplegar();        
        return SUCCESS;
    }
    
    public String getJSON() throws Exception {
        return execute();
    }
    
    public String index() {
        return SUCCESS;
    }
}