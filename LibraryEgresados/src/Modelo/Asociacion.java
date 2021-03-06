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
public class Asociacion {
    private long idAsociacion;
    private String descripcion;
    private Date fechaVinculacion;
    private Pais idPais;
    private Date fechaRegistro;
    private boolean estado;
    private TipoAsociacion idTipoAsociacion;
    private long idEgresado;
    private String numeroDocumento;    
    /**
     * @return the idAsociacion
     */
    public long getIdAsociacion() {
        return idAsociacion;
    }

    /**
     * @param idAsociacion the idAsociacion to set
     */
    public void setIdAsociacion(long idAsociacion) {
        this.idAsociacion = idAsociacion;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the fechaVinculacion
     */
    public Date getFechaVinculacion() {
        return fechaVinculacion;
    }

    /**
     * @param fechaVinculacion the fechaVinculacion to set
     */
    public void setFechaVinculacion(Date fechaVinculacion) {
        this.fechaVinculacion = fechaVinculacion;
    }

    /**
     * @return the idPais
     */
    public Pais getIdPais() {
        return idPais;
    }

    /**
     * @param idPais the idPais to set
     */
    public void setIdPais(Pais idPais) {
        this.idPais = idPais;
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
     * @return the idTipoAsociacion
     */
    public TipoAsociacion getIdTipoAsociacion() {
        return idTipoAsociacion;
    }

    /**
     * @param idTipoAsociacion the idTipoAsociacion to set
     */
    public void setIdTipoAsociacion(TipoAsociacion idTipoAsociacion) {
        this.idTipoAsociacion = idTipoAsociacion;
    }

    /**
     * @return the idEgresado
     */
    public long getIdEgresado() {
        return idEgresado;
    }

    /**
     * @param idEgresado the idEgresado to set
     */
    public void setIdEgresado(long idEgresado) {
        this.idEgresado = idEgresado;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
}
