/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controlador.ControladorEgresado;
import Modelo.Ciudad;
import Modelo.Departamento;
import Modelo.Egresado;
import Modelo.EstadoCivil;
import Modelo.Genero;
import Modelo.GrupoSanguineo;
import Modelo.Pais;
import Modelo.PreguntaSeguridad;
import Modelo.TipoDocumento;
import Util.Listas;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author YURY
 */
public class RegistroAction implements ModelDriven<Egresado> {

//    private Map<Long, Pais> listaPaises;
//    private Map<Long, Departamento> listaDepartamentos;
    private Map<Long, Ciudad> listaCiudades;
    private Map<Long, TipoDocumento> listaTiposDocumento;
    private Map<Long, GrupoSanguineo> listaGruposSanguineos;
    private Map<Long, Genero> listaGeneros;
    private Map<Long, EstadoCivil> listaEstadosCiviles;
    private Map<Long, PreguntaSeguridad> listaPreguntas;
    private long ciudadNacimiento;
    private long ciudadExpedicion;
    private long tipoDocumento;
    private long genero;
    private long estadoCivil;
    private long preguntaSeguridad;
    private String confirmacionClave;
    private Egresado egresado;
    private ControladorEgresado controladorEgresado;

    public RegistroAction() {
        
    }

    /**
     * @return the listaCiudades
     */
    public Map<Long, Ciudad> getListaCiudades() {
        return listaCiudades;
    }

    /**
     * @param listaCiudades the listaCiudades to set
     */
    public void setListaCiudades(Map<Long, Ciudad> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }

    /**
     * @return the listaTiposDocumento
     */
    public Map<Long, TipoDocumento> getListaTiposDocumento() {
        return listaTiposDocumento;
    }

    /**
     * @param listaTiposDocumento the listaTiposDocumento to set
     */
    public void setListaTiposDocumento(Map<Long, TipoDocumento> listaTiposDocumento) {
        this.listaTiposDocumento = listaTiposDocumento;
    }

    /**
     * @return the listaGruposSanguineos
     */
    public Map<Long, GrupoSanguineo> getListaGruposSanguineos() {
        return listaGruposSanguineos;
    }

    /**
     * @param listaGruposSanguineos the listaGruposSanguineos to set
     */
    public void setListaGruposSanguineos(Map<Long, GrupoSanguineo> listaGruposSanguineos) {
        this.listaGruposSanguineos = listaGruposSanguineos;
    }

    /**
     * @return the listaGeneros
     */
    public Map<Long, Genero> getListaGeneros() {
        return listaGeneros;
    }

    /**
     * @param listaGeneros the listaGeneros to set
     */
    public void setListaGeneros(Map<Long, Genero> listaGeneros) {
        this.listaGeneros = listaGeneros;
    }

    /**
     * @return the listaEstadosCiviles
     */
    public Map<Long, EstadoCivil> getListaEstadosCiviles() {
        return listaEstadosCiviles;
    }

    /**
     * @param listaEstadosCiviles the listaEstadosCiviles to set
     */
    public void setListaEstadosCiviles(Map<Long, EstadoCivil> listaEstadosCiviles) {
        this.listaEstadosCiviles = listaEstadosCiviles;
    }

    /**
     * @return the listaPreguntas
     */
    public Map<Long, PreguntaSeguridad> getListaPreguntas() {
        return listaPreguntas;
    }

    /**
     * @param listaPreguntas the listaPreguntas to set
     */
    public void setListaPreguntas(Map<Long, PreguntaSeguridad> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }

    /**
     * @return the ciudadNacimiento
     */
    public long getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    /**
     * @param ciudadNacimiento the ciudadNacimiento to set
     */
    public void setCiudadNacimiento(long ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    /**
     * @return the ciudadExpedicion
     */
    public long getCiudadExpedicion() {
        return ciudadExpedicion;
    }

    /**
     * @param ciudadExpedicion the ciudadExpedicion to set
     */
    public void setCiudadExpedicion(long ciudadExpedicion) {
        this.ciudadExpedicion = ciudadExpedicion;
    }

    /**
     * @return the tipoDocumento
     */
    public long getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(long tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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
     * @return the preguntaSeguridad
     */
    public long getPreguntaSeguridad() {
        return preguntaSeguridad;
    }

    /**
     * @param preguntaSeguridad the preguntaSeguridad to set
     */
    public void setPreguntaSeguridad(long preguntaSeguridad) {
        this.preguntaSeguridad = preguntaSeguridad;
    }

    /**
     * @return the confirmacionClave
     */
    public String getConfirmacionClave() {
        return confirmacionClave;
    }

    /**
     * @param confirmacionClave the confirmacionClave to set
     */
    public void setConfirmacionClave(String confirmacionClave) {
        this.confirmacionClave = confirmacionClave;
    }
    
    /**
     * @return the egresado
     */
    public Egresado getEgresado() {
        return egresado;
    }

    /**
     * @param egresado the egresado to set
     */
    public void setEgresado(Egresado egresado) {
        this.egresado = egresado;
    }

    @Override
    public Egresado getModel() {
        return this.egresado;
    }

    private String desplegar() {
        setListaCiudades(Listas.obtenerListas().getListaCiudades());
        setListaEstadosCiviles(Listas.obtenerListas().getListaEstadosCiviles());
        setListaGeneros(Listas.obtenerListas().getListaGeneros());
        setListaGruposSanguineos(Listas.obtenerListas().getListaGruposSanguineos());
        setListaTiposDocumento(Listas.obtenerListas().getListaTiposDocumento());
        setListaPreguntas(Listas.obtenerListas().getListaPreguntas());

        return "nuevo";
    }

    public String obtenerEgresado() {
        Map session = ActionContext.getContext().getSession();
        String usuario = (String) session.get("usuario");
        ControladorEgresado controladorEgresado = new ControladorEgresado(usuario);
       //setEgresado(controladorEgresado.obtenerInformacionBasica());
        desplegar();
        

        return "actual";
    }
//
//    public String crearEgresado() {
//        if (terminos) {
//            if (getEgresado().getClave().equals(getConfirmacionClave())) {
//                ControladorEgresado controladorEgresado = new ControladorEgresado();
//                controladorEgresado.crearEgresado(getEgresado());
//                return "successNuevo";
//            } else {
//                addActionError("La confirmación de contraseña es incorrecta");
//                return "errorNuevo";
//            }
//        } else {
//            addActionError("Debe aceptar términos y condiciones");
//            return "errorNuevo";
//        }
//    }
//
//    public String actualizarEgresado() {
//        if (terminos) {
//            ControladorEgresado controladorEgresado = new ControladorEgresado();
//            controladorEgresado.actualizarInformacionBasica(getEgresado());
//            return "successActual";
//        } else {
//            addActionError("Debe aceptar términos y condiciones");
//            return "errorActual";
//        }
//    }
//
//    @Override
//    public void insertarTipos() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void consultarTipos() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void insertarValoresDefecto() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
