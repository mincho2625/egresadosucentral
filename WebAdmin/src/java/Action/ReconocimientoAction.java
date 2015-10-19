/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorTablas;
import Modelo.Reconocimiento;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author PC
 */
public class ReconocimientoAction extends CrudAction<Reconocimiento>{
    
    public ReconocimientoAction() {
        super(Reconocimiento.class.getName());
        this.getIdObjeto = "getIdReconocimiento";
        this.consultaTodos = "Reconocimiento.findByConsulta";
        this.entidad = Reconocimiento.class.getSimpleName();
        this.nombreIdObjeto = "idReconocimiento";
        this.consultaIdObjeto = "Reconocimiento.findByIdReconocimiento";
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
            for (Reconocimiento listaObjeto : listaObjetos) {
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