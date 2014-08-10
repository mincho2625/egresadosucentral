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
public class EgresadoRedSocial {
    private long idEgresadoRedSocial;
    private long idRedSocial;
    private String url;
    private long idEgresado;

    /**
     * @return the idEgresadoRedSocial
     */
    public long getIdEgresadoRedSocial() {
        return idEgresadoRedSocial;
    }

    /**
     * @param idEgresadoRedSocial the idEgresadoRedSocial to set
     */
    public void setIdEgresadoRedSocial(long idEgresadoRedSocial) {
        this.idEgresadoRedSocial = idEgresadoRedSocial;
    }

    /**
     * @return the idRedSocial
     */
    public long getIdRedSocial() {
        return idRedSocial;
    }

    /**
     * @param idRedSocial the idRedSocial to set
     */
    public void setIdRedSocial(long idRedSocial) {
        this.idRedSocial = idRedSocial;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
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
}
