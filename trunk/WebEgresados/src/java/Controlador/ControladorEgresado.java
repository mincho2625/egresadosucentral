package Controlador;

import Modelo.Ciudad;
import Modelo.ClaseReconocimiento;
import Modelo.Contacto;
import Modelo.Educacion;
import Modelo.EducacionFormal;
import Modelo.Egresado;
import Modelo.EgresadoRedSocial;
import Modelo.Reconocimiento;
import Modelo.Residencia;
import Modelo.TipoReconocimiento;
import Util.Convertidor;
import Util.ConvertidorObjetos;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
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
    private final ConvertidorObjetos convertidorObjetos = new ConvertidorObjetos();
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

    public Egresado obtenerInformacionBasica() {
        Egresado egresado;
        if (e != null) {
            ConvertidorObjetos<Persistencia.Egresado, Modelo.Egresado> co = new ConvertidorObjetos<>(Modelo.Egresado.class.getName());
            egresado = co.convertir(e);
//            egresado = new Egresado();            
//            egresado.setCiudadExpedicion(e.getIdCiudadExpedicion().getIdCiudad());
//            egresado.setCiudadNacimiento(e.getIdCiudadNacimiento().getIdCiudad());
//            egresado.setCorreoInstitucional(e.getIdUsuario().getCorreoInstitucional());
//            egresado.setEstadoCivil(e.getIdEstadoCivil().getIdEstadoCivil());
//            egresado.setFechaExpedicion(e.getFechaExpedicion());
//            egresado.setFechaNacimiento(e.getFechaNacimiento());
//            egresado.setFechaUltimaAct(e.getFechaUltimaAct());
//            egresado.setFoto(e.getFoto());
//            egresado.setGenero(e.getIdGenero().getIdGenero());
//            egresado.setGrupoSanguineo(e.getIdGrupoSanguineo().getIdGrupoSanguineo());
//            egresado.setNombreUsuario(e.getIdUsuario().getNombre());
//            egresado.setNombres(e.getNombres());
//            egresado.setNumeroDocumento(e.getNumeroDocumento());
//            egresado.setPrimerApellido(e.getPrimerApellido());
//            egresado.setSegundoApellido(e.getSegundoApellido());
//            egresado.setTipoDocumento(e.getIdTipoDocumento().getIdTipoDocumento());
//            egresado.setIdEgresado(e.getIdEgresado());
        } else {
            egresado = null;
        }

        return egresado;
    }

    public Map<Long, Contacto> obtenerDatosUbicacion() {
        Map<Long, Contacto> listaContactos = new HashMap<>();
        ConvertidorObjetos<Persistencia.Contacto, Modelo.Contacto> co = new ConvertidorObjetos<>(Modelo.Contacto.class.getName());
        
        for (Persistencia.Contacto c : this.e.getContactoCollection()) {
            if (c.getEstado())
            try {
                listaContactos.put(c.getIdContacto(), co.convertir(c));
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(ControladorEgresado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return listaContactos;
    }
    
    public Map<Long, EgresadoRedSocial> consultarDatosRedesSociales()
    {
        Map<Long, EgresadoRedSocial> listaRedesSociales = new HashMap<>();
        ConvertidorObjetos<Persistencia.EgresadoRedSocial, Modelo.EgresadoRedSocial> co = new ConvertidorObjetos<>(Modelo.EgresadoRedSocial.class.getName());
        
        for (Persistencia.EgresadoRedSocial ers : this.e.getEgresadoRedSocialCollection()) {
            if (ers.getEstado())
                listaRedesSociales.put(ers.getIdEgresadoRedSocial(), co.convertir(ers));
        }
        
        return listaRedesSociales;
    }
    
    public Map<Long, Residencia> consultarDatosResidencia()
    {
        Map<Long, Residencia> listaResidencia = new HashMap<>();
        ConvertidorObjetos<Persistencia.Residencia, Modelo.Residencia> co = new ConvertidorObjetos<>(Modelo.Residencia.class.getName());
        
        for (Persistencia.Residencia ers : this.e.getResidenciaCollection()) {
            if (ers.getEstado())
                listaResidencia.put(ers.getIdResidencia(), co.convertir(ers));
        }
        
        return listaResidencia;
    }
    
    public Map<Long, Modelo.Educacion> consultarEducacionFormal()
    {
        Map<Long, Modelo.Educacion> listaEducacionFormal = new HashMap<>();
        ConvertidorObjetos<Persistencia.EducacionFormal, Modelo.Educacion> co = new ConvertidorObjetos<>(Modelo.Educacion.class.getName());
        
        for (Persistencia.Educacion ers : this.e.getEducacionCollection()) {
            if (ers.getEstado() && ers.getEducacionFormal() != null)
                listaEducacionFormal.put(ers.getIdEducacion(), co.convertir(ers.getEducacionFormal()));
        }
        
        return listaEducacionFormal;
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

        c.setDescripcion(contacto.getDescripcion());
        c.setEstado(true);
        c.setFechaRegistro(Date.valueOf(LocalDate.now()));
        c.setIdTipoContacto(em.getReference(Persistencia.TipoContacto.class, contacto.getIdTipoContacto()));
        c.setIdEgresado(e);

        em.persist(c);
        em.getTransaction().commit();

        return true;
    }
    
    public boolean actualizarDatosRedSocial(EgresadoRedSocial egresadoRedSocial)
    {
        if (egresadoRedSocial == null)
            return false;
        
        em.getTransaction().begin();
        
        Persistencia.EgresadoRedSocial ers;
        if (egresadoRedSocial.getIdEgresadoRedSocial() > 0)
            ers = em.getReference(Persistencia.EgresadoRedSocial.class, egresadoRedSocial.getIdEgresadoRedSocial());
        else
            ers = new Persistencia.EgresadoRedSocial();
        
        ers.setEstado(true);
        ers.setFechaRegistro(Date.valueOf(LocalDate.now()));
        ers.setIdEgresado(e);
        ers.setIdRedSocial(em.getReference(Persistencia.RedSocial.class, egresadoRedSocial.getIdRedSocial()));
        ers.setUrl(egresadoRedSocial.getUrl());
        
        em.persist(ers);
        em.getTransaction().commit();
        
        return true;
    }
    
    public boolean actualizarDatosResidencia(Residencia residencia)
    {
        if (residencia == null)
            return false;
        
        em.getTransaction().begin();
        Persistencia.Residencia r;
        if (residencia.getIdResidencia() > 0)
            r = em.getReference(Persistencia.Residencia.class, residencia.getIdResidencia());
        else
            r = new Persistencia.Residencia();
        
        r.setComputador(residencia.isComputador());
        r.setConexionInternet(residencia.isConexionInternet());
        r.setDireccion(residencia.getDireccion());
        r.setEstado(residencia.isEstado());
        r.setFechaRegistro(Date.valueOf(LocalDate.now()));
        r.setEstado(true);
        r.setIdCiudadResidencia(em.getReference(Persistencia.Ciudad.class, residencia.getIdCiudadResidencia()));
        r.setIdEgresado(e);
        r.setIdEstrato(em.getReference(Persistencia.Estrato.class, residencia.getIdEstrato()));
        r.setIdTipoTenenciaVivienda(em.getReference(Persistencia.TipoTenenciaVivienda.class, residencia.getIdTipoTenenciaVivienda()));
        r.setIdTipoVivienda(em.getReference(Persistencia.TipoVivienda.class, residencia.getIdTipoVivienda()));
        
        em.persist(r);
        em.getTransaction().commit();
        
        return true;
    }
    
    public boolean actualizarDatosEducacion(Educacion educacion)
    {
        if (educacion == null)
            return false;
        
        em.getTransaction().begin();
        Persistencia.Educacion ed;
        if (educacion.getIdEducacion() > 0)
            ed = em.getReference(Persistencia.Educacion.class, educacion.getIdEducacion());
        else
            ed = new Persistencia.Educacion();
        
        ed.setAnioFinalizacion(educacion.getAnioFinalizacion());
        ed.setAnioInicio(educacion.getAnioInicio());
        ed.setEstado(true);
        ed.setFechaActEstado(Date.valueOf(LocalDate.now()));
        ed.setIdAreaEstudios(em.getReference(Persistencia.AreaEstudios.class, 1));
        ed.setIdCiudad(em.getReference(Persistencia.Ciudad.class, 1));
        ed.setIdEgresado(e);
        ed.setIdEstadoEducacion(em.getReference(Persistencia.EstadoEducacion.class, educacion.getIdEstadoEducacion()));
        ed.setIdInstitucion(em.getReference(Persistencia.Institucion.class, 1));
        ed.setIdMesFinalizacion(em.getReference(Persistencia.Mes.class, educacion.getIdMesFinalizacion()));
        ed.setIdMesInicio(em.getReference(Persistencia.Mes.class, educacion.getIdMesInicio()));
        ed.setIdModalidad(em.getReference(Persistencia.Modalidad.class, 1));
                
        if (educacion.getClass().getSimpleName().equals("EducacionFormal"))
        {
            EducacionFormal educacionFormal = (EducacionFormal)educacion;
            
            Persistencia.EducacionFormal ef;
            if (ed.getEducacionFormal() != null)
                ef = ed.getEducacionFormal();
            else
                ef = new Persistencia.EducacionFormal();
            
            ef.setEducacion(ed);
            ef.setIdJornada(em.getReference(Persistencia.Jornada.class, educacionFormal.getIdJornada()));
            ef.setIdNivelEstudios(em.getReference(Persistencia.NivelEstudios.class, educacionFormal.getIdNivelEstudios()));
            ef.setIdPrograma(em.getReference(Persistencia.Programa.class, educacionFormal.getIdPrograma()));
            em.persist(ef);
        }
        
        em.getTransaction().commit();
        return true;
    }
    
    public boolean actualizar(Object objeto, String claseDestino, String idObjeto)
    {
        try {
            if (objeto == null)
                return false;
            
            em.getTransaction().begin();
            Convertidor convertidor2 = new Convertidor();
            Object destino = (Persistencia.Reconocimiento)convertidor2.convertirAPersistencia(objeto, claseDestino, idObjeto);
            
            Method metodo = objeto.getClass().getDeclaredMethod("setIdEgresado", Persistencia.Egresado.class);
            metodo.invoke(objeto, e);
            
            em.persist(destino);
            em.getTransaction().commit();
            return true;
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(ControladorEgresado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean borrarDatosUbicacion(long idContacto)
    {
        em.getTransaction().begin();
        Persistencia.Contacto c = em.getReference(Persistencia.Contacto.class, idContacto);
        c.setEstado(false);
        em.persist(c);
        em.getTransaction().commit();
        
        return true;
    }
    
    public boolean borrarDatosRedSocial(long idEgresadoRedSocial)
    {
        em.getTransaction().begin();
        Persistencia.EgresadoRedSocial ers = em.getReference(Persistencia.EgresadoRedSocial.class, idEgresadoRedSocial);
        ers.setEstado(false);
        em.persist(ers);
        em.getTransaction().commit();
        
        return true;
    }
    
    public boolean borrarDatosResidencia(long idResidencia)
    {
        em.getTransaction().begin();
        Persistencia.Residencia r = em.getReference(Persistencia.Residencia.class, idResidencia);
        r.setEstado(false);
        em.persist(r);
        em.getTransaction().commit();
        
        return true;
    }
    
    public void refrescar()
    {
        em.refresh(e);
    }
}
