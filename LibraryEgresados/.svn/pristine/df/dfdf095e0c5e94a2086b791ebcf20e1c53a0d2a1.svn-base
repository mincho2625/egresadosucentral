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
@Table(name = "genero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genero.findAll", query = "SELECT g FROM Genero g"),
    @NamedQuery(name = "Genero.findByIdGenero", query = "SELECT g FROM Genero g WHERE g.idGenero = :idGenero"),
    @NamedQuery(name = "Genero.findByNombre", query = "SELECT g FROM Genero g WHERE g.nombre = :nombre and g.estado = :estado"),
    @NamedQuery(name = "Genero.findByEstado", query = "SELECT g FROM Genero g WHERE g.estado = :estado")})
public class Genero implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_GENERO")
    private Long idGenero;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGenero")
    private Collection<Egresado> egresadoCollection;

    public Genero() {
    }

    public Genero(Long idGenero) {
        this.idGenero = idGenero;
    }

    public Genero(Long idGenero, String nombre, boolean estado) {
        this.idGenero = idGenero;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
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
    public Collection<Egresado> getEgresadoCollection() {
        return egresadoCollection;
    }

    public void setEgresadoCollection(Collection<Egresado> egresadoCollection) {
        this.egresadoCollection = egresadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGenero != null ? idGenero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genero)) {
            return false;
        }
        Genero other = (Genero) object;
        return !((this.idGenero == null && other.idGenero != null) || (this.idGenero != null && !this.idGenero.equals(other.idGenero)));
    }

    @Override
    public String toString() {
        return "Persistencia.Genero[ idGenero=" + idGenero + " ]";
    }
}