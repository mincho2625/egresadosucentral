/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.EgresadoRespuesta;
import Modelo.Encuesta;
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
public class ControlardorEncuesta {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebEgresadosPU");
    private EntityManager em;
    private Persistencia.Egresado e;
    
    public ControlardorEncuesta()
    {
        em = emf.createEntityManager();
    }
    
    public ControlardorEncuesta(String nombreUsuario) {
        em = emf.createEntityManager();
        
        Query query = em.createNamedQuery("Usuario.findByNombre");
        query.setParameter("nombre", nombreUsuario);
        Persistencia.Usuario u = (Persistencia.Usuario)query.getSingleResult();
        e = ((Persistencia.Egresado)u.getEgresadoCollection().toArray()[0]);
    }
    
    public ArrayList<Encuesta> consultarEncuestas()
    {
        Convertidor convertidor = new Convertidor();
        ArrayList<Encuesta> listaEncuestas = new ArrayList<>();
        
        try {
            Query query = em.createNamedQuery("Encuesta.findAll");
            List<Persistencia.Encuesta> lista = query.getResultList();
            for (Persistencia.Encuesta encuesta : lista) {
                if (encuesta.getEstado()){
                    listaEncuestas.add((Encuesta)convertidor.convertirAModelo(encuesta, null, Modelo.Encuesta.class.getName()));
                }
            }

            return listaEncuestas;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorEgresado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public Map<Long, PreguntaEncuesta> consularPreguntasEncuesta(long idEncuesta)
    {
        Convertidor convertidor = new Convertidor();
        Map<Long, PreguntaEncuesta> listaPreguntas = new HashMap<>();
        
        try {
            Persistencia.Encuesta en = em.getReference(Persistencia.Encuesta.class, idEncuesta);
            if (en != null) {
                for (Persistencia.PreguntaEncuesta pe : en.getPreguntaEncuestaCollection()) {
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

                        listaPreguntas.put(pe.getIdPreguntaEncuesta(), preguntaEncuesta);
                    }
                }
            }

            return listaPreguntas;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorEgresado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
//    
//    public long encuestaAnterior()
//    {
//        return 0;
//    }
//    
//    public long encuestaSiguiente()
//    {
//        CriteriaBuilder qb = em.getCriteriaBuilder();
//        CriteriaQuery<Number> cq = qb.createQuery(Number.class);
//        Root<Persistencia.Encuesta> root = cq.from(Persistencia.Encuesta.class);
//        cq.select(qb.min(root.get("idEncuesta")));
//        cq.where(qb.equal(Persistencia.Encuesta.get("org"), qb.parameter(MyOrgType.class, "myOrg")));
//        em.createQuery(cq).setParameter("myOrg", myOrg).getSingleResult();
//    }
    
    public boolean guardar(ArrayList<EgresadoRespuesta> respuestas)
    {
        if (respuestas == null)
            return false;
        
        Convertidor convertidor = new Convertidor();        
        em.getTransaction().begin();
        
        for (EgresadoRespuesta egresadoRespuesta : respuestas) {
            try {
                Object destino = convertidor.convertirAPersistencia(egresadoRespuesta, Persistencia.EgresadoRespuesta.class.getName(), "getIdEgresadoRespuesta", em);
                
                Method insertarEgresado = destino.getClass().getMethod("setIdEgresado", e.getClass());
                insertarEgresado.invoke(destino, e);                
                em.persist(destino);
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(ControlardorEncuesta.class.getName()).log(Level.SEVERE, null, ex);
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
