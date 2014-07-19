/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @NamedQuery(name = "LenguaExtranjera.findByIdEducacion", query = "SELECT l FROM LenguaExtranjera l WHERE l.idEducacion = :idEducacion")})
public class LenguaExtranjera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EDUCACION")
    private Integer idEducacion;
    @JoinColumn(name = "ID_EDUCACION", referencedColumnName = "ID_EDUCACION", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Educacion educacion;
    @JoinColumn(name = "ID_DOMINIO", referencedColumnName = "ID_DOMINIO_LENGUA_EXT")
    @ManyToOne(optional = false)
    private DominioLenguaExt idDominio;
    @JoinColumn(name = "ID_IDIOMA", referencedColumnName = "ID_IDIOMA")
    @ManyToOne(optional = false)
    private Idioma idIdioma;

    public LenguaExtranjera() {
    }

    public LenguaExtranjera(Integer idEducacion) {
        this.idEducacion = idEducacion;
    }

    public Integer getIdEducacion() {
        return idEducacion;
    }

    public void setIdEducacion(Integer idEducacion) {
        this.idEducacion = idEducacion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEducacion != null ? idEducacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LenguaExtranjera)) {
            return false;
        }
        LenguaExtranjera other = (LenguaExtranjera) object;
        if ((this.idEducacion == null && other.idEducacion != null) || (this.idEducacion != null && !this.idEducacion.equals(other.idEducacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.LenguaExtranjera[ idEducacion=" + idEducacion + " ]";
    }
    
}
