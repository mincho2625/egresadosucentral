/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.ItemLista;
import Modelo.Sector;
import Modelo.Subsector;
import java.util.List;

/**
 *
 * @author yury
 */
public class SubsectorAction extends CrudAction<Subsector> {
    private List<ItemLista> listaSectores;
    private long sector;
    
    public SubsectorAction() {
        super(Subsector.class.getName());
        this.getIdObjeto = "getIdSubsector";
        this.nombreIdObjeto = "idSubsector";
        this.entidad = Subsector.class.getSimpleName();
        this.consultaTodos = "Subsector.findByEstado";
        this.consultaIdObjeto = "Subsector.findByIdSubsector";
    }
    
    /**
     * @return the listaSectores
     */
    public List<ItemLista> getListaSectores() {
        return listaSectores;
    }

    /**
     * @param listaSectores the listaSectores to set
     */
    public void setListaSectores(List<ItemLista> listaSectores) {
        this.listaSectores = listaSectores;
    }

    /**
     * @return the sector
     */
    public long getSector() {
        return sector;
    }

    /**
     * @param sector the sector to set
     */
    public void setSector(long sector) {
        this.sector = sector;
    }

    @Override
    public void desplegar() {
        this.setListaSectores(listas.consultarSectores());
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdSector(new Sector(this.getSector()));
    }

    @Override
    public void consultarTipos() {
        this.setSector(this.objeto.getIdSector().getIdSector());
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
        if (this.sector < 0)
            addFieldError("sector", "El sector es requerido");
    }

    @Override
    public void validarLista() {
        if (cantidadObjetos == 0)
            addActionError("Ingrese al menos un sector.");
    }
}