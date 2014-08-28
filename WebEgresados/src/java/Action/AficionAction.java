/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.Aficion;
import Modelo.TipoActividad;
import Util.Listas;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author JERONIMO
 */
public class AficionAction  extends CrudAction<Aficion>{

    private Map<Long,TipoActividad> listaTiposActividades;
    private long tipoActividad;
    
    public AficionAction() {
        super(Aficion.class.getName());
        this.idObjeto = "getIdAficion";
        this.coleccion = "getAficionesCollection";
        this.claseBasePersistencia = Persistencia.Aficiones.class.getName();
    }
    
    /**
     * @return the listaTiposActividades
     */
    public Collection<TipoActividad> getListaTiposActividades() {
        return listaTiposActividades.values();
    }

    /**
     * @param listaTiposActividades the listaTiposActividades to set
     */
    public void setListaTiposActividades(Map<Long,TipoActividad> listaTiposActividades) {
        this.listaTiposActividades = listaTiposActividades;
    }
    
    /**
     * @return the tipoActividad
     */
    public long getTipoActividad() {
        return tipoActividad;
    }

    /**
     * @param tipoActividad the tipoActividad to set
     */
    public void setTipoActividad(long tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    @Override
    public String desplegar() {
        this.setListaTiposActividades(Listas.obtenerListas().getListaTiposActividades());
        this.obtenerLista();
        this.editar = true;
        return SUCCESS;
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdTipoActividad(Listas.obtenerListas().getListaTiposActividades().get(this.tipoActividad));
    }

    @Override
    public void consultarTipos() {
        this.setTipoActividad(objeto.getIdTipoActividad().getIdTipoActividad());
    }

    @Override
    public void insertarValoresDefecto() {
        this.objeto.setEstado(true);
        this.objeto.setFechaRegistro(Date.valueOf(LocalDate.now()));
    }
}
