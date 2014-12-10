/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YURY
 */
@Entity
@Table(name = "asociacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asociacion.findAll", query = "SELECT a FROM Asociacion a"),
    @NamedQuery(name = "Asociacion.findByIdAsociacion", query = "SELECT a FROM Asociacion a WHERE a.idAsociacion = :idAsociacion"),
    @NamedQuery(name = "Asociacion.findByDescripcion", query = "SELECT a FROM Asociacion a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Asociacion.findByFechaVinculacion", query = "SELECT a FROM Asociacion a WHERE a.fechaVinculacion = :fechaVinculacion"),
    @NamedQuery(name = "Asociacion.findByFechaRegistro", query = "SELECT a FROM Asociacion a WHERE a.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Asociacion.findByEstado", query = "SELECT a FROM Asociacion a WHERE a.estado = :estado"),
    @NamedQuery(name = "Asociacion.findByOtra", query = "SELECT a FROM Asociacion a WHERE a.otra = :otra")})
public class Asociacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ASOCIACION")
    private Long idAsociacion;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "FECHA_VINCULACION")
    @Temporal(TemporalType.DATE)
    private Date fechaVinculacion;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @Column(name = "OTRA")
    private String otra;
    @JoinColumn(name = "ID_TIPO_ASOCIACION", referencedColumnName = "ID_TIPO_ASOCIACION")
    @ManyToOne
    private TipoAsociacion idTipoAsociacion;
    @JoinColumn(name = "ID_PAIS", referencedColumnName = "ID_PAIS")
    @ManyToOne(optional = false)
    private Pais idPais;
    @JoinColumn(name = "ID_EGRESADO", referencedColumnName = "ID_EGRESADO")
    @ManyToOne(optional = false)
    private Egresado idEgresado;

    public Asociacion() {
    }

    public Asociacion(Long idAsociacion) {
        this.idAsociacion = idAsociacion;
    }

    public Asociacion(Long idAsociacion, String descripcion, Date fechaVinculacion, Date fechaRegistro, boolean estado) {
        this.idAsociacion = idAsociacion;
        this.descripcion = descripcion;
        this.fechaVinculacion = fechaVinculacion;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    public Long getIdAsociacion() {
        return idAsociacion;
    }

    public void setIdAsociacion(Long idAsociacion) {
        this.idAsociacion = idAsociacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaVinculacion() {
        return fechaVinculacion;
    }

    public void setFechaVinculacion(Date fechaVinculacion) {
        this.fechaVinculacion = fechaVinculacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getOtra() {
        return otra;
    }

    public void setOtra(String otra) {
        this.otra = otra;
    }

    public TipoAsociacion getIdTipoAsociacion() {
        return idTipoAsociacion;
    }

    public void setIdTipoAsociacion(TipoAsociacion idTipoAsociacion) {
        this.idTipoAsociacion = idTipoAsociacion;
    }

    public Pais getIdPais() {
        return idPais;
    }

    public void setIdPais(Pais idPais) {
        this.idPais = idPais;
    }

    public Egresado getIdEgresado() {
        return idEgresado;
    }

    public void setIdEgresado(Egresado idEgresado) {
        this.idEgresado = idEgresado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsociacion != null ? idAsociacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asociacion)) {
            return false;
        }
        Asociacion other = (Asociacion) object;
        if ((this.idAsociacion == null && other.idAsociacion != null) || (this.idAsociacion != null && !this.idAsociacion.equals(other.idAsociacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Asociacion[ idAsociacion=" + idAsociacion + " ]";
    }
    
}
