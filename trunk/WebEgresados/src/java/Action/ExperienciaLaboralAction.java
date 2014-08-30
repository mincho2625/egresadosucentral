/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.AreaEmpresa;
import Modelo.CargoEquivalente;
import Modelo.Ciudad;
import Modelo.ExperienciaLaboral;
import Modelo.Mes;
import Modelo.NivelCargo;
import Modelo.RangoSalarial;
import Modelo.Subsector;
import Modelo.TipoContrato;
import Util.Listas;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author JERONIMO
 */
public class ExperienciaLaboralAction extends CrudAction<ExperienciaLaboral> {
    // Aquí van las listas que van a sr los combos del formulario, ejemplo: ciudades
    // Debes crear el objeto TipoContrato en el modelo, los atributos del modelo deben llamarse igual que el Persistencia, porque 
    // yo hice unos métodos genéricos que pasan los datos rápidamente, pero es importante el nombre
    private Map<Long, TipoContrato> listaTiposContrato;
    private Map<Long, Subsector> listaSubsectores;
    private Map<Long, NivelCargo> listaNivelesCargo;
    private Map<Long, AreaEmpresa> listaAreasEmpresa;
    private Map<Long, RangoSalarial> listaRangosSalariales;
    private Map<Long, CargoEquivalente> listaCargosEquivalentes;
    private Map<Long, Mes> listaMeses;
    private Map<Long, Ciudad> listaCiudades;
    private ArrayList<Integer> listaAnios;
    private long tipoContrato;
    private long subsector;
    private long nivelCargo;
    private long areaEmpresa;
    private long rangoSalarial;
    private long cargoEquivalente;
    private long ciudad;
    private long mesIngreso;
    private long mesFinalizacion;

    public ExperienciaLaboralAction() {
        super(ExperienciaLaboral.class.getName());
        this.idObjeto = "getIdExperienciaLaboral";
        this.coleccion = "getExperienciaLaboralCollection";
        this.claseConcretaPersistencia = Persistencia.ExperienciaLaboral.class;
    }
    
    /**
     * @return the listaTiposContrato
     */
    public Collection<TipoContrato> getListaTiposContrato() {
        return listaTiposContrato.values();
    }

    /**
     * @param listaTiposContrato the listaTiposContrato to set
     */
    public void setListaTiposContrato(Map<Long, TipoContrato> listaTiposContrato) {
        this.listaTiposContrato = listaTiposContrato;
    }

    /**
     * @return the listaSubsectores
     */
    public Collection<Subsector> getListaSubsectores() {
        return listaSubsectores.values();
    }

    /**
     * @param listaSubsectores the listaSubsectores to set
     */
    public void setListaSubsectores(Map<Long, Subsector> listaSubsectores) {
        this.listaSubsectores = listaSubsectores;
    }

    /**
     * @return the listaNivelesCargo
     */
    public Collection<NivelCargo> getListaNivelesCargo() {
        return listaNivelesCargo.values();
    }

    /**
     * @param listaNivelesCargo the listaNivelesCargo to set
     */
    public void setListaNivelesCargo(Map<Long, NivelCargo> listaNivelesCargo) {
        this.listaNivelesCargo = listaNivelesCargo;
    }

    /**
     * @return the listaAreasEmpresa
     */
    public Collection<AreaEmpresa> getListaAreasEmpresa() {
        return listaAreasEmpresa.values();
    }

    /**
     * @param listaAreasEmpresa the listaAreasEmpresa to set
     */
    public void setListaAreasEmpresa(Map<Long, AreaEmpresa> listaAreasEmpresa) {
        this.listaAreasEmpresa = listaAreasEmpresa;
    }

    /**
     * @return the listaRangosSalariales
     */
    public Collection<RangoSalarial> getListaRangosSalariales() {
        return listaRangosSalariales.values();
    }

    /**
     * @param listaRangosSalariales the listaRangosSalariales to set
     */
    public void setListaRangosSalariales(Map<Long, RangoSalarial> listaRangosSalariales) {
        this.listaRangosSalariales = listaRangosSalariales;
    }

    /**
     * @return the listaCargosEquivalentes
     */
    public Collection<CargoEquivalente> getListaCargosEquivalentes() {
        return listaCargosEquivalentes.values();
    }

    /**
     * @param listaCargosEquivalentes the listaCargosEquivalentes to set
     */
    public void setListaCargosEquivalentes(Map<Long, CargoEquivalente> listaCargosEquivalentes) {
        this.listaCargosEquivalentes = listaCargosEquivalentes;
    }

    /**
     * @return the listaMeses
     */
    public Collection<Mes> getListaMeses() {
        return listaMeses.values();
    }

    /**
     * @param listaMeses the listaMeses to set
     */
    public void setListaMeses(Map<Long, Mes> listaMeses) {
        this.listaMeses = listaMeses;
    }

    /**
     * @return the tipoContrato
     */
    public long getTipoContrato() {
        return tipoContrato;
    }

