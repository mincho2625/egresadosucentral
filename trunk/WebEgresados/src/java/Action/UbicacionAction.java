/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Modelo.Contacto;
import Modelo.TipoContacto;
import Util.Listas;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author YURY
 */
public class UbicacionAction extends CrudAction<Contacto> {

    private Map<Long, TipoContacto> listaTiposContacto;
    private long tipoContacto;

    public UbicacionAction() {
        super(Modelo.Contacto.class.getName());
        this.idObjeto = "getIdContacto";
        this.coleccion = "getContactoCollection";
        this.claseConcretaPersistencia = Persistencia.Contacto.class;
    }

    /**
     * @return the listaTiposContacto
     */
    public Collection<TipoContacto> getListaTiposContacto() {
        return listaTiposContacto.values();
    }

    /**
     * @param listaTiposContacto the listaTiposContacto to set
     */
    public void setListaTiposContacto(Map<Long, TipoContacto> listaTiposContacto) {
        this.listaTiposContacto = listaTiposContacto;
    }

    /**
     * @return the tipoContacto
     */
    public long getTipoContacto() {
        return tipoContacto;
    }

    /**
     * @param tipoContacto the tipoContacto to set
     */
    public void setTipoContacto(long tipoContacto) {
        this.tipoContacto = tipoContacto;
    }

    @Override
    public void validate() {
        if (objeto.getDescripcion() != null) {
            if (objeto.getDescripcion().equals("")) {
             addFieldError("descripcion", "Digite una Descripcion");   
            }
        }
    }

    @Override
    public String desplegar() {
        this.setListaTiposContacto(Listas.obtenerListas().getListaTiposContacto());
        this.obtenerLista();
        this.editar = true;
        return SUCCESS;
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdTipoContacto(Listas.obtenerListas().getListaTiposContacto().get(this.tipoContacto));
    }

    @Override
    public void consultarTipos() {
        this.setTipoContacto(objeto.getIdTipoContacto().getIdTipoContacto());
    }

    @Override
    public void insertarValoresDefecto() {
        this.objeto.setEstado(true);
        this.objeto.setFechaRegistro(Date.valueOf(LocalDate.now()));
    }
}
