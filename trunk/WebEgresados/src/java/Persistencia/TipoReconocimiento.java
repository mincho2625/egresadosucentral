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
@Table(name = "tipo_reconocimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoReconocimiento.findAll", query = "SELECT t FROM TipoReconocimiento t"),
    @NamedQuery(name = "TipoReconocimiento.findByIdTipoReconocimiento", query = "SELECT t FROM TipoReconocimiento t WHERE t.idTipoReconocimiento = :idTipoReconocimiento"),
    @NamedQuery(name = "TipoReconocimiento.findByNombre", query = "SELECT t FROM TipoReconocimiento t WHERE t.nombre = :nombre")})
public class TipoReconocimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_RECONOCIMIENTO")
    private Integer idTipoReconocimiento;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Lob
    @Column(name = "ESTADO")
    private byte[] estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoReconocimiento")
    private Collection<Reconocimiento> reconocimientoCollection;

    public TipoReconocimiento() {
    }

    public TipoReconocimiento(Integer idTipoReconocimiento) {
        this.idTipoReconocimiento = idTipoReconocimiento;
    }

    public TipoReconocimiento(Integer idTipoReconocimiento, String nombre, byte[] estado) {
        this.idTipoReconocimiento = idTipoReconocimiento;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdTipoReconocimiento() {
        return idTipoReconocimiento;
    }

    public void setIdTipoReconocimiento(Integer idTipoReconocimiento) {
        this.idTipoReconocimiento = idTipoReconocimiento;
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
    public Collection<Reconocimiento> getReconocimientoCollection() {
        return reconocimientoCollection;
    }

    public void setReconocimientoCollection(Collection<Reconocimiento> reconocimientoCollection) {
        this.reconocimientoCollection = reconocimientoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoReconocimiento != null ? idTipoReconocimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoReconocimiento)) {
            return false;
        }
        TipoReconocimiento other = (TipoReconocimiento) object;
        if ((this.idTipoReconocimiento == null && other.idTipoReconocimiento != null) || (this.idTipoReconocimiento != null && !this.idTipoReconocimiento.equals(other.idTipoReconocimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.TipoReconocimiento[ idTipoReconocimiento=" + idTipoReconocimiento + " ]";
    }
    
}
