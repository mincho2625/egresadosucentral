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
@Table(name = "pregunta_seguridad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreguntaSeguridad.findAll", query = "SELECT p FROM PreguntaSeguridad p"),
    @NamedQuery(name = "PreguntaSeguridad.findByIdPreguntaSeguridad", query = "SELECT p FROM PreguntaSeguridad p WHERE p.idPreguntaSeguridad = :idPreguntaSeguridad"),
    @NamedQuery(name = "PreguntaSeguridad.findByPregunta", query = "SELECT p FROM PreguntaSeguridad p WHERE p.pregunta = :pregunta")})
public class PreguntaSeguridad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PREGUNTA_SEGURIDAD")
    private Integer idPreguntaSeguridad;
    @Basic(optional = false)
    @Column(name = "PREGUNTA")
    private String pregunta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPreguntaSeguridad")
    private Collection<RespuestaSeguridad> respuestaSeguridadCollection;

    public PreguntaSeguridad() {
    }

    public PreguntaSeguridad(Integer idPreguntaSeguridad) {
        this.idPreguntaSeguridad = idPreguntaSeguridad;
    }

    public PreguntaSeguridad(Integer idPreguntaSeguridad, String pregunta) {
        this.idPreguntaSeguridad = idPreguntaSeguridad;
        this.pregunta = pregunta;
    }

    public Integer getIdPreguntaSeguridad() {
        return idPreguntaSeguridad;
    }

    public void setIdPreguntaSeguridad(Integer idPreguntaSeguridad) {
        this.idPreguntaSeguridad = idPreguntaSeguridad;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    @XmlTransient
    public Collection<RespuestaSeguridad> getRespuestaSeguridadCollection() {
        return respuestaSeguridadCollection;
    }

    public void setRespuestaSeguridadCollection(Collection<RespuestaSeguridad> respuestaSeguridadCollection) {
        this.respuestaSeguridadCollection = respuestaSeguridadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPreguntaSeguridad != null ? idPreguntaSeguridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreguntaSeguridad)) {
            return false;
        }
        PreguntaSeguridad other = (PreguntaSeguridad) object;
        if ((this.idPreguntaSeguridad == null && other.idPreguntaSeguridad != null) || (this.idPreguntaSeguridad != null && !this.idPreguntaSeguridad.equals(other.idPreguntaSeguridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.PreguntaSeguridad[ idPreguntaSeguridad=" + idPreguntaSeguridad + " ]";
    }
    
}
