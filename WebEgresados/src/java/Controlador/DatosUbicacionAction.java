
package Controlador;

import Modelo.Contacto;
import Modelo.TipoContacto;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

public class DatosUbicacionAction extends ActionSupport implements ModelDriven<Contacto>{

    private Contacto contacto = new Contacto();
    private ArrayList<TipoContacto> listaTiposContacto;

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public Contacto getContacto() {
        return contacto;
    }
    
    public ArrayList<TipoContacto> getListaTiposContacto() {
        return listaTiposContacto;
    }

    public void setListaTiposContacto(ArrayList<TipoContacto> listaTiposContacto) {
        this.listaTiposContacto = listaTiposContacto;
    }
    
    @Override
    public Contacto getModel() {
        return getContacto();
    }
    
    public String desplegar()
    {
        ControladorListas cl = new ControladorListas();
        setListaTiposContacto(cl.obtenerTiposContacto());
        
        return "desplegar";
    }
    
//    @Override
//    public String execute()
//    {
//        ControladorEgresado ce = new ControladorEgresado();
//        ce.actualizarInformacionBasica(getEgresado());
//        return SUCCESS;
//    }

    
}