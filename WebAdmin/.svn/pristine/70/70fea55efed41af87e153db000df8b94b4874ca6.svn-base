/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.AreaEstudios;
import Modelo.ItemLista;
import Modelo.NivelEstudios;
import java.util.List;

/**
 *
 * @author yury
 */
public class AreaEstudiosAction extends CrudAction<AreaEstudios> {
    private List<ItemLista> listaNivelesEstudios;
    private long nivelEstudios;
    
    public AreaEstudiosAction() {
        super(AreaEstudios.class.getName());
        this.getIdObjeto = "getIdAreaEstudios";
        this.nombreIdObjeto = "idAreaEstudios";
        this.entidad = AreaEstudios.class.getSimpleName();
        this.consultaTodos = "AreaEstudios.findByEstado";
        this.consultaIdObjeto = "AreaEstudios.findByIdAreaEstudios";
    }
    
    /**
     * @return the listaNivelesEstudios
     */
    public List<ItemLista> getListaNivelesEstudios() {
        return listaNivelesEstudios;
    }

    /**
     * @param listaNivelesEstudios the listaNivelesEstudios to set
     */
    public void setListaNivelesEstudios(List<ItemLista> listaNivelesEstudios) {
        this.listaNivelesEstudios = listaNivelesEstudios;
    }

    /**
     * @return the nivelEstudios
     */
    public long getNivelEstudios() {
        return nivelEstudios;
    }

    /**
     * @param nivelEstudios the nivelEstudios to set
     */
    public void setNivelEstudios(long nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
    }

    @Override
    public void desplegar() {
        this.setListaNivelesEstudios(listas.consultarNivelesEstudios());
    }

    @Override
    public void insertarTipos() {
        if (this.nivelEstudios > 0)
            this.objeto.setIdNivelEstudios(new NivelEstudios(this.nivelEstudios));
        else
            this.objeto.setIdNivelEstudios(null);
    }

    @Override
    public void consultarTipos() {
        if (this.objeto.getIdNivelEstudios() != null)
            this.nivelEstudios = this.objeto.getIdNivelEstudios().getIdNivelEstudios();
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
            addActionError("Ingrese al menos una área.");
    }
}