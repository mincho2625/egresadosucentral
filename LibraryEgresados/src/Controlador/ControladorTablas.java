/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author pc
 */
public class ControladorTablas {
    
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EgresadosPU");
    
    
    public String consultarEgresado(long id) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Egresado.findByIdEgresado");
        query.setParameter("idEgresado", id);
        List<Persistencia.Egresado> listapro = query.getResultList();
        for (Persistencia.Egresado e : listapro) {
            return e.getNumeroDocumento();
        }
        return null;
    }
    
}
