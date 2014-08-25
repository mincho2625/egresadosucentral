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

    public Map<Long, Object> consultar(String lista, String idObjeto, String claseDestino)
    {
        Convertidor convertidor2 = new Convertidor();
        
        try {
            Map<Long, Object> listaObjetos = new HashMap<>();
            
            Collection<Object> coleccion = (Collection)convertidor2.invocar(e,lista);
            for (Object objeto : coleccion) {
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

    public boolean actualizarInformacionBasica(Egresado egresado) {
        Convertidor convertidor = new Convertidor();
        if (egresado == null) {
            return false;
        }

        em.getTransaction().begin();
        e = (Persistencia.Egresado) convertidor.convertirAPersistencia(egresado, Persistencia.Egresado.class.getName(), "idEgresado", em);
        Persistencia.Usuario u = (Persistencia.Usuario) convertidor.convertirAPersistencia(egresado, Persistencia.Usuario.class.getName(), "idUsuario", em);
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
    
    public boolean actualizar(Object objeto, String claseDestino, String idObjeto, String claseDestino2, String idObjeto2)
    {
        try {
            if (objeto == null)
                return false;
            
            em.getTransaction().begin();
            Convertidor convertidor = new Convertidor();
            Object destino2 = convertidor.convertirAPersistencia(objeto, claseDestino2, idObjeto, em);
            Object destino = convertidor.convertirAPersistencia(objeto, claseDestino, idObjeto, em);
            
            // Educación
            Method insertarEgresado = destino.getClass().getMethod("setIdEgresado", e.getClass());
            insertarEgresado.invoke(destino, e);
            
            Method insertarDestino2 = destino2.getClass().getMethod("setEducacion", destino.getClass());
            insertarDestino2.invoke(destino2, destino);
            
            em.persist(destino2);
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
