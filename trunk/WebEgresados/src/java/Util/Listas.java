/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

import Controlador.ControladorEgresado;
import Modelo.AreaEmpresa;
import Modelo.AreaEstudios;
import Modelo.CargoEquivalente;
import Modelo.Ciudad;
import Modelo.ClaseReconocimiento;
import Modelo.DominioLenguaExt;
import Modelo.EstadoCivil;
import Modelo.EstadoEducacion;
import Modelo.Estrato;
import Modelo.Genero;
import Modelo.GrupoSanguineo;
import Modelo.Idioma;
import Modelo.Institucion;
import Modelo.IntensidadHoraria;
import Modelo.Jornada;
import Modelo.Mes;
import Modelo.Modalidad;
import Modelo.NivelCargo;
import Modelo.NivelEstudios;
import Modelo.Pais;
import Modelo.PreguntaSeguridad;
import Modelo.Programa;
import Modelo.RangoSalarial;
import Modelo.RedSocial;
import Modelo.Subsector;
import Modelo.TipoContacto;
import Modelo.TipoContrato;
import Modelo.TipoActividad;
import Modelo.TipoAsociacion;
import Modelo.TipoDocumento;
import Modelo.TipoEdNoFormal;
import Modelo.TipoReconocimiento;
import Modelo.TipoTenenciaVivienda;
import Modelo.TipoVivienda;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author YURY
 */
public final class Listas {
    private Map<Long, Ciudad> listaCiudades;
    private Map<Long, TipoReconocimiento> listaTiposReconocimiento;
    private Map<Long, ClaseReconocimiento> listaClasesReconocimiento;
    private Map<Long, Mes> listaMeses;
    private Map<Long, EstadoEducacion> listaEstadosEducacion;
    private Map<Long, AreaEstudios> listaAreasEstudios;
    private Map<Long, Modalidad> listaModalidades;
    private Map<Long, Institucion> listaInstituciones;
    private Map<Long, Jornada> listaJornadas;
    private Map<Long, Programa> listaProgramas;
    private Map<Long, NivelEstudios> listaNivelesEstudios;
    private Map<Long, RedSocial> listaRedesSociales;
    private Map<Long, TipoContrato> listaTiposContrato;
    private Map<Long, Subsector> listaSubsectores;
    private Map<Long, NivelCargo> listaNivelesCargo;
    private Map<Long, AreaEmpresa> listaAreasEmpresa;
    private Map<Long, RangoSalarial> listaRangosSalariales;
    private Map<Long, CargoEquivalente> listaCargosEquivalentes;
    private Map<Long, TipoVivienda> listaTiposVivienda;
    private Map<Long, TipoTenenciaVivienda> listaTiposTenenciaVivienda;
    private Map<Long, Estrato> listaEstratos;
    private Map<Long, TipoContacto> listaTiposContacto;
    private Map<Long,TipoActividad> listaTiposActividades;
    private Map<Long, TipoDocumento> listaTiposDocumento;
    private Map<Long, GrupoSanguineo> listaGruposSanguineos;
    private Map<Long, Genero> listaGeneros;
    private Map<Long, EstadoCivil> listaEstadosCiviles;
    private Map<Long, PreguntaSeguridad> listaPreguntas;
    private Map<Long, TipoAsociacion> listaTiposAsociaciones;
    private Map<Long, Pais> listaPaises;
    private Map<Long, TipoEdNoFormal> listaTiposEdNoFormal;
    private Map<Long, IntensidadHoraria> listaIntensidadesHorarias;
    private Map<Long, DominioLenguaExt> listaDominioLenguaExt;
    private Map<Long, Idioma> listaIdiomas;
    private ArrayList<Integer> listaAnios;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebEgresadosPU");

