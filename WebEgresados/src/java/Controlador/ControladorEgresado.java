package Controlador;

import Modelo.Contacto;
import Modelo.Egresado;
import Util.ConvertidosObjetos;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private final ConvertidosObjetos convertidosObjetos = new ConvertidosObjetos();
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
            egresado.setIdEgresado(e.getIdEgresado());
        } else {
            egresado = null;
        }

        return egresado;
    }

    public ArrayList<Contacto> obtenerDatosUbicacion() {
        ArrayList<Contacto> listaContactos = new ArrayList<>();

        for (Persistencia.Contacto c : this.e.getContactoCollection()) {
            listaContactos.add(convertidosObjetos.convertirContacto(c));
        }

        return listaContactos;
    }

    public void actualizarDatosAdicionales() {
    }

    public void actualizarEducacionFormal() {
    }

    public void actualizarEducacionNoFormal() {
    }

    public void actualizarExperienciaLaboral() {
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

    public boolean actualizarDatosUbicacion(Contacto contacto) {
        if (contacto == null) {
            return false;
        }

        em.getTransaction().begin();

        Persistencia.Contacto c;
        if (contacto.getIdContacto() > 0) {
            c = em.getReference(Persistencia.Contacto.class, contacto.getIdContacto());
        } else {
            c = new Persistencia.Contacto();
        }

        c.setDescripción(contacto.getDescripcion());
        c.setEstado(true);
        c.setFechaRegistro(contacto.getFechaRegistro());
        c.setIdTipoContacto(em.getReference(Persistencia.TipoContacto.class, contacto.getIdTipoContacto()));
        c.setIdEgresado(e);

        em.persist(c);
        em.getTransaction().commit();

        return true;
    }
}
