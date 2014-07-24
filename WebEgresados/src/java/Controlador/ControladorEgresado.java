package Controlador;

import Modelo.Egresado;
import Util.ConvertidosObjetos;
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
    
    // Cambio
    
    /**
     * @return the idEgresado
     */
    public int getIdEgresado() {
        return idEgresado;
    }

    /**
     * @param idEgresado the idEgresado to set
     */
    public void setIdEgresado(int idEgresado) {
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
        ConvertidosObjetos tro = new ConvertidosObjetos();
        
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Egresado.findByIdEgresado");
        query.setParameter("idEgresado", idEgresado);
        Persistencia.Egresado e = (Persistencia.Egresado) query.getSingleResult();
        if (e != null)
        {
            egresado = new Egresado();
            egresado.setCiudadExpedicion(e.getIdCiudadExpedicion().getIdCiudad());
            egresado.setCiudadNacimiento(e.getIdCiudadNacimiento().getIdCiudad());
            egresado.setCorreoInstitucional(e.getUsuario().getCorreoInstitucional());
            egresado.setEstadoCivil(e.getIdEstadoCivil().getIdEstadoCivil());
            egresado.setFechaExpedicion(e.getFechaExpedicion());
            egresado.setFechaNacimiento(e.getFechaNacimiento());
            egresado.setFechaUltimaAct(e.getFechaUltimaAct());
            egresado.setFoto(e.getFoto());
            egresado.setGenero(e.getIdGenero().getIdGenero());
            egresado.setGrupoSanguineo(e.getIdGrupoSanguineo().getIdGrupoSanguineo());
            egresado.setIdEgresado(e.getIdEgresado());
            egresado.setNombre(e.getUsuario().getNombre());
            egresado.setNombres(e.getNombres());
            egresado.setNumeroDocumento(e.getNumeroDocumento());
            egresado.setPrimerApellido(e.getPrimerApellido());
            egresado.setSegundoApellido(e.getSegundoApellido());
            egresado.setTipoDocumento(e.getIdTipoDocumento().getIdTipoDocumento());
        }
        else{
            egresado = null;
        }
        
        return egresado;
    }

    public void obtenerInformacionPersonal() {

    }
    
    public void actualizarDatosAdicionales(){}
    
    public void actualizarEducacionFormal(){}
    
    public void actualizarEducacionNoFormal(){}
    
    public void actualizarExperienciaLaboral(){}
    
    public void actualizarInformacionBasica(Egresado egresado){}
    
    public void actualizarInformacionPersonal(){}
}
