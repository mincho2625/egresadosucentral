/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controlador.ControladorTablas;
import Modelo.Aficiones;
import Modelo.Asociacion;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class AsociacionesAction extends CrudAction<Asociacion>{

    public AsociacionesAction() {
        super(Asociacion.class.getName());
        System.out.println("aaaaaaa");
        this.getIdObjeto = "getIdAsociacion";
        this.consultaTodos = "Asociacion.findByConsulta";
        this.entidad = Asociacion.class.getSimpleName();
        this.nombreIdObjeto = "idAsociacion";
        this.consultaIdObjeto = "Asociacion.findByIdAsociacion";
        System.out.println("aaaaaaa1");
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
            for (Asociacion listaObjeto : listaObjetos) {
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
