/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controlador.ControladorTablas;
import Modelo.Aficiones;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.Egresado;


/**
 *
 * @author pc
 */
public class AficionesAction extends CrudAction<Aficiones> {

    public AficionesAction() {
        super(Aficiones.class.getName());
        this.getIdObjeto = "getIdAficion";
        this.nombreIdObjeto = "idAficion";
        this.entidad = Aficiones.class.getSimpleName();
        this.consultaTodos = "Aficiones.findByConsulta";
        this.consultaIdObjeto = "Aficiones.findByIdAficion";
        this.baseEntidad = Egresado.class.getSimpleName();
    }

    @Override
    public void desplegar() {

    }

    @Override
    public void insertarTipos() {

    }

    @Override
    public void consultarTipos() {

    }

    @Override
    public void insertarValoresDefecto() {

    }

    @Override
    public void validar() {

    }

    @Override
    public void validarLista() {

    }

    public String generarLista() {
        try {
            obtenerLista();
            for (Aficiones listaObjeto : listaObjetos) {
                ControladorTablas controladorTablas=new ControladorTablas();
                String documento=controladorTablas.consultarEgresado(listaObjeto.getIdEgresado());
                listaObjeto.setNumeroDocumento(documento);
            }
            return SUCCESS;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(CrudAction.class.getName()).log(Level.SEVERE, null, ex);
            return ERROR;
        }
    }
}