    private Listas()
    {
        this.listaCiudades = new HashMap<>();
        this.listaClasesReconocimiento = new HashMap<>();
        this.listaTiposReconocimiento = new HashMap<>();
        this.listaMeses = new HashMap<>();
        this.listaEstadosEducacion = new HashMap<>();
        this.listaAreasEstudios = new HashMap<>();
        this.listaModalidades = new HashMap<>();
        this.listaInstituciones = new HashMap<>();
        this.listaJornadas = new HashMap<>();
        this.listaProgramas = new HashMap<>();
        this.listaNivelesEstudios = new HashMap<>();
        this.listaRedesSociales = new HashMap<>();
        this.listaTiposContrato = new HashMap<>();
        this.listaSubsectores = new HashMap<>();
        this.listaNivelesCargo = new HashMap<>();
        this.listaAreasEmpresa = new HashMap<>();
        this.listaRangosSalariales = new HashMap<>();
        this.listaCargosEquivalentes = new HashMap<>();
        this.listaTiposVivienda = new HashMap<>();
        this.listaTiposTenenciaVivienda = new HashMap<>();
        this.listaEstratos = new HashMap<>();
        this.listaTiposContacto = new HashMap<>();
        this.listaTiposDocumento = new HashMap<>();
        this.listaGruposSanguineos = new HashMap<>();
        this.listaGeneros = new HashMap<>();
        this.listaEstadosCiviles = new HashMap<>();
        this.listaPreguntas = new HashMap<>();
        this.listaTiposActividades = new HashMap<>();
        this.listaTiposAsociaciones = new HashMap<>();
        this.listaPaises = new HashMap<>();
        this.listaTiposEdNoFormal = new HashMap<>();
        this.listaIntensidadesHorarias = new HashMap<>();
        this.listaDominioLenguaExt = new HashMap<>();
        this.listaIdiomas = new HashMap<>();
        
        consultar(this.listaCiudades, "Ciudad.findAll", "getIdCiudad", Modelo.Ciudad.class.getName());        
        consultar(this.listaClasesReconocimiento, "ClaseReconocimiento.findAll", "getIdClaseReconocimiento", Modelo.ClaseReconocimiento.class.getName());        
        consultar(this.listaTiposReconocimiento, "TipoReconocimiento.findAll", "getIdTipoReconocimiento", Modelo.TipoReconocimiento.class.getName());
        consultar(this.listaMeses, "Mes.findAll", "getIdMes", Modelo.Mes.class.getName());
        consultar(this.listaEstadosEducacion, "EstadoEducacion.findAll", "getIdEstadoEducacion", Modelo.EstadoEducacion.class.getName());
        consultar(this.listaAreasEstudios, "AreaEstudios.findAll", "getIdAreaEstudios", Modelo.AreaEstudios.class.getName());
        consultar(this.listaModalidades, "Modalidad.findAll", "getIdModalidad", Modelo.Modalidad.class.getName());
        consultar(this.listaInstituciones, "Institucion.findAll", "getIdInstitucion", Modelo.Institucion.class.getName());
        consultar(this.listaJornadas, "Jornada.findAll", "getIdJornada", Modelo.Jornada.class.getName());
        consultar(this.listaProgramas, "Programa.findAll", "getIdPrograma", Modelo.Programa.class.getName());
        consultar(this.listaNivelesEstudios, "NivelEstudios.findAll", "getIdNivelEstudios", Modelo.NivelEstudios.class.getName());
        consultar(this.listaRedesSociales, "RedSocial.findAll", "getIdRedSocial", Modelo.RedSocial.class.getName());
        consultar(this.listaTiposContrato, "TipoContrato.findAll", "getIdTipoContrato", Modelo.TipoContrato.class.getName());
        consultar(this.listaSubsectores, "Subsector.findAll", "getIdSubsector", Modelo.Subsector.class.getName());
        consultar(this.listaNivelesCargo, "NivelCargo.findAll", "getIdNivelCargo", Modelo.NivelCargo.class.getName());
        consultar(this.listaAreasEmpresa, "AreaEmpresa.findAll", "getIdAreaEmpresa", Modelo.AreaEmpresa.class.getName());
        consultar(this.listaRangosSalariales, "RangoSalarial.findAll", "getIdRangoSalarial", Modelo.RangoSalarial.class.getName());
        consultar(this.listaCargosEquivalentes, "CargoEquivalente.findAll", "getIdCargoEquivalente", Modelo.CargoEquivalente.class.getName());
        consultar(this.listaTiposVivienda, "TipoVivienda.findAll", "getIdTipoVivienda", Modelo.TipoVivienda.class.getName());
        consultar(this.listaTiposTenenciaVivienda, "TipoTenenciaVivienda.findAll", "getIdTipoTenenciaVivienda", Modelo.TipoTenenciaVivienda.class.getName());
        consultar(this.listaEstratos, "Estrato.findAll", "getIdEstrato", Modelo.Estrato.class.getName());
        consultar(this.listaTiposContacto, "TipoContacto.findAll", "getIdTipoContacto", Modelo.TipoContacto.class.getName());
        consultar(this.listaTiposDocumento, "TipoDocumento.findAll", "getIdTipoDocumento", Modelo.TipoDocumento.class.getName());
        consultar(this.listaGruposSanguineos, "GrupoSanguineo.findAll", "getIdGrupoSanguineo", Modelo.GrupoSanguineo.class.getName());
        consultar(this.listaPreguntas, "PreguntaSeguridad.findAll", "getIdPreguntaSeguridad", Modelo.PreguntaSeguridad.class.getName());
        consultar(this.listaEstadosCiviles, "EstadoCivil.findAll", "getIdEstadoCivil", Modelo.EstadoCivil.class.getName());
        consultar(this.listaGeneros, "Genero.findAll", "getIdGenero", Modelo.Genero.class.getName());
        consultar(this.listaTiposActividades, "TipoActividad.findAll", "getIdTipoActividad", Modelo.TipoActividad.class.getName());
        consultar(this.listaTiposAsociaciones, "TipoAsociacion.findAll", "getIdTipoAsociacion", Modelo.TipoAsociacion.class.getName());
        consultar(this.listaPaises, "Pais.findAll", "getIdPais", Modelo.Pais.class.getName());
        consultar(this.listaTiposEdNoFormal, "TipoEdNoFormal.findAll", "getIdTipoEdNoFormal", Modelo.TipoEdNoFormal.class.getName());
        consultar(this.listaIntensidadesHorarias, "IntensidadHoraria.findAll", "getIdIntensidadHoraria", Modelo.IntensidadHoraria.class.getName());
        consultar(this.listaDominioLenguaExt, "DominioLenguaExt.findAll", "getIdDominioLenguaExt", Modelo.DominioLenguaExt.class.getName());
        consultar(this.listaIdiomas, "Idioma.findAll", "getIdIdioma", Modelo.Idioma.class.getName());
        consultarAnios();
    }
    
