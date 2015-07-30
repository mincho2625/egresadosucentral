/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controlador.ControladorCrud;
import Modelo.Egresado;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author YURY
 */
public class SalidaAction extends ActionSupport{
    private Map sesion;
    private ControladorCrud controladorCrud;
    
    public SalidaAction()
    {
        sesion = ActionContext.getContext().getSession();
    }

    @Override
    public String execute() throws Exception {
        validate();
        return SUCCESS;
    }

    public String validar() {
        long idEgresado = (long) sesion.get("idEgresado");
        controladorCrud = new ControladorCrud();
        Egresado egresado = (Egresado) controladorCrud.consultar("Egresado.findByIdEgresado", 
                Modelo.Egresado.class.getName(), "idEgresado", idEgresado, Modelo.Usuario.class.getName());
        
        if (!egresado.isInformacionCompleta())
            addActionMessage("Su información no está completa. ¿Está seguro que desea salir?");
        
        return "confirmar";
    }
    
    public String cancelar()
    {
        return "cancelar";
    }
}