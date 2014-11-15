/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author YURY
 */
@Entity
@Table(name = "encuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encuesta.findAll", query = "SELECT e FROM Encuesta e"),
    @NamedQuery(name = "Encuesta.findByIdEncuesta", query = "SELECT e FROM Encuesta e WHERE e.idEncuesta = :idEncuesta"),
    @NamedQuery(name = "Encuesta.findByNombre", query = "SELECT e FROM Encuesta e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Encuesta.findByDescripcion", query = "SELECT e FROM Encuesta e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Encuesta.findByEstado", query = "SELECT e FROM Encuesta e WHERE e.estado = :estado"),
    @NamedQuery(name = "Encuesta.findByGraduando", query = "SELECT e FROM Encuesta e WHERE e.graduando = :graduando"),
    @NamedQuery(name = "Encuesta.findByEgresado", query = "SELECT e FROM Encuesta e WHERE e.egresado = :egresado"),
    @NamedQuery(name = "Encuesta.findByFechaRegistro", query = "SELECT e FROM Encuesta e WHERE e.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Encuesta.findByOrden", query = "SELECT e FROM Encuesta e WHERE e.orden = :orden")})
public class Encuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ENCUESTA")
    private Long idEncuesta;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @Basic(optional = false)
    @Column(name = "GRADUANDO")
    private boolean graduando;
    @Basic(optional = false)
    @Column(name = "EGRESADO")
    private boolean egresado;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "ORDEN")
    private int orden;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEncuesta")
    private Collection<PreguntaEncuesta> preguntaEncuestaCollection;

    public Encuesta() {
    }

    public Encuesta(Long idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public Encuesta(Long idEncuesta, String nombre, boolean estado, boolean graduando, boolean egresado, Date fechaRegistro, int orden) {
        this.idEncuesta = idEncuesta;
        this.nombre = nombre;
        this.estado = estado;
        this.graduando = graduando;
        this.egresado = egresado;
        this.fechaRegistro = fechaRegistro;
        this.orden = orden;
    }

    public Long getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(Long idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean getGraduando() {
        return graduando;
    }

    public void setGraduando(boolean graduando) {
        this.graduando = graduando;
    }

    public boolean getEgresado() {
        return egresado;
    }

    public void setEgresado(boolean egresado) {
        this.egresado = egresado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    @XmlTransient
    public Collection<PreguntaEncuesta> getPreguntaEncuestaCollection() {
        return preguntaEncuestaCollection;
    }

    public void setPreguntaEncuestaCollection(Collection<PreguntaEncuesta> preguntaEncuestaCollection) {
        this.preguntaEncuestaCollection = preguntaEncuestaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEncuesta != null ? idEncuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encuesta)) {
            return false;
        }
        Encuesta other = (Encuesta) object;
        if ((this.idEncuesta == null && other.idEncuesta != null) || (this.idEncuesta != null && !this.idEncuesta.equals(other.idEncuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Encuesta[ idEncuesta=" + idEncuesta + " ]";
    }
    
}
