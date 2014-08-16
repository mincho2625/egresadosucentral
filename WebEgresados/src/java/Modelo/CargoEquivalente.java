/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author JERONIMO
 */
public class CargoEquivalente {
 
    private Long idCargoEquivalente;
    private String nombre;
    private boolean estado;

    public Long getIdCargoEquivalente() {
        return idCargoEquivalente;
    }

    public void setIdCargoEquivalente(Long idCargoEquivalente) {
        this.idCargoEquivalente = idCargoEquivalente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
