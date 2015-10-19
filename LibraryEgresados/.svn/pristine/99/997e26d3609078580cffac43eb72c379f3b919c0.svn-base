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
@Table(name = "jornada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jornada.findAll", query = "SELECT j FROM Jornada j"),
    @NamedQuery(name = "Jornada.findByIdJornada", query = "SELECT j FROM Jornada j WHERE j.idJornada = :idJornada"),
    @NamedQuery(name = "Jornada.findByNombre", query = "SELECT j FROM Jornada j WHERE j.nombre = :nombre"),
    @NamedQuery(name = "Jornada.findByEstado", query = "SELECT j FROM Jornada j WHERE j.estado = :estado")})
public class Jornada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_JORNADA")
    private Long idJornada;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJornada")
    private Collection<EducacionFormalUcentral> educacionFormalUcentralCollection;

    public Jornada() {
    }

    public Jornada(Long idJornada) {
        this.idJornada = idJornada;
    }

    public Jornada(Long idJornada, String nombre, boolean estado) {
        this.idJornada = idJornada;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(Long idJornada) {
        this.idJornada = idJornada;
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
    public Collection<EducacionFormalUcentral> getEducacionFormalUcentralCollection() {
        return educacionFormalUcentralCollection;
    }

    public void setEducacionFormalUcentralCollection(Collection<EducacionFormalUcentral> educacionFormalUcentralCollection) {
        this.educacionFormalUcentralCollection = educacionFormalUcentralCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJornada != null ? idJornada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jornada)) {
            return false;
        }
        Jornada other = (Jornada) object;
        return !((this.idJornada == null && other.idJornada != null) || (this.idJornada != null && !this.idJornada.equals(other.idJornada)));
    }

    @Override
    public String toString() {
        return "Persistencia.Jornada[ idJornada=" + idJornada + " ]";
    }
    
}
