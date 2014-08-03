/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @NamedQuery(name = "EgresadoRespuesta.findByIdRespuesta", query = "SELECT e FROM EgresadoRespuesta e WHERE e.egresadoRespuestaPK.idRespuesta = :idRespuesta"),
    @NamedQuery(name = "EgresadoRespuesta.findByOtra", query = "SELECT e FROM EgresadoRespuesta e WHERE e.otra = :otra"),
    @NamedQuery(name = "EgresadoRespuesta.findByEstado", query = "SELECT e FROM EgresadoRespuesta e WHERE e.estado = :estado"),
    @NamedQuery(name = "EgresadoRespuesta.findByIdEgresado", query = "SELECT e FROM EgresadoRespuesta e WHERE e.egresadoRespuestaPK.idEgresado = :idEgresado")})
public class EgresadoRespuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EgresadoRespuestaPK egresadoRespuestaPK;
    @Column(name = "OTRA")
    private String otra;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @JoinColumn(name = "ID_RESPUESTA", referencedColumnName = "ID_RESPUESTA_ENCUESTA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RespuestaEncuesta respuestaEncuesta;
    @JoinColumn(name = "ID_EGRESADO", referencedColumnName = "ID_EGRESADO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Egresado egresado;

    public EgresadoRespuesta() {
    }

    public EgresadoRespuesta(EgresadoRespuestaPK egresadoRespuestaPK) {
        this.egresadoRespuestaPK = egresadoRespuestaPK;
    }

    public EgresadoRespuesta(EgresadoRespuestaPK egresadoRespuestaPK, boolean estado) {
        this.egresadoRespuestaPK = egresadoRespuestaPK;
        this.estado = estado;
    }

    public EgresadoRespuesta(long idRespuesta, long idEgresado) {
        this.egresadoRespuestaPK = new EgresadoRespuestaPK(idRespuesta, idEgresado);
    }

    public EgresadoRespuestaPK getEgresadoRespuestaPK() {
        return egresadoRespuestaPK;
    }

    public void setEgresadoRespuestaPK(EgresadoRespuestaPK egresadoRespuestaPK) {
        this.egresadoRespuestaPK = egresadoRespuestaPK;
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

    public RespuestaEncuesta getRespuestaEncuesta() {
        return respuestaEncuesta;
    }

    public void setRespuestaEncuesta(RespuestaEncuesta respuestaEncuesta) {
        this.respuestaEncuesta = respuestaEncuesta;
    }

    public Egresado getEgresado() {
        return egresado;
    }

    public void setEgresado(Egresado egresado) {
        this.egresado = egresado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (egresadoRespuestaPK != null ? egresadoRespuestaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EgresadoRespuesta)) {
            return false;
        }
        EgresadoRespuesta other = (EgresadoRespuesta) object;
        if ((this.egresadoRespuestaPK == null && other.egresadoRespuestaPK != null) || (this.egresadoRespuestaPK != null && !this.egresadoRespuestaPK.equals(other.egresadoRespuestaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.EgresadoRespuesta[ egresadoRespuestaPK=" + egresadoRespuestaPK + " ]";
    }
    
}
