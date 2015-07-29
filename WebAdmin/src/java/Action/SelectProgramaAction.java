/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorListas;
import Modelo.ItemLista;
import static com.opensymphony.xwork2.Action.SUCCESS;
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
    private List<Long> seleccionNivelEstudios;
    private List<Long> seleccionFacultades;
    private List<Long> seleccionProgramas;
    private String criterioSeleccionado;
    private final ControladorListas listas;
    
    public SelectProgramaAction()
    {
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
     * @return the seleccionNivelEstudios
     */
    public List<Long> getSeleccionNivelEstudios() {
        return seleccionNivelEstudios;
    }

    /**
     * @param seleccionNivelEstudios the seleccionNivelEstudios to set
     */
    public void setSeleccionNivelEstudios(List<Long> seleccionNivelEstudios) {
        this.seleccionNivelEstudios = seleccionNivelEstudios;
    }

    /**
     * @return the seleccionFacultades
     */
    public List<Long> getSeleccionFacultades() {
        return seleccionFacultades;
    }

    /**
     * @param seleccionFacultades the seleccionFacultades to set
     */
    public void setSeleccionFacultades(List<Long> seleccionFacultades) {
        this.seleccionFacultades = seleccionFacultades;
    }

    /**
     * @return the seleccionProgramas
     */
    public List<Long> getSeleccionProgramas() {
        return seleccionProgramas;
    }

    /**
     * @param seleccionProgramas the seleccionProgramas to set
     */
    public void setSeleccionProgramas(List<Long> seleccionProgramas) {
        this.seleccionProgramas = seleccionProgramas;
    }
    
    /**
     * @return the criterioSeleccionado
     */
    public String getCriterioSeleccionado() {
        return criterioSeleccionado;
    }

    /**
     * @param criterioSeleccionado the criterioSeleccionado to set
     */
    public void setCriterioSeleccionado(String criterioSeleccionado) {
        this.criterioSeleccionado = criterioSeleccionado;
    }

    @Override
    public String execute() throws Exception {
        listaNivelesEstudios = listas.consultarNivelesEstudiosAplicaUCentral();
        listaFacultades = listas.consultarFacultades();
        if (seleccionNivelEstudios != null && seleccionFacultades != null && seleccionNivelEstudios.size() > 0 && seleccionFacultades.size() > 0)
            listaProgramas = listas.consultarProgramasPorListaFacultadYNivelEstudios(seleccionFacultades, seleccionNivelEstudios);
        
        criterioSeleccionado = "Este es el criterio seleccionado";
        
        return SUCCESS;
    }
    
    public String getJSON() throws Exception {
        return execute();
    }
    
    public String index() {
        return SUCCESS;
    }
}