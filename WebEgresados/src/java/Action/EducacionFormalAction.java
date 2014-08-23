/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

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
import Util.Listas;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author YURY
 */
public class EducacionFormalAction extends CrudAction<EducacionFormal> {
    private Map<Long, Mes> listaMeses;
    private Map<Long, Ciudad> listaCiudades;
    private Map<Long, EstadoEducacion> listaEstadosEducacion;
    private Map<Long, AreaEstudios> listaAreasEstudios;
    private Map<Long, Modalidad> listaModalidades;
    private Map<Long, Institucion> listaInstituciones;
    private Map<Long, Jornada> listaJornadas;
    private Map<Long, Programa> listaProgramas;
    private Map<Long, NivelEstudios> listaNivelesEstudios;
    private ArrayList<Integer> listaAnios;
    private long mesInicio;
    private long ciudad;
    private long mesFinalizacion;
    private long estadoEducacion;
    private long areaEstudios;
    private long modalidad;
    private long institucion;
    private long programa;
    private long jornada;
    private long nivelEstudios;
    
            
    public EducacionFormalAction() {
        super(EducacionFormal.class.getName());
        this.idObjeto = "getIdEducacion";
        this.coleccion = "getEducacionCollection";
        this.clasePersistencia = Persistencia.EducacionFormal.class.getName();
    }

    /**
     * @return the listaMeses
     */
    public Collection<Mes> getListaMeses() {
        return listaMeses.values();
    }

    /**
     * @param listaMeses the listaMeses to set
     */
    public void setListaMeses(Map<Long, Mes> listaMeses) {
        this.listaMeses = listaMeses;
    }

    /**
     * @return the listaCiudades
     */
    public Collection<Ciudad> getListaCiudades() {
        return listaCiudades.values();
    }

    /**
     * @param listaCiudades the listaCiudades to set
     */
    public void setListaCiudades(Map<Long, Ciudad> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }

    /**
     * @return the listaEstadosEducacion
     */
    public Collection<EstadoEducacion> getListaEstadosEducacion() {
        return listaEstadosEducacion.values();
    }

    /**
     * @param listaEstadosEducacion the listaEstadosEducacion to set
     */
    public void setListaEstadosEducacion(Map<Long, EstadoEducacion> listaEstadosEducacion) {
        this.listaEstadosEducacion = listaEstadosEducacion;
    }

    /**
     * @return the listaAreasEstudios
     */
    public Collection<AreaEstudios> getListaAreasEstudios() {
        return listaAreasEstudios.values();
    }

    /**
     * @param listaAreasEstudios the listaAreasEstudios to set
     */
    public void setListaAreasEstudios(Map<Long, AreaEstudios> listaAreasEstudios) {
        this.listaAreasEstudios = listaAreasEstudios;
    }

    /**
     * @return the listaModalidades
     */
    public Collection<Modalidad> getListaModalidades() {
        return listaModalidades.values();
    }

    /**
     * @param listaModalidades the listaModalidades to set
     */
    public void setListaModalidades(Map<Long, Modalidad> listaModalidades) {
        this.listaModalidades = listaModalidades;
    }

    /**
     * @return the listaInstituciones
     */
    public Collection<Institucion> getListaInstituciones() {
        return listaInstituciones.values();
    }

    /**
     * @param listaInstituciones the listaInstituciones to set
     */
    public void setListaInstituciones(Map<Long, Institucion> listaInstituciones) {
        this.listaInstituciones = listaInstituciones;
    }

    /**
     * @return the listaJornadas
     */
    public Collection<Jornada> getListaJornadas() {
        return listaJornadas.values();
    }

    /**
     * @param listaJornadas the listaJornadas to set
     */
    public void setListaJornadas(Map<Long, Jornada> listaJornadas) {
        this.listaJornadas = listaJornadas;
    }

    /**
     * @return the listaProgramas
     */
    public Collection<Programa> getListaProgramas() {
        return listaProgramas.values();
    }

    /**
     * @param listaProgramas the listaProgramas to set
     */
    public void setListaProgramas(Map<Long, Programa> listaProgramas) {
        this.listaProgramas = listaProgramas;
    }

    /**
     * @return the listaNivelesEstudios
     */
    public Collection<NivelEstudios> getListaNivelesEstudios() {
        return listaNivelesEstudios.values();
    }