    /**
     * @param tipoContrato the tipoContrato to set
     */
    public void setTipoContrato(long tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    /**
     * @return the subsector
     */
    public long getSubsector() {
        return subsector;
    }

    /**
     * @param subsector the subsector to set
     */
    public void setSubsector(long subsector) {
        this.subsector = subsector;
    }

    /**
     * @return the nivelCargo
     */
    public long getNivelCargo() {
        return nivelCargo;
    }

    /**
     * @param nivelCargo the nivelCargo to set
     */
    public void setNivelCargo(long nivelCargo) {
        this.nivelCargo = nivelCargo;
    }

    /**
     * @return the areaEmpresa
     */
    public long getAreaEmpresa() {
        return areaEmpresa;
    }

    /**
     * @param areaEmpresa the areaEmpresa to set
     */
    public void setAreaEmpresa(long areaEmpresa) {
        this.areaEmpresa = areaEmpresa;
    }

    /**
     * @return the rangoSalarial
     */
    public long getRangoSalarial() {
        return rangoSalarial;
    }

    /**
     * @param rangoSalarial the rangoSalarial to set
     */
    public void setRangoSalarial(long rangoSalarial) {
        this.rangoSalarial = rangoSalarial;
    }

    /**
     * @return the cargoEquivalente
     */
    public long getCargoEquivalente() {
        return cargoEquivalente;
    }

    /**
     * @param cargoEquivalente the cargoEquivalente to set
     */
    public void setCargoEquivalente(long cargoEquivalente) {
        this.cargoEquivalente = cargoEquivalente;
    }
    
    /**
     * @return the listaCiudades
     */
    public Collection<Ciudad> getListaCiudades() {
        return listaCiudades.values();
    }

    /**
     * @param listaCiudades the listaCiudades to set
     */
    public void setListaCiudades(Map<Long, Ciudad> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }

    /**
     * @return the ciudad
     */
    public long getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(long ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the mesFinalizacion
     */
    public long getMesFinalizacion() {
        return mesFinalizacion;
    }

    /**
     * @param mesFinalizacion the mesFinalizacion to set
     */
    public void setMesFinalizacion(long mesFinalizacion) {
        this.mesFinalizacion = mesFinalizacion;
    }
    
    /**
     * @return the mesIngreso
     */
    public long getMesIngreso() {
        return mesIngreso;
    }

    /**
     * @param mesIngreso the mesIngreso to set
     */
    public void setMesIngreso(long mesIngreso) {
        this.mesIngreso = mesIngreso;
    }
    
    /**
     * @return the listaAnios
     */
    public ArrayList<Integer> getListaAnios() {
        return listaAnios;
    }

    /**
     * @param listaAnios the listaAnios to set
     */
    public void setListaAnios(ArrayList<Integer> listaAnios) {
        this.listaAnios = listaAnios;
    }
    
    @Override
    public String desplegar() {
        this.obtenerLista();
        this.setListaAreasEmpresa(Listas.obtenerListas().getListaAreasEmpresa());
        this.setListaCargosEquivalentes(Listas.obtenerListas().getListaCargosEquivalentes());
        this.setListaMeses(Listas.obtenerListas().getListaMeses());
        this.setListaNivelesCargo(Listas.obtenerListas().getListaNivelesCargo());
        this.setListaRangosSalariales(Listas.obtenerListas().getListaRangosSalariales());
        this.setListaSubsectores(Listas.obtenerListas().getListaSubsectores());
        this.setListaTiposContrato(Listas.obtenerListas().getListaTiposContrato());
        this.setListaCiudades(Listas.obtenerListas().getListaCiudades());
        this.setListaAnios(Listas.obtenerListas().getListaAnios());
        
        this.editar = true;
        return SUCCESS;
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdAreaEmpresa(Listas.obtenerListas().getListaAreasEmpresa().get(this.areaEmpresa));
        this.objeto.setIdCargoEquivalente(Listas.obtenerListas().getListaCargosEquivalentes().get(this.cargoEquivalente));
        this.objeto.setIdCiudad(Listas.obtenerListas().getListaCiudades().get(this.ciudad));
        this.objeto.setIdMesFinalizacion(Listas.obtenerListas().getListaMeses().get(this.mesFinalizacion));
        this.objeto.setIdMesIngreso(Listas.obtenerListas().getListaMeses().get(this.mesIngreso));
        this.objeto.setIdNivelCargo(Listas.obtenerListas().getListaNivelesCargo().get(this.nivelCargo));
        this.objeto.setIdRangoSalarial(Listas.obtenerListas().getListaRangosSalariales().get(this.rangoSalarial));
        this.objeto.setIdSubsector(Listas.obtenerListas().getListaSubsectores().get(this.subsector));
        this.objeto.setIdTipoContrato(Listas.obtenerListas().getListaTiposContrato().get(this.tipoContrato));
    }

    @Override
    public void consultarTipos() {
        this.setAreaEmpresa(objeto.getIdAreaEmpresa().getIdAreaEmpresa());
        this.setCargoEquivalente(objeto.getIdCargoEquivalente().getIdCargoEquivalente());
        this.setCiudad(objeto.getIdCiudad().getIdCiudad());
        this.setNivelCargo(objeto.getIdNivelCargo().getIdNivelCargo());
        this.setRangoSalarial(objeto.getIdRangoSalarial().getIdRangoSalarial());
        this.setSubsector(objeto.getIdSubsector().getIdSubsector());
        this.setTipoContrato(objeto.getIdTipoContrato().getIdTipoContrato());
        this.setMesFinalizacion(objeto.getIdMesFinalizacion().getIdMes());
        this.setMesIngreso(objeto.getIdMesIngreso().getIdMes());
    }

    @Override
    public void insertarValoresDefecto() {
        this.objeto.setEstado(true);
        this.objeto.setFechaRegistro(Date.valueOf(LocalDate.now()));
    }
}
