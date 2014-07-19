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
import javax.persistence.Lob;
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
@Table(name = "nivel_estudios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelEstudios.findAll", query = "SELECT n FROM NivelEstudios n"),
    @NamedQuery(name = "NivelEstudios.findByIdNivelEstudios", query = "SELECT n FROM NivelEstudios n WHERE n.idNivelEstudios = :idNivelEstudios"),
    @NamedQuery(name = "NivelEstudios.findByNombre", query = "SELECT n FROM NivelEstudios n WHERE n.nombre = :nombre")})
public class NivelEstudios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_NIVEL_ESTUDIOS")
    private Integer idNivelEstudios;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Lob
    @Column(name = "ESTADO")
    private byte[] estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivelEstudios")
    private Collection<EducacionFormal> educacionFormalCollection;

    public NivelEstudios() {
    }

    public NivelEstudios(Integer idNivelEstudios) {
        this.idNivelEstudios = idNivelEstudios;
    }

    public NivelEstudios(Integer idNivelEstudios, String nombre, byte[] estado) {
        this.idNivelEstudios = idNivelEstudios;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdNivelEstudios() {
        return idNivelEstudios;
    }

    public void setIdNivelEstudios(Integer idNivelEstudios) {
        this.idNivelEstudios = idNivelEstudios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getEstado() {
        return estado;
    }

    public void setEstado(byte[] estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<EducacionFormal> getEducacionFormalCollection() {
        return educacionFormalCollection;
    }

    public void setEducacionFormalCollection(Collection<EducacionFormal> educacionFormalCollection) {
        this.educacionFormalCollection = educacionFormalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivelEstudios != null ? idNivelEstudios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelEstudios)) {
            return false;
        }
        NivelEstudios other = (NivelEstudios) object;
        if ((this.idNivelEstudios == null && other.idNivelEstudios != null) || (this.idNivelEstudios != null && !this.idNivelEstudios.equals(other.idNivelEstudios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.NivelEstudios[ idNivelEstudios=" + idNivelEstudios + " ]";
    }
    
}
