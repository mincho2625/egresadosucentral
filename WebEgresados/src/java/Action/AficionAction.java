/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.Aficion;
import Modelo.TipoActividad;
import Util.Listas;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author JERONIMO
 */
public class AficionAction  extends CrudAction<Aficion>{

    private Map<Long,TipoActividad> listaActividad;
    private long tipoActividad;
    
    public AficionAction() {
        super(Aficion.class.getName());
        this.idObjeto = "getIdAficion";
        this.coleccion = "getAficionesCollection";
        this.clasePersistencia = Persistencia.Aficiones.class.getName();
    }
    
    public Collection<TipoActividad> getListaActividad() {
        return listaActividad.values();
    }

    public void setListaActividad(Map<Long,TipoActividad> listaActividad) {
        this.listaActividad = listaActividad;
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
        this.setListaActividad(Listas.obtenerListas().getListaActividad());
        this.obtenerLista();
        this.editar = true;
        return SUCCESS;
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdTipoActividad(Listas.obtenerListas().getListaActividad().get(this.tipoActividad));
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
