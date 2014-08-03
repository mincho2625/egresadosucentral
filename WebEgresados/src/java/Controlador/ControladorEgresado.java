package Controlador;

import Modelo.Egresado;
import java.sql.Date;
import java.time.LocalDate;
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

    private int idEgresado;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebEgresadosPU");

    public ControladorEgresado() {
    }

    public ControladorEgresado(int idEgresado) {
        this.idEgresado = idEgresado;
    }

    public void obtenerDatosAdicionales() {

    }

    public void obtenerEducacionFormal() {

    }

    public void obtenerEducacionNoFormal() {

    }

    public void obtenerExperienciaLaboral() {

    }

    public Egresado obtenerInformacionBasica() {
        Egresado egresado;

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Egresado.findByIdEgresado");
        query.setParameter("idEgresado", idEgresado);
        Persistencia.Egresado e = (Persistencia.Egresado) query.getSingleResult();
        if (e != null) {
            egresado = new Egresado();
            egresado.setCiudadExpedicion(e.getIdCiudadExpedicion().getIdCiudad());
            egresado.setCiudadNacimiento(e.getIdCiudadNacimiento().getIdCiudad());
            egresado.setCorreoInstitucional(e.getIdUsuario().getCorreoInstitucional());
            egresado.setEstadoCivil(e.getIdEstadoCivil().getIdEstadoCivil());
            egresado.setFechaExpedicion(e.getFechaExpedicion());
            egresado.setFechaNacimiento(e.getFechaNacimiento());
            egresado.setFechaUltimaAct(e.getFechaUltimaAct());
            egresado.setFoto(e.getFoto());
            egresado.setGenero(e.getIdGenero().getIdGenero());
            egresado.setGrupoSanguineo(e.getIdGrupoSanguineo().getIdGrupoSanguineo());
            egresado.setNombreUsuario(e.getIdUsuario().getNombre());
            egresado.setNombres(e.getNombres());
            egresado.setNumeroDocumento(e.getNumeroDocumento());
            egresado.setPrimerApellido(e.getPrimerApellido());
            egresado.setSegundoApellido(e.getSegundoApellido());
            egresado.setTipoDocumento(e.getIdTipoDocumento().getIdTipoDocumento());
        } else {
            egresado = null;
        }

        return egresado;
    }

    public void obtenerInformacionPersonal() {

    }

    public void actualizarDatosAdicionales() {
    }

    public void actualizarEducacionFormal() {
    }

    public void actualizarEducacionNoFormal() {
    }

    public void actualizarExperienciaLaboral() {
    }

    public boolean actualizarInformacionBasica(Egresado egresado) {
        if (egresado == null) {
            return false;
        }

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Persistencia.Egresado e;
        Persistencia.Usuario u;
        
        if (egresado.getIdUsuario() > 0) {
            e = em.getReference(Persistencia.Egresado.class, egresado.getIdEgresado());
        } else {
            e = new Persistencia.Egresado();
        }

        if (e != null) {

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
            
            u = e.getIdUsuario();
            if (u == null)
                u = new Persistencia.Usuario();
            
            u.setContrasenia(egresado.getClave());
            u.setCorreoInstitucional(egresado.getCorreoInstitucional());
            u.setIdPreguntaSeguridad(em.getReference(Persistencia.PreguntaSeguridad.class, egresado.getIdPreguntaSeguridad()));
            u.setNombre(egresado.getNombreUsuario());
            u.setRespuestaSeguridad(egresado.getRespuestaSeguridad());
            e.setIdUsuario(u);

            em.persist(e);
            em.getTransaction().commit();
        } else {
            return false;
        }

        return true;
    }

    public void actualizarInformacionPersonal() {
    }
}
