/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Persistencia.EstadoLog;
import Util.Constantes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 *
 * @author YURY
 */
public class ControladorCargueMasivo {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EgresadosPU");
    private final EntityManager em;
    private Persistencia.ProcesoCargue procesoCargue;
    private Persistencia.LogCargue logcargue;
    private final EstadoLog exitoso;
    private final EstadoLog error;
    private long idproceso;
    private List<Persistencia.LogCargue> lista;
    private DataModel dataModelCabecera;
    private DataModel dataModelContenido;

    public ControladorCargueMasivo() {
        em = emf.createEntityManager();
        crearProceso();
        exitoso = em.getReference(Persistencia.EstadoLog.class, Constantes.LOG_EXITOSO);
        error = em.getReference(Persistencia.EstadoLog.class, Constantes.LOG_ERROR);
    }

    public ControladorCargueMasivo(long idproces) {
        em = emf.createEntityManager();
        inicializar();
        idproceso = idproces;
        exitoso = em.getReference(Persistencia.EstadoLog.class, Constantes.LOG_EXITOSO);
        error = em.getReference(Persistencia.EstadoLog.class, Constantes.LOG_ERROR);
    }

    public DataModel getDataModelCabecera() {
        return dataModelCabecera;
    }

    public void setDataModelCabecera(DataModel dataModelCabecera) {
        this.dataModelCabecera = dataModelCabecera;
    }

    public DataModel getDataModelContenido() {
        return dataModelContenido;
    }

    public void setDataModelContenido(DataModel dataModelContenido) {
        this.dataModelContenido = dataModelContenido;
    }

    public final void inicializar() {
        em.getTransaction().begin();
        logcargue = new Persistencia.LogCargue();
        procesoCargue = new Persistencia.ProcesoCargue();
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

    public int exportar() {
        System.out.println("idproceso " + idproceso);
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("ProcesoCargue.findAll");
        query.setParameter("idProcesoCargue", idproceso);
        List<Persistencia.ProcesoCargue> listapro = query.getResultList();
        for (Persistencia.ProcesoCargue e : listapro) {
            System.out.println("ID proceso cargue" + e.getIdProcesoCargue());
            EntityManager em1 = emf.createEntityManager();
            Query query1 = em1.createNamedQuery("Logcargue.findAll");
            query1.setParameter("idProcesoCargue", em.getReference(Persistencia.ProcesoCargue.class, e.getIdProcesoCargue()));
            lista = query1.getResultList();
            if (lista != null) {
                if (!exportarExcel()) {
                    return 1;
                }
            }else{
                return 2;
            }
        }
        return 0;
    }

    public boolean exportarExcel() {
        dataModelReporte();
        HSSFWorkbook hssfWorkbook = obtenerExcel(dataModelContenido,
                dataModelCabecera, "log cargue masivo");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(
                    "log_cargue.xls");
            hssfWorkbook.write(fileOutputStream);
            fileOutputStream.close();
            File x = new File("log_cargue.xls");
            String path=x.getAbsolutePath();
            path= path.replace("\\", "\\"+"\\");
            System.out.println("path "+path);
            Runtime.getRuntime().exec("cmd /c start "+path);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static HSSFWorkbook obtenerExcel(DataModel contenidoCeldas,
            DataModel cabecerasCeldas, String nombreHoja) {

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = hssfWorkbook.createSheet(nombreHoja);
        int numeroFila = 0;
        int numeroColumna = 0;
        HSSFRow hssfRow = hssfSheet.createRow(numeroFila++);
        HSSFCellStyle hssfCellStyleCabecera = hssfWorkbook.createCellStyle();
        hssfCellStyleCabecera.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        hssfCellStyleCabecera.setFillBackgroundColor(new HSSFColor.BLACK()
                .getIndex());
        HSSFFont hssfFont = hssfWorkbook.createFont();
        hssfFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        hssfFont.setColor(HSSFColor.WHITE.index);
        hssfCellStyleCabecera.setFont(hssfFont);
        String columnaCabecera;
        HSSFCell hssfCell = null;
        List cabecerasExcel = (List) cabecerasCeldas.getWrappedData();
        for (int i = 0; i < cabecerasExcel.size(); i++) {
            columnaCabecera = (String) cabecerasExcel.get(i);
            hssfCell = hssfRow.createCell((short) numeroColumna++);
            hssfCell.setCellValue(columnaCabecera);
            hssfCell.setCellStyle(hssfCellStyleCabecera);
        }
        List contenidoExcel = (List) contenidoCeldas.getWrappedData();
        List fila = null;
        Object valor;
        for (int i = 0; i < contenidoExcel.size(); i++) {
            fila = (List) contenidoExcel.get(i);
            hssfRow = hssfSheet.createRow(numeroFila++);
            numeroColumna = 0;
            for (int x = 0; x < fila.size(); x++) {
                valor = fila.get(x);
                hssfCell = hssfRow.createCell((short) numeroColumna++);
                hssfCell.setCellValue((String) valor);
            }
        }
        return hssfWorkbook;
    }

    public void dataModelReporte() {
        List listaFinal = new ArrayList();
        List listaCabeceras = new ArrayList();

        listaCabeceras.add("Id log cargue");
        listaCabeceras.add("Numero documento");
        listaCabeceras.add("Linea");
        listaCabeceras.add("Id proceso cargue");
        listaCabeceras.add("Id estado log");
        listaCabeceras.add("Error");
        this.setDataModelCabecera(new ListDataModel(
                listaCabeceras));
        try {
            List listaFila = null;

            for (Persistencia.LogCargue e2 : lista) {
                listaFila = new ArrayList();
                listaFila.add(String.valueOf(e2.getIdLogCargue()));
                listaFila.add(e2.getNumeroDocumento());
                listaFila.add(String.valueOf(e2.getLinea()));
                listaFila.add(String.valueOf(e2.getIdProcesoCargue().getIdProcesoCargue()));
                listaFila.add(String.valueOf(e2.getIdLogCargue()));
                listaFila.add(e2.getError());
                listaFinal.add(listaFila);
            }

            this.setDataModelContenido(new ListDataModel(listaFinal));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            listaFinal = new ArrayList();
        }
    }
}
