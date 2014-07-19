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
@Table(name = "tipo_asociacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAsociacion.findAll", query = "SELECT t FROM TipoAsociacion t"),
    @NamedQuery(name = "TipoAsociacion.findByIdTipoAsociacion", query = "SELECT t FROM TipoAsociacion t WHERE t.idTipoAsociacion = :idTipoAsociacion"),
    @NamedQuery(name = "TipoAsociacion.findByNombre", query = "SELECT t FROM TipoAsociacion t WHERE t.nombre = :nombre")})
public class TipoAsociacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_ASOCIACION")
    private Integer idTipoAsociacion;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Lob
    @Column(name = "ESTADO")
    private byte[] estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoAsociacion")
    private Collection<Asociacion> asociacionCollection;

    public TipoAsociacion() {
    }

    public TipoAsociacion(Integer idTipoAsociacion) {
        this.idTipoAsociacion = idTipoAsociacion;
    }

    public TipoAsociacion(Integer idTipoAsociacion, String nombre, byte[] estado) {
        this.idTipoAsociacion = idTipoAsociacion;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdTipoAsociacion() {
        return idTipoAsociacion;
    }

    public void setIdTipoAsociacion(Integer idTipoAsociacion) {
        this.idTipoAsociacion = idTipoAsociacion;
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
    public Collection<Asociacion> getAsociacionCollection() {
        return asociacionCollection;
    }

    public void setAsociacionCollection(Collection<Asociacion> asociacionCollection) {
        this.asociacionCollection = asociacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoAsociacion != null ? idTipoAsociacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAsociacion)) {
            return false;
        }
        TipoAsociacion other = (TipoAsociacion) object;
        if ((this.idTipoAsociacion == null && other.idTipoAsociacion != null) || (this.idTipoAsociacion != null && !this.idTipoAsociacion.equals(other.idTipoAsociacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.TipoAsociacion[ idTipoAsociacion=" + idTipoAsociacion + " ]";
    }
    
}
