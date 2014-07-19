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
@Table(name = "tipo_tenencia_vivienda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTenenciaVivienda.findAll", query = "SELECT t FROM TipoTenenciaVivienda t"),
    @NamedQuery(name = "TipoTenenciaVivienda.findByIdTipoTenenciaVivienda", query = "SELECT t FROM TipoTenenciaVivienda t WHERE t.idTipoTenenciaVivienda = :idTipoTenenciaVivienda"),
    @NamedQuery(name = "TipoTenenciaVivienda.findByNombre", query = "SELECT t FROM TipoTenenciaVivienda t WHERE t.nombre = :nombre")})
public class TipoTenenciaVivienda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_TENENCIA_VIVIENDA")
    private Integer idTipoTenenciaVivienda;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Lob
    @Column(name = "ESTADO")
    private byte[] estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoTenenciaVivienda")
    private Collection<Residencia> residenciaCollection;

    public TipoTenenciaVivienda() {
    }

    public TipoTenenciaVivienda(Integer idTipoTenenciaVivienda) {
        this.idTipoTenenciaVivienda = idTipoTenenciaVivienda;
    }

    public TipoTenenciaVivienda(Integer idTipoTenenciaVivienda, String nombre, byte[] estado) {
        this.idTipoTenenciaVivienda = idTipoTenenciaVivienda;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdTipoTenenciaVivienda() {
        return idTipoTenenciaVivienda;
    }

    public void setIdTipoTenenciaVivienda(Integer idTipoTenenciaVivienda) {
        this.idTipoTenenciaVivienda = idTipoTenenciaVivienda;
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
    public Collection<Residencia> getResidenciaCollection() {
        return residenciaCollection;
    }

    public void setResidenciaCollection(Collection<Residencia> residenciaCollection) {
        this.residenciaCollection = residenciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoTenenciaVivienda != null ? idTipoTenenciaVivienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTenenciaVivienda)) {
            return false;
        }
        TipoTenenciaVivienda other = (TipoTenenciaVivienda) object;
        if ((this.idTipoTenenciaVivienda == null && other.idTipoTenenciaVivienda != null) || (this.idTipoTenenciaVivienda != null && !this.idTipoTenenciaVivienda.equals(other.idTipoTenenciaVivienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.TipoTenenciaVivienda[ idTipoTenenciaVivienda=" + idTipoTenenciaVivienda + " ]";
    }
    
}
