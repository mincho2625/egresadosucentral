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
@Table(name = "tipo_vivienda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoVivienda.findAll", query = "SELECT t FROM TipoVivienda t"),
    @NamedQuery(name = "TipoVivienda.findByIdTipoVivienda", query = "SELECT t FROM TipoVivienda t WHERE t.idTipoVivienda = :idTipoVivienda"),
    @NamedQuery(name = "TipoVivienda.findByNombre", query = "SELECT t FROM TipoVivienda t WHERE t.nombre = :nombre")})
public class TipoVivienda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_VIVIENDA")
    private Integer idTipoVivienda;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Lob
    @Column(name = "ESTADO")
    private byte[] estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoVivienda")
    private Collection<Residencia> residenciaCollection;

    public TipoVivienda() {
    }

    public TipoVivienda(Integer idTipoVivienda) {
        this.idTipoVivienda = idTipoVivienda;
    }

    public TipoVivienda(Integer idTipoVivienda, String nombre, byte[] estado) {
        this.idTipoVivienda = idTipoVivienda;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdTipoVivienda() {
        return idTipoVivienda;
    }

    public void setIdTipoVivienda(Integer idTipoVivienda) {
        this.idTipoVivienda = idTipoVivienda;
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
        hash += (idTipoVivienda != null ? idTipoVivienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoVivienda)) {
            return false;
        }
        TipoVivienda other = (TipoVivienda) object;
        if ((this.idTipoVivienda == null && other.idTipoVivienda != null) || (this.idTipoVivienda != null && !this.idTipoVivienda.equals(other.idTipoVivienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.TipoVivienda[ idTipoVivienda=" + idTipoVivienda + " ]";
    }
    
}
