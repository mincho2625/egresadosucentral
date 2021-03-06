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
@Table(name = "reconocimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reconocimiento.findAll", query = "SELECT r FROM Reconocimiento r"),
    @NamedQuery(name = "Reconocimiento.findByIdReconocimiento", query = "SELECT r FROM Reconocimiento r WHERE r.idReconocimiento = :idReconocimiento"),
    @NamedQuery(name = "Reconocimiento.findByEntidadOtorgante", query = "SELECT r FROM Reconocimiento r WHERE r.entidadOtorgante = :entidadOtorgante"),
    @NamedQuery(name = "Reconocimiento.findByDescripcion", query = "SELECT r FROM Reconocimiento r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Reconocimiento.findByFechaReconocimiento", query = "SELECT r FROM Reconocimiento r WHERE r.fechaReconocimiento = :fechaReconocimiento"),
    @NamedQuery(name = "Reconocimiento.findByFechaRegistro", query = "SELECT r FROM Reconocimiento r WHERE r.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Reconocimiento.findByEstado", query = "SELECT r FROM Reconocimiento r WHERE r.estado = :estado"),
    @NamedQuery(name = "Reconocimiento.findByConsulta", 
            query = "SELECT a FROM Reconocimiento a "
                    + "inner join Egresado e on e = a.idEgresado "
                    + "inner join Usuario u on u = e.usuario "
                    + "WHERE a.estado = :estado"),
    @NamedQuery(name = "Reconocimiento.findByIdEgresado", 
            query = "SELECT a FROM Reconocimiento a "
                    + "inner join Egresado e on e = a.idEgresado "
                    + "inner join Usuario u on u = e.usuario "
                    + "WHERE u.idUsuario = :idEgresado and a.estado = :estado")})
public class Reconocimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_RECONOCIMIENTO")
    private Long idReconocimiento;
    @Basic(optional = false)
    @Column(name = "ENTIDAD_OTORGANTE")
    private String entidadOtorgante;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "FECHA_RECONOCIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaReconocimiento;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @JoinColumn(name = "ID_TIPO_RECONOCIMIENTO", referencedColumnName = "ID_TIPO_RECONOCIMIENTO")
    @ManyToOne(optional = false)
    private TipoReconocimiento idTipoReconocimiento;
    @JoinColumn(name = "ID_CLASE_RECONOCIMIENTO", referencedColumnName = "ID_CLASE_RECONOCIMIENTO")
    @ManyToOne(optional = false)
    private ClaseReconocimiento idClaseReconocimiento;
    @JoinColumn(name = "ID_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad idCiudad;
    @JoinColumn(name = "ID_EGRESADO", referencedColumnName = "ID_EGRESADO")
    @ManyToOne(optional = false)
    private Egresado idEgresado;

    public Reconocimiento() {
    }

    public Reconocimiento(Long idReconocimiento) {
        this.idReconocimiento = idReconocimiento;
    }

    public Reconocimiento(Long idReconocimiento, String entidadOtorgante, Date fechaReconocimiento, Date fechaRegistro, boolean estado) {
        this.idReconocimiento = idReconocimiento;
        this.entidadOtorgante = entidadOtorgante;
        this.fechaReconocimiento = fechaReconocimiento;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    public Long getIdReconocimiento() {
        return idReconocimiento;
    }

    public void setIdReconocimiento(Long idReconocimiento) {
        this.idReconocimiento = idReconocimiento;
    }

    public String getEntidadOtorgante() {
        return entidadOtorgante;
    }

    public void setEntidadOtorgante(String entidadOtorgante) {
        this.entidadOtorgante = entidadOtorgante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaReconocimiento() {
        return fechaReconocimiento;
    }

    public void setFechaReconocimiento(Date fechaReconocimiento) {
        this.fechaReconocimiento = fechaReconocimiento;
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

    public TipoReconocimiento getIdTipoReconocimiento() {
        return idTipoReconocimiento;
    }

    public void setIdTipoReconocimiento(TipoReconocimiento idTipoReconocimiento) {
        this.idTipoReconocimiento = idTipoReconocimiento;
    }

    public ClaseReconocimiento getIdClaseReconocimiento() {
        return idClaseReconocimiento;
    }

    public void setIdClaseReconocimiento(ClaseReconocimiento idClaseReconocimiento) {
        this.idClaseReconocimiento = idClaseReconocimiento;
    }

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
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
        hash += (idReconocimiento != null ? idReconocimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reconocimiento)) {
            return false;
        }
        Reconocimiento other = (Reconocimiento) object;
        return (this.idReconocimiento != null || other.idReconocimiento == null) && (this.idReconocimiento == null || this.idReconocimiento.equals(other.idReconocimiento));
    }

    @Override
    public String toString() {
        return "Persistencia.Reconocimiento[ idReconocimiento=" + idReconocimiento + " ]";
    }
    
}
