/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.ItemLista;
import Util.Listas;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author yury
 */
public class SelectProgramaAction extends ActionSupport {
    private List<ItemLista> listaNivelesEstudios;
    private List<ItemLista> listaFacultades;
    private List<ItemLista> listaProgramas;
    private long nivelEstudios;
    private long facultad;
    private long programa;
    private final Listas listas;
    
    public SelectProgramaAction()
    {
        listas = new Listas();
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
     * @return the listaFacultades
     */
    public List<ItemLista> getListaFacultades() {
        return listaFacultades;
    }

    /**
     * @param listaFacultades the listaFacultades to set
     */
    public void setListaFacultades(List<ItemLista> listaFacultades) {
        this.listaFacultades = listaFacultades;
    }

    /**
     * @return the listaProgramas
     */
    public List<ItemLista> getListaProgramas() {
        return listaProgramas;
    }

    /**
     * @param listaProgramas the listaProgramas to set
     */
    public void setListaProgramas(List<ItemLista> listaProgramas) {
        this.listaProgramas = listaProgramas;
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
     * @return the facultad
     */
    public long getFacultad() {
        return facultad;
    }

    /**
     * @param facultad the facultad to set
     */
    public void setFacultad(long facultad) {
        this.facultad = facultad;
    }

    /**
     * @return the programa
     */
    public long getPrograma() {
        return programa;
    }

    /**
     * @param programa the programa to set
     */
    public void setPrograma(long programa) {
        this.programa = programa;
    }

    @Override
    public String execute() throws Exception {
        listaNivelesEstudios = listas.consultarNivelesEstudiosAplicaUCentral();
        listaFacultades = listas.consultarFacultades();
        
        if (nivelEstudios > 0 && facultad > 0)
            listaProgramas = listas.consultarProgramasPorFacultadYNivelEstudios(facultad, nivelEstudios);
        
        return SUCCESS;
    }
    
    public String getJSON() throws Exception {
        return execute();
    }
    
    public String index() {
        return SUCCESS;
    }
}
