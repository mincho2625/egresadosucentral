package Modelo;

import java.util.Date;

/**
 * @author YURY
 * @version 1.0
 * @created 12-jul-2014 06:37:27 a.m.
 */
public class Usuario {

    private String correoInstitucional;
    private String nombre;
    private String contrasenia;
    private PreguntaSeguridad idPreguntaSeguridad;
    private String respuestaSeguridad;
    private long idUsuario;
    protected boolean estado;
    private Date fechaRegistro;

    public Usuario() {}
    
    public Usuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    /**
     * @return the correoInstitucional
     */
    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    /**
     * @param correoInstitucional the correoInstitucional to set
     */
    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * @param contrasenia the contrasenia to set
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * @return the idPreguntaSeguridad
     */
    public PreguntaSeguridad getIdPreguntaSeguridad() {
        return idPreguntaSeguridad;
    }

    /**
     * @param idPreguntaSeguridad the idPreguntaSeguridad to set
     */
    public void setIdPreguntaSeguridad(PreguntaSeguridad idPreguntaSeguridad) {
        this.idPreguntaSeguridad = idPreguntaSeguridad;
    }

    /**
     * @return the respuestaSeguridad
     */
    public String getRespuestaSeguridad() {
        return respuestaSeguridad;
    }

    /**
     * @param respuestaSeguridad the respuestaSeguridad to set
     */
    public void setRespuestaSeguridad(String respuestaSeguridad) {
        this.respuestaSeguridad = respuestaSeguridad;
    }

    /**
     * @return the idUsuario
     */
    public long getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return (estado ? "Activo" : "Inactivo");
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the fechaRegistro
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param fechaRegistro the fechaRegistro to set
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}