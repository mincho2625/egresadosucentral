/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.Ciudad;
import Modelo.Educacion;
import Modelo.EducacionFormalUcentral;
import Modelo.EstadoEducacion;
import Modelo.Institucion;
import Modelo.ItemLista;
import Modelo.Jornada;
import Modelo.Mes;
import Modelo.Programa;
import Util.Constantes;
import com.opensymphony.xwork2.ActionContext;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author YURY
 */
public class EducacionFormalUCentralAction extends CrudAction<EducacionFormalUcentral> {
    private List<ItemLista> listaMeses;
    private List<ItemLista> listaEstadosEducacion;
    private List<ItemLista> listaJornadas;
    private ArrayList<Integer> listaAnios;
    private long mesInicio;
    private long mesFinalizacion;
    private long estadoEducacion;
    private long programa;
    private long jornada;
    private long nivelEstudios;
    private long facultad;

    public EducacionFormalUCentralAction() {
        super(EducacionFormalUcentral.class.getName());
        this.getIdObjeto = "getIdEducacion";
        this.consultaTodos = "EducacionFormalUcentral.findByIdEgresado";
        this.entidad = EducacionFormalUcentral.class.getSimpleName();
        this.nombreIdObjeto = "idEducacion";
        this.consultaIdObjeto = "EducacionFormalUcentral.findByIdEducacion";
        this.baseEntidad = Educacion.class.getSimpleName();
        
        Map session = ActionContext.getContext().getSession();
        long id = (long) session.get("idEgresado");
        this.parametros = new HashMap<>();
        this.parametros.put("idEgresado", id);
        this.objeto.setIdEgresado(id);
    }

    /**
     * @return the listaMeses
     */
    public List<ItemLista> getListaMeses() {
        return listaMeses;
    }

    /**
     * @param listaMeses the listaMeses to set
     */
    public void setListaMeses(List<ItemLista> listaMeses) {
        this.listaMeses = listaMeses;
    }

    /**
     * @return the listaEstadosEducacion
     */
    public List<ItemLista> getListaEstadosEducacion() {
        return listaEstadosEducacion;
    }

    /**
     * @param listaEstadosEducacion the listaEstadosEducacion to set
     */
    public void setListaEstadosEducacion(List<ItemLista> listaEstadosEducacion) {
        this.listaEstadosEducacion = listaEstadosEducacion;
    }

    /**
     * @return the listaJornadas
     */
    public List<ItemLista> getListaJornadas() {
        return listaJornadas;
    }

    /**
     * @param listaJornadas the listaJornadas to set
     */
    public void setListaJornadas(List<ItemLista> listaJornadas) {
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
    
    @Override
    public void desplegar() {
        this.setListaEstadosEducacion(listas.consultarEstadosEducacion());
        this.setListaMeses(listas.consultarMeses());
        this.setListaJornadas(listas.consultarJornadas());
        this.setListaAnios(listas.consultarAnios());
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdEstadoEducacion(new EstadoEducacion(this.estadoEducacion));
        this.objeto.setIdJornada(new Jornada(this.jornada));
        this.objeto.setIdMesFinalizacion(new Mes(this.mesFinalizacion));
        this.objeto.setIdMesInicio(new Mes(this.mesInicio));
        this.objeto.setIdPrograma(new Programa(this.programa));
    }

    @Override
    public void consultarTipos() {
        this.setNivelEstudios(objeto.getIdPrograma().getIdNivelEstudios().getIdNivelEstudios());
        this.setFacultad(objeto.getIdPrograma().getIdFacultad().getIdFacultad());
        this.setEstadoEducacion(objeto.getIdEstadoEducacion().getIdEstadoEducacion());
        this.setJornada(objeto.getIdJornada().getIdJornada());
        this.setMesInicio(objeto.getIdMesInicio().getIdMes());
        this.setPrograma(objeto.getIdPrograma().getIdPrograma());
        
        if (objeto.getIdMesFinalizacion() != null)
            this.setMesFinalizacion(objeto.getIdMesFinalizacion().getIdMes());
    }

    @Override
    public void insertarValoresDefecto() {
        this.objeto.setEstado(true);
        this.objeto.setFechaRegistro(Date.valueOf(LocalDate.now()));
        this.objeto.setFechaActEstado(Date.valueOf(LocalDate.now()));
        this.objeto.setIdCiudad(new Ciudad(Constantes.INSTITUCION_UCENTRAL));
        this.objeto.setIdInstitucion(new Institucion(Constantes.CIUDAD_BOGOTA));
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
            
            if (objeto.getAnioFinalizacion() == -1)
                objeto.setAnioFinalizacion(null);
        }
    }

    @Override
    public void validarLista() {
        List<ItemLista> listaNivelesEstudios = listas.consultarNivelesEstudiosObligatorioUCentral();
        
        Collection<Long> lista = new ArrayList<>();
        for (EducacionFormalUcentral ed : listaObjetos) {
            lista.add(ed.getIdPrograma().getIdNivelEstudios().getIdNivelEstudios());
        }

        for (ItemLista nivel : listaNivelesEstudios) {
            if (!lista.contains(nivel.getId())) {
                addActionError(String.format("Ingrese al menos un estudio de tipo %s", nivel.getNombre()));
            }
        }
    }
}