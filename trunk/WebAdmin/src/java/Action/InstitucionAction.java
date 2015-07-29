/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.Institucion;

/**
 *
 * @author yury
 */
public class InstitucionAction extends CrudAction<Institucion> {
    
    public InstitucionAction() {
        super(Institucion.class.getName());
        this.getIdObjeto = "getIdInstitucion";
        this.nombreIdObjeto = "idInstitucion";
        this.entidad = Institucion.class.getSimpleName();
        this.consultaTodos = "Institucion.findByEstado";
        this.consultaIdObjeto = "Institucion.findByIdInstitucion";
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
            addActionError("Ingrese al menos una institución.");
    }
}