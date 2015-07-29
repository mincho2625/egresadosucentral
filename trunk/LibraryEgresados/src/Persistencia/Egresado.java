/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    @NamedQuery(name = "Egresado.findByNombreUsuario", query = "SELECT e FROM Egresado e inner join Usuario u on u = e.usuario WHERE u.nombre = :nombreUsuario"),
    @NamedQuery(name = "Egresado.findByUsuarios", query = "SELECT e FROM Egresado e inner join Usuario u on u = e.usuario"),
    @NamedQuery(name = "Egresado.findByIdEgresado", query = "SELECT e FROM Egresado e inner join Usuario u on u = e.usuario WHERE u.idUsuario = :idEgresado")})
public class Egresado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Basic(optional = false)
    @Column(name = "NOMBRES")
    private String nombres;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;
    @Column(name = "FECHA_EXPEDICION")
    @Temporal(TemporalType.DATE)
    private Date fechaExpedicion;
    @Column(name = "FOTO")
    private String foto;
    @Column(name = "FECHA_ULTIMA_ACT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimaAct;
    @Basic(optional = false)
    @Column(name = "ACEPTA_CONDICIONES")
    private boolean aceptaCondiciones;
    @Id
    @JoinColumn(name = "ID_EGRESADO", referencedColumnName = "ID_USUARIO")
    @OneToOne(optional = false)
    private Usuario usuario;
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
    @ManyToOne(optional = true)
    private GrupoSanguineo idGrupoSanguineo;
    @JoinColumn(name = "ID_CIUDAD_EXPEDICION", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = true)
    private Ciudad idCiudadExpedicion;
    @JoinColumn(name = "ID_GENERO", referencedColumnName = "ID_GENERO")
    @ManyToOne(optional = false)
    private Genero idGenero;
    @JoinColumn(name = "ID_CIUDAD_NACIMIENTO", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = true)
    private Ciudad idCiudadNacimiento;
    @JoinColumn(name = "ID_TIPO_DOCUMENTO", referencedColumnName = "ID_TIPO_DOCUMENTO")
    @ManyToOne(optional = true)
    private TipoDocumento idTipoDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEgresado")
    private Collection<Educacion> educacionCollection;
    @Basic(optional = false)
    @Column(name = "INFORMACION_COMPLETA")
    private boolean informacionCompleta;

    public Egresado() {
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    /**
     * @return the informacionCompleta
     */
    public boolean isInformacionCompleta() {
        return informacionCompleta;
    }

    /**
     * @param informacionCompleta the informacionCompleta to set
     */
    public void setInformacionCompleta(boolean informacionCompleta) {
        this.informacionCompleta = informacionCompleta;
    }
    
    public boolean getEstado()
    {
        return usuario.getEstado();
    }
    
    public long getIdEgresado()
    {
        return usuario.getIdUsuario();
    }

    @XmlTransient
    public Collection<Educacion> getEducacionCollection() {
        return educacionCollection;
    }

    public void setEducacionCollection(Collection<Educacion> educacionCollection) {
        this.educacionCollection = educacionCollection;
    }
}