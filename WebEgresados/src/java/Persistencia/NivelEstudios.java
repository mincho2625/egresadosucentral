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
@Table(name = "nivel_estudios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelEstudios.findAll", query = "SELECT n FROM NivelEstudios n"),
    @NamedQuery(name = "NivelEstudios.findByIdNivelEstudios", query = "SELECT n FROM NivelEstudios n WHERE n.idNivelEstudios = :idNivelEstudios"),
    @NamedQuery(name = "NivelEstudios.findByNombre", query = "SELECT n FROM NivelEstudios n WHERE n.nombre = :nombre"),
    @NamedQuery(name = "NivelEstudios.findByEstado", query = "SELECT n FROM NivelEstudios n WHERE n.estado = :estado"),
    @NamedQuery(name = "NivelEstudios.findByFormal", query = "SELECT n FROM NivelEstudios n WHERE n.formal = :formal"),
    @NamedQuery(name = "NivelEstudios.findByObligatorioUCentral", query = "SELECT n FROM NivelEstudios n WHERE n.obligatorioUCentral = :obligatorioUCentral"),
    @NamedQuery(name = "NivelEstudios.findByObligatorioOtrasInst", query = "SELECT n FROM NivelEstudios n WHERE n.obligatorioOtrasInst = :obligatorioOtrasInst"),
    @NamedQuery(name = "NivelEstudios.findByObligatorioNoFormal", query = "SELECT n FROM NivelEstudios n WHERE n.obligatorioNoFormal = :obligatorioNoFormal"),
    @NamedQuery(name = "NivelEstudios.findByAplicaUCentral", query = "SELECT distinct n FROM NivelEstudios n inner join Programa p on p.idNivelEstudios = n")})
public class NivelEstudios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_NIVEL_ESTUDIOS")
    private Long idNivelEstudios;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @Basic(optional = false)
    @Column(name = "FORMAL")
    private boolean formal;
    @Basic(optional = false)
    @Column(name = "OBLIGATORIO_U_CENTRAL")
    private boolean obligatorioUCentral;
    @Basic(optional = false)
    @Column(name = "OBLIGATORIO_OTRAS_INST")
    private boolean obligatorioOtrasInst;
    @Basic(optional = false)
    @Column(name = "OBLIGATORIO_NO_FORMAL")
    private boolean obligatorioNoFormal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivelEstudios")
    private Collection<Programa> programaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivelEstudios")
    private Collection<EducacionNoFormal> educacionNoFormalCollection;
    @OneToMany(mappedBy = "idNivelEstudios")
    private Collection<AreaEstudios> areaEstudiosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivelEstudios")
    private Collection<EdFormalOtrasInstituciones> edFormalOtrasInstitucionesCollection;

    public NivelEstudios() {
    }

    public NivelEstudios(Long idNivelEstudios) {
        this.idNivelEstudios = idNivelEstudios;
    }

    public NivelEstudios(Long idNivelEstudios, String nombre, boolean estado, boolean formal, boolean obligatorioUCentral, boolean obligatorioOtrasInst, boolean obligatorioNoFormal) {
        this.idNivelEstudios = idNivelEstudios;
        this.nombre = nombre;
        this.estado = estado;
        this.formal = formal;
        this.obligatorioUCentral = obligatorioUCentral;
        this.obligatorioOtrasInst = obligatorioOtrasInst;
        this.obligatorioNoFormal = obligatorioNoFormal;
    }

    public Long getIdNivelEstudios() {
        return idNivelEstudios;
    }

    public void setIdNivelEstudios(Long idNivelEstudios) {
        this.idNivelEstudios = idNivelEstudios;
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

    public boolean getFormal() {
        return formal;
    }

    public void setFormal(boolean formal) {
        this.formal = formal;
    }

    public boolean getObligatorioUCentral() {
        return obligatorioUCentral;
    }

    public void setObligatorioUCentral(boolean obligatorioUCentral) {
        this.obligatorioUCentral = obligatorioUCentral;
    }

    public boolean getObligatorioOtrasInst() {
        return obligatorioOtrasInst;
    }

    public void setObligatorioOtrasInst(boolean obligatorioOtrasInst) {
        this.obligatorioOtrasInst = obligatorioOtrasInst;
    }

    public boolean getObligatorioNoFormal() {
        return obligatorioNoFormal;
    }

    public void setObligatorioNoFormal(boolean obligatorioNoFormal) {
        this.obligatorioNoFormal = obligatorioNoFormal;
    }

    @XmlTransient
    public Collection<Programa> getProgramaCollection() {
        return programaCollection;
    }

    public void setProgramaCollection(Collection<Programa> programaCollection) {
        this.programaCollection = programaCollection;
    }

    @XmlTransient
    public Collection<EducacionNoFormal> getEducacionNoFormalCollection() {
        return educacionNoFormalCollection;
    }

    public void setEducacionNoFormalCollection(Collection<EducacionNoFormal> educacionNoFormalCollection) {
        this.educacionNoFormalCollection = educacionNoFormalCollection;
    }

    @XmlTransient
    public Collection<AreaEstudios> getAreaEstudiosCollection() {
        return areaEstudiosCollection;
    }

    public void setAreaEstudiosCollection(Collection<AreaEstudios> areaEstudiosCollection) {
        this.areaEstudiosCollection = areaEstudiosCollection;
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
        hash += (idNivelEstudios != null ? idNivelEstudios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelEstudios)) {
            return false;
        }
        NivelEstudios other = (NivelEstudios) object;
        return (this.idNivelEstudios != null || other.idNivelEstudios == null) && (this.idNivelEstudios == null || this.idNivelEstudios.equals(other.idNivelEstudios));
    }

    @Override
    public String toString() {
        return "Persistencia.NivelEstudios[ idNivelEstudios=" + idNivelEstudios + " ]";
    }
    
}
