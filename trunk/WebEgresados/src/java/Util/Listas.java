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
import Modelo.ItemLista;
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
import Modelo.TipoActividad;
import Modelo.TipoAsociacion;
import Modelo.TipoContacto;
import Modelo.TipoContrato;
import Modelo.TipoDocumento;
import Modelo.TipoReconocimiento;
import Modelo.TipoTenenciaVivienda;
import Modelo.TipoVivienda;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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
public class Listas {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebEgresadosPU");

    /**
     * @return the listaTiposReconocimiento
     */
    public Map<Long, TipoReconocimiento> consultarTiposReconocimiento() {
        Map<Long, TipoReconocimiento> listaTiposReconocimiento = new HashMap<>();
        consultar(listaTiposReconocimiento, "TipoReconocimiento.findAll", "getIdTipoReconocimiento", Modelo.TipoReconocimiento.class.getName());
        return listaTiposReconocimiento;
    }

    /**
     * @return the listaClasesReconocimiento
     */
    public Map<Long, ClaseReconocimiento> consultarClasesReconocimiento() {
        Map<Long, ClaseReconocimiento> listaClasesReconocimiento = new HashMap<>();
        consultar(listaClasesReconocimiento, "ClaseReconocimiento.findAll", "getIdClaseReconocimiento", Modelo.ClaseReconocimiento.class.getName());
        return listaClasesReconocimiento;
    }

    /**
     * @return the listaMeses
     */
    public Map<Long, Mes> consultarMeses() {
        Map<Long, Mes> listaMeses = new HashMap<>();
        consultar(listaMeses, "Mes.findAll", "getIdMes", Modelo.Mes.class.getName());
        return listaMeses;
    }

    /**
     * @return the listaEstadosEducacion
     */
    public Map<Long, EstadoEducacion> consultarEstadosEducacion() {
        Map<Long, EstadoEducacion> listaEstadosEducacion = new HashMap<>();
        consultar(listaEstadosEducacion, "EstadoEducacion.findAll", "getIdEstadoEducacion", Modelo.EstadoEducacion.class.getName());
        return listaEstadosEducacion;
    }

    /**
     * @return the listaAreasEstudios
     */
    public Map<Long, AreaEstudios> consultarAreasEstudios() {
        Map<Long, AreaEstudios> listaAreasEstudios = new HashMap<>();
        consultar(listaAreasEstudios, "AreaEstudios.findAll", "getIdAreaEstudios", Modelo.AreaEstudios.class.getName());
        return listaAreasEstudios;
    }

    /**
     * @return the listaModalidades
     */
    public Map<Long, Modalidad> consultarModalidades() {
        Map<Long, Modalidad> listaModalidades = new HashMap<>();
        consultar(listaModalidades, "Modalidad.findAll", "getIdModalidad", Modelo.Modalidad.class.getName());
        return listaModalidades;
    }

    /**
     * @return the listaInstituciones
     */
    public Map<Long, Institucion> consultarInstituciones() {
        Map<Long, Institucion> listaInstituciones = new HashMap<>();
        consultar(listaInstituciones, "Institucion.findAll", "getIdInstitucion", Modelo.Institucion.class.getName());
        return listaInstituciones;
    }

    /**
     * @return the listaJornadas
     */
    public Map<Long, Jornada> consultarJornadas() {
        Map<Long, Jornada> listaJornadas = new HashMap<>();
        consultar(listaJornadas, "Jornada.findAll", "getIdJornada", Modelo.Jornada.class.getName());
        return listaJornadas;
    }

    /**
     * @return the listaProgramas
     */
    public Map<Long, Programa> consultarProgramas() {
        Map<Long, Programa> listaProgramas = new HashMap<>();
        consultar(listaProgramas, "Programa.findAll", "getIdPrograma", Modelo.Programa.class.getName());
        return listaProgramas;
    }

    /**
     * @return the listaNivelesEstudios
     */
    public Map<Long, NivelEstudios> consultarNivelesEstudios() {
        Map<Long, NivelEstudios> listaNivelesEstudios = new HashMap<>();
        consultar(listaNivelesEstudios, "NivelEstudios.findAll", "getIdNivelEstudios", Modelo.NivelEstudios.class.getName());
        return listaNivelesEstudios;
    }

    /**
     * @return the listaRedesSociales
     */
    public Map<Long, RedSocial> consultarRedesSociales() {
        Map<Long, RedSocial> listaRedesSociales = new HashMap<>();
        consultar(listaRedesSociales, "RedSocial.findAll", "getIdRedSocial", Modelo.RedSocial.class.getName());
        return listaRedesSociales;
    }

