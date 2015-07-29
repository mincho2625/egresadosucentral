/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.NivelEstudios;

/**
 *
 * @author yury
 */
public class NivelEstudiosAction extends CrudAction<NivelEstudios> {
    
    public NivelEstudiosAction() {
        super(NivelEstudios.class.getName());
        this.getIdObjeto = "getIdNivelEstudios";
        this.nombreIdObjeto = "idNivelEstudios";
        this.entidad = NivelEstudios.class.getSimpleName();
        this.consultaTodos = "NivelEstudios.findByEstado";
        this.consultaIdObjeto = "NivelEstudios.findByIdNivelEstudios";
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
            addActionError("Ingrese al menos un nivel de estudios.");
    }
}