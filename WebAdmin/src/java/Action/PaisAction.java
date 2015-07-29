/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.Pais;

/**
 *
 * @author yury
 */
public class PaisAction extends CrudAction<Pais> {
    
    public PaisAction() {
        super(Pais.class.getName());
        this.getIdObjeto = "getIdPais";
        this.nombreIdObjeto = "idPais";
        this.entidad = Pais.class.getSimpleName();
        this.consultaTodos = "Pais.findByEstado";
        this.consultaIdObjeto = "Pais.findByIdPais";
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
            addActionError("Ingrese al menos un país.");
    }
}