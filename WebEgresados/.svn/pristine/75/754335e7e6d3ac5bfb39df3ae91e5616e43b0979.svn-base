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
import Modelo.ItemLista;
import Modelo.Mes;
import Modelo.NivelCargo;
import Modelo.RangoSalarial;
import Modelo.Subsector;
import Modelo.TipoContrato;
import com.opensymphony.xwork2.ActionContext;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author JERONIMO
 */
public class ExperienciaLaboralAction extends CrudAction<ExperienciaLaboral> {
    private List<ItemLista> listaTiposContrato;
    private List<ItemLista> listaNivelesCargo;
    private List<ItemLista> listaAreasEmpresa;
    private List<ItemLista> listaRangosSalariales;
    private List<ItemLista> listaCargosEquivalentes;
    private List<ItemLista> listaMeses;
    private ArrayList<Integer> listaAnios;
    private long tipoContrato;
    private long sector;
    private long subsector;
    private long nivelCargo;
    private long areaEmpresa;
    private long rangoSalarial;
    private long cargoEquivalente;
    private long ciudad;
    private long mesIngreso;
    private long mesFinalizacion;
    private long pais;
    private long departamento;
    private boolean trabajoActual;

    public ExperienciaLaboralAction() {
        super(ExperienciaLaboral.class.getName());
        this.getIdObjeto = "getIdExperienciaLaboral";
        this.consultaTodos = "ExperienciaLaboral.findByIdEgresado";
        this.entidad = ExperienciaLaboral.class.getSimpleName();
        this.nombreIdObjeto = "idExperienciaLaboral";
        this.consultaIdObjeto = "ExperienciaLaboral.findByIdExperienciaLaboral";
        
        Map session = ActionContext.getContext().getSession();
        long id = (long) session.get("idEgresado");
        this.parametros = new HashMap<>();
        this.parametros.put("idEgresado", id);
        this.objeto.setIdEgresado(id);
    }

    /**
     * @return the listaTiposContrato
     */
    public List<ItemLista> getListaTiposContrato() {
        return listaTiposContrato;
    }

    /**
     * @param listaTiposContrato the listaTiposContrato to set
     */
    public void setListaTiposContrato(List<ItemLista> listaTiposContrato) {
        this.listaTiposContrato = listaTiposContrato;
    }

    /**
     * @return the listaNivelesCargo
     */
    public List<ItemLista> getListaNivelesCargo() {
        return listaNivelesCargo;
    }

    /**
     * @param listaNivelesCargo the listaNivelesCargo to set
     */
    public void setListaNivelesCargo(List<ItemLista> listaNivelesCargo) {
        this.listaNivelesCargo = listaNivelesCargo;
    }

    /**
     * @return the listaAreasEmpresa
     */
    public List<ItemLista> getListaAreasEmpresa() {
        return listaAreasEmpresa;
    }

    /**
     * @param listaAreasEmpresa the listaAreasEmpresa to set
     */
    public void setListaAreasEmpresa(List<ItemLista> listaAreasEmpresa) {
        this.listaAreasEmpresa = listaAreasEmpresa;
    }

    /**
     * @return the listaRangosSalariales
     */
    public List<ItemLista> getListaRangosSalariales() {
        return listaRangosSalariales;
    }

    /**
     * @param listaRangosSalariales the listaRangosSalariales to set
     */
    public void setListaRangosSalariales(List<ItemLista> listaRangosSalariales) {
        this.listaRangosSalariales = listaRangosSalariales;
    }

    /**
     * @return the listaCargosEquivalentes
     */
    public List<ItemLista> getListaCargosEquivalentes() {
        return listaCargosEquivalentes;
    }

    /**
     * @param listaCargosEquivalentes the listaCargosEquivalentes to set
     */
    public void setListaCargosEquivalentes(List<ItemLista> listaCargosEquivalentes) {
        this.listaCargosEquivalentes = listaCargosEquivalentes;
    }

    /**
     * @return the listaMeses
     */
    public List<ItemLista> getListaMeses() {
        return listaMeses;
    }

