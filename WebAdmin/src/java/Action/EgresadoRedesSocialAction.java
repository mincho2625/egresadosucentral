/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorTablas;
import Modelo.EgresadoRedSocial;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author YURY
 */
public class EgresadoRedesSocialAction extends CrudAction<EgresadoRedSocial>{


    public EgresadoRedesSocialAction() {
        super(EgresadoRedSocial.class.getName());
        this.getIdObjeto = "getIdEgresadoRedSocial";
        this.consultaTodos = "EgresadoRedSocial.findByConsulta";
        this.entidad = EgresadoRedSocial.class.getSimpleName();
        this.nombreIdObjeto = "idEgresadoRedSocial";
        this.consultaIdObjeto = "EgresadoRedSocial.findByIdEgresadoRedSocial";
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
            for (EgresadoRedSocial listaObjeto : listaObjetos) {
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