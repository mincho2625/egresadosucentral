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
public class EducacionFormal {
    private Educacion idEducacion;
    private Long idPrograma;
    private Long idJornada;
    private Long idNivelEstudios;

    /**
     * @return the idEducacion
     */
    public Educacion getIdEducacion() {
        return idEducacion;
    }

    /**
     * @param idEducacion the idEducacion to set
     */
    public void setIdEducacion(Educacion idEducacion) {
        this.idEducacion = idEducacion;
    }

    /**
     * @return the idPrograma
     */
    public Long getIdPrograma() {
        return idPrograma;
    }

    /**
     * @param idPrograma the idPrograma to set
     */
    public void setIdPrograma(Long idPrograma) {
        this.idPrograma = idPrograma;
    }

    /**
     * @return the idJornada
     */
    public Long getIdJornada() {
        return idJornada;
    }

    /**
     * @param idJornada the idJornada to set
     */
    public void setIdJornada(Long idJornada) {
        this.idJornada = idJornada;
    }

    /**
     * @return the idNivelEstudios
     */
    public Long getIdNivelEstudios() {
        return idNivelEstudios;
    }

    /**
     * @param idNivelEstudios the idNivelEstudios to set
     */
    public void setIdNivelEstudios(Long idNivelEstudios) {
        this.idNivelEstudios = idNivelEstudios;
    }
}
