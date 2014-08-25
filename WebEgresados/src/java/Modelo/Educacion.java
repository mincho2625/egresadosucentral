/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.Date;

/**
 *
 * @author YURY
 */
public class Educacion {
    private long idEducacion;
    private Date fechaActEstado;
    private Mes idMesInicio;
    private Ciudad idCiudad;
    private Date fechaRegistro;
    private Mes idMesFinalizacion;
    private EstadoEducacion idEstadoEducacion;
    private AreaEstudios idAreaEstudios;
    private Modalidad idModalidad;
    private int anioInicio;
    private int anioFinalizacion;
    private Institucion idInstitucion;
    private String otraInstitucion;
    private boolean estado;
    private long idEgresado;
    private String tipo;

    /**
     * @return the idEducacion
     */
    public Long getIdEducacion() {
        return idEducacion;
    }

    /**
     * @param idEducacion the idEducacion to set
     */
    public void setIdEducacion(Long idEducacion) {
        this.idEducacion = idEducacion;
    }

    /**
     * @return the fechaActEstado
     */
    public Date getFechaActEstado() {
        return fechaActEstado;
    }

    /**
     * @param fechaActEstado the fechaActEstado to set
     */
    public void setFechaActEstado(Date fechaActEstado) {
        this.fechaActEstado = fechaActEstado;
    }

    /**
     * @return the idMesInicio
     */
    public Mes getIdMesInicio() {
        return idMesInicio;
    }

    /**
     * @param idMesInicio the idMesInicio to set
     */
    public void setIdMesInicio(Mes idMesInicio) {
        this.idMesInicio = idMesInicio;
    }

    /**
     * @return the idCiudad
     */
    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    /**
     * @param idCiudad the idCiudad to set
     */
    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    /**
     * @return the fechaRegistro
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param fechaRegistro the fechaRegistro to set
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * @return the idMesFinalizacion
     */
    public Mes getIdMesFinalizacion() {
        return idMesFinalizacion;
    }

    /**
     * @param idMesFinalizacion the idMesFinalizacion to set
     */
    public void setIdMesFinalizacion(Mes idMesFinalizacion) {
        this.idMesFinalizacion = idMesFinalizacion;
    }

    /**
     * @return the idEstadoEducacion
     */
    public EstadoEducacion getIdEstadoEducacion() {
        return idEstadoEducacion;
    }

    /**
     * @param idEstadoEducacion the idEstadoEducacion to set
     */
    public void setIdEstadoEducacion(EstadoEducacion idEstadoEducacion) {
        this.idEstadoEducacion = idEstadoEducacion;
    }

    /**
     * @return the idAreaEstudios
     */
    public AreaEstudios getIdAreaEstudios() {
        return idAreaEstudios;
    }

    /**
     * @param idAreaEstudios the idAreaEstudios to set
     */
    public void setIdAreaEstudios(AreaEstudios idAreaEstudios) {
        this.idAreaEstudios = idAreaEstudios;
    }

    /**
     * @return the idModalidad
     */
    public Modalidad getIdModalidad() {
        return idModalidad;
    }

    /**
     * @param idModalidad the idModalidad to set
     */
    public void setIdModalidad(Modalidad idModalidad) {
        this.idModalidad = idModalidad;
    }

    /**
     * @return the anioInicio
     */
    public int getAnioInicio() {
        return anioInicio;
    }

    /**
     * @param anioInicio the anioInicio to set
     */
    public void setAnioInicio(int anioInicio) {
        this.anioInicio = anioInicio;
    }

    /**
     * @return the anioFinalizacion
     */
    public int getAnioFinalizacion() {
        return anioFinalizacion;
    }

    /**
     * @param anioFinalizacion the anioFinalizacion to set
     */
    public void setAnioFinalizacion(int anioFinalizacion) {
        this.anioFinalizacion = anioFinalizacion;
    }

    /**
     * @return the idInstitucion
     */
    public Institucion getIdInstitucion() {
        return idInstitucion;
    }

    /**
     * @param idInstitucion the idInstitucion to set
     */
    public void setIdInstitucion(Institucion idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    /**
     * @return the otraInstitucion
     */
    public String getOtraInstitucion() {
        return otraInstitucion;
    }

    /**
     * @param otraInstitucion the otraInstitucion to set
     */
    public void setOtraInstitucion(String otraInstitucion) {
        this.otraInstitucion = otraInstitucion;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the idEgresado
     */
    public Long getIdEgresado() {
        return idEgresado;
    }

    /**
     * @param idEgresado the idEgresado to set
     */
    public void setIdEgresado(Long idEgresado) {
        this.idEgresado = idEgresado;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}