/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controlador.ControladorColumnas;
import Controlador.ControladorCorreo;
import Controlador.ControladorEgresado;
import Controlador.ControladorListas;
import Modelo.EducacionFormalUcentral;
import Modelo.Egresado;
import Modelo.ItemLista;
import Modelo.PlantillaCorreo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.mail.Address;
import javax.mail.internet.AddressException;
import javax.naming.NamingException;

/**
 *
 * @author YURY
 */
public class EgresadosAction extends ActionSupport {

    private Map<Long, String> listaNivelesEstudios;
    private Map<Long, String> listaFacultades;
    private Map<Long, String> listaGeneros;
    private Map<Long, String> listaProgramas;
    private Map<Long, String> listaEstadosCiviles;
    private Map<Integer, String> listaEstados;
    private List<Long> seleccionNivelEstudios;
    private List<Long> seleccionFacultades;
    private List<Long> seleccionGeneros;
    private List<Long> seleccionEstadosCiviles;
    private List<Long> seleccionProgramas;
    private List<Integer> seleccionEstados;
    private int anioFinalizacionDesde;
    private int anioFinalizacionHasta;
    private int actual;

    private List<ItemLista> listaPlantillas;
    private Map<String, String> listaColumnas;
    private List<Egresado> listaEgresados;
    private List<Long> seleccionEgresados;
    private long plantilla;
    private int indice;
    private final ControladorListas listas;
    private final ControladorCorreo controladorCorreo;

    public EgresadosAction() {
        listas = new ControladorListas();
        controladorCorreo = new ControladorCorreo();
        desplegar();
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

    private void desplegar() {
        listaNivelesEstudios = listas.consultarNivelesEstudiosAplicaUCentralMap();
        listaFacultades = listas.consultarFacultadesMap();
        listaGeneros = listas.consultarGenerosMap();
        setListaEstadosCiviles(listas.consultarEstadosCivilesMap());
        listaPlantillas = listas.consultarPlantillasCorreo();

        listaEstados = new HashMap<>();
        listaEstados.put(1, "Activo");
        listaEstados.put(0, "Inactivo");

        Calendar calendario = Calendar.getInstance(Locale.ROOT);
        actual = calendario.get(Calendar.YEAR);
        anioFinalizacionDesde = actual - 1;
        anioFinalizacionHasta = actual;

        seleccionProgramas = new ArrayList<>();
    }

    private void validar() {
        if (seleccionEgresados == null || seleccionEgresados.isEmpty()) {
            addActionError("Seleccione al menos un egresado.");
        }
    }

    private void validarCorreoMasivo() {
        if (plantilla <= 0) {
            addActionError("Seleccione plantilla de correo.");
        }

    }

    public String mostrar() {
        return SUCCESS;
    }

    public String limpiar() {
        seleccionNivelEstudios.clear();
        seleccionFacultades.clear();
        seleccionGeneros.clear();
        seleccionEstadosCiviles.clear();
        seleccionProgramas.clear();
        seleccionEstados.clear();

        return SUCCESS;
    }

    public String buscar() {
        System.out.println("Inicio Buscar");

        System.out.println("seleccionNivelEstudios: " + seleccionNivelEstudios);
        System.out.println("seleccionFacultades: " + seleccionFacultades);
        System.out.println("seleccionProgramas: " + seleccionProgramas);

        if (seleccionNivelEstudios != null && seleccionNivelEstudios.size() > 0
                && seleccionFacultades != null && seleccionFacultades.size() > 0) {
            setListaProgramas(listas.consultarProgramasPorListaFacultadYNivelEstudiosMap(seleccionFacultades, seleccionNivelEstudios));
        }
        System.out.println("seleccionProgramass: " + seleccionProgramas);

        if (!hasErrors()) {
            Map<String, Object> parametros = new HashMap<>();
            if (this.seleccionProgramas.size() > 0) {
                parametros.put("idPrograma", this.seleccionProgramas);
            }
            if (this.seleccionNivelEstudios.size() > 0) {
                parametros.put("idNivelEstudios", this.seleccionNivelEstudios);
            }
            if (this.seleccionFacultades.size() > 0) {
                parametros.put("idFacultad", this.seleccionFacultades);
            }
            if (this.seleccionGeneros.size() > 0) {
                parametros.put("idGenero", this.seleccionGeneros);
            }
            if (this.seleccionEstadosCiviles.size() > 0) {
                parametros.put("idEstadoCivil", this.seleccionEstadosCiviles);
            }
            if (this.seleccionEstados.size() > 0) {
                parametros.put("estado", this.seleccionEstados);
            }
            parametros.put("anioFinalizacionDesde", this.anioFinalizacionDesde);
            parametros.put("anioFinalizacionHasta", this.anioFinalizacionHasta);

            // buscar
            ControladorEgresado controladorEgresado = new ControladorEgresado();
            listaEgresados = controladorEgresado.consultar(parametros);
            indice = 1;

            // Consultar columnas para mostrar información
            Map session = ActionContext.getContext().getSession();
            long idUsuario = (long) session.get("idUsuario");
            ControladorColumnas controladorColumnas = new ControladorColumnas();
            listaColumnas = controladorColumnas.consultarEducacionFormalUCentralPorUsuarioMap(idUsuario);
            System.out.println("listaColumnas: " + listaColumnas);

            System.out.println("Fin Buscar");
            return SUCCESS;
        }

        addActionError("Error al buscar resultados.");
        return ERROR;
    }

    public String enviarCorreo() throws AddressException, NamingException {
        indice = 1;
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

    public String activar() {
        indice = 1;
        validar();
        if (!hasErrors()) {
            ControladorEgresado controladorEgresado = new ControladorEgresado();
            controladorEgresado.activar(seleccionEgresados, true);
            return SUCCESS;
        }

        return ERROR;
    }

    public String inactivar() {
        indice = 1;
        validar();
        if (!hasErrors()) {
            ControladorEgresado controladorEgresado = new ControladorEgresado();
            controladorEgresado.activar(seleccionEgresados, false);
            return SUCCESS;
        }

        return ERROR;
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
     * @return the actual
     */
    public int getActual() {
        return actual;
    }

    /**
     * @param actual the actual to set
     */
    public void setActual(int actual) {
        this.actual = actual;
    }

    /**
     * @return the listaEstados
     */
    public Map<Integer, String> getListaEstados() {
        return listaEstados;
    }

    /**
     * @param listaEstados the listaEstados to set
     */
    public void setListaEstados(Map<Integer, String> listaEstados) {
        this.listaEstados = listaEstados;
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
