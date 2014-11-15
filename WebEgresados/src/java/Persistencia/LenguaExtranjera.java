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
@Table(name = "lengua_extranjera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LenguaExtranjera.findAll", query = "SELECT l FROM LenguaExtranjera l"),
    @NamedQuery(name = "LenguaExtranjera.findByIdLenguaExtranjera", query = "SELECT l FROM LenguaExtranjera l WHERE l.idLenguaExtranjera = :idLenguaExtranjera"),
    @NamedQuery(name = "LenguaExtranjera.findByFechaRegistro", query = "SELECT l FROM LenguaExtranjera l WHERE l.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "LenguaExtranjera.findByEstado", query = "SELECT l FROM LenguaExtranjera l WHERE l.estado = :estado")})
public class LenguaExtranjera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_LENGUA_EXTRANJERA")
    private Long idLenguaExtranjera;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @JoinColumn(name = "ID_DOMINIO", referencedColumnName = "ID_DOMINIO_LENGUA_EXT")
    @ManyToOne(optional = false)
    private DominioLenguaExt idDominio;
    @JoinColumn(name = "ID_IDIOMA", referencedColumnName = "ID_IDIOMA")
    @ManyToOne(optional = false)
    private Idioma idIdioma;
    @JoinColumn(name = "ID_EGRESADO", referencedColumnName = "ID_EGRESADO")
    @ManyToOne(optional = false)
    private Egresado idEgresado;

    public LenguaExtranjera() {
    }

    public LenguaExtranjera(Long idLenguaExtranjera) {
        this.idLenguaExtranjera = idLenguaExtranjera;
    }

    public LenguaExtranjera(Long idLenguaExtranjera, Date fechaRegistro, boolean estado) {
        this.idLenguaExtranjera = idLenguaExtranjera;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    public Long getIdLenguaExtranjera() {
        return idLenguaExtranjera;
    }

    public void setIdLenguaExtranjera(Long idLenguaExtranjera) {
        this.idLenguaExtranjera = idLenguaExtranjera;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public DominioLenguaExt getIdDominio() {
        return idDominio;
    }

    public void setIdDominio(DominioLenguaExt idDominio) {
        this.idDominio = idDominio;
    }

    public Idioma getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Idioma idIdioma) {
        this.idIdioma = idIdioma;
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
        hash += (idLenguaExtranjera != null ? idLenguaExtranjera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LenguaExtranjera)) {
            return false;
        }
        LenguaExtranjera other = (LenguaExtranjera) object;
        if ((this.idLenguaExtranjera == null && other.idLenguaExtranjera != null) || (this.idLenguaExtranjera != null && !this.idLenguaExtranjera.equals(other.idLenguaExtranjera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.LenguaExtranjera[ idLenguaExtranjera=" + idLenguaExtranjera + " ]";
    }
    
}
