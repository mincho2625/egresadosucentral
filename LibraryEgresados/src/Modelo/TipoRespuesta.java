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
public class TipoRespuesta {
    private long idTipoRespuesta;
    private String nombre;
    private boolean estado;

    public TipoRespuesta() {
    }

    
    public TipoRespuesta(long idTipoRespuesta) {
        this.idTipoRespuesta = idTipoRespuesta;
    }
    /**
     * @return the idTipoRespuesta
     */
    public long getIdTipoRespuesta() {
        return idTipoRespuesta;
    }

    /**
     * @param idTipoRespuesta the idTipoRespuesta to set
     */
    public void setIdTipoRespuesta(long idTipoRespuesta) {
        this.idTipoRespuesta = idTipoRespuesta;
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
