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
import javax.persistence.Lob;
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
    @NamedQuery(name = "ClaseReconocimiento.findByNombre", query = "SELECT c FROM ClaseReconocimiento c WHERE c.nombre = :nombre")})
public class ClaseReconocimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CLASE_RECONOCIMIENTO")
    private Integer idClaseReconocimiento;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Lob
    @Column(name = "ESTADO")
    private byte[] estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClaseReconocimiento")
    private Collection<Reconocimiento> reconocimientoCollection;

    public ClaseReconocimiento() {
    }

    public ClaseReconocimiento(Integer idClaseReconocimiento) {
        this.idClaseReconocimiento = idClaseReconocimiento;
    }

    public ClaseReconocimiento(Integer idClaseReconocimiento, String nombre, byte[] estado) {
        this.idClaseReconocimiento = idClaseReconocimiento;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdClaseReconocimiento() {
        return idClaseReconocimiento;
    }

    public void setIdClaseReconocimiento(Integer idClaseReconocimiento) {
        this.idClaseReconocimiento = idClaseReconocimiento;
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
        if ((this.idClaseReconocimiento == null && other.idClaseReconocimiento != null) || (this.idClaseReconocimiento != null && !this.idClaseReconocimiento.equals(other.idClaseReconocimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.ClaseReconocimiento[ idClaseReconocimiento=" + idClaseReconocimiento + " ]";
    }
    
}
