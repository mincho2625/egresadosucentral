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
@Table(name = "residencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Residencia.findAll", query = "SELECT r FROM Residencia r"),
    @NamedQuery(name = "Residencia.findByIdResidencia", query = "SELECT r FROM Residencia r WHERE r.idResidencia = :idResidencia"),
    @NamedQuery(name = "Residencia.findByDireccion", query = "SELECT r FROM Residencia r WHERE r.direccion = :direccion"),
    @NamedQuery(name = "Residencia.findByFechaRegistro", query = "SELECT r FROM Residencia r WHERE r.fechaRegistro = :fechaRegistro")})
public class Residencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_RESIDENCIA")
    private Integer idResidencia;
    @Basic(optional = false)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @Lob
    @Column(name = "COMPUTADOR")
    private byte[] computador;
    @Basic(optional = false)
    @Lob
    @Column(name = "CONEXION_INTERNET")
    private byte[] conexionInternet;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Lob
    @Column(name = "ESTADO")
    private byte[] estado;
    @JoinColumn(name = "ID_EGRESADO", referencedColumnName = "ID_EGRESADO")
    @ManyToOne(optional = false)
    private Egresado idEgresado;
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

    public Residencia() {
    }

    public Residencia(Integer idResidencia) {
        this.idResidencia = idResidencia;
    }

    public Residencia(Integer idResidencia, String direccion, byte[] computador, byte[] conexionInternet, Date fechaRegistro, byte[] estado) {
        this.idResidencia = idResidencia;
        this.direccion = direccion;
        this.computador = computador;
        this.conexionInternet = conexionInternet;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    public Integer getIdResidencia() {
        return idResidencia;
    }

    public void setIdResidencia(Integer idResidencia) {
        this.idResidencia = idResidencia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public byte[] getComputador() {
        return computador;
    }

    public void setComputador(byte[] computador) {
        this.computador = computador;
    }

    public byte[] getConexionInternet() {
        return conexionInternet;
    }

    public void setConexionInternet(byte[] conexionInternet) {
        this.conexionInternet = conexionInternet;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public byte[] getEstado() {
        return estado;
    }

    public void setEstado(byte[] estado) {
        this.estado = estado;
    }

    public Egresado getIdEgresado() {
        return idEgresado;
    }

    public void setIdEgresado(Egresado idEgresado) {
        this.idEgresado = idEgresado;
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
