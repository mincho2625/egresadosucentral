/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorListas;
import Modelo.AreaEstudios;
import Modelo.Ciudad;
import Modelo.EducacionFormal;
import Modelo.EstadoEducacion;
import Modelo.Institucion;
import Modelo.Jornada;
import Modelo.Mes;
import Modelo.Modalidad;
import Modelo.NivelEstudios;
import Modelo.Programa;
import java.util.ArrayList;

/**
 *
 * @author YURY
 */
public class EducacionFormalAction extends CrudAction<EducacionFormal> {
    private ArrayList<Mes> listaMeses;
    private ArrayList<Ciudad> listaCiudades;
    private ArrayList<EstadoEducacion> listaEstadosEducacion;
    private ArrayList<AreaEstudios> listaAreasEstudios;
    private ArrayList<Modalidad> listaModalidades;
    private ArrayList<Institucion> listaInstituciones;
    private ArrayList<Jornada> listaJornadas;
    private ArrayList<Programa> listaProgramas;
    private ArrayList<NivelEstudios> listaNivelesEstudios;
    private ArrayList<Integer> listaAnios;
    private ControladorListas controladorListas = new ControladorListas();
    
    public EducacionFormalAction() {
        super("Modelo.EducacionFormal");
        this.metodoBorrar = "borrarDatosEducacionFormal";
        this.metodoConsultar = "consultarDatosEducacionFormal";
        this.metodoActualizar = "actualizarDatosEducacion";
    }

    /**
     * @return the listaMeses
     */
    public ArrayList<Mes> getListaMeses() {
        return listaMeses;
    }

    /**
     * @param listaMeses the listaMeses to set
     */
    public void setListaMeses(ArrayList<Mes> listaMeses) {
        this.listaMeses = listaMeses;
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
     * @return the listaEstadosEducacion
     */
    public ArrayList<EstadoEducacion> getListaEstadosEducacion() {
        return listaEstadosEducacion;
    }

    /**
     * @param listaEstadosEducacion the listaEstadosEducacion to set
     */
    public void setListaEstadosEducacion(ArrayList<EstadoEducacion> listaEstadosEducacion) {
        this.listaEstadosEducacion = listaEstadosEducacion;
    }

    /**
     * @return the listaAreasEstudios
     */
    public ArrayList<AreaEstudios> getListaAreasEstudios() {
        return listaAreasEstudios;
    }

    /**
     * @param listaAreasEstudios the listaAreasEstudios to set
     */
    public void setListaAreasEstudios(ArrayList<AreaEstudios> listaAreasEstudios) {
        this.listaAreasEstudios = listaAreasEstudios;
    }

    /**
     * @return the listaModalidades
     */
    public ArrayList<Modalidad> getListaModalidades() {
        return listaModalidades;
    }

    /**
     * @param listaModalidades the listaModalidades to set
     */
    public void setListaModalidades(ArrayList<Modalidad> listaModalidades) {
        this.listaModalidades = listaModalidades;
    }

    /**
     * @return the listaInstituciones
     */
    public ArrayList<Institucion> getListaInstituciones() {
        return listaInstituciones;
    }

    /**
     * @param listaInstituciones the listaInstituciones to set
     */
    public void setListaInstituciones(ArrayList<Institucion> listaInstituciones) {
        this.listaInstituciones = listaInstituciones;
    }
    
    /**
     * @return the listaJornadas
     */
    public ArrayList<Jornada> getListaJornadas() {
        return listaJornadas;
    }

    /**
     * @param listaJornadas the listaJornadas to set
     */
    public void setListaJornadas(ArrayList<Jornada> listaJornadas) {
        this.listaJornadas = listaJornadas;
    }

    /**
     * @return the listaProgramas
     */
    public ArrayList<Programa> getListaProgramas() {
        return listaProgramas;
    }

    /**
     * @param listaProgramas the listaProgramas to set
     */
    public void setListaProgramas(ArrayList<Programa> listaProgramas) {
        this.listaProgramas = listaProgramas;
    }

    /**
     * @return the listaNivelesEstudios
     */
    public ArrayList<NivelEstudios> getListaNivelesEstudios() {
        return listaNivelesEstudios;
    }

    /**
     * @param listaNivelesEstudios the listaNivelesEstudios to set
     */
    public void setListaNivelesEstudios(ArrayList<NivelEstudios> listaNivelesEstudios) {
        this.listaNivelesEstudios = listaNivelesEstudios;
    }
    
    /**
     * @return the listaAnios
     */
    public ArrayList<Integer> getListaAnios() {
        return listaAnios;
    }

    /**
     * @param listaAnios the listaAnios to set
     */
    public void setListaAnios(ArrayList<Integer> listaAnios) {
        this.listaAnios = listaAnios;
    }
    
    @Override
    public String desplegar() {
        this.obtenerLista();
        this.setListaAreasEstudios(controladorListas.consultarAreasEstudios());
        this.setListaCiudades(controladorListas.obtenerCiudades());
        this.setListaEstadosEducacion(controladorListas.consultarEstadosEducacion());
        this.setListaInstituciones(controladorListas.consultarInstituciones());
        this.setListaMeses(controladorListas.consultarMeses());
        this.setListaModalidades(controladorListas.consultarModalidades());
        this.setListaJornadas(controladorListas.consultarJornadas());
        this.setListaNivelesEstudios(controladorListas.consultarNivelesEstudios());
        this.setListaProgramas(controladorListas.consultarProgramas());
        this.setListaAnios(controladorListas.consultarAnios());
        
        this.editar = true;
        return SUCCESS;
    }
}
