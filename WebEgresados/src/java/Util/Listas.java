/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

import Controlador.ControladorListas;
import Modelo.Ciudad;
import Modelo.Departamento;
import Modelo.EstadoCivil;
import Modelo.Genero;
import Modelo.GrupoSanguineo;
import Modelo.Pais;
import Modelo.TipoContacto;
import Modelo.TipoDocumento;
import java.util.ArrayList;

/**
 *
 * @author YURY
 */
public final class Listas {
    private ArrayList<Pais> listaPaises;
    private ArrayList<Departamento> listaDepartamentos;
    private ArrayList<Ciudad> listaCiudades;
    private ArrayList<TipoDocumento> listaTiposDocumento;
    private ArrayList<GrupoSanguineo> listaGruposSanguineos;
    private ArrayList<Genero> listaGeneros;
    private ArrayList<EstadoCivil> listaEstadosCiviles;
    private ArrayList<TipoContacto> listaTiposContacto;

    private Listas()
    {
        ControladorListas cl = new ControladorListas();
        setListaPaises(cl.obtenerPaises());
        setListaCiudades(cl.obtenerCiudadesPorDepartamento(1));
        setListaDepartamentos(cl.obtenerDepartamentosPorPais(1));
        setListaEstadosCiviles(cl.obtenerEstadosCiviles());
        setListaGeneros(cl.obtenerGeneros());
        setListaGruposSanguineos(cl.obtenerGruposSanguineos());
        setListaTiposDocumento(cl.obtenerTiposDocumento());
        setListaTiposContacto(cl.obtenerTiposContacto());
    }
    
    private static Listas listas;
    
    public static Listas obtenerLilstas()
    {
        if (listas == null)
            listas = new Listas();
        
        return listas;
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
    
    public ArrayList<TipoContacto> getListaTiposContacto() {
        return listaTiposContacto;
    }

    public void setListaTiposContacto(ArrayList<TipoContacto> listaTiposContacto) {
        this.listaTiposContacto = listaTiposContacto;
    }
}
