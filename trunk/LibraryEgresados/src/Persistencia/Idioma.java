/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author YURY
 */
@Entity
@Table(name = "idioma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Idioma.findAll", query = "SELECT i FROM Idioma i"),
    @NamedQuery(name = "Idioma.findByIdIdioma", query = "SELECT i FROM Idioma i WHERE i.idIdioma = :idIdioma"),
    @NamedQuery(name = "Idioma.findByNombre", query = "SELECT i FROM Idioma i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Idioma.findByEstado", query = "SELECT i FROM Idioma i WHERE i.estado = :estado")})
public class Idioma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_IDIOMA")
    private Long idIdioma;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIdioma")
    private Collection<LenguaExtranjera> lenguaExtranjeraCollection;

    public Idioma() {
    }

    public Idioma(Long idIdioma) {
        this.idIdioma = idIdioma;
    }

    public Idioma(Long idIdioma, String nombre, boolean estado) {
        this.idIdioma = idIdioma;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Long idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<LenguaExtranjera> getLenguaExtranjeraCollection() {
        return lenguaExtranjeraCollection;
    }

    public void setLenguaExtranjeraCollection(Collection<LenguaExtranjera> lenguaExtranjeraCollection) {
        this.lenguaExtranjeraCollection = lenguaExtranjeraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIdioma != null ? idIdioma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Idioma)) {
            return false;
        }
        Idioma other = (Idioma) object;
        return !((this.idIdioma == null && other.idIdioma != null) || (this.idIdioma != null && !this.idIdioma.equals(other.idIdioma)));
    }

    @Override
    public String toString() {
        return "Persistencia.Idioma[ idIdioma=" + idIdioma + " ]";
    }
}
