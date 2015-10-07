/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ItemLista;
import Persistencia.Columna;
import Persistencia.Usuario;
import Persistencia.UsuarioColumna;
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
public class ControladorColumnas {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EgresadosPU");
    private final EntityManager em;
    
    public ControladorColumnas()
    {
        em = emf.createEntityManager();
    }
    
    public List<ItemLista> consultarEducacionFormalUCentralPorUsuario(long idUsuario)
    {
        List<ItemLista> listaColumnas = new ArrayList<>();
        
        try {
            Query query = em.createNamedQuery("UsuarioColumna.findByIdUsuario");
            query.setParameter("idUsuario", idUsuario);
            query.setParameter("estado", true);
            
            List<UsuarioColumna> lista = query.getResultList();
            for(UsuarioColumna columna: lista) {
                ItemLista item = new ItemLista();
                item.setId(columna.getIdColumna().getIdColumna());
                item.setNombre(columna.getIdColumna().getValor());
                listaColumnas.add(item);
            }

            return listaColumnas;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorListas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public Map<String, String> consultarEducacionFormalUCentralPorUsuarioMap(long idUsuario)
    {
        Map<String, String> listaColumnas = new HashMap<>();
        
        try {
            Query query = em.createNamedQuery("UsuarioColumna.findByIdUsuario");
            query.setParameter("idUsuario", idUsuario);
            query.setParameter("estado", true);
            
            List<UsuarioColumna> lista = query.getResultList();
            for(UsuarioColumna columna: lista) {
                listaColumnas.put(columna.getIdColumna().getNombre(), columna.getIdColumna().getValor());
            }

            return listaColumnas;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorListas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public List<ItemLista> consultarEducacionFormalUCentral()
    {
        List<ItemLista> listaColumnas = new ArrayList<>();
        
        try {
            Query query = em.createNamedQuery("Columna.findByDisponible");
            query.setParameter("estado", true);
            
            List<Columna> lista = query.getResultList();
            for(Columna columna: lista) {
                ItemLista item = new ItemLista();
                item.setId(columna.getIdColumna());
                item.setNombre(columna.getValor());
                listaColumnas.add(item);
            }

            return listaColumnas;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorListas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void guardarEducacionFormalUCentral(List<Long> listaColumnas, long idUsuario)
    {
        try {
            em.getTransaction().begin();

            Query query = em.createNamedQuery("UsuarioColumna.findByIdUsuario");
            query.setParameter("idUsuario", idUsuario);
            query.setParameter("estado", true);

            List<UsuarioColumna> lista = query.getResultList();
            for(UsuarioColumna columna: lista) {
                em.remove(columna);
            }

            Query queryUsuario = em.createNamedQuery("Usuario.findByIdUsuario");
            queryUsuario.setParameter("idUsuario", idUsuario);
            Usuario usuario = (Usuario)queryUsuario.getSingleResult();

            Query query2 = em.createNamedQuery("Columna.findByIdColumnas");
            query2.setParameter("idColumna", listaColumnas);

            List<Columna> columnas = query2.getResultList();
            for (Columna columna : columnas) {
                UsuarioColumna usuarioColumna = new UsuarioColumna();
                usuarioColumna.setIdColumna(columna);
                usuarioColumna.setIdUsuario(usuario);
                em.persist(usuarioColumna);
            }

            em.getTransaction().commit();
        }
        catch (Exception ex)
        {
            Logger.getLogger(ControladorListas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
