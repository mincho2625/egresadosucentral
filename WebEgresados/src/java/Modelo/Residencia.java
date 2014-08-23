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
public class Residencia {
    private long idResidencia;
    private Ciudad idCiudadResidencia;
    private TipoVivienda idTipoVivienda;
    private TipoTenenciaVivienda idTipoTenenciaVivienda;
    private String direccion;
    private Estrato idEstrato;
    private boolean computador;
    private boolean conexionInternet;
    private Date fechaRegistro;
    private boolean estado;
    private long idEgresado;

    /**
     * @return the idResidencia
     */
    public long getIdResidencia() {
        return idResidencia;
    }

    /**
     * @param idResidencia the idResidencia to set
     */
    public void setIdResidencia(long idResidencia) {
        this.idResidencia = idResidencia;
    }

    /**
     * @return the idCiudadResidencia
     */
    public Ciudad getIdCiudadResidencia() {
        return idCiudadResidencia;
    }

    /**
     * @param idCiudadResidencia the idCiudadResidencia to set
     */
    public void setIdCiudadResidencia(Ciudad idCiudadResidencia) {
        this.idCiudadResidencia = idCiudadResidencia;
    }

    /**
     * @return the idTipoVivienda
     */
    public TipoVivienda getIdTipoVivienda() {
        return idTipoVivienda;
    }

    /**
     * @param idTipoVivienda the idTipoVivienda to set
     */
    public void setIdTipoVivienda(TipoVivienda idTipoVivienda) {
        this.idTipoVivienda = idTipoVivienda;
    }

    /**
     * @return the idTipoTenenciaVivienda
     */
    public TipoTenenciaVivienda getIdTipoTenenciaVivienda() {
        return idTipoTenenciaVivienda;
    }

    /**
     * @param idTipoTenenciaVivienda the idTipoTenenciaVivienda to set
     */
    public void setIdTipoTenenciaVivienda(TipoTenenciaVivienda idTipoTenenciaVivienda) {
        this.idTipoTenenciaVivienda = idTipoTenenciaVivienda;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the idEstrato
     */
    public Estrato getIdEstrato() {
        return idEstrato;
    }

    /**
     * @param idEstrato the idEstrato to set
     */
    public void setIdEstrato(Estrato idEstrato) {
        this.idEstrato = idEstrato;
    }

    /**
     * @return the computador
     */
    public boolean isComputador() {
        return computador;
    }

    /**
     * @param computador the computador to set
     */
    public void setComputador(boolean computador) {
        this.computador = computador;
    }

    /**
     * @return the conexionInternet
     */
    public boolean isConexionInternet() {
        return conexionInternet;
    }

    /**
     * @param conexionInternet the conexionInternet to set
     */
    public void setConexionInternet(boolean conexionInternet) {
        this.conexionInternet = conexionInternet;
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
