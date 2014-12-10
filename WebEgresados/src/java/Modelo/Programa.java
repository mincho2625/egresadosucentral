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
public class Programa {
    private long idPrograma;
    private String nombre;
    private boolean estado;
    private NivelEstudios idNivelEstudios;
    private Facultad idFacultad;

    /**
     * @return the idPrograma
     */
    public long getIdPrograma() {
        return idPrograma;
    }

    /**
     * @param idPrograma the idPrograma to set
     */
    public void setIdPrograma(long idPrograma) {
        this.idPrograma = idPrograma;
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

    /**
     * @return the idNivelEstudios
     */
    public NivelEstudios getIdNivelEstudios() {
        return idNivelEstudios;
    }

    /**
     * @param idNivelEstudios the idNivelEstudios to set
     */
    public void setIdNivelEstudios(NivelEstudios idNivelEstudios) {
        this.idNivelEstudios = idNivelEstudios;
    }

    /**
     * @return the idFacultad
     */
    public Facultad getIdFacultad() {
        return idFacultad;
    }

    /**
     * @param idFacultad the idFacultad to set
     */
    public void setIdFacultad(Facultad idFacultad) {
        this.idFacultad = idFacultad;
    }
}