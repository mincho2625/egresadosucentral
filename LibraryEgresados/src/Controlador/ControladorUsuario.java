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
import Util.Utilidades;

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
    public long login(String usuario, String contrasenia) {
        try {
            String contrase;
            EntityManager em = emf.createEntityManager();
            Query query = em.createNamedQuery("Usuario.findByNombre");
            query.setParameter("nombre", usuario);
            query.setParameter("estado", true);
            Object result = query.getSingleResult();
            if (result != null) {
                Persistencia.Usuario u = (Persistencia.Usuario) result;
                contrase=Utilidades.Desencriptar(u.getContrasenia());
                if (contrase.equals(contrasenia)) {
                    return u.getIdUsuario();
                }
            }
        }
        catch(Exception ex)
        {
            return 0;
        }
        
        return 0;
    }
    
    public boolean cambiarContrasenia(String usuario, String contrasenia)
    {
        try {
            EntityManager em = emf.createEntityManager();
            Query query = em.createNamedQuery("Usuario.findByNombre");
            query.setParameter("nombre", usuario);
            query.setParameter("estado", true);
            Object result = query.getSingleResult();
            if (result != null) {
                em.getTransaction().begin();
                Persistencia.Usuario u = (Persistencia.Usuario) result;
                u.setContrasenia(Utilidades.Encriptar(contrasenia));
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
    public boolean informacionCompleta(String documento) {
        boolean informacion=false;
        try {
            EntityManager em = emf.createEntityManager();
            Query query = em.createNamedQuery("Egresado.findByNumeroDocumento");
            query.setParameter("numeroDocumento", documento);
            Object result = query.getSingleResult();
            if (result != null) {
                Persistencia.Egresado u = (Persistencia.Egresado) result;
                System.out.println("jijijijijij "+u.isInformacionCompleta());
                informacion=u.isInformacionCompleta();
            }
        } catch (Exception ex) {
        }
        return informacion;
    }
}