/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorCorreo;
import Modelo.ConfiguracionCorreo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *
 * @author YURY
 */
public class ConfiguracionCorreoAction extends ActionSupport implements ModelDriven<ConfiguracionCorreo> {
    private final ControladorCorreo controladorCorreo;
    private ConfiguracionCorreo configuracionCorreo;
    
    public ConfiguracionCorreoAction()
    {
        controladorCorreo = new ControladorCorreo();
        configuracionCorreo = controladorCorreo.consultarConfiguracion();
    }
    
    /**
     * @return the configuracionCorreo
     */
    public ConfiguracionCorreo getConfiguracionCorreo() {
        return configuracionCorreo;
    }

    /**
     * @param configuracionCorreo the configuracionCorreo to set
     */
    public void setConfiguracionCorreo(ConfiguracionCorreo configuracionCorreo) {
        this.configuracionCorreo = configuracionCorreo;
    }
    
    @Override
    public ConfiguracionCorreo getModel() {
        return configuracionCorreo;
    }

    @Override
    public String execute() throws Exception {
        validar();
        if (!hasActionErrors()) {
            if (controladorCorreo.guardarConfiguracion(configuracionCorreo)) {
                addActionMessage("Configuración guardada exitosamente");
                return SUCCESS;
            }
        }
        
        addActionError("Error al guardar la configuración. Por favor revise la información enviada.");
        return ERROR;
    }
    
    public String editar() {
        return SUCCESS;
    }
    
    private void validar()
    {
        if (configuracionCorreo.getContrasenia().isEmpty())
            addFieldError("contrasenia", "La contraseña es requerida");
        if (configuracionCorreo.getPuerto().isEmpty())
            addFieldError("puerto", "El puerto es requerido");
        if (configuracionCorreo.getServidor().isEmpty())
            addFieldError("servidor", "El servidor es requerido");
        if (configuracionCorreo.getUsuario().isEmpty())
            addFieldError("usuario", "El usuario es requerido");
    }
}
