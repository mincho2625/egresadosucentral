/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Contacto;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;

/**
 *
 * @author YURY
 */
public class UbicacionAction extends ActionSupport implements ModelDriven<Contacto> {
    private Contacto contacto = new Contacto();
    private ArrayList<Contacto> listaContactos = new ArrayList<Contacto>();
    private ControladorEgresado controladorEgresado = new ControladorEgresado();
    
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
    
    public String guardar()
    {
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
    
    
    @Override
    public Contacto getModel() {
        return contacto;
    }    
}
