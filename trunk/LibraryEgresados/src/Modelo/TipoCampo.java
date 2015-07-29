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
public class TipoCampo {
    private long idTipoCampo;
    private String nombre;
    private boolean estado;

    public TipoCampo() {}
    
    public TipoCampo(long idTipoCampo) {
        this.idTipoCampo = idTipoCampo;
    }
    
    /**
     * @return the idTipoCampo
     */
    public long getIdTipoCampo() {
        return idTipoCampo;
    }

    /**
     * @param idTipoCampo the idTipoCampo to set
     */
    public void setIdTipoCampo(long idTipoCampo) {
        this.idTipoCampo = idTipoCampo;
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