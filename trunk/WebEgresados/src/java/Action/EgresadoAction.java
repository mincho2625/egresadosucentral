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
    
    public void insertarTipos() {
        this.getEgresado().setIdCiudadExpedicion(new Ciudad(ciudad2));
        this.getEgresado().setIdCiudadNacimiento(new Ciudad(ciudad));
        this.getEgresado().setIdEstadoCivil(listas.consultarEstadosCiviles().get(estadoCivil));
        this.getEgresado().setIdGenero(listas.consultarGeneros().get(genero));
        this.getEgresado().setIdGrupoSanguineo(listas.consultarGruposSanguineos().get(grupoSanguineo));
        this.getEgresado().setIdTipoDocumento(listas.consultarTiposDocumento().get(tipoDocumento));
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
}