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
import java.util.Map;

/**
 *
 * @author YURY
 */
public class UbicacionAction extends ActionSupport implements ModelDriven<Contacto> {
    private Contacto contacto = new Contacto();
    private boolean nuevo = false;
    private ArrayList<Contacto> listaContactos = new ArrayList<>();
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
    public ArrayList<Contacto> getListaContactos() {
        return listaContactos;
    }

    /**
     * @param listaContactos the listaContactos to set
     */
    public void setListaContactos(ArrayList<Contacto> listaContactos) {
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
     * @return the nuevo
     */
    public boolean isNuevo() {
        return nuevo;
    }

    /**
     * @param nuevo the nuevo to set
     */
    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }
    
    public String guardar()
    {
        contacto.setFechaRegistro(Date.valueOf(LocalDate.now()));
        contacto.setEstado(true);
        controladorEgresado.actualizarDatosUbicacion(contacto);
        obtenerLista();
        desplegar();
        return SUCCESS;
    }
    
    public String obtenerLista()
    {
        setListaContactos(controladorEgresado.obtenerDatosUbicacion());
        return SUCCESS;
    }
    
    public String borrar()
    {
        return SUCCESS;
    }
    
    public String editar()
    {
        return SUCCESS;
    }
    
    public String desplegar()
    {
        this.setListaTiposContacto(controladorListas.obtenerTiposContacto());
        this.nuevo = true;
        return SUCCESS;
    }
    
    @Override
    public Contacto getModel() {
        return contacto;
    }
}
