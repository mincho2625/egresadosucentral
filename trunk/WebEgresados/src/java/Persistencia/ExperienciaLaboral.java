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
@Table(name = "experiencia_laboral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExperienciaLaboral.findAll", query = "SELECT e FROM ExperienciaLaboral e"),
    @NamedQuery(name = "ExperienciaLaboral.findByIdExperienciaLaboral", query = "SELECT e FROM ExperienciaLaboral e WHERE e.idExperienciaLaboral = :idExperienciaLaboral"),
    @NamedQuery(name = "ExperienciaLaboral.findByNombreEmpresa", query = "SELECT e FROM ExperienciaLaboral e WHERE e.nombreEmpresa = :nombreEmpresa"),
    @NamedQuery(name = "ExperienciaLaboral.findByCargo", query = "SELECT e FROM ExperienciaLaboral e WHERE e.cargo = :cargo"),
    @NamedQuery(name = "ExperienciaLaboral.findByConexionInternet", query = "SELECT e FROM ExperienciaLaboral e WHERE e.conexionInternet = :conexionInternet"),
    @NamedQuery(name = "ExperienciaLaboral.findByFechaRegistro", query = "SELECT e FROM ExperienciaLaboral e WHERE e.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "ExperienciaLaboral.findByFuncionesLogros", query = "SELECT e FROM ExperienciaLaboral e WHERE e.funcionesLogros = :funcionesLogros"),
    @NamedQuery(name = "ExperienciaLaboral.findByTelefonoEmpresa", query = "SELECT e FROM ExperienciaLaboral e WHERE e.telefonoEmpresa = :telefonoEmpresa"),
    @NamedQuery(name = "ExperienciaLaboral.findByJefeInmediato", query = "SELECT e FROM ExperienciaLaboral e WHERE e.jefeInmediato = :jefeInmediato"),
    @NamedQuery(name = "ExperienciaLaboral.findByAnioIngreso", query = "SELECT e FROM ExperienciaLaboral e WHERE e.anioIngreso = :anioIngreso"),
    @NamedQuery(name = "ExperienciaLaboral.findByAnioFinalizacion", query = "SELECT e FROM ExperienciaLaboral e WHERE e.anioFinalizacion = :anioFinalizacion"),
    @NamedQuery(name = "ExperienciaLaboral.findByEstado", query = "SELECT e FROM ExperienciaLaboral e WHERE e.estado = :estado")})
