/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.TipoReconocimiento;

/**
 *
 * @author yury
 */
public class TipoReconocimientoAction extends CrudAction<TipoReconocimiento> {
    
    public TipoReconocimientoAction() {
        super(TipoReconocimiento.class.getName());
        this.getIdObjeto = "getIdTipoReconocimiento";
        this.nombreIdObjeto = "idTipoReconocimiento";
        this.entidad = TipoReconocimiento.class.getSimpleName();
        this.consultaTodos = "TipoReconocimiento.findByEstado";
        this.consultaIdObjeto = "TipoReconocimiento.findByIdTipoReconocimiento";
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
            addActionError("Ingrese al menos un tipo de reconocimiento.");
    }
}