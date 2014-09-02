/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.AreaEstudios;
import Modelo.Ciudad;
import Modelo.DominioLenguaExt;
import Modelo.EstadoEducacion;
import Modelo.Idioma;
import Modelo.Institucion;
import Modelo.LenguaExtranjera;
import Modelo.Mes;
import Modelo.Modalidad;
import Util.Listas;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author YURY
 */
public class LenguaExtranjeraAction extends CrudAction<LenguaExtranjera> {
    private Map<Long, Mes> listaMeses;
    private Map<Long, EstadoEducacion> listaEstadosEducacion;
    private Map<Long, AreaEstudios> listaAreasEstudios;
    private Map<Long, Ciudad> listaCiudades;
    private Map<Long, Institucion> listaInstituciones;
    private Map<Long, Modalidad> listaModalidades;
    private ArrayList<Integer> listaAnios;
    private Map<Long, DominioLenguaExt> listaDominioLenguaExt;
    private Map<Long, Idioma> listaIdiomas;
    private long mesInicio;
    private long mesFinalizacion;
    private long estadoEducacion;
    private long areaEstudios;
    private long ciudad;
    private long institucion;
    private long modalidad;
    private long dominio;
    private long idioma;
    
    public LenguaExtranjeraAction() {
        super(LenguaExtranjera.class.getName());
        this.idObjeto = "getIdEducacion";
        this.coleccion = "getLenguaExtranjera";
        this.claseConcretaPersistencia = Persistencia.LenguaExtranjera.class;
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
     * @return the listaDominioLenguaExt
     */
    public Collection<DominioLenguaExt> getListaDominioLenguaExt() {
        return listaDominioLenguaExt.values();
    }

    /**
     * @param listaDominioLenguaExt the listaDominioLenguaExt to set
     */
    public void setListaDominioLenguaExt(Map<Long, DominioLenguaExt> listaDominioLenguaExt) {
        this.listaDominioLenguaExt = listaDominioLenguaExt;
    }

    /**
     * @return the listaIdiomas
     */
    public Collection<Idioma> getListaIdiomas() {
        return listaIdiomas.values();
    }

    /**
     * @param listaIdiomas the listaIdiomas to set
     */
    public void setListaIdiomas(Map<Long, Idioma> listaIdiomas) {
        this.listaIdiomas = listaIdiomas;
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
     * @return the dominio
     */
    public long getDominio() {
        return dominio;
    }

    /**
     * @param dominio the dominio to set
     */
    public void setDominio(long dominio) {
        this.dominio = dominio;
    }

    /**
     * @return the idioma
     */
    public long getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(long idioma) {
        this.idioma = idioma;
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
        this.setListaDominioLenguaExt(Listas.obtenerListas().getListaDominioLenguaExt());
        this.setListaIdiomas(Listas.obtenerListas().getListaIdiomas());
        
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
        this.objeto.setIdDominio(Listas.obtenerListas().getListaDominioLenguaExt().get(this.dominio));
        this.objeto.setIdIdioma(Listas.obtenerListas().getListaIdiomas().get(this.idioma));
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
        this.setDominio(objeto.getIdDominio().getIdDominioLenguaExt());
        this.setIdioma(objeto.getIdIdioma().getIdIdioma());
    }

    @Override
    public void insertarValoresDefecto() {
        this.objeto.setEstado(true);
        this.objeto.setFechaRegistro(Date.valueOf(LocalDate.now()));
        this.objeto.setFechaActEstado(Date.valueOf(LocalDate.now()));
    }    
}
