/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controlador.ControladorEgresado;
import Controlador.ControladorListas;
import Modelo.Egresado;
import Modelo.ItemLista;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author YURY
 */
public class BusquedaAvanzadaAction extends ActionSupport {
    private List<Integer> listaAnios;
    private List<ItemLista> listaGeneros;
    private List<ItemLista> listaEstadosCiviles;
    private List<ItemLista> listaPlantillas;
    private List<Long> seleccionNivelEstudios;
    private List<Long> seleccionFacultades;
    private List<Long> seleccionProgramas;
    private List<Long> seleccionEstadosCiviles;
    private List<Integer> seleccionAnios;
    private List<Long> seleccionGeneros;
    private final ControladorListas listas;
    private Map<String, Object> parametros;
    private List<Egresado> listaEgresados;
    
    public BusquedaAvanzadaAction()
    {
        listas = new ControladorListas();
        desplegar();
        //seleccionFacultades = new ArrayList<>();
        //seleccionNivelEstudios = new ArrayList<>();
        //seleccionProgramas = new ArrayList<>();
        //seleccionEstadosCiviles = new ArrayList<>();
    }

    /**
     * @return the listaAnios
     */
    public List<Integer> getListaAnios() {
        return listaAnios;
    }

    /**
     * @param listaAnios the listaAnios to set
     */
    public void setListaAnios(List<Integer> listaAnios) {
        this.listaAnios = listaAnios;
    }

    /**
     * @return the listaGeneros
     */
    public List<ItemLista> getListaGeneros() {
        return listaGeneros;
    }

    /**
     * @param listaGeneros the listaGeneros to set
     */
    public void setListaGeneros(List<ItemLista> listaGeneros) {
        this.listaGeneros = listaGeneros;
    }

    /**
     * @return the listaEstadosCiviles
     */
    public List<ItemLista> getListaEstadosCiviles() {
        return listaEstadosCiviles;
    }

    /**
     * @param listaEstadosCiviles the listaEstadosCiviles to set
     */
    public void setListaEstadosCiviles(List<ItemLista> listaEstadosCiviles) {
        this.listaEstadosCiviles = listaEstadosCiviles;
    }

    /**
     * @return the listaPlantillas
     */
    public List<ItemLista> getListaPlantillas() {
        return listaPlantillas;
    }

    /**
     * @param listaPlantillas the listaPlantillas to set
     */
    public void setListaPlantillas(List<ItemLista> listaPlantillas) {
        this.listaPlantillas = listaPlantillas;
    }
    
    /**
     * @return the seleccionNivelEstudios
     */
    public List<Long> getSeleccionNivelEstudios() {
        return seleccionNivelEstudios;
    }

    /**
     * @param seleccionNivelEstudios the seleccionNivelEstudios to set
     */
    public void setSeleccionNivelEstudios(List<Long> seleccionNivelEstudios) {
        this.seleccionNivelEstudios = seleccionNivelEstudios;
    }

    /**
     * @return the seleccionFacultades
     */
    public List<Long> getSeleccionFacultades() {
        return seleccionFacultades;
    }

    /**
     * @param seleccionFacultades the seleccionFacultades to set
     */
    public void setSeleccionFacultades(List<Long> seleccionFacultades) {
        this.seleccionFacultades = seleccionFacultades;
    }

    /**
     * @return the seleccionProgramas
     */
    public List<Long> getSeleccionProgramas() {
        return seleccionProgramas;
    }

    /**
     * @param seleccionProgramas the seleccionProgramas to set
     */
    public void setSeleccionProgramas(List<Long> seleccionProgramas) {
        this.seleccionProgramas = seleccionProgramas;
    }

    /**
     * @return the seleccionestadosCiviles
     */
    public List<Long> getSeleccionEstadosCiviles() {
        return seleccionEstadosCiviles;
    }

    /**
     * @param seleccionEstadosCiviles the seleccionEstadosCiviles to set
     */
    public void setSeleccionEstadosCiviles(List<Long> seleccionEstadosCiviles) {
        this.seleccionEstadosCiviles = seleccionEstadosCiviles;
    }

    /**
     * @return the seleccionAnios
     */
    public List<Integer> getSeleccionAnios() {
        return seleccionAnios;
    }

    /**
     * @param seleccionAnios the seleccionAnios to set
     */
    public void setSeleccionAnios(List<Integer> seleccionAnios) {
        this.seleccionAnios = seleccionAnios;
    }

    /**
     * @return the seleccionGeneros
     */
    public List<Long> getSeleccionGeneros() {
        return seleccionGeneros;
    }

    /**
     * @param seleccionGeneros the seleccionGeneros to set
     */
    public void setSeleccionGeneros(List<Long> seleccionGeneros) {
        this.seleccionGeneros = seleccionGeneros;
    }
    
    /**
     * @return the listaEgresados
     */
    public List<Egresado> getListaEgresados() {
        return listaEgresados;
    }

    /**
     * @param listaEgresados the listaEgresados to set
     */
    public void setListaEgresados(List<Egresado> listaEgresados) {
        this.listaEgresados = listaEgresados;
    }
    
    private void desplegar()
    {
        listaAnios = listas.consultarAnios();
        listaEstadosCiviles = listas.consultarEstadosCiviles();
        listaGeneros = listas.consultarGeneros();
        listaPlantillas = listas.consultarPlantillasCorreo();
    }
    
    private void validar()
    {
        
    }
    
    public String mostrar() {
        return SUCCESS;
    }
    
    public String buscar() {
        validar();
        
        if (!hasErrors()) {
            parametros = new HashMap<>();
            parametros.put("idPrograma", this.seleccionProgramas.size() > 0 ? this.seleccionProgramas : null);
            parametros.put("idNivelEstudios", this.seleccionNivelEstudios.size() > 0 ? this.seleccionNivelEstudios : null);
            parametros.put("idFacultad", this.seleccionFacultades.size() > 0 ? this.seleccionFacultades : null);
            parametros.put("anioFinalizacion", this.seleccionAnios.size() > 0 ? this.seleccionAnios : null);
            parametros.put("idGenero", this.seleccionGeneros.size() > 0 ? this.seleccionGeneros : null);
            parametros.put("idEstadoCivil", this.seleccionEstadosCiviles.size() > 0 ? this.seleccionEstadosCiviles : null);

            // buscar
            ControladorEgresado controladorEgresado = new ControladorEgresado();
            listaEgresados = controladorEgresado.consultar(parametros);
            return SUCCESS;
        }
        
        addActionError("Error al buscar resultados.");
        return ERROR;
    }
}