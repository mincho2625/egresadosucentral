package Controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author YURY
 * @version 1.0
 * @created 12-jul-2014 06:36:19 a.m.
 */
public class ControladorUsuario {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebEgresadosPU");

    /**
     *
     * @param usuario
     * @param contrasenia
     * @return 
     */
    public boolean login(String usuario, String contrasenia) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Usuario.findByNombre");
        query.setParameter("nombre", usuario);
        Object result = query.getSingleResult();
        if (result != null) {
            Persistencia.Usuario u = (Persistencia.Usuario) result;
            if (u.getContrasenia().equals(contrasenia))
                return true;
        }
        
        return false;
    }

}
