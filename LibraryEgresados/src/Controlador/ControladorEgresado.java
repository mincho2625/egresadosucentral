/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.EducacionFormalUcentral;
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
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

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
    
    public List<EducacionFormalUcentral> consultar(Map<String, Object> parametros)
    {
        List<EducacionFormalUcentral> listaEgresados = new ArrayList<>();
        Convertidor convertidor = new Convertidor();
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Persistencia.EducacionFormalUcentral> cq = cb.createQuery(Persistencia.EducacionFormalUcentral.class);
        Root<Persistencia.EducacionFormalUcentral> edFormalUC = cq.from(Persistencia.EducacionFormalUcentral.class);
        Join<Persistencia.EducacionFormalUcentral, Persistencia.Educacion> educacion = edFormalUC.join(Persistencia.EducacionFormalUcentral_.educacion);
        Join<Persistencia.Educacion, Persistencia.Egresado> egresado = educacion.join(Persistencia.Educacion_.idEgresado);
        Join<Persistencia.EducacionFormalUcentral, Persistencia.Programa> programa = edFormalUC.join(Persistencia.EducacionFormalUcentral_.idPrograma);
        
        if (parametros.containsKey("anioFinalizacion")) {
            cq.where(educacion.get(Persistencia.Educacion_.anioFinalizacion).in((List<Integer>)parametros.get("anioFinalizacion")));
        }
        
        if (parametros.containsKey("idNivelEstudios")) {
            Join<Persistencia.Programa, Persistencia.NivelEstudios> nivelEstudios = programa.join(Persistencia.Programa_.idNivelEstudios);
            cq.where(nivelEstudios.get(Persistencia.NivelEstudios_.idNivelEstudios).in((List<Long>)parametros.get("idNivelEstudios")));
        }
        
        if (parametros.containsKey("idFacultad")) {
            Join<Persistencia.Programa, Persistencia.Facultad> facultad = programa.join(Persistencia.Programa_.idFacultad);
            cq.where(facultad.get(Persistencia.Facultad_.idFacultad).in((List<Long>)parametros.get("idFacultad")));
        }
        
        System.out.println("Programas: " + parametros.get("idPrograma"));
        if (parametros.containsKey("idPrograma")) {
            cq.where(programa.get(Persistencia.Programa_.idPrograma).in((List<Long>)parametros.get("idPrograma")));
        }
        
        if (parametros.containsKey("idGenero")) {
            Join<Persistencia.Egresado, Persistencia.Genero> genero = egresado.join(Persistencia.Egresado_.idGenero);
            cq.where(genero.get(Persistencia.Genero_.idGenero).in((List<Long>)parametros.get("idGenero")));
        }
        
        if (parametros.containsKey("idEstadoCivil")) {
            Join<Persistencia.Egresado, Persistencia.EstadoCivil> estadoCivil = egresado.join(Persistencia.Egresado_.idEstadoCivil);
            cq.where(estadoCivil.get(Persistencia.EstadoCivil_.idEstadoCivil).in((List<Long>)parametros.get("idEstadoCivil")));
        }
        
        cq.select(edFormalUC);
        TypedQuery<Persistencia.EducacionFormalUcentral> query = em.createQuery(cq);
        List<Persistencia.EducacionFormalUcentral> lista = query.getResultList();
        
        for (Persistencia.EducacionFormalUcentral e: lista) {
            EducacionFormalUcentral educacionFormalUcentral = (EducacionFormalUcentral)convertidor.convertirAModelo(
                    e.getEducacion().getEducacionFormalUcentral(), e.getEducacion(), Modelo.EducacionFormalUcentral.class.getName());
            educacionFormalUcentral.setEgresado((Egresado)convertidor.convertirAModelo(e.getEducacion().getIdEgresado(), 
                    e.getEducacion().getIdEgresado().getUsuario(), Modelo.Egresado.class.getName()));
            listaEgresados.add(educacionFormalUcentral);
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
    
    public boolean activar(List<Long> idEgresados, boolean activo)
    {
        try {
            em.getTransaction().begin();
            
            Query query = em.createNamedQuery("Usuario.findByIdUsuarios");
            query.setParameter("idUsuarios", idEgresados);

            List<Persistencia.Usuario> lista = query.getResultList();
            for (Persistencia.Usuario usuario: lista) {
                usuario.setEstado(activo);
                em.persist(usuario);
            }
            em.getTransaction().commit();
            
            return true;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorEgresado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean actualizarFecha(Date fecha)
    {
        try {
            em.getTransaction().begin();
            Persistencia.Egresado u = em.getReference(Persistencia.Egresado.class, e.getIdEgresado());
            u.setFechaUltimaAct(fecha);
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
