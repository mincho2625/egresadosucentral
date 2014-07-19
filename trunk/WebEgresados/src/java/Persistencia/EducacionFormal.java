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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YURY
 */
@Entity
@Table(name = "educacion_formal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EducacionFormal.findAll", query = "SELECT e FROM EducacionFormal e"),
    @NamedQuery(name = "EducacionFormal.findByIdEducacion", query = "SELECT e FROM EducacionFormal e WHERE e.idEducacion = :idEducacion")})
public class EducacionFormal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_EDUCACION")
    private Integer idEducacion;
    @JoinColumn(name = "ID_PROGRAMA", referencedColumnName = "ID_PROGRAMA")
    @ManyToOne(optional = false)
    private Programa idPrograma;
    @JoinColumn(name = "ID_JORNADA", referencedColumnName = "ID_JORNADA")
    @ManyToOne(optional = false)
    private Jornada idJornada;
    @JoinColumn(name = "ID_NIVEL_ESTUDIOS", referencedColumnName = "ID_NIVEL_ESTUDIOS")
    @ManyToOne(optional = false)
    private NivelEstudios idNivelEstudios;
    @JoinColumn(name = "ID_EDUCACION", referencedColumnName = "ID_EDUCACION", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Educacion educacion;

    public EducacionFormal() {
    }

    public EducacionFormal(Integer idEducacion) {
        this.idEducacion = idEducacion;
    }

    public Integer getIdEducacion() {
        return idEducacion;
    }

    public void setIdEducacion(Integer idEducacion) {
        this.idEducacion = idEducacion;
    }

    public Programa getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Programa idPrograma) {
        this.idPrograma = idPrograma;
    }

    public Jornada getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(Jornada idJornada) {
        this.idJornada = idJornada;
    }

    public NivelEstudios getIdNivelEstudios() {
        return idNivelEstudios;
    }

    public void setIdNivelEstudios(NivelEstudios idNivelEstudios) {
        this.idNivelEstudios = idNivelEstudios;
    }

    public Educacion getEducacion() {
        return educacion;
    }

    public void setEducacion(Educacion educacion) {
        this.educacion = educacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEducacion != null ? idEducacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EducacionFormal)) {
            return false;
        }
        EducacionFormal other = (EducacionFormal) object;
        if ((this.idEducacion == null && other.idEducacion != null) || (this.idEducacion != null && !this.idEducacion.equals(other.idEducacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.EducacionFormal[ idEducacion=" + idEducacion + " ]";
    }
    
}
