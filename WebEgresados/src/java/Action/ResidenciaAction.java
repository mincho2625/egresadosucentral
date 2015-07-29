/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.Ciudad;
import Modelo.Estrato;
import Modelo.ItemLista;
import Modelo.Residencia;
import Modelo.TipoTenenciaVivienda;
import Modelo.TipoVivienda;
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
public class ResidenciaAction extends CrudAction<Residencia> {
    private List<ItemLista> listaTiposVivienda;
    private List<ItemLista> listaTiposTenenciaVivienda;
    private List<ItemLista> listaEstratos;
    private long tipoVivienda;
    private long tipoTenenciaVivienda;
    private long estrato;
    private long ciudad;
    private long pais;
    private long departamento;
    
    public ResidenciaAction()
    {
        super(Residencia.class.getName());
        this.getIdObjeto = "getIdResidencia";
        this.consultaTodos = "Residencia.findByIdEgresado";
        this.entidad = Residencia.class.getSimpleName();
        this.nombreIdObjeto = "idResidencia";
        this.consultaIdObjeto = "Residencia.findByIdResidencia";
        
        Map session = ActionContext.getContext().getSession();
        long id = (long) session.get("idEgresado");
        this.parametros = new HashMap<>();
        this.parametros.put("idEgresado", id);
        this.objeto.setIdEgresado(id);
    }

    /**
     * @return the listaTiposVivienda
     */
    public List<ItemLista> getListaTiposVivienda() {
        return listaTiposVivienda;
    }

    /**
     * @param listaTiposVivienda the listaTiposVivienda to set
     */
    public void setListaTiposVivienda(List<ItemLista> listaTiposVivienda) {
        this.listaTiposVivienda = listaTiposVivienda;
    }

    /**
     * @return the listaTiposTenenciaVivienda
     */
    public List<ItemLista> getListaTiposTenenciaVivienda() {
        return listaTiposTenenciaVivienda;
    }

    /**
     * @param listaTiposTenenciaVivienda the listaTiposTenenciaVivienda to set
     */
    public void setListaTiposTenenciaVivienda(List<ItemLista> listaTiposTenenciaVivienda) {
        this.listaTiposTenenciaVivienda = listaTiposTenenciaVivienda;
    }

    /**
     * @return the listaEstratos
     */
    public List<ItemLista> getListaEstratos() {
        return listaEstratos;
    }

    /**
     * @param listaEstratos the listaEstratos to set
     */
    public void setListaEstratos(List<ItemLista> listaEstratos) {
        this.listaEstratos = listaEstratos;
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
    
    @Override
    public void desplegar()
    {
        this.setListaTiposVivienda(listas.consultarTiposVivienda());
        this.setListaTiposTenenciaVivienda(listas.consultarTiposTenenciaVivienda());
        this.setListaEstratos(listas.consultarEstratos());
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdCiudad(new Ciudad(ciudad));
        this.objeto.setIdTipoTenenciaVivienda(new TipoTenenciaVivienda(this.tipoTenenciaVivienda));
        this.objeto.setIdTipoVivienda(new TipoVivienda(this.tipoVivienda));
        this.objeto.setIdEstrato(new Estrato(this.estrato));
    }

    @Override
    public void consultarTipos() {
        this.setPais(objeto.getIdCiudad().getIdDepartamento().getIdPais().getIdPais());
        this.setDepartamento(objeto.getIdCiudad().getIdDepartamento().getIdDepartamento());
        this.setCiudad(objeto.getIdCiudad().getIdCiudad());
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
        System.out.println("Ciudad: " + ciudad);
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