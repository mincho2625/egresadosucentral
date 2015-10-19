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
@Table(name = "pregunta_encuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreguntaEncuesta.findAll", query = "SELECT p FROM PreguntaEncuesta p"),
    @NamedQuery(name = "PreguntaEncuesta.findByIdPreguntaEncuesta", query = "SELECT p FROM PreguntaEncuesta p WHERE p.idPreguntaEncuesta = :idPreguntaEncuesta"),
    @NamedQuery(name = "PreguntaEncuesta.findByPregunta", query = "SELECT p FROM PreguntaEncuesta p WHERE p.pregunta = :pregunta and p.estado = :estado"),
    @NamedQuery(name = "PreguntaEncuesta.findByEstado", query = "SELECT p FROM PreguntaEncuesta p WHERE p.estado = :estado"),
    @NamedQuery(name = "PreguntaEncuesta.findByEstadoPregunta", query = "SELECT p FROM PreguntaEncuesta p inner join TipoRespuesta e on e = e.idTipoRespuesta WHERE p.estado = :estado and e.idTipoRespuesta BETWEEN 2 AND 99"),
    @NamedQuery(name = "PreguntaEncuesta.findByObligatoria", query = "SELECT p FROM PreguntaEncuesta p WHERE p.obligatoria = :obligatoria"),
    @NamedQuery(name = "PreguntaEncuesta.findByIdEncuesta", query = "SELECT p FROM PreguntaEncuesta p WHERE p.idEncuesta = :idEncuesta"),
    @NamedQuery(name = "PreguntaEncuesta.findByOrden", query = "SELECT p FROM PreguntaEncuesta p WHERE p.orden = :orden"),
    @NamedQuery(name = "PreguntaEncuesta.findByOrdenEncuesta", query = "SELECT p FROM PreguntaEncuesta p inner join Encuesta e on e = p.idEncuesta WHERE e.orden = :orden"),
    @NamedQuery(name = "PreguntaEncuesta.findByPosicionFormato", query = "SELECT p FROM PreguntaEncuesta p WHERE p.posicionFormato is not null")})
public class PreguntaEncuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PREGUNTA_ENCUESTA")
    private Long idPreguntaEncuesta;
    @Basic(optional = false)
    @Column(name = "PREGUNTA")
    private String pregunta;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @Basic(optional = false)
    @Column(name = "OBLIGATORIA")
    private boolean obligatoria;
    @Basic(optional = false)
    @Column(name = "ORDEN")
    private int orden;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPreguntaEncuesta")
    private Collection<EgresadoRespuesta> egresadoRespuestaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPreguntaEncuesta")
    private Collection<RespuestaEncuesta> respuestaEncuestaCollection;
    @JoinColumn(name = "ID_TIPO_RESPUESTA", referencedColumnName = "ID_TIPO_RESPUESTA")
    @ManyToOne(optional = false)
    private TipoRespuesta idTipoRespuesta;
    @JoinColumn(name = "ID_ENCUESTA", referencedColumnName = "ID_ENCUESTA")
    @ManyToOne(optional = false)
    private Encuesta idEncuesta;
    @Column(name = "POSICION_FORMATO")
    private int posicionFormato;

    public PreguntaEncuesta() {
    }

    public PreguntaEncuesta(Long idPreguntaEncuesta) {
        this.idPreguntaEncuesta = idPreguntaEncuesta;
    }

    public PreguntaEncuesta(Long idPreguntaEncuesta, String pregunta, boolean estado, boolean obligatoria, int orden) {
        this.idPreguntaEncuesta = idPreguntaEncuesta;
        this.pregunta = pregunta;
        this.estado = estado;
        this.obligatoria = obligatoria;
        this.orden = orden;
    }

    public Long getIdPreguntaEncuesta() {
        return idPreguntaEncuesta;
    }

    public void setIdPreguntaEncuesta(Long idPreguntaEncuesta) {
        this.idPreguntaEncuesta = idPreguntaEncuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean getObligatoria() {
        return obligatoria;
    }

    public void setObligatoria(boolean obligatoria) {
        this.obligatoria = obligatoria;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    @XmlTransient
    public Collection<EgresadoRespuesta> getEgresadoRespuestaCollection() {
        return egresadoRespuestaCollection;
    }

    public void setEgresadoRespuestaCollection(Collection<EgresadoRespuesta> egresadoRespuestaCollection) {
        this.egresadoRespuestaCollection = egresadoRespuestaCollection;
    }

    @XmlTransient
    public Collection<RespuestaEncuesta> getRespuestaEncuestaCollection() {
        return respuestaEncuestaCollection;
    }

    public void setRespuestaEncuestaCollection(Collection<RespuestaEncuesta> respuestaEncuestaCollection) {
        this.respuestaEncuestaCollection = respuestaEncuestaCollection;
    }

    public TipoRespuesta getIdTipoRespuesta() {
        return idTipoRespuesta;
    }

    public void setIdTipoRespuesta(TipoRespuesta idTipoRespuesta) {
        this.idTipoRespuesta = idTipoRespuesta;
    }

    public Encuesta getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(Encuesta idEncuesta) {
        this.idEncuesta = idEncuesta;
    }
    
    /**
     * @return the posicionFormato
     */
    public int getPosicionFormato() {
        return posicionFormato;
    }

    /**
     * @param posicionFormato the posicionFormato to set
     */
    public void setPosicionFormato(int posicionFormato) {
        this.posicionFormato = posicionFormato;
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
        return (this.idPreguntaEncuesta != null || other.idPreguntaEncuesta == null) && (this.idPreguntaEncuesta == null || this.idPreguntaEncuesta.equals(other.idPreguntaEncuesta));
    }

    @Override
    public String toString() {
        return "Persistencia.PreguntaEncuesta[ idPreguntaEncuesta=" + idPreguntaEncuesta + " ]";
    }
}