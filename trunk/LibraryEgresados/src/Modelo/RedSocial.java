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
public class RedSocial {
    private long idRedSocial;
    private String nombre;
    private boolean estado;
    
    public RedSocial() {}
    
    public RedSocial(long idRedSocial) {
        this.idRedSocial = idRedSocial;
    }

    /**
     * @return the idRedSocial
     */
    public long getIdRedSocial() {
        return idRedSocial;
    }

    /**
     * @param idRedSocial the idRedSocial to set
     */
    public void setIdRedSocial(long idRedSocial) {
        this.idRedSocial = idRedSocial;
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