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
@Table(name = "area_estudios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaEstudios.findAll", query = "SELECT a FROM AreaEstudios a"),
    @NamedQuery(name = "AreaEstudios.findByIdAreaEstudios", query = "SELECT a FROM AreaEstudios a WHERE a.idAreaEstudios = :idAreaEstudios"),
    @NamedQuery(name = "AreaEstudios.findByNombre", query = "SELECT a FROM AreaEstudios a WHERE a.nombre = :nombre")})
public class AreaEstudios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_AREA_ESTUDIOS")
    private Integer idAreaEstudios;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Lob
    @Column(name = "ESTADO")
    private byte[] estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAreaEstudios")
    private Collection<Educacion> educacionCollection;

    public AreaEstudios() {
    }

    public AreaEstudios(Integer idAreaEstudios) {
        this.idAreaEstudios = idAreaEstudios;
    }

    public AreaEstudios(Integer idAreaEstudios, String nombre, byte[] estado) {
        this.idAreaEstudios = idAreaEstudios;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdAreaEstudios() {
        return idAreaEstudios;
    }

    public void setIdAreaEstudios(Integer idAreaEstudios) {
        this.idAreaEstudios = idAreaEstudios;
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
        hash += (idAreaEstudios != null ? idAreaEstudios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaEstudios)) {
            return false;
        }
        AreaEstudios other = (AreaEstudios) object;
        if ((this.idAreaEstudios == null && other.idAreaEstudios != null) || (this.idAreaEstudios != null && !this.idAreaEstudios.equals(other.idAreaEstudios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.AreaEstudios[ idAreaEstudios=" + idAreaEstudios + " ]";
    }
    
}
