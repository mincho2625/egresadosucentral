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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private Persistencia.Egresado eg;

    public ControladorEgresado() {
        em = emf.createEntityManager();
    }

    public Egresado consultar(String nombreUsuario) {
        Egresado egresado = null;
        Query query = em.createNamedQuery("Egresado.findByNombreUsuario");
        query.setParameter("nombreUsuario", nombreUsuario);

        List results = query.getResultList();
        if (!results.isEmpty()) {
            e = (Persistencia.Egresado) results.get(0);
            Convertidor convertidor = new Convertidor();
            egresado = (Egresado) convertidor.convertirAModelo(e, e.getUsuario(), Modelo.Egresado.class.getName());
        }

        return egresado;
    }

    public Egresado consultar(String numeroDocumento, long tipoDocumento, Date fechaNacimiento) {
        Egresado egresado = null;
        try {
            Query query = em.createNamedQuery("Egresado.findByNumeroDocumento");
            query.setParameter("numeroDocumento", numeroDocumento);
            Object result = query.getSingleResult();
            if (result != null) {
                e = (Persistencia.Egresado) result;
                if (e.getIdTipoDocumento().getIdTipoDocumento().equals(tipoDocumento) && e.getFechaNacimiento().equals(fechaNacimiento)) {
                    Convertidor convertidor = new Convertidor();
                    egresado = (Egresado) convertidor.convertirAModelo(e, e.getUsuario(), Modelo.Egresado.class.getName());
                }
            }

            return egresado;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Egresado> consultar(Map<String, Object> parametros)
    {
        List<Egresado> listaEgresados = new ArrayList<>();
        Convertidor convertidor = new Convertidor();
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Persistencia.EducacionFormalUcentral> cq = cb.createQuery(Persistencia.EducacionFormalUcentral.class);
        Root<Persistencia.EducacionFormalUcentral> edFormalUC = cq.from(Persistencia.EducacionFormalUcentral.class);
        Join<Persistencia.EducacionFormalUcentral, Persistencia.Educacion> educacion = edFormalUC.join(Persistencia.EducacionFormalUcentral_.educacion);
        Join<Persistencia.Educacion, Persistencia.Egresado> egresado = educacion.join(Persistencia.Educacion_.idEgresado);
        Join<Persistencia.EducacionFormalUcentral, Persistencia.Programa> programa = edFormalUC.join(Persistencia.EducacionFormalUcentral_.idPrograma);
        
        if (parametros.containsKey("anioFinalizacionDesde")) {
            cb.greaterThanOrEqualTo(educacion.get(Persistencia.Educacion_.anioFinalizacion), 
                    Integer.parseInt(String.valueOf(parametros.get("anioFinalizacionDesde"))));
        }
        
        if (parametros.containsKey("anioFinalizacionHasta")) {
            cb.lessThanOrEqualTo(educacion.get(Persistencia.Educacion_.anioFinalizacion), 
                    Integer.parseInt(String.valueOf(parametros.get("anioFinalizacionHasta"))));
        }
        
        if (parametros.containsKey("estado")) {
            Join<Persistencia.Egresado, Persistencia.Usuario> usuario = egresado.join(Persistencia.Egresado_.usuario);
            cq.where(usuario.get(Persistencia.Usuario_.estado).in((List<Integer>)parametros.get("estado")));
        }
        
        if (parametros.containsKey("idNivelEstudios")) {
            Join<Persistencia.Programa, Persistencia.NivelEstudios> nivelEstudios = programa.join(Persistencia.Programa_.idNivelEstudios);
            cq.where(nivelEstudios.get(Persistencia.NivelEstudios_.idNivelEstudios).in((List<Long>)parametros.get("idNivelEstudios")));
        }
        
        if (parametros.containsKey("idFacultad")) {
            Join<Persistencia.Programa, Persistencia.Facultad> facultad = programa.join(Persistencia.Programa_.idFacultad);
            cq.where(facultad.get(Persistencia.Facultad_.idFacultad).in((List<Long>)parametros.get("idFacultad")));
        }
        
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
            Egresado eg = (Egresado)convertidor.convertirAModelo(e.getEducacion().getIdEgresado(), 
                    e.getEducacion().getIdEgresado().getUsuario(), Modelo.Egresado.class.getName());
            eg.setEducacionFormalUcentral((EducacionFormalUcentral)convertidor.convertirAModelo(
                    e.getEducacion().getEducacionFormalUcentral(), e.getEducacion(), Modelo.EducacionFormalUcentral.class.getName()));
            
            listaEgresados.add(eg);
        }
        
        if (!parametros.containsKey("idNivelEstudios") && !parametros.containsKey("idFacultad") 
                && !parametros.containsKey("idPrograma")) {
            
            CriteriaBuilder cbe = em.getCriteriaBuilder();
            CriteriaQuery<Persistencia.Egresado> cqe = cbe.createQuery(Persistencia.Egresado.class);
            Root<Persistencia.Egresado> egresadoRoot = cqe.from(Persistencia.Egresado.class);
            cbe.isNull(egresadoRoot.get(Persistencia.Egresado_.educacionCollection));

            if (parametros.containsKey("idGenero")) {
                Join<Persistencia.Egresado, Persistencia.Genero> generoRoot = egresadoRoot.join(Persistencia.Egresado_.idGenero);
                cqe.where(generoRoot.get(Persistencia.Genero_.idGenero).in((List<Long>)parametros.get("idGenero")));
            }

            if (parametros.containsKey("idEstadoCivil")) {
                Join<Persistencia.Egresado, Persistencia.EstadoCivil> estadoCivilRoot = egresadoRoot.join(Persistencia.Egresado_.idEstadoCivil);
                cqe.where(estadoCivilRoot.get(Persistencia.EstadoCivil_.idEstadoCivil).in((List<Long>)parametros.get("idEstadoCivil")));
            }

            if (parametros.containsKey("estado")) {
                Join<Persistencia.Egresado, Persistencia.Usuario> usuarioRoot = egresadoRoot.join(Persistencia.Egresado_.usuario);
                cqe.where(usuarioRoot.get(Persistencia.Usuario_.estado).in((List<Integer>)parametros.get("estado")));
            }
            
            cqe.select(egresadoRoot);
            TypedQuery<Persistencia.Egresado> queryNoEd = em.createQuery(cqe);
            List<Persistencia.Egresado> listaNoEd = queryNoEd.getResultList();

            for (Persistencia.Egresado eNoEd: listaNoEd) {
                Egresado egNoEd = (Egresado)convertidor.convertirAModelo(eNoEd, eNoEd.getUsuario(), Modelo.Egresado.class.getName());
                listaEgresados.add(egNoEd);
            }
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

    public boolean activar(List<Long> idEgresados, boolean activo) {
        try {
            em.getTransaction().begin();

            Query query = em.createNamedQuery("Usuario.findByIdUsuarios");
            query.setParameter("idUsuarios", idEgresados);

            List<Persistencia.Usuario> lista = query.getResultList();
            for (Persistencia.Usuario usuario : lista) {
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

    public boolean actualizarFecha(Date fecha) {
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

    public void completarInformacion(String nombreUsuario) {
        try {
            EntityManager em1 = emf.createEntityManager();
            Query query = em1.createNamedQuery("Egresado.findByNombreUsuario");
            query.setParameter("nombreUsuario", nombreUsuario);
            eg = ((Persistencia.Egresado) query.getSingleResult());
            em.getTransaction().begin();
            System.out.println("aaaaaa "+eg.getIdEgresado());
            java.util.Date fecha = null;
            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
            String fecha1 = formatoDeFecha.format(Date.valueOf(LocalDate.now()));
            fecha = formatoDeFecha.parse(fecha1);
            System.out.println("bbbbbbbb");
            /*eg.setFechaUltimaAct(fecha);
            System.out.println("jojoajdojaodjaodjad11111");
            eg.setInformacionCompleta(true);
            System.out.println("jojoajdojaodjaodjad");
            em.persist(eg);
            em.getTransaction().commit();*/
        } catch (ParseException ex) {

        }
    }
}