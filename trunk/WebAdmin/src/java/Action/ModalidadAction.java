/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.Modalidad;

/**
 *
 * @author yury
 */
public class ModalidadAction extends CrudAction<Modalidad> {
    
    public ModalidadAction() {
        super(Modalidad.class.getName());
        this.getIdObjeto = "getIdModalidad";
        this.nombreIdObjeto = "idModalidad";
        this.entidad = Modalidad.class.getSimpleName();
        this.consultaTodos = "Modalidad.findByEstado";
        this.consultaIdObjeto = "Modalidad.findByIdModalidad";
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
            addActionError("Ingrese al menos una modalidad.");
    }
}
