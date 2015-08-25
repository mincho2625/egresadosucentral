/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.GrupoSanguineo;

/**
 *
 * @author yury
 */
public class GrupoSanguineoAction extends CrudAction<GrupoSanguineo> {
    
    public GrupoSanguineoAction() {
        super(GrupoSanguineo.class.getName());
        this.getIdObjeto = "getIdGrupoSanguineo";
        this.nombreIdObjeto = "idGrupoSanguineo";
        this.entidad = GrupoSanguineo.class.getSimpleName();
        this.consultaTodos = "GrupoSanguineo.findByEstado";
        this.consultaIdObjeto = "GrupoSanguineo.findByIdGrupoSanguineo";
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
        if (objeto.getGrupoSanguineo().isEmpty())
            addFieldError("grupoSanguineo", "El nombre es requerido");
    }

    @Override
    public void validarLista() {
        if (cantidadObjetos == 0)
            addActionError("Ingrese al menos una grupo sanguíneo.");
    }
}