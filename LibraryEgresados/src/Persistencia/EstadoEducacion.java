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
@Table(name = "estado_educacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoEducacion.findAll", query = "SELECT e FROM EstadoEducacion e"),
    @NamedQuery(name = "EstadoEducacion.findByIdEstadoEducacion", query = "SELECT e FROM EstadoEducacion e WHERE e.idEstadoEducacion = :idEstadoEducacion"),
    @NamedQuery(name = "EstadoEducacion.findByNombre", query = "SELECT e FROM EstadoEducacion e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EstadoEducacion.findByEstado", query = "SELECT e FROM EstadoEducacion e WHERE e.estado = :estado")})
public class EstadoEducacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_EDUCACION")
    private Long idEstadoEducacion;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoEducacion")
    private Collection<Educacion> educacionCollection;
    @Basic(optional = false)
    @Column(name = "SOLO_LECTURA")
    private boolean soloLectura;

    public EstadoEducacion() {
    }

    public EstadoEducacion(Long idEstadoEducacion) {
        this.idEstadoEducacion = idEstadoEducacion;
    }

    public EstadoEducacion(Long idEstadoEducacion, String nombre, boolean estado) {
        this.idEstadoEducacion = idEstadoEducacion;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getIdEstadoEducacion() {
        return idEstadoEducacion;
    }

    public void setIdEstadoEducacion(Long idEstadoEducacion) {
        this.idEstadoEducacion = idEstadoEducacion;
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
    public Collection<Educacion> getEducacionCollection() {
        return educacionCollection;
    }

    public void setEducacionCollection(Collection<Educacion> educacionCollection) {
        this.educacionCollection = educacionCollection;
    }
    
    /**
     * @return the soloLectura
     */
    public boolean getSoloLectura() {
        return soloLectura;
    }

    /**
     * @param soloLectura the soloLectura to set
     */
    public void setSoloLectura(boolean soloLectura) {
        this.soloLectura = soloLectura;
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
        return !((this.idEstadoEducacion == null && other.idEstadoEducacion != null) || (this.idEstadoEducacion != null && !this.idEstadoEducacion.equals(other.idEstadoEducacion)));
    }

    @Override
    public String toString() {
        return "Persistencia.EstadoEducacion[ idEstadoEducacion=" + idEstadoEducacion + " ]";
    }
}