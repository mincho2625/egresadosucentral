/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Modelo.AreaEstudios;
import Modelo.Ciudad;
import Modelo.EdFormalOtrasInstituciones;
import Modelo.EstadoEducacion;
import Modelo.Institucion;
import Modelo.Jornada;
import Modelo.Mes;
import Modelo.Modalidad;
import Modelo.NivelEstudios;
import Modelo.Programa;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author YURY
 */
public class EducacionFormalOtrasInstitucionesAction extends CrudAction<EdFormalOtrasInstituciones> {

    private Map<Long, Mes> listaMeses;
    private Map<Long, EstadoEducacion> listaEstadosEducacion;
    private Map<Long, Jornada> listaJornadas;
    private Map<Long, AreaEstudios> listaAreasEstudios;
    private Map<Long, Ciudad> listaCiudades;
    private Map<Long, Institucion> listaInstituciones;
    private Map<Long, Modalidad> listaModalidades;
    private Map<Long, NivelEstudios> listaNivelesEstudios;
    private ArrayList<Integer> listaAnios;

    private long mesInicio;
    private long mesFinalizacion;
    private long estadoEducacion;
    private long jornada;
    private long areaEstudios;
    private long ciudad;
    private long institucion;
    private long modalidad;
    private long nivelEstudios;
    private boolean checkOtraInstitucion;

    public EducacionFormalOtrasInstitucionesAction() {
        super(EdFormalOtrasInstituciones.class.getName());
        this.idObjeto = "getIdEducacion";
        this.coleccion = "getEducacionFormalOtrasInstituciones";
        this.claseConcretaPersistencia = Persistencia.EdFormalOtrasInstituciones.class;
        this.claseBasePersistencia = Persistencia.Educacion.class;
    }

    /**
     * @return the listaMeses
     */
    public Collection<Mes> getListaMeses() {
        return listaMeses.values();
    }

    /**
     * @param listaMeses the listaMeses to set
     */
    public void setListaMeses(Map<Long, Mes> listaMeses) {
        this.listaMeses = listaMeses;
    }

    /**
     * @return the listaEstadosEducacion
     */
    public Collection<EstadoEducacion> getListaEstadosEducacion() {
        return listaEstadosEducacion.values();
    }

    /**
     * @param listaEstadosEducacion the listaEstadosEducacion to set
     */
    public void setListaEstadosEducacion(Map<Long, EstadoEducacion> listaEstadosEducacion) {
        this.listaEstadosEducacion = listaEstadosEducacion;
    }

    /**
     * @return the listaJornadas
     */
    public Collection<Jornada> getListaJornadas() {
        return listaJornadas.values();
    }

    /**
     * @param listaJornadas the listaJornadas to set
     */
    public void setListaJornadas(Map<Long, Jornada> listaJornadas) {
        this.listaJornadas = listaJornadas;
    }

    /**
     * @return the listaAnios
     */
    public ArrayList<Integer> getListaAnios() {
        return listaAnios;
    }

    /**
     * @param listaAnios the listaAnios to set
     */
    public void setListaAnios(ArrayList<Integer> listaAnios) {
        this.listaAnios = listaAnios;
    }

    /**
     * @return the mesInicio
     */
    public long getMesInicio() {
        return mesInicio;
    }

    /**
     * @param mesInicio the mesInicio to set
     */
    public void setMesInicio(long mesInicio) {
        this.mesInicio = mesInicio;
    }

    /**
     * @return the mesFinalizacion
     */
    public long getMesFinalizacion() {
        return mesFinalizacion;
    }

    /**
     * @param mesFinalizacion the mesFinalizacion to set
     */
    public void setMesFinalizacion(long mesFinalizacion) {
        this.mesFinalizacion = mesFinalizacion;
    }

    /**
     * @return the estadoEducacion
     */
    public long getEstadoEducacion() {
        return estadoEducacion;
    }

    /**
     * @param estadoEducacion the estadoEducacion to set
     */
    public void setEstadoEducacion(long estadoEducacion) {
        this.estadoEducacion = estadoEducacion;
    }

    /**
     * @return the jornada
     */
    public long getJornada() {
        return jornada;
    }

    /**
     * @param jornada the jornada to set
     */
    public void setJornada(long jornada) {
        this.jornada = jornada;
    }

