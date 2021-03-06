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
public class ProcesoCargue {
    private long idProcesoCargue;
    private Date fechaInicio;
    private Date fechaFin;
    private EstadoProceso idEstadoProceso;
    private String error;

    /**
     * @return the idProcesoCargue
     */
    public long getIdProcesoCargue() {
        return idProcesoCargue;
    }

    /**
     * @param idProcesoCargue the idProcesoCargue to set
     */
    public void setIdProcesoCargue(long idProcesoCargue) {
        this.idProcesoCargue = idProcesoCargue;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the idEstadoProceso
     */
    public EstadoProceso getIdEstadoProceso() {
        return idEstadoProceso;
    }

    /**
     * @param idEstadoProceso the idEstadoProceso to set
     */
    public void setIdEstadoProceso(EstadoProceso idEstadoProceso) {
        this.idEstadoProceso = idEstadoProceso;
    }

    /**
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(String error) {
        this.error = error;
    }
}