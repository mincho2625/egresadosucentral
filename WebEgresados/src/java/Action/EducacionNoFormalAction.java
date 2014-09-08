/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Modelo.AreaEstudios;
import Modelo.Ciudad;
import Modelo.EducacionNoFormal;
import Modelo.EstadoEducacion;
import Modelo.Institucion;
import Modelo.IntensidadHoraria;
import Modelo.Mes;
import Modelo.Modalidad;
import Modelo.TipoEdNoFormal;
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
public class EducacionNoFormalAction extends CrudAction<EducacionNoFormal> {

    private Map<Long, Mes> listaMeses;
    private Map<Long, EstadoEducacion> listaEstadosEducacion;
    private Map<Long, AreaEstudios> listaAreasEstudios;
    private Map<Long, Ciudad> listaCiudades;
    private Map<Long, Institucion> listaInstituciones;
    private Map<Long, Modalidad> listaModalidades;
    private ArrayList<Integer> listaAnios;
    private Map<Long, TipoEdNoFormal> listaTiposEdNoFormal;
    private Map<Long, IntensidadHoraria> listaIntensidadesHorarias;
    private long mesInicio;
    private long mesFinalizacion;
    private long estadoEducacion;
    private long areaEstudios;
    private long ciudad;
    private long institucion;
    private long modalidad;
    private long tipoEdNoFormal;
    private long intensidadHoraria;

    public EducacionNoFormalAction() {
        super(EducacionNoFormal.class.getName());
        this.idObjeto = "getIdEducacion";
        this.coleccion = "getEducacionNoFormal";
        this.claseConcretaPersistencia = Persistencia.EducacionNoFormal.class;
        this.claseBasePersistencia = Persistencia.Educacion.class;
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
     * @return the listaTiposEdNoFormal
     */
    public Collection<TipoEdNoFormal> getListaTiposEdNoFormal() {
        return listaTiposEdNoFormal.values();
    }

    /**
     * @param listaTiposEdNoFormal the listaTiposEdNoFormal to set
     */
    public void setListaTiposEdNoFormal(Map<Long, TipoEdNoFormal> listaTiposEdNoFormal) {
        this.listaTiposEdNoFormal = listaTiposEdNoFormal;
    }

    /**
     * @return the listaIntensidadesHorarias
     */
    public Collection<IntensidadHoraria> getListaIntensidadesHorarias() {
        return listaIntensidadesHorarias.values();
    }

    /**
     * @param listaIntensidadesHorarias the listaIntensidadesHorarias to set
     */
    public void setListaIntensidadesHorarias(Map<Long, IntensidadHoraria> listaIntensidadesHorarias) {
        this.listaIntensidadesHorarias = listaIntensidadesHorarias;
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
     * @return the tipoEdNoFormal
     */
    public long getTipoEdNoFormal() {
        return tipoEdNoFormal;
    }

    /**
     * @param tipoEdNoFormal the tipoEdNoFormal to set
     */
    public void setTipoEdNoFormal(long tipoEdNoFormal) {
        this.tipoEdNoFormal = tipoEdNoFormal;
    }

    /**
     * @return the intensidadHoraria
     */
    public long getIntensidadHoraria() {
        return intensidadHoraria;
    }

    /**
     * @param intensidadHoraria the intensidadHoraria to set
     */
    public void setIntensidadHoraria(long intensidadHoraria) {
        this.intensidadHoraria = intensidadHoraria;
    }

    @Override
    public String desplegar() {
        this.setListaEstadosEducacion(Listas.obtenerListas().getListaEstadosEducacion());
        this.setListaMeses(Listas.obtenerListas().getListaMeses());
        this.setListaAnios(Listas.obtenerListas().getListaAnios());
        this.setListaAreasEstudios(Listas.obtenerListas().getListaAreasEstudios());
        this.setListaCiudades(Listas.obtenerListas().getListaCiudades());
        this.setListaInstituciones(Listas.obtenerListas().getListaInstituciones());
        this.setListaModalidades(Listas.obtenerListas().getListaModalidades());
        this.setListaIntensidadesHorarias(Listas.obtenerListas().getListaIntensidadesHorarias());
        this.setListaTiposEdNoFormal(Listas.obtenerListas().getListaTiposEdNoFormal());

        this.obtenerLista();
        this.editar = true;
        return SUCCESS;
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdEstadoEducacion(Listas.obtenerListas().getListaEstadosEducacion().get(this.estadoEducacion));
        this.objeto.setIdMesFinalizacion(Listas.obtenerListas().getListaMeses().get(this.mesFinalizacion));
        this.objeto.setIdMesInicio(Listas.obtenerListas().getListaMeses().get(this.mesInicio));
        this.objeto.setIdAreaEstudios(Listas.obtenerListas().getListaAreasEstudios().get(this.areaEstudios));
        this.objeto.setIdCiudad(Listas.obtenerListas().getListaCiudades().get(this.ciudad));
        this.objeto.setIdInstitucion(Listas.obtenerListas().getListaInstituciones().get(this.institucion));
        this.objeto.setIdModalidad(Listas.obtenerListas().getListaModalidades().get(this.modalidad));
        this.objeto.setIdIntensidadHoraria(Listas.obtenerListas().getListaIntensidadesHorarias().get(this.intensidadHoraria));
        this.objeto.setIdTipoEdNoFormal(Listas.obtenerListas().getListaTiposEdNoFormal().get(this.tipoEdNoFormal));
    }

    @Override
    public void consultarTipos() {
        this.setEstadoEducacion(objeto.getIdEstadoEducacion().getIdEstadoEducacion());
        this.setMesFinalizacion(objeto.getIdMesFinalizacion().getIdMes());
        this.setMesInicio(objeto.getIdMesInicio().getIdMes());
        this.setAreaEstudios(objeto.getIdAreaEstudios().getIdAreaEstudios());
        this.setCiudad(objeto.getIdCiudad().getIdCiudad());
        this.setInstitucion(objeto.getIdInstitucion().getIdInstitucion());
        this.setModalidad(objeto.getIdModalidad().getIdModalidad());
        this.setIntensidadHoraria(objeto.getIdIntensidadHoraria().getIdIntensidadHoraria());
        this.setTipoEdNoFormal(objeto.getIdTipoEdNoFormal().getIdTipoEdNoFormal());
    }

    @Override
    public void insertarValoresDefecto() {
        this.objeto.setEstado(true);
        this.objeto.setFechaRegistro(Date.valueOf(LocalDate.now()));
        this.objeto.setFechaActEstado(Date.valueOf(LocalDate.now()));
    }

    @Override
    public void validate() {
        if (objeto.getTitulo() != null) {
            if (objeto.getTitulo().equals("")) {
                addFieldError("titulo", "Digite el titulo");
            }
        }
        if (objeto.getDescripcion()!= null) {
            if (objeto.getDescripcion().equals("")) {
             addFieldError("descri", "Digite ladescripcion");   
            }
        }
    }

}