    /**
     * @param listaMeses the listaMeses to set
     */
    public void setListaMeses(List<ItemLista> listaMeses) {
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
    
    /**
     * @return the pais
     */
    public long getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(long pais) {
        this.pais = pais;
    }

    /**
     * @return the departamento
     */
    public long getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(long departamento) {
        this.departamento = departamento;
    }
    
    /**
     * @return the sector
     */
    public long getSector() {
        return sector;
    }

    /**
     * @param sector the sector to set
     */
    public void setSector(long sector) {
        this.sector = sector;
    }

    /**
     * @return the trabajoActual
     */
    public boolean isTrabajoActual() {
        return trabajoActual;
    }

    /**
     * @param trabajoActual the trabajoActual to set
     */
    public void setTrabajoActual(boolean trabajoActual) {
        this.trabajoActual = trabajoActual;
    }

    @Override
    public void desplegar() {
        this.setListaAreasEmpresa(listas.consultarAreasEmpresa());
        this.setListaCargosEquivalentes(listas.consultarCargosEquivalentes());
        this.setListaMeses(listas.consultarMeses());
        this.setListaNivelesCargo(listas.consultarNivelesCargo());
        this.setListaRangosSalariales(listas.consultarRangosSalariales());
        this.setListaTiposContrato(listas.consultarTiposContrato());
        this.setListaAnios(listas.consultarAnios());
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdAreaEmpresa(new AreaEmpresa(this.areaEmpresa));
        this.objeto.setIdCargoEquivalente(new CargoEquivalente(this.cargoEquivalente));
        this.objeto.setIdCiudad(new Ciudad(this.ciudad));
        this.objeto.setIdMesFinalizacion(new Mes(this.mesFinalizacion));
        this.objeto.setIdMesIngreso(new Mes(this.mesIngreso));
        this.objeto.setIdNivelCargo(new NivelCargo(this.nivelCargo));
        this.objeto.setIdRangoSalarial(new RangoSalarial(this.rangoSalarial));
        this.objeto.setIdSubsector(new Subsector(this.subsector));
        this.objeto.setIdTipoContrato(new TipoContrato(this.tipoContrato));
    }

    @Override
    public void consultarTipos() {
        this.setPais(objeto.getIdCiudad().getIdDepartamento().getIdPais().getIdPais());
        this.setDepartamento(objeto.getIdCiudad().getIdDepartamento().getIdDepartamento());
        this.setAreaEmpresa(objeto.getIdAreaEmpresa().getIdAreaEmpresa());
        this.setCargoEquivalente(objeto.getIdCargoEquivalente().getIdCargoEquivalente());
        this.setCiudad(objeto.getIdCiudad().getIdCiudad());
        this.setNivelCargo(objeto.getIdNivelCargo().getIdNivelCargo());
        this.setRangoSalarial(objeto.getIdRangoSalarial().getIdRangoSalarial());
        this.setSector(objeto.getIdSubsector().getIdSector().getIdSector());
        this.setSubsector(objeto.getIdSubsector().getIdSubsector());
        this.setTipoContrato(objeto.getIdTipoContrato().getIdTipoContrato());
        this.setMesIngreso(objeto.getIdMesIngreso().getIdMes());
        
        if (this.objeto.getAnioFinalizacion() == null && this.objeto.getIdMesFinalizacion() == null)
            this.trabajoActual = true;
        else
            this.setMesFinalizacion(objeto.getIdMesFinalizacion().getIdMes());
    }

    @Override
    public void insertarValoresDefecto() {
        this.objeto.setEstado(true);
        this.objeto.setFechaRegistro(Date.valueOf(LocalDate.now()));
    }

    @Override
    public void validar() {
        if (objeto.getNombreEmpresa().isEmpty()) {
            addFieldError("nombreEmpresa", "El nombre de la empresa es requerido.");
        }
        if (objeto.getCargo().isEmpty()) {
            addFieldError("cargo", "El cargo es requerido.");
        }
        if (objeto.getFuncionesLogros().equals("")) {
            addFieldError("funcionesLogros", "Las funciones y logros son requeridos.");
        }
        if (tipoContrato <= 0)
            addFieldError("tipoContrato", "El tipo de contrato es requerido.");
        if (ciudad <= 0)
            addFieldError("ciudad", "La ciudad es requerida.");
        if (sector <= 0)
            addFieldError("sector", "El sector es requerido.");
        if (subsector <= 0)
            addFieldError("subsector", "El subsector es requerido.");
        if (nivelCargo <= 0)
            addFieldError("nivelCargo", "El nivel del cargo es requerido.");
        if (areaEmpresa <= 0)
            addFieldError("areaEmpresa", "El área de la empresa es requerido.");
        if (rangoSalarial <= 0)
            addFieldError("rangoSalarial", "El rango salarial es requerido.");
        if (cargoEquivalente <= 0)
            addFieldError("cargoEquivalente", "El cargo equivalente es requerido.");
        if (mesIngreso <= 0)
            addFieldError("mesIngreso", "El mes de ingreso es requerido.");
        if (objeto.getAnioIngreso() <= 0)
            addFieldError("anioIngreso", "El año de ingreso es requerido.");
        
        if (!trabajoActual){
            if (objeto.getAnioFinalizacion() > 0)
            {
                if (objeto.getAnioFinalizacion() < objeto.getAnioIngreso())
                    addFieldError("anioFinalizacion", "El año de finalización debe ser mayor o igual al año de ingreso.");
                if (mesFinalizacion <= 0)
                    addFieldError("mesFinalizacion", "El mes de finalización es requerido.");
            }
            else
            {
                addFieldError("anioFinalizacion", "El año de finalización es requerido.");
            }

            if (mesFinalizacion > 0)
            {
                if (objeto.getAnioFinalizacion() <= 0)
                    addFieldError("anioFinalizacion", "El año de finalización es requerido.");
                else if (objeto.getAnioFinalizacion() == objeto.getAnioIngreso() && mesFinalizacion < mesIngreso)
                    addFieldError("mesFinalizacion", "El mes de finalización debe ser mayor o igual al mes de ingreso.");
            }
            else
            {
                addFieldError("mesFinalizacion", "El mes de finalización es requerido.");
            }
        }
        else {
            objeto.setAnioFinalizacion(null);
            objeto.setIdMesFinalizacion(null);
        }
    }

    @Override
    public void validarLista() {
        
    }
}