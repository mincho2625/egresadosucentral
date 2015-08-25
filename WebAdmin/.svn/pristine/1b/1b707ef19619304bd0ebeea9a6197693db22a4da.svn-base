/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.Sector;

/**
 *
 * @author yury
 */
public class SectorAction extends CrudAction<Sector> {
    
    public SectorAction() {
        super(Sector.class.getName());
        this.getIdObjeto = "getIdSector";
        this.nombreIdObjeto = "idSector";
        this.entidad = Sector.class.getSimpleName();
        this.consultaTodos = "Sector.findByEstado";
        this.consultaIdObjeto = "Sector.findByIdSector";
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
            addActionError("Ingrese al menos un sector.");
    }
}