    private static Listas listas;
    
    public static Listas obtenerListas()
    {
        if (listas == null)
            listas = new Listas();
        
        return listas;
    }

    /**
     * @return the listaCiudades
     */
    public Map<Long, Ciudad> getListaCiudades() {
        return listaCiudades;
    }

    /**
     * @param listaCiudades the listaCiudades to set
     */
    public void setListaCiudades(Map<Long, Ciudad> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }

    /**
     * @return the listaTiposReconocimiento
     */
    public Map<Long, TipoReconocimiento> getListaTiposReconocimiento() {
        return listaTiposReconocimiento;
    }

    /**
     * @param listaTiposReconocimiento the listaTiposReconocimiento to set
     */
    public void setListaTiposReconocimiento(Map<Long, TipoReconocimiento> listaTiposReconocimiento) {
        this.listaTiposReconocimiento = listaTiposReconocimiento;
    }

    /**
     * @return the listaClasesReconocimiento
     */
    public Map<Long, ClaseReconocimiento> getListaClasesReconocimiento() {
        return listaClasesReconocimiento;
    }

    /**
     * @param listaClasesReconocimiento the listaClasesReconocimiento to set
     */
    public void setListaClasesReconocimiento(Map<Long, ClaseReconocimiento> listaClasesReconocimiento) {
        this.listaClasesReconocimiento = listaClasesReconocimiento;
    }

