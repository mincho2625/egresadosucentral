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
public class SelectDobleCiudadAction extends ActionSupport {
    private List<ItemLista> listaPaises;
    private List<ItemLista> listaDepartamentos;
    private List<ItemLista> listaCiudades;
    private List<ItemLista> listaPaises2;
    private List<ItemLista> listaDepartamentos2;
    private List<ItemLista> listaCiudades2;
    private long pais;
    private long departamento;
    private long pais2;
    private long departamento2;
    private final Listas listas;

    public SelectDobleCiudadAction()
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
     * @return the listaPaises2
     */
    public List<ItemLista> getListaPaises2() {
        return listaPaises2;
    }

    /**
     * @param listaPaises2 the listaPaises2 to set
     */
    public void setListaPaises2(List<ItemLista> listaPaises2) {
        this.listaPaises2 = listaPaises2;
    }

    /**
     * @return the listaDepartamentos2
     */
    public List<ItemLista> getListaDepartamentos2() {
        return listaDepartamentos2;
    }

    /**
     * @param listaDepartamentos2 the listaDepartamentos2 to set
     */
    public void setListaDepartamentos2(List<ItemLista> listaDepartamentos2) {
        this.listaDepartamentos2 = listaDepartamentos2;
    }

    /**
     * @return the listaCiudades2
     */
    public List<ItemLista> getListaCiudades2() {
        return listaCiudades2;
    }

    /**
     * @param listaCiudades2 the listaCiudades2 to set
     */
    public void setListaCiudades2(List<ItemLista> listaCiudades2) {
        this.listaCiudades2 = listaCiudades2;
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

    /**
     * @return the pais2
     */
    public long getPais2() {
        return pais2;
    }

    /**
     * @param pais2 the pais2 to set
     */
    public void setPais2(long pais2) {
        this.pais2 = pais2;
    }

    /**
     * @return the departamento2
     */
    public long getDepartamento2() {
        return departamento2;
    }

    /**
     * @param departamento2 the departamento2 to set
     */
    public void setDepartamento2(long departamento2) {
        this.departamento2 = departamento2;
    }
   
    //http://stackoverflow.com/questions/23746323/3-or-more-dependent-drop-down-using-struts2
    @Override
    public String execute() throws Exception {
        setListaPaises(listas.consultarPaises());
        if (getPais() > 0){
            setListaDepartamentos(listas.consultarDepartamentosPorPais(getPais()));
            System.out.println("Pais: " + pais + ", Departamentos: " + listaDepartamentos.size());
        }
        if (getDepartamento() > 0)
            setListaCiudades(listas.consultarCiudadesPorDepartamento(getDepartamento()));
        
        setListaPaises2(listas.consultarPaises());
        if (getPais2() > 0)
            setListaDepartamentos2(listas.consultarDepartamentosPorPais(getPais2()));
        if (getDepartamento2() > 0)
            setListaCiudades2(listas.consultarCiudadesPorDepartamento(getDepartamento2()));
        
        return SUCCESS;
    }
    
    public String getJSON() throws Exception {
        return execute();
    }
    
    public String index() {
        return SUCCESS;
    }
}