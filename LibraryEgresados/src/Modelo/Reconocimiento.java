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
public class Reconocimiento {
    private long idReconocimiento;
    private TipoReconocimiento idTipoReconocimiento;
    private ClaseReconocimiento idClaseReconocimiento;
    private String entidadOtorgante;
    private String descripcion;
    private Date fechaReconocimiento;
    private Ciudad idCiudad;
    private Date fechaRegistro;
    private boolean estado;
    private long idEgresado;
    private String numeroDocumento;
    /**
     * @return the idReconocimiento
     */
    public long getIdReconocimiento() {
        return idReconocimiento;
    }

    /**
     * @param idReconocimiento the idReconocimiento to set
     */
    public void setIdReconocimiento(long idReconocimiento) {
        this.idReconocimiento = idReconocimiento;
    }

    /**
     * @return the idTipoReconocimiento
     */
    public TipoReconocimiento getIdTipoReconocimiento() {
        return idTipoReconocimiento;
    }

    /**
     * @param idTipoReconocimiento the idTipoReconocimiento to set
     */
    public void setIdTipoReconocimiento(TipoReconocimiento idTipoReconocimiento) {
        this.idTipoReconocimiento = idTipoReconocimiento;
    }

    /**
     * @return the idClaseReconocimiento
     */
    public ClaseReconocimiento getIdClaseReconocimiento() {
        return idClaseReconocimiento;
    }

    /**
     * @param idClaseReconocimiento the idClaseReconocimiento to set
     */
    public void setIdClaseReconocimiento(ClaseReconocimiento idClaseReconocimiento) {
        this.idClaseReconocimiento = idClaseReconocimiento;
    }

    /**
     * @return the entidadOtorgante
     */
    public String getEntidadOtorgante() {
        return entidadOtorgante;
    }

    /**
     * @param entidadOtorgante the entidadOtorgante to set
     */
    public void setEntidadOtorgante(String entidadOtorgante) {
        this.entidadOtorgante = entidadOtorgante;
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
     * @return the fechaReconocimiento
     */
    public Date getFechaReconocimiento() {
        return fechaReconocimiento;
    }

    /**
     * @param fechaReconocimiento the fechaReconocimiento to set
     */
    public void setFechaReconocimiento(Date fechaReconocimiento) {
        this.fechaReconocimiento = fechaReconocimiento;
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

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
}
