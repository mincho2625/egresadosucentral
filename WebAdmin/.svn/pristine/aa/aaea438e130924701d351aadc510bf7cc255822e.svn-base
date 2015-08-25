/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.Facultad;
import Modelo.ItemLista;
import Modelo.NivelEstudios;
import Modelo.Programa;
import java.util.List;

/**
 *
 * @author yury
 */
public class ProgramaAction extends CrudAction<Programa> {
    private List<ItemLista> listaNivelesEstudios;
    private List<ItemLista> listaFacultades;
    private long nivelEstudios;
    private long facultad;
    
    public ProgramaAction() {
        super(Programa.class.getName());
        this.getIdObjeto = "getIdPrograma";
        this.nombreIdObjeto = "idPrograma";
        this.entidad = Programa.class.getSimpleName();
        this.consultaTodos = "Programa.findByEstado";
        this.consultaIdObjeto = "Programa.findByIdPrograma";
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
     * @return the listaFacultades
     */
    public List<ItemLista> getListaFacultades() {
        return listaFacultades;
    }

    /**
     * @param listaFacultades the listaFacultades to set
     */
    public void setListaFacultades(List<ItemLista> listaFacultades) {
        this.listaFacultades = listaFacultades;
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

    /**
     * @return the facultad
     */
    public long getFacultad() {
        return facultad;
    }

    /**
     * @param facultad the facultad to set
     */
    public void setFacultad(long facultad) {
        this.facultad = facultad;
    }

    @Override
    public void desplegar() {
        this.setListaNivelesEstudios(listas.consultarNivelesEstudios());
        this.setListaFacultades(listas.consultarFacultades());
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdNivelEstudios(new NivelEstudios(this.nivelEstudios));
        this.objeto.setIdFacultad(new Facultad(this.facultad));
    }

    @Override
    public void consultarTipos() {
        this.nivelEstudios = this.objeto.getIdNivelEstudios().getIdNivelEstudios();
        this.facultad = this.objeto.getIdFacultad().getIdFacultad();
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
        if (this.nivelEstudios < 0)
            addFieldError("nivelEstudios", "El nivel de estudios es requerido");
        if (this.facultad < 0)
            addFieldError("facultad", "La facultad es requerida");
    }

    @Override
    public void validarLista() {
        if (cantidadObjetos == 0)
            addActionError("Ingrese al menos un programa.");
    }
}