/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Persistencia.EstadoLog;
import Util.Constantes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
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
public class ControladorCargueMasivo {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EgresadosPU");
    private final EntityManager em;
    private Persistencia.ProcesoCargue procesoCargue;
    private final EstadoLog exitoso;
    private final EstadoLog error;

    public ControladorCargueMasivo() {
        em = emf.createEntityManager();
        crearProceso();
        exitoso = em.getReference(Persistencia.EstadoLog.class, Constantes.LOG_EXITOSO);
        error = em.getReference(Persistencia.EstadoLog.class, Constantes.LOG_ERROR);
    }

    public long ejecutar(File archivo) {
        if (procesoCargue.getIdProcesoCargue() > 0) {
            Thread proceso = new Thread(() -> {
                cargarArchivo(archivo);
            });

            proceso.start();
        }

        return procesoCargue.getIdProcesoCargue();
    }

    private void cargarArchivo(File archivo) {
        BufferedReader br = null;
        String linea;
        String delimitador = ";";
        int numeroLinea = 0;
        boolean hayErrores = false;

        try {

            iniciarProceso();
            br = new BufferedReader(new FileReader(archivo));
            if ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            while ((linea = br.readLine()) != null) {
                System.out.println("Despues de titulos " + linea);
                numeroLinea++;
                String[] informacion = linea.split(delimitador);
                CargueEgresado cargueEgresado = new CargueEgresado(informacion);
                System.out.println("informacion.length: " + informacion.length);
                if (informacion.length == 58) {
                    cargueEgresado.iniciarTransaccion();
                    if (validarCedula(cargueEgresado.validarDocumento())) {
                        if (validarCorreo(cargueEgresado.validarCorreo())) {
                            System.out.println("Persona Correcta para Ingresar");
                            if (cargueEgresado.crearEgresado()) {
                                cargueEgresado.terminarTransaccion(true);
                                log(numeroLinea, informacion[0], (cargueEgresado.getError() == null ? exitoso : error), cargueEgresado.getError());
                            } else {
                                cargueEgresado.terminarTransaccion(false);
                                log(numeroLinea, informacion[0], error, cargueEgresado.getError());
                                hayErrores = true;
                            }
                        } else {
                            System.out.println("Porfin");
                            cargueEgresado.terminarTransaccion(false);
                            log(numeroLinea, informacion[0], error, "Usuario existente");
                            hayErrores = true;
                        }
                    } else {
                        System.out.println("Otra ves aqui");
                        cargueEgresado.terminarTransaccion(false);
                        log(numeroLinea, informacion[0], error, "Cedula Existente");
                        hayErrores = true;
                    }
                } else {
                    cargueEgresado.terminarTransaccion(false);
                    log(numeroLinea, informacion[0], error, "Estructura del archivo incorrecta");
                    terminarProceso(Constantes.PROCESO_FALLO, "Estructura del archivo incorrecta");
                    hayErrores = true;
                    linea = null;
                }
            }
            terminarProceso((hayErrores ? Constantes.PROCESO_TERMINADO_CON_ERRORES : Constantes.PROCESO_TERMINADO_EXITOSO), null);
        } catch (Exception e) {
            Logger.getLogger(ControladorCargueMasivo.class.getName()).log(Level.SEVERE, null, e);
            terminarProceso(Constantes.PROCESO_TERMINADO_CON_ERRORES, (e.getMessage() != null && e.getMessage().length() > 4000 ? e.getMessage().substring(0, 4000) : e.getMessage()));
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    Logger.getLogger(ControladorCargueMasivo.class.getName()).log(Level.SEVERE, null, e);
                    terminarProceso(Constantes.PROCESO_TERMINADO_CON_ERRORES, (e.getMessage() != null && e.getMessage().length() > 4000 ? e.getMessage().substring(0, 4000) : e.getMessage()));
                }
            }
        }
    }

    public boolean validarCedula(String cedula) {
        try {
            EntityManager em = emf.createEntityManager();
            Query query = em.createNamedQuery("Egresado.findByNumeroDocumento");
            query.setParameter("numeroDocumento", cedula);
            Object result = query.getSingleResult();
            if (result != null) {
                Persistencia.Egresado u = (Persistencia.Egresado) result;
                if (u.getNumeroDocumento().equals(cedula)) {
                    System.out.println("Si existe Cedula");
                    return false;
                }
            }
        } catch (Exception ex) {
            return true;
        }
        return false;
    }

    public boolean validarCorreo(String correo) {
        try {
            System.out.println("Correo " + correo);
            EntityManager em = emf.createEntityManager();
            Query query = em.createNamedQuery("Usuario.findByCorreoInstitucional");
            query.setParameter("correoInstitucional", correo);
            System.out.println("Aqui voy correo 1");
            Object result1 = query.getSingleResult();
            System.out.println("Aqui voy correo 2");
            if (result1 != null) {
                Persistencia.Usuario u = (Persistencia.Usuario) result1;
                System.out.println("asd " + u.getCorreoInstitucional());
                if (u.getCorreoInstitucional().equals(correo)) {
                    System.out.println("Si existe Correo");
                    return false;
                }
            }
        } catch (Exception ex) {
            return true;
        }
        return true;
    }

    private void crearProceso() {
        em.getTransaction().begin();
        procesoCargue = new Persistencia.ProcesoCargue();
        procesoCargue.setFechaInicio(Calendar.getInstance().getTime());
        procesoCargue.setIdEstadoProceso(em.getReference(Persistencia.EstadoProceso.class, Constantes.PROCESO_INICIADO));

        em.persist(procesoCargue);
        em.getTransaction().commit();
        em.refresh(procesoCargue);
    }

    private void iniciarProceso() {
        em.getTransaction().begin();
        procesoCargue.setIdEstadoProceso(em.getReference(Persistencia.EstadoProceso.class, Constantes.PROCESO_EN_EJECUCIÓN));
        em.persist(procesoCargue);
        em.getTransaction().commit();
    }

    private void terminarProceso(long estado, String error) {
        em.getTransaction().begin();
        procesoCargue.setIdEstadoProceso(em.getReference(Persistencia.EstadoProceso.class, estado));
        procesoCargue.setFechaFin(Calendar.getInstance().getTime());
        procesoCargue.setError(error);
        em.persist(procesoCargue);
        em.getTransaction().commit();
    }

    private void log(int linea, String numeroDocumento, EstadoLog estado, String mensajeError) {
        em.getTransaction().begin();
        Persistencia.LogCargue logCargue = new Persistencia.LogCargue();
        logCargue.setIdProcesoCargue(procesoCargue);
        logCargue.setLinea(linea);
        logCargue.setNumeroDocumento(numeroDocumento);
        logCargue.setIdEstadoLog(estado);
        logCargue.setError(mensajeError);
        em.persist(logCargue);
        em.getTransaction().commit();
    }

    public void exportar(String idproceso) {
        System.out.println("idproceso " + idproceso);
        /*EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Logcargue.findAll");
        query.setParameter("idLogCargue", idproceso);
        List<Persistencia.LogCargue> lista = query.getResultList();
        for (Persistencia.LogCargue e : lista) {
            System.out.println(e.getError());   
        }*/
    }
}
