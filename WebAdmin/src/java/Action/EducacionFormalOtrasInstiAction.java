/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controlador.ControladorTablas;
import Modelo.EdFormalOtrasInstituciones;
import Modelo.Educacion;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author pc
 */
public class EducacionFormalOtrasInstiAction extends CrudAction<EdFormalOtrasInstituciones>  {

    public EducacionFormalOtrasInstiAction() {
        super(EdFormalOtrasInstituciones.class.getName());
        System.out.println("jajajajajaj");
        this.getIdObjeto = "getIdEducacion";
        System.out.println("jajajajajaj1");
        this.consultaTodos = "EdFormalOtrasInstituciones.findByConsulta";
        System.out.println("jajajajajaj2");
        this.entidad = EdFormalOtrasInstituciones.class.getSimpleName();
        System.out.println("jajajajajaj3");
        this.nombreIdObjeto = "idEducacion";
        System.out.println("jajajajajaj4");
        this.consultaIdObjeto = "EdFormalOtrasInstituciones.findByIdEducacion";
        System.out.println("jajajajajaj5");
        this.baseEntidad = Educacion.class.getSimpleName();
        System.out.println("jajajajajaj6");
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
            for (EdFormalOtrasInstituciones listaObjeto : listaObjetos) {
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