    /**
     * @param listaNivelesEstudios the listaNivelesEstudios to set
     */
    public void setListaNivelesEstudios(Map<Long, NivelEstudios> listaNivelesEstudios) {
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

    /**
     * @return the mesInicio
     */
    public long getMesInicio() {
        return mesInicio;
    }

    /**
     * @param mesInicio the mesInicio to set
     */
    public void setMesInicio(long mesInicio) {
        this.mesInicio = mesInicio;
    }

    /**
     * @return the ciudad
     */
    public long getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(long ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the mesFinalizacion
     */
    public long getMesFinalizacion() {
        return mesFinalizacion;
    }

    /**
     * @param mesFinalizacion the mesFinalizacion to set
     */
    public void setMesFinalizacion(long mesFinalizacion) {
        this.mesFinalizacion = mesFinalizacion;
    }

    /**
     * @return the estadoEducacion
     */
    public long getEstadoEducacion() {
        return estadoEducacion;
    }

    /**
     * @param estadoEducacion the estadoEducacion to set
     */
    public void setEstadoEducacion(long estadoEducacion) {
        this.estadoEducacion = estadoEducacion;
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

    /**
     * @return the modalidad
     */
    public long getModalidad() {
        return modalidad;
    }

    /**
     * @param modalidad the modalidad to set
     */
    public void setModalidad(long modalidad) {
        this.modalidad = modalidad;
    }

    /**
     * @return the institucion
     */
    public long getInstitucion() {
        return institucion;
    }

    /**
     * @param institucion the institucion to set
     */
    public void setInstitucion(long institucion) {
        this.institucion = institucion;
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

    /**
     * @return the jornada
     */
    public long getJornada() {
        return jornada;
    }

    /**
     * @param jornada the jornada to set
     */
    public void setJornada(long jornada) {
        this.jornada = jornada;
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
    
    @Override
    public String desplegar() {
        this.setListaAreasEstudios(Listas.obtenerListas().getListaAreasEstudios());
        this.setListaCiudades(Listas.obtenerListas().getListaCiudades());
        this.setListaEstadosEducacion(Listas.obtenerListas().getListaEstadosEducacion());
        this.setListaInstituciones(Listas.obtenerListas().getListaInstituciones());
        this.setListaMeses(Listas.obtenerListas().getListaMeses());
        this.setListaModalidades(Listas.obtenerListas().getListaModalidades());
        this.setListaJornadas(Listas.obtenerListas().getListaJornadas());
        this.setListaNivelesEstudios(Listas.obtenerListas().getListaNivelesEstudios());
        this.setListaProgramas(Listas.obtenerListas().getListaProgramas());
        this.setListaAnios(Listas.obtenerListas().getListaAnios());
        
        this.obtenerLista();
        this.editar = true;
        return SUCCESS;
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdAreaEstudios(Listas.obtenerListas().getListaAreasEstudios().get(this.areaEstudios));
        this.objeto.setIdCiudad(Listas.obtenerListas().getListaCiudades().get(this.ciudad));
        this.objeto.setIdEstadoEducacion(Listas.obtenerListas().getListaEstadosEducacion().get(this.estadoEducacion));
        this.objeto.setIdInstitucion(Listas.obtenerListas().getListaInstituciones().get(this.institucion));
        this.objeto.setIdJornada(Listas.obtenerListas().getListaJornadas().get(this.jornada));
        this.objeto.setIdMesFinalizacion(Listas.obtenerListas().getListaMeses().get(this.mesFinalizacion));
        this.objeto.setIdMesInicio(Listas.obtenerListas().getListaMeses().get(this.mesInicio));
        this.objeto.setIdModalidad(Listas.obtenerListas().getListaModalidades().get(this.modalidad));
        this.objeto.setIdNivelEstudios(Listas.obtenerListas().getListaNivelesEstudios().get(this.nivelEstudios));
        this.objeto.setIdPrograma(Listas.obtenerListas().getListaProgramas().get(this.programa));
    }

    @Override
    public void consultarTipos() {
        this.setAreaEstudios(objeto.getIdAreaEstudios().getIdAreaEstudios());
        this.setCiudad(objeto.getIdCiudad().getIdCiudad());
        this.setEstadoEducacion(objeto.getIdEstadoEducacion().getIdEstadoEducacion());
        this.setInstitucion(objeto.getIdInstitucion().getIdInstitucion());
        this.setJornada(objeto.getIdJornada().getIdJornada());
        this.setMesFinalizacion(objeto.getIdMesFinalizacion().getIdMes());
        this.setMesInicio(objeto.getIdMesInicio().getIdMes());
        this.setModalidad(objeto.getIdModalidad().getIdModalidad());
        this.setNivelEstudios(objeto.getIdNivelEstudios().getIdNivelEstudios());
        this.setPrograma(objeto.getIdPrograma().getIdPrograma());
    }

    @Override
    public void insertarValoresDefecto() {
        this.objeto.setEstado(true);
        this.objeto.setFechaRegistro(Date.valueOf(LocalDate.now()));
        this.objeto.setFechaActEstado(Date.valueOf(LocalDate.now()));
    }
}
