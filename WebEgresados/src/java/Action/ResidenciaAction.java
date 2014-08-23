/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.Ciudad;
import Modelo.Estrato;
import Modelo.Residencia;
import Modelo.TipoTenenciaVivienda;
import Modelo.TipoVivienda;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;

/**
 *
 * @author YURY
 */
public class ResidenciaAction extends CrudAction<Residencia> {
    private ArrayList<TipoVivienda> listaTiposVivienda;
    private ArrayList<TipoTenenciaVivienda> listaTiposTenenciaVivienda;
    private ArrayList<Estrato> listaEstratos;
    private ArrayList<Ciudad> listaCiudades;
    
    public ResidenciaAction()
    {
        super("Modelo.Residencia");
    }

    /**
     * @return the listaTiposVivienda
     */
    public ArrayList<TipoVivienda> getListaTiposVivienda() {
        return listaTiposVivienda;
    }

    /**
     * @param listaTiposVivienda the listaTiposVivienda to set
     */
    public void setListaTiposVivienda(ArrayList<TipoVivienda> listaTiposVivienda) {
        this.listaTiposVivienda = listaTiposVivienda;
    }

    /**
     * @return the listaTiposTenenciaVivienda
     */
    public ArrayList<TipoTenenciaVivienda> getListaTiposTenenciaVivienda() {
        return listaTiposTenenciaVivienda;
    }

    /**
     * @param listaTiposTenenciaVivienda the listaTiposTenenciaVivienda to set
     */
    public void setListaTiposTenenciaVivienda(ArrayList<TipoTenenciaVivienda> listaTiposTenenciaVivienda) {
        this.listaTiposTenenciaVivienda = listaTiposTenenciaVivienda;
    }

    /**
     * @return the listaEstratos
     */
    public ArrayList<Estrato> getListaEstratos() {
        return listaEstratos;
    }

    /**
     * @param listaEstratos the listaEstratos to set
     */
    public void setListaEstratos(ArrayList<Estrato> listaEstratos) {
        this.listaEstratos = listaEstratos;
    }
    
    /**
     * @return the listaCiudades
     */
    public ArrayList<Ciudad> getListaCiudades() {
        return listaCiudades;
    }

    /**
     * @param listaCiudades the listaCiudades to set
     */
    public void setListaCiudades(ArrayList<Ciudad> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }

    @Override
    public String desplegar()
    {
        this.obtenerLista();
//        this.setListaTiposVivienda(controladorListas.consultarTiposVivienda());
//        this.setListaTiposTenenciaVivienda(controladorListas.consultarTiposTenenciaVivienda());
//        this.setListaEstratos(controladorListas.consultarEstratos());
//        this.setListaCiudades(controladorListas.obtenerCiudades());
        this.editar = true;
        return SUCCESS;
    }

    @Override
    public void insertarTipos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultarTipos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertarValoresDefecto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}