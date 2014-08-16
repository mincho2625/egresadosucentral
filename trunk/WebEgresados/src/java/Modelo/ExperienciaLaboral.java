/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Persistencia.AreaEmpresa;
import Persistencia.CargoEquivalente;
import Persistencia.Subsector;
import Persistencia.TipoContrato;
import Persistencia.Ciudad;
import Persistencia.NivelCargo;
import Persistencia.RangoSalarial;
import Persistencia.Egresado;
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
    private String FUNCIONES_LOGROS;
    private String TELEFONO_EMPRESA;
    private CargoEquivalente idCargoEquivalente;
    private String JEFE_INMEDIATO;
    private Persistencia.Mes idMesIngreso;
    private Persistencia.Mes idMesFinalizacion;
    private int anioIngreso;
    private Integer anioFinalizacion;
    private Egresado idEgresado;

    public long getIdExperienciaLaboral() {
        return idExperienciaLaboral;
    }

    public void setIdExperienciaLaboral(long idExperienciaLaboral) {
        this.idExperienciaLaboral = idExperienciaLaboral;
    }

    public TipoContrato getIdTipoContrato() {
        return idTipoContrato;
    }

    public void setIdTipoContrato(TipoContrato idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    public boolean isConexionInternet() {
        return conexionInternet;
    }

    public void setConexionInternet(boolean conexionInternet) {
        this.conexionInternet = conexionInternet;
    }

    public RangoSalarial getIdRangoSalarial() {
        return idRangoSalarial;
    }

    public void setIdRangoSalarial(RangoSalarial idRangoSalarial) {
        this.idRangoSalarial = idRangoSalarial;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFUNCIONES_LOGROS() {
        return FUNCIONES_LOGROS;
    }

    public void setFUNCIONES_LOGROS(String FUNCIONES_LOGROS) {
        this.FUNCIONES_LOGROS = FUNCIONES_LOGROS;
    }

    public String getTELEFONO_EMPRESA() {
        return TELEFONO_EMPRESA;
    }

    public void setTELEFONO_EMPRESA(String TELEFONO_EMPRESA) {
        this.TELEFONO_EMPRESA = TELEFONO_EMPRESA;
    }

    public CargoEquivalente getIdCargoEquivalente() {
        return idCargoEquivalente;
    }

    public void setIdCargoEquivalente(CargoEquivalente idCargoEquivalente) {
        this.idCargoEquivalente = idCargoEquivalente;
    }

    public String getJEFE_INMEDIATO() {
        return JEFE_INMEDIATO;
    }

    public void setJEFE_INMEDIATO(String JEFE_INMEDIATO) {
        this.JEFE_INMEDIATO = JEFE_INMEDIATO;
    }

    public Persistencia.Mes getIdMesIngreso() {
        return idMesIngreso;
    }

    public void setIdMesIngreso(Persistencia.Mes idMesIngreso) {
        this.idMesIngreso = idMesIngreso;
    }

    public Persistencia.Mes getIdMesFinalizacion() {
        return idMesFinalizacion;
    }

    public void setIdMesFinalizacion(Persistencia.Mes idMesFinalizacion) {
        this.idMesFinalizacion = idMesFinalizacion;
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

    public Egresado getIdEgresado() {
        return idEgresado;
    }

    public void setIdEgresado(Egresado idEgresado) {
        this.idEgresado = idEgresado;
    }

   
}
