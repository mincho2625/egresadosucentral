/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.Facultad;

/**
 *
 * @author yury
 */
public class FacultadAction extends CrudAction<Facultad> {
    
    public FacultadAction() {
        super(Facultad.class.getName());
        this.getIdObjeto = "getIdFacultad";
        this.nombreIdObjeto = "idFacultad";
        this.entidad = Facultad.class.getSimpleName();
        this.consultaTodos = "Facultad.findByEstado";
        this.consultaIdObjeto = "Facultad.findByIdFacultad";
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
            addActionError("Ingrese al menos una facultad.");
    }
}