/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.Ciudad;
import Modelo.Estrato;
import Modelo.Residencia;
import Modelo.TipoTenenciaVivienda;
import Modelo.TipoVivienda;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author YURY
 */
public class ResidenciaAction extends CrudAction<Residencia> {
    private Map<Long, TipoVivienda> listaTiposVivienda;
    private Map<Long, TipoTenenciaVivienda> listaTiposTenenciaVivienda;
    private Map<Long, Estrato> listaEstratos;
    private Map<Long, Ciudad> listaCiudades;
    private long tipoVivienda;
    private long tipoTenenciaVivienda;
    private long estrato;
    private long ciudad;
    
    public ResidenciaAction()
    {
        super(Residencia.class.getName());
        this.idObjeto = "getIdResidencia";
        this.coleccion = "getResidenciaCollection";
        this.claseConcretaPersistencia = Persistencia.Residencia.class;
    }

    /**
     * @return the listaTiposVivienda
     */
    public Collection<TipoVivienda> getListaTiposVivienda() {
        return listaTiposVivienda.values();
    }

    /**
     * @param listaTiposVivienda the listaTiposVivienda to set
     */
    public void setListaTiposVivienda(Map<Long, TipoVivienda> listaTiposVivienda) {
        this.listaTiposVivienda = listaTiposVivienda;
    }

    /**
     * @return the listaTiposTenenciaVivienda
     */
    public Collection<TipoTenenciaVivienda> getListaTiposTenenciaVivienda() {
        return listaTiposTenenciaVivienda.values();
    }

    /**
     * @param listaTiposTenenciaVivienda the listaTiposTenenciaVivienda to set
     */
    public void setListaTiposTenenciaVivienda(Map<Long, TipoTenenciaVivienda> listaTiposTenenciaVivienda) {
        this.listaTiposTenenciaVivienda = listaTiposTenenciaVivienda;
    }

    /**
     * @return the listaEstratos
     */
    public Collection<Estrato> getListaEstratos() {
        return listaEstratos.values();
    }

    /**
     * @param listaEstratos the listaEstratos to set
     */
    public void setListaEstratos(Map<Long, Estrato> listaEstratos) {
        this.listaEstratos = listaEstratos;
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
     * @return the tipoVivienda
     */
    public long getTipoVivienda() {
        return tipoVivienda;
    }

    /**
     * @param tipoVivienda the tipoVivienda to set
     */
    public void setTipoVivienda(long tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    /**
     * @return the tipoTenenciaVivienda
     */
    public long getTipoTenenciaVivienda() {
        return tipoTenenciaVivienda;
    }

    /**
     * @param tipoTenenciaVivienda the tipoTenenciaVivienda to set
     */
    public void setTipoTenenciaVivienda(long tipoTenenciaVivienda) {
        this.tipoTenenciaVivienda = tipoTenenciaVivienda;
    }

    /**
     * @return the estrato
     */
    public long getEstrato() {
        return estrato;
    }

    /**
     * @param estrato the estrato to set
     */
    public void setEstrato(long estrato) {
        this.estrato = estrato;
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
    
    @Override
    public String desplegar()
    {
        this.obtenerLista();
        this.setListaTiposVivienda(listas.getListaTiposVivienda());
        this.setListaTiposTenenciaVivienda(listas.getListaTiposTenenciaVivienda());
        this.setListaEstratos(listas.getListaEstratos());
        this.setListaCiudades(listas.getListaCiudades());
        this.editar = true;
        return SUCCESS;
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdCiudadResidencia(listas.getListaCiudades().get(this.ciudad));
        this.objeto.setIdTipoTenenciaVivienda(listas.getListaTiposTenenciaVivienda().get(this.tipoTenenciaVivienda));
        this.objeto.setIdTipoVivienda(listas.getListaTiposVivienda().get(this.tipoVivienda));
        this.objeto.setIdEstrato(listas.getListaEstratos().get(this.estrato));
    }

    @Override
    public void consultarTipos() {
        this.setCiudad(objeto.getIdCiudadResidencia().getIdCiudad());
        this.setTipoTenenciaVivienda(objeto.getIdTipoTenenciaVivienda().getIdTipoTenenciaVivienda());
        this.setTipoVivienda(objeto.getIdTipoVivienda().getIdTipoVivienda());
        this.setEstrato(objeto.getIdEstrato().getIdEstrato());
    }

    @Override
    public void insertarValoresDefecto() {
        this.objeto.setEstado(true);
        this.objeto.setFechaRegistro(Date.valueOf(LocalDate.now()));
    }

    @Override
    public void validar() {
        if (ciudad <= 0)
            addFieldError("ciudad", "La ciudad es requerida.");
        if (tipoVivienda <= 0)
            addFieldError("tipoVivienda", "El tipo de vivienda es requerido.");
        if (tipoTenenciaVivienda <= 0)
            addFieldError("tipoTenenciaVivienda", "Tipo de tenencia vivienda es requerido.");
        if (objeto.getDireccion().isEmpty())
            addFieldError("direccion", "La dirección es requerida.");
        if (estrato <= 0)
            addFieldError("estrato", "El estrato es requerido.");
    }

    @Override
    public void validarLista() {
        if (cantidadObjetos == 0)
            addActionError("Ingrese al menos una dirección de residencia.");
    }
}