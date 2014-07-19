/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YURY
 */
@Entity
@Table(name = "egresado_red_social")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EgresadoRedSocial.findAll", query = "SELECT e FROM EgresadoRedSocial e"),
    @NamedQuery(name = "EgresadoRedSocial.findByIdEgresadoRedSocial", query = "SELECT e FROM EgresadoRedSocial e WHERE e.idEgresadoRedSocial = :idEgresadoRedSocial"),
    @NamedQuery(name = "EgresadoRedSocial.findByUrl", query = "SELECT e FROM EgresadoRedSocial e WHERE e.url = :url"),
    @NamedQuery(name = "EgresadoRedSocial.findByFechaRegistro", query = "SELECT e FROM EgresadoRedSocial e WHERE e.fechaRegistro = :fechaRegistro")})
public class EgresadoRedSocial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EGRESADO_RED_SOCIAL")
    private Integer idEgresadoRedSocial;
    @Basic(optional = false)
    @Lob
    @Column(name = "ESTADO")
    private byte[] estado;
    @Basic(optional = false)
    @Column(name = "URL")
    private String url;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @JoinColumn(name = "ID_RED_SOCIAL", referencedColumnName = "ID_RED_SOCIAL")
    @ManyToOne(optional = false)
    private RedSocial idRedSocial;
    @JoinColumn(name = "ID_EGRESADO", referencedColumnName = "ID_EGRESADO")
    @ManyToOne(optional = false)
    private Egresado idEgresado;

    public EgresadoRedSocial() {
    }

    public EgresadoRedSocial(Integer idEgresadoRedSocial) {
        this.idEgresadoRedSocial = idEgresadoRedSocial;
    }

    public EgresadoRedSocial(Integer idEgresadoRedSocial, byte[] estado, String url, Date fechaRegistro) {
        this.idEgresadoRedSocial = idEgresadoRedSocial;
        this.estado = estado;
        this.url = url;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdEgresadoRedSocial() {
        return idEgresadoRedSocial;
    }

    public void setIdEgresadoRedSocial(Integer idEgresadoRedSocial) {
        this.idEgresadoRedSocial = idEgresadoRedSocial;
    }

    public byte[] getEstado() {
        return estado;
    }

    public void setEstado(byte[] estado) {
        this.estado = estado;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public RedSocial getIdRedSocial() {
        return idRedSocial;
    }

    public void setIdRedSocial(RedSocial idRedSocial) {
        this.idRedSocial = idRedSocial;
    }

    public Egresado getIdEgresado() {
        return idEgresado;
    }

    public void setIdEgresado(Egresado idEgresado) {
        this.idEgresado = idEgresado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEgresadoRedSocial != null ? idEgresadoRedSocial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EgresadoRedSocial)) {
            return false;
        }
        EgresadoRedSocial other = (EgresadoRedSocial) object;
        if ((this.idEgresadoRedSocial == null && other.idEgresadoRedSocial != null) || (this.idEgresadoRedSocial != null && !this.idEgresadoRedSocial.equals(other.idEgresadoRedSocial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.EgresadoRedSocial[ idEgresadoRedSocial=" + idEgresadoRedSocial + " ]";
    }
    
}
