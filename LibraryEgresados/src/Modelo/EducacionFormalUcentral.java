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
public class EducacionFormalUcentral extends Educacion {
    private Programa idPrograma;
    private Jornada idJornada;

    /**
     * @return the idPrograma
     */
    public Programa getIdPrograma() {
        return idPrograma;
    }

    /**
     * @param idPrograma the idPrograma to set
     */
    public void setIdPrograma(Programa idPrograma) {
        this.idPrograma = idPrograma;
    }

    /**
     * @return the idJornada
     */
    public Jornada getIdJornada() {
        return idJornada;
    }

    /**
     * @param idJornada the idJornada to set
     */
    public void setIdJornada(Jornada idJornada) {
        this.idJornada = idJornada;
    }
}