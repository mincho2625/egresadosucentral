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
@Table(name = "tipo_respuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRespuesta.findAll", query = "SELECT t FROM TipoRespuesta t"),
    @NamedQuery(name = "TipoRespuesta.findByIdTipoRespuesta", query = "SELECT t FROM TipoRespuesta t WHERE t.idTipoRespuesta = :idTipoRespuesta"),
    @NamedQuery(name = "TipoRespuesta.findByNombre", query = "SELECT t FROM TipoRespuesta t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoRespuesta.findByEstado", query = "SELECT t FROM TipoRespuesta t WHERE t.estado = :estado")})
public class TipoRespuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPO_RESPUESTA")
    private Long idTipoRespuesta;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoRespuesta")
    private Collection<PreguntaEncuesta> preguntaEncuestaCollection;

    public TipoRespuesta() {
    }

    public TipoRespuesta(Long idTipoRespuesta) {
        this.idTipoRespuesta = idTipoRespuesta;
    }

    public TipoRespuesta(Long idTipoRespuesta, String nombre, boolean estado) {
        this.idTipoRespuesta = idTipoRespuesta;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getIdTipoRespuesta() {
        return idTipoRespuesta;
    }

    public void setIdTipoRespuesta(Long idTipoRespuesta) {
        this.idTipoRespuesta = idTipoRespuesta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<PreguntaEncuesta> getPreguntaEncuestaCollection() {
        return preguntaEncuestaCollection;
    }

    public void setPreguntaEncuestaCollection(Collection<PreguntaEncuesta> preguntaEncuestaCollection) {
        this.preguntaEncuestaCollection = preguntaEncuestaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoRespuesta != null ? idTipoRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRespuesta)) {
            return false;
        }
        TipoRespuesta other = (TipoRespuesta) object;
        return !((this.idTipoRespuesta == null && other.idTipoRespuesta != null) || (this.idTipoRespuesta != null && !this.idTipoRespuesta.equals(other.idTipoRespuesta)));
    }

    @Override
    public String toString() {
        return "Persistencia.TipoRespuesta[ idTipoRespuesta=" + idTipoRespuesta + " ]";
    }
}