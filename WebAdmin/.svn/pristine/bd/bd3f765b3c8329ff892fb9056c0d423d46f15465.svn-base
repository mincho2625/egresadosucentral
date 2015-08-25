/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.EstadoCivil;

/**
 *
 * @author yury
 */
public class EstadoCivilAction extends CrudAction<EstadoCivil> {
    
    public EstadoCivilAction() {
        super(EstadoCivil.class.getName());
        this.getIdObjeto = "getIdEstadoCivil";
        this.nombreIdObjeto = "idEstadoCivil";
        this.entidad = EstadoCivil.class.getSimpleName();
        this.consultaTodos = "EstadoCivil.findByEstado";
        this.consultaIdObjeto = "EstadoCivil.findByIdEstadoCivil";
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
        if (objeto.getEstadoCivil().isEmpty())
            addFieldError("estadoCivil", "El nombre es requerido");
    }

    @Override
    public void validarLista() {
        if (cantidadObjetos == 0)
            addActionError("Ingrese al menos un estado civil.");
    }
}