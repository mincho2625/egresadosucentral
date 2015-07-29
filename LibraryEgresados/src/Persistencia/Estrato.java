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
@Table(name = "estrato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estrato.findAll", query = "SELECT e FROM Estrato e"),
    @NamedQuery(name = "Estrato.findByIdEstrato", query = "SELECT e FROM Estrato e WHERE e.idEstrato = :idEstrato"),
    @NamedQuery(name = "Estrato.findByNombre", query = "SELECT e FROM Estrato e WHERE e.nombre = :nombre and e.estado = :estado"),
    @NamedQuery(name = "Estrato.findByEstado", query = "SELECT e FROM Estrato e WHERE e.estado = :estado")})
public class Estrato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTRATO")
    private Long idEstrato;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstrato")
    private Collection<Residencia> residenciaCollection;

    public Estrato() {
    }

    public Estrato(Long idEstrato) {
        this.idEstrato = idEstrato;
    }

    public Estrato(Long idEstrato, String nombre, boolean estado) {
        this.idEstrato = idEstrato;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getIdEstrato() {
        return idEstrato;
    }

    public void setIdEstrato(Long idEstrato) {
        this.idEstrato = idEstrato;
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
    public Collection<Residencia> getResidenciaCollection() {
        return residenciaCollection;
    }

    public void setResidenciaCollection(Collection<Residencia> residenciaCollection) {
        this.residenciaCollection = residenciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstrato != null ? idEstrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estrato)) {
            return false;
        }
        Estrato other = (Estrato) object;
        return (this.idEstrato != null || other.idEstrato == null) && (this.idEstrato == null || this.idEstrato.equals(other.idEstrato));
    }

    @Override
    public String toString() {
        return "Persistencia.Estrato[ idEstrato=" + idEstrato + " ]";
    }
    
}
