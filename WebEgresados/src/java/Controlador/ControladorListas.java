package Controlador;

import Modelo.TipoDocumento;
import Modelo.GrupoSanguineo;
import Modelo.EstadoCivil;
import Modelo.Ciudad;
import Modelo.Departamento;
import Modelo.Genero;
import Modelo.Pais;
import Util.ConvertidosObjetos;
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
    private final ConvertidosObjetos convertidosObjetos = new ConvertidosObjetos();

    /**
     *
     * @param idDepartamento
     * @return
     */
    public List<Ciudad> obtenerCiudadesPorDepartamento(int idDepartamento) {
        List<Ciudad> listaCiudades = new ArrayList<Ciudad>();

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Ciudad.findByIdDepartamento");
        query.setParameter("idDepartamento", idDepartamento);
        List<Persistencia.Ciudad> lista = query.getResultList();
        for (Persistencia.Ciudad c : lista) {
            listaCiudades.add(convertidosObjetos.convertirCiudad(c));
        }

        return listaCiudades;
    }

    /**
     *
     * @param idPais
     * @return 
     */
    public List<Departamento> obtenerDepartamentosPorPais(int idPais) {
        List<Departamento> listaDepartamentos = new ArrayList<Departamento>();

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Pais.findByIdPais");
        query.setParameter("idPais", idPais);
        List<Persistencia.Departamento> lista = query.getResultList();
        for (Persistencia.Departamento d: lista) {
            listaDepartamentos.add(convertidosObjetos.convertirDepartamento(d));
        }

        return listaDepartamentos;
    }

    public List<EstadoCivil> obtenerEstadosCiviles() {
        List<EstadoCivil> listaEstadosCiviles = new ArrayList<EstadoCivil>();

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("EstadoCivil.findAll");
        
        List<Persistencia.EstadoCivil> lista = query.getResultList();
        for (Persistencia.EstadoCivil e: lista) {
            listaEstadosCiviles.add(convertidosObjetos.convertirEstadoCivil(e));
        }

        return listaEstadosCiviles;
    }

    public List<Genero> obtenerGeneros() {
        List<Genero> listaGeneros = new ArrayList<Genero>();

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Genero.findAll");
        
        List<Persistencia.Genero> lista = query.getResultList();
        for (Persistencia.Genero g: lista) {
            listaGeneros.add(convertidosObjetos.convertirGenero(g));
        }

        return listaGeneros;
    }

    public List<GrupoSanguineo> obtenerGruposSanguineos() {
        List<GrupoSanguineo> listaGruposSanguineos = new ArrayList<GrupoSanguineo>();

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("GrupoSanguineo.findAll");
        
        List<Persistencia.GrupoSanguineo> lista = query.getResultList();
        for (Persistencia.GrupoSanguineo g: lista) {
            listaGruposSanguineos.add(convertidosObjetos.convertirGrupoSanguineo(g));
        }

        return listaGruposSanguineos;
    }

    public ArrayList<Pais> obtenerPaises() {
        ArrayList<Pais> listaPaises = new ArrayList<Pais>();

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Pais.findAll");
        
        List<Persistencia.Pais> lista = query.getResultList();
        for (Persistencia.Pais p: lista) {
            listaPaises.add(convertidosObjetos.convertirPais(p));
        }

        return listaPaises;
    }

    public List<TipoDocumento> obtenerTiposDocumento() {
        List<TipoDocumento> listaTiposDocumento = new ArrayList<TipoDocumento>();

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("TipoDocumento.findAll");
        
        List<Persistencia.TipoDocumento> lista = query.getResultList();
        for (Persistencia.TipoDocumento td: lista) {
            listaTiposDocumento.add(convertidosObjetos.convertirTipoDocumento(td));
        }

        return listaTiposDocumento;
    }

}