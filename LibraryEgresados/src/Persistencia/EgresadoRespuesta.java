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
@Table(name = "egresado_respuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EgresadoRespuesta.findAll", query = "SELECT e FROM EgresadoRespuesta e"),
    @NamedQuery(name = "EgresadoRespuesta.findByOtra", query = "SELECT e FROM EgresadoRespuesta e WHERE e.otra = :otra"),
    @NamedQuery(name = "EgresadoRespuesta.findByEstado", query = "SELECT e FROM EgresadoRespuesta e WHERE e.estado = :estado"),
    @NamedQuery(name = "EgresadoRespuesta.findByIdEgresadoRespuesta", query = "SELECT e FROM EgresadoRespuesta e WHERE e.idEgresadoRespuesta = :idEgresadoRespuesta"),
    @NamedQuery(name = "EgresadoRespuesta.findByConsulta", query = "SELECT e FROM EgresadoRespuesta e WHERE e.estado = :estado"),
    @NamedQuery(name = "EgresadoRespuesta.findByFechaRegistro", query = "SELECT e FROM EgresadoRespuesta e WHERE e.fechaRegistro = :fechaRegistro")})
public class EgresadoRespuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "OTRA")
    private String otra;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EGRESADO_RESPUESTA")
    private Long idEgresadoRespuesta;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @JoinColumn(name = "ID_RESPUESTA_ENCUESTA", referencedColumnName = "ID_RESPUESTA_ENCUESTA")
    @ManyToOne
    private RespuestaEncuesta idRespuestaEncuesta;
    @JoinColumn(name = "ID_EGRESADO", referencedColumnName = "ID_EGRESADO")
    @ManyToOne(optional = false)
    private Egresado idEgresado;
    @JoinColumn(name = "ID_PREGUNTA_ENCUESTA", referencedColumnName = "ID_PREGUNTA_ENCUESTA")
    @ManyToOne(optional = false)
    private PreguntaEncuesta idPreguntaEncuesta;

    public EgresadoRespuesta() {
    }

    public EgresadoRespuesta(Long idEgresadoRespuesta) {
        this.idEgresadoRespuesta = idEgresadoRespuesta;
    }

    public EgresadoRespuesta(Long idEgresadoRespuesta, boolean estado, Date fechaRegistro) {
        this.idEgresadoRespuesta = idEgresadoRespuesta;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
    }

    public String getOtra() {
        return otra;
    }

    public void setOtra(String otra) {
        this.otra = otra;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Long getIdEgresadoRespuesta() {
        return idEgresadoRespuesta;
    }

    public void setIdEgresadoRespuesta(Long idEgresadoRespuesta) {
        this.idEgresadoRespuesta = idEgresadoRespuesta;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public RespuestaEncuesta getIdRespuestaEncuesta() {
        return idRespuestaEncuesta;
    }

    public void setIdRespuestaEncuesta(RespuestaEncuesta idRespuestaEncuesta) {
        this.idRespuestaEncuesta = idRespuestaEncuesta;
    }

    public Egresado getIdEgresado() {
        return idEgresado;
    }

    public void setIdEgresado(Egresado idEgresado) {
        this.idEgresado = idEgresado;
    }

    public PreguntaEncuesta getIdPreguntaEncuesta() {
        return idPreguntaEncuesta;
    }

    public void setIdPreguntaEncuesta(PreguntaEncuesta idPreguntaEncuesta) {
        this.idPreguntaEncuesta = idPreguntaEncuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEgresadoRespuesta != null ? idEgresadoRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EgresadoRespuesta)) {
            return false;
        }
        EgresadoRespuesta other = (EgresadoRespuesta) object;
        return (this.idEgresadoRespuesta != null || other.idEgresadoRespuesta == null) && (this.idEgresadoRespuesta == null || this.idEgresadoRespuesta.equals(other.idEgresadoRespuesta));
    }

    @Override
    public String toString() {
        return "Persistencia.EgresadoRespuesta[ idEgresadoRespuesta=" + idEgresadoRespuesta + " ]";
    }
}