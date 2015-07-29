/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

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
    @NamedQuery(name = "PreguntaSeguridad.findByPregunta", query = "SELECT p FROM PreguntaSeguridad p WHERE p.pregunta = :pregunta"),
    @NamedQuery(name = "PreguntaSeguridad.findByEstado", query = "SELECT p FROM PreguntaSeguridad p WHERE p.estado = :estado")})
public class PreguntaSeguridad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PREGUNTA_SEGURIDAD")
    private Long idPreguntaSeguridad;
    @Basic(optional = false)
    @Column(name = "PREGUNTA")
    private String pregunta;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;

    public PreguntaSeguridad() {
    }

    public PreguntaSeguridad(Long idPreguntaSeguridad) {
        this.idPreguntaSeguridad = idPreguntaSeguridad;
    }

    public PreguntaSeguridad(Long idPreguntaSeguridad, String pregunta, boolean estado) {
        this.idPreguntaSeguridad = idPreguntaSeguridad;
        this.pregunta = pregunta;
        this.estado = estado;
    }

    public Long getIdPreguntaSeguridad() {
        return idPreguntaSeguridad;
    }

    public void setIdPreguntaSeguridad(Long idPreguntaSeguridad) {
        this.idPreguntaSeguridad = idPreguntaSeguridad;
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
        return (this.idPreguntaSeguridad != null || other.idPreguntaSeguridad == null) && (this.idPreguntaSeguridad == null || this.idPreguntaSeguridad.equals(other.idPreguntaSeguridad));
    }

    @Override
    public String toString() {
        return "Persistencia.PreguntaSeguridad[ idPreguntaSeguridad=" + idPreguntaSeguridad + " ]";
    }
    
}
