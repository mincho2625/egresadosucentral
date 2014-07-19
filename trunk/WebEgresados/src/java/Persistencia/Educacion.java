/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YURY
 */
@Entity
@Table(name = "educacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Educacion.findAll", query = "SELECT e FROM Educacion e"),
    @NamedQuery(name = "Educacion.findByIdEducacion", query = "SELECT e FROM Educacion e WHERE e.idEducacion = :idEducacion"),
    @NamedQuery(name = "Educacion.findByFechaActEstado", query = "SELECT e FROM Educacion e WHERE e.fechaActEstado = :fechaActEstado"),
    @NamedQuery(name = "Educacion.findByFechaRegistro", query = "SELECT e FROM Educacion e WHERE e.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Educacion.findByAnioInicio", query = "SELECT e FROM Educacion e WHERE e.anioInicio = :anioInicio"),
    @NamedQuery(name = "Educacion.findByAnioFinalizacion", query = "SELECT e FROM Educacion e WHERE e.anioFinalizacion = :anioFinalizacion"),
    @NamedQuery(name = "Educacion.findByOtraInstitucion", query = "SELECT e FROM Educacion e WHERE e.otraInstitucion = :otraInstitucion")})
public class Educacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EDUCACION")
    private Integer idEducacion;
    @Basic(optional = false)
    @Column(name = "FECHA_ACT_ESTADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActEstado;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "ANIO_INICIO")
    private int anioInicio;
    @Column(name = "ANIO_FINALIZACION")
    private Integer anioFinalizacion;
    @Column(name = "OTRA_INSTITUCION")
    private String otraInstitucion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "educacion")
    private EducacionNoFormal educacionNoFormal;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "educacion")
    private LenguaExtranjera lenguaExtranjera;
    @JoinColumn(name = "ID_EGRESADO", referencedColumnName = "ID_EGRESADO")
    @ManyToOne(optional = false)
    private Egresado idEgresado;
    @JoinColumn(name = "ID_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad idCiudad;
    @JoinColumn(name = "ID_MES_INICIO", referencedColumnName = "ID_MES")
    @ManyToOne(optional = false)
    private Mes idMesInicio;
    @JoinColumn(name = "ID_MES_FINALIZACION", referencedColumnName = "ID_MES")
    @ManyToOne
    private Mes idMesFinalizacion;
    @JoinColumn(name = "ID_AREA_ESTUDIOS", referencedColumnName = "ID_AREA_ESTUDIOS")
    @ManyToOne(optional = false)
    private AreaEstudios idAreaEstudios;
    @JoinColumn(name = "ID_ESTADO_EDUCACION", referencedColumnName = "ID_ESTADO_EDUCACION")
    @ManyToOne(optional = false)
    private EstadoEducacion idEstadoEducacion;
    @JoinColumn(name = "ID_MODALIDAD", referencedColumnName = "ID_MODALIDAD")
    @ManyToOne(optional = false)
    private Modalidad idModalidad;
    @JoinColumn(name = "ID_INSTITUCION", referencedColumnName = "ID_INSTITUCION")
    @ManyToOne(optional = false)
    private Institucion idInstitucion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "educacion")
    private EducacionFormal educacionFormal;

    public Educacion() {
    }

    public Educacion(Integer idEducacion) {
        this.idEducacion = idEducacion;
    }

    public Educacion(Integer idEducacion, Date fechaActEstado, Date fechaRegistro, int anioInicio) {
        this.idEducacion = idEducacion;
        this.fechaActEstado = fechaActEstado;
        this.fechaRegistro = fechaRegistro;
        this.anioInicio = anioInicio;
    }

    public Integer getIdEducacion() {
        return idEducacion;
    }

    public void setIdEducacion(Integer idEducacion) {
        this.idEducacion = idEducacion;
    }

    public Date getFechaActEstado() {
        return fechaActEstado;
    }

    public void setFechaActEstado(Date fechaActEstado) {
        this.fechaActEstado = fechaActEstado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(int anioInicio) {
        this.anioInicio = anioInicio;
    }

    public Integer getAnioFinalizacion() {
        return anioFinalizacion;
    }

    public void setAnioFinalizacion(Integer anioFinalizacion) {
        this.anioFinalizacion = anioFinalizacion;
    }

    public String getOtraInstitucion() {
        return otraInstitucion;
    }

    public void setOtraInstitucion(String otraInstitucion) {
        this.otraInstitucion = otraInstitucion;
    }

    public EducacionNoFormal getEducacionNoFormal() {
        return educacionNoFormal;
    }

    public void setEducacionNoFormal(EducacionNoFormal educacionNoFormal) {
        this.educacionNoFormal = educacionNoFormal;
    }

    public LenguaExtranjera getLenguaExtranjera() {
        return lenguaExtranjera;
    }

    public void setLenguaExtranjera(LenguaExtranjera lenguaExtranjera) {
        this.lenguaExtranjera = lenguaExtranjera;
    }

    public Egresado getIdEgresado() {
        return idEgresado;
    }

    public void setIdEgresado(Egresado idEgresado) {
        this.idEgresado = idEgresado;
    }

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Mes getIdMesInicio() {
        return idMesInicio;
    }

    public void setIdMesInicio(Mes idMesInicio) {
        this.idMesInicio = idMesInicio;
    }

    public Mes getIdMesFinalizacion() {
        return idMesFinalizacion;
    }

    public void setIdMesFinalizacion(Mes idMesFinalizacion) {
        this.idMesFinalizacion = idMesFinalizacion;
    }

    public AreaEstudios getIdAreaEstudios() {
        return idAreaEstudios;
    }

    public void setIdAreaEstudios(AreaEstudios idAreaEstudios) {
        this.idAreaEstudios = idAreaEstudios;
    }

    public EstadoEducacion getIdEstadoEducacion() {
        return idEstadoEducacion;
    }

    public void setIdEstadoEducacion(EstadoEducacion idEstadoEducacion) {
        this.idEstadoEducacion = idEstadoEducacion;
    }

    public Modalidad getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(Modalidad idModalidad) {
        this.idModalidad = idModalidad;
    }

    public Institucion getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Institucion idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public EducacionFormal getEducacionFormal() {
        return educacionFormal;
    }

    public void setEducacionFormal(EducacionFormal educacionFormal) {
        this.educacionFormal = educacionFormal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEducacion != null ? idEducacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Educacion)) {
            return false;
        }
        Educacion other = (Educacion) object;
        if ((this.idEducacion == null && other.idEducacion != null) || (this.idEducacion != null && !this.idEducacion.equals(other.idEducacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Educacion[ idEducacion=" + idEducacion + " ]";
    }
    
}
