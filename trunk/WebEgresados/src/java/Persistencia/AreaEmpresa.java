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
@Table(name = "area_empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaEmpresa.findAll", query = "SELECT a FROM AreaEmpresa a"),
    @NamedQuery(name = "AreaEmpresa.findByIdAreaEmpresa", query = "SELECT a FROM AreaEmpresa a WHERE a.idAreaEmpresa = :idAreaEmpresa"),
    @NamedQuery(name = "AreaEmpresa.findByNombre", query = "SELECT a FROM AreaEmpresa a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "AreaEmpresa.findByEstado", query = "SELECT a FROM AreaEmpresa a WHERE a.estado = :estado")})
public class AreaEmpresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_AREA_EMPRESA")
    private Long idAreaEmpresa;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAreaEmpresa")
    private Collection<ExperienciaLaboral> experienciaLaboralCollection;

    public AreaEmpresa() {
    }

    public AreaEmpresa(Long idAreaEmpresa) {
        this.idAreaEmpresa = idAreaEmpresa;
    }

    public AreaEmpresa(Long idAreaEmpresa, String nombre, boolean estado) {
        this.idAreaEmpresa = idAreaEmpresa;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getIdAreaEmpresa() {
        return idAreaEmpresa;
    }

    public void setIdAreaEmpresa(Long idAreaEmpresa) {
        this.idAreaEmpresa = idAreaEmpresa;
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
    public Collection<ExperienciaLaboral> getExperienciaLaboralCollection() {
        return experienciaLaboralCollection;
    }

    public void setExperienciaLaboralCollection(Collection<ExperienciaLaboral> experienciaLaboralCollection) {
        this.experienciaLaboralCollection = experienciaLaboralCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAreaEmpresa != null ? idAreaEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaEmpresa)) {
            return false;
        }
        AreaEmpresa other = (AreaEmpresa) object;
        if ((this.idAreaEmpresa == null && other.idAreaEmpresa != null) || (this.idAreaEmpresa != null && !this.idAreaEmpresa.equals(other.idAreaEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.AreaEmpresa[ idAreaEmpresa=" + idAreaEmpresa + " ]";
    }
    
}