public class ExperienciaLaboral implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EXPERIENCIA_LABORAL")
    private Long idExperienciaLaboral;
    @Basic(optional = false)
    @Column(name = "NOMBRE_EMPRESA")
    private String nombreEmpresa;
    @Basic(optional = false)
    @Column(name = "CARGO")
    private String cargo;
    @Basic(optional = false)
    @Column(name = "CONEXION_INTERNET")
    private boolean conexionInternet;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "FUNCIONES_LOGROS")
    private String funcionesLogros;
    @Column(name = "TELEFONO_EMPRESA")
    private String telefonoEmpresa;
    @Column(name = "JEFE_INMEDIATO")
    private String jefeInmediato;
    @Basic(optional = false)
    @Column(name = "ANIO_INGRESO")
    private int anioIngreso;
    @Column(name = "ANIO_FINALIZACION")
    private Integer anioFinalizacion;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @JoinColumn(name = "ID_TIPO_CONTRATO", referencedColumnName = "ID_TIPO_CONTRATO")
    @ManyToOne(optional = false)
    private TipoContrato idTipoContrato;
    @JoinColumn(name = "ID_SUBSECTOR", referencedColumnName = "ID_SUBSECTOR")
    @ManyToOne(optional = false)
    private Subsector idSubsector;
    @JoinColumn(name = "ID_NIVEL_CARGO", referencedColumnName = "ID_NIVEL_CARGO")
    @ManyToOne(optional = false)
    private NivelCargo idNivelCargo;
    @JoinColumn(name = "ID_AREA_EMPRESA", referencedColumnName = "ID_AREA_EMPRESA")
    @ManyToOne(optional = false)
    private AreaEmpresa idAreaEmpresa;
    @JoinColumn(name = "ID_RANGO_SALARIAL", referencedColumnName = "ID_RANGO_SALARIAL")
    @ManyToOne(optional = false)
    private RangoSalarial idRangoSalarial;
    @JoinColumn(name = "ID_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad idCiudad;
    @JoinColumn(name = "ID_CARGO_EQUIVALENTE", referencedColumnName = "ID_CARGO_EQUIVALENTE")
    @ManyToOne(optional = false)
    private CargoEquivalente idCargoEquivalente;
    @JoinColumn(name = "ID_MES_INGRESO", referencedColumnName = "ID_MES")
    @ManyToOne(optional = false)
    private Mes idMesIngreso;
    @JoinColumn(name = "ID_MES_FINALIZACION", referencedColumnName = "ID_MES")
    @ManyToOne
    private Mes idMesFinalizacion;
    @JoinColumn(name = "ID_EGRESADO", referencedColumnName = "ID_EGRESADO")
    @ManyToOne(optional = false)
    private Egresado idEgresado;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(Long idExperienciaLaboral) {
        this.idExperienciaLaboral = idExperienciaLaboral;
    }

    public ExperienciaLaboral(Long idExperienciaLaboral, String nombreEmpresa, String cargo, boolean conexionInternet, Date fechaRegistro, String funcionesLogros, int anioIngreso, boolean estado) {
        this.idExperienciaLaboral = idExperienciaLaboral;
        this.nombreEmpresa = nombreEmpresa;
        this.cargo = cargo;
        this.conexionInternet = conexionInternet;
        this.fechaRegistro = fechaRegistro;
        this.funcionesLogros = funcionesLogros;
        this.anioIngreso = anioIngreso;
        this.estado = estado;
    }

    public Long getIdExperienciaLaboral() {
        return idExperienciaLaboral;
    }

    public void setIdExperienciaLaboral(Long idExperienciaLaboral) {
        this.idExperienciaLaboral = idExperienciaLaboral;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    public String getFuncionesLogros() {
        return funcionesLogros;
    }

    public void setFuncionesLogros(String funcionesLogros) {
        this.funcionesLogros = funcionesLogros;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getJefeInmediato() {
        return jefeInmediato;
    }

    public void setJefeInmediato(String jefeInmediato) {
        this.jefeInmediato = jefeInmediato;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    public Integer getAnioFinalizacion() {
        return anioFinalizacion;
    }

    public void setAnioFinalizacion(Integer anioFinalizacion) {
        this.anioFinalizacion = anioFinalizacion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public TipoContrato getIdTipoContrato() {
        return idTipoContrato;
    }

    public void setIdTipoContrato(TipoContrato idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public Subsector getIdSubsector() {
        return idSubsector;
    }

    public void setIdSubsector(Subsector idSubsector) {
        this.idSubsector = idSubsector;
    }

    public NivelCargo getIdNivelCargo() {
        return idNivelCargo;
    }

    public void setIdNivelCargo(NivelCargo idNivelCargo) {
        this.idNivelCargo = idNivelCargo;
    }

    public AreaEmpresa getIdAreaEmpresa() {
        return idAreaEmpresa;
    }

    public void setIdAreaEmpresa(AreaEmpresa idAreaEmpresa) {
        this.idAreaEmpresa = idAreaEmpresa;
    }

    public RangoSalarial getIdRangoSalarial() {
        return idRangoSalarial;
    }

    public void setIdRangoSalarial(RangoSalarial idRangoSalarial) {
        this.idRangoSalarial = idRangoSalarial;
    }

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    public CargoEquivalente getIdCargoEquivalente() {
        return idCargoEquivalente;
    }

    public void setIdCargoEquivalente(CargoEquivalente idCargoEquivalente) {
        this.idCargoEquivalente = idCargoEquivalente;
    }

    public Mes getIdMesIngreso() {
        return idMesIngreso;
    }

    public void setIdMesIngreso(Mes idMesIngreso) {
        this.idMesIngreso = idMesIngreso;
    }

    public Mes getIdMesFinalizacion() {
        return idMesFinalizacion;
    }

    public void setIdMesFinalizacion(Mes idMesFinalizacion) {
        this.idMesFinalizacion = idMesFinalizacion;
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
        hash += (idExperienciaLaboral != null ? idExperienciaLaboral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExperienciaLaboral)) {
            return false;
        }
        ExperienciaLaboral other = (ExperienciaLaboral) object;
        if ((this.idExperienciaLaboral == null && other.idExperienciaLaboral != null) || (this.idExperienciaLaboral != null && !this.idExperienciaLaboral.equals(other.idExperienciaLaboral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.ExperienciaLaboral[ idExperienciaLaboral=" + idExperienciaLaboral + " ]";
    }
    
}
