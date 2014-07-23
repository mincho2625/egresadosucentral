/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Ciudad;
import Modelo.Departamento;
import Modelo.Egresado;
import Modelo.EstadoCivil;
import Modelo.Genero;
import Modelo.GrupoSanguineo;
import Modelo.Pais;
import Modelo.TipoDocumento;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;

/**
 *
 * @author YURY
 */
public class RegistroAction extends ActionSupport implements ModelDriven<Egresado>{

    ControladorListas cl = new ControladorListas();
    private Egresado egresado = new Egresado();
    private ArrayList<Pais> listaPaises = cl.obtenerPaises();
    private ArrayList<Departamento> listaDepartamentos = cl.obtenerDepartamentosPorPais(1);
    private ArrayList<Ciudad> listaCiudades = cl.obtenerCiudadesPorDepartamento(1);
    private ArrayList<TipoDocumento> listaTiposDocumento = cl.obtenerTiposDocumento();
    private ArrayList<GrupoSanguineo> listaGruposSanguineos = cl.obtenerGruposSanguineos();
    private ArrayList<Genero> listaGeneros = cl.obtenerGeneros();
    private ArrayList<EstadoCivil> listaEstadosCiviles = cl.obtenerEstadosCiviles();
            
    /**
     * @return the egresado
     */
    public Egresado getEgresado() {
        return egresado;
    }

    /**
     * @param egresado the egresado to set
     */
    public void setEgresado(Egresado egresado) {
        this.egresado = egresado;
    }

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

    /**
     * @return the listaDepartamentos
     */
    public ArrayList<Departamento> getListaDepartamentos() {
        return listaDepartamentos;
    }

    /**
     * @param listaDepartamentos the listaDepartamentos to set
     */
    public void setListaDepartamentos(ArrayList<Departamento> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
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

    /**
     * @return the listaTiposDocumento
     */
    public ArrayList<TipoDocumento> getListaTiposDocumento() {
        return listaTiposDocumento;
    }

    /**
     * @param listaTiposDocumento the listaTiposDocumento to set
     */
    public void setListaTiposDocumento(ArrayList<TipoDocumento> listaTiposDocumento) {
        this.listaTiposDocumento = listaTiposDocumento;
    }

    /**
     * @return the listaGruposSanguineos
     */
    public ArrayList<GrupoSanguineo> getListaGruposSanguineos() {
        return listaGruposSanguineos;
    }

    /**
     * @param listaGruposSanguineos the listaGruposSanguineos to set
     */
    public void setListaGruposSanguineos(ArrayList<GrupoSanguineo> listaGruposSanguineos) {
        this.listaGruposSanguineos = listaGruposSanguineos;
    }

    /**
     * @return the listaGeneros
     */
    public ArrayList<Genero> getListaGeneros() {
        return listaGeneros;
    }

    /**
     * @param listaGeneros the listaGeneros to set
     */
    public void setListaGeneros(ArrayList<Genero> listaGeneros) {
        this.listaGeneros = listaGeneros;
    }

    /**
     * @return the listaEstadosCiviles
     */
    public ArrayList<EstadoCivil> getListaEstadosCiviles() {
        return listaEstadosCiviles;
    }

    /**
     * @param listaEstadosCiviles the listaEstadosCiviles to set
     */
    public void setListaEstadosCiviles(ArrayList<EstadoCivil> listaEstadosCiviles) {
        this.listaEstadosCiviles = listaEstadosCiviles;
    }
    
    public String populate()
    {
        //
        setListaPaises(cl.obtenerPaises());
        setListaCiudades(cl.obtenerCiudadesPorDepartamento(1));
        setListaDepartamentos(cl.obtenerDepartamentosPorPais(1));
        setListaEstadosCiviles(cl.obtenerEstadosCiviles());
        setListaGeneros(cl.obtenerGeneros());
        setListaGruposSanguineos(cl.obtenerGruposSanguineos());
        setListaTiposDocumento(cl.obtenerTiposDocumento());
        
        return "populate";
    }
    
    public String execute()
    {
        ControladorEgresado ce = new ControladorEgresado();
        ce.actualizarInformacionBasica(getEgresado());
        return SUCCESS;
    }

    @Override
    public Egresado getModel() {
        return getEgresado();
    }
}