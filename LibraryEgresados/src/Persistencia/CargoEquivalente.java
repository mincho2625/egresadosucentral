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
@Table(name = "cargo_equivalente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CargoEquivalente.findAll", query = "SELECT c FROM CargoEquivalente c"),
    @NamedQuery(name = "CargoEquivalente.findByIdCargoEquivalente", query = "SELECT c FROM CargoEquivalente c WHERE c.idCargoEquivalente = :idCargoEquivalente"),
    @NamedQuery(name = "CargoEquivalente.findByNombre", query = "SELECT c FROM CargoEquivalente c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "CargoEquivalente.findByEstado", query = "SELECT c FROM CargoEquivalente c WHERE c.estado = :estado")})
public class CargoEquivalente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CARGO_EQUIVALENTE")
    private Long idCargoEquivalente;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargoEquivalente")
    private Collection<ExperienciaLaboral> experienciaLaboralCollection;

    public CargoEquivalente() {
    }

    public CargoEquivalente(Long idCargoEquivalente) {
        this.idCargoEquivalente = idCargoEquivalente;
    }

    public CargoEquivalente(Long idCargoEquivalente, String nombre, boolean estado) {
        this.idCargoEquivalente = idCargoEquivalente;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getIdCargoEquivalente() {
        return idCargoEquivalente;
    }

    public void setIdCargoEquivalente(Long idCargoEquivalente) {
        this.idCargoEquivalente = idCargoEquivalente;
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
    public Collection<ExperienciaLaboral> getExperienciaLaboralCollection() {
        return experienciaLaboralCollection;
    }

    public void setExperienciaLaboralCollection(Collection<ExperienciaLaboral> experienciaLaboralCollection) {
        this.experienciaLaboralCollection = experienciaLaboralCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCargoEquivalente != null ? idCargoEquivalente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CargoEquivalente)) {
            return false;
        }
        CargoEquivalente other = (CargoEquivalente) object;
        return !((this.idCargoEquivalente == null && other.idCargoEquivalente != null) || (this.idCargoEquivalente != null && !this.idCargoEquivalente.equals(other.idCargoEquivalente)));
    }

    @Override
    public String toString() {
        return "Persistencia.CargoEquivalente[ idCargoEquivalente=" + idCargoEquivalente + " ]";
    }
}
