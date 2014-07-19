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
@Table(name = "respuesta_seguridad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RespuestaSeguridad.findAll", query = "SELECT r FROM RespuestaSeguridad r"),
    @NamedQuery(name = "RespuestaSeguridad.findByIdRespuestaSeguridad", query = "SELECT r FROM RespuestaSeguridad r WHERE r.idRespuestaSeguridad = :idRespuestaSeguridad"),
    @NamedQuery(name = "RespuestaSeguridad.findByRespuesta", query = "SELECT r FROM RespuestaSeguridad r WHERE r.respuesta = :respuesta")})
public class RespuestaSeguridad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_RESPUESTA_SEGURIDAD")
    private Integer idRespuestaSeguridad;
    @Basic(optional = false)
    @Column(name = "RESPUESTA")
    private String respuesta;
    @JoinColumn(name = "ID_PREGUNTA_SEGURIDAD", referencedColumnName = "ID_PREGUNTA_SEGURIDAD")
    @ManyToOne(optional = false)
    private PreguntaSeguridad idPreguntaSeguridad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRespuestaSeguridad")
    private Collection<Usuario> usuarioCollection;

    public RespuestaSeguridad() {
    }

    public RespuestaSeguridad(Integer idRespuestaSeguridad) {
        this.idRespuestaSeguridad = idRespuestaSeguridad;
    }

    public RespuestaSeguridad(Integer idRespuestaSeguridad, String respuesta) {
        this.idRespuestaSeguridad = idRespuestaSeguridad;
        this.respuesta = respuesta;
    }

    public Integer getIdRespuestaSeguridad() {
        return idRespuestaSeguridad;
    }

    public void setIdRespuestaSeguridad(Integer idRespuestaSeguridad) {
        this.idRespuestaSeguridad = idRespuestaSeguridad;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public PreguntaSeguridad getIdPreguntaSeguridad() {
        return idPreguntaSeguridad;
    }

    public void setIdPreguntaSeguridad(PreguntaSeguridad idPreguntaSeguridad) {
        this.idPreguntaSeguridad = idPreguntaSeguridad;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRespuestaSeguridad != null ? idRespuestaSeguridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RespuestaSeguridad)) {
            return false;
        }
        RespuestaSeguridad other = (RespuestaSeguridad) object;
        if ((this.idRespuestaSeguridad == null && other.idRespuestaSeguridad != null) || (this.idRespuestaSeguridad != null && !this.idRespuestaSeguridad.equals(other.idRespuestaSeguridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.RespuestaSeguridad[ idRespuestaSeguridad=" + idRespuestaSeguridad + " ]";
    }
    
}
