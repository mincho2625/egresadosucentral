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
@Table(name = "aficiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aficiones.findAll", query = "SELECT a FROM Aficiones a"),
    @NamedQuery(name = "Aficiones.findByIdAficion", query = "SELECT a FROM Aficiones a WHERE a.idAficion = :idAficion"),
    @NamedQuery(name = "Aficiones.findByListaActividades", query = "SELECT a FROM Aficiones a WHERE a.listaActividades = :listaActividades"),
    @NamedQuery(name = "Aficiones.findByFechaRegistro", query = "SELECT a FROM Aficiones a WHERE a.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Aficiones.findByEstado", query = "SELECT a FROM Aficiones a WHERE a.estado = :estado"),
    @NamedQuery(name = "Aficiones.findByConsulta", query = "SELECT a FROM Aficiones a inner join Egresado e on e = a.idEgresado WHERE a.estado = :estado"),
    @NamedQuery(name = "Aficiones.findByIdEgresado", 
            query = "SELECT a FROM Aficiones a "
                    + "inner join Egresado e on e = a.idEgresado "
                    + "inner join Usuario u on u = e.usuario "
                    + "WHERE u.idUsuario = :idEgresado and a.estado = :estado")})
public class Aficiones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_AFICION")
    private Long idAficion;
    @Basic(optional = false)
    @Column(name = "LISTA_ACTIVIDADES")
    private String listaActividades;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @JoinColumn(name = "ID_TIPO_ACTIVIDAD", referencedColumnName = "ID_TIPO_ACTIVIDAD")
    @ManyToOne(optional = false)
    private TipoActividad idTipoActividad;
    @JoinColumn(name = "ID_EGRESADO", referencedColumnName = "ID_EGRESADO")
    @ManyToOne(optional = false)
    private Egresado idEgresado;

    public Aficiones() {
    }

    public Aficiones(Long idAficion) {
        this.idAficion = idAficion;
    }

    public Aficiones(Long idAficion, String listaActividades, Date fechaRegistro, boolean estado) {
        this.idAficion = idAficion;
        this.listaActividades = listaActividades;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    public Long getIdAficion() {
        return idAficion;
    }

    public void setIdAficion(Long idAficion) {
        this.idAficion = idAficion;
    }

    public String getListaActividades() {
        return listaActividades;
    }

    public void setListaActividades(String listaActividades) {
        this.listaActividades = listaActividades;
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

    public TipoActividad getIdTipoActividad() {
        return idTipoActividad;
    }

    public void setIdTipoActividad(TipoActividad idTipoActividad) {
        this.idTipoActividad = idTipoActividad;
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
        hash += (idAficion != null ? idAficion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aficiones)) {
            return false;
        }
        Aficiones other = (Aficiones) object;
        return (this.idAficion != null || other.idAficion == null) && (this.idAficion == null || this.idAficion.equals(other.idAficion));
    }

    @Override
    public String toString() {
        return "Persistencia.Aficiones[ idAficion=" + idAficion + " ]";
    }
}
