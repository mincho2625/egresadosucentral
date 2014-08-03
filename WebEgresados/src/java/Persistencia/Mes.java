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
@Table(name = "mes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mes.findAll", query = "SELECT m FROM Mes m"),
    @NamedQuery(name = "Mes.findByIdMes", query = "SELECT m FROM Mes m WHERE m.idMes = :idMes"),
    @NamedQuery(name = "Mes.findByMes", query = "SELECT m FROM Mes m WHERE m.mes = :mes"),
    @NamedQuery(name = "Mes.findByEstado", query = "SELECT m FROM Mes m WHERE m.estado = :estado")})
public class Mes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MES")
    private Long idMes;
    @Basic(optional = false)
    @Column(name = "MES")
    private String mes;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMesIngreso")
    private Collection<ExperienciaLaboral> experienciaLaboralCollection;
    @OneToMany(mappedBy = "idMesFinalizacion")
    private Collection<ExperienciaLaboral> experienciaLaboralCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMesInicio")
    private Collection<Educacion> educacionCollection;
    @OneToMany(mappedBy = "idMesFinalizacion")
    private Collection<Educacion> educacionCollection1;

    public Mes() {
    }

    public Mes(Long idMes) {
        this.idMes = idMes;
    }

    public Mes(Long idMes, String mes, boolean estado) {
        this.idMes = idMes;
        this.mes = mes;
        this.estado = estado;
    }

    public Long getIdMes() {
        return idMes;
    }

    public void setIdMes(Long idMes) {
        this.idMes = idMes;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
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

    @XmlTransient
    public Collection<ExperienciaLaboral> getExperienciaLaboralCollection1() {
        return experienciaLaboralCollection1;
    }

    public void setExperienciaLaboralCollection1(Collection<ExperienciaLaboral> experienciaLaboralCollection1) {
        this.experienciaLaboralCollection1 = experienciaLaboralCollection1;
    }

    @XmlTransient
    public Collection<Educacion> getEducacionCollection() {
        return educacionCollection;
    }

    public void setEducacionCollection(Collection<Educacion> educacionCollection) {
        this.educacionCollection = educacionCollection;
    }

    @XmlTransient
    public Collection<Educacion> getEducacionCollection1() {
        return educacionCollection1;
    }

    public void setEducacionCollection1(Collection<Educacion> educacionCollection1) {
        this.educacionCollection1 = educacionCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMes != null ? idMes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mes)) {
            return false;
        }
        Mes other = (Mes) object;
        if ((this.idMes == null && other.idMes != null) || (this.idMes != null && !this.idMes.equals(other.idMes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Mes[ idMes=" + idMes + " ]";
    }
    
}
