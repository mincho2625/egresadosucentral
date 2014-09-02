package Controlador;

import Modelo.Egresado;
import Util.Convertidor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author YURY
 * @version 1.0
 * @created 12-jun-2014 06:36:19 a.m.
 */
public class ControladorEgresado {

    private String nombreUsuario;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebEgresadosPU");
    private EntityManager em;
    private Persistencia.Egresado e;
    
    public ControladorEgresado()
    {
        em = emf.createEntityManager();
    }

    public ControladorEgresado(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        em = emf.createEntityManager();
        
        Query query = em.createNamedQuery("Egresado.findByNombreUsuario");
        query.setParameter("nombreUsuario", nombreUsuario);
        e = (Persistencia.Egresado) query.getSingleResult();
    }
    
    public Egresado consultar()
    {
        Convertidor convertidor = new Convertidor();
        Egresado egresado = (Egresado)convertidor.convertirAModelo(e, e.getIdUsuario(), Modelo.Egresado.class.getName());
        return egresado;
    }

    public Map<Long, Object> consultar(String lista, String idObjeto, String claseDestino)
    {
        Convertidor convertidor = new Convertidor();
        
        try {
            Map<Long, Object> listaObjetos = new HashMap<>();
            
            Collection<Object> coleccion = (Collection)convertidor.invocar(e,lista);
            for (Object objeto : coleccion) {
                if ((boolean)convertidor.invocar(objeto, "getEstado")){
                    listaObjetos.put((Long)convertidor.invocar(objeto, idObjeto), convertidor.convertirAModelo(objeto, null, claseDestino));
                }
            }
            
            return listaObjetos;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorEgresado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public Map<Long, Object> consultar(String lista, String idObjeto, String claseDestino, String claseBase)
    {
        Convertidor convertidor2 = new Convertidor();
        
        try {
            Map<Long, Object> listaObjetos = new HashMap<>();
            
            Collection<Object> coleccion = (Collection)convertidor2.invocar(e,lista);
            for (Object objeto : coleccion) {
                if ((boolean)convertidor2.invocar(objeto, "getEstado")){
                    Object concreto = convertidor2.invocar(objeto, "get"+claseBase);
                    Object item = convertidor2.convertirAModelo(objeto, concreto, claseDestino);
                    listaObjetos.put((Long)convertidor2.invocar(concreto, idObjeto), item);
                }
            }
            
            return listaObjetos;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorEgresado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public boolean actualizar(Egresado egresado) {
        Convertidor convertidor = new Convertidor();
        if (egresado == null) {
            return false;
        }

        em.getTransaction().begin();
        e = (Persistencia.Egresado) convertidor.convertirAPersistencia(egresado, Persistencia.Egresado.class.getName(), "getIdEgresado", em);
        Persistencia.Usuario u = (Persistencia.Usuario) convertidor.convertirAPersistencia(egresado, Persistencia.Usuario.class.getName(), "getIdUsuario", em);
        e.setIdUsuario(u);

        em.persist(e);
        em.getTransaction().commit();

        return true;
    }

    public boolean actualizar(Object objeto, String claseDestino, String idObjeto)
    {
        try {
            if (objeto == null)
                return false;
            
            em.getTransaction().begin();
            Convertidor convertidor2 = new Convertidor();
            Object destino = convertidor2.convertirAPersistencia(objeto, claseDestino, idObjeto, em);
            
            Method insertarEgresado = destino.getClass().getMethod("setIdEgresado", e.getClass());
            insertarEgresado.invoke(destino, e);
            
            em.persist(destino);
            em.getTransaction().commit();
            return true;
        } catch (SecurityException | IllegalArgumentException | NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(ControladorEgresado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean actualizar(Object objeto, String claseDestino, String idObjeto, String claseBase, String setClaseBase)
    {
        try {
            if (objeto == null)
                return false;
            
            em.getTransaction().begin();
            Convertidor convertidor = new Convertidor();
            Object base = convertidor.convertirAPersistencia(objeto, claseBase, idObjeto, em);
            Object concreto = convertidor.convertirAPersistencia(objeto, claseDestino, idObjeto, em);
            
            // Educación
            Method insertarEgresado = base.getClass().getMethod("setIdEgresado", e.getClass());
            insertarEgresado.invoke(base, e);
            
            Method insertarDestino2 = concreto.getClass().getMethod(setClaseBase, base.getClass());
            insertarDestino2.invoke(concreto, base);
            
            em.persist(base);
            em.persist(concreto);
            em.getTransaction().commit();
            return true;
        } catch (SecurityException | IllegalArgumentException | NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(ControladorEgresado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean borrar(String claseDestino, long idObjeto)
    {
        try {
            em.getTransaction().begin();
            Object objeto = em.getReference(Class.forName(claseDestino), idObjeto);
            Method borrar = objeto.getClass().getDeclaredMethod("setEstado", Boolean.TYPE);
            borrar.invoke(objeto, false);
            em.persist(objeto);
            em.getTransaction().commit();
            
            return true;
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(ControladorEgresado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public void refrescar()
    {
        em.refresh(e);
    }
}
