/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author YURY
 */
public class PreguntaEncuesta {
    private long idPreguntaEncuesta;
    private String pregunta;
    private Encuesta idEncuesta;
    private boolean estado;
    private TipoRespuesta idTipoRespuesta;

    /**
     * @return the idPreguntaEncuesta
     */
    public long getIdPreguntaEncuesta() {
        return idPreguntaEncuesta;
    }

    /**
     * @param idPreguntaEncuesta the idPreguntaEncuesta to set
     */
    public void setIdPreguntaEncuesta(long idPreguntaEncuesta) {
        this.idPreguntaEncuesta = idPreguntaEncuesta;
    }

    /**
     * @return the pregunta
     */
    public String getPregunta() {
        return pregunta;
    }

    /**
     * @param pregunta the pregunta to set
     */
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    /**
     * @return the idEncuesta
     */
    public Encuesta getIdEncuesta() {
        return idEncuesta;
    }

    /**
     * @param idEncuesta the idEncuesta to set
     */
    public void setIdEncuesta(Encuesta idEncuesta) {
        this.idEncuesta = idEncuesta;
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
     * @return the idTipoRespuesta
     */
    public TipoRespuesta getIdTipoRespuesta() {
        return idTipoRespuesta;
    }

    /**
     * @param idTipoRespuesta the idTipoRespuesta to set
     */
    public void setIdTipoRespuesta(TipoRespuesta idTipoRespuesta) {
        this.idTipoRespuesta = idTipoRespuesta;
    }
}
