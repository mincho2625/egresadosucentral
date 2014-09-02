/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YURY
 */
@Entity
@Table(name = "lengua_extranjera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LenguaExtranjera.findAll", query = "SELECT l FROM LenguaExtranjera l"),
    @NamedQuery(name = "LenguaExtranjera.findByIdEducacion", query = "SELECT l FROM LenguaExtranjera l WHERE l.educacion = :educacion")})
public class LenguaExtranjera implements Serializable {
    private static final long serialVersionUID = 1L;
    @JoinColumn(name = "ID_DOMINIO", referencedColumnName = "ID_DOMINIO_LENGUA_EXT")
    @ManyToOne(optional = false)
    private DominioLenguaExt idDominio;
    @JoinColumn(name = "ID_IDIOMA", referencedColumnName = "ID_IDIOMA")
    @ManyToOne(optional = false)
    private Idioma idIdioma;
    @Id
    @JoinColumn(name = "ID_EDUCACION", referencedColumnName = "ID_EDUCACION")
    @OneToOne(optional = false)
    private Educacion educacion;

    public LenguaExtranjera() {
    }

    public Educacion getEducacion() {
        return educacion;
    }

    public void setEducacion(Educacion educacion) {
        this.educacion = educacion;
    }

    public DominioLenguaExt getIdDominio() {
        return idDominio;
    }

    public void setIdDominio(DominioLenguaExt idDominio) {
        this.idDominio = idDominio;
    }

    public Idioma getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Idioma idIdioma) {
        this.idIdioma = idIdioma;
    }
    
    public boolean getEstado()
    {
        return educacion.getEstado();
    }
    
    public void setEstado(boolean estado)
    {
        educacion.setEstado(estado);
    }
}
