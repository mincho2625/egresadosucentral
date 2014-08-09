/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Contacto;
import Modelo.TipoContacto;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author YURY
 */
public class UbicacionAction extends ActionSupport implements ModelDriven<Contacto> {
    private Contacto contacto = new Contacto();
    private boolean editar = false;
    private Map<Long, Contacto> listaContactos = new HashMap<Long, Contacto>();
    private ArrayList<TipoContacto> listaTiposContacto;
    private ControladorEgresado controladorEgresado;
    private ControladorListas controladorListas = new ControladorListas();
    
    public UbicacionAction()
    {
        Map session = ActionContext.getContext().getSession();
        String usuario = (String) session.get("usuario");
        controladorEgresado = new ControladorEgresado(usuario);
    }
    
    /**
     * @return the listaContactos
     */
    public Collection<Contacto> getListaContactos() {
        return listaContactos.values();
    }

    /**
     * @param listaContactos the listaContactos to set
     */
    public void setListaContactos(Map<Long, Contacto> listaContactos) {
        this.listaContactos = listaContactos;
    }
    
    /**
     * @return the listaTiposContacto
     */
    public ArrayList<TipoContacto> getListaTiposContacto() {
        return listaTiposContacto;
    }

    /**
     * @param listaTiposContacto the listaTiposContacto to set
     */
    public void setListaTiposContacto(ArrayList<TipoContacto> listaTiposContacto) {
        this.listaTiposContacto = listaTiposContacto;
    }
    
    /**
     * @return the editar
     */
    public boolean isEditar() {
        return editar;
    }

    /**
     * @param editar the editar to set
     */
    public void setEditar(boolean editar) {
        this.editar = editar;
    }
    
    public String guardar()
    {
        contacto.setFechaRegistro(Date.valueOf(LocalDate.now()));
        contacto.setEstado(true);
        controladorEgresado.actualizarDatosUbicacion(contacto);
        obtenerLista();
        this.editar = false;
        return SUCCESS;
    }
    
    public String obtenerLista()
    {
        controladorEgresado.refrescar();
        setListaContactos(controladorEgresado.obtenerDatosUbicacion());
        return SUCCESS;
    }
    
    public String borrar()
    {
        return SUCCESS;
    }
    
    public String editar()
    {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        this.desplegar();
        this.contacto = this.listaContactos.get(Long.parseLong( request.getParameter("idContacto")));
        return SUCCESS;
    }
    
    public String desplegar()
    {
        this.obtenerLista();
        this.setListaTiposContacto(controladorListas.obtenerTiposContacto());
        this.editar = true;
        return SUCCESS;
    }
    
    @Override
    public Contacto getModel() {
        return contacto;
    }
}
