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
public class TipoAsociacion {
    private long idTipoAsociacion;
    private String nombre;
    private boolean estado;
    
    public TipoAsociacion() {}
    
    public TipoAsociacion(long idTipoAsociacion) {
        this.idTipoAsociacion = idTipoAsociacion;
    }

    /**
     * @return the idTipoAsociacion
     */
    public long getIdTipoAsociacion() {
        return idTipoAsociacion;
    }

    /**
     * @param idTipoAsociacion the idTipoAsociacion to set
     */
    public void setIdTipoAsociacion(long idTipoAsociacion) {
        this.idTipoAsociacion = idTipoAsociacion;
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