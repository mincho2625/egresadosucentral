/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Encuesta;
import Modelo.PreguntaEncuesta;
import Modelo.RespuestaEncuesta;
import Util.Convertidor;
import java.util.ArrayList;
import java.util.List;
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
    
    public ArrayList<Encuesta> consultarEncuestas()
    {
        Convertidor convertidor = new Convertidor();
        em = emf.createEntityManager();
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
    
    public ArrayList<PreguntaEncuesta> consularPreguntasEncuesta(long idEncuesta)
    {
        Convertidor convertidor = new Convertidor();
        em = emf.createEntityManager();
        ArrayList<PreguntaEncuesta> listaPreguntas = new ArrayList<>();
        
        try {
            Persistencia.Encuesta e = em.getReference(Persistencia.Encuesta.class, idEncuesta);
            if (e != null) {
                for (Persistencia.PreguntaEncuesta pe : e.getPreguntaEncuestaCollection()) {
                    if (pe.getEstado()){
                        PreguntaEncuesta preguntaEncuesta = (PreguntaEncuesta)convertidor.convertirAModelo(pe, null, Modelo.PreguntaEncuesta.class.getName());
                        for (Persistencia.RespuestaEncuesta re : pe.getRespuestaEncuestaCollection()) {
                            preguntaEncuesta.agregarRespuestaEncuesta((RespuestaEncuesta)convertidor.convertirAModelo(re, null, Modelo.RespuestaEncuesta.class.getName()));
                        }

                        listaPreguntas.add(preguntaEncuesta);
                    }
                }
            }

            return listaPreguntas;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorEgresado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
