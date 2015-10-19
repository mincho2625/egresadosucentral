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
public class Sector {
    private long idSector;
    private String nombre;
    private boolean estado;

    public Sector() {}
    
    public Sector(long idSector) {
        this.idSector = idSector;
    }
    
    /**
     * @return the idSector
     */
    public long getIdSector() {
        return idSector;
    }

    /**
     * @param idSector the idSector to set
     */
    public void setIdSector(long idSector) {
        this.idSector = idSector;
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