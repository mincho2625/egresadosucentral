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
public class BusquedaAvanzadaAction extends ActionSupport {
    private List<Long> seleccionNivelEstudios;
    private List<Long> seleccionFacultades;
    private List<Long> seleccionGeneros;
    private List<Long> seleccionEstadosCiviles;
    private List<Long> seleccionProgramas;
    private List<Integer> seleccionEstados;
    private int anioFinalizacionDesde;
    private int anioFinalizacionHasta;
    private List<String> criterioSeleccionado;
    private Map<Long, String> listaProgramas;
    private final ControladorListas listas;
    
    public BusquedaAvanzadaAction()
    {
        criterioSeleccionado = new ArrayList<>();
        listas = new ControladorListas();
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
        criterioSeleccionado.clear();
        
        if (seleccionNivelEstudios.size() > 0 && seleccionFacultades.size() > 0) {
            listaProgramas = listas.consultarProgramasPorListaFacultadYNivelEstudiosMap(seleccionFacultades, seleccionNivelEstudios);
        }
        
        if (seleccionNivelEstudios.size() > 0) {
            criterioSeleccionado.add("- NIVEL DE ESTUDIOS");
            criterioSeleccionado.addAll(listas.consultarNivelesEstudiosMap(seleccionNivelEstudios).values());
            criterioSeleccionado.add("");
        }
        
        System.out.println("seleccionFacultadess: " + seleccionFacultades);
        if (seleccionFacultades.size() > 0) {
            criterioSeleccionado.add("- FACULTADES");
            criterioSeleccionado.addAll(listas.consultarFacultadesMap(seleccionFacultades).values());
            criterioSeleccionado.add("");
        }
        
        if (seleccionProgramas != null && seleccionProgramas.size() > 0) {
            criterioSeleccionado.add("- PROGRAMAS");
            criterioSeleccionado.addAll(listas.consultarProgramasMap(seleccionProgramas).values());
            criterioSeleccionado.add("");
        }
        
        if (seleccionGeneros.size() > 0)
        {
            criterioSeleccionado.add("- GÉNERO");
            criterioSeleccionado.addAll(listas.consultarGenerosMap(seleccionGeneros).values());
            criterioSeleccionado.add("");
        }
        
        if (seleccionEstadosCiviles.size() > 0)
        {
            criterioSeleccionado.add("- ESTADO CIVIL");
            criterioSeleccionado.addAll(listas.consultarEstadosCivilesMap(seleccionEstadosCiviles).values());
            criterioSeleccionado.add("");
        }
        
        if (seleccionEstados.size() > 0)
        {
            criterioSeleccionado.add("- ESTADO");
            for (int estado : seleccionEstados) criterioSeleccionado.add(estado == 1 ? "Activo" : "Inactivo");
            criterioSeleccionado.add("");
        }
        
        criterioSeleccionado.add("- AÑO DE GRADO");
        criterioSeleccionado.add(anioFinalizacionDesde + " - " + anioFinalizacionHasta);
        
        return SUCCESS;
    }
   
    
    public String getJSON() throws Exception {
        return execute();
    }
    
    public String index() {
        return SUCCESS;
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
     * @return the anioFinalizacionDesde
     */
    public int getAnioFinalizacionDesde() {
        return anioFinalizacionDesde;
    }

    /**
     * @param anioFinalizacionDesde the anioFinalizacionDesde to set
     */
    public void setAnioFinalizacionDesde(int anioFinalizacionDesde) {
        this.anioFinalizacionDesde = anioFinalizacionDesde;
    }

    /**
     * @return the anioFinalizacionHasta
     */
    public int getAnioFinalizacionHasta() {
        return anioFinalizacionHasta;
    }

    /**
     * @param anioFinalizacionHasta the anioFinalizacionHasta to set
     */
    public void setAnioFinalizacionHasta(int anioFinalizacionHasta) {
        this.anioFinalizacionHasta = anioFinalizacionHasta;
    }

    /**
     * @return the seleccionEstados
     */
    public List<Integer> getSeleccionEstados() {
        return seleccionEstados;
    }

    /**
     * @param seleccionEstados the seleccionEstados to set
     */
    public void setSeleccionEstados(List<Integer> seleccionEstados) {
        this.seleccionEstados = seleccionEstados;
    }
}