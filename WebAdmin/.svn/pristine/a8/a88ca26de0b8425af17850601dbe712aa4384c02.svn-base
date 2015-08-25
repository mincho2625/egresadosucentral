/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.Idioma;

/**
 *
 * @author yury
 */
public class IdiomaAction extends CrudAction<Idioma> {
    
    public IdiomaAction() {
        super(Idioma.class.getName());
        this.getIdObjeto = "getIdIdioma";
        this.nombreIdObjeto = "idIdioma";
        this.entidad = Idioma.class.getSimpleName();
        this.consultaTodos = "Idioma.findByEstado";
        this.consultaIdObjeto = "Idioma.findByIdIdioma";
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
            addActionError("Ingrese al menos un idioma.");
    }
}