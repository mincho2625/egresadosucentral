/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Util.Equivalencia;

/**
 *
 * @author YURY
 */
@Equivalencia(nombre = "getIdMes")
public class Mes {
    private long idMes;
    private String mes;
    private boolean estado;
    private int numero;

    /**
     * @return the idMes
     */
    public long getIdMes() {
        return idMes;
    }

    /**
     * @param idMes the idMes to set
     */
    public void setIdMes(long idMes) {
        this.idMes = idMes;
    }

    /**
     * @return the mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(String mes) {
        this.mes = mes;
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
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
}
