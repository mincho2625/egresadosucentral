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
public class AreaEstudios {
    private long idAreaEstudios;
    private String nombre;
    private boolean estado;
    private NivelEstudios idNivelEstudios;
    
    public AreaEstudios() {}
    
    public AreaEstudios(long idAreaEstudios) {
        this.idAreaEstudios = idAreaEstudios;
    }

    /**
     * @return the idAreaEstudios
     */
    public long getIdAreaEstudios() {
        return idAreaEstudios;
    }

    /**
     * @param idAreaEstudios the idAreaEstudios to set
     */
    public void setIdAreaEstudios(long idAreaEstudios) {
        this.idAreaEstudios = idAreaEstudios;
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

    /**
     * @return the idNivelEstudios
     */
    public NivelEstudios getIdNivelEstudios() {
        return idNivelEstudios;
    }

    /**
     * @param idNivelEstudios the idNivelEstudios to set
     */
    public void setIdNivelEstudios(NivelEstudios idNivelEstudios) {
        this.idNivelEstudios = idNivelEstudios;
    }
}