/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.EducacionFormalUCentral;
import Modelo.EstadoEducacion;
import Modelo.Jornada;
import Modelo.Mes;
import Modelo.NivelEstudios;
import Modelo.Programa;
import Util.Configuracion;
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
public class EducacionFormalUCentralAction extends CrudAction<EducacionFormalUCentral> {
    private Map<Long, Mes> listaMeses;
    private Map<Long, EstadoEducacion> listaEstadosEducacion;
    private Map<Long, Jornada> listaJornadas;
    private Map<Long, Programa> listaProgramas;
    private ArrayList<Integer> listaAnios;
    private long mesInicio;
    private long mesFinalizacion;
    private long estadoEducacion;
    private long programa;
    private long jornada;

    public EducacionFormalUCentralAction() {
        super(EducacionFormalUCentral.class.getName());
        this.idObjeto = "getIdEducacion";
        this.coleccion = "getEducacionFormalUcentral";
        this.claseConcretaPersistencia = Persistencia.EducacionFormalUcentral.class;
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
     * @return the listaProgramas
     */
    public Collection<Programa> getListaProgramas() {
        return listaProgramas.values();
    }

    /**
     * @param listaProgramas the listaProgramas to set
     */
    public void setListaProgramas(Map<Long, Programa> listaProgramas) {
        this.listaProgramas = listaProgramas;
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
    
    @Override
    public String desplegar() {
        this.setListaEstadosEducacion(listas.consultarEstadosEducacion());
        this.setListaMeses(listas.consultarMeses());
        this.setListaJornadas(listas.consultarJornadas());
        this.setListaProgramas(listas.consultarProgramas());
        this.setListaAnios(listas.consultarAnios());
        
        this.obtenerLista();
        this.editar = true;
        return SUCCESS;
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdEstadoEducacion(listas.consultarEstadosEducacion().get(this.estadoEducacion));
        this.objeto.setIdJornada(listas.consultarJornadas().get(this.jornada));
        this.objeto.setIdMesFinalizacion(listas.consultarMeses().get(this.mesFinalizacion));
        this.objeto.setIdMesInicio(listas.consultarMeses().get(this.mesInicio));
        this.objeto.setIdPrograma(listas.consultarProgramas().get(this.programa));
    }

    @Override
    public void consultarTipos() {
        this.setEstadoEducacion(objeto.getIdEstadoEducacion().getIdEstadoEducacion());
        this.setJornada(objeto.getIdJornada().getIdJornada());
        this.setMesInicio(objeto.getIdMesInicio().getIdMes());
        this.setPrograma(objeto.getIdPrograma().getIdPrograma());
        
        if (objeto.getIdMesFinalizacion() != null)
            this.setMesFinalizacion(objeto.getIdMesFinalizacion().getIdMes());
    }

    @Override
    public void insertarValoresDefecto() {
        Configuracion configuracion = new Configuracion();
        this.objeto.setEstado(true);
        this.objeto.setFechaRegistro(Date.valueOf(LocalDate.now()));
        this.objeto.setFechaActEstado(Date.valueOf(LocalDate.now()));
        this.objeto.setIdCiudad(configuracion.getIdCiudadUcentral());
        this.objeto.setIdInstitucion(configuracion.getIdInstitucionUcentral());
    }

    @Override
    public void validar() {
        if (mesInicio <= 0)
            addFieldError("mesInicio", "El mes inicio es requerido.");
        if (programa <= 0)
            addFieldError("programa", "El programa es requerido.");
        if (jornada <= 0)
            addFieldError("jornada", "La jornada es requerida.");
        if (objeto.getAnioInicio() <= 0)
            addFieldError("anioInicio", "El año de inicio es requerido.");
        
        // Estado educación
        if (estadoEducacion <= 0)
            addFieldError("estadoEducacion", "El estado es requerido.");
        else {
            // Configuración: Terminado
            if (estadoEducacion == 2)
            {
                if (objeto.getAnioFinalizacion() <= 0)
                    addFieldError("anioFinalizacion", "El año de finalización es requerido.");
                else if (objeto.getAnioFinalizacion() < objeto.getAnioInicio())
                    addFieldError("anioFinalizacion", "El año de finalización debe ser mayor al año de inicio.");
                
                if (mesFinalizacion <= 0)
                    addFieldError("mesFinalizacion", "El mes de finalización es requerido.");
                else if (objeto.getAnioFinalizacion() == objeto.getAnioInicio() &&
                        objeto.getIdMesFinalizacion().getNumero() < objeto.getIdMesInicio().getNumero())
                    addFieldError("mesFinalizacion", "El mes de finalización debe ser mayor o igual al mes de inicio.");
            }
        }
    }

    @Override
    public void validarLista() {
//        this.setListaNivelesEstudios(listas.getListaNivelesEstudiosUCentral());
//        
//        Collection<Long> lista = new ArrayList<>();
//        for (EducacionFormalUCentral ed : listaObjetos.values()) {
//            lista.add(ed.getIdNivelEstudios().getIdNivelEstudios());
//        }
//
//        for (NivelEstudios nivel : listaNivelesEstudios.values()) {
//            if (nivel.isObligatorioUCentral() && !lista.contains(nivel.getIdNivelEstudios())) {
//                addActionError(String.format("Ingrese al menos un estudio de tipo %s", nivel.getNombre()));
//            }
//        }
    }
}