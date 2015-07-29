/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.EgresadoRespuesta;
import Modelo.PreguntaEncuesta;
import Modelo.RespuestaEncuesta;
import Util.Convertidor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
public class ControladorEncuesta {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EgresadosPU");
    private final EntityManager em;
    private Persistencia.Egresado e;
    
    public ControladorEncuesta()
    {
        em = emf.createEntityManager();
    }
    
    public ControladorEncuesta(String nombreUsuario) {
        em = emf.createEntityManager();               
        Query query = em.createNamedQuery("Egresado.findByNombreUsuario");
        query.setParameter("nombreUsuario", nombreUsuario);
        e = ((Persistencia.Egresado)query.getSingleResult());
    }
    
    public int consultarUltimaEncuesta()
    {
        try {
            Query query = em.createNamedQuery("Encuesta.maxOrden");
            query.setParameter("estado", true);
            List results = query.getResultList();
            if(!results.isEmpty()){
                return ((Number)results.get(0)).intValue();
            }
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorEncuesta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public Map<Long, PreguntaEncuesta> consultarPreguntasEncuesta(long orden)
    {
        Convertidor convertidor = new Convertidor();
        Map<Long, PreguntaEncuesta> listaPreguntas = new HashMap<>();
        
        try {
            Query query = em.createNamedQuery("PreguntaEncuesta.findByOrdenEncuesta");
            query.setParameter("orden", orden);
            List<Persistencia.PreguntaEncuesta> lista = query.getResultList();
            
            for (Persistencia.PreguntaEncuesta pe : lista) {
                if (pe.getEstado()){
                    PreguntaEncuesta preguntaEncuesta = (PreguntaEncuesta)convertidor.convertirAModelo(pe, null, Modelo.PreguntaEncuesta.class.getName());
                    for (Persistencia.RespuestaEncuesta pre : pe.getRespuestaEncuestaCollection()) {
                        if (pre.getEstado()){
                            preguntaEncuesta.agregarPosibleRespuestaEncuesta((RespuestaEncuesta)convertidor.convertirAModelo(pre, null, Modelo.RespuestaEncuesta.class.getName()));
                        }
                    }

                    for (Persistencia.EgresadoRespuesta re : e.getEgresadoRespuestaCollection()) {
                        if (re.getIdPreguntaEncuesta().equals(pe) && re.getEstado()){
                            preguntaEncuesta.getListaRespuestasEncuesta().add((EgresadoRespuesta) convertidor.convertirAModelo(re, null, Modelo.EgresadoRespuesta.class.getName()));
                        }
                    }

                    System.out.println(String.format("Pregunta %d, Posibles respuestas %d, Egresado respuestas %d", 
                            preguntaEncuesta.getIdPreguntaEncuesta(),
                            preguntaEncuesta.getListaPosiblesRespuestasEncuesta().size(),
                            preguntaEncuesta.getListaRespuestasEncuesta().size()));
                    listaPreguntas.put(pe.getIdPreguntaEncuesta(), preguntaEncuesta);
                }
            }

            return listaPreguntas;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorEncuesta.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean guardar(ArrayList<EgresadoRespuesta> respuestas)
    {
        if (respuestas == null)
            return false;
        
        Convertidor convertidor = new Convertidor();        
        em.getTransaction().begin();
        
        for (EgresadoRespuesta egresadoRespuesta : respuestas) {
            try {
                egresadoRespuesta.setIdEgresado(e.getIdEgresado());
                Object destino = convertidor.convertirAPersistencia(egresadoRespuesta, Persistencia.EgresadoRespuesta.class.getName(), "getIdEgresadoRespuesta", em);
                
                Method insertarEgresado = destino.getClass().getMethod("setIdEgresado", e.getClass());
                insertarEgresado.invoke(destino, e);                
                em.persist(destino);
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(ControladorEncuesta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        em.getTransaction().commit();
        return true;
    }
    
    public void refrescar()
    {
        em.refresh(e);
    }
}
