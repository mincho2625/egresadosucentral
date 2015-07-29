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
@Table(name = "intensidad_horaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IntensidadHoraria.findAll", query = "SELECT i FROM IntensidadHoraria i"),
    @NamedQuery(name = "IntensidadHoraria.findByIdIntensidadHoraria", query = "SELECT i FROM IntensidadHoraria i WHERE i.idIntensidadHoraria = :idIntensidadHoraria"),
    @NamedQuery(name = "IntensidadHoraria.findByNombre", query = "SELECT i FROM IntensidadHoraria i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "IntensidadHoraria.findByEstado", query = "SELECT i FROM IntensidadHoraria i WHERE i.estado = :estado")})
public class IntensidadHoraria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_INTENSIDAD_HORARIA")
    private Long idIntensidadHoraria;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIntensidadHoraria")
    private Collection<EducacionNoFormal> educacionNoFormalCollection;

    public IntensidadHoraria() {
    }

    public IntensidadHoraria(Long idIntensidadHoraria) {
        this.idIntensidadHoraria = idIntensidadHoraria;
    }

    public IntensidadHoraria(Long idIntensidadHoraria, String nombre, boolean estado) {
        this.idIntensidadHoraria = idIntensidadHoraria;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getIdIntensidadHoraria() {
        return idIntensidadHoraria;
    }

    public void setIdIntensidadHoraria(Long idIntensidadHoraria) {
        this.idIntensidadHoraria = idIntensidadHoraria;
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
        hash += (idIntensidadHoraria != null ? idIntensidadHoraria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IntensidadHoraria)) {
            return false;
        }
        IntensidadHoraria other = (IntensidadHoraria) object;
        return !((this.idIntensidadHoraria == null && other.idIntensidadHoraria != null) || (this.idIntensidadHoraria != null && !this.idIntensidadHoraria.equals(other.idIntensidadHoraria)));
    }

    @Override
    public String toString() {
        return "Persistencia.IntensidadHoraria[ idIntensidadHoraria=" + idIntensidadHoraria + " ]";
    }
    
}
