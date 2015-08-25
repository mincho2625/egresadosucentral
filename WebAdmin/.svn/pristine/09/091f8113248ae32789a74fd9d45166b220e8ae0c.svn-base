/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.RedSocial;

/**
 *
 * @author yury
 */
public class RedSocialAction extends CrudAction<RedSocial> {
    
    public RedSocialAction() {
        super(RedSocial.class.getName());
        this.getIdObjeto = "getIdRedSocial";
        this.nombreIdObjeto = "idRedSocial";
        this.entidad = RedSocial.class.getSimpleName();
        this.consultaTodos = "RedSocial.findByEstado";
        this.consultaIdObjeto = "RedSocial.findByIdRedSocial";
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
            addActionError("Ingrese al menos una red social.");
    }
}