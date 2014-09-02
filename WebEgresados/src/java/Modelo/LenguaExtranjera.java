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
public class LenguaExtranjera extends Educacion {
    private DominioLenguaExt idDominio;
    private Idioma idIdioma;

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
}
