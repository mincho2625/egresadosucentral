/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controlador.ControladorCorreo;
import Controlador.ControladorEgresado;
import Controlador.ControladorListas;
import Modelo.EducacionFormalUcentral;
import Modelo.ItemLista;
import Modelo.PlantillaCorreo;
import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.mail.Address;
import javax.mail.internet.AddressException;
import javax.naming.NamingException;

/**
 *
 * @author YURY
 */
public class EgresadosAction extends ActionSupport {
    private List<ItemLista> listaPlantillas;
    private Map<String, String> listaColumnas;
    private List<Long> seleccionNivelEstudios;
    private List<Long> seleccionFacultades;
    private List<Long> seleccionProgramas;
    private List<Long> seleccionEstadosCiviles;
    private List<Integer> seleccionAnios;
    private List<Long> seleccionGeneros;
    private Map<String, Object> parametros;
    private List<EducacionFormalUcentral> listaEgresados;
    private List<String> criterioSeleccionado;
    private final ControladorListas listas;
    
    private int indice;
    
    private List<String> seleccionIdColumnas;
    private List<String> seleccionIdColumnasTemp;
    private Map<String, String> seleccionColumnas;
    private List<Long> seleccionEgresados;
    private final ControladorCorreo controladorCorreo;
    private long plantilla;
    
    public EgresadosAction()
    {
        listas = new ControladorListas();
        controladorCorreo = new ControladorCorreo();
        seleccionColumnas = new HashMap<>();
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
     * @return the listaColumnas
     */
    public Map<String, String> getListaColumnas() {
        return listaColumnas;
    }

    /**
     * @param listaColumnas the listaColumnas to set
     */
    public void setListaColumnas(Map<String, String> listaColumnas) {
        this.listaColumnas = listaColumnas;
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
    public List<EducacionFormalUcentral> getListaEgresados() {
        return listaEgresados;
    }

    /**
     * @param listaEgresados the listaEgresados to set
     */
    public void setListaEgresados(List<EducacionFormalUcentral> listaEgresados) {
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
    
    
    
    /**
     * @return the indice
     */
    public int getIndice() {
        return indice;
    }

    /**
     * @param indice the indice to set
     */
    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    private void desplegar()
    {
        listaPlantillas = listas.consultarPlantillasCorreo();
    }
    
    private void validar()
    {
        if (seleccionEgresados.isEmpty())
            addActionError("Seleccione al menos un egresado.");
    }
    
    private void validarCorreoMasivo()
    {
        if (plantilla <= 0)
            addActionError("Seleccione plantilla de correo.");
    }
    
    private void validarBuscar()
    {
        if (seleccionColumnas.isEmpty())
            addActionError("Seleccione al menos una columna.");
    }
    
    public String mostrar() {
        return SUCCESS;
    }
    
    public String buscar() {
        seleccionIdColumnasTemp = seleccionIdColumnas;
        System.out.println("Inicio Buscar");
        System.out.println("Resultado seleccionIdColumnasTemp: " + seleccionIdColumnasTemp);
        //validarBuscar();
        
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
            indice = 1;
            
            listarColumnas();
            
            System.out.println("Fin Buscar");
            return SUCCESS;
        }
        
        addActionError("Error al buscar resultados.");
        return ERROR;
    }
    
    public String enviarCorreo() throws AddressException, NamingException
    {
        validar();
        validarCorreoMasivo();
        if (!hasErrors()) {

            Address[] listaDestinatarios = controladorCorreo.consultarDestinatarios(getSeleccionEgresados());
            PlantillaCorreo plantillaCorreo = controladorCorreo.consultarPlantillaCorreo(getPlantilla());
            
            if (controladorCorreo.enviarCorreo(plantillaCorreo, listaDestinatarios)) {
                addActionMessage("Correos enviados exitosamente");
                return SUCCESS;
            }
            
            addActionError("Error al enviar correo masivo.");
            return ERROR;
        }
        
        return ERROR;
    }
    
    public String activar()
    {
        validar();
        if (!hasErrors()) {
            ControladorEgresado controladorEgresado = new ControladorEgresado();
            controladorEgresado.activar(seleccionEgresados, true);
            return SUCCESS;
        }
        
        return ERROR;
    }
    
    public String inactivar()
    {
        validar();
        if (!hasErrors()) {
            ControladorEgresado controladorEgresado = new ControladorEgresado();
            controladorEgresado.activar(seleccionEgresados, false);
            return SUCCESS;
        }
        
        return ERROR;
    }
    
    private void listarColumnas()
    {
        setListaColumnas(new HashMap<>());
        getListaColumnas().put("egresado.nombres", "Nombres");
        getListaColumnas().put("egresado.primerApellido", "Primer apellido");
        getListaColumnas().put("egresado.segundoApellido", "Segundo apellido");
        getListaColumnas().put("egresado.numeroDocumento", "Documento");
        getListaColumnas().put("idPrograma.nombre", "Programa");
        getListaColumnas().put("egresado.estado", "Estado");
        
        for (String idColumna : seleccionIdColumnas) {
            seleccionColumnas.put(idColumna, listaColumnas.get(idColumna));
        }
    }

    /**
     * @return the seleccionIdColumnas
     */
    public List<String> getSeleccionIdColumnas() {
        return seleccionIdColumnas;
    }

    /**
     * @param seleccionIdColumnas the seleccionIdColumnas to set
     */
    public void setSeleccionIdColumnas(List<String> seleccionIdColumnas) {
        this.seleccionIdColumnas = seleccionIdColumnas;
    }

    /**
     * @return the seleccionColumnas
     */
    public Map<String, String> getSeleccionColumnas() {
        return seleccionColumnas;
    }

    /**
     * @param seleccionColumnas the seleccionColumnas to set
     */
    public void setSeleccionColumnas(Map<String, String> seleccionColumnas) {
        this.seleccionColumnas = seleccionColumnas;
    }

    /**
     * @return the seleccionIdColumnasTemp
     */
    public List<String> getSeleccionIdColumnasTemp() {
        return seleccionIdColumnasTemp;
    }

    /**
     * @param seleccionIdColumnasTemp the seleccionIdColumnasTemp to set
     */
    public void setSeleccionIdColumnasTemp(List<String> seleccionIdColumnasTemp) {
        this.seleccionIdColumnasTemp = seleccionIdColumnasTemp;
    }

    /**
     * @return the plantilla
     */
    public long getPlantilla() {
        return plantilla;
    }

    /**
     * @param plantilla the plantilla to set
     */
    public void setPlantilla(long plantilla) {
        this.plantilla = plantilla;
    }

    /**
     * @return the seleccionEgresados
     */
    public List<Long> getSeleccionEgresados() {
        return seleccionEgresados;
    }

    /**
     * @param seleccionEgresados the seleccionEgresados to set
     */
    public void setSeleccionEgresados(List<Long> seleccionEgresados) {
        this.seleccionEgresados = seleccionEgresados;
    }
}