/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Ciudad;
import Modelo.Departamento;
import Modelo.Egresado;
import Modelo.EstadoCivil;
import Modelo.Genero;
import Modelo.GrupoSanguineo;
import Modelo.Pais;
import Modelo.PreguntaSeguridad;
import Modelo.TipoDocumento;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author YURY
 */
public class RegistroAction extends ActionSupport implements ModelDriven<Egresado> {

    private Egresado egresado = new Egresado();
    private ArrayList<Pais> listaPaises;
    private ArrayList<Departamento> listaDepartamentos;
    private ArrayList<Ciudad> listaCiudades;
    private ArrayList<TipoDocumento> listaTiposDocumento;
    private ArrayList<GrupoSanguineo> listaGruposSanguineos;
    private ArrayList<Genero> listaGeneros;
    private ArrayList<EstadoCivil> listaEstadosCiviles;
    private ArrayList<PreguntaSeguridad> listaPreguntas;
    private int idPais;
    private int idDepartamento;
    private String confirmacionClave;
    private boolean terminos;

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

    /**
     * @return the listaPaises
     */
    public ArrayList<Pais> getListaPaises() {
        return listaPaises;
    }

    /**
     * @param listaPaises the listaPaises to set
     */
    public void setListaPaises(ArrayList<Pais> listaPaises) {
        this.listaPaises = listaPaises;
    }

    /**
     * @return the listaDepartamentos
     */
    public ArrayList<Departamento> getListaDepartamentos() {
        return listaDepartamentos;
    }

    /**
     * @param listaDepartamentos the listaDepartamentos to set
     */
    public void setListaDepartamentos(ArrayList<Departamento> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    /**
     * @return the listaCiudades
     */
    public ArrayList<Ciudad> getListaCiudades() {
        return listaCiudades;
    }

    /**
     * @param listaCiudades the listaCiudades to set
     */
    public void setListaCiudades(ArrayList<Ciudad> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }

    /**
     * @return the listaTiposDocumento
     */
    public ArrayList<TipoDocumento> getListaTiposDocumento() {
        return listaTiposDocumento;
    }

    /**
     * @param listaTiposDocumento the listaTiposDocumento to set
     */
    public void setListaTiposDocumento(ArrayList<TipoDocumento> listaTiposDocumento) {
        this.listaTiposDocumento = listaTiposDocumento;
    }

    /**
     * @return the listaGruposSanguineos
     */
    public ArrayList<GrupoSanguineo> getListaGruposSanguineos() {
        return listaGruposSanguineos;
    }

    /**
     * @param listaGruposSanguineos the listaGruposSanguineos to set
     */
    public void setListaGruposSanguineos(ArrayList<GrupoSanguineo> listaGruposSanguineos) {
        this.listaGruposSanguineos = listaGruposSanguineos;
    }

    /**
     * @return the listaGeneros
     */
    public ArrayList<Genero> getListaGeneros() {
        return listaGeneros;
    }

    /**
     * @param listaGeneros the listaGeneros to set
     */
    public void setListaGeneros(ArrayList<Genero> listaGeneros) {
        this.listaGeneros = listaGeneros;
    }

    /**
     * @return the listaEstadosCiviles
     */
    public ArrayList<EstadoCivil> getListaEstadosCiviles() {
        return listaEstadosCiviles;
    }

    /**
     * @param listaEstadosCiviles the listaEstadosCiviles to set
     */
    public void setListaEstadosCiviles(ArrayList<EstadoCivil> listaEstadosCiviles) {
        this.listaEstadosCiviles = listaEstadosCiviles;
    }
    
    /**
     * @return the listaPreguntas
     */
    public ArrayList<PreguntaSeguridad> getListaPreguntas() {
        return listaPreguntas;
    }

    /**
     * @param listaPreguntas the listaPreguntas to set
     */
    public void setListaPreguntas(ArrayList<PreguntaSeguridad> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }

    /**
     * @return the idPais
     */
    public int getIdPais() {
        return idPais;
    }

    /**
     * @param idPais the idPais to set
     */
    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    /**
     * @return the idDepartamento
     */
    public int getIdDepartamento() {
        return idDepartamento;
    }

    /**
     * @param idDepartamento the idDepartamento to set
     */
    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
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
     * @return the terminos
     */
    public boolean isTerminos() {
        return terminos;
    }

    /**
     * @param terminos the terminos to set
     */
    public void setTerminos(boolean terminos) {
        this.terminos = terminos;
    }

    @Override
    public Egresado getModel() {
        return getEgresado();
    }

    private String desplegar() {
        ControladorListas cl = new ControladorListas();
//        setListaPaises(cl.obtenerPaises());
//        setListaDepartamentos(new ArrayList<Departamento>());
        setListaCiudades(cl.obtenerCiudades());
        setListaEstadosCiviles(cl.obtenerEstadosCiviles());
        setListaGeneros(cl.obtenerGeneros());
        setListaGruposSanguineos(cl.obtenerGruposSanguineos());
        setListaTiposDocumento(cl.obtenerTiposDocumento());
        setListaPreguntas(cl.obtenerPreguntasSeguridad());

        return "populate";
    }

    @Actions({
        @Action(
                value = "/refrescarPaises",
                results = {
                    @Result(name = "populate", type = "json")
                })
    })
    public String refrescarPaises() {
        if (idPais > 0) {
            ControladorListas cl = new ControladorListas();
            setListaPaises(cl.obtenerPaises());
            setListaDepartamentos(cl.obtenerDepartamentosPorPais(getIdPais()));
            setListaCiudades(cl.obtenerCiudadesPorDepartamento(getIdDepartamento()));
        }
        return "populate";
    }

    public String nuevoEgresado() {
        setEgresado(new Egresado());
        desplegar();

        return "nuevo";
    }

    public String obtenerEgresado() {
        ControladorEgresado controladorEgresado = new ControladorEgresado(1);
        setEgresado(controladorEgresado.obtenerInformacionBasica());
        desplegar();

        return "actual";
    }

    public String crearEgresado() {
        if (terminos) {
            if (egresado.getClave().equals(confirmacionClave)) {
                ControladorEgresado controladorEgresado = new ControladorEgresado();
                controladorEgresado.actualizarInformacionBasica(egresado);
                return "successNuevo";
            } else {
                addActionError("La confirmación de contraseña es incorrecta");
                return "errorNuevo";
            }
        } else {
            addActionError("Debe aceptar términos y condiciones");
            return "errorNuevo";
        }
    }
}
