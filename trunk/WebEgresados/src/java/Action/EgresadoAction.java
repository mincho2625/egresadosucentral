/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorEgresado;
import Modelo.Ciudad;
import Modelo.Egresado;
import Modelo.EstadoCivil;
import Modelo.Genero;
import Modelo.GrupoSanguineo;
import Modelo.TipoDocumento;
import Util.Listas;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YURY
 */
public class EgresadoAction extends ActionSupport implements ModelDriven<Egresado> {
    
    private final ControladorEgresado controladorEgresado;
    private final Listas listas;
    private Egresado egresado;
    private Map<Long, TipoDocumento> listaTiposDocumento;
    private Map<Long, GrupoSanguineo> listaGruposSanguineos;
    private Map<Long, Genero> listaGeneros;
    private Map<Long, EstadoCivil> listaEstadosCiviles;
    private long ciudadExpedicion;
    private long ciudadNacimiento;
    private long tipoDocumento;
    private long grupoSanguineo;
    private long genero;
    private long estadoCivil;
    private boolean terminos;
    private long departamentoNacimiento;
    private long departamentoExpedicion;
    private long paisNacimiento;
    private long paisExpedicion;
        
    public EgresadoAction()
    {
        Map session = ActionContext.getContext().getSession();
        String usuario = (String) session.get("usuario");
        controladorEgresado = new ControladorEgresado(usuario);
        this.egresado = controladorEgresado.consultar();
        this.listas = new Listas();
    }

    /**
     * @return the listaTiposDocumento
     */
    public Collection<TipoDocumento> getListaTiposDocumento() {
        return listaTiposDocumento.values();
    }

    /**
     * @param listaTiposDocumento the listaTiposDocumento to set
     */
    public void setListaTiposDocumento(Map<Long, TipoDocumento> listaTiposDocumento) {
        this.listaTiposDocumento = listaTiposDocumento;
    }

    /**
     * @return the listaGruposSanguineos
     */
    public Collection<GrupoSanguineo> getListaGruposSanguineos() {
        return listaGruposSanguineos.values();
    }

    /**
     * @param listaGruposSanguineos the listaGruposSanguineos to set
     */
    public void setListaGruposSanguineos(Map<Long, GrupoSanguineo> listaGruposSanguineos) {
        this.listaGruposSanguineos = listaGruposSanguineos;
    }

    /**
     * @return the listaGeneros
     */
    public Collection<Genero> getListaGeneros() {
        return listaGeneros.values();
    }

    /**
     * @param listaGeneros the listaGeneros to set
     */
    public void setListaGeneros(Map<Long, Genero> listaGeneros) {
        this.listaGeneros = listaGeneros;
    }

    /**
     * @return the listaEstadosCiviles
     */
    public Collection<EstadoCivil> getListaEstadosCiviles() {
        return listaEstadosCiviles.values();
    }

    /**
     * @param listaEstadosCiviles the listaEstadosCiviles to set
     */
    public void setListaEstadosCiviles(Map<Long, EstadoCivil> listaEstadosCiviles) {
        this.listaEstadosCiviles = listaEstadosCiviles;
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
     * @return the departamentoNacimiento
     */
    public long getDepartamentoNacimiento() {
        return departamentoNacimiento;
    }

    /**
     * @param departamentoNacimiento the departamentoNacimiento to set
     */
    public void setDepartamentoNacimiento(long departamentoNacimiento) {
        this.departamentoNacimiento = departamentoNacimiento;
    }

    /**
     * @return the departamentoExpedicion
     */
    public long getDepartamentoExpedicion() {
        return departamentoExpedicion;
    }

    /**
     * @param departamentoExpedicion the departamentoExpedicion to set
     */
    public void setDepartamentoExpedicion(long departamentoExpedicion) {
        this.departamentoExpedicion = departamentoExpedicion;
    }

    /**
     * @return the paisNacimiento
     */
    public long getPaisNacimiento() {
        return paisNacimiento;
    }

    /**
     * @param paisNacimiento the paisNacimiento to set
     */
    public void setPaisNacimiento(long paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    /**
     * @return the paisExpedicion
     */
    public long getPaisExpedicion() {
        return paisExpedicion;
    }

    /**
     * @param paisExpedicion the paisExpedicion to set
     */
    public void setPaisExpedicion(long paisExpedicion) {
        this.paisExpedicion = paisExpedicion;
    }
    
    public void insertarTipos() {
        this.getEgresado().setIdCiudadExpedicion(new Ciudad(ciudadExpedicion));
        this.getEgresado().setIdCiudadNacimiento(new Ciudad(ciudadNacimiento));
        this.getEgresado().setIdEstadoCivil(listas.consultarEstadosCiviles().get(estadoCivil));
        this.getEgresado().setIdGenero(listas.consultarGeneros().get(genero));
        this.getEgresado().setIdGrupoSanguineo(listas.consultarGruposSanguineos().get(grupoSanguineo));
        this.getEgresado().setIdTipoDocumento(listas.consultarTiposDocumento().get(tipoDocumento));
    }

    public void consultarTipos() {
        this.setCiudadExpedicion(this.getEgresado().getIdCiudadExpedicion().getIdCiudad());
        this.setCiudadNacimiento(this.getEgresado().getIdCiudadNacimiento().getIdCiudad());
        this.setEstadoCivil(this.getEgresado().getIdEstadoCivil().getIdEstadoCivil());
        this.setGenero(this.getEgresado().getIdGenero().getIdGenero());
        this.setGrupoSanguineo(this.getEgresado().getIdGrupoSanguineo().getIdGrupoSanguineo());
        this.setTipoDocumento(this.getEgresado().getIdTipoDocumento().getIdTipoDocumento());
    }

    public void insertarValoresDefecto() {
        this.getEgresado().setAceptaCondiciones(true);
        this.getEgresado().setFechaUltimaAct(Date.valueOf(LocalDate.now()));
    }
        
    public String editar()
    {
        this.setListaEstadosCiviles(listas.consultarEstadosCiviles());
        this.setListaGeneros(listas.consultarGeneros());
        this.setListaGruposSanguineos(listas.consultarGruposSanguineos());
        this.setListaTiposDocumento(listas.consultarTiposDocumento());
        
        this.consultarTipos();
        return INPUT;
    }

    @Override
    public Egresado getModel() {
        return getEgresado();
    }

    @Override
    public String execute() throws Exception {
        try {
            validar();
            if (!this.hasErrors()) {
                insertarTipos();
                insertarValoresDefecto();
                controladorEgresado.actualizar(getEgresado());
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
}