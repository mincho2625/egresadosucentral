package Controlador;

import Modelo.AreaEstudios;
import Modelo.Ciudad;
import Modelo.Departamento;
import Modelo.EstadoCivil;
import Modelo.EstadoEducacion;
import Modelo.Estrato;
import Modelo.Genero;
import Modelo.GrupoSanguineo;
import Modelo.Institucion;
import Modelo.Jornada;
import Modelo.Mes;
import Modelo.Modalidad;
import Modelo.NivelEstudios;
import Modelo.Pais;
import Modelo.PreguntaSeguridad;
import Modelo.Programa;
import Modelo.RedSocial;
import Modelo.TipoContacto;
import Modelo.TipoDocumento;
import Modelo.TipoTenenciaVivienda;
import Modelo.TipoVivienda;
import Util.ConvertidorObjetos;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author YURY
 * @version 1.0
 * @created 12-jun-2014 06:36:19 a.m.
 */
public class ControladorListas {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebEgresadosPU");
    private final ConvertidorObjetos convertidorObjetos = new ConvertidorObjetos();

    public ArrayList<Ciudad> obtenerCiudades() {
        ArrayList<Ciudad> listaCiudades = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        
        Query query = em.createNamedQuery("Ciudad.findAll");
        List<Persistencia.Ciudad> lista = query.getResultList();
        for (Persistencia.Ciudad c : lista) {
            listaCiudades.add(convertidorObjetos.convertirCiudad(c));
        }

        return listaCiudades;
    }
    
    /**
     *
     * @param idDepartamento
     * @return
     */
    public ArrayList<Ciudad> obtenerCiudadesPorDepartamento(int idDepartamento) {
        ArrayList<Ciudad> listaCiudades = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        
        Query query = em.createNamedQuery("Ciudad.findByIdDepartamento");
        query.setParameter("idDepartamento", em.getReference(Persistencia.Departamento.class, idDepartamento));
        List<Persistencia.Ciudad> lista = query.getResultList();
        for (Persistencia.Ciudad c : lista) {
            listaCiudades.add(convertidorObjetos.convertirCiudad(c));
        }

        return listaCiudades;
    }

    /**
     *
     * @param idPais
     * @return 
     */
    public ArrayList<Departamento> obtenerDepartamentosPorPais(int idPais) {
        ArrayList<Departamento> listaDepartamentos = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Departamento.findByIdPais");
        query.setParameter("idPais", em.getReference(Persistencia.Pais.class, idPais));
        List<Persistencia.Departamento> lista = query.getResultList();
        for (Persistencia.Departamento d: lista) {
            listaDepartamentos.add(convertidorObjetos.convertirDepartamento(d));
        }

        return listaDepartamentos;
    }

    public ArrayList<EstadoCivil> obtenerEstadosCiviles() {
        ArrayList<EstadoCivil> listaEstadosCiviles = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("EstadoCivil.findAll");
        
        List<Persistencia.EstadoCivil> lista = query.getResultList();
        for (Persistencia.EstadoCivil e: lista) {
            listaEstadosCiviles.add(convertidorObjetos.convertirEstadoCivil(e));
        }

        return listaEstadosCiviles;
    }

    public ArrayList<Genero> obtenerGeneros() {
        ArrayList<Genero> listaGeneros = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Genero.findAll");
        
        List<Persistencia.Genero> lista = query.getResultList();
        for (Persistencia.Genero g: lista) {
            listaGeneros.add(convertidorObjetos.convertirGenero(g));
        }

        return listaGeneros;
    }

    public ArrayList<GrupoSanguineo> obtenerGruposSanguineos() {
        ArrayList<GrupoSanguineo> listaGruposSanguineos = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("GrupoSanguineo.findAll");
        
        List<Persistencia.GrupoSanguineo> lista = query.getResultList();
        for (Persistencia.GrupoSanguineo g: lista) {
            listaGruposSanguineos.add(convertidorObjetos.convertirGrupoSanguineo(g));
        }

        return listaGruposSanguineos;
    }

    public ArrayList<Pais> obtenerPaises() {
        ArrayList<Pais> listaPaises = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Pais.findAll");
        
        List<Persistencia.Pais> lista = query.getResultList();
        for (Persistencia.Pais p: lista) {
            listaPaises.add(convertidorObjetos.convertirPais(p));
        }

        return listaPaises;
    }

    public ArrayList<TipoDocumento> obtenerTiposDocumento() {
        ArrayList<TipoDocumento> listaTiposDocumento = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("TipoDocumento.findAll");
        
        List<Persistencia.TipoDocumento> lista = query.getResultList();
        for (Persistencia.TipoDocumento td: lista) {
            listaTiposDocumento.add(convertidorObjetos.convertirTipoDocumento(td));
        }

        return listaTiposDocumento;
    }
    
