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
public class TipoVivienda {
    private long idTipoVivienda;
    private String nombre;

    /**
     * @return the idTipoVivienda
     */
    public long getIdTipoVivienda() {
        return idTipoVivienda;
    }

    /**
     * @param idTipoVivienda the idTipoVivienda to set
     */
    public void setIdTipoVivienda(long idTipoVivienda) {
        this.idTipoVivienda = idTipoVivienda;
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
}
