/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorListas;
import Modelo.Contacto;
import Modelo.TipoContacto;
import java.util.ArrayList;

/**
 *
 * @author YURY
 */
public class UbicacionAction extends CrudAction<Contacto> {
    private ArrayList<TipoContacto> listaTiposContacto;
    private ControladorListas controladorListas = new ControladorListas();
    
    public UbicacionAction()
    {
        super(Modelo.Contacto.class.getName());
        this.metodoBorrar = "borrarDatosUbicacion";
        //this.clase = ;
        this.metodoConsultar = "obtenerDatosUbicacion";
        this.metodoActualizar = "actualizarDatosUbicacion";
    }
    
    /**
     * @return the listaTiposContacto
     */
    public ArrayList<TipoContacto> getListaTiposContacto() {
        return listaTiposContacto;
    }

    /**
     * @param listaTiposContacto the listaTiposContacto to set
     */
    public void setListaTiposContacto(ArrayList<TipoContacto> listaTiposContacto) {
        this.listaTiposContacto = listaTiposContacto;
    }
    
    @Override
    public String desplegar()
    {
        this.obtenerLista();
        this.setListaTiposContacto(controladorListas.obtenerTiposContacto());
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
}
