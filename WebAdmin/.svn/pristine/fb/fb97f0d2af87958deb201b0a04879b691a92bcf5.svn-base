/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorCorreo;
import Controlador.ControladorListas;
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
public class CorreoMasivoAction extends ActionSupport {
    private List<Integer> listaAnios;
    private List<ItemLista> listaGeneros;
    private List<ItemLista> listaEstadosCiviles;
    private List<ItemLista> listaPlantillas;
    private long nivelEstudios;
    private long facultad;
    private long programa;
    private int anioGrado;
    private long genero;
    private long estadoCivil;
    private long plantilla;
    private final ControladorListas listas;
    private Map<String, Object> parametros;
    private final ControladorCorreo controladorCorreo;
    
    public CorreoMasivoAction()
    {
        listas = new ControladorListas();
        controladorCorreo = new ControladorCorreo();
        desplegar();
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

    /**
     * @return the programa
     */
    public long getPrograma() {
        return programa;
    }

    /**
     * @param programa the programa to set
     */
    public void setPrograma(long programa) {
        this.programa = programa;
    }

    /**
     * @return the anioGrado
     */
    public int getAnioGrado() {
        return anioGrado;
    }

    /**
     * @param anioGrado the anioGrado to set
     */
    public void setAnioGrado(int anioGrado) {
        this.anioGrado = anioGrado;
    }

    /**
     * @return the genero
     */
    public long getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(long genero) {
        this.genero = genero;
    }

    /**
     * @return the estadoCivil
     */
    public long getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(long estadoCivil) {
        this.estadoCivil = estadoCivil;
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
    
    private void desplegar()
    {
        listaAnios = listas.consultarAnios();
        listaEstadosCiviles = listas.consultarEstadosCiviles();
        listaGeneros = listas.consultarGeneros();
        listaPlantillas = listas.consultarPlantillasCorreo();
    }
    
    private void validar()
    {
        if (plantilla <= 0)
            addFieldError("plantilla", "La plantilla de correo es requerida");
    }
    
    public String mostrar() {
        return SUCCESS;
    }
    
    public String enviar() throws NamingException, AddressException {
        validar();
        
        if (!hasErrors()) {
            parametros = new HashMap<>();
            parametros.put("idPrograma", this.programa > 0 ? this.programa : null);
            parametros.put("idNivelEstudios", this.nivelEstudios > 0 ? this.nivelEstudios : null);
            parametros.put("idFacultad", this.facultad > 0 ? this.facultad : null);
            parametros.put("anioFinalizacion", this.anioGrado > 0 ? this.anioGrado : null);
            parametros.put("idGenero", this.genero > 0 ? this.genero : null);
            parametros.put("idEstadoCivil", this.estadoCivil > 0 ? this.estadoCivil : null);

            Address[] listaDestinatarios = controladorCorreo.consultarDestinatarios(parametros);
            PlantillaCorreo plantillaCorreo = controladorCorreo.consultarPlantillaCorreo(plantilla);
            
            if (controladorCorreo.enviarCorreo(plantillaCorreo, listaDestinatarios)) {
                addActionMessage("Correos enviados exitosamente");
                return SUCCESS;
            }
        }
        
        addActionError("Error al enviar correo.");
        return ERROR;
    }
}