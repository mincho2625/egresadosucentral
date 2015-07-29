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
public class Estrato {
    private long idEstrato;
    private String nombre;
    private boolean estado;
    
    public Estrato() {}
    
    public Estrato(long idEstrato) {
        this.idEstrato = idEstrato;
    }

    /**
     * @return the idEstrato
     */
    public long getIdEstrato() {
        return idEstrato;
    }

    /**
     * @param idEstrato the idEstrato to set
     */
    public void setIdEstrato(long idEstrato) {
        this.idEstrato = idEstrato;
    }

    /**
     * @return the estratoLetras
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre
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
