/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.TipoTenenciaVivienda;

/**
 *
 * @author yury
 */
public class TipoTenenciaViviendaAction extends CrudAction<TipoTenenciaVivienda> {
    
    public TipoTenenciaViviendaAction() {
        super(TipoTenenciaVivienda.class.getName());
        this.getIdObjeto = "getIdTipoTenenciaVivienda";
        this.nombreIdObjeto = "idTipoTenenciaVivienda";
        this.entidad = TipoTenenciaVivienda.class.getSimpleName();
        this.consultaTodos = "TipoTenenciaVivienda.findByEstado";
        this.consultaIdObjeto = "TipoTenenciaVivienda.findByIdTipoTenenciaVivienda";
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
            addActionError("Ingrese al menos una tipo de tenencia vivienda.");
    }
}