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
@Table(name = "red_social")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RedSocial.findAll", query = "SELECT r FROM RedSocial r"),
    @NamedQuery(name = "RedSocial.findByIdRedSocial", query = "SELECT r FROM RedSocial r WHERE r.idRedSocial = :idRedSocial"),
    @NamedQuery(name = "RedSocial.findByNombre", query = "SELECT r FROM RedSocial r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "RedSocial.findByEstado", query = "SELECT r FROM RedSocial r WHERE r.estado = :estado")})
public class RedSocial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_RED_SOCIAL")
    private Long idRedSocial;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRedSocial")
    private Collection<EgresadoRedSocial> egresadoRedSocialCollection;

    public RedSocial() {
    }

    public RedSocial(Long idRedSocial) {
        this.idRedSocial = idRedSocial;
    }

    public RedSocial(Long idRedSocial, String nombre, boolean estado) {
        this.idRedSocial = idRedSocial;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getIdRedSocial() {
        return idRedSocial;
    }

    public void setIdRedSocial(Long idRedSocial) {
        this.idRedSocial = idRedSocial;
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
    public Collection<EgresadoRedSocial> getEgresadoRedSocialCollection() {
        return egresadoRedSocialCollection;
    }

    public void setEgresadoRedSocialCollection(Collection<EgresadoRedSocial> egresadoRedSocialCollection) {
        this.egresadoRedSocialCollection = egresadoRedSocialCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRedSocial != null ? idRedSocial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RedSocial)) {
            return false;
        }
        RedSocial other = (RedSocial) object;
        if ((this.idRedSocial == null && other.idRedSocial != null) || (this.idRedSocial != null && !this.idRedSocial.equals(other.idRedSocial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.RedSocial[ idRedSocial=" + idRedSocial + " ]";
    }
    
}
