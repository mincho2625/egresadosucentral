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
public class TipoTenenciaVivienda {
    private long idTipoTenenciaVivienda;
    private String nombre;

    /**
     * @return the idTipoTenenciaVivienda
     */
    public long getIdTipoTenenciaVivienda() {
        return idTipoTenenciaVivienda;
    }

    /**
     * @param idTipoTenenciaVivienda the idTipoTenenciaVivienda to set
     */
    public void setIdTipoTenenciaVivienda(long idTipoTenenciaVivienda) {
        this.idTipoTenenciaVivienda = idTipoTenenciaVivienda;
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
