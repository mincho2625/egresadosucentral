/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Egresado;
import Util.Convertidor;
import java.sql.Date;
import java.time.LocalDate;
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
public class ControladorEgresado {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EgresadosPU");
    private final EntityManager em;
    private Persistencia.Egresado e;
    
    public ControladorEgresado()
    {
        em = emf.createEntityManager();
    }
    
    public Egresado consultar(String nombreUsuario)
    {
        Egresado egresado = null;
        Query query = em.createNamedQuery("Egresado.findByNombreUsuario");
        query.setParameter("nombreUsuario", nombreUsuario);
        
        List results = query.getResultList();
        if(!results.isEmpty()){
            e = (Persistencia.Egresado)results.get(0);
            Convertidor convertidor = new Convertidor();
            egresado = (Egresado)convertidor.convertirAModelo(e, e.getUsuario(), Modelo.Egresado.class.getName());
        }
        
        return egresado;
    }
    
    public Egresado consultar(String numeroDocumento, long tipoDocumento, Date fechaNacimiento)
    {
        Egresado egresado = null;
        try {
            Query query = em.createNamedQuery("Egresado.findByNumeroDocumento");
            query.setParameter("numeroDocumento", numeroDocumento);
            Object result = query.getSingleResult();
            if (result != null) {
                e = (Persistencia.Egresado) result;
                if (e.getIdTipoDocumento().getIdTipoDocumento().equals(tipoDocumento) && e.getFechaNacimiento().equals(fechaNacimiento))
                {
                    Convertidor convertidor = new Convertidor();
                    egresado = (Egresado)convertidor.convertirAModelo(e, e.getUsuario(), Modelo.Egresado.class.getName());
                }
            }
            
            return egresado;
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    public List<Egresado> consultar(Map<String, Object> parametros)
    {
        List<Egresado> listaEgresados = new ArrayList<>();
        Convertidor convertidor = new Convertidor();
        
        Query query = em.createNamedQuery("EducacionFormalUcentral.findByCriterio");
        for (Map.Entry<String, Object> entry : parametros.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        
        List<Persistencia.Egresado> lista = query.getResultList();
        for (Persistencia.Egresado e: lista) {
            listaEgresados.add((Egresado)convertidor.convertirAModelo(e, e.getUsuario(), Modelo.Egresado.class.getName()));
        }
        
        return listaEgresados;
    }

    public boolean actualizar(Egresado egresado) {
        Convertidor convertidor = new Convertidor();
        if (egresado == null) {
            return false;
        }

        em.getTransaction().begin();
        e = (Persistencia.Egresado) convertidor.convertirAPersistencia(egresado, Persistencia.Egresado.class.getName(), "getIdEgresado", em);
        Persistencia.Usuario u = (Persistencia.Usuario) convertidor.convertirAPersistencia(egresado, Persistencia.Usuario.class.getName(), "getIdUsuario", em);
        e.setUsuario(u);
        
        em.persist(u);
        em.persist(e);
        em.getTransaction().commit();

        return true;
    }
    
    public boolean activar(long idEgresado, boolean activo)
    {
        try {
            em.getTransaction().begin();
            Persistencia.Usuario u = em.getReference(Persistencia.Usuario.class, idEgresado);
            u.setEstado(activo);
            em.persist(u);
            em.getTransaction().commit();
            
            return true;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorEgresado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public void completarInformacion()
    {
        em.getTransaction().begin();
        
        e.setInformacionCompleta(true);
        e.setFechaUltimaAct(Date.valueOf(LocalDate.now()));
        
        em.persist(e);
        em.getTransaction().commit();
    }
}
