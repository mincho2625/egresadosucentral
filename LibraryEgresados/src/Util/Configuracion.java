/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

import Modelo.AreaEstudios;
import Modelo.Ciudad;
import Modelo.Institucion;
import Modelo.Modalidad;
import Modelo.NivelEstudios;
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
public class Configuracion {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryEgresadosPU");
    private EntityManager em;
    private Institucion idInstitucionUcentral;
    private Ciudad idCiudadUcentral;
    private AreaEstudios idAreaEstudios;
    private Modalidad idModalidadUcentral;
    private NivelEstudios idNivelEstudios;
    
    // Configuración: Universidad Central
    public Configuracion()
    {
        this.idAreaEstudios = (AreaEstudios)consultar("AreaEstudios.findByIdAreaEstudios", "idAreaEstudios", 1, AreaEstudios.class.getName());
        this.idCiudadUcentral = (Ciudad)consultar("Ciudad.findByIdCiudad", "idCiudad", 1, Ciudad.class.getName());
        this.idInstitucionUcentral = (Institucion)consultar("Institucion.findByIdInstitucion", "idInstitucion", 1, Institucion.class.getName());
        this.idModalidadUcentral = (Modalidad)consultar("Modalidad.findByIdModalidad", "idModalidad", 1, Modalidad.class.getName());
        this.idNivelEstudios = (NivelEstudios)consultar("NivelEstudios.findByIdNivelEstudios", "idNivelEstudios", 1, NivelEstudios.class.getName());
    }
    
    public Object consultar(String consulta, String parametro, long idParametro, String claseDestino)
    {
        Convertidor convertidor = new Convertidor();
        em = emf.createEntityManager();
        try {
            
            Query query = em.createNamedQuery(consulta);
            query.setParameter(parametro, idParametro);
            Object objeto = query.getSingleResult();            
            return convertidor.convertirAModelo(objeto, null, claseDestino);
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    /**
     * @return the idInstitucionUcentral
     */
    public Institucion getIdInstitucionUcentral() {
        return idInstitucionUcentral;
    }

    /**
     * @param idInstitucionUcentral the idInstitucionUcentral to set
     */
    public void setIdInstitucionUcentral(Institucion idInstitucionUcentral) {
        this.idInstitucionUcentral = idInstitucionUcentral;
    }

    /**
     * @return the idCiudadUcentral
     */
    public Ciudad getIdCiudadUcentral() {
        return idCiudadUcentral;
    }

    /**
     * @param idCiudadUcentral the idCiudadUcentral to set
     */
    public void setIdCiudadUcentral(Ciudad idCiudadUcentral) {
        this.idCiudadUcentral = idCiudadUcentral;
    }

    /**
     * @return the idAreaEstudios
     */
    public AreaEstudios getIdAreaEstudios() {
        return idAreaEstudios;
    }

    /**
     * @param idAreaEstudios the idAreaEstudios to set
     */
    public void setIdAreaEstudios(AreaEstudios idAreaEstudios) {
        this.idAreaEstudios = idAreaEstudios;
    }

    /**
     * @return the idModalidadUcentral
     */
    public Modalidad getIdModalidadUcentral() {
        return idModalidadUcentral;
    }

    /**
     * @param idModalidadUcentral the idModalidadUcentral to set
     */
    public void setIdModalidadUcentral(Modalidad idModalidadUcentral) {
        this.idModalidadUcentral = idModalidadUcentral;
    }

    /**
     * @return the idNivelEstudios
     */
    public NivelEstudios getIdNivelEstudios() {
        return idNivelEstudios;
    }

    /**
     * @param idNivelEstudios the idNivelEstudios to set
     */
    public void setIdNivelEstudios(NivelEstudios idNivelEstudios) {
        this.idNivelEstudios = idNivelEstudios;
    }
}
