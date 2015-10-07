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
@Table(name = "programa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programa.findAll", query = "SELECT p FROM Programa p"),
    @NamedQuery(name = "Programa.findByIdPrograma", query = "SELECT p FROM Programa p WHERE p.idPrograma = :idPrograma"),
    @NamedQuery(name = "Programa.findByIdProgramas", query = "SELECT p FROM Programa p WHERE p.idPrograma in :idPrograma"),
    @NamedQuery(name = "Programa.findByNombre", query = "SELECT p FROM Programa p WHERE p.nombre = :nombre and p.estado = :estado"),
    @NamedQuery(name = "Programa.findByEstado", query = "SELECT p FROM Programa p WHERE p.estado = :estado"),
    @NamedQuery(name = "Programa.findByFacultadYNivelEstudios",
            query = "SELECT p FROM Programa p "
                    + "inner join Facultad f on f = p.idFacultad "
                    + "inner join NivelEstudios n on n = p.idNivelEstudios "
                    + "WHERE f.idFacultad = :idFacultad "
                    + "and n.idNivelEstudios = :idNivelEstudios "
                    + "and p.estado = :estado"),
    @NamedQuery(name = "Programa.findByListaFacultadYNivelEstudios",
            query = "SELECT p FROM Programa p "
                    + "inner join Facultad f on f = p.idFacultad "
                    + "inner join NivelEstudios n on n = p.idNivelEstudios "
                    + "WHERE f.idFacultad in :listaFacultades "
                    + "and n.idNivelEstudios in :listaNivelesEstudios "
                    + "and p.estado = :estado")})
public class Programa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PROGRAMA")
    private Long idPrograma;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @JoinColumn(name = "ID_NIVEL_ESTUDIOS", referencedColumnName = "ID_NIVEL_ESTUDIOS")
    @ManyToOne(optional = false)
    private NivelEstudios idNivelEstudios;
    @JoinColumn(name = "ID_FACULTAD", referencedColumnName = "ID_FACULTAD")
    @ManyToOne(optional = false)
    private Facultad idFacultad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrograma")
    private Collection<EducacionFormalUcentral> educacionFormalUcentralCollection;

    public Programa() {
    }

    public Programa(Long idPrograma) {
        this.idPrograma = idPrograma;
    }

    public Programa(Long idPrograma, String nombre, boolean estado) {
        this.idPrograma = idPrograma;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Long idPrograma) {
        this.idPrograma = idPrograma;
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

    public NivelEstudios getIdNivelEstudios() {
        return idNivelEstudios;
    }

    public void setIdNivelEstudios(NivelEstudios idNivelEstudios) {
        this.idNivelEstudios = idNivelEstudios;
    }

    public Facultad getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Facultad idFacultad) {
        this.idFacultad = idFacultad;
    }

    @XmlTransient
    public Collection<EducacionFormalUcentral> getEducacionFormalUcentralCollection() {
        return educacionFormalUcentralCollection;
    }

    public void setEducacionFormalUcentralCollection(Collection<EducacionFormalUcentral> educacionFormalUcentralCollection) {
        this.educacionFormalUcentralCollection = educacionFormalUcentralCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrograma != null ? idPrograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programa)) {
            return false;
        }
        Programa other = (Programa) object;
        return (this.idPrograma != null || other.idPrograma == null) && (this.idPrograma == null || this.idPrograma.equals(other.idPrograma));
    }

    @Override
    public String toString() {
        return "Persistencia.Programa[ idPrograma=" + idPrograma + " ]";
    }
}