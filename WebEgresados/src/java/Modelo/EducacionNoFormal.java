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
public class EducacionNoFormal extends Educacion {
    private TipoEdNoFormal idTipoEdNoFormal;
    private String otroTipoEdNoFormal;
    private String titulo;
    private IntensidadHoraria idIntensidadHoraria;
    private String descripcion;
    private boolean estado;

    /**
     * @return the idTipoEdNoFormal
     */
    public TipoEdNoFormal getIdTipoEdNoFormal() {
        return idTipoEdNoFormal;
    }

    /**
     * @param idTipoEdNoFormal the idTipoEdNoFormal to set
     */
    public void setIdTipoEdNoFormal(TipoEdNoFormal idTipoEdNoFormal) {
        this.idTipoEdNoFormal = idTipoEdNoFormal;
    }

    /**
     * @return the otroTipoEdNoFormal
     */
    public String getOtroTipoEdNoFormal() {
        return otroTipoEdNoFormal;
    }

    /**
     * @param otroTipoEdNoFormal the otroTipoEdNoFormal to set
     */
    public void setOtroTipoEdNoFormal(String otroTipoEdNoFormal) {
        this.otroTipoEdNoFormal = otroTipoEdNoFormal;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the idIntensidadHoraria
     */
    public IntensidadHoraria getIdIntensidadHoraria() {
        return idIntensidadHoraria;
    }

    /**
     * @param idIntensidadHoraria the idIntensidadHoraria to set
     */
    public void setIdIntensidadHoraria(IntensidadHoraria idIntensidadHoraria) {
        this.idIntensidadHoraria = idIntensidadHoraria;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
