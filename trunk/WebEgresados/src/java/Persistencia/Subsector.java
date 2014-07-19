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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "subsector")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subsector.findAll", query = "SELECT s FROM Subsector s"),
    @NamedQuery(name = "Subsector.findByIdSubsector", query = "SELECT s FROM Subsector s WHERE s.idSubsector = :idSubsector"),
    @NamedQuery(name = "Subsector.findByNombre", query = "SELECT s FROM Subsector s WHERE s.nombre = :nombre")})
public class Subsector implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SUBSECTOR")
    private Integer idSubsector;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Lob
    @Column(name = "ESTADO")
    private byte[] estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSubsector")
    private Collection<ExperienciaLaboral> experienciaLaboralCollection;
    @JoinColumn(name = "ID_SECTOR", referencedColumnName = "ID_SECTOR")
    @ManyToOne(optional = false)
    private Sector idSector;

    public Subsector() {
    }

    public Subsector(Integer idSubsector) {
        this.idSubsector = idSubsector;
    }

    public Subsector(Integer idSubsector, String nombre, byte[] estado) {
        this.idSubsector = idSubsector;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdSubsector() {
        return idSubsector;
    }

    public void setIdSubsector(Integer idSubsector) {
        this.idSubsector = idSubsector;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getEstado() {
        return estado;
    }

    public void setEstado(byte[] estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<ExperienciaLaboral> getExperienciaLaboralCollection() {
        return experienciaLaboralCollection;
    }

    public void setExperienciaLaboralCollection(Collection<ExperienciaLaboral> experienciaLaboralCollection) {
        this.experienciaLaboralCollection = experienciaLaboralCollection;
    }

    public Sector getIdSector() {
        return idSector;
    }

    public void setIdSector(Sector idSector) {
        this.idSector = idSector;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubsector != null ? idSubsector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subsector)) {
            return false;
        }
        Subsector other = (Subsector) object;
        if ((this.idSubsector == null && other.idSubsector != null) || (this.idSubsector != null && !this.idSubsector.equals(other.idSubsector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Subsector[ idSubsector=" + idSubsector + " ]";
    }
    
}
