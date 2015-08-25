/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorCrud;
import Controlador.ControladorListas;
import Modelo.Ciudad;
import Modelo.Egresado;
import Modelo.EstadoCivil;
import Modelo.Genero;
import Modelo.GrupoSanguineo;
import Modelo.ItemLista;
import Modelo.TipoDocumento;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author YURY
 */
public class EgresadoAction extends ActionSupport implements ModelDriven<Egresado>, ServletRequestAware {
    
    private final ControladorCrud controladorCrud;
    private final ControladorListas listas;
    private Egresado egresado;
    private List<ItemLista> listaTiposDocumento;
    private List<ItemLista> listaGruposSanguineos;
    private List<ItemLista> listaGeneros;
    private List<ItemLista> listaEstadosCiviles;
    private long tipoDocumento;
    private long grupoSanguineo;
    private long genero;
    private long estadoCivil;
    private boolean terminos;
    private long ciudad; //Nacimiento
    private long ciudad2; //Expedición
    private long departamento;
    private long departamento2;
    private long pais;
    private long pais2;
    private File fileUpload;
    private String fileUploadContentType;
    private String fileUploadFileName;
    private HttpServletRequest servletRequest;
    private String rutaEgresados;
    
    public EgresadoAction()
    {
        Map session = ActionContext.getContext().getSession();
        long idEgresado = (long) session.get("idEgresado");
        controladorCrud = new ControladorCrud();
        this.egresado = (Egresado) controladorCrud.consultar("Egresado.findByIdEgresado", 
                Modelo.Egresado.class.getName(), "idEgresado", idEgresado, Modelo.Usuario.class.getName());
        this.listas = new ControladorListas();
        this.desplegar();
        rutaEgresados = "D:\\FotosEgresados\\";
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
     * @return the ciudad
     */
    public long getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(long ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the ciudad2
     */
    public long getCiudad2() {
        return ciudad2;
    }

    /**
     * @param ciudad2 the ciudad2 to set
     */
    public void setCiudad2(long ciudad2) {
        this.ciudad2 = ciudad2;
    }

    /**
     * @return the departamento
     */
    public long getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(long departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the departamento2
     */
    public long getDepartamento2() {
        return departamento2;
    }

    /**
     * @param departamento2 the departamento2 to set
     */
    public void setDepartamento2(long departamento2) {
        this.departamento2 = departamento2;
    }

    /**
     * @return the pais
     */
    public long getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(long pais) {
        this.pais = pais;
    }

    /**
     * @return the pais2
     */
    public long getPais2() {
        return pais2;
    }

    /**
     * @param pais2 the pais2 to set
     */
    public void setPais2(long pais2) {
        this.pais2 = pais2;
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
    
    public void insertarTipos() {
        this.getEgresado().setIdCiudadExpedicion(new Ciudad(ciudad2));
        this.getEgresado().setIdCiudadNacimiento(new Ciudad(ciudad));
        this.getEgresado().setIdEstadoCivil(new EstadoCivil(estadoCivil));
        this.getEgresado().setIdGenero(new Genero(genero));
        this.getEgresado().setIdGrupoSanguineo(new GrupoSanguineo(grupoSanguineo));
        this.getEgresado().setIdTipoDocumento(new TipoDocumento(tipoDocumento));
    }

    public void consultarTipos() {
        this.setPais(this.getEgresado().getIdCiudadNacimiento().getIdDepartamento().getIdPais().getIdPais());
        this.setDepartamento(this.getEgresado().getIdCiudadNacimiento().getIdDepartamento().getIdDepartamento());
        this.setCiudad(this.getEgresado().getIdCiudadNacimiento().getIdCiudad());
        this.setPais2(this.getEgresado().getIdCiudadExpedicion().getIdDepartamento().getIdPais().getIdPais());
        this.setDepartamento2(this.getEgresado().getIdCiudadExpedicion().getIdDepartamento().getIdDepartamento());
        this.setCiudad2(this.getEgresado().getIdCiudadExpedicion().getIdCiudad());
        this.setEstadoCivil(this.getEgresado().getIdEstadoCivil().getIdEstadoCivil());
        this.setGenero(this.getEgresado().getIdGenero().getIdGenero());
        this.setGrupoSanguineo(this.getEgresado().getIdGrupoSanguineo().getIdGrupoSanguineo());
        this.setTipoDocumento(this.getEgresado().getIdTipoDocumento().getIdTipoDocumento());
    }

    public void insertarValoresDefecto() {
        this.getEgresado().setAceptaCondiciones(true);
    }
    
    private void desplegar()
    {
        this.setListaEstadosCiviles(listas.consultarEstadosCiviles());
        this.setListaGeneros(listas.consultarGeneros());
        this.setListaGruposSanguineos(listas.consultarGruposSanguineos());
        this.setListaTiposDocumento(listas.consultarTiposDocumento());
    }
    
    public String editar()
    {
        this.consultarTipos();
        return "editar";
    }

    @Override
    public Egresado getModel() {
        return getEgresado();
    }
    
    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.servletRequest = hsr;
    }

    @Override
    public String execute() throws Exception {
        try {
            validar();
            if (!this.hasErrors()) {
                insertarTipos();
                insertarValoresDefecto();
                guardarFoto();
                controladorCrud.actualizar(egresado, Egresado.class.getSimpleName(), "getIdUsuario");
                return SUCCESS;
            }
            else
            {
                editar();
                return ERROR;
            }
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(CrudAction.class.getName()).log(Level.SEVERE, null, ex);
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
        if (ciudad2 <= 0) {
            addFieldError("ciudadExpedicion", "La ciudad de expedición del documento es requerida.");
        }
        if (ciudad <= 0) {
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
    }

    public String siguiente()
    {
        consultarTipos();
        validar();
        if (hasErrors()) {
            editar();
            return ERROR;
        }
        else {
            return SUCCESS;
        }
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