    /**
     * @return the listaMeses
     */
    public Map<Long, Mes> getListaMeses() {
        return listaMeses;
    }

    /**
     * @param listaMeses the listaMeses to set
     */
    public void setListaMeses(Map<Long, Mes> listaMeses) {
        this.listaMeses = listaMeses;
    }

    /**
     * @return the listaEstadosEducacion
     */
    public Map<Long, EstadoEducacion> getListaEstadosEducacion() {
        return listaEstadosEducacion;
    }

    /**
     * @param listaEstadosEducacion the listaEstadosEducacion to set
     */
    public void setListaEstadosEducacion(Map<Long, EstadoEducacion> listaEstadosEducacion) {
        this.listaEstadosEducacion = listaEstadosEducacion;
    }

    /**
     * @return the listaAreasEstudios
     */
    public Map<Long, AreaEstudios> getListaAreasEstudios() {
        return listaAreasEstudios;
    }

    /**
     * @param listaAreasEstudios the listaAreasEstudios to set
     */
    public void setListaAreasEstudios(Map<Long, AreaEstudios> listaAreasEstudios) {
        this.listaAreasEstudios = listaAreasEstudios;
    }

    /**
     * @return the listaModalidades
     */
    public Map<Long, Modalidad> getListaModalidades() {
        return listaModalidades;
    }

    /**
     * @param listaModalidades the listaModalidades to set
     */
    public void setListaModalidades(Map<Long, Modalidad> listaModalidades) {
        this.listaModalidades = listaModalidades;
    }

    /**
     * @return the listaInstituciones
     */
    public Map<Long, Institucion> getListaInstituciones() {
        return listaInstituciones;
    }

    /**
     * @param listaInstituciones the listaInstituciones to set
     */
    public void setListaInstituciones(Map<Long, Institucion> listaInstituciones) {
        this.listaInstituciones = listaInstituciones;
    }

    /**
     * @return the listaJornadas
     */
    public Map<Long, Jornada> getListaJornadas() {
        return listaJornadas;
    }

    /**
     * @param listaJornadas the listaJornadas to set
     */
    public void setListaJornadas(Map<Long, Jornada> listaJornadas) {
        this.listaJornadas = listaJornadas;
    }

    /**
     * @return the listaProgramas
     */
    public Map<Long, Programa> getListaProgramas() {
        return listaProgramas;
    }

    /**
     * @param listaProgramas the listaProgramas to set
     */
    public void setListaProgramas(Map<Long, Programa> listaProgramas) {
        this.listaProgramas = listaProgramas;
    }

    /**
     * @return the listaNivelesEstudios
     */
    public Map<Long, NivelEstudios> getListaNivelesEstudios() {
        return listaNivelesEstudios;
    }

