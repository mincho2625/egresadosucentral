/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.Date;

/**
 *
 * @author JERONIMO
 */
public class Aficion {
    
    private long idAficion;
    private long idTipoActividad;
    private String listaActividades;
    private Date fechaRegistro;
    private boolean estado;
    private long idEgresado;

    public long getIdAficion() {
        return idAficion;
    }

    public void setIdAficion(long idAficion) {
        this.idAficion = idAficion;
    }

    public long getIdTipoActividad() {
        return idTipoActividad;
    }

    public void setIdTipoActividad(long idTipoActividad) {
        this.idTipoActividad = idTipoActividad;
    }

    public String getListaActividades() {
        return listaActividades;
    }

    public void setListaActividades(String listaActividades) {
        this.listaActividades = listaActividades;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public long getIdEgresado() {
        return idEgresado;
    }

    public void setIdEgresado(long idEgresado) {
        this.idEgresado = idEgresado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
