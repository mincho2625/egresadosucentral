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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByContrasenia", query = "SELECT u FROM Usuario u WHERE u.contrasenia = :contrasenia"),
    @NamedQuery(name = "Usuario.findByCorreoInstitucional", query = "SELECT u FROM Usuario u WHERE u.correoInstitucional = :correoInstitucional"),
    @NamedQuery(name = "Usuario.findByRespuestaSeguridad", query = "SELECT u FROM Usuario u WHERE u.respuestaSeguridad = :respuestaSeguridad"),
    @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private Long idUsuario;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "CONTRASENIA")
    private String contrasenia;
    @Basic(optional = false)
    @Column(name = "CORREO_INSTITUCIONAL")
    private String correoInstitucional;
    @Basic(optional = false)
    @Column(name = "RESPUESTA_SEGURIDAD")
    private String respuestaSeguridad;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;
    @JoinColumn(name = "ID_PREGUNTA_SEGURIDAD", referencedColumnName = "ID_PREGUNTA_SEGURIDAD")
    @ManyToOne(optional = false)
    private PreguntaSeguridad idPreguntaSeguridad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<Egresado> egresadoCollection;

    public Usuario() {
    }

    public Usuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Long idUsuario, String nombre, String contrasenia, String correoInstitucional, String respuestaSeguridad, boolean estado) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.correoInstitucional = correoInstitucional;
        this.respuestaSeguridad = respuestaSeguridad;
        this.estado = estado;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getRespuestaSeguridad() {
        return respuestaSeguridad;
    }

    public void setRespuestaSeguridad(String respuestaSeguridad) {
        this.respuestaSeguridad = respuestaSeguridad;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public PreguntaSeguridad getIdPreguntaSeguridad() {
        return idPreguntaSeguridad;
    }

    public void setIdPreguntaSeguridad(PreguntaSeguridad idPreguntaSeguridad) {
        this.idPreguntaSeguridad = idPreguntaSeguridad;
    }

    @XmlTransient
    public Collection<Egresado> getEgresadoCollection() {
        return egresadoCollection;
    }

    public void setEgresadoCollection(Collection<Egresado> egresadoCollection) {
        this.egresadoCollection = egresadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
