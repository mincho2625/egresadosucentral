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
@Table(name = "tipo_contacto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoContacto.findAll", query = "SELECT t FROM TipoContacto t"),
    @NamedQuery(name = "TipoContacto.findByIdTipoContacto", query = "SELECT t FROM TipoContacto t WHERE t.idTipoContacto = :idTipoContacto"),
    @NamedQuery(name = "TipoContacto.findByNombre", query = "SELECT t FROM TipoContacto t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoContacto.findByEstado", query = "SELECT t FROM TipoContacto t WHERE t.estado = :estado")})
public class TipoContacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_CONTACTO")
    private Long idTipoContacto;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoContacto")
    private Collection<Contacto> contactoCollection;

    public TipoContacto() {
    }

    public TipoContacto(Long idTipoContacto) {
        this.idTipoContacto = idTipoContacto;
    }

    public TipoContacto(Long idTipoContacto, String nombre, boolean estado) {
        this.idTipoContacto = idTipoContacto;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getIdTipoContacto() {
        return idTipoContacto;
    }

    public void setIdTipoContacto(Long idTipoContacto) {
        this.idTipoContacto = idTipoContacto;
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
    public Collection<Contacto> getContactoCollection() {
        return contactoCollection;
    }

    public void setContactoCollection(Collection<Contacto> contactoCollection) {
        this.contactoCollection = contactoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoContacto != null ? idTipoContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoContacto)) {
            return false;
        }
        TipoContacto other = (TipoContacto) object;
        if ((this.idTipoContacto == null && other.idTipoContacto != null) || (this.idTipoContacto != null && !this.idTipoContacto.equals(other.idTipoContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.TipoContacto[ idTipoContacto=" + idTipoContacto + " ]";
    }
    
}