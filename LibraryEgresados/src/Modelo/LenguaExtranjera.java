/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.Date;

/**
 *
 * @author YURY
 */
public class LenguaExtranjera {
    private DominioLenguaExt idDominio;
    private Idioma idIdioma;
    private boolean estado;
    private long idEgresado;
    private long idLenguaExtranjera;
    private Date fechaRegistro;

    /**
     * @return the idDominio
     */
    public DominioLenguaExt getIdDominio() {
        return idDominio;
    }

    /**
     * @param idDominio the idDominio to set
     */
    public void setIdDominio(DominioLenguaExt idDominio) {
        this.idDominio = idDominio;
    }

    /**
     * @return the idIdioma
     */
    public Idioma getIdIdioma() {
        return idIdioma;
    }

    /**
     * @param idIdioma the idIdioma to set
     */
    public void setIdIdioma(Idioma idIdioma) {
        this.idIdioma = idIdioma;
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
     * @return the idEgresado
     */
    public long getIdEgresado() {
        return idEgresado;
    }

    /**
     * @param idEgresado the idEgresado to set
     */
    public void setIdEgresado(long idEgresado) {
        this.idEgresado = idEgresado;
    }

    /**
     * @return the idLenguaExtranjera
     */
    public long getIdLenguaExtranjera() {
        return idLenguaExtranjera;
    }

    /**
     * @param idLenguaExtranjera the idLenguaExtranjera to set
     */
    public void setIdLenguaExtranjera(long idLenguaExtranjera) {
        this.idLenguaExtranjera = idLenguaExtranjera;
    }

    /**
     * @return the fechaRegistro
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param fechaRegistro the fechaRegistro to set
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
