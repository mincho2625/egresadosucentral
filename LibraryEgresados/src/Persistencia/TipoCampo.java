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
@Table(name = "tipo_campo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCampo.findAll", query = "SELECT t FROM TipoCampo t"),
    @NamedQuery(name = "TipoCampo.findByIdTipoCampo", query = "SELECT t FROM TipoCampo t WHERE t.idTipoCampo = :idTipoCampo"),
    @NamedQuery(name = "TipoCampo.findByNombre", query = "SELECT t FROM TipoCampo t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoCampo.findByEstado", query = "SELECT t FROM TipoCampo t WHERE t.estado = :estado")})
public class TipoCampo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPO_CAMPO")
    private Long idTipoCampo;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoCampo")
    private Collection<TipoContacto> tipoContactoCollection;

    public TipoCampo() {
    }

    public TipoCampo(Long idTipoCampo) {
        this.idTipoCampo = idTipoCampo;
    }

    public TipoCampo(Long idTipoCampo, String nombre, boolean estado) {
        this.idTipoCampo = idTipoCampo;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getIdTipoCampo() {
        return idTipoCampo;
    }

    public void setIdTipoCampo(Long idTipoCampo) {
        this.idTipoCampo = idTipoCampo;
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
    public Collection<TipoContacto> getTipoContactoCollection() {
        return tipoContactoCollection;
    }

    public void setTipoContactoCollection(Collection<TipoContacto> tipoContactoCollection) {
        this.tipoContactoCollection = tipoContactoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCampo != null ? idTipoCampo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCampo)) {
            return false;
        }
        TipoCampo other = (TipoCampo) object;
        return !((this.idTipoCampo == null && other.idTipoCampo != null) || (this.idTipoCampo != null && !this.idTipoCampo.equals(other.idTipoCampo)));
    }

    @Override
    public String toString() {
        return "Persistencia.TipoCampo[ idTipoCampo=" + idTipoCampo + " ]";
    }
}