    /**
     * @return the listaTiposContrato
     */
    public Map<Long, TipoContrato> consultarTiposContrato() {
        Map<Long, TipoContrato> listaTiposContrato = new HashMap<>();
        consultar(listaTiposContrato, "TipoContrato.findAll", "getIdTipoContrato", Modelo.TipoContrato.class.getName());
        return listaTiposContrato;
    }

    /**
     * @return the listaSubsectores
     */
    public Map<Long, Subsector> consultarSubsectores() {
        Map<Long, Subsector> listaSubsectores = new HashMap<>();
        consultar(listaSubsectores, "Subsector.findAll", "getIdSubsector", Modelo.Subsector.class.getName());
        return listaSubsectores;
    }

    /**
     * @return the listaNivelesCargo
     */
    public Map<Long, NivelCargo> consultarNivelesCargo() {
        Map<Long, NivelCargo> listaNivelesCargo = new HashMap<>();
        consultar(listaNivelesCargo, "NivelCargo.findAll", "getIdNivelCargo", Modelo.NivelCargo.class.getName());
        return listaNivelesCargo;
    }

    /**
     * @return the listaAreasEmpresa
     */
    public Map<Long, AreaEmpresa> consultarAreasEmpresa() {
        Map<Long, AreaEmpresa> listaAreasEmpresa = new HashMap<>();
        consultar(listaAreasEmpresa, "AreaEmpresa.findAll", "getIdAreaEmpresa", Modelo.AreaEmpresa.class.getName());
        return listaAreasEmpresa;
    }

    /**
     * @return the listaRangosSalariales
     */
    public Map<Long, RangoSalarial> consultarRangosSalariales() {
        Map<Long, RangoSalarial> listaRangosSalariales = new HashMap<>();
        consultar(listaRangosSalariales, "RangoSalarial.findAll", "getIdRangoSalarial", Modelo.RangoSalarial.class.getName());
        return listaRangosSalariales;
    }

    /**
     * @return the listaCargosEquivalentes
     */
    public Map<Long, CargoEquivalente> consultarCargosEquivalentes() {
        Map<Long, CargoEquivalente> listaCargosEquivalentes = new HashMap<>();
        consultar(listaCargosEquivalentes, "CargoEquivalente.findAll", "getIdCargoEquivalente", Modelo.CargoEquivalente.class.getName());
        return listaCargosEquivalentes;
    }
    
    /**
     * @return the listaTiposVivienda
     */
    public Map<Long, TipoVivienda> consultarTiposVivienda() {
        Map<Long, TipoVivienda> listaTiposVivienda = new HashMap<>();
        consultar(listaTiposVivienda, "TipoVivienda.findAll", "getIdTipoVivienda", Modelo.TipoVivienda.class.getName());
        return listaTiposVivienda;
    }

    /**
     * @return the listaTiposTenenciaVivienda
     */
    public Map<Long, TipoTenenciaVivienda> consultarTiposTenenciaVivienda() {
        Map<Long, TipoTenenciaVivienda> listaTiposTenenciaVivienda = new HashMap<>();
        consultar(listaTiposTenenciaVivienda, "TipoTenenciaVivienda.findAll", "getIdTipoTenenciaVivienda", Modelo.TipoTenenciaVivienda.class.getName());
        return listaTiposTenenciaVivienda;
    }

    /**
     * @return the listaEstratos
     */
    public Map<Long, Estrato> consultarEstratos() {
        Map<Long, Estrato> listaEstratos = new HashMap<>();
        consultar(listaEstratos, "Estrato.findAll", "getIdEstrato", Modelo.Estrato.class.getName());
        return listaEstratos;
    }

    /**
     * @return the listaTiposContacto
     */
    public Map<Long, TipoContacto> consultarTiposContacto() {
        Map<Long, TipoContacto> listaTiposContacto = new HashMap<>();
        consultar(listaTiposContacto, "TipoContacto.findAll", "getIdTipoContacto", Modelo.TipoContacto.class.getName());
        return listaTiposContacto;
    }

    /**
     * @return the listaTiposDocumento
     */
    public Map<Long, TipoDocumento> consultarTiposDocumento() {
        Map<Long, TipoDocumento> listaTiposDocumento = new HashMap<>();
        consultar(listaTiposDocumento, "TipoDocumento.findAll", "getIdTipoDocumento", Modelo.TipoDocumento.class.getName());
        return listaTiposDocumento;
    }

    /**
     * @return the listaGruposSanguineos
     */
    public Map<Long, GrupoSanguineo> consultarGruposSanguineos() {
        Map<Long, GrupoSanguineo> listaGruposSanguineos = new HashMap<>();
        consultar(listaGruposSanguineos, "GrupoSanguineo.findAll", "getIdGrupoSanguineo", Modelo.GrupoSanguineo.class.getName());
        return listaGruposSanguineos;
    }

    /**
     * @return the listaGeneros
     */
    public Map<Long, Genero> consultarGeneros() {
        Map<Long, Genero> listaGeneros = new HashMap<>();
        consultar(listaGeneros, "Genero.findAll", "getIdGenero", Modelo.Genero.class.getName());
        return listaGeneros;
    }

    /**
     * @return the listaEstadosCiviles
     */
    public Map<Long, EstadoCivil> consultarEstadosCiviles() {
        Map<Long, EstadoCivil> listaEstadosCiviles = new HashMap<>();
        consultar(listaEstadosCiviles, "EstadoCivil.findAll", "getIdEstadoCivil", Modelo.EstadoCivil.class.getName());
        return listaEstadosCiviles;
    }

    /**
     * @return the listaPreguntas
     */
    public Map<Long, PreguntaSeguridad> consultarPreguntas() {
        Map<Long, PreguntaSeguridad> listaPreguntas = new HashMap<>();
        consultar(listaPreguntas, "PreguntaSeguridad.findAll", "getIdPreguntaSeguridad", Modelo.PreguntaSeguridad.class.getName());
        return listaPreguntas;
    }

    /**
     * @return the listaTiposAsociaciones
     */
    public Map<Long, TipoAsociacion> consultarTiposAsociaciones() {
        Map<Long, TipoAsociacion> listaTiposAsociaciones = new HashMap<>();
        consultar(listaTiposAsociaciones, "TipoAsociacion.findAll", "getIdTipoAsociacion", Modelo.TipoAsociacion.class.getName());
        return listaTiposAsociaciones;
    }
    
    /**
     * @return the listaPaises
     */
    public Map<Long, Pais> consultarPaises() {
        Map<Long, Pais> listaPaises = new HashMap<>();
        consultar(listaPaises, "Pais.findAll", "getIdPais", Modelo.Pais.class.getName());
        return listaPaises;
    }
    
    /**
     * @return the listaPaises
     */
    public List<ItemLista> consultarNombresPaises() {
        return consultar("Pais.findAll", "getIdPais");
    }
    
    /**
     * @param idPais
     * @return the listaDepartamentosPorPais
     */
    public List<ItemLista> consultarDepartamentosPorPais(long idPais) {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("idPais", idPais);
        return consultar("Departamento.findByIdPais", "getIdDepartamento", parametros);
    }
    
    /**
     * @param idDepartamento
     * @return the listaCiudades
     */
    public List<ItemLista> consultarCiudadesPorDepartamento(long idDepartamento) {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("idDepartamento", idDepartamento);
        return consultar("Ciudad.findByIdDepartamento", "getIdCiudad", parametros);
    }

    /**
     * @return the listaTiposActividades
     */
    public Map<Long,TipoActividad> consultarTiposActividades() {
        Map<Long, TipoActividad> listaTiposActividades = new HashMap<>();
        consultar(listaTiposActividades, "TipoActividad.findAll", "getIdTipoActividad", Modelo.TipoActividad.class.getName());
        return listaTiposActividades;
    }

    /**
     * @return the listaIntensidadesHorarias
     */
    public Map<Long, IntensidadHoraria> consultarIntensidadesHorarias() {
        Map<Long, IntensidadHoraria> listaIntensidadesHorarias = new HashMap<>();
        consultar(listaIntensidadesHorarias, "IntensidadHoraria.findAll", "getIdIntensidadHoraria", Modelo.IntensidadHoraria.class.getName());
        return listaIntensidadesHorarias;
    }

    /**
     * @return the listaDominioLenguaExt
     */
    public Map<Long, DominioLenguaExt> consultarDominioLenguaExt() {
        Map<Long, DominioLenguaExt> listaDominioLenguaExt = new HashMap<>();
        consultar(listaDominioLenguaExt, "DominioLenguaExt.findAll", "getIdDominioLenguaExt", Modelo.DominioLenguaExt.class.getName());
        return listaDominioLenguaExt;
    }

    /**
     * @return the listaIdiomas
     */
    public Map<Long, Idioma> consultarIdiomas() {
        Map<Long, Idioma> listaIdiomas = new HashMap<>();
        consultar(listaIdiomas, "Idioma.findAll", "getIdIdioma", Modelo.Idioma.class.getName());
        return listaIdiomas;
    }

    /**
     * @return the listaNivelesEstudiosUCentral
     */
    public Map<Long, NivelEstudios> consultarNivelesEstudiosUCentral() {
        Map<Long, NivelEstudios> listaNivelesEstudiosUCentral = new HashMap<>();
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("aplicaUCentral", true);
        consultar(listaNivelesEstudiosUCentral, "NivelEstudios.findByAplicaUCentral", "getIdNivelEstudios", Modelo.NivelEstudios.class.getName(), parametros);
        return listaNivelesEstudiosUCentral;
    }

