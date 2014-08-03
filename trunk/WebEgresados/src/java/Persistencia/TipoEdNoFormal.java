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
@Table(name = "tipo_ed_no_formal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEdNoFormal.findAll", query = "SELECT t FROM TipoEdNoFormal t"),
    @NamedQuery(name = "TipoEdNoFormal.findByIdTipoEdNoFormal", query = "SELECT t FROM TipoEdNoFormal t WHERE t.idTipoEdNoFormal = :idTipoEdNoFormal"),
    @NamedQuery(name = "TipoEdNoFormal.findByNombre", query = "SELECT t FROM TipoEdNoFormal t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoEdNoFormal.findByEstado", query = "SELECT t FROM TipoEdNoFormal t WHERE t.estado = :estado")})
public class TipoEdNoFormal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_ED_NO_FORMAL")
    private Long idTipoEdNoFormal;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoEdNoFormal")
    private Collection<EducacionNoFormal> educacionNoFormalCollection;

    public TipoEdNoFormal() {
    }

    public TipoEdNoFormal(Long idTipoEdNoFormal) {
        this.idTipoEdNoFormal = idTipoEdNoFormal;
    }

    public TipoEdNoFormal(Long idTipoEdNoFormal, String nombre, boolean estado) {
        this.idTipoEdNoFormal = idTipoEdNoFormal;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getIdTipoEdNoFormal() {
        return idTipoEdNoFormal;
    }

    public void setIdTipoEdNoFormal(Long idTipoEdNoFormal) {
        this.idTipoEdNoFormal = idTipoEdNoFormal;
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
    public Collection<EducacionNoFormal> getEducacionNoFormalCollection() {
        return educacionNoFormalCollection;
    }

    public void setEducacionNoFormalCollection(Collection<EducacionNoFormal> educacionNoFormalCollection) {
        this.educacionNoFormalCollection = educacionNoFormalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEdNoFormal != null ? idTipoEdNoFormal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEdNoFormal)) {
            return false;
        }
        TipoEdNoFormal other = (TipoEdNoFormal) object;
        if ((this.idTipoEdNoFormal == null && other.idTipoEdNoFormal != null) || (this.idTipoEdNoFormal != null && !this.idTipoEdNoFormal.equals(other.idTipoEdNoFormal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.TipoEdNoFormal[ idTipoEdNoFormal=" + idTipoEdNoFormal + " ]";
    }
    
}
