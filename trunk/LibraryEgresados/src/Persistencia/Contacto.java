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
@Table(name = "contacto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c"),
    @NamedQuery(name = "Contacto.findByIdContacto", query = "SELECT c FROM Contacto c WHERE c.idContacto = :idContacto"),
    @NamedQuery(name = "Contacto.findByDescripcion", query = "SELECT c FROM Contacto c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Contacto.findByFechaRegistro", query = "SELECT c FROM Contacto c WHERE c.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Contacto.findByEstado", query = "SELECT c FROM Contacto c WHERE c.estado = :estado"),
    @NamedQuery(name = "Contacto.findByIdEgresado", 
            query = "SELECT a FROM Contacto a "
                    + "inner join Egresado e on e = a.idEgresado "
                    + "inner join Usuario u on u = e.usuario "
                    + "WHERE u.idUsuario = :idEgresado and a.estado = :estado")})
public class Contacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CONTACTO")
    private Long idContacto;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @JoinColumn(name = "ID_TIPO_CONTACTO", referencedColumnName = "ID_TIPO_CONTACTO")
    @ManyToOne(optional = false)
    private TipoContacto idTipoContacto;
    @JoinColumn(name = "ID_EGRESADO", referencedColumnName = "ID_EGRESADO")
    @ManyToOne(optional = false)
    private Egresado idEgresado;

    public Contacto() {
    }

    public Contacto(Long idContacto) {
        this.idContacto = idContacto;
    }

    public Contacto(Long idContacto, String descripcion, Date fechaRegistro, boolean estado) {
        this.idContacto = idContacto;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    public Long getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Long idContacto) {
        this.idContacto = idContacto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public TipoContacto getIdTipoContacto() {
        return idTipoContacto;
    }

    public void setIdTipoContacto(TipoContacto idTipoContacto) {
        this.idTipoContacto = idTipoContacto;
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
        hash += (idContacto != null ? idContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacto)) {
            return false;
        }
        Contacto other = (Contacto) object;
        return (this.idContacto != null || other.idContacto == null) && (this.idContacto == null || this.idContacto.equals(other.idContacto));
    }

    @Override
    public String toString() {
        return "Persistencia.Contacto[ idContacto=" + idContacto + " ]";
    }
}