    public ArrayList<PreguntaSeguridad> obtenerPreguntasSeguridad()
    {
        ArrayList<PreguntaSeguridad> listaPreguntasSeguridad = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("PreguntaSeguridad.findAll");
        
        List<Persistencia.PreguntaSeguridad> lista = query.getResultList();
        for (Persistencia.PreguntaSeguridad ps: lista) {
            listaPreguntasSeguridad.add(convertidorObjetos.convertirPreguntaSeguridad(ps));
        }

        return listaPreguntasSeguridad;
    }
    
    public ArrayList<TipoContacto> obtenerTiposContacto() {
        ArrayList<TipoContacto> listaTiposContacto = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("TipoContacto.findAll");
        
        List<Persistencia.TipoContacto> lista = query.getResultList();
        for (Persistencia.TipoContacto tc: lista) {
            listaTiposContacto.add(convertidorObjetos.convertirTipoContacto(tc));
        }

        return listaTiposContacto;
    }
    
    public ArrayList<RedSocial> consultarRedesSociales()
    {
        ArrayList<RedSocial> listaRedSocial = new ArrayList<>();
        ConvertidorObjetos<Persistencia.RedSocial, Modelo.RedSocial> co = new ConvertidorObjetos<>(Modelo.RedSocial.class.getName());
        
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("RedSocial.findAll");
        
        List<Persistencia.RedSocial> lista = query.getResultList();
        for (Persistencia.RedSocial tc: lista) {
            listaRedSocial.add(co.convertir(tc));
        }
        
        return listaRedSocial;
    }
    
    public ArrayList<TipoVivienda> consultarTiposVivienda()
    {
        ArrayList<TipoVivienda> listaTipoVivienda = new ArrayList<>();
        ConvertidorObjetos<Persistencia.TipoVivienda, Modelo.TipoVivienda> co = new ConvertidorObjetos<>(Modelo.TipoVivienda.class.getName());
        
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("TipoVivienda.findAll");
        
        List<Persistencia.TipoVivienda> lista = query.getResultList();
        for (Persistencia.TipoVivienda tc: lista) {
            listaTipoVivienda.add(co.convertir(tc));
        }
        
        return listaTipoVivienda;
    }
    
    public ArrayList<TipoTenenciaVivienda> consultarTiposTenenciaVivienda()
    {
        ArrayList<TipoTenenciaVivienda> listaTipoTenenciaVivienda = new ArrayList<>();
        ConvertidorObjetos<Persistencia.TipoTenenciaVivienda, Modelo.TipoTenenciaVivienda> co = new ConvertidorObjetos<>(Modelo.TipoTenenciaVivienda.class.getName());
        
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("TipoTenenciaVivienda.findAll");
        
        List<Persistencia.TipoTenenciaVivienda> lista = query.getResultList();
        for (Persistencia.TipoTenenciaVivienda tc: lista) {
            listaTipoTenenciaVivienda.add(co.convertir(tc));
        }
        
        return listaTipoTenenciaVivienda;
    }
    
    public ArrayList<Estrato> consultarEstratos()
    {
        ArrayList<Estrato> listaEstratos = new ArrayList<>();
        ConvertidorObjetos<Persistencia.Estrato, Modelo.Estrato> co = new ConvertidorObjetos<>(Modelo.Estrato.class.getName());
        
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Estrato.findAll");
        
        List<Persistencia.Estrato> lista = query.getResultList();
        for (Persistencia.Estrato tc: lista) {
            listaEstratos.add(co.convertir(tc));
        }
        
        return listaEstratos;
    }
    
    private ArrayList<Mes> consultarMeses()
    {
        ArrayList<Mes> listaMeses = new ArrayList<>();
        return listaMeses;
    }
    
    private ArrayList<EstadoEducacion> consultarEstadosEducacion()
    {
        ArrayList<EstadoEducacion> listaEstadosEducacion = new ArrayList<>();
        return listaEstadosEducacion;
    }
    
    private ArrayList<AreaEstudios> consultarAreasEstudios()
    {
        ArrayList<AreaEstudios> lista = new ArrayList<>();
        return lista;
    }
    
    private ArrayList<Modalidad> consultarModalidades()
    {
        ArrayList<Modalidad> lista = new ArrayList<>();
        return lista;
    }
    
    private ArrayList<Institucion> consultarInstituciones()
    {
        ArrayList<Institucion> lista = new ArrayList<>();
        return lista;
    }
    
    private ArrayList<Programa> consultarProgramas()
    {
        ArrayList<Programa> lista = new ArrayList<>();
        return lista;
    }
    
    private ArrayList<Jornada> consultarJornadas()
    {
        ArrayList<Jornada> lista = new ArrayList<>();
        return lista;
    }
    
    private ArrayList<NivelEstudios> consultarNivelesEstudios()
    {
        ArrayList<NivelEstudios> lista = new ArrayList<>();
        return lista;
    }
}