    /**
     * @return the listaOtrasInstituciones
     */
    public Map<Long, Institucion> consultarOtrasInstituciones() {
        Map<Long, Institucion> listaOtrasInstituciones = new HashMap<>();
        HashMap<String, Object> parametros = new HashMap<>();
        // Configuración: Universidad Central
        parametros.put("idInstitucion", 1);
        consultar(listaOtrasInstituciones, "Institucion.findOtras", "getIdInstitucion", Modelo.Institucion.class.getName(), parametros);
        return listaOtrasInstituciones;
    }
    
    public ArrayList<Integer> consultarAnios()
    {
        ArrayList<Integer> listaAnios = new ArrayList<>();
        Calendar calendario = Calendar.getInstance(Locale.ROOT);
        for (int i = calendario.getMaximum(Calendar.YEAR); i <= calendario.getMinimum(Calendar.YEAR); i++) {
            listaAnios.add(i);
        }
        return listaAnios;
    }
    
    private List<ItemLista> consultar(String consulta, String idObjeto, Map<String, Object> parametros)
    {
        Convertidor convertidor = new Convertidor();
        EntityManager em = emf.createEntityManager();
        List<ItemLista> listaObjetos = new ArrayList<ItemLista>();
        
        try {
            Query query = em.createNamedQuery(consulta);
            
            for (Map.Entry<String, Object> entry : parametros.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
            
            List<Object> lista = query.getResultList();
            for(Object objeto: lista)
            {
                if ((boolean)convertidor.invocar(objeto, "getEstado")) {
                    ItemLista item = new ItemLista();
                    item.setId((Long)convertidor.invocar(objeto, idObjeto));
                    item.setNombre((String)convertidor.invocar(objeto, "getNombre"));
                    listaObjetos.add(item);
                }
            }

            return listaObjetos;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorEgresado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    private List<ItemLista> consultar(String consulta, String idObjeto)
    {
        Convertidor convertidor = new Convertidor();
        EntityManager em = emf.createEntityManager();
        List<ItemLista> listaObjetos = new ArrayList<>();
        
        try {
            Query query = em.createNamedQuery(consulta);            
            List<Object> lista = query.getResultList();
            for(Object objeto: lista)
            {
                if ((boolean)convertidor.invocar(objeto, "getEstado")) {
                    ItemLista item = new ItemLista();
                    item.setId((Long)convertidor.invocar(objeto, idObjeto));
                    item.setNombre((String)convertidor.invocar(objeto, "getNombre"));
                    listaObjetos.add(item);
                }
            }

            return listaObjetos;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorEgresado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    private Map<Long, String> consultar(Map listaObjetos, String consulta, String idObjeto)
    {
        Convertidor convertidor = new Convertidor();
        EntityManager em = emf.createEntityManager();
        
        try {
            Query query = em.createNamedQuery(consulta);
            List<Object> lista = query.getResultList();
            for(Object objeto: lista)
            {
                if ((boolean)convertidor.invocar(objeto, "getEstado")) {
                    listaObjetos.put((Long)convertidor.invocar(objeto, idObjeto), (String)convertidor.invocar(objeto, "nombre"));
                }
            }

            return listaObjetos;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorEgresado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    private Map<Long, Object> consultar(Map listaObjetos, String consulta, String idObjeto, String claseDestino)
    {
        Convertidor convertidor = new Convertidor();
        EntityManager em = emf.createEntityManager();
        
        try {
            Query query = em.createNamedQuery(consulta);
            List<Object> lista = query.getResultList();
            for(Object objeto: lista)
            {
                if ((boolean)convertidor.invocar(objeto, "getEstado")) {
                    listaObjetos.put((Long)convertidor.invocar(objeto, idObjeto), convertidor.convertirAModelo(objeto, null, claseDestino));
                }
            }

            return listaObjetos;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorEgresado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    private Map<Long, Object> consultar(Map listaObjetos, String consulta, String idObjeto, String claseDestino, Map<String, Object> parametros)
    {
        Convertidor convertidor = new Convertidor();
        EntityManager em = emf.createEntityManager();
        
        try {
            Query query = em.createNamedQuery(consulta);
            
            for (Map.Entry<String, Object> entry : parametros.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
            
            List<Object> lista = query.getResultList();
            for(Object objeto: lista)
            {
                if ((boolean)convertidor.invocar(objeto, "getEstado"))
                {
                    listaObjetos.put((Long)convertidor.invocar(objeto, idObjeto), convertidor.convertirAModelo(objeto, null, claseDestino));
                }
            }

            return listaObjetos;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorEgresado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}