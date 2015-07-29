/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorListas;
import Modelo.ItemLista;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author yury
 */
public class SelectAreaEstudiosAction extends ActionSupport {
    private List<ItemLista> listaNivelesEstudios;
    private List<ItemLista> listaAreasEstudios;
    private long nivelEstudios;
    private long areaEstudios;
    private final ControladorListas listas;
    
    public SelectAreaEstudiosAction() {
        listas = new ControladorListas();
    }

    /**
     * @return the listaNivelesEstudios
     */
    public List<ItemLista> getListaNivelesEstudios() {
        return listaNivelesEstudios;
    }

    /**
     * @param listaNivelesEstudios the listaNivelesEstudios to set
     */
    public void setListaNivelesEstudios(List<ItemLista> listaNivelesEstudios) {
        this.listaNivelesEstudios = listaNivelesEstudios;
    }

    /**
     * @return the listaAreaEstudios
     */
    public List<ItemLista> getListaAreasEstudios() {
        return listaAreasEstudios;
    }

    /**
     * @param listaAreasEstudios
     */
    public void setListaAreasEstudios(List<ItemLista> listaAreasEstudios) {
        this.listaAreasEstudios = listaAreasEstudios;
    }

    /**
     * @return the nivelEstudios
     */
    public long getNivelEstudios() {
        return nivelEstudios;
    }

    /**
     * @param nivelEstudios the nivelEstudios to set
     */
    public void setNivelEstudios(long nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
    }

    /**
     * @return the areaEstudios
     */
    public long getAreaEstudios() {
        return areaEstudios;
    }

    /**
     * @param areaEstudios the areaEstudios to set
     */
    public void setAreaEstudios(long areaEstudios) {
        this.areaEstudios = areaEstudios;
    }

    @Override
    public String execute() throws Exception {
        listaNivelesEstudios = listas.consultarNivelesEstudiosFormal();
        if (nivelEstudios > 0)
        {
            listaAreasEstudios = listas.consultarAreasEstudiosPorNivelEstudios(nivelEstudios);
            if (listaAreasEstudios.isEmpty())
                listaAreasEstudios = listas.consultarAreasEstudiosPorNivelEstudiosNull();
        }
        
        return SUCCESS;
    }
    
    public String getJSON() throws Exception {
        return execute();
    }
    
    public String index() {
        return SUCCESS;
    }
}