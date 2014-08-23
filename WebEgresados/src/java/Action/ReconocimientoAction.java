/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.Ciudad;
import Modelo.ClaseReconocimiento;
import Modelo.Reconocimiento;
import Modelo.TipoReconocimiento;
import Util.Listas;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author YURY
 */
public class ReconocimientoAction extends CrudAction<Reconocimiento>{
    private Map<Long, Ciudad> listaCiudades;
    private Map<Long, TipoReconocimiento> listaTiposReconocimiento;
    private Map<Long, ClaseReconocimiento> listaClasesReconocimiento;
    private long ciudad;
    private long tipoReconocimiento;
    private long claseReconocimiento;
    
    public ReconocimientoAction() {
        super(Reconocimiento.class.getName());
        this.idObjeto = "getIdReconocimiento";
        this.coleccion = "getReconocimientoCollection";
        this.clasePersistencia = Persistencia.Reconocimiento.class.getName();
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
     * @return the listaTiposReconocimiento
     */
    public Collection<TipoReconocimiento> getListaTiposReconocimiento() {
        return listaTiposReconocimiento.values();
    }

    /**
     * @param listaTiposReconocimiento the listaTiposReconocimiento to set
     */
    public void setListaTiposReconocimiento(Map<Long, TipoReconocimiento> listaTiposReconocimiento) {
        this.listaTiposReconocimiento = listaTiposReconocimiento;
    }

    /**
     * @return the listaClasesReconocimiento
     */
    public Collection<ClaseReconocimiento> getListaClasesReconocimiento() {
        return listaClasesReconocimiento.values();
    }

    /**
     * @param listaClasesReconocimiento the listaClasesReconocimiento to set
     */
    public void setListaClasesReconocimiento(Map<Long, ClaseReconocimiento> listaClasesReconocimiento) {
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
    
    @Override
    public String desplegar() {
        this.setListaCiudades(Listas.obtenerListas().getListaCiudades());
        this.setListaClasesReconocimiento(Listas.obtenerListas().getListaClasesReconocimiento());
        this.setListaTiposReconocimiento(Listas.obtenerListas().getListaTiposReconocimiento());
        
        this.obtenerLista();
        this.editar = true;
        return SUCCESS;
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdClaseReconocimiento(Listas.obtenerListas().getListaClasesReconocimiento().get(this.claseReconocimiento));
        this.objeto.setIdCiudad(Listas.obtenerListas().getListaCiudades().get(this.ciudad));
        this.objeto.setIdTipoReconocimiento(Listas.obtenerListas().getListaTiposReconocimiento().get(this.tipoReconocimiento));
    }

    @Override
    public void consultarTipos() {
        this.setCiudad(objeto.getIdCiudad().getIdCiudad());
        this.setTipoReconocimiento(objeto.getIdTipoReconocimiento().getIdTipoReconocimiento());
        this.setClaseReconocimiento(objeto.getIdClaseReconocimiento().getIdClaseReconocimiento());
    }

    @Override
    public void insertarValoresDefecto() {
        this.objeto.setEstado(true);
        this.objeto.setFechaRegistro(Date.valueOf(LocalDate.now()));
    }
}