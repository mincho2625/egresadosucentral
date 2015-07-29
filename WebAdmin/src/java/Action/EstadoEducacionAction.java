/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.EstadoEducacion;

/**
 *
 * @author yury
 */
public class EstadoEducacionAction extends CrudAction<EstadoEducacion> {
    
    public EstadoEducacionAction() {
        super(EstadoEducacion.class.getName());
        this.getIdObjeto = "getIdEstadoEducacion";
        this.nombreIdObjeto = "idEstadoEducacion";
        this.entidad = EstadoEducacion.class.getSimpleName();
        this.consultaTodos = "EstadoEducacion.findByEstado";
        this.consultaIdObjeto = "EstadoEducacion.findByIdEstadoEducacion";
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
        if (objeto.getNombre().isEmpty())
            addFieldError("nombre", "El nombre es requerido");
    }

    @Override
    public void validarLista() {
        if (cantidadObjetos == 0)
            addActionError("Ingrese al menos una estado.");
    }
}