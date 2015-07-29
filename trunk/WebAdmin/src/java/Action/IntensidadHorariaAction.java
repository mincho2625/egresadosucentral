/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.IntensidadHoraria;

/**
 *
 * @author yury
 */
public class IntensidadHorariaAction extends CrudAction<IntensidadHoraria> {
    
    public IntensidadHorariaAction() {
        super(IntensidadHoraria.class.getName());
        this.getIdObjeto = "getIdIntensidadHoraria";
        this.nombreIdObjeto = "idIntensidadHoraria";
        this.entidad = IntensidadHoraria.class.getSimpleName();
        this.consultaTodos = "IntensidadHoraria.findByEstado";
        this.consultaIdObjeto = "IntensidadHoraria.findByIdIntensidadHoraria";
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
            addActionError("Ingrese al menos una intensidad horaria.");
    }
}