/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.DominioLenguaExt;

/**
 *
 * @author yury
 */
public class DominioLenguaExtAction extends CrudAction<DominioLenguaExt> {
    
    public DominioLenguaExtAction() {
        super(DominioLenguaExt.class.getName());
        
        this.getIdObjeto = "getIdDominioLenguaExt";
        this.consultaTodos = "DominioLenguaExt.findByEstado";
        this.entidad = DominioLenguaExt.class.getSimpleName();
        this.nombreIdObjeto = "idDominioLenguaExt";
        this.consultaIdObjeto = "DominioLenguaExt.findByIdDominioLenguaExt";
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
        if (objeto.getDominioLenguaExt().isEmpty())
            addFieldError("dominioLenguaExt", "El nombre es requerido");
    }

    @Override
    public void validarLista() {
        if (cantidadObjetos == 0)
            addActionError("Ingrese al menos un dominio.");
    }
}