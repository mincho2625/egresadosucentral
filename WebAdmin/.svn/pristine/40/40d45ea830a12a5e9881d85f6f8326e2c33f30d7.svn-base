/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.Jornada;

/**
 *
 * @author yury
 */
public class JornadaAction extends CrudAction<Jornada> {
    
    public JornadaAction() {
        super(Jornada.class.getName());
        this.getIdObjeto = "getIdJornada";
        this.nombreIdObjeto = "idJornada";
        this.entidad = Jornada.class.getSimpleName();
        this.consultaTodos = "Jornada.findByEstado";
        this.consultaIdObjeto = "Jornada.findByIdJornada";
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
            addActionError("Ingrese al menos una jornada.");
    }
}