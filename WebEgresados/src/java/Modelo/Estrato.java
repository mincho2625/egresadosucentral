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
    private boolean estratoNumero;
    private String estratoLetras;
    private boolean estado;

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
     * @return the estratoNumero
     */
    public boolean isEstratoNumero() {
        return estratoNumero;
    }

    /**
     * @param estratoNumero the estratoNumero to set
     */
    public void setEstratoNumero(boolean estratoNumero) {
        this.estratoNumero = estratoNumero;
    }

    /**
     * @return the estratoLetras
     */
    public String getEstratoLetras() {
        return estratoLetras;
    }

    /**
     * @param estratoLetras the estratoLetras to set
     */
    public void setEstratoLetras(String estratoLetras) {
        this.estratoLetras = estratoLetras;
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
