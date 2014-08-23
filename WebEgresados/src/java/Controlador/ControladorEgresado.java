package Controlador;

import Modelo.Egresado;
import Util.Convertidor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.time.LocalDate;
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

    public boolean crearEgresado(Egresado egresado) {
        if (egresado == null) {
            return false;
        }

        em.getTransaction().begin();
        e = new Persistencia.Egresado();

        e.setFechaExpedicion(egresado.getFechaExpedicion());
        e.setFechaNacimiento(egresado.getFechaNacimiento());
        e.setFechaUltimaAct(egresado.getFechaUltimaAct());
        e.setIdCiudadExpedicion(em.getReference(Persistencia.Ciudad.class, egresado.getCiudadExpedicion()));
        e.setIdCiudadNacimiento(em.getReference(Persistencia.Ciudad.class, egresado.getCiudadNacimiento()));
        e.setIdEstadoCivil(em.getReference(Persistencia.EstadoCivil.class, egresado.getEstadoCivil()));
        e.setIdGenero(em.getReference(Persistencia.Genero.class, egresado.getGenero()));
        e.setIdGrupoSanguineo(em.getReference(Persistencia.GrupoSanguineo.class, egresado.getGrupoSanguineo()));
        e.setIdTipoDocumento(em.getReference(Persistencia.TipoDocumento.class, egresado.getTipoDocumento()));
        e.setNombres(egresado.getNombres());
        e.setNumeroDocumento(egresado.getNumeroDocumento());
        e.setPrimerApellido(egresado.getPrimerApellido());
        e.setSegundoApellido(egresado.getSegundoApellido());
        e.setAceptaCondiciones(true);
        e.setFechaUltimaAct(Date.valueOf(LocalDate.now()));

        Persistencia.Usuario u = new Persistencia.Usuario();
        u.setContrasenia(egresado.getClave());
        u.setCorreoInstitucional(egresado.getCorreoInstitucional());
        u.setIdPreguntaSeguridad(em.getReference(Persistencia.PreguntaSeguridad.class, egresado.getIdPreguntaSeguridad()));
        u.setNombre(egresado.getNombreUsuario());
        u.setRespuestaSeguridad(egresado.getRespuestaSeguridad());
        e.setIdUsuario(u);

        em.persist(e);
        em.getTransaction().commit();

        return true;
    }

    public boolean actualizarInformacionBasica(Egresado egresado) {
        if (egresado == null) {
            return false;
        }

        if (egresado.getIdEgresado() > 0) {
            em.getTransaction().begin();

            e = em.getReference(Persistencia.Egresado.class, egresado.getIdEgresado());
            e.setFechaExpedicion(egresado.getFechaExpedicion());
            e.setFechaNacimiento(egresado.getFechaNacimiento());
            e.setFechaUltimaAct(egresado.getFechaUltimaAct());
            e.setIdCiudadExpedicion(em.getReference(Persistencia.Ciudad.class, egresado.getCiudadExpedicion()));
            e.setIdCiudadNacimiento(em.getReference(Persistencia.Ciudad.class, egresado.getCiudadNacimiento()));
            e.setIdEstadoCivil(em.getReference(Persistencia.EstadoCivil.class, egresado.getEstadoCivil()));
            e.setIdGenero(em.getReference(Persistencia.Genero.class, egresado.getGenero()));
            e.setIdGrupoSanguineo(em.getReference(Persistencia.GrupoSanguineo.class, egresado.getGrupoSanguineo()));
            e.setIdTipoDocumento(em.getReference(Persistencia.TipoDocumento.class, egresado.getTipoDocumento()));
            e.setNombres(egresado.getNombres());
            e.setNumeroDocumento(egresado.getNumeroDocumento());
            e.setPrimerApellido(egresado.getPrimerApellido());
            e.setSegundoApellido(egresado.getSegundoApellido());
            e.setAceptaCondiciones(true);
            e.setFechaUltimaAct(Date.valueOf(LocalDate.now()));

            em.persist(e);
            em.getTransaction().commit();
        } else {
            return false;
        }

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
            
            Method insertarEgresado = destino.getClass().getDeclaredMethod("setIdEgresado", e.getClass());
            insertarEgresado.invoke(destino, e);
            
            em.persist(destino);
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
