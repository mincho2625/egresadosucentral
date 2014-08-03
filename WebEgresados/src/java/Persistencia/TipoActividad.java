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
@Table(name = "tipo_actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoActividad.findAll", query = "SELECT t FROM TipoActividad t"),
    @NamedQuery(name = "TipoActividad.findByIdTipoActividad", query = "SELECT t FROM TipoActividad t WHERE t.idTipoActividad = :idTipoActividad"),
    @NamedQuery(name = "TipoActividad.findByNombre", query = "SELECT t FROM TipoActividad t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoActividad.findByEstado", query = "SELECT t FROM TipoActividad t WHERE t.estado = :estado")})
public class TipoActividad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_ACTIVIDAD")
    private Long idTipoActividad;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoActividad")
    private Collection<Aficiones> aficionesCollection;

    public TipoActividad() {
    }

    public TipoActividad(Long idTipoActividad) {
        this.idTipoActividad = idTipoActividad;
    }

    public TipoActividad(Long idTipoActividad, String nombre, boolean estado) {
        this.idTipoActividad = idTipoActividad;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getIdTipoActividad() {
        return idTipoActividad;
    }

    public void setIdTipoActividad(Long idTipoActividad) {
        this.idTipoActividad = idTipoActividad;
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
    public Collection<Aficiones> getAficionesCollection() {
        return aficionesCollection;
    }

    public void setAficionesCollection(Collection<Aficiones> aficionesCollection) {
        this.aficionesCollection = aficionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoActividad != null ? idTipoActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoActividad)) {
            return false;
        }
        TipoActividad other = (TipoActividad) object;
        if ((this.idTipoActividad == null && other.idTipoActividad != null) || (this.idTipoActividad != null && !this.idTipoActividad.equals(other.idTipoActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.TipoActividad[ idTipoActividad=" + idTipoActividad + " ]";
    }
    
}