    /**
     * @return the listaAreasEstudios
     */
    public Collection<AreaEstudios> getListaAreasEstudios() {
        return listaAreasEstudios.values();
    }

    /**
     * @param listaAreasEstudios the listaAreasEstudios to set
     */
    public void setListaAreasEstudios(Map<Long, AreaEstudios> listaAreasEstudios) {
        this.listaAreasEstudios = listaAreasEstudios;
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
     * @return the listaInstituciones
     */
    public Collection<Institucion> getListaInstituciones() {
        return listaInstituciones.values();
    }

    /**
     * @param listaInstituciones the listaInstituciones to set
     */
    public void setListaInstituciones(Map<Long, Institucion> listaInstituciones) {
        this.listaInstituciones = listaInstituciones;
    }

    /**
     * @return the listaModalidades
     */
    public Collection<Modalidad> getListaModalidades() {
        return listaModalidades.values();
    }

    /**
     * @param listaModalidades the listaModalidades to set
     */
    public void setListaModalidades(Map<Long, Modalidad> listaModalidades) {
        this.listaModalidades = listaModalidades;
    }

    /**
     * @return the listaNivelesEstudios
     */
    public Collection<NivelEstudios> getListaNivelesEstudios() {
        return listaNivelesEstudios.values();
    }

    /**
     * @param listaNivelesEstudios the listaNivelesEstudios to set
     */
    public void setListaNivelesEstudios(Map<Long, NivelEstudios> listaNivelesEstudios) {
        this.listaNivelesEstudios = listaNivelesEstudios;
    }

    /**
     * @return the areaEstudios
     */
    public long getAreaEstudios() {
        return areaEstudios;
    }

    /**
     * @param areaEstudios the areaEstudios to set
     */
    public void setAreaEstudios(long areaEstudios) {
        this.areaEstudios = areaEstudios;
    }

    /**
     * @return the ciudad
     */
    public long getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(long ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the institucion
     */
    public long getInstitucion() {
        return institucion;
    }

    /**
     * @param institucion the institucion to set
     */
    public void setInstitucion(long institucion) {
        this.institucion = institucion;
    }

    /**
     * @return the modalidad
     */
    public long getModalidad() {
        return modalidad;
    }

    /**
     * @param modalidad the modalidad to set
     */
    public void setModalidad(long modalidad) {
        this.modalidad = modalidad;
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
     * @return the checkOtraInstitucion
     */
    public boolean isCheckOtraInstitucion() {
        return checkOtraInstitucion;
    }

    /**
     * @param checkOtraInstitucion the checkOtraInstitucion to set
     */
    public void setCheckOtraInstitucion(boolean checkOtraInstitucion) {
        this.checkOtraInstitucion = checkOtraInstitucion;
    }

    @Override
    public String desplegar() {
        this.setListaEstadosEducacion(listas.getListaEstadosEducacion());
        this.setListaMeses(listas.getListaMeses());
        this.setListaJornadas(listas.getListaJornadas());
        this.setListaAnios(listas.getListaAnios());
        this.setListaAreasEstudios(listas.getListaAreasEstudios());
        this.setListaCiudades(listas.getListaCiudades());
        this.setListaInstituciones(listas.getListaOtrasInstituciones());
        this.setListaModalidades(listas.getListaModalidades());
        this.setListaNivelesEstudios(listas.getListaNivelesEstudios());

        this.obtenerLista();
        this.editar = true;
        return SUCCESS;
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdEstadoEducacion(listas.getListaEstadosEducacion().get(this.estadoEducacion));
        this.objeto.setIdMesFinalizacion(listas.getListaMeses().get(this.mesFinalizacion));
        this.objeto.setIdMesInicio(listas.getListaMeses().get(this.mesInicio));
        this.objeto.setIdAreaEstudios(listas.getListaAreasEstudios().get(this.areaEstudios));
        this.objeto.setIdCiudad(listas.getListaCiudades().get(this.ciudad));
        this.objeto.setIdInstitucion(listas.getListaInstituciones().get(this.institucion));
        this.objeto.setIdModalidad(listas.getListaModalidades().get(this.modalidad));
        this.objeto.setIdNivelEstudios(listas.getListaNivelesEstudios().get(this.nivelEstudios));
        if (this.institucion > 0) {
            this.checkOtraInstitucion = false;
        }
    }

    @Override
    public void consultarTipos() {
        this.setEstadoEducacion(objeto.getIdEstadoEducacion().getIdEstadoEducacion());
        this.setMesInicio(objeto.getIdMesInicio().getIdMes());
        this.setAreaEstudios(objeto.getIdAreaEstudios().getIdAreaEstudios());
        this.setCiudad(objeto.getIdCiudad().getIdCiudad());
        this.setModalidad(objeto.getIdModalidad().getIdModalidad());
        this.setNivelEstudios(objeto.getIdNivelEstudios().getIdNivelEstudios());
        
        if (objeto.getIdMesFinalizacion() != null)
            this.setMesFinalizacion(objeto.getIdMesFinalizacion().getIdMes());
        if (objeto.getIdInstitucion() != null)
            this.setInstitucion(objeto.getIdInstitucion().getIdInstitucion());
    }

    @Override
    public void insertarValoresDefecto() {
        this.objeto.setEstado(true);
        this.objeto.setFechaRegistro(Date.valueOf(LocalDate.now()));
        this.objeto.setFechaActEstado(Date.valueOf(LocalDate.now()));
    }

    @Override
    public void validar() {
        if (mesInicio <= 0) {
            addFieldError("mesInicio", "El mes inicio es requerido.");
        }
        if (jornada <= 0) {
            addFieldError("jornada", "La jornada es requerida.");
        }
        if (areaEstudios <= 0) {
            addFieldError("areaEstudios", "El área de estudios es requerido.");
        }
        if (ciudad <= 0) {
            addFieldError("ciudad", "La ciudad es requerida.");
        }
        if (modalidad <= 0) {
            addFieldError("modalidad", "La modalidad es requerida.");
        }
        if (nivelEstudios <= 0) {
            addFieldError("nivelEstudios", "El nivel de estudios es requerido.");
        }
        if (objeto.getAnioInicio() <= 0) {
            addFieldError("anioInicio", "El año de inicio es requerido.");
        }
        if (objeto.getTitulo().isEmpty()) {
            addFieldError("titulo", "El título es requerido.");
        }

        // Estado educación
        if (estadoEducacion <= 0) {
            addFieldError("estadoEducacion", "El estado es requerido.");
        } else {
            // Configuración: Terminado
            if (estadoEducacion == 2) {
                if (objeto.getAnioFinalizacion() <= 0) {
                    addFieldError("anioFinalizacion", "El año de finalización es requerido.");
                } else if (objeto.getAnioFinalizacion() < objeto.getAnioInicio()) {
                    addFieldError("anioFinalizacion", "El año de finalización debe ser mayor al año de inicio.");
                }

                if (mesFinalizacion <= 0) {
                    addFieldError("mesFinalizacion", "El mes de finalización es requerido.");
                } else if (objeto.getAnioFinalizacion() == objeto.getAnioInicio()
                        && objeto.getIdMesFinalizacion().getNumero() < objeto.getIdMesInicio().getNumero()) {
                    addFieldError("mesFinalizacion", "El mes de finalización debe ser mayor o igual al mes de inicio.");
                }
            }
        }

        //otra institución
        if (isCheckOtraInstitucion()) {
            if (objeto.getOtraInstitucion().isEmpty()) {
                addFieldError("otraInstitucion", "La institución es requerida.");
            }
        } else {
            if (institucion <= 0) {
                addFieldError("institucion", "La institución es requerida.");
            }
        }
    }

    @Override
    public void validarLista() {
        this.setListaNivelesEstudios(listas.getListaNivelesEstudios());

        Collection<Long> lista = new ArrayList<>();
        for (EdFormalOtrasInstituciones ed : listaObjetos.values()) {
            lista.add(ed.getIdNivelEstudios().getIdNivelEstudios());
        }

        for (NivelEstudios nivel : listaNivelesEstudios.values()) {
            if (nivel.isObligatorioOtrasInst() && !lista.contains(nivel.getIdNivelEstudios())) {
                addActionError(String.format("Ingrese al menos un estudio de tipo %s", nivel.getNombre()));
            }
        }
    }
}