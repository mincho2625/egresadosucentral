/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Pais;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;

/**
 *
 * @author YURY
 */
public class RegistroAction extends ActionSupport {
    private ArrayList<Pais> listaPaises;
    
    /**
     * @return the listaPaises
     */
    public ArrayList<Pais> getListaPaises() {
        return listaPaises;
    }

    /**
     * @param listaPaises the listaPaises to set
     */
    public void setListaPaises(ArrayList<Pais> listaPaises) {
        this.listaPaises = listaPaises;
    }
    
    public String populate()
    {
        ControladorListas cl = new ControladorListas();
        setListaPaises(cl.obtenerPaises());
        
        return "populate";
    }
}