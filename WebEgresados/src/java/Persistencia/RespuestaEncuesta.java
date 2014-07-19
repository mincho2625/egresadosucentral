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
import javax.persistence.Lob;
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
@Table(name = "respuesta_encuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RespuestaEncuesta.findAll", query = "SELECT r FROM RespuestaEncuesta r"),
    @NamedQuery(name = "RespuestaEncuesta.findByIdRespuestaEncuesta", query = "SELECT r FROM RespuestaEncuesta r WHERE r.idRespuestaEncuesta = :idRespuestaEncuesta"),
    @NamedQuery(name = "RespuestaEncuesta.findByRespuesta", query = "SELECT r FROM RespuestaEncuesta r WHERE r.respuesta = :respuesta")})
public class RespuestaEncuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_RESPUESTA_ENCUESTA")
    private Integer idRespuestaEncuesta;
    @Basic(optional = false)
    @Column(name = "RESPUESTA")
    private String respuesta;
    @Basic(optional = false)
    @Lob
    @Column(name = "ESTADO")
    private byte[] estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "respuestaEncuesta")
    private Collection<EgresadoRespuesta> egresadoRespuestaCollection;
    @JoinColumn(name = "ID_PREGUNTA_ENCUESTA", referencedColumnName = "ID_PREGUNTA_ENCUESTA")
    @ManyToOne(optional = false)
    private PreguntaEncuesta idPreguntaEncuesta;

    public RespuestaEncuesta() {
    }

    public RespuestaEncuesta(Integer idRespuestaEncuesta) {
        this.idRespuestaEncuesta = idRespuestaEncuesta;
    }

    public RespuestaEncuesta(Integer idRespuestaEncuesta, String respuesta, byte[] estado) {
        this.idRespuestaEncuesta = idRespuestaEncuesta;
        this.respuesta = respuesta;
        this.estado = estado;
    }

    public Integer getIdRespuestaEncuesta() {
        return idRespuestaEncuesta;
    }

    public void setIdRespuestaEncuesta(Integer idRespuestaEncuesta) {
        this.idRespuestaEncuesta = idRespuestaEncuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public byte[] getEstado() {
        return estado;
    }

    public void setEstado(byte[] estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<EgresadoRespuesta> getEgresadoRespuestaCollection() {
        return egresadoRespuestaCollection;
    }

    public void setEgresadoRespuestaCollection(Collection<EgresadoRespuesta> egresadoRespuestaCollection) {
        this.egresadoRespuestaCollection = egresadoRespuestaCollection;
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
        hash += (idRespuestaEncuesta != null ? idRespuestaEncuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RespuestaEncuesta)) {
            return false;
        }
        RespuestaEncuesta other = (RespuestaEncuesta) object;
        if ((this.idRespuestaEncuesta == null && other.idRespuestaEncuesta != null) || (this.idRespuestaEncuesta != null && !this.idRespuestaEncuesta.equals(other.idRespuestaEncuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.RespuestaEncuesta[ idRespuestaEncuesta=" + idRespuestaEncuesta + " ]";
    }
    
}
