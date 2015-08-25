/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.PreguntaSeguridad;

/**
 *
 * @author yury
 */
public class PreguntaSeguridadAction extends CrudAction<PreguntaSeguridad> {
    
    public PreguntaSeguridadAction() {
        super(PreguntaSeguridad.class.getName());
        this.getIdObjeto = "getIdPreguntaSeguridad";
        this.nombreIdObjeto = "idPreguntaSeguridad";
        this.entidad = PreguntaSeguridad.class.getSimpleName();
        this.consultaTodos = "PreguntaSeguridad.findByEstado";
        this.consultaIdObjeto = "PreguntaSeguridad.findByIdPreguntaSeguridad";
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
        this.objeto.setEstado(true);
        //this.objeto.setFechaRegistro(Date.valueOf(LocalDate.now()));
    }

    @Override
    public void validar() {
        if (objeto.getPregunta().isEmpty())
            addFieldError("pregunta", "La pregunta es requerida");
    }

    @Override
    public void validarLista() {
        if (cantidadObjetos == 0)
            addActionError("Ingrese al menos una pregunta de seguridad.");
    }
}