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
@Table(name = "rango_salarial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RangoSalarial.findAll", query = "SELECT r FROM RangoSalarial r"),
    @NamedQuery(name = "RangoSalarial.findByIdRangoSalarial", query = "SELECT r FROM RangoSalarial r WHERE r.idRangoSalarial = :idRangoSalarial"),
    @NamedQuery(name = "RangoSalarial.findByDescripcion", query = "SELECT r FROM RangoSalarial r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "RangoSalarial.findByEstado", query = "SELECT r FROM RangoSalarial r WHERE r.estado = :estado")})
public class RangoSalarial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_RANGO_SALARIAL")
    private Long idRangoSalarial;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRangoSalarial")
    private Collection<ExperienciaLaboral> experienciaLaboralCollection;

    public RangoSalarial() {
    }

    public RangoSalarial(Long idRangoSalarial) {
        this.idRangoSalarial = idRangoSalarial;
    }

    public RangoSalarial(Long idRangoSalarial, String descripcion, boolean estado) {
        this.idRangoSalarial = idRangoSalarial;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Long getIdRangoSalarial() {
        return idRangoSalarial;
    }

    public void setIdRangoSalarial(Long idRangoSalarial) {
        this.idRangoSalarial = idRangoSalarial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<ExperienciaLaboral> getExperienciaLaboralCollection() {
        return experienciaLaboralCollection;
    }

    public void setExperienciaLaboralCollection(Collection<ExperienciaLaboral> experienciaLaboralCollection) {
        this.experienciaLaboralCollection = experienciaLaboralCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRangoSalarial != null ? idRangoSalarial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RangoSalarial)) {
            return false;
        }
        RangoSalarial other = (RangoSalarial) object;
        return !((this.idRangoSalarial == null && other.idRangoSalarial != null) || (this.idRangoSalarial != null && !this.idRangoSalarial.equals(other.idRangoSalarial)));
    }

    @Override
    public String toString() {
        return "Persistencia.RangoSalarial[ idRangoSalarial=" + idRangoSalarial + " ]";
    }
}