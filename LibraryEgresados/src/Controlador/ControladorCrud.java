/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Encuesta;
import Modelo.TipoRespuesta;
import Util.Convertidor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
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
public class ControladorCrud {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EgresadosPU");
    private final EntityManager em;
    private final String paquetePersistencia = "Persistencia.";

    public ControladorCrud() {
        em = emf.createEntityManager();
    }

    public Object consultar(String consulta, String clase, String parametro, long idObjeto) {
        Convertidor convertidor = new Convertidor();
        try {
            Query query = em.createNamedQuery(consulta);
            query.setParameter(parametro, idObjeto);
            Object objeto = query.getSingleResult();
            return convertidor.convertirAModelo(objeto, null, clase);
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Object consultar(String consulta, String clase, String parametro, long idObjeto, String claseBase) {
        Convertidor convertidor = new Convertidor();
        try {
            Query query = em.createNamedQuery(consulta);
            query.setParameter(parametro, idObjeto);
            Object objeto = query.getSingleResult();
            Object concreto = convertidor.invocar(objeto, "get" + claseBase);
            return convertidor.convertirAModelo(objeto, concreto, clase);
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Object> consultarLista(String consulta, String clase) {
        Convertidor convertidor = new Convertidor();
        List<Object> listaObjetos = new ArrayList<>();

        try {
            Query query = em.createNamedQuery(consulta);
            List<Object> lista = query.getResultList();
            for (Object objeto : lista) {
                listaObjetos.add(convertidor.convertirAModelo(objeto, null, clase));
            }
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorCrud.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaObjetos;
    }

    public List<Object> consultarLista(String consulta, String clase, Map<String, Object> parametros) {
        Convertidor convertidor = new Convertidor();
        List<Object> listaObjetos = new ArrayList<>();

        try {
            Query query = em.createNamedQuery(consulta);
            query.setParameter("estado", true);

            if (parametros != null) {
                for (Map.Entry<String, Object> entry : parametros.entrySet()) {
                    query.setParameter(entry.getKey(), entry.getValue());
                }
            }

            List<Object> lista = query.getResultList();
            for (Object objeto : lista) {
                listaObjetos.add(convertidor.convertirAModelo(objeto, null, clase));
            }
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorCrud.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaObjetos;
    }

    public List<Object> consultarListaEncuesta(String consulta, String clase, Map<String, Object> parametros) {
        Convertidor convertidor = new Convertidor();
        List<Object> listaObjetos = new ArrayList<>();

        try {
            Query query = em.createNamedQuery(consulta);

            if (parametros != null) {
                for (Map.Entry<String, Object> entry : parametros.entrySet()) {
                    query.setParameter(entry.getKey(), entry.getValue());
                }
            }

            List<Object> lista = query.getResultList();
            for (Object objeto : lista) {
                listaObjetos.add(convertidor.convertirAModelo(objeto, null, clase));
            }
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorCrud.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaObjetos;
    }

    public List<Object> consultarLista(String consulta, String clase, Map<String, Object> parametros, String claseBase) {
        Convertidor convertidor = new Convertidor();
        List<Object> listaObjetos = new ArrayList<>();

        try {
            Query query = em.createNamedQuery(consulta);
            query.setParameter("estado", true);
            if (parametros != null) {
                for (Map.Entry<String, Object> entry : parametros.entrySet()) {
                    query.setParameter(entry.getKey(), entry.getValue());
                }
            }

            List<Object> lista = query.getResultList();

            for (Object objeto : lista) {
                System.out.println("jajajajajaaj1 "+claseBase);
                Object concreto = convertidor.invocar(objeto, "get" + claseBase);
                System.out.println("jajajajajaaj2");
                Object item = convertidor.convertirAModelo(objeto, concreto, clase);
                System.out.println("jajajajajaaj3");
                listaObjetos.add(item);
            }

            return listaObjetos;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorCrud.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public boolean actualizar(Object objeto, String clase, String idObjeto) {
        Convertidor convertidor = new Convertidor();
        if (objeto == null) {
            return false;
        }
        em.getTransaction().begin();
        System.out.println("aaaaaaaa "+objeto);
        Object destino = convertidor.convertirAPersistencia(objeto, paquetePersistencia + clase, idObjeto, em);
        System.out.println("aaaaaaaa111111111111");
        em.persist(destino);
        em.getTransaction().commit();
        return true;
    }

    public boolean actualizar(Object objeto, String clasePersistencia, String idObjeto,
            String claseBasePersistencia) {
        try {
            Convertidor convertidor = new Convertidor();
            if (objeto == null) {
                return false;
            }

            em.getTransaction().begin();
            Object base = convertidor.convertirAPersistencia(objeto, paquetePersistencia + claseBasePersistencia, idObjeto, em);
            Object concreto = convertidor.convertirAPersistencia(objeto, paquetePersistencia + clasePersistencia, idObjeto, em);

            Method insertar = concreto.getClass().getMethod("set" + claseBasePersistencia, base.getClass());
            insertar.invoke(concreto, base);

            em.persist(base);
            em.persist(concreto);
            em.getTransaction().commit();

            return true;
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(ControladorCrud.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean borrar(String clase, long idObjeto) {
        try {
            em.getTransaction().begin();
            Object objeto = em.getReference(Class.forName(paquetePersistencia + clase), idObjeto);
            Method borrar = objeto.getClass().getDeclaredMethod("setEstado", Boolean.TYPE);
            borrar.invoke(objeto, false);
            em.persist(objeto);
            em.getTransaction().commit();

            return true;
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(ControladorCrud.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public Long consultarPregunta(String idTipoRespuest) {
        try {
            EntityManager em = emf.createEntityManager();
            Query query = em.createNamedQuery("TipoRespuesta.findByIdTipoRespuesta");
            query.setParameter("idTipoRespuesta", Long.parseLong(idTipoRespuest));
            Object result = query.getSingleResult();
            if (result != null) {
                Persistencia.TipoRespuesta u = (Persistencia.TipoRespuesta) result;
                return u.getIdTipoRespuesta();
            }
        } catch (Exception ex) {
            return null;
        }
        return null;
    }

    public Long consultarIdEncuesta(String idEncuesta) {
        try {
            EntityManager em = emf.createEntityManager();
            Query query = em.createNamedQuery("Encuesta.findByIdEncuesta");
            query.setParameter("idEncuesta", Long.parseLong(idEncuesta));
            Object result = query.getSingleResult();
            if (result != null) {
                Persistencia.Encuesta u = (Persistencia.Encuesta) result;
                return u.getIdEncuesta();
            }
        } catch (Exception ex) {
            return null;
        }
        return null;
    }   
}
