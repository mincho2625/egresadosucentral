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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c"),
    @NamedQuery(name = "Ciudad.findByIdCiudad", query = "SELECT c FROM Ciudad c WHERE c.idCiudad = :idCiudad"),
    @NamedQuery(name = "Ciudad.findByNombre", query = "SELECT c FROM Ciudad c WHERE c.nombre = :nombre and c.estado = :estado"),
    @NamedQuery(name = "Ciudad.findByEstado", query = "SELECT c FROM Ciudad c WHERE c.estado = :estado"),
    @NamedQuery(name = "Ciudad.findByIdDepartamento", query = "SELECT c FROM Ciudad c inner join Departamento d on d = c.idDepartamento WHERE d.idDepartamento = :idDepartamento and c.estado = :estado")})
public class Ciudad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CIUDAD")
    private Long idCiudad;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudad")
    private Collection<Residencia> residenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudad")
    private Collection<ExperienciaLaboral> experienciaLaboralCollection;
    @JoinColumn(name = "ID_DEPARTAMENTO", referencedColumnName = "ID_DEPARTAMENTO")
    @ManyToOne(optional = false)
    private Departamento idDepartamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudad")
    private Collection<Reconocimiento> reconocimientoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudadExpedicion")
    private Collection<Egresado> egresadoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudadNacimiento")
    private Collection<Egresado> egresadoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudad")
    private Collection<Educacion> educacionCollection;
    @Basic(optional = false)
    @Column(name = "SOLO_LECTURA")
    private boolean soloLectura;

    public Ciudad() {
    }

    public Ciudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Ciudad(Long idCiudad, String nombre, boolean estado) {
        this.idCiudad = idCiudad;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
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

    @XmlTransient
    public Collection<ExperienciaLaboral> getExperienciaLaboralCollection() {
        return experienciaLaboralCollection;
    }

    public void setExperienciaLaboralCollection(Collection<ExperienciaLaboral> experienciaLaboralCollection) {
        this.experienciaLaboralCollection = experienciaLaboralCollection;
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @XmlTransient
    public Collection<Reconocimiento> getReconocimientoCollection() {
        return reconocimientoCollection;
    }

    public void setReconocimientoCollection(Collection<Reconocimiento> reconocimientoCollection) {
        this.reconocimientoCollection = reconocimientoCollection;
    }

    @XmlTransient
    public Collection<Egresado> getEgresadoCollection() {
        return egresadoCollection;
    }

    public void setEgresadoCollection(Collection<Egresado> egresadoCollection) {
        this.egresadoCollection = egresadoCollection;
    }

    @XmlTransient
    public Collection<Egresado> getEgresadoCollection1() {
        return egresadoCollection1;
    }

    public void setEgresadoCollection1(Collection<Egresado> egresadoCollection1) {
        this.egresadoCollection1 = egresadoCollection1;
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
        hash += (idCiudad != null ? idCiudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        return (this.idCiudad != null || other.idCiudad == null) && (this.idCiudad == null || this.idCiudad.equals(other.idCiudad));
    }

    @Override
    public String toString() {
        return "Persistencia.Ciudad[ idCiudad=" + idCiudad + " ]";
    }
}