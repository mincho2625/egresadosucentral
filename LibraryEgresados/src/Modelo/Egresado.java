package Modelo;

import java.util.Date;

/**
 * @author YURY
 * @version 1.0
 * @created 12-jul-2014 06:37:26 a.m.
 */
public class Egresado extends Usuario {

    private Date fechaExpedicion;
    private Date fechaNacimiento;
    private Date fechaUltimaAct;
    private String foto;
    private String nombres;
    private String numeroDocumento;
    private String primerApellido;
    private String segundoApellido;
    private Ciudad idCiudadNacimiento;
    private Ciudad idCiudadExpedicion;
    private EstadoCivil idEstadoCivil;
    private GrupoSanguineo idGrupoSanguineo;
    private Genero idGenero;
    private TipoDocumento idTipoDocumento;
    private boolean aceptaCondiciones;
    private boolean informacionCompleta;
    private EducacionFormalUcentral educacionFormalUcentral;

    /**
     * @return the fechaExpedicion
     */
    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    /**
     * @param fechaExpedicion the fechaExpedicion to set
     */
    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the fechaUltimaAct
     */
    public Date getFechaUltimaAct() {
        return fechaUltimaAct;
    }

    /**
     * @param fechaUltimaAct the fechaUltimaAct to set
     */
    public void setFechaUltimaAct(Date fechaUltimaAct) {
        this.fechaUltimaAct = fechaUltimaAct;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the numeroDocumento
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * @param numeroDocumento the numeroDocumento to set
     */
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     * @return the primerApellido
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * @param primerApellido the primerApellido to set
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /**
     * @return the segundoApellido
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**
     * @param segundoApellido the segundoApellido to set
     */
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    /**
     * @return the idCiudadNacimiento
     */
    public Ciudad getIdCiudadNacimiento() {
        return idCiudadNacimiento;
    }

    /**
     * @param idCiudadNacimiento the idCiudadNacimiento to set
     */
    public void setIdCiudadNacimiento(Ciudad idCiudadNacimiento) {
        this.idCiudadNacimiento = idCiudadNacimiento;
    }

    /**
     * @return the idCiudadExpedicion
     */
    public Ciudad getIdCiudadExpedicion() {
        return idCiudadExpedicion;
    }

    /**
     * @param idCiudadExpedicion the idCiudadExpedicion to set
     */
    public void setIdCiudadExpedicion(Ciudad idCiudadExpedicion) {
        this.idCiudadExpedicion = idCiudadExpedicion;
    }

    /**
     * @return the idEstadoCivil
     */
    public EstadoCivil getIdEstadoCivil() {
        return idEstadoCivil;
    }

    /**
     * @param idEstadoCivil the idEstadoCivil to set
     */
    public void setIdEstadoCivil(EstadoCivil idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    /**
     * @return the idGrupoSanguineo
     */
    public GrupoSanguineo getIdGrupoSanguineo() {
        return idGrupoSanguineo;
    }

    /**
     * @param idGrupoSanguineo the idGrupoSanguineo to set
     */
    public void setIdGrupoSanguineo(GrupoSanguineo idGrupoSanguineo) {
        this.idGrupoSanguineo = idGrupoSanguineo;
    }

    /**
     * @return the idGenero
     */
    public Genero getIdGenero() {
        return idGenero;
    }

    /**
     * @param idGenero the idGenero to set
     */
    public void setIdGenero(Genero idGenero) {
        this.idGenero = idGenero;
    }

    /**
     * @return the idTipoDocumento
     */
    public TipoDocumento getIdTipoDocumento() {
        return idTipoDocumento;
    }

    /**
     * @param idTipoDocumento the idTipoDocumento to set
     */
    public void setIdTipoDocumento(TipoDocumento idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    /**
     * @return the aceptaCondiciones
     */
    public boolean isAceptaCondiciones() {
        return aceptaCondiciones;
    }

    /**
     * @param aceptaCondiciones the aceptaCondiciones to set
     */
    public void setAceptaCondiciones(boolean aceptaCondiciones) {
        this.aceptaCondiciones = aceptaCondiciones;
    }

    /**
     * @return the idEgresado
     */
    public long getIdEgresado() {
        return this.getIdUsuario();
    }

    /**
     * @param idEgresado the idEgresado to set
     */
    public void setIdEgresado(long idEgresado) {
        this.setIdUsuario(idEgresado);
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

    /**
     * @return the educacionFormalUcentral
     */
    public EducacionFormalUcentral getEducacionFormalUcentral() {
        return educacionFormalUcentral;
    }

    /**
     * @param educacionFormalUcentral the educacionFormalUcentral to set
     */
    public void setEducacionFormalUcentral(EducacionFormalUcentral educacionFormalUcentral) {
        this.educacionFormalUcentral = educacionFormalUcentral;
    }
}