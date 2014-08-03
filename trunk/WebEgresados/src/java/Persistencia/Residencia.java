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
@Table(name = "residencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Residencia.findAll", query = "SELECT r FROM Residencia r"),
    @NamedQuery(name = "Residencia.findByIdResidencia", query = "SELECT r FROM Residencia r WHERE r.idResidencia = :idResidencia"),
    @NamedQuery(name = "Residencia.findByDireccion", query = "SELECT r FROM Residencia r WHERE r.direccion = :direccion"),
    @NamedQuery(name = "Residencia.findByComputador", query = "SELECT r FROM Residencia r WHERE r.computador = :computador"),
    @NamedQuery(name = "Residencia.findByConexionInternet", query = "SELECT r FROM Residencia r WHERE r.conexionInternet = :conexionInternet"),
    @NamedQuery(name = "Residencia.findByFechaRegistro", query = "SELECT r FROM Residencia r WHERE r.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Residencia.findByEstado", query = "SELECT r FROM Residencia r WHERE r.estado = :estado")})
public class Residencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_RESIDENCIA")
    private Long idResidencia;
    @Basic(optional = false)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "COMPUTADOR")
    private boolean computador;
    @Basic(optional = false)
    @Column(name = "CONEXION_INTERNET")
    private boolean conexionInternet;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @JoinColumn(name = "ID_CIUDAD_RESIDENCIA", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad idCiudadResidencia;
    @JoinColumn(name = "ID_TIPO_VIVIENDA", referencedColumnName = "ID_TIPO_VIVIENDA")
    @ManyToOne(optional = false)
    private TipoVivienda idTipoVivienda;
    @JoinColumn(name = "ID_TIPO_TENENCIA_VIVIENDA", referencedColumnName = "ID_TIPO_TENENCIA_VIVIENDA")
    @ManyToOne(optional = false)
    private TipoTenenciaVivienda idTipoTenenciaVivienda;
    @JoinColumn(name = "ID_ESTRATO", referencedColumnName = "ID_ESTRATO")
    @ManyToOne(optional = false)
    private Estrato idEstrato;
    @JoinColumn(name = "ID_EGRESADO", referencedColumnName = "ID_EGRESADO")
    @ManyToOne(optional = false)
    private Egresado idEgresado;

    public Residencia() {
    }

    public Residencia(Long idResidencia) {
        this.idResidencia = idResidencia;
    }

    public Residencia(Long idResidencia, String direccion, boolean computador, boolean conexionInternet, Date fechaRegistro, boolean estado) {
        this.idResidencia = idResidencia;
        this.direccion = direccion;
        this.computador = computador;
        this.conexionInternet = conexionInternet;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    public Long getIdResidencia() {
        return idResidencia;
    }

    public void setIdResidencia(Long idResidencia) {
        this.idResidencia = idResidencia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean getComputador() {
        return computador;
    }

    public void setComputador(boolean computador) {
        this.computador = computador;
    }

    public boolean getConexionInternet() {
        return conexionInternet;
    }

    public void setConexionInternet(boolean conexionInternet) {
        this.conexionInternet = conexionInternet;
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

    public Ciudad getIdCiudadResidencia() {
        return idCiudadResidencia;
    }

    public void setIdCiudadResidencia(Ciudad idCiudadResidencia) {
        this.idCiudadResidencia = idCiudadResidencia;
    }

    public TipoVivienda getIdTipoVivienda() {
        return idTipoVivienda;
    }

    public void setIdTipoVivienda(TipoVivienda idTipoVivienda) {
        this.idTipoVivienda = idTipoVivienda;
    }

    public TipoTenenciaVivienda getIdTipoTenenciaVivienda() {
        return idTipoTenenciaVivienda;
    }

    public void setIdTipoTenenciaVivienda(TipoTenenciaVivienda idTipoTenenciaVivienda) {
        this.idTipoTenenciaVivienda = idTipoTenenciaVivienda;
    }

    public Estrato getIdEstrato() {
        return idEstrato;
    }

    public void setIdEstrato(Estrato idEstrato) {
        this.idEstrato = idEstrato;
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
        hash += (idResidencia != null ? idResidencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Residencia)) {
            return false;
        }
        Residencia other = (Residencia) object;
        if ((this.idResidencia == null && other.idResidencia != null) || (this.idResidencia != null && !this.idResidencia.equals(other.idResidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Residencia[ idResidencia=" + idResidencia + " ]";
    }
    
}
