/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.TipoContrato;

/**
 *
 * @author yury
 */
public class TipoContratoAction extends CrudAction<TipoContrato> {
    
    public TipoContratoAction() {
        super(TipoContrato.class.getName());
        this.getIdObjeto = "getIdTipoContrato";
        this.nombreIdObjeto = "idTipoContrato";
        this.entidad = TipoContrato.class.getSimpleName();
        this.consultaTodos = "TipoContrato.findByEstado";
        this.consultaIdObjeto = "TipoContrato.findByIdTipoContrato";
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
            addActionError("Ingrese al menos una tipo de contrato.");
    }
}