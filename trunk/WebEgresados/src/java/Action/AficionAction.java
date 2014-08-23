/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.TipoActividad;
import Util.Listas;
import java.util.Map;

/**
 *
 * @author JERONIMO
 */
public class AficionAction  extends CrudAction<AficionAction>{

    private Map<Long,TipoActividad> listaActividad;
    
    public AficionAction(String clase) {
        super(AficionAction.class.getName());
        this.idObjeto = "getidAficion";
        this.coleccion = "getAficionCollection";
        this.clasePersistencia = Persistencia.Aficiones.class.getName();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultarTipos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertarValoresDefecto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Map<Long,TipoActividad> getListaActividad() {
        return listaActividad;
    }

    public void setListaActividad(Map<Long,TipoActividad> listaActividad) {
        this.listaActividad = listaActividad;
    }
    
}