    /**
     * @param listaNivelesEstudios the listaNivelesEstudios to set
     */
    public void setListaNivelesEstudios(Map<Long, NivelEstudios> listaNivelesEstudios) {
        this.listaNivelesEstudios = listaNivelesEstudios;
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
     * @return the listaRedesSociales
     */
    public Map<Long, RedSocial> getListaRedesSociales() {
        return listaRedesSociales;
    }

    /**
     * @param listaRedesSociales the listaRedesSociales to set
     */
    public void setListaRedesSociales(Map<Long, RedSocial> listaRedesSociales) {
        this.listaRedesSociales = listaRedesSociales;
    }
    
    /**
     * @return the listaTiposContrato
     */
    public Map<Long, TipoContrato> getListaTiposContrato() {
        return listaTiposContrato;
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
    public Map<Long, Subsector> getListaSubsectores() {
        return listaSubsectores;
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
    public Map<Long, NivelCargo> getListaNivelesCargo() {
        return listaNivelesCargo;
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
    public Map<Long, AreaEmpresa> getListaAreasEmpresa() {
        return listaAreasEmpresa;
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
    public Map<Long, RangoSalarial> getListaRangosSalariales() {
        return listaRangosSalariales;
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
    public Map<Long, CargoEquivalente> getListaCargosEquivalentes() {
        return listaCargosEquivalentes;
    }

    /**
     * @param listaCargosEquivalentes the listaCargosEquivalentes to set
     */
    public void setListaCargosEquivalentes(Map<Long, CargoEquivalente> listaCargosEquivalentes) {
        this.listaCargosEquivalentes = listaCargosEquivalentes;
    }
    
    /**
     * @return the listaTiposVivienda
     */
    public Map<Long, TipoVivienda> getListaTiposVivienda() {
        return listaTiposVivienda;
    }

    /**
     * @param listaTiposVivienda the listaTiposVivienda to set
     */
    public void setListaTiposVivienda(Map<Long, TipoVivienda> listaTiposVivienda) {
        this.listaTiposVivienda = listaTiposVivienda;
    }

    /**
     * @return the listaTiposTenenciaVivienda
     */
    public Map<Long, TipoTenenciaVivienda> getListaTiposTenenciaVivienda() {
        return listaTiposTenenciaVivienda;
    }

    /**
     * @param listaTiposTenenciaVivienda the listaTiposTenenciaVivienda to set
     */
    public void setListaTiposTenenciaVivienda(Map<Long, TipoTenenciaVivienda> listaTiposTenenciaVivienda) {
        this.listaTiposTenenciaVivienda = listaTiposTenenciaVivienda;
    }

    /**
     * @return the listaEstratos
     */
    public Map<Long, Estrato> getListaEstratos() {
        return listaEstratos;
    }

    /**
     * @param listaEstratos the listaEstratos to set
     */
    public void setListaEstratos(Map<Long, Estrato> listaEstratos) {
        this.listaEstratos = listaEstratos;
    }
    
    /**
     * @return the listaTiposContacto
     */
    public Map<Long, TipoContacto> getListaTiposContacto() {
        return listaTiposContacto;
    }

    /**
     * @param listaTiposContacto the listaTiposContacto to set
     */
    public void setListaTiposContacto(Map<Long, TipoContacto> listaTiposContacto) {
        this.listaTiposContacto = listaTiposContacto;
    }
    
    /**
     * @return the listaTiposDocumento
     */
    public Map<Long, TipoDocumento> getListaTiposDocumento() {
        return listaTiposDocumento;
    }

    /**
     * @param listaTiposDocumento the listaTiposDocumento to set
     */
    public void setListaTiposDocumento(Map<Long, TipoDocumento> listaTiposDocumento) {
        this.listaTiposDocumento = listaTiposDocumento;
    }

    /**
     * @return the listaGruposSanguineos
     */
    public Map<Long, GrupoSanguineo> getListaGruposSanguineos() {
        return listaGruposSanguineos;
    }

    /**
     * @param listaGruposSanguineos the listaGruposSanguineos to set
     */
    public void setListaGruposSanguineos(Map<Long, GrupoSanguineo> listaGruposSanguineos) {
        this.listaGruposSanguineos = listaGruposSanguineos;
    }

    /**
     * @return the listaGeneros
     */
    public Map<Long, Genero> getListaGeneros() {
        return listaGeneros;
    }

    /**
     * @param listaGeneros the listaGeneros to set
     */
    public void setListaGeneros(Map<Long, Genero> listaGeneros) {
        this.listaGeneros = listaGeneros;
    }

    /**
     * @return the listaEstadosCiviles
     */
    public Map<Long, EstadoCivil> getListaEstadosCiviles() {
        return listaEstadosCiviles;
    }

    /**
     * @param listaEstadosCiviles the listaEstadosCiviles to set
     */
    public void setListaEstadosCiviles(Map<Long, EstadoCivil> listaEstadosCiviles) {
        this.listaEstadosCiviles = listaEstadosCiviles;
    }

    /**
     * @return the listaPreguntas
     */
    public Map<Long, PreguntaSeguridad> getListaPreguntas() {
        return listaPreguntas;
    }

    /**
     * @param listaPreguntas the listaPreguntas to set
     */
    public void setListaPreguntas(Map<Long, PreguntaSeguridad> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }
    
    /**
     * @return the listaTiposAsociaciones
     */
    public Map<Long, TipoAsociacion> getListaTiposAsociaciones() {
        return listaTiposAsociaciones;
    }

    /**
     * @param listaTiposAsociaciones the listaTiposAsociaciones to set
     */
    public void setListaTiposAsociaciones(Map<Long, TipoAsociacion> listaTiposAsociaciones) {
        this.listaTiposAsociaciones = listaTiposAsociaciones;
    }
    
    /**
     * @return the listaPaises
     */
    public Map<Long, Pais> getListaPaises() {
        return listaPaises;
    }

    /**
     * @param listaPaises the listaPaises to set
     */
    public void setListaPaises(Map<Long, Pais> listaPaises) {
        this.listaPaises = listaPaises;
    }
    
    /**
     * @return the listaTiposActividades
     */
    public Map<Long,TipoActividad> getListaTiposActividades() {
        return listaTiposActividades;
    }

    /**
     * @param listaTiposActividades the listaTiposActividades to set
     */
    public void setListaTiposActividades(Map<Long,TipoActividad> listaTiposActividades) {
        this.listaTiposActividades = listaTiposActividades;
    }
    
    /**
     * @return the listaTiposEdNoFormal
     */
    public Map<Long, TipoEdNoFormal> getListaTiposEdNoFormal() {
        return listaTiposEdNoFormal;
    }

    /**
     * @param listaTiposEdNoFormal the listaTiposEdNoFormal to set
     */
    public void setListaTiposEdNoFormal(Map<Long, TipoEdNoFormal> listaTiposEdNoFormal) {
        this.listaTiposEdNoFormal = listaTiposEdNoFormal;
    }

    /**
     * @return the listaIntensidadesHorarias
     */
    public Map<Long, IntensidadHoraria> getListaIntensidadesHorarias() {
        return listaIntensidadesHorarias;
    }

    /**
     * @param listaIntensidadesHorarias the listaIntensidadesHorarias to set
     */
    public void setListaIntensidadesHorarias(Map<Long, IntensidadHoraria> listaIntensidadesHorarias) {
        this.listaIntensidadesHorarias = listaIntensidadesHorarias;
    }
    
    /**
     * @return the listaDominioLenguaExt
     */
    public Map<Long, DominioLenguaExt> getListaDominioLenguaExt() {
        return listaDominioLenguaExt;
    }

    /**
     * @param listaDominioLenguaExt the listaDominioLenguaExt to set
     */
    public void setListaDominioLenguaExt(Map<Long, DominioLenguaExt> listaDominioLenguaExt) {
        this.listaDominioLenguaExt = listaDominioLenguaExt;
    }

    /**
     * @return the listaIdiomas
     */
    public Map<Long, Idioma> getListaIdiomas() {
        return listaIdiomas;
    }

    /**
     * @param listaIdiomas the listaIdiomas to set
     */
    public void setListaIdiomas(Map<Long, Idioma> listaIdiomas) {
        this.listaIdiomas = listaIdiomas;
    }
    
    private Map<Long, Object> consultar(Map listaObjetos, String consulta, String idObjeto, String claseDestino)
    {
        Convertidor convertidor2 = new Convertidor();
        EntityManager em = emf.createEntityManager();
        
        try {
            Query query = em.createNamedQuery(consulta);
            List<Object> lista = query.getResultList();
            for (Object objeto : lista) {
                if ((boolean)convertidor2.invocar(objeto, "getEstado")){
                    listaObjetos.put((Long)convertidor2.invocar(objeto, idObjeto), convertidor2.convertirAModelo(objeto, null, claseDestino));
                }
            }

            return listaObjetos;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorEgresado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    private ArrayList<Integer> consultarAnios()
    {
        listaAnios = new ArrayList<>();
        for (int i = 1990; i <= LocalDate.now().getYear(); i++) {
            listaAnios.add(i);
        }
        return listaAnios;
    }
}