/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author YURY
 */
public class ExperienciaLaboral {

    // A esto me refiero
    //Asi no se llama en la persis
    //una cosa es la variable y otra la persis
    // Si, me refiero al atributo que tienen las calses del paquete4 Persistencia
    //vale voy a ver si me funcionan oky tu no vas a ir a la u?
    // no tengo clase... ah que chevere
    // yo si tengo cita medica de los ojos ahora a las 9.40
    
    private long idExperienciaLaboral;
    private TipoContrato idTipoContrato;
    private String nombreEmpresa;
    private Ciudad idCiudad;
    private String cargo;
    private Subsector idSubsector;
    private NivelCargo idNivelCargo;
    private AreaEmpresa idAreaEmpresa;
    private boolean conexionInternet;
    private RangoSalarial idRangoSalarial;
    private Date fechaRegistro;
    private String funcionesLogros;
    private String telefonoEmpresa;
    private CargoEquivalente idCargoEquivalente;
    private String jefeInmediato;
    private Mes idMesIngreso;
    private Mes idMesFinalizacion;
    private int anioIngreso;
    private int anioFinalizacion;
    private long idEgresado;
    private boolean estado;

    /**
     * @return the idExperienciaLaboral
     */
    public long getIdExperienciaLaboral() {
        return idExperienciaLaboral;
    }

    /**
     * @param idExperienciaLaboral the idExperienciaLaboral to set
     */
    public void setIdExperienciaLaboral(long idExperienciaLaboral) {
        this.idExperienciaLaboral = idExperienciaLaboral;
    }

    /**
     * @return the idTipoContrato
     */
    public TipoContrato getIdTipoContrato() {
        return idTipoContrato;
    }

    /**
     * @param idTipoContrato the idTipoContrato to set
     */
    public void setIdTipoContrato(TipoContrato idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    /**
     * @return the nombreEmpresa
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /**
     * @param nombreEmpresa the nombreEmpresa to set
     */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    /**
     * @return the idCiudad
     */
    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    /**
     * @param idCiudad the idCiudad to set
     */
    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the idSubsector
     */
    public Subsector getIdSubsector() {
        return idSubsector;
    }

    /**
     * @param idSubsector the idSubsector to set
     */
    public void setIdSubsector(Subsector idSubsector) {
        this.idSubsector = idSubsector;
    }

    /**
     * @return the idNivelCargo
     */
    public NivelCargo getIdNivelCargo() {
        return idNivelCargo;
    }

    /**
     * @param idNivelCargo the idNivelCargo to set
     */
    public void setIdNivelCargo(NivelCargo idNivelCargo) {
        this.idNivelCargo = idNivelCargo;
    }

    /**
     * @return the idAreaEmpresa
     */
    public AreaEmpresa getIdAreaEmpresa() {
        return idAreaEmpresa;
    }

    /**
     * @param idAreaEmpresa the idAreaEmpresa to set
     */
    public void setIdAreaEmpresa(AreaEmpresa idAreaEmpresa) {
        this.idAreaEmpresa = idAreaEmpresa;
    }

    /**
     * @return the conexionInternet
     */
    public boolean isConexionInternet() {
        return conexionInternet;
    }

    /**
     * @param conexionInternet the conexionInternet to set
     */
    public void setConexionInternet(boolean conexionInternet) {
        this.conexionInternet = conexionInternet;
    }

    /**
     * @return the idRangoSalarial
     */
    public RangoSalarial getIdRangoSalarial() {
        return idRangoSalarial;
    }

    /**
     * @param idRangoSalarial the idRangoSalarial to set
     */
    public void setIdRangoSalarial(RangoSalarial idRangoSalarial) {
        this.idRangoSalarial = idRangoSalarial;
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

    /**
     * @return the funcionesLogros
     */
    public String getFuncionesLogros() {
        return funcionesLogros;
    }

    /**
     * @param funcionesLogros the funcionesLogros to set
     */
    public void setFuncionesLogros(String funcionesLogros) {
        this.funcionesLogros = funcionesLogros;
    }

    /**
     * @return the telefonoEmpresa
     */
    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    /**
     * @param telefonoEmpresa the telefonoEmpresa to set
     */
    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    /**
     * @return the idCargoEquivalente
     */
    public CargoEquivalente getIdCargoEquivalente() {
        return idCargoEquivalente;
    }

    /**
     * @param idCargoEquivalente the idCargoEquivalente to set
     */
    public void setIdCargoEquivalente(CargoEquivalente idCargoEquivalente) {
        this.idCargoEquivalente = idCargoEquivalente;
    }

    /**
     * @return the jefeInmediato
     */
    public String getJefeInmediato() {
        return jefeInmediato;
    }

    /**
     * @param jefeInmediato the jefeInmediato to set
     */
    public void setJefeInmediato(String jefeInmediato) {
        this.jefeInmediato = jefeInmediato;
    }

    /**
     * @return the idMesIngreso
     */
    public Mes getIdMesIngreso() {
        return idMesIngreso;
    }

    /**
     * @param idMesIngreso the idMesIngreso to set
     */
    public void setIdMesIngreso(Mes idMesIngreso) {
        this.idMesIngreso = idMesIngreso;
    }

    /**
     * @return the idMesFinalizacion
     */
    public Mes getIdMesFinalizacion() {
        return idMesFinalizacion;
    }

    /**
     * @param idMesFinalizacion the idMesFinalizacion to set
     */
    public void setIdMesFinalizacion(Mes idMesFinalizacion) {
        this.idMesFinalizacion = idMesFinalizacion;
    }

    /**
     * @return the anioIngreso
     */
    public int getAnioIngreso() {
        return anioIngreso;
    }

    /**
     * @param anioIngreso the anioIngreso to set
     */
    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    /**
     * @return the anioFinalizacion
     */
    public int getAnioFinalizacion() {
        return anioFinalizacion;
    }

    /**
     * @param anioFinalizacion the anioFinalizacion to set
     */
    public void setAnioFinalizacion(int anioFinalizacion) {
        this.anioFinalizacion = anioFinalizacion;
    }

    /**
     * @return the idEgresado
     */
    public long getIdEgresado() {
        return idEgresado;
    }

    /**
     * @param idEgresado the idEgresado to set
     */
    public void setIdEgresado(long idEgresado) {
        this.idEgresado = idEgresado;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
