/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.Estrato;

/**
 *
 * @author yury
 */
public class EstratoAction extends CrudAction<Estrato> {
    
    public EstratoAction() {
        super(Estrato.class.getName());
        this.getIdObjeto = "getIdEstrato";
        this.nombreIdObjeto = "idEstrato";
        this.entidad = Estrato.class.getSimpleName();
        this.consultaTodos = "Estrato.findByEstado";
        this.consultaIdObjeto = "Estrato.findByIdEstrato";
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
            addFieldError("nombre", "El estrato es requerido");
    }

    @Override
    public void validarLista() {
        if (cantidadObjetos == 0)
            addActionError("Ingrese al menos una área.");
    }
}