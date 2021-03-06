/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConfiguracionCorreo;
import Modelo.PlantillaCorreo;
import Util.Constantes;
import Util.Convertidor;
import Util.Utilidades;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author YURY
 */
public class ControladorCorreo {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EgresadosPU");
    private final EntityManager em;

    public ControladorCorreo() {
        em = emf.createEntityManager();
    }

    public boolean enviarCorreo(PlantillaCorreo plantillaCorreo, Address[] listaDestinatarios) throws NamingException {
        ConfiguracionCorreo configuracionCorreo = consultarConfiguracion();

        Properties propiedades = new Properties();
        propiedades.setProperty("mail.smtp.host", configuracionCorreo.getServidor());
        propiedades.setProperty("mail.smtp.port", configuracionCorreo.getPuerto());
        propiedades.setProperty("mail.smtp.user", configuracionCorreo.getUsuario());
        propiedades.setProperty("mail.smtp.starttls.enable", "true");
        propiedades.setProperty("mail.smtp.auth", "true");

        Session sesion = Session.getDefaultInstance(propiedades);

        try {
            Message mensaje = new MimeMessage(sesion);
            mensaje.setFrom(new InternetAddress(configuracionCorreo.getUsuario()));
            mensaje.addRecipients(Message.RecipientType.TO, listaDestinatarios);

            mensaje.setSubject(plantillaCorreo.getAsunto());
            mensaje.setContent(plantillaCorreo.getContenido(), "text/html");

            Transport t = sesion.getTransport("smtp");
            t.connect(configuracionCorreo.getUsuario(), configuracionCorreo.getContrasenia());
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();

            return true;
        } catch (MessagingException ex) {
            Logger.getLogger(ControladorCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean guardarConfiguracion(ConfiguracionCorreo configuracionCorreo) {
        if (configuracionCorreo == null) {
            return false;
        }
        Utilidades utilidades = new Utilidades();
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Parametro.findByLista");
        List<String> listaNombres = new ArrayList<>();
        listaNombres.add(Constantes.SERVIDOR_CORREO);
        listaNombres.add(Constantes.PUERTO_CORREO);
        listaNombres.add(Constantes.USUARIO_CORREO);
        listaNombres.add(Constantes.CONTRASENIA_CORREO);
        query.setParameter("listaNombres", listaNombres);

        List<Persistencia.Parametro> result = query.getResultList();
        for (Persistencia.Parametro parametro : result) {
            try {
                if (parametro.getNombre().equals(Constantes.SERVIDOR_CORREO)) {
                    parametro.setValor(utilidades.Encriptar(configuracionCorreo.getServidor()));
                }
                if (parametro.getNombre().equals(Constantes.PUERTO_CORREO)) {
                    parametro.setValor(utilidades.Encriptar(configuracionCorreo.getPuerto()));
                }
                if (parametro.getNombre().equals(Constantes.USUARIO_CORREO)) {
                    parametro.setValor(utilidades.Encriptar(configuracionCorreo.getUsuario()));
                }
                if (parametro.getNombre().equals(Constantes.CONTRASENIA_CORREO)) {
                    parametro.setValor(utilidades.Encriptar(configuracionCorreo.getContrasenia()));
                }

                em.persist(parametro);
            } catch (Exception ex) {

            }
        }

        em.getTransaction().commit();
        return true;
    }

    public ConfiguracionCorreo consultarConfiguracion() {
        ConfiguracionCorreo configuracionCorreo = new ConfiguracionCorreo();
        List<String> listaNombres = new ArrayList<>();
        Utilidades utilidades = new Utilidades();
        try {
            Query query = em.createNamedQuery("Parametro.findByLista");
            listaNombres.add(Constantes.SERVIDOR_CORREO);
            listaNombres.add(Constantes.PUERTO_CORREO);
            listaNombres.add(Constantes.USUARIO_CORREO);
            listaNombres.add(Constantes.CONTRASENIA_CORREO);
            query.setParameter("listaNombres", listaNombres);

            List<Persistencia.Parametro> result = query.getResultList();
            for (Persistencia.Parametro parametro : result) {
                try {
                    if (parametro.getNombre().equals(Constantes.SERVIDOR_CORREO)) {
                        configuracionCorreo.setServidor(utilidades.Desencriptar(parametro.getValor()));
                    }
                    if (parametro.getNombre().equals(Constantes.PUERTO_CORREO)) {
                        configuracionCorreo.setPuerto(utilidades.Desencriptar(parametro.getValor()));
                    }
                    if (parametro.getNombre().equals(Constantes.USUARIO_CORREO)) {
                        configuracionCorreo.setUsuario(utilidades.Desencriptar(parametro.getValor()));
                    }
                    if (parametro.getNombre().equals(Constantes.CONTRASENIA_CORREO)) {
                        configuracionCorreo.setContrasenia(utilidades.Desencriptar(parametro.getValor()));
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ControladorCorreo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return configuracionCorreo;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(ControladorCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public PlantillaCorreo consultarPlantillaCorreo(long idPlantillaCorreo) {
        Convertidor convertidor = new Convertidor();
        PlantillaCorreo plantillaCorreo = null;

        Query query = em.createNamedQuery("PlantillaCorreo.findByIdPlantillaCorreo");
        query.setParameter("idPlantillaCorreo", idPlantillaCorreo);

        List results = query.getResultList();
        if (!results.isEmpty()) {
            plantillaCorreo = (PlantillaCorreo) convertidor.convertirAModelo(results.get(0), null, Modelo.PlantillaCorreo.class.getName());
        }

        return plantillaCorreo;
    }

    public Address[] consultarDestinatarios(List<Long> idUsuarios) throws AddressException {
        List<Address> listaDestinatarios = new ArrayList<>();
        Query query = em.createNamedQuery("Usuario.findByIdUsuarios");
        query.setParameter("idUsuarios", idUsuarios);

        List<Persistencia.Usuario> lista = query.getResultList();
        for (Persistencia.Usuario usuario : lista) {
            listaDestinatarios.add(new InternetAddress(usuario.getCorreoInstitucional()));
        }

        Address[] stockArr = new Address[listaDestinatarios.size()];
        System.out.println("Destinatarios: " + listaDestinatarios.size());
        return listaDestinatarios.toArray(stockArr);
    }
}
