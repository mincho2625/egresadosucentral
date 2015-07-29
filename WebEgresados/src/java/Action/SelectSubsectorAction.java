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
 * @author YURY
 */
public class SelectSubsectorAction extends ActionSupport {
    private List<ItemLista> listaSectores;
    private List<ItemLista> listaSubsectores;
    private long sector;
    private long subsector;
    private final ControladorListas listas;
    
    public SelectSubsectorAction()
    {
        listas = new ControladorListas();
    }

    /**
     * @return the listaSectores
     */
    public List<ItemLista> getListaSectores() {
        return listaSectores;
    }

    /**
     * @param listaSectores the listaSectores to set
     */
    public void setListaSectores(List<ItemLista> listaSectores) {
        this.listaSectores = listaSectores;
    }

    /**
     * @return the listaSubsectores
     */
    public List<ItemLista> getListaSubsectores() {
        return listaSubsectores;
    }

    /**
     * @param listaSubsectores the listaSubsectores to set
     */
    public void setListaSubsectores(List<ItemLista> listaSubsectores) {
        this.listaSubsectores = listaSubsectores;
    }

    /**
     * @return the sector
     */
    public long getSector() {
        return sector;
    }

    /**
     * @param sector the sector to set
     */
    public void setSector(long sector) {
        this.sector = sector;
    }

    /**
     * @return the subsector
     */
    public long getSubsector() {
        return subsector;
    }

    /**
     * @param subsector the subsector to set
     */
    public void setSubsector(long subsector) {
        this.subsector = subsector;
    }

    @Override
    public String execute() throws Exception {
        listaSectores = listas.consultarSectores();
        if (sector > 0)
            listaSubsectores = listas.consultarSubsectoresPorSector(sector);
        
        return SUCCESS;
    }
    
    public String getJSON() throws Exception {
        return execute();
    }
    
    public String index() {
        return SUCCESS;
    }
}
