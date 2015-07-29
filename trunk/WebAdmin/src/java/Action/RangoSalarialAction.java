/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.RangoSalarial;

/**
 *
 * @author yury
 */
public class RangoSalarialAction extends CrudAction<RangoSalarial> {
    
    public RangoSalarialAction() {
        super(RangoSalarial.class.getName());
        this.getIdObjeto = "getIdRangoSalarial";
        this.nombreIdObjeto = "idRangoSalarial";
        this.entidad = RangoSalarial.class.getSimpleName();
        this.consultaTodos = "RangoSalarial.findByEstado";
        this.consultaIdObjeto = "RangoSalarial.findByIdRangoSalarial";
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
        if (objeto.getDescripcion().isEmpty())
            addFieldError("descripcion", "La descripción es requerida");
    }

    @Override
    public void validarLista() {
        if (cantidadObjetos == 0)
            addActionError("Ingrese al menos un rango salarial.");
    }
}