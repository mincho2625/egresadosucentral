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
public class Contacto {
    private long idContacto;
    private long idTipoContacto;
    private String descripcion;
    private Date fechaRegistro;
    private boolean estado;
    private long idEgresado;

    /**
     * @return the idContacto
     */
    public long getIdContacto() {
        return idContacto;
    }

    /**
     * @param idContacto the idContacto to set
     */
    public void setIdContacto(long idContacto) {
        this.idContacto = idContacto;
    }

    /**
     * @return the idTipoContacto
     */
    public long getIdTipoContacto() {
        return idTipoContacto;
    }

    /**
     * @param idTipoContacto the idTipoContacto to set
     */
    public void setIdTipoContacto(long idTipoContacto) {
        this.idTipoContacto = idTipoContacto;
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
}
