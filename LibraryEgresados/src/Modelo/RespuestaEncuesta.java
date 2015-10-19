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
public class RespuestaEncuesta {
    private long idRespuestaEncuesta;
    private String respuesta;
    private boolean estado;
    private int orden;
    private PreguntaEncuesta idPreguntaEncuesta;
    private Date fechaRegistro;

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    

    public PreguntaEncuesta getIdPreguntaEncuesta() {
        return idPreguntaEncuesta;
    }

    public void setIdPreguntaEncuesta(PreguntaEncuesta idPreguntaEncuesta) {
        this.idPreguntaEncuesta = idPreguntaEncuesta;
    }

    /**
     * @return the idRespuestaEncuesta
     */
    public long getIdRespuestaEncuesta() {
        return idRespuestaEncuesta;
    }

    /**
     * @param idRespuestaEncuesta the idRespuestaEncuesta to set
     */
    public void setIdRespuestaEncuesta(long idRespuestaEncuesta) {
        this.idRespuestaEncuesta = idRespuestaEncuesta;
    }

    /**
     * @return the respuesta
     */
    public String getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta the respuesta to set
     */
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return (estado ? "Activo" : "Inactivo");
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the orden
     */
    public int getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(int orden) {
        this.orden = orden;
    }
}