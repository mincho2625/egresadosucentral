/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.NivelCargo;

/**
 *
 * @author yury
 */
public class NivelCargoAction extends CrudAction<NivelCargo> {
    
    public NivelCargoAction() {
        super(NivelCargo.class.getName());
        this.getIdObjeto = "getIdNivelCargo";
        this.nombreIdObjeto = "idNivelCargo";
        this.entidad = NivelCargo.class.getSimpleName();
        this.consultaTodos = "NivelCargo.findByEstado";
        this.consultaIdObjeto = "NivelCargo.findByIdNivelCargo";
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
            addActionError("Ingrese al menos una nivel.");
    }
}