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
 * @author YURY
 */
public class SelectCiudadAction extends ActionSupport {
    private List<ItemLista> listaPaises;
    private List<ItemLista> listaDepartamentos;
    private List<ItemLista> listaCiudades;    
    private long pais;
    private long departamento;
    private final Listas listas;
    
    public SelectCiudadAction()
    {
        listas = new Listas();
    }

    /**
     * @return the listaPaises
     */
    public List<ItemLista> getListaPaises() {
        return listaPaises;
    }

    /**
     * @param listaPaises the listaPaises to set
     */
    public void setListaPaises(List<ItemLista> listaPaises) {
        this.listaPaises = listaPaises;
    }

    /**
     * @return the listaDepartamentos
     */
    public List<ItemLista> getListaDepartamentos() {
        return listaDepartamentos;
    }

    /**
     * @param listaDepartamentos the listaDepartamentos to set
     */
    public void setListaDepartamentos(List<ItemLista> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    /**
     * @return the listaCiudades
     */
    public List<ItemLista> getListaCiudades() {
        return listaCiudades;
    }

    /**
     * @param listaCiudades the listaCiudades to set
     */
    public void setListaCiudades(List<ItemLista> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }

    /**
     * @return the pais
     */
    public long getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(long pais) {
        this.pais = pais;
    }

    /**
     * @return the departamento
     */
    public long getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(long departamento) {
        this.departamento = departamento;
    }
    
    //http://stackoverflow.com/questions/23746323/3-or-more-dependent-drop-down-using-struts2
    @Override
    public String execute() throws Exception {
        setListaPaises(listas.consultarPaises());
        System.out.println("Paises: " + listaPaises.size());
        if (getPais() > 0){
            setListaDepartamentos(listas.consultarDepartamentosPorPais(getPais()));
            System.out.println("Pais: " + pais + ", Departamentos: " + listaDepartamentos.size());
        }
        if (getDepartamento() > 0)
            setListaCiudades(listas.consultarCiudadesPorDepartamento(getDepartamento()));
        
        return SUCCESS;
    }
    
    public String getJSON() throws Exception {
        return execute();
    }
    
    public String index() {
        return SUCCESS;
    }
}