package Modelo;

/**
 * @author YURY
 * @version 1.0
 * @created 12-jul-2014 06:37:27 a.m.
 */
public class Usuario {

    private String correoInstitucional;
    private String nombreUsuario;
    private String clave;
    private long idPreguntaSeguridad;
    private String respuestaSeguridad;
    private long idUsuario;

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
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the idPreguntaSeguridad
     */
    public long getIdPreguntaSeguridad() {
        return idPreguntaSeguridad;
    }

    /**
     * @param idPreguntaSeguridad the idPreguntaSeguridad to set
     */
    public void setIdPreguntaSeguridad(long idPreguntaSeguridad) {
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
}