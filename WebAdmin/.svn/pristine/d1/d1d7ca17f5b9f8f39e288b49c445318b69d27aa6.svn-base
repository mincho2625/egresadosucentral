/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.AreaEmpresa;

/**
 *
 * @author yury
 */
public class AreaEmpresaAction extends CrudAction<AreaEmpresa> {
    
    public AreaEmpresaAction() {
        super(AreaEmpresa.class.getName());
        this.getIdObjeto = "getIdAreaEmpresa";
        this.nombreIdObjeto = "idAreaEmpresa";
        this.entidad = AreaEmpresa.class.getSimpleName();
        this.consultaTodos = "AreaEmpresa.findByEstado";
        this.consultaIdObjeto = "AreaEmpresa.findByIdAreaEmpresa";
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
            addActionError("Ingrese al menos una área.");
    }
}