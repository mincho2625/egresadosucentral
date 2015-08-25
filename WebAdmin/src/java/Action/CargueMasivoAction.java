/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controlador.ControladorCargueMasivo;
import Controlador.ControladorCrud;
import Modelo.ProcesoCargue;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author YURY
 */
public class CargueMasivoAction extends ActionSupport {

    private List<Object> listaProcesos;
    private List<Object> listaLogCargue;
    private File fileUpload;
    private String fileUploadContentType;
    private String fileUploadFileName;
    private final ControladorCrud controladorCrud;
    private ControladorCargueMasivo controladorCargueMasivo;
    private String idObjeto;

    public String getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto) {
        this.idObjeto = idObjeto;
    }
    

    public CargueMasivoAction() {
        controladorCrud = new ControladorCrud();
        consultar();
    }

    /**
     * @return the listaProcesos
     */
    public List<Object> getListaProcesos() {
        return listaProcesos;
    }

    /**
     * @param listaProcesos the listaProcesos to set
     */
    public void setListaProcesos(List<Object> listaProcesos) {
        this.listaProcesos = listaProcesos;
    }

    /**
     * @return the listaLogCargue
     */
    public List<Object> getListaLogCargue() {
        return listaLogCargue;
    }

    /**
     * @param listaLogCargue the listaLogCargue to set
     */
    public void setListaLogCargue(List<Object> listaLogCargue) {
        this.listaLogCargue = listaLogCargue;
    }

    /**
     * @return the fileUpload
     */
    public File getFileUpload() {
        return fileUpload;
    }

    /**
     * @param fileUpload the fileUpload to set
     */
    public void setFileUpload(File fileUpload) {
        this.fileUpload = fileUpload;
    }

    /**
     * @return the fileUploadContentType
     */
    public String getFileUploadContentType() {
        return fileUploadContentType;
    }

    /**
     * @param fileUploadContentType the fileUploadContentType to set
     */
    public void setFileUploadContentType(String fileUploadContentType) {
        this.fileUploadContentType = fileUploadContentType;
    }

    /**
     * @return the fileUploadFileName
     */
    public String getFileUploadFileName() {
        return fileUploadFileName;
    }

    /**
     * @param fileUploadFileName the fileUploadFileName to set
     */
    public void setFileUploadFileName(String fileUploadFileName) {
        this.fileUploadFileName = fileUploadFileName;
    }

    public String desplegar() {
        return SUCCESS;
    }

    public String ejecutar() {
        validar();
        if (!hasErrors()) {
            controladorCargueMasivo = new ControladorCargueMasivo();
            long idProceso = controladorCargueMasivo.ejecutar(fileUpload);
            if (idProceso > 0) {
                addActionMessage(String.format("Cargue de egresados iniciado. Proceso: %d.", idProceso));
                consultar();
                return SUCCESS;
            }
            addActionError("Error al crear el proceso de cargue. Intente nuevamente.");
        }

        consultar();
        return ERROR;
    }

    private void validar() {
        if (fileUpload == null) {
            addFieldError("fileUpload", "No ha seleccionado el archivo.");
        }
    }

    private void consultar() {
        listaProcesos = controladorCrud.consultarLista("ProcesoCargue.findAllOrderByFechaInicio", ProcesoCargue.class.getName());
    }

    public String exportar() {
         controladorCargueMasivo = new ControladorCargueMasivo();
         HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
         String objeto = request.getParameter("idObjeto");
         System.out.println("objeto " + objeto);
         if (objeto != null) {
         System.out.println("Ingreso");
         controladorCargueMasivo.exportar(objeto);
         return SUCCESS;
         }/* else {
         System.out.println("No se pudo exportar el proceso.");
         addFieldError("fileUpload", "No se pudo exportar el proceso.");
         return ERROR;
         }*/
         return SUCCESS;
    }
}
