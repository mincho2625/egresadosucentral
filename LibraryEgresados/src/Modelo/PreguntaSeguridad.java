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
public class PreguntaSeguridad {
    private long idPreguntaSeguridad;
    private String pregunta;
    private boolean estado;
    
    public PreguntaSeguridad() {}
    
    public PreguntaSeguridad(long idPreguntaSeguridad) {
        this.idPreguntaSeguridad = idPreguntaSeguridad;
    }

    /**
     * @return the idPreguntaSeguridad
     */
    public long getIdPreguntaSeguridad() {
        return idPreguntaSeguridad;
    }

    /**
     * @param idPreguntaSeguridad the idPreguntaSeguridad to set
     */
    public void setIdPreguntaSeguridad(long idPreguntaSeguridad) {
        this.idPreguntaSeguridad = idPreguntaSeguridad;
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
}