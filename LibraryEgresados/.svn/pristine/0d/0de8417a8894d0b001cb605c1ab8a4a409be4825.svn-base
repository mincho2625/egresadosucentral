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
@Table(name = "area_estudios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaEstudios.findAll", query = "SELECT a FROM AreaEstudios a"),
    @NamedQuery(name = "AreaEstudios.findByIdAreaEstudios", query = "SELECT a FROM AreaEstudios a WHERE a.idAreaEstudios = :idAreaEstudios"),
    @NamedQuery(name = "AreaEstudios.findByNombre", query = "SELECT a FROM AreaEstudios a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "AreaEstudios.findByEstado", query = "SELECT a FROM AreaEstudios a WHERE a.estado = :estado"),
    @NamedQuery(name = "AreaEstudios.findByIdNivelEstudios", query = "SELECT a FROM AreaEstudios a inner join NivelEstudios n on n = a.idNivelEstudios WHERE n.idNivelEstudios = :idNivelEstudios and a.estado = :estado"),
    @NamedQuery(name = "AreaEstudios.findByIdNivelEstudiosNull", query = "SELECT a FROM AreaEstudios a WHERE a.idNivelEstudios is null and a.estado = :estado")})
public class AreaEstudios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_AREA_ESTUDIOS")
    private Long idAreaEstudios;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAreaEstudios")
    private Collection<EducacionNoFormal> educacionNoFormalCollection;
    @JoinColumn(name = "ID_NIVEL_ESTUDIOS", referencedColumnName = "ID_NIVEL_ESTUDIOS")
    @ManyToOne
    private NivelEstudios idNivelEstudios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAreaEstudios")
    private Collection<EdFormalOtrasInstituciones> edFormalOtrasInstitucionesCollection;

    public AreaEstudios() {
    }

    public AreaEstudios(Long idAreaEstudios) {
        this.idAreaEstudios = idAreaEstudios;
    }

    public AreaEstudios(Long idAreaEstudios, String nombre, boolean estado) {
        this.idAreaEstudios = idAreaEstudios;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getIdAreaEstudios() {
        return idAreaEstudios;
    }

    public void setIdAreaEstudios(Long idAreaEstudios) {
        this.idAreaEstudios = idAreaEstudios;
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

    public NivelEstudios getIdNivelEstudios() {
        return idNivelEstudios;
    }

    public void setIdNivelEstudios(NivelEstudios idNivelEstudios) {
        this.idNivelEstudios = idNivelEstudios;
    }

    @XmlTransient
    public Collection<EdFormalOtrasInstituciones> getEdFormalOtrasInstitucionesCollection() {
        return edFormalOtrasInstitucionesCollection;
    }

    public void setEdFormalOtrasInstitucionesCollection(Collection<EdFormalOtrasInstituciones> edFormalOtrasInstitucionesCollection) {
        this.edFormalOtrasInstitucionesCollection = edFormalOtrasInstitucionesCollection;
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
        return (this.idAreaEstudios != null || other.idAreaEstudios == null) && (this.idAreaEstudios == null || this.idAreaEstudios.equals(other.idAreaEstudios));
    }

    @Override
    public String toString() {
        return "Persistencia.AreaEstudios[ idAreaEstudios=" + idAreaEstudios + " ]";
    }
    
}
