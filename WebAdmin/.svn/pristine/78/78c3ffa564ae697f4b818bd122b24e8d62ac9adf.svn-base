/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.ClaseReconocimiento;

/**
 *
 * @author yury
 */
public class ClaseReconocimientoAction extends CrudAction<ClaseReconocimiento> {
    
    public ClaseReconocimientoAction() {
        super(ClaseReconocimiento.class.getName());
        this.getIdObjeto = "getIdClaseReconocimiento";
        this.nombreIdObjeto = "idClaseReconocimiento";
        this.entidad = ClaseReconocimiento.class.getSimpleName();
        this.consultaTodos = "ClaseReconocimiento.findByEstado";
        this.consultaIdObjeto = "ClaseReconocimiento.findByIdClaseReconocimiento";
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
            addActionError("Ingrese al menos una clase de reconocimiento.");
    }
}
