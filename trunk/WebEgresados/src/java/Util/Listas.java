/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

import Controlador.ControladorEgresado;
import Modelo.AreaEstudios;
import Modelo.Ciudad;
import Modelo.ClaseReconocimiento;
import Modelo.EstadoEducacion;
import Modelo.Institucion;
import Modelo.Jornada;
import Modelo.Mes;
import Modelo.Modalidad;
import Modelo.NivelEstudios;
import Modelo.Programa;
import Modelo.TipoReconocimiento;
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
    private ArrayList<Integer> listaAnios;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebEgresadosPU");

    private Listas()
    {
        this.listaCiudades = new HashMap<>();
        consultar(this.listaCiudades, "Ciudad.findAll", "getIdCiudad", Modelo.Ciudad.class.getName());
        this.listaClasesReconocimiento = new HashMap<>();
        consultar(this.listaClasesReconocimiento, "ClaseReconocimiento.findAll", "getIdClaseReconocimiento", Modelo.ClaseReconocimiento.class.getName());
        this.listaTiposReconocimiento = new HashMap<>();
        consultar(this.listaTiposReconocimiento, "TipoReconocimiento.findAll", "getIdTipoReconocimiento", Modelo.TipoReconocimiento.class.getName());
        //Pendiente llenar listas
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
    
    private Map<Long, Object> consultar(Map listaObjetos, String consulta, String idObjeto, String claseDestino)
    {
        Convertidor convertidor2 = new Convertidor();
        EntityManager em = emf.createEntityManager();
        
        try {
            Query query = em.createNamedQuery(consulta);
            List<Object> lista = query.getResultList();
            for (Object objeto : lista) {
                if ((boolean)convertidor2.invocar(objeto, "getEstado")){
                    listaObjetos.put((Long)convertidor2.invocar(objeto, idObjeto), convertidor2.convertirAModelo(objeto, claseDestino));
                }
            }

            return listaObjetos;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorEgresado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ArrayList<Integer> consultarAnios()
    {
        listaAnios = new ArrayList<>();
        for (int i = 1990; i < LocalDate.now().getYear(); i++) {
            listaAnios.add(i);
        }
        return listaAnios;
    }
}