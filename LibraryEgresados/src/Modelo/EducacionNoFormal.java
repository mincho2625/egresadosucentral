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
    private String otroNivelEstudios;
    private String titulo;
    private IntensidadHoraria idIntensidadHoraria;
    private String descripcion;
    private AreaEstudios idAreaEstudios;
    private Modalidad idModalidad;
    private NivelEstudios idNivelEstudios;
    private String numeroDocumento;

    /**
     * @return the otroNivelEstudios
     */
    public String getOtroNivelEstudios() {
        return otroNivelEstudios;
    }

    /**
     * @param otroNivelEstudios the otroNivelEstudios to set
     */
    public void setOtroNivelEstudios(String otroNivelEstudios) {
        this.otroNivelEstudios = otroNivelEstudios;
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
     * @return the idAreaEstudios
     */
    public AreaEstudios getIdAreaEstudios() {
        return idAreaEstudios;
    }

    /**
     * @param idAreaEstudios the idAreaEstudios to set
     */
    public void setIdAreaEstudios(AreaEstudios idAreaEstudios) {
        this.idAreaEstudios = idAreaEstudios;
    }

    /**
     * @return the idModalidad
     */
    public Modalidad getIdModalidad() {
        return idModalidad;
    }

    /**
     * @param idModalidad the idModalidad to set
     */
    public void setIdModalidad(Modalidad idModalidad) {
        this.idModalidad = idModalidad;
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

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
}
