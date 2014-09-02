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
    
    private ControladorEgresado controladorEgresado;
    private Egresado egresado;
    private Map<Long, Ciudad> listaCiudades;
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
        
    public EgresadoAction()
    {
        Map session = ActionContext.getContext().getSession();
        String usuario = (String) session.get("usuario");
        controladorEgresado = new ControladorEgresado(usuario);
        this.egresado = controladorEgresado.consultar();
    }

    /**
     * @return the listaCiudades
     */
    public Collection<Ciudad> getListaCiudades() {
        return listaCiudades.values();
    }

    /**
     * @param listaCiudades the listaCiudades to set
     */
    public void setListaCiudades(Map<Long, Ciudad> listaCiudades) {
        this.listaCiudades = listaCiudades;
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
    
    public void insertarTipos() {
        this.getEgresado().setIdCiudadExpedicion(Listas.obtenerListas().getListaCiudades().get(ciudadExpedicion));
        this.getEgresado().setIdCiudadNacimiento(Listas.obtenerListas().getListaCiudades().get(ciudadNacimiento));
        this.getEgresado().setIdEstadoCivil(Listas.obtenerListas().getListaEstadosCiviles().get(estadoCivil));
        this.getEgresado().setIdGenero(Listas.obtenerListas().getListaGeneros().get(genero));
        this.getEgresado().setIdGrupoSanguineo(Listas.obtenerListas().getListaGruposSanguineos().get(grupoSanguineo));
        this.getEgresado().setIdTipoDocumento(Listas.obtenerListas().getListaTiposDocumento().get(tipoDocumento));
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

    public String guardar()
    {
        try {
            insertarTipos();
            insertarValoresDefecto();
            controladorEgresado.actualizar(getEgresado());
            return SUCCESS;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(CrudAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return SUCCESS;
    }
    
    public String editar()
    {
        this.setListaCiudades(Listas.obtenerListas().getListaCiudades());
        this.setListaEstadosCiviles(Listas.obtenerListas().getListaEstadosCiviles());
        this.setListaGeneros(Listas.obtenerListas().getListaGeneros());
        this.setListaGruposSanguineos(Listas.obtenerListas().getListaGruposSanguineos());
        this.setListaTiposDocumento(Listas.obtenerListas().getListaTiposDocumento());
        
        this.consultarTipos();
        return "editar";
    }

    @Override
    public Egresado getModel() {
        return getEgresado();
    }
}