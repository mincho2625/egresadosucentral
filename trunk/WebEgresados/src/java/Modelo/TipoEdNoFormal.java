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
public class TipoEdNoFormal {
    private long idTipoEdNoFormal;
    private String nombre;
    private boolean estado;

    /**
     * @return the idTipoEdNoFormal
     */
    public long getIdTipoEdNoFormal() {
        return idTipoEdNoFormal;
    }

    /**
     * @param idTipoEdNoFormal the idTipoEdNoFormal to set
     */
    public void setIdTipoEdNoFormal(long idTipoEdNoFormal) {
        this.idTipoEdNoFormal = idTipoEdNoFormal;
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
