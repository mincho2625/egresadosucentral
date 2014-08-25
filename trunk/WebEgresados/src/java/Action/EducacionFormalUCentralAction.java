/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.EducacionFormal;
import Modelo.EstadoEducacion;
import Modelo.Jornada;
import Modelo.Mes;
import Modelo.Programa;
import Util.Configuracion;
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
public class EducacionFormalUCentralAction extends CrudAction<EducacionFormal> {
    private Map<Long, Mes> listaMeses;
    private Map<Long, EstadoEducacion> listaEstadosEducacion;
    private Map<Long, Jornada> listaJornadas;
    private Map<Long, Programa> listaProgramas;
    private ArrayList<Integer> listaAnios;
    private long mesInicio;
    private long mesFinalizacion;
    private long estadoEducacion;
    private long programa;
    private long jornada;

    public EducacionFormalUCentralAction() {
        super(EducacionFormal.class.getName());
        this.idObjeto = "getIdEducacion";
        this.idObjeto2 = "setEducacionFormal";
        this.coleccion = "getEducacionFormalUcentral";
        this.clasePersistencia2 = Persistencia.EducacionFormal.class.getName();
        this.clasePersistencia = Persistencia.Educacion.class.getName();
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
    
    @Override
    public String desplegar() {
        this.setListaEstadosEducacion(Listas.obtenerListas().getListaEstadosEducacion());
        this.setListaMeses(Listas.obtenerListas().getListaMeses());
        this.setListaJornadas(Listas.obtenerListas().getListaJornadas());
        this.setListaProgramas(Listas.obtenerListas().getListaProgramas());
        this.setListaAnios(Listas.obtenerListas().getListaAnios());
        
        this.obtenerLista();
        this.editar = true;
        return SUCCESS;
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdEstadoEducacion(Listas.obtenerListas().getListaEstadosEducacion().get(this.estadoEducacion));
        this.objeto.setIdJornada(Listas.obtenerListas().getListaJornadas().get(this.jornada));
        this.objeto.setIdMesFinalizacion(Listas.obtenerListas().getListaMeses().get(this.mesFinalizacion));
        this.objeto.setIdMesInicio(Listas.obtenerListas().getListaMeses().get(this.mesInicio));
        this.objeto.setIdPrograma(Listas.obtenerListas().getListaProgramas().get(this.programa));
    }

    @Override
    public void consultarTipos() {
        this.setEstadoEducacion(objeto.getIdEstadoEducacion().getIdEstadoEducacion());
        this.setJornada(objeto.getIdJornada().getIdJornada());
        this.setMesFinalizacion(objeto.getIdMesFinalizacion().getIdMes());
        this.setMesInicio(objeto.getIdMesInicio().getIdMes());
        this.setPrograma(objeto.getIdPrograma().getIdPrograma());
    }

    @Override
    public void insertarValoresDefecto() {
        Configuracion configuracion = new Configuracion();
        this.objeto.setEstado(true);
        this.objeto.setFechaRegistro(Date.valueOf(LocalDate.now()));
        this.objeto.setFechaActEstado(Date.valueOf(LocalDate.now()));
        this.objeto.setIdAreaEstudios(configuracion.getIdAreaEstudios());
        this.objeto.setIdCiudad(configuracion.getIdCiudadUcentral());
        this.objeto.setIdInstitucion(configuracion.getIdInstitucionUcentral());
        this.objeto.setIdModalidad(configuracion.getIdModalidadUcentral());
        this.objeto.setIdNivelEstudios(configuracion.getIdNivelEstudios());
    }
}
