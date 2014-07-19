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
@Table(name = "estrato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estrato.findAll", query = "SELECT e FROM Estrato e"),
    @NamedQuery(name = "Estrato.findByIdEstrato", query = "SELECT e FROM Estrato e WHERE e.idEstrato = :idEstrato"),
    @NamedQuery(name = "Estrato.findByEstratoNumero", query = "SELECT e FROM Estrato e WHERE e.estratoNumero = :estratoNumero"),
    @NamedQuery(name = "Estrato.findByEstratoLetras", query = "SELECT e FROM Estrato e WHERE e.estratoLetras = :estratoLetras")})
public class Estrato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTRATO")
    private Integer idEstrato;
    @Basic(optional = false)
    @Column(name = "ESTRATO_NUMERO")
    private int estratoNumero;
    @Basic(optional = false)
    @Column(name = "ESTRATO_LETRAS")
    private String estratoLetras;
    @Basic(optional = false)
    @Lob
    @Column(name = "ESTADO")
    private byte[] estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstrato")
    private Collection<Residencia> residenciaCollection;

    public Estrato() {
    }

    public Estrato(Integer idEstrato) {
        this.idEstrato = idEstrato;
    }

    public Estrato(Integer idEstrato, int estratoNumero, String estratoLetras, byte[] estado) {
        this.idEstrato = idEstrato;
        this.estratoNumero = estratoNumero;
        this.estratoLetras = estratoLetras;
        this.estado = estado;
    }

    public Integer getIdEstrato() {
        return idEstrato;
    }

    public void setIdEstrato(Integer idEstrato) {
        this.idEstrato = idEstrato;
    }

    public int getEstratoNumero() {
        return estratoNumero;
    }

    public void setEstratoNumero(int estratoNumero) {
        this.estratoNumero = estratoNumero;
    }

    public String getEstratoLetras() {
        return estratoLetras;
    }

    public void setEstratoLetras(String estratoLetras) {
        this.estratoLetras = estratoLetras;
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
        hash += (idEstrato != null ? idEstrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estrato)) {
            return false;
        }
        Estrato other = (Estrato) object;
        if ((this.idEstrato == null && other.idEstrato != null) || (this.idEstrato != null && !this.idEstrato.equals(other.idEstrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Estrato[ idEstrato=" + idEstrato + " ]";
    }
    
}
