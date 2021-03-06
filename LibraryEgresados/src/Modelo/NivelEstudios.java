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
public class NivelEstudios {
    private long idNivelEstudios;
    private String nombre;
    private boolean estado;
    private boolean formal;
    private boolean obligatorioUCentral;
    private boolean obligatorioOtrasInst;
    private boolean obligatorioNoFormal;

    public NivelEstudios() {}
    
    public NivelEstudios(long idNivelEstudios) {
        this.idNivelEstudios = idNivelEstudios;
    }
    
    /**
     * @return the idNivelEstudios
     */
    public long getIdNivelEstudios() {
        return idNivelEstudios;
    }

    /**
     * @param idNivelEstudios the idNivelEstudios to set
     */
    public void setIdNivelEstudios(long idNivelEstudios) {
        this.idNivelEstudios = idNivelEstudios;
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
     * @return the formal
     */
    public boolean isFormal() {
        return formal;
    }

    /**
     * @param formal the formal to set
     */
    public void setFormal(boolean formal) {
        this.formal = formal;
    }

    /**
     * @return the obligatorioUCentral
     */
    public boolean isObligatorioUCentral() {
        return obligatorioUCentral;
    }

    /**
     * @param obligatorioUCentral the obligatorioUCentral to set
     */
    public void setObligatorioUCentral(boolean obligatorioUCentral) {
        this.obligatorioUCentral = obligatorioUCentral;
    }

    /**
     * @return the obligatorioOtrasInst
     */
    public boolean isObligatorioOtrasInst() {
        return obligatorioOtrasInst;
    }

    /**
     * @param obligatorioOtrasInst the obligatorioOtrasInst to set
     */
    public void setObligatorioOtrasInst(boolean obligatorioOtrasInst) {
        this.obligatorioOtrasInst = obligatorioOtrasInst;
    }

    /**
     * @return the obligatorioNoFormal
     */
    public boolean isObligatorioNoFormal() {
        return obligatorioNoFormal;
    }

    /**
     * @param obligatorioNoFormal the obligatorioNoFormal to set
     */
    public void setObligatorioNoFormal(boolean obligatorioNoFormal) {
        this.obligatorioNoFormal = obligatorioNoFormal;
    }
}