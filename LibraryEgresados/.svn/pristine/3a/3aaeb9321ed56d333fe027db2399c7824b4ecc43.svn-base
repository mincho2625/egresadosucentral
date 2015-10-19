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
@Table(name = "clase_reconocimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClaseReconocimiento.findAll", query = "SELECT c FROM ClaseReconocimiento c"),
    @NamedQuery(name = "ClaseReconocimiento.findByIdClaseReconocimiento", query = "SELECT c FROM ClaseReconocimiento c WHERE c.idClaseReconocimiento = :idClaseReconocimiento"),
    @NamedQuery(name = "ClaseReconocimiento.findByNombre", query = "SELECT c FROM ClaseReconocimiento c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "ClaseReconocimiento.findByEstado", query = "SELECT c FROM ClaseReconocimiento c WHERE c.estado = :estado")})
public class ClaseReconocimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CLASE_RECONOCIMIENTO")
    private Long idClaseReconocimiento;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClaseReconocimiento")
    private Collection<Reconocimiento> reconocimientoCollection;

    public ClaseReconocimiento() {
    }

    public ClaseReconocimiento(Long idClaseReconocimiento) {
        this.idClaseReconocimiento = idClaseReconocimiento;
    }

    public ClaseReconocimiento(Long idClaseReconocimiento, String nombre, boolean estado) {
        this.idClaseReconocimiento = idClaseReconocimiento;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getIdClaseReconocimiento() {
        return idClaseReconocimiento;
    }

    public void setIdClaseReconocimiento(Long idClaseReconocimiento) {
        this.idClaseReconocimiento = idClaseReconocimiento;
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
    public Collection<Reconocimiento> getReconocimientoCollection() {
        return reconocimientoCollection;
    }

    public void setReconocimientoCollection(Collection<Reconocimiento> reconocimientoCollection) {
        this.reconocimientoCollection = reconocimientoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClaseReconocimiento != null ? idClaseReconocimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClaseReconocimiento)) {
            return false;
        }
        ClaseReconocimiento other = (ClaseReconocimiento) object;
        return !((this.idClaseReconocimiento == null && other.idClaseReconocimiento != null) || (this.idClaseReconocimiento != null && !this.idClaseReconocimiento.equals(other.idClaseReconocimiento)));
    }

    @Override
    public String toString() {
        return "Persistencia.ClaseReconocimiento[ idClaseReconocimiento=" + idClaseReconocimiento + " ]";
    }
}
