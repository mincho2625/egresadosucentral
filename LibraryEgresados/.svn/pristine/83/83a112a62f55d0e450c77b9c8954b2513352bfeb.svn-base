/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.ItemLista;
import Util.Convertidor;
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
public class ControladorListas {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EgresadosPU");

    /**
     * @return the listaTiposReconocimiento
     */
    public List<ItemLista> consultarTiposReconocimiento() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("TipoReconocimiento.findByEstado", "getIdTipoReconocimiento", parametros);
    }

    /**
     * @return the listaClasesReconocimiento
     */
    public List<ItemLista> consultarClasesReconocimiento() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("ClaseReconocimiento.findByEstado", "getIdClaseReconocimiento", parametros);
    }

    /**
     * @return the listaMeses
     */
    public List<ItemLista> consultarMeses() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("Mes.findByEstado", "getIdMes", parametros, "getMes");
    }

    /**
     * @return the listaEstadosEducacion
     */
    public List<ItemLista> consultarEstadosEducacion() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("EstadoEducacion.findByEstado", "getIdEstadoEducacion", parametros);
    }

    /**
     * @return the listaModalidades
     */
    public List<ItemLista> consultarModalidades() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("Modalidad.findByEstado", "getIdModalidad", parametros);
    }

    /**
     * @return the listaInstituciones
     */
    public List<ItemLista> consultarInstituciones() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("Institucion.findByEstado", "getIdInstitucion", parametros);
    }

    /**
     * @return the listaJornadas
     */
    public List<ItemLista> consultarJornadas() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("Jornada.findByEstado", "getIdJornada", parametros);
    }

    /**
     * @return the listaRedesSociales
     */
    public List<ItemLista> consultarRedesSociales() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("RedSocial.findByEstado", "getIdRedSocial", parametros);
    }

    /**
     * @return the listaTiposContrato
     */
    public List<ItemLista> consultarTiposContrato() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("TipoContrato.findByEstado", "getIdTipoContrato", parametros);
    }
    
    public List<ItemLista> consultarSectores()
    {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("Sector.findByEstado", "getIdSector", parametros);
    }

    /**
     * @param idSector
     * @return the listaSubsectores
     */
    public List<ItemLista> consultarSubsectoresPorSector(long idSector) {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("idSector", idSector);
        parametros.put("estado", true);
        return consultar("Subsector.findByIdSector", "getIdSubsector", parametros);
    }

    /**
     * @return the listaNivelesCargo
     */
    public List<ItemLista> consultarNivelesCargo() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("NivelCargo.findByEstado", "getIdNivelCargo", parametros);
    }

    /**
     * @return the listaAreasEmpresa
     */
    public List<ItemLista> consultarAreasEmpresa() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("AreaEmpresa.findByEstado", "getIdAreaEmpresa", parametros);
    }

    /**
     * @return the listaRangosSalariales
     */
    public List<ItemLista> consultarRangosSalariales() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("RangoSalarial.findByEstado", "getIdRangoSalarial", parametros, "getDescripcion");
    }

    /**
     * @return the listaCargosEquivalentes
     */
    public List<ItemLista> consultarCargosEquivalentes() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("CargoEquivalente.findByEstado", "getIdCargoEquivalente", parametros);
    }
    
    /**
     * @return the listaTiposVivienda
     */
    public List<ItemLista> consultarTiposVivienda() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("TipoVivienda.findByEstado", "getIdTipoVivienda", parametros);
    }

    /**
     * @return the listaTiposTenenciaVivienda
     */
    public List<ItemLista> consultarTiposTenenciaVivienda() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("TipoTenenciaVivienda.findByEstado", "getIdTipoTenenciaVivienda", parametros);
    }

    /**
     * @return the listaEstratos
     */
    public List<ItemLista> consultarEstratos() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("Estrato.findByEstado", "getIdEstrato", parametros);
    }

    /**
     * @return the listaTiposContacto
     */
    public List<ItemLista> consultarTiposContacto() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("TipoContacto.findByEstado", "getIdTipoContacto", parametros);
    }
    
    /**
     * @return the listaTiposContacto
     */
    public List<ItemLista> consultarTiposContactoObligatorio() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        parametros.put("obligatorio", true);
        return consultar("TipoContacto.findByObligatorio", "getIdTipoContacto", parametros);
    }

    /**
     * @return the listaTiposDocumento
     */
    public List<ItemLista> consultarTiposDocumento() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("TipoDocumento.findByEstado", "getIdTipoDocumento", parametros);
    }

    /**
     * @return the listaGruposSanguineos
     */
    public List<ItemLista> consultarGruposSanguineos() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("GrupoSanguineo.findByEstado", "getIdGrupoSanguineo", parametros, "getGrupoSanguineo");
    }

    /**
     * @return the listaGeneros
     */
    public List<ItemLista> consultarGeneros() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("Genero.findByEstado", "getIdGenero", parametros);
    }
    
    public Map<Long, String> consultarMapGeneros() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultarMap("Genero.findByEstado", "getIdGenero", parametros);
    }

    /**
     * @return the listaEstadosCiviles
     */
    public List<ItemLista> consultarEstadosCiviles() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("EstadoCivil.findByEstado", "getIdEstadoCivil", parametros, "getEstadoCivil");
    }
    
    public Map<Long, String> consultarMapEstadosCiviles() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultarMap("EstadoCivil.findByEstado", "getIdEstadoCivil", parametros, "getEstadoCivil");
    }

    /**
     * @return the listaPreguntas
     */
    public List<ItemLista> consultarPreguntas() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("PreguntaSeguridad.findByEstado", "getIdPreguntaSeguridad", parametros, "getPregunta");
    }

    /**
     * @return the listaTiposAsociaciones
     */
    public List<ItemLista> consultarTiposAsociaciones() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("TipoAsociacion.findByEstado", "getIdTipoAsociacion", parametros);
    }
    
    /**
     * @return the listaPaises
     */
    public List<ItemLista> consultarPaises() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("Pais.findByEstado", "getIdPais", parametros);
    }
    
    /**
     * @param idPais
     * @return the listaDepartamentosPorPais
     */
    public List<ItemLista> consultarDepartamentosPorPais(long idPais) {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        parametros.put("idPais", idPais);
        return consultar("Departamento.findByIdPais", "getIdDepartamento", parametros);
    }
    
    /**
     * @param idDepartamento
     * @return the listaCiudades
     */
    public List<ItemLista> consultarCiudadesPorDepartamento(long idDepartamento) {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        parametros.put("idDepartamento", idDepartamento);
        return consultar("Ciudad.findByIdDepartamento", "getIdCiudad", parametros);
    }

    /**
     * @return the listaTiposActividades
     */
    public List<ItemLista> consultarTiposActividades() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("TipoActividad.findByEstado", "getIdTipoActividad", parametros);
    }

    /**
     * @return the listaIntensidadesHorarias
     */
    public List<ItemLista> consultarIntensidadesHorarias() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("IntensidadHoraria.findByEstado", "getIdIntensidadHoraria", parametros);
    }

    /**
     * @return the listaDominioLenguaExt
     */
    public List<ItemLista> consultarDominioLenguaExt() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("DominioLenguaExt.findByEstado", "getIdDominioLenguaExt", parametros, "getDominioLenguaExt");
    }

    /**
     * @return the listaIdiomas
     */
    public List<ItemLista> consultarIdiomas() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("Idioma.findByEstado", "getIdIdioma", parametros);
    }

    /**
     *
     * @return
     */
    public List<ItemLista> consultarNivelesEstudios() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("NivelEstudios.findByEstado", "getIdNivelEstudios", parametros);
    }
    
    /**
     *
     * @return
     */
    public List<ItemLista> consultarNivelesEstudiosFormal() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("formal", true);
        parametros.put("estado", true);
        return consultar("NivelEstudios.findByFormal", "getIdNivelEstudios", parametros);
    }
    
    public List<ItemLista> consultarNivelesEstudiosNoFormal() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("formal", false);
        parametros.put("estado", true);
        return consultar("NivelEstudios.findByFormal", "getIdNivelEstudios", parametros);
    }
    
    /**
     * @return the listaNivelesEstudiosUCentral
     */
    public List<ItemLista> consultarNivelesEstudiosAplicaUCentral() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("NivelEstudios.findByAplicaUCentral", "getIdNivelEstudios", parametros);
    }
    
    public Map<Long, String> consultarMapNivelesEstudiosAplicaUCentral() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultarMap("NivelEstudios.findByAplicaUCentral", "getIdNivelEstudios", parametros);
    }
    
    public List<ItemLista> consultarNivelesEstudiosObligatorioUCentral() { 
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("obligatorioUCentral", true);
        parametros.put("estado", true);
        return consultar("NivelEstudios.findByObligatorioUCentral", "getIdNivelEstudios", parametros);
    }
    
    /**
     *
     * @return
     */
    public List<ItemLista> consultarNivelesEstudiosObligatorioOtrasInst() { 
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("obligatorioOtrasInst", true);
        parametros.put("estado", true);
        return consultar("NivelEstudios.findByObligatorioOtrasInst", "getIdNivelEstudios", parametros);
    }
    
    public List<ItemLista> consultarFacultades() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("Facultad.findByEstado", "getIdFacultad", parametros);
    }
    
    public Map<Long, String> consultarMapFacultades() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultarMap("Facultad.findByEstado", "getIdFacultad", parametros);
    }
    
    /**
     * @param idFacultad
     * @param idNivelEstudios
     * @return the listaProgramas
     */
    public List<ItemLista> consultarProgramasPorFacultadYNivelEstudios(long idFacultad, long idNivelEstudios) {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("idFacultad", idFacultad);
        parametros.put("idNivelEstudios", idNivelEstudios);
        parametros.put("estado", true);
        return consultar("Programa.findByFacultadYNivelEstudios", "getIdPrograma", parametros);
    }
    
    public Map<Long, String> consultarMapProgramasPorListaFacultadYNivelEstudios(List<Long> listaFacultades, 
            List<Long> listaNivelesEstudios) {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("listaFacultades", listaFacultades);
        parametros.put("listaNivelesEstudios", listaNivelesEstudios);
        parametros.put("estado", true);
        return consultarMap("Programa.findByListaFacultadYNivelEstudios", "getIdPrograma", parametros);
    }
    
    public List<ItemLista> consultarAreasEstudiosPorNivelEstudiosNull() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("AreaEstudios.findByIdNivelEstudiosNull", "getIdAreaEstudios", parametros);
    }
    
    public List<ItemLista> consultarAreasEstudiosPorNivelEstudios(long idNivelEstudios) {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("idNivelEstudios", idNivelEstudios);
        parametros.put("estado", true);
        return consultar("AreaEstudios.findByIdNivelEstudios", "getIdAreaEstudios", parametros);
    }

    /**
     * @return the listaOtrasInstituciones
     */
    public List<ItemLista> consultarOtrasInstituciones() {
        HashMap<String, Object> parametros = new HashMap<>();
        // pendiente id ucentral parametrización
        parametros.put("idInstitucion", 1);
        parametros.put("estado", true);
        return consultar("Institucion.findOtras", "getIdInstitucion", parametros);
    }
    
    public List<ItemLista> consultarTiposCampos(){
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("TipoCampo.findByEstado", "getIdTipoCampo", parametros);
    }
    
    public List<ItemLista> consultarPlantillasCorreo() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("estado", true);
        return consultar("PlantillaCorreo.findByEstado", "getIdPlantillaCorreo", parametros);
    }
    
    public ArrayList<Integer> consultarAnios()
    {
        ArrayList<Integer> listaAnios = new ArrayList<>();
        Calendar calendario = Calendar.getInstance(Locale.ROOT);
        int anio = calendario.get(Calendar.YEAR);
        
        for (int i = 1900; i <= anio; i++) {
            listaAnios.add(i);
        }
        return listaAnios;
    }
    
    private List<ItemLista> consultar(String consulta, String idObjeto, Map<String, Object> parametros)
    {
        Convertidor convertidor = new Convertidor();
        EntityManager em = emf.createEntityManager();
        List<ItemLista> listaObjetos = new ArrayList<>();
        
        try {
            Query query = em.createNamedQuery(consulta);
            
            for (Map.Entry<String, Object> entry : parametros.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
            
            List<Object> lista = query.getResultList();
            for(Object objeto: lista)
            {
                ItemLista item = new ItemLista();
                item.setId((Long)convertidor.invocar(objeto, idObjeto));
                item.setNombre((String)convertidor.invocar(objeto, "getNombre"));
                listaObjetos.add(item);
            }

            return listaObjetos;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorListas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    private List<ItemLista> consultar(String consulta, String idObjeto, Map<String, Object> parametros, String nombreObjeto)
    {
        Convertidor convertidor = new Convertidor();
        EntityManager em = emf.createEntityManager();
        List<ItemLista> listaObjetos = new ArrayList<>();
        
        try {
            Query query = em.createNamedQuery(consulta);
            
            for (Map.Entry<String, Object> entry : parametros.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
            
            List<Object> lista = query.getResultList();
            for(Object objeto: lista)
            {
                ItemLista item = new ItemLista();
                item.setId((Long)convertidor.invocar(objeto, idObjeto));
                item.setNombre((String)convertidor.invocar(objeto, nombreObjeto));
                listaObjetos.add(item);
            }

            return listaObjetos;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorListas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    private Map<Long, String> consultarMap(String consulta, String idObjeto, Map<String, Object> parametros)
    {
        Convertidor convertidor = new Convertidor();
        EntityManager em = emf.createEntityManager();
        Map<Long, String> listaObjetos = new HashMap<>();
        
        try {
            Query query = em.createNamedQuery(consulta);
            
            for (Map.Entry<String, Object> entry : parametros.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
            
            List<Object> lista = query.getResultList();
            for(Object objeto: lista) {
                listaObjetos.put((Long)convertidor.invocar(objeto, idObjeto), (String)convertidor.invocar(objeto, "getNombre"));
            }

            return listaObjetos;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorListas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    private Map<Long, String> consultarMap(String consulta, String idObjeto, Map<String, Object> parametros, String nombreObjeto)
    {
        Convertidor convertidor = new Convertidor();
        EntityManager em = emf.createEntityManager();
        Map<Long, String> listaObjetos = new HashMap<>();
        
        try {
            Query query = em.createNamedQuery(consulta);
            
            for (Map.Entry<String, Object> entry : parametros.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
            
            List<Object> lista = query.getResultList();
            for(Object objeto: lista) {
                listaObjetos.put((Long)convertidor.invocar(objeto, idObjeto), (String)convertidor.invocar(objeto, nombreObjeto));
            }

            return listaObjetos;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorListas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}