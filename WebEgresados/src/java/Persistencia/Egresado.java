/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author YURY
 */
@Entity
@Table(name = "egresado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Egresado.findAll", query = "SELECT e FROM Egresado e"),
    @NamedQuery(name = "Egresado.findByPrimerApellido", query = "SELECT e FROM Egresado e WHERE e.primerApellido = :primerApellido"),
    @NamedQuery(name = "Egresado.findBySegundoApellido", query = "SELECT e FROM Egresado e WHERE e.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Egresado.findByNombres", query = "SELECT e FROM Egresado e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "Egresado.findByFechaNacimiento", query = "SELECT e FROM Egresado e WHERE e.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Egresado.findByNumeroDocumento", query = "SELECT e FROM Egresado e WHERE e.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "Egresado.findByFechaExpedicion", query = "SELECT e FROM Egresado e WHERE e.fechaExpedicion = :fechaExpedicion"),
    @NamedQuery(name = "Egresado.findByFechaUltimaAct", query = "SELECT e FROM Egresado e WHERE e.fechaUltimaAct = :fechaUltimaAct"),
    @NamedQuery(name = "Egresado.findByAceptaCondiciones", query = "SELECT e FROM Egresado e WHERE e.aceptaCondiciones = :aceptaCondiciones"),
    @NamedQuery(name = "Egresado.findByIdEgresado", query = "SELECT e FROM Egresado e WHERE e.idEgresado = :idEgresado"),
    @NamedQuery(name = "Egresado.findByNombreUsuario", query = "SELECT e FROM Egresado e inner join Usuario u on u = e.idUsuario WHERE u.nombre = :nombreUsuario")})
public class Egresado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Basic(optional = false)
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Basic(optional = false)
    @Column(name = "NOMBRES")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;
    @Basic(optional = false)
    @Column(name = "FECHA_EXPEDICION")
    @Temporal(TemporalType.DATE)
    private Date fechaExpedicion;
    @Lob
    @Column(name = "FOTO")
    private byte[] foto;
    @Column(name = "FECHA_ULTIMA_ACT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimaAct;
    @Basic(optional = false)
    @Column(name = "ACEPTA_CONDICIONES")
    private boolean aceptaCondiciones;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EGRESADO")
    private Long idEgresado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEgresado")
    private Collection<Asociacion> asociacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEgresado")
    private Collection<EgresadoRespuesta> egresadoRespuestaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEgresado")
    private Collection<Residencia> residenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEgresado")
    private Collection<ExperienciaLaboral> experienciaLaboralCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEgresado")
    private Collection<Reconocimiento> reconocimientoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEgresado")
    private Collection<LenguaExtranjera> lenguaExtranjeraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEgresado")
    private Collection<Contacto> contactoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEgresado")
    private Collection<EgresadoRedSocial> egresadoRedSocialCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEgresado")
    private Collection<Aficiones> aficionesCollection;
    @JoinColumn(name = "ID_ESTADO_CIVIL", referencedColumnName = "ID_ESTADO_CIVIL")
    @ManyToOne(optional = false)
    private EstadoCivil idEstadoCivil;
    @JoinColumn(name = "ID_GRUPO_SANGUINEO", referencedColumnName = "ID_GRUPO_SANGUINEO")
    @ManyToOne(optional = false)
    private GrupoSanguineo idGrupoSanguineo;
    @JoinColumn(name = "ID_CIUDAD_EXPEDICION", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad idCiudadExpedicion;
    @JoinColumn(name = "ID_GENERO", referencedColumnName = "ID_GENERO")
    @ManyToOne(optional = false)
    private Genero idGenero;
    @JoinColumn(name = "ID_CIUDAD_NACIMIENTO", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad idCiudadNacimiento;
    @JoinColumn(name = "ID_TIPO_DOCUMENTO", referencedColumnName = "ID_TIPO_DOCUMENTO")
    @ManyToOne(optional = false)
    private TipoDocumento idTipoDocumento;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEgresado")
    private Collection<Educacion> educacionCollection;

    public Egresado() {
    }

    public Egresado(Long idEgresado) {
        this.idEgresado = idEgresado;
    }

    public Egresado(Long idEgresado, String primerApellido, String segundoApellido, String nombres, Date fechaNacimiento, String numeroDocumento, Date fechaExpedicion, boolean aceptaCondiciones) {
        this.idEgresado = idEgresado;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroDocumento = numeroDocumento;
        this.fechaExpedicion = fechaExpedicion;
        this.aceptaCondiciones = aceptaCondiciones;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Date getFechaUltimaAct() {
        return fechaUltimaAct;
    }

    public void setFechaUltimaAct(Date fechaUltimaAct) {
        this.fechaUltimaAct = fechaUltimaAct;
    }

    public boolean getAceptaCondiciones() {
        return aceptaCondiciones;
    }

    public void setAceptaCondiciones(boolean aceptaCondiciones) {
        this.aceptaCondiciones = aceptaCondiciones;
    }

    public Long getIdEgresado() {
        return idEgresado;
    }

    public void setIdEgresado(Long idEgresado) {
        this.idEgresado = idEgresado;
    }

    @XmlTransient
    public Collection<Asociacion> getAsociacionCollection() {
        return asociacionCollection;
    }

    public void setAsociacionCollection(Collection<Asociacion> asociacionCollection) {
        this.asociacionCollection = asociacionCollection;
    }

    @XmlTransient
    public Collection<EgresadoRespuesta> getEgresadoRespuestaCollection() {
        return egresadoRespuestaCollection;
    }

    public void setEgresadoRespuestaCollection(Collection<EgresadoRespuesta> egresadoRespuestaCollection) {
        this.egresadoRespuestaCollection = egresadoRespuestaCollection;
    }

    @XmlTransient
    public Collection<Residencia> getResidenciaCollection() {
        return residenciaCollection;
    }

    public void setResidenciaCollection(Collection<Residencia> residenciaCollection) {
        this.residenciaCollection = residenciaCollection;
    }

    @XmlTransient
    public Collection<ExperienciaLaboral> getExperienciaLaboralCollection() {
        return experienciaLaboralCollection;
    }

    public void setExperienciaLaboralCollection(Collection<ExperienciaLaboral> experienciaLaboralCollection) {
        this.experienciaLaboralCollection = experienciaLaboralCollection;
    }

    @XmlTransient
    public Collection<Reconocimiento> getReconocimientoCollection() {
        return reconocimientoCollection;
    }

    public void setReconocimientoCollection(Collection<Reconocimiento> reconocimientoCollection) {
        this.reconocimientoCollection = reconocimientoCollection;
    }

    @XmlTransient
    public Collection<LenguaExtranjera> getLenguaExtranjeraCollection() {
        return lenguaExtranjeraCollection;
    }

    public void setLenguaExtranjeraCollection(Collection<LenguaExtranjera> lenguaExtranjeraCollection) {
        this.lenguaExtranjeraCollection = lenguaExtranjeraCollection;
    }

    @XmlTransient
    public Collection<Contacto> getContactoCollection() {
        return contactoCollection;
    }

    public void setContactoCollection(Collection<Contacto> contactoCollection) {
        this.contactoCollection = contactoCollection;
    }

    @XmlTransient
    public Collection<EgresadoRedSocial> getEgresadoRedSocialCollection() {
        return egresadoRedSocialCollection;
    }

    public void setEgresadoRedSocialCollection(Collection<EgresadoRedSocial> egresadoRedSocialCollection) {
        this.egresadoRedSocialCollection = egresadoRedSocialCollection;
    }

    @XmlTransient
    public Collection<Aficiones> getAficionesCollection() {
        return aficionesCollection;
    }

    public void setAficionesCollection(Collection<Aficiones> aficionesCollection) {
        this.aficionesCollection = aficionesCollection;
    }

    public EstadoCivil getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(EstadoCivil idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public GrupoSanguineo getIdGrupoSanguineo() {
        return idGrupoSanguineo;
    }

    public void setIdGrupoSanguineo(GrupoSanguineo idGrupoSanguineo) {
        this.idGrupoSanguineo = idGrupoSanguineo;
    }

    public Ciudad getIdCiudadExpedicion() {
        return idCiudadExpedicion;
    }

    public void setIdCiudadExpedicion(Ciudad idCiudadExpedicion) {
        this.idCiudadExpedicion = idCiudadExpedicion;
    }

    public Genero getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Genero idGenero) {
        this.idGenero = idGenero;
    }

    public Ciudad getIdCiudadNacimiento() {
        return idCiudadNacimiento;
    }

    public void setIdCiudadNacimiento(Ciudad idCiudadNacimiento) {
        this.idCiudadNacimiento = idCiudadNacimiento;
    }

    public TipoDocumento getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(TipoDocumento idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public Collection<Educacion> getEducacionCollection() {
        return educacionCollection;
    }

    public void setEducacionCollection(Collection<Educacion> educacionCollection) {
        this.educacionCollection = educacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEgresado != null ? idEgresado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Egresado)) {
            return false;
        }
        Egresado other = (Egresado) object;
        return (this.idEgresado != null || other.idEgresado == null) && (this.idEgresado == null || this.idEgresado.equals(other.idEgresado));
    }

    @Override
    public String toString() {
        return "Persistencia.Egresado[ idEgresado=" + idEgresado + " ]";
    }
    
    public Collection<EducacionFormalUcentral> getEducacionFormalUcentral() {
        Collection<EducacionFormalUcentral> coleccion = new ArrayList<>();
        for (Educacion educacion : educacionCollection) {
            if (educacion.getEducacionFormalUcentral() != null) {
                coleccion.add(educacion.getEducacionFormalUcentral());
            }
        }
        return coleccion;
    }
    
    public Collection<EdFormalOtrasInstituciones> getEducacionFormalOtrasInstituciones() {
        Collection<EdFormalOtrasInstituciones> coleccion = new ArrayList<>();
        for (Educacion educacion : educacionCollection) {
            if (educacion.getEdFormalOtrasInstituciones()!= null) {
                coleccion.add(educacion.getEdFormalOtrasInstituciones());
            }
        }
        return coleccion;
    }
    
    public Collection<EducacionNoFormal> getEducacionNoFormal()
    {
        Collection<EducacionNoFormal> coleccion = new ArrayList<>();
        for (Educacion educacion : educacionCollection) {
            if (educacion.getEducacionNoFormal()!= null) {
                coleccion.add(educacion.getEducacionNoFormal());
            }
        }
        
        return coleccion;
    }
}
