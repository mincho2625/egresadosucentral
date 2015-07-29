/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.CargoEquivalente;

/**
 *
 * @author yury
 */
public class CargoEquivalenteAction extends CrudAction<CargoEquivalente>{

    public CargoEquivalenteAction() {
        super(CargoEquivalente.class.getName());
        this.getIdObjeto = "getIdCargoEquivalente";
        this.nombreIdObjeto = "idCargoEquivalente";
        this.entidad = CargoEquivalente.class.getSimpleName();
        this.consultaTodos = "CargoEquivalente.findByEstado";
        this.consultaIdObjeto = "CargoEquivalente.findByIdCargoEquivalente";
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
    }

    @Override
    public void validar() {
        if (objeto.getNombre().isEmpty())
            addFieldError("nombre", "El nombre es requerido");
    }

    @Override
    public void validarLista() {
        if (cantidadObjetos == 0)
            addActionError("Ingrese al menos un cargo.");
    }
}