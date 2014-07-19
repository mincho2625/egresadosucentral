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
@Table(name = "pregunta_encuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreguntaEncuesta.findAll", query = "SELECT p FROM PreguntaEncuesta p"),
    @NamedQuery(name = "PreguntaEncuesta.findByIdPreguntaEncuesta", query = "SELECT p FROM PreguntaEncuesta p WHERE p.idPreguntaEncuesta = :idPreguntaEncuesta"),
    @NamedQuery(name = "PreguntaEncuesta.findByPregunta", query = "SELECT p FROM PreguntaEncuesta p WHERE p.pregunta = :pregunta")})
public class PreguntaEncuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PREGUNTA_ENCUESTA")
    private Integer idPreguntaEncuesta;
    @Basic(optional = false)
    @Column(name = "PREGUNTA")
    private String pregunta;
    @Basic(optional = false)
    @Lob
    @Column(name = "ESTADO")
    private byte[] estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPreguntaEncuesta")
    private Collection<RespuestaEncuesta> respuestaEncuestaCollection;
    @JoinColumn(name = "ID_ENCUESTA", referencedColumnName = "ID_ENCUESTA")
    @ManyToOne(optional = false)
    private Encuesta idEncuesta;
    @JoinColumn(name = "ID_TIPO_RESPUESTA", referencedColumnName = "ID_TIPO_RESPUESTA")
    @ManyToOne(optional = false)
    private TipoRespuesta idTipoRespuesta;

    public PreguntaEncuesta() {
    }

    public PreguntaEncuesta(Integer idPreguntaEncuesta) {
        this.idPreguntaEncuesta = idPreguntaEncuesta;
    }

    public PreguntaEncuesta(Integer idPreguntaEncuesta, String pregunta, byte[] estado) {
        this.idPreguntaEncuesta = idPreguntaEncuesta;
        this.pregunta = pregunta;
        this.estado = estado;
    }

    public Integer getIdPreguntaEncuesta() {
        return idPreguntaEncuesta;
    }

    public void setIdPreguntaEncuesta(Integer idPreguntaEncuesta) {
        this.idPreguntaEncuesta = idPreguntaEncuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public byte[] getEstado() {
        return estado;
    }

    public void setEstado(byte[] estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<RespuestaEncuesta> getRespuestaEncuestaCollection() {
        return respuestaEncuestaCollection;
    }

    public void setRespuestaEncuestaCollection(Collection<RespuestaEncuesta> respuestaEncuestaCollection) {
        this.respuestaEncuestaCollection = respuestaEncuestaCollection;
    }

    public Encuesta getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(Encuesta idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public TipoRespuesta getIdTipoRespuesta() {
        return idTipoRespuesta;
    }

    public void setIdTipoRespuesta(TipoRespuesta idTipoRespuesta) {
        this.idTipoRespuesta = idTipoRespuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPreguntaEncuesta != null ? idPreguntaEncuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreguntaEncuesta)) {
            return false;
        }
        PreguntaEncuesta other = (PreguntaEncuesta) object;
        if ((this.idPreguntaEncuesta == null && other.idPreguntaEncuesta != null) || (this.idPreguntaEncuesta != null && !this.idPreguntaEncuesta.equals(other.idPreguntaEncuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.PreguntaEncuesta[ idPreguntaEncuesta=" + idPreguntaEncuesta + " ]";
    }
    
}
