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
@Table(name = "seccion_encuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeccionEncuesta.findAll", query = "SELECT s FROM SeccionEncuesta s"),
    @NamedQuery(name = "SeccionEncuesta.findByIdSeccionEncuesta", query = "SELECT s FROM SeccionEncuesta s WHERE s.idSeccionEncuesta = :idSeccionEncuesta"),
    @NamedQuery(name = "SeccionEncuesta.findByNombre", query = "SELECT s FROM SeccionEncuesta s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SeccionEncuesta.findByOrden", query = "SELECT s FROM SeccionEncuesta s WHERE s.orden = :orden")})
public class SeccionEncuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SECCION_ENCUESTA")
    private Long idSeccionEncuesta;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ORDEN")
    private int orden;
    @JoinColumn(name = "ID_ENCUESTA", referencedColumnName = "ID_ENCUESTA")
    @ManyToOne(optional = false)
    private Encuesta idEncuesta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSeccionEncuesta")
    private Collection<PreguntaEncuesta> preguntaEncuestaCollection;

    public SeccionEncuesta() {
    }

    public SeccionEncuesta(Long idSeccionEncuesta) {
        this.idSeccionEncuesta = idSeccionEncuesta;
    }

    public SeccionEncuesta(Long idSeccionEncuesta, String nombre, int orden) {
        this.idSeccionEncuesta = idSeccionEncuesta;
        this.nombre = nombre;
        this.orden = orden;
    }

    public Long getIdSeccionEncuesta() {
        return idSeccionEncuesta;
    }

    public void setIdSeccionEncuesta(Long idSeccionEncuesta) {
        this.idSeccionEncuesta = idSeccionEncuesta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public Encuesta getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(Encuesta idEncuesta) {
        this.idEncuesta = idEncuesta;
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
        hash += (idSeccionEncuesta != null ? idSeccionEncuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeccionEncuesta)) {
            return false;
        }
        SeccionEncuesta other = (SeccionEncuesta) object;
        if ((this.idSeccionEncuesta == null && other.idSeccionEncuesta != null) || (this.idSeccionEncuesta != null && !this.idSeccionEncuesta.equals(other.idSeccionEncuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.SeccionEncuesta[ idSeccionEncuesta=" + idSeccionEncuesta + " ]";
    }
    
}
