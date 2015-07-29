/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controlador.ControladorEgresado;
import Controlador.ControladorListas;
import Modelo.Ciudad;
import Modelo.Egresado;
import Modelo.EstadoCivil;
import Modelo.Genero;
import Modelo.GrupoSanguineo;
import Modelo.ItemLista;
import Modelo.PreguntaSeguridad;
import Modelo.TipoDocumento;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author YURY
 */
public class RegistroAction extends ActionSupport implements ModelDriven<Egresado>, ServletRequestAware {

    private List<ItemLista> listaTiposDocumento;
    private List<ItemLista> listaGruposSanguineos;
    private List<ItemLista> listaGeneros;
    private List<ItemLista> listaEstadosCiviles;
    private List<ItemLista> listaPreguntas;
    private long ciudadNacimiento;
    private long ciudadExpedicion;
    private long tipoDocumento;
    private long grupoSanguineo;
    private long genero;
    private long estadoCivil;
    private long preguntaSeguridad;
    private String confirmacionClave;
    private Egresado egresado = new Egresado();
    private boolean terminos;
    private final ControladorEgresado controladorEgresado;
    private final ControladorListas listas;
    private File fileUpload;
    private String fileUploadContentType;
    private String fileUploadFileName;
    private HttpServletRequest servletRequest;
    private String rutaEgresados;

    public RegistroAction() {
        controladorEgresado = new ControladorEgresado();
        listas = new ControladorListas();
        rutaEgresados = "D:\\FotosEgresados\\";
        this.desplegar();
    }

    /**
     * @return the listaTiposDocumento
     */
    public List<ItemLista> getListaTiposDocumento() {
        return listaTiposDocumento;
    }

    /**
     * @param listaTiposDocumento the listaTiposDocumento to set
     */
    public void setListaTiposDocumento(List<ItemLista> listaTiposDocumento) {
        this.listaTiposDocumento = listaTiposDocumento;
    }

    /**
     * @return the listaGruposSanguineos
     */
    public List<ItemLista> getListaGruposSanguineos() {
        return listaGruposSanguineos;
    }

    /**
     * @param listaGruposSanguineos the listaGruposSanguineos to set
     */
    public void setListaGruposSanguineos(List<ItemLista> listaGruposSanguineos) {
        this.listaGruposSanguineos = listaGruposSanguineos;
    }

    /**
     * @return the listaGeneros
     */
    public List<ItemLista> getListaGeneros() {
        return listaGeneros;
    }

    /**
     * @param listaGeneros the listaGeneros to set
     */
    public void setListaGeneros(List<ItemLista> listaGeneros) {
        this.listaGeneros = listaGeneros;
    }

    /**
     * @return the listaEstadosCiviles
     */
    public List<ItemLista> getListaEstadosCiviles() {
        return listaEstadosCiviles;
    }

    /**
     * @param listaEstadosCiviles the listaEstadosCiviles to set
     */
    public void setListaEstadosCiviles(List<ItemLista> listaEstadosCiviles) {
        this.listaEstadosCiviles = listaEstadosCiviles;
    }

    /**
     * @return the listaPreguntas
     */
    public List<ItemLista> getListaPreguntas() {
        return listaPreguntas;
    }

    /**
     * @param listaPreguntas the listaPreguntas to set
     */
    public void setListaPreguntas(List<ItemLista> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }

    /**
     * @return the ciudadNacimiento
     */
    public long getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    /**
     * @param ciudadNacimiento the ciudadNacimiento to set
     */
    public void setCiudadNacimiento(long ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    /**
     * @return the ciudadExpedicion
     */
    public long getCiudadExpedicion() {
        return ciudadExpedicion;
    }

    /**
     * @param ciudadExpedicion the ciudadExpedicion to set
     */
    public void setCiudadExpedicion(long ciudadExpedicion) {
        this.ciudadExpedicion = ciudadExpedicion;
    }

    /**
     * @return the tipoDocumento
     */
    public long getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(long tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * @return the grupoSanguineo
     */
    public long getGrupoSanguineo() {
        return grupoSanguineo;
    }

    /**
     * @param grupoSanguineo the grupoSanguineo to set
     */
    public void setGrupoSanguineo(long grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    /**
     * @return the genero
     */
    public long getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(long genero) {
        this.genero = genero;
    }

    /**
     * @return the estadoCivil
     */
    public long getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(long estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the preguntaSeguridad
     */
    public long getPreguntaSeguridad() {
        return preguntaSeguridad;
    }

    /**
     * @param preguntaSeguridad the preguntaSeguridad to set
     */
    public void setPreguntaSeguridad(long preguntaSeguridad) {
        this.preguntaSeguridad = preguntaSeguridad;
    }

    /**
     * @return the confirmacionClave
     */
    public String getConfirmacionClave() {
        return confirmacionClave;
    }

    /**
     * @param confirmacionClave the confirmacionClave to set
     */
    public void setConfirmacionClave(String confirmacionClave) {
        this.confirmacionClave = confirmacionClave;
    }

    /**
     * @return the terminos
     */
    public boolean isTerminos() {
        return terminos;
    }

    /**
     * @param terminos the terminos to set
     */
    public void setTerminos(boolean terminos) {
        this.terminos = terminos;
    }

    /**
     * @return the egresado
     */
    public Egresado getEgresado() {
        return egresado;
    }

    /**
     * @param egresado the egresado to set
     */
    public void setEgresado(Egresado egresado) {
        this.egresado = egresado;
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
    
    /**
     * @return the rutaEgresados
     */
    public String getRutaEgresados() {
        return rutaEgresados;
    }

    /**
     * @param rutaEgresados the rutaEgresados to set
     */
    public void setRutaEgresados(String rutaEgresados) {
        this.rutaEgresados = rutaEgresados;
    }

    @Override
    public Egresado getModel() {
        return this.egresado;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.servletRequest = hsr;
    }

    private void desplegar() {
        setListaEstadosCiviles(listas.consultarEstadosCiviles());
        setListaGeneros(listas.consultarGeneros());
        setListaGruposSanguineos(listas.consultarGruposSanguineos());
        setListaTiposDocumento(listas.consultarTiposDocumento());
        setListaPreguntas(listas.consultarPreguntas());
    }
    
    public String crear()
    {
        return "crear";
    }

    public String guardar() throws Exception {
        validar();
        if (!this.hasErrors()) {
            insertarTipos();
            insertarValoresDefecto();
            
            this.guardarFoto();
            controladorEgresado.actualizar(getEgresado());
            clearMessages();
            addActionMessage("Felicidades! Usted se ha registrado exitosamente en nuestra base de datos de egresados.\nEn un plazo no mayor a 24 horas se activará su cuenta.");
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public void validar() {
        if (egresado.getPrimerApellido().equals("")) {
            addFieldError("primerApellido", "El primer apellido es requerido.");
        }

        if (egresado.getNombres().equals("")) {
            addFieldError("nombres", "Los nombres son requeridos.");
        }

        if (egresado.getFechaNacimiento() == null) {
            addFieldError("fechaNacimiento", "La fecha de nacimiento es requerida.");
        }

        if (egresado.getNumeroDocumento().equals("")) {
            addFieldError("numeroDocumento", "El número de documento es requerido.");
        }

        if (egresado.getFechaExpedicion() == null) {
            addFieldError("fechaExpedicion", "La fecha de expedición del documento es requerida.");
        }

        if (ciudadExpedicion <= 0) {
            addFieldError("ciudadExpedicion", "La ciudad de expedición del documento es requerida.");
        }

        if (ciudadNacimiento <= 0) {
            addFieldError("ciudadNacimiento", "La ciudad de nacimiento es requerida.");
        }

        if (tipoDocumento <= 0) {
            addFieldError("tipoDocumento", "El tipo de documento es requerido.");
        }

        if (genero <= 0) {
            addFieldError("genero", "El género es requerido.");
        }

        if (grupoSanguineo <= 0) {
            addFieldError("grupoSanguineo", "El grupo sanguíneo es requerido.");
        }

        if (estadoCivil <= 0) {
            addFieldError("estadoCivil", "El estado civil es requerido.");
        }

        if (egresado.getNombre().equals("")) {
            addFieldError("nombre", "El nombre de usuario es requerido");
        }

        if (egresado.getCorreoInstitucional().equals("")) {
            addFieldError("correoInstitucional", "El correo institucional es requerido");
        }

        if (egresado.getContrasenia().equals("")) {
            addFieldError("contrasenia", "La contrasenia es requerida");
        }

        if (!egresado.getContrasenia().equals(confirmacionClave)) {
            addFieldError("confirmacionClave", "La confirmación de contraseña es incorrecta.");
        }

        if (preguntaSeguridad <= 0) {
            addFieldError("preguntaSeguridad", "La pregunta de seguridad es requerida.");
        }

        if (egresado.getRespuestaSeguridad().equals("")) {
            addFieldError("respuestaSeguridad", "La respuesta de seguridad es requerida.");
        }

        if (!terminos) {
            addFieldError("terminos", "Debe aceptar términos y condiciones");
        }
    }

    public void insertarTipos() {
        this.egresado.setIdCiudadExpedicion(new Ciudad(ciudadExpedicion));
        this.egresado.setIdCiudadNacimiento(new Ciudad(ciudadNacimiento));
        this.egresado.setIdEstadoCivil(new EstadoCivil(estadoCivil));
        this.egresado.setIdGenero(new Genero(genero));
        this.egresado.setIdGrupoSanguineo(new GrupoSanguineo(grupoSanguineo));
        this.egresado.setIdPreguntaSeguridad(new PreguntaSeguridad(preguntaSeguridad));
        this.egresado.setIdTipoDocumento(new TipoDocumento(tipoDocumento));
    }

    public void insertarValoresDefecto() {
        this.egresado.setAceptaCondiciones(true);
        this.egresado.setFechaRegistro(Date.valueOf(LocalDate.now()));
        this.egresado.setEstado(true);
    }
    
    private void guardarFoto()
    {
        try {
            String filePath = servletRequest.getRealPath("/");
            
            if (this.fileUploadFileName != null && !this.fileUploadFileName.isEmpty()) {
                File fileToCreate = new File(filePath, this.fileUploadFileName);
                FileUtils.copyFile(this.fileUpload, fileToCreate);
                
                this.egresado.setFoto(this.egresado.getNumeroDocumento() + ".jpg");
                File destino = new File(rutaEgresados, this.egresado.getFoto());
                FileUtils.writeByteArrayToFile(destino, FileUtils.readFileToByteArray(this.fileUpload));
            }
        } catch (IOException ex) {
            Logger.getLogger(RegistroAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}