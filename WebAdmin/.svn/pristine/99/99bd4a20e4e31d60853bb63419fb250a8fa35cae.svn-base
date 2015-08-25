/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorListas;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yury
 */
public class SelectProgramaAction extends ActionSupport {
    private Map<Long, String> listaNivelesEstudios;
    private Map<Long, String> listaFacultades;
    private Map<Long, String> listaProgramas;
    private Map<Long, String> listaEstadosCiviles;
    private Map<Long, String> listaGeneros;
    private List<Integer> listaAnios;
    private List<Long> seleccionNivelEstudios;
    private List<Long> seleccionFacultades;
    private List<Long> seleccionProgramas;
    private List<Long> seleccionEstadosCiviles;
    private List<Long> seleccionGeneros;
    private List<Integer> seleccionAnios;
    private List<String> criterioSeleccionado;
    private final ControladorListas listas;
    
    public SelectProgramaAction()
    {
        listas = new ControladorListas();
        criterioSeleccionado = new ArrayList<>();
    }

    /**
     * @return the listaNivelesEstudios
     */
    public Map<Long, String> getListaNivelesEstudios() {
        return listaNivelesEstudios;
    }

    /**
     * @param listaNivelesEstudios the listaNivelesEstudios to set
     */
    public void setListaNivelesEstudios(Map<Long, String> listaNivelesEstudios) {
        this.listaNivelesEstudios = listaNivelesEstudios;
    }

    /**
     * @return the listaFacultades
     */
    public Map<Long, String> getListaFacultades() {
        return listaFacultades;
    }

    /**
     * @param listaFacultades the listaFacultades to set
     */
    public void setListaFacultades(Map<Long, String> listaFacultades) {
        this.listaFacultades = listaFacultades;
    }
    
    /**
     * @return the listaEstadosCiviles
     */
    public Map<Long, String> getListaEstadosCiviles() {
        return listaEstadosCiviles;
    }

    /**
     * @param listaEstadosCiviles the listaEstadosCiviles to set
     */
    public void setListaEstadosCiviles(Map<Long, String> listaEstadosCiviles) {
        this.listaEstadosCiviles = listaEstadosCiviles;
    }

    /**
     * @return the listaProgramas
     */
    public Map<Long, String> getListaProgramas() {
        return listaProgramas;
    }

    /**
     * @param listaProgramas the listaProgramas to set
     */
    public void setListaProgramas(Map<Long, String> listaProgramas) {
        this.listaProgramas = listaProgramas;
    }
    
    /**
     * @return the listaGeneros
     */
    public Map<Long, String> getListaGeneros() {
        return listaGeneros;
    }

    /**
     * @param listaGeneros the listaGeneros to set
     */
    public void setListaGeneros(Map<Long, String> listaGeneros) {
        this.listaGeneros = listaGeneros;
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
     * @return the seleccionEstadosCiviles
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

    @Override
    public String execute() throws Exception {
        System.out.println("Carga");
        listaNivelesEstudios = listas.consultarMapNivelesEstudiosAplicaUCentral();
        listaFacultades = listas.consultarMapFacultades();
        listaEstadosCiviles = listas.consultarMapEstadosCiviles();
        listaGeneros = listas.consultarMapGeneros();
        listaAnios = listas.consultarAnios();
        
        if (seleccionNivelEstudios.size() > 0 && seleccionFacultades.size() > 0) {
            listaProgramas = listas.consultarMapProgramasPorListaFacultadYNivelEstudios(seleccionFacultades, seleccionNivelEstudios);
        }
        
        System.out.println("seleccionNivelEstudios :" + seleccionNivelEstudios);
        if (seleccionNivelEstudios.size() > 0 && !criterioSeleccionado.contains("Nivel de estudios")) {
            criterioSeleccionado.add("Nivel de estudios");
            for (Long nivelEstudios : seleccionNivelEstudios)
                criterioSeleccionado.add("- " + listaNivelesEstudios.get(nivelEstudios));
        }
        
        System.out.println("seleccionFacultades :" + seleccionFacultades);
        if (seleccionFacultades.size() > 0 && !criterioSeleccionado.contains("Facultad")) {
            criterioSeleccionado.add("Facultad");
            for (Long facultad : seleccionFacultades)
                criterioSeleccionado.add("- " + listaFacultades.get(facultad));
        }
        
        System.out.println("seleccionProgramas :" + seleccionProgramas);
        if (seleccionProgramas.size() > 0 && !criterioSeleccionado.contains("Programa")) {
            criterioSeleccionado.add("Programa");
            for (Long programa : seleccionProgramas)
                criterioSeleccionado.add("- " + listaProgramas.get(programa));
        }
        
        System.out.println("seleccionEstadosCiviles :" + seleccionEstadosCiviles);
        if (seleccionEstadosCiviles.size() > 0 && !criterioSeleccionado.contains("Estado civil"))
        {
            criterioSeleccionado.add("Estado civil");
                for (Long estadoCivil : seleccionEstadosCiviles)
                    criterioSeleccionado.add("- " + listaEstadosCiviles.get(estadoCivil));
        }
        
        System.out.println("seleccionGeneros :" + seleccionGeneros);
        if (seleccionGeneros.size() > 0 && !criterioSeleccionado.contains("Genero"))
        {
            criterioSeleccionado.add("Genero");
                for (Long genero : seleccionGeneros)
                    criterioSeleccionado.add("- " + listaGeneros.get(genero));
        }
        
        System.out.println("seleccionAnios :" + seleccionAnios);
        if (seleccionAnios.size() > 0 && !criterioSeleccionado.contains("Año de grado"))
        {
            criterioSeleccionado.add("Año de grado");
                for (Integer anio : seleccionAnios)
                    criterioSeleccionado.add("- " + anio);
        }
        
        System.out.println("Criterio seleccionado: " + criterioSeleccionado);
        
        return SUCCESS;
    }
    
    public String getJSON() throws Exception {
        return execute();
    }
    
    public String index() {
        return SUCCESS;
    }
}