/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.Asociacion;
import Modelo.Pais;
import Modelo.TipoAsociacion;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author YURY
 */
public class AsociacionAction extends CrudAction<Asociacion> {
    private Map<Long, TipoAsociacion> listaTiposAsociaciones;
    private Map<Long, Pais> listaPaises;
    private long tipoAsociacion;
    private long pais;
    
    public AsociacionAction() {
        super(Asociacion.class.getName());
        this.idObjeto = "getIdAsociacion";
        this.coleccion = "getAsociacionCollection";
        this.claseConcretaPersistencia = Persistencia.Asociacion.class;
    }

    /**
     * @return the listaTiposAsociaciones
     */
    public Collection<TipoAsociacion> getListaTiposAsociaciones() {
        return listaTiposAsociaciones.values();
    }

    /**
     * @param listaTiposAsociaciones the listaTiposAsociaciones to set
     */
    public void setListaTiposAsociaciones(Map<Long, TipoAsociacion> listaTiposAsociaciones) {
        this.listaTiposAsociaciones = listaTiposAsociaciones;
    }

    /**
     * @return the tipoAsociacion
     */
    public long getTipoAsociacion() {
        return tipoAsociacion;
    }

    /**
     * @param tipoAsociacion the tipoAsociacion to set
     */
    public void setTipoAsociacion(long tipoAsociacion) {
        this.tipoAsociacion = tipoAsociacion;
    }
    
    /**
     * @return the listaPaises
     */
    public Collection<Pais> getListaPaises() {
        return listaPaises.values();
    }

    /**
     * @param listaPaises the listaPaises to set
     */
    public void setListaPaises(Map<Long, Pais> listaPaises) {
        this.listaPaises = listaPaises;
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
    
    @Override
    public String desplegar() {
        this.setListaTiposAsociaciones(listas.consultarTiposAsociaciones());
        this.setListaPaises(listas.consultarPaises());
        this.obtenerLista();
        this.editar = true;
        return SUCCESS;
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdTipoAsociacion(listas.consultarTiposAsociaciones().get(this.tipoAsociacion));
        this.objeto.setIdPais(listas.consultarPaises().get(this.pais));
    }

    @Override
    public void consultarTipos() {
        this.setTipoAsociacion(objeto.getIdTipoAsociacion().getIdTipoAsociacion());
        this.setPais(objeto.getIdPais().getIdPais());
    }

    @Override
    public void insertarValoresDefecto() {
        this.objeto.setEstado(true);
        this.objeto.setFechaRegistro(Date.valueOf(LocalDate.now()));
    }

    @Override
    public void validar() {
        if (tipoAsociacion <= 0)
            addFieldError("tipoAsociacion", "El tipo de asociación es requerido.");
        if (pais <= 0)
            addFieldError("pais", "El país es requerido");
        if (objeto.getDescripcion().isEmpty())
            addFieldError("descripcion", "La descripción es requerida");
        if (objeto.getFechaVinculacion() == null)
            addFieldError("fechaVinculacion", "La fecha de vinculación es requerida");
    }

    @Override
    public void validarLista() {
        if (cantidadObjetos == 0)
            addActionError("Ingrese al menos una asociación.");
    }
}