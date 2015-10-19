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
public class Aficiones {
    
    private long idAficion;
    private TipoActividad idTipoActividad;
    private String listaActividades;
    private Date fechaRegistro;
    private boolean estado;
    private long idEgresado;
    private String numeroDocumento;
    private Egresado egresado;
    
    public long getIdAficion() {
        return idAficion;
    }

    public void setIdAficion(long idAficion) {
        this.idAficion = idAficion;
    }

    public TipoActividad getIdTipoActividad() {
        return idTipoActividad;
    }

    public void setIdTipoActividad(TipoActividad idTipoActividad) {
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public long getIdEgresado() {
        return idEgresado;
    }

    public void setIdEgresado(long idEgresado) {
        this.idEgresado = idEgresado;
    }

    public Egresado getEgresado() {
        return egresado;
    }

    public void setEgresado(Egresado egresado) {
        this.egresado = egresado;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
}