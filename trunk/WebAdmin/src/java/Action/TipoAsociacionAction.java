/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.TipoAsociacion;

/**
 *
 * @author yury
 */
public class TipoAsociacionAction extends CrudAction<TipoAsociacion> {
    
    public TipoAsociacionAction() {
        super(TipoAsociacion.class.getName());
        this.getIdObjeto = "getIdTipoAsociacion";
        this.nombreIdObjeto = "idTipoAsociacion";
        this.entidad = TipoAsociacion.class.getSimpleName();
        this.consultaTodos = "TipoAsociacion.findByEstado";
        this.consultaIdObjeto = "TipoAsociacion.findByIdTipoAsociacion";
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
            addActionError("Ingrese al menos un tipo de asociación.");
    }
}