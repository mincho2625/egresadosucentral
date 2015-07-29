/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

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
public class ControladorUsuario {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EgresadosPU");
    private static final String base = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ@!#$";

    /**
     *
     * @param usuario
     * @param contrasenia
     * @return 
     */
    public boolean login(String usuario, String contrasenia) {
        try {
            EntityManager em = emf.createEntityManager();
            Query query = em.createNamedQuery("Usuario.findByNombre");
            query.setParameter("nombre", usuario);
            Object result = query.getSingleResult();
            if (result != null) {
                Persistencia.Usuario u = (Persistencia.Usuario) result;
                if (u.getContrasenia().equals(contrasenia)) {
                    return true;
                }
            }
        }
        catch(Exception ex)
        {
            return false;
        }
        
        return false;
    }
    
    public boolean cambiarContrasenia(String usuario, String contrasenia)
    {
        try {
            EntityManager em = emf.createEntityManager();
            Query query = em.createNamedQuery("Usuario.findByNombre");
            query.setParameter("nombre", usuario);
            Object result = query.getSingleResult();
            if (result != null) {
                em.getTransaction().begin();
                Persistencia.Usuario u = (Persistencia.Usuario) result;
                u.setContrasenia(contrasenia);
                em.persist(u);
                em.getTransaction().commit();
                return true;
            }
        }
        catch(Exception ex)
        {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return false;
    }
    
    public String generarContrasenia()
    {
        int longitud = base.length();
        String contrasena="";
        
        for(int i=0; i<10;i++){ //1
            int numero = (int)(Math.random()*(longitud)); //2
            String caracter=base.substring(numero, numero+1); //3
            contrasena=contrasena+caracter; //4
        }

        return contrasena;
    }
}