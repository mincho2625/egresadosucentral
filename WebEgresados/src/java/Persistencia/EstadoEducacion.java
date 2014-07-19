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
@Table(name = "estado_educacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoEducacion.findAll", query = "SELECT e FROM EstadoEducacion e"),
    @NamedQuery(name = "EstadoEducacion.findByIdEstadoEducacion", query = "SELECT e FROM EstadoEducacion e WHERE e.idEstadoEducacion = :idEstadoEducacion"),
    @NamedQuery(name = "EstadoEducacion.findByNombre", query = "SELECT e FROM EstadoEducacion e WHERE e.nombre = :nombre")})
public class EstadoEducacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_EDUCACION")
    private Integer idEstadoEducacion;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Lob
    @Column(name = "ESTADO")
    private byte[] estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoEducacion")
    private Collection<Educacion> educacionCollection;

    public EstadoEducacion() {
    }

    public EstadoEducacion(Integer idEstadoEducacion) {
        this.idEstadoEducacion = idEstadoEducacion;
    }

    public EstadoEducacion(Integer idEstadoEducacion, String nombre, byte[] estado) {
        this.idEstadoEducacion = idEstadoEducacion;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdEstadoEducacion() {
        return idEstadoEducacion;
    }

    public void setIdEstadoEducacion(Integer idEstadoEducacion) {
        this.idEstadoEducacion = idEstadoEducacion;
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
    public Collection<Educacion> getEducacionCollection() {
        return educacionCollection;
    }

    public void setEducacionCollection(Collection<Educacion> educacionCollection) {
        this.educacionCollection = educacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoEducacion != null ? idEstadoEducacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoEducacion)) {
            return false;
        }
        EstadoEducacion other = (EstadoEducacion) object;
        if ((this.idEstadoEducacion == null && other.idEstadoEducacion != null) || (this.idEstadoEducacion != null && !this.idEstadoEducacion.equals(other.idEstadoEducacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.EstadoEducacion[ idEstadoEducacion=" + idEstadoEducacion + " ]";
    }
    
}
