/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controlador.ControladorCrud;
import Controlador.ControladorUsuario;
import Modelo.Egresado;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author YURY
 */
public class SalidaAction extends ActionSupport {

    private Map sesion;
    private ControladorCrud controladorCrud;
    private ControladorUsuario controladorUsuario;
    private String nombre;
    private boolean primeraVez;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public SalidaAction() {
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
        controladorUsuario = new ControladorUsuario();
        Egresado egresado = (Egresado) controladorCrud.consultar("Egresado.findByIdEgresado",
                Modelo.Egresado.class.getName(), "idEgresado", idEgresado, Modelo.Usuario.class.getName());
        if (egresado.getSegundoApellido() != null) {
            this.setNombre(String.format("%s %s %s", egresado.getNombres(), egresado.getPrimerApellido(), egresado.getSegundoApellido()));
        } else {
            this.setNombre(String.format("%s %s", egresado.getNombres(), egresado.getPrimerApellido()));
        }
        if (!controladorUsuario.informacionCompleta(egresado.getNumeroDocumento())) {
            addActionMessage("Su información no está completa. ¿Está seguro que desea salir?");
        } else {
            addActionMessage("Esta saliendo del portal de egresados. ¿Está seguro que desea salir?");
        }

        return "confirmar";
    }

    public String cancelar() {
        long idEgresado = (long) sesion.get("idEgresado");
        controladorCrud = new ControladorCrud();
        Egresado egresado = (Egresado) controladorCrud.consultar("Egresado.findByIdEgresado",
                Modelo.Egresado.class.getName(), "idEgresado", idEgresado, Modelo.Usuario.class.getName());
        if (egresado.getSegundoApellido() != null) {
            this.setNombre(String.format("%s %s %s", egresado.getNombres(), egresado.getPrimerApellido(), egresado.getSegundoApellido()));
        } else {
            this.setNombre(String.format("%s %s", egresado.getNombres(), egresado.getPrimerApellido()));
        }
        return "cancelar";
    }

    public boolean isPrimeraVez() {
        return primeraVez;
    }

    public void setPrimeraVez(boolean primeraVez) {
        this.primeraVez = primeraVez;
    }
}
