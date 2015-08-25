/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.Asociacion;
import Modelo.ItemLista;
import Modelo.Pais;
import Modelo.TipoAsociacion;
import com.opensymphony.xwork2.ActionContext;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author YURY
 */
public class AsociacionAction extends CrudAction<Asociacion> {
    private List<ItemLista> listaTiposAsociaciones;
    private List<ItemLista> listaPaises;
    private long tipoAsociacion;
    private long pais;
    
    public AsociacionAction() {
        super(Asociacion.class.getName());
        this.getIdObjeto = "getIdAsociacion";
        this.consultaTodos = "Asociacion.findByIdEgresado";
        this.entidad = Asociacion.class.getSimpleName();
        this.nombreIdObjeto = "idAsociacion";
        this.consultaIdObjeto = "Asociacion.findByIdAsociacion";
        
        Map session = ActionContext.getContext().getSession();
        long id = (long) session.get("idEgresado");
        this.parametros = new HashMap<>();
        this.parametros.put("idEgresado", id);
        this.objeto.setIdEgresado(id);
    }

    /**
     * @return the listaTiposAsociaciones
     */
    public List<ItemLista> getListaTiposAsociaciones() {
        return listaTiposAsociaciones;
    }

    /**
     * @param listaTiposAsociaciones the listaTiposAsociaciones to set
     */
    public void setListaTiposAsociaciones(List<ItemLista> listaTiposAsociaciones) {
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
    public List<ItemLista> getListaPaises() {
        return listaPaises;
    }

    /**
     * @param listaPaises the listaPaises to set
     */
    public void setListaPaises(List<ItemLista> listaPaises) {
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
    public void desplegar() {
        this.setListaTiposAsociaciones(listas.consultarTiposAsociaciones());
        this.setListaPaises(listas.consultarPaises());
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdTipoAsociacion(new TipoAsociacion(this.tipoAsociacion));
        this.objeto.setIdPais(new Pais(this.pais));
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