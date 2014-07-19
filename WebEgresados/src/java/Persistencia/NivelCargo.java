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
@Table(name = "nivel_cargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelCargo.findAll", query = "SELECT n FROM NivelCargo n"),
    @NamedQuery(name = "NivelCargo.findByIdNivelCargo", query = "SELECT n FROM NivelCargo n WHERE n.idNivelCargo = :idNivelCargo"),
    @NamedQuery(name = "NivelCargo.findByNombre", query = "SELECT n FROM NivelCargo n WHERE n.nombre = :nombre")})
public class NivelCargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_NIVEL_CARGO")
    private Integer idNivelCargo;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Lob
    @Column(name = "ESTADO")
    private byte[] estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivelCargo")
    private Collection<ExperienciaLaboral> experienciaLaboralCollection;

    public NivelCargo() {
    }

    public NivelCargo(Integer idNivelCargo) {
        this.idNivelCargo = idNivelCargo;
    }

    public NivelCargo(Integer idNivelCargo, String nombre, byte[] estado) {
        this.idNivelCargo = idNivelCargo;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdNivelCargo() {
        return idNivelCargo;
    }

    public void setIdNivelCargo(Integer idNivelCargo) {
        this.idNivelCargo = idNivelCargo;
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
    public Collection<ExperienciaLaboral> getExperienciaLaboralCollection() {
        return experienciaLaboralCollection;
    }

    public void setExperienciaLaboralCollection(Collection<ExperienciaLaboral> experienciaLaboralCollection) {
        this.experienciaLaboralCollection = experienciaLaboralCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivelCargo != null ? idNivelCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelCargo)) {
            return false;
        }
        NivelCargo other = (NivelCargo) object;
        if ((this.idNivelCargo == null && other.idNivelCargo != null) || (this.idNivelCargo != null && !this.idNivelCargo.equals(other.idNivelCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.NivelCargo[ idNivelCargo=" + idNivelCargo + " ]";
    }
    
}
