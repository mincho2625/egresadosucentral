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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author YURY
 */
public class BusquedaAvanzadaAction extends ActionSupport {
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
    private List<String> criterioSeleccionado;
    
    public BusquedaAvanzadaAction()
    {
        listas = new ControladorListas();
        desplegar();
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
    
     /**
     * @return the criterioSeleccionado
     */
    public List<String> getCriterioSeleccionado() {
        return criterioSeleccionado;
    }

    /**
     * @param criterioSeleccionado the criterioSeleccionado to set
     */
    public void setCriterioSeleccionado(List<String> criterioSeleccionado) {
        this.criterioSeleccionado = criterioSeleccionado;
    }
    
    private void desplegar()
    {
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
            if (this.seleccionProgramas.size() > 0) parametros.put("idPrograma", this.seleccionProgramas);
            if (this.seleccionNivelEstudios.size() > 0) parametros.put("idNivelEstudios", this.seleccionNivelEstudios);
            if (this.seleccionFacultades.size() > 0) parametros.put("idFacultad", this.seleccionFacultades);
            if (this.seleccionAnios.size() > 0) parametros.put("anioFinalizacion", this.seleccionAnios);
            if (this.seleccionGeneros.size() > 0) parametros.put("idGenero", this.seleccionGeneros);
            if (this.seleccionEstadosCiviles.size() > 0) parametros.put("idEstadoCivil", this.seleccionEstadosCiviles);

            // buscar
            ControladorEgresado controladorEgresado = new ControladorEgresado();
            listaEgresados = controladorEgresado.consultar(parametros);
            return SUCCESS;
        }
        
        addActionError("Error al buscar resultados.");
        return ERROR;
    }
}