/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
    private Map<Long, RespuestaEncuesta> listaPosiblesRespuestasEncuesta;
    private int orden;
    private ArrayList<EgresadoRespuesta> listaRespuestasEncuesta;
    private boolean obligatoria;
    private int posicionFormato;
    
    public PreguntaEncuesta() {
        this.listaPosiblesRespuestasEncuesta = new HashMap<>();
        this.listaRespuestasEncuesta = new ArrayList<>();
    }

    public PreguntaEncuesta(long idPreguntaEncuesta) {
        this.idPreguntaEncuesta = idPreguntaEncuesta;
    }

    
    
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

    /**
     * @return the listaPosiblesRespuestasEncuesta
     */
    public Collection<RespuestaEncuesta> getListaPosiblesRespuestasEncuesta() {
        return listaPosiblesRespuestasEncuesta.values();
    }

    /**
     * @param listaPosiblesRespuestasEncuesta the listaPosiblesRespuestasEncuesta to set
     */
    public void setListaPosiblesRespuestasEncuesta(Map<Long, RespuestaEncuesta> listaPosiblesRespuestasEncuesta) {
        this.listaPosiblesRespuestasEncuesta = listaPosiblesRespuestasEncuesta;
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

    /**
     * @return the listaRespuestasEncuesta
     */
    public ArrayList<EgresadoRespuesta> getListaRespuestasEncuesta() {
        return listaRespuestasEncuesta;
    }

    /**
     * @param listaRespuestasEncuesta the listaRespuestasEncuesta to set
     */
    public void setListaRespuestasEncuesta(ArrayList<EgresadoRespuesta> listaRespuestasEncuesta) {
        this.listaRespuestasEncuesta = listaRespuestasEncuesta;
    }

    public void agregarPosibleRespuestaEncuesta(RespuestaEncuesta respuestaEncuesta) {
        this.listaPosiblesRespuestasEncuesta.put(respuestaEncuesta.getIdRespuestaEncuesta(), respuestaEncuesta);
    }

    public RespuestaEncuesta getRespuestaEncuesta(long idRespuesta) {
        return listaPosiblesRespuestasEncuesta.get(idRespuesta);
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

    public boolean isObligatoria() {
        return obligatoria;
    }

    public void setObligatoria(boolean obligatoria) {
        this.obligatoria = obligatoria;
    }

    public int getPosicionFormato() {
        return posicionFormato;
    }

    public void setPosicionFormato(int posicionFormato) {
        this.posicionFormato = posicionFormato;
    }

    public void getIdTipoRespuesta(TipoRespuesta reference) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}