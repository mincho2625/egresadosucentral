/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controlador.ControladorEgresado;
import Modelo.Ciudad;
import Modelo.Egresado;
import Modelo.EstadoCivil;
import Modelo.Genero;
import Modelo.GrupoSanguineo;
import Modelo.PreguntaSeguridad;
import Modelo.TipoDocumento;
import Util.Listas;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author YURY
 */
public class RegistroAction extends ActionSupport implements ModelDriven<Egresado> {

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
    private long grupoSanguineo;
    private long genero;
    private long estadoCivil;
    private long preguntaSeguridad;
    private String confirmacionClave;
    private Egresado egresado = new Egresado();
    private boolean terminos;
    private ControladorEgresado controladorEgresado;
    private Listas listas;

    public RegistroAction() {
        controladorEgresado = new ControladorEgresado();
        listas = new Listas();
    }

    /**
     * @return the listaCiudades
     */
    public Collection<Ciudad> getListaCiudades() {
        return listaCiudades.values();
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
    public Collection<TipoDocumento> getListaTiposDocumento() {
        return listaTiposDocumento.values();
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
    public Collection<GrupoSanguineo> getListaGruposSanguineos() {
        return listaGruposSanguineos.values();
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
    public Collection<Genero> getListaGeneros() {
        return listaGeneros.values();
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
    public Collection<EstadoCivil> getListaEstadosCiviles() {
        return listaEstadosCiviles.values();
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
    public Collection<PreguntaSeguridad> getListaPreguntas() {
        return listaPreguntas.values();
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
     * @return the grupoSanguineo
     */
    public long getGrupoSanguineo() {
        return grupoSanguineo;
    }

    /**
     * @param grupoSanguineo the grupoSanguineo to set
     */
    public void setGrupoSanguineo(long grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
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
     * @return the listas
     */
    public Listas getListas() {
        return listas;
    }

    /**
     * @param listas the listas to set
     */
    public void setListas(Listas listas) {
        this.listas = listas;
    }

    @Override
    public Egresado getModel() {
        return this.egresado;
    }

    public String desplegar() {
        setListaCiudades(listas.getListaCiudades());
        setListaEstadosCiviles(listas.getListaEstadosCiviles());
        setListaGeneros(listas.getListaGeneros());
        setListaGruposSanguineos(listas.getListaGruposSanguineos());
        setListaTiposDocumento(listas.getListaTiposDocumento());
        setListaPreguntas(listas.getListaPreguntas());

        return "crear";
    }

    public String guardar() {
        validar();
        if (!this.hasErrors()) {
            insertarTipos();
            insertarValoresDefecto();
            controladorEgresado.actualizar(getEgresado());
            return SUCCESS;
        } else {
            desplegar();
            return ERROR;
        }
    }

    public void validar() {
        if (egresado.getPrimerApellido().equals("")) {
            addFieldError("primerApellido", "El primer apellido es requerido.");
        }

        if (egresado.getNombres().equals("")) {
            addFieldError("nombres", "Los nombres son requeridos.");
        }

        if (egresado.getFechaNacimiento() == null) {
            addFieldError("fechaNacimiento", "La fecha de nacimiento es requerida.");
        }

        if (egresado.getNumeroDocumento().equals("")) {
            addFieldError("numeroDocumento", "El número de documento es requerido.");
        }

        if (egresado.getFechaExpedicion() == null) {
            addFieldError("fechaExpedicion", "La fecha de expedición del documento es requerida.");
        }

        if (ciudadExpedicion <= 0) {
            addFieldError("ciudadExpedicion", "La ciudad de expedición del documento es requerida.");
        }

        if (ciudadNacimiento <= 0) {
            addFieldError("ciudadNacimiento", "La ciudad de nacimiento es requerida.");
        }

        if (tipoDocumento <= 0) {
            addFieldError("tipoDocumento", "El tipo de documento es requerido.");
        }

        if (genero <= 0) {
            addFieldError("genero", "El género es requerido.");
        }

        if (grupoSanguineo <= 0) {
            addFieldError("grupoSanguineo", "El grupo sanguíneo es requerido.");
        }

        if (estadoCivil <= 0) {
            addFieldError("estadoCivil", "El estado civil es requerido.");
        }

        if (egresado.getNombre().equals("")) {
            addFieldError("nombre", "El nombre de usuario es requerido");
        }

        if (egresado.getCorreoInstitucional().equals("")) {
            addFieldError("correoInstitucional", "El correo institucional es requerido");
        }

        if (egresado.getContrasenia().equals("")) {
            addFieldError("contrasenia", "La contrasenia es requerida");
        }

        if (!egresado.getContrasenia().equals(confirmacionClave)) {
            addFieldError("confirmacionClave", "La confirmación de contraseña es incorrecta.");
        }

        if (preguntaSeguridad <= 0) {
            addFieldError("preguntaSeguridad", "La pregunta de seguridad es requerida.");
        }

        if (egresado.getRespuestaSeguridad().equals("")) {
            addFieldError("respuestaSeguridad", "La respuesta de seguridad es requerida.");
        }

        if (!terminos) {
            addFieldError("terminos", "Debe aceptar términos y condiciones");
        }
    }
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

    public void insertarTipos() {
        this.egresado.setIdCiudadExpedicion(listas.getListaCiudades().get(ciudadExpedicion));
        this.egresado.setIdCiudadNacimiento(listas.getListaCiudades().get(ciudadNacimiento));
        this.egresado.setIdEstadoCivil(listas.getListaEstadosCiviles().get(estadoCivil));
        this.egresado.setIdGenero(listas.getListaGeneros().get(genero));
        this.egresado.setIdGrupoSanguineo(listas.getListaGruposSanguineos().get(grupoSanguineo));
        this.egresado.setIdPreguntaSeguridad(listas.getListaPreguntas().get(preguntaSeguridad));
        this.egresado.setIdTipoDocumento(listas.getListaTiposDocumento().get(tipoDocumento));
    }
//
//    @Override
//    public void consultarTipos() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//

    public void insertarValoresDefecto() {
        this.egresado.setAceptaCondiciones(true);
        this.egresado.setFechaRegistro(Date.valueOf(LocalDate.now()));
        this.egresado.setEstado(true);
    }
}
