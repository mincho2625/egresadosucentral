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
@Table(name = "grupo_sanguineo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoSanguineo.findAll", query = "SELECT g FROM GrupoSanguineo g"),
    @NamedQuery(name = "GrupoSanguineo.findByIdGrupoSanguineo", query = "SELECT g FROM GrupoSanguineo g WHERE g.idGrupoSanguineo = :idGrupoSanguineo"),
    @NamedQuery(name = "GrupoSanguineo.findByGrupoSanguineo", query = "SELECT g FROM GrupoSanguineo g WHERE g.grupoSanguineo = :grupoSanguineo"),
    @NamedQuery(name = "GrupoSanguineo.findByEstado", query = "SELECT g FROM GrupoSanguineo g WHERE g.estado = :estado")})
public class GrupoSanguineo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_GRUPO_SANGUINEO")
    private Long idGrupoSanguineo;
    @Basic(optional = false)
    @Column(name = "GRUPO_SANGUINEO")
    private String grupoSanguineo;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrupoSanguineo")
    private Collection<Egresado> egresadoCollection;

    public GrupoSanguineo() {
    }

    public GrupoSanguineo(Long idGrupoSanguineo) {
        this.idGrupoSanguineo = idGrupoSanguineo;
    }

    public GrupoSanguineo(Long idGrupoSanguineo, String grupoSanguineo, boolean estado) {
        this.idGrupoSanguineo = idGrupoSanguineo;
        this.grupoSanguineo = grupoSanguineo;
        this.estado = estado;
    }

    public Long getIdGrupoSanguineo() {
        return idGrupoSanguineo;
    }

    public void setIdGrupoSanguineo(Long idGrupoSanguineo) {
        this.idGrupoSanguineo = idGrupoSanguineo;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
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
        hash += (idGrupoSanguineo != null ? idGrupoSanguineo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoSanguineo)) {
            return false;
        }
        GrupoSanguineo other = (GrupoSanguineo) object;
        return !((this.idGrupoSanguineo == null && other.idGrupoSanguineo != null) || (this.idGrupoSanguineo != null && !this.idGrupoSanguineo.equals(other.idGrupoSanguineo)));
    }

    @Override
    public String toString() {
        return "Persistencia.GrupoSanguineo[ idGrupoSanguineo=" + idGrupoSanguineo + " ]";
    }
}