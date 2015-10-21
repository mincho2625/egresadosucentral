/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;
import Controlador.ControladorTablas;
import Modelo.EgresadoRespuesta;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 *
 * @author pc
 */
public class EgresadoRespuestasAction extends CrudAction<EgresadoRespuesta>{

    public EgresadoRespuestasAction() {
        super(EgresadoRespuesta.class.getName());
        this.getIdObjeto = "getIdRespuestaEncuesta";
        this.nombreIdObjeto = "idRespuestaEncuesta";
        this.entidad = EgresadoRespuesta.class.getSimpleName();
        this.consultaTodos = "EgresadoRespuesta.findByEstado";
        this.consultaIdObjeto = "EgresadoRespuesta.findByIdEgresadoRespuesta";
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
            for (EgresadoRespuesta listaObjeto : listaObjetos) {
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
