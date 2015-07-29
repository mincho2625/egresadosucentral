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
public class IntensidadHoraria {
    private long idIntensidadHoraria;
    private String nombre;
    private boolean estado;
    
    public IntensidadHoraria() {}
    
    public IntensidadHoraria(long idIntensidadHoraria) {
        this.idIntensidadHoraria = idIntensidadHoraria;
    }

    /**
     * @return the idIntensidadHoraria
     */
    public long getIdIntensidadHoraria() {
        return idIntensidadHoraria;
    }

    /**
     * @param idIntensidadHoraria the idIntensidadHoraria to set
     */
    public void setIdIntensidadHoraria(long idIntensidadHoraria) {
        this.idIntensidadHoraria = idIntensidadHoraria;
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
