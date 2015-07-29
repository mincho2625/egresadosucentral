/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.Ciudad;
import Modelo.ClaseReconocimiento;
import Modelo.ItemLista;
import Modelo.Reconocimiento;
import Modelo.TipoReconocimiento;
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
public class ReconocimientoAction extends CrudAction<Reconocimiento>{
    private List<ItemLista> listaTiposReconocimiento;
    private List<ItemLista> listaClasesReconocimiento;
    private long ciudad;
    private long tipoReconocimiento;
    private long claseReconocimiento;
    private long pais;
    private long departamento;
    
    public ReconocimientoAction() {
        super(Reconocimiento.class.getName());
        this.getIdObjeto = "getIdReconocimiento";
        this.consultaTodos = "Reconocimiento.findByIdEgresado";
        this.entidad = Reconocimiento.class.getSimpleName();
        this.nombreIdObjeto = "idReconocimiento";
        this.consultaIdObjeto = "Reconocimiento.findByIdReconocimiento";
        
        Map session = ActionContext.getContext().getSession();
        long id = (long) session.get("idEgresado");
        this.parametros = new HashMap<>();
        this.parametros.put("idEgresado", id);
        this.objeto.setIdEgresado(id);
    }

    /**
     * @return the listaTiposReconocimiento
     */
    public List<ItemLista> getListaTiposReconocimiento() {
        return listaTiposReconocimiento;
    }

    /**
     * @param listaTiposReconocimiento the listaTiposReconocimiento to set
     */
    public void setListaTiposReconocimiento(List<ItemLista> listaTiposReconocimiento) {
        this.listaTiposReconocimiento = listaTiposReconocimiento;
    }

    /**
     * @return the listaClasesReconocimiento
     */
    public List<ItemLista> getListaClasesReconocimiento() {
        return listaClasesReconocimiento;
    }

    /**
     * @param listaClasesReconocimiento the listaClasesReconocimiento to set
     */
    public void setListaClasesReconocimiento(List<ItemLista> listaClasesReconocimiento) {
        this.listaClasesReconocimiento = listaClasesReconocimiento;
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
     * @return the tipoReconocimiento
     */
    public long getTipoReconocimiento() {
        return tipoReconocimiento;
    }

    /**
     * @param tipoReconocimiento the tipoReconocimiento to set
     */
    public void setTipoReconocimiento(long tipoReconocimiento) {
        this.tipoReconocimiento = tipoReconocimiento;
    }

    /**
     * @return the claseReconocimiento
     */
    public long getClaseReconocimiento() {
        return claseReconocimiento;
    }

    /**
     * @param claseReconocimiento the claseReconocimiento to set
     */
    public void setClaseReconocimiento(long claseReconocimiento) {
        this.claseReconocimiento = claseReconocimiento;
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
    public void desplegar() {
        this.setListaClasesReconocimiento(listas.consultarClasesReconocimiento());
        this.setListaTiposReconocimiento(listas.consultarTiposReconocimiento());
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdClaseReconocimiento(new ClaseReconocimiento(this.claseReconocimiento));
        this.objeto.setIdCiudad(new Ciudad(this.ciudad));
        this.objeto.setIdTipoReconocimiento(new TipoReconocimiento(this.tipoReconocimiento));
    }

    @Override
    public void consultarTipos() {
        this.setPais(objeto.getIdCiudad().getIdDepartamento().getIdPais().getIdPais());
        this.setDepartamento(objeto.getIdCiudad().getIdDepartamento().getIdDepartamento());
        this.setCiudad(objeto.getIdCiudad().getIdCiudad());
        this.setTipoReconocimiento(objeto.getIdTipoReconocimiento().getIdTipoReconocimiento());
        this.setClaseReconocimiento(objeto.getIdClaseReconocimiento().getIdClaseReconocimiento());
    }

    @Override
    public void insertarValoresDefecto() {
        this.objeto.setEstado(true);
        this.objeto.setFechaRegistro(Date.valueOf(LocalDate.now()));
    }

    @Override
    public void validar() {
        if (tipoReconocimiento <= 0)
            addFieldError("tipoReconocimiento", "El tipo de reconocimiento es requerido.");
        if (claseReconocimiento <= 0)
            addFieldError("claseReconocimiento", "La clase de reconocimiento es requerida.");
        if (objeto.getEntidadOtorgante().isEmpty())
            addFieldError("entidadOtorgante", "La entidad otorgante es requerida.");
        if (objeto.getFechaReconocimiento() == null)
            addFieldError("fechaReconocimiento", "La fecha de reconocimiento es requerida.");
        if (ciudad <= 0)
            addFieldError("ciudad", "La ciudad es requerida.");
    }

    @Override
    public void validarLista() {
        
    }
}