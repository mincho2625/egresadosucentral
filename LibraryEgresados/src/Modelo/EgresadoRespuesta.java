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
public class EgresadoRespuesta {
    private RespuestaEncuesta idRespuestaEncuesta;
    private String otra;
    private boolean estado;
    private long idEgresado;
    private PreguntaEncuesta idPreguntaEncuesta;
    private long idEgresadoRespuesta;
    private Date fechaRegistro;
    private String numeroDocumento;    

    /**
     * @return the idRespuestaEncuesta
     */
    public RespuestaEncuesta getIdRespuestaEncuesta() {
        return idRespuestaEncuesta;
    }

    /**
     * @param idRespuestaEncuesta the idRespuestaEncuesta to set
     */
    public void setIdRespuestaEncuesta(RespuestaEncuesta idRespuestaEncuesta) {
        this.idRespuestaEncuesta = idRespuestaEncuesta;
    }

    /**
     * @return the otra
     */
    public String getOtra() {
        return otra;
    }

    /**
     * @param otra the otra to set
     */
    public void setOtra(String otra) {
        this.otra = otra;
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

    /**
     * @return the idPreguntaEncuesta
     */
    public PreguntaEncuesta getIdPreguntaEncuesta() {
        return idPreguntaEncuesta;
    }

    /**
     * @param idPreguntaEncuesta the idPreguntaEncuesta to set
     */
    public void setIdPreguntaEncuesta(PreguntaEncuesta idPreguntaEncuesta) {
        this.idPreguntaEncuesta = idPreguntaEncuesta;
    }

    /**
     * @return the idEgresadoRespuesta
     */
    public long getIdEgresadoRespuesta() {
        return idEgresadoRespuesta;
    }

    /**
     * @param idEgresadoRespuesta the idEgresadoRespuesta to set
     */
    public void setIdEgresadoRespuesta(long idEgresadoRespuesta) {
        this.idEgresadoRespuesta = idEgresadoRespuesta;
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

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
}
