/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Modelo.Encuesta;

/**
 *
 * @author yury
 */
public class SeccionEncuesta {
    private long idSeccionEncuesta;
    private String nombre;
    private int orden;
    private Encuesta idEncuesta;

    /**
     * @return the idSeccionEncuesta
     */
    public long getIdSeccionEncuesta() {
        return idSeccionEncuesta;
    }

    /**
     * @param idSeccionEncuesta the idSeccionEncuesta to set
     */
    public void setIdSeccionEncuesta(long idSeccionEncuesta) {
        this.idSeccionEncuesta = idSeccionEncuesta;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
}