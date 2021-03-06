/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Modelo.AreaEstudios;
import Modelo.Ciudad;
import Modelo.EdFormalOtrasInstituciones;
import Modelo.Educacion;
import Modelo.EstadoEducacion;
import Modelo.Institucion;
import Modelo.ItemLista;
import Modelo.Mes;
import Modelo.Modalidad;
import Modelo.NivelEstudios;
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
public class EducacionFormalOtrasInstitucionesAction extends CrudAction<EdFormalOtrasInstituciones> {

    private List<ItemLista> listaMeses;
    private List<ItemLista> listaEstadosEducacion;
    private List<ItemLista> listaInstituciones;
    private List<ItemLista> listaModalidades;
    private ArrayList<Integer> listaAnios;

    private long mesInicio;
    private long mesFinalizacion;
    private long estadoEducacion;
    private long areaEstudios;
    private long ciudad;
    private long institucion;
    private long modalidad;
    private long nivelEstudios;
    private boolean checkOtraInstitucion;
    private long pais;
    private long departamento;

    public EducacionFormalOtrasInstitucionesAction() {
        super(EdFormalOtrasInstituciones.class.getName());
        this.getIdObjeto = "getIdEducacion";
        this.consultaTodos = "EdFormalOtrasInstituciones.findByIdEgresado";
        this.entidad = EdFormalOtrasInstituciones.class.getSimpleName();
        this.nombreIdObjeto = "idEducacion";
        this.consultaIdObjeto = "EdFormalOtrasInstituciones.findByIdEducacion";
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
     * @return the listaInstituciones
     */
    public List<ItemLista> getListaInstituciones() {
        return listaInstituciones;
    }

    /**
     * @param listaInstituciones the listaInstituciones to set
     */
    public void setListaInstituciones(List<ItemLista> listaInstituciones) {
        this.listaInstituciones = listaInstituciones;
    }

    /**
     * @return the listaModalidades
     */
    public List<ItemLista> getListaModalidades() {
        return listaModalidades;
    }

    /**
     * @param listaModalidades the listaModalidades to set
     */
    public void setListaModalidades(List<ItemLista> listaModalidades) {
        this.listaModalidades = listaModalidades;
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
    
    /**
     * @return the pais
     */
    public long getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(long pais) {
        this.pais = pais;
    }

    /**
     * @return the departamento
     */
    public long getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(long departamento) {
        this.departamento = departamento;
    }

    @Override
    public void desplegar() {
        this.setListaEstadosEducacion(listas.consultarEstadosEducacion());
        this.setListaMeses(listas.consultarMeses());
        this.setListaAnios(listas.consultarAnios());
        this.setListaInstituciones(listas.consultarOtrasInstituciones());
        this.setListaModalidades(listas.consultarModalidades());
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdEstadoEducacion(new EstadoEducacion(this.estadoEducacion));
        this.objeto.setIdMesFinalizacion(new Mes(this.mesFinalizacion));
        this.objeto.setIdMesInicio(new Mes(this.mesInicio));
        this.objeto.setIdAreaEstudios(new AreaEstudios(this.areaEstudios));
        this.objeto.setIdCiudad(new Ciudad(this.ciudad));
        this.objeto.setIdInstitucion(new Institucion(this.institucion));
        this.objeto.setIdModalidad(new Modalidad(this.modalidad));
        this.objeto.setIdNivelEstudios(new NivelEstudios(this.nivelEstudios));
        if (this.institucion > 0) {
            this.checkOtraInstitucion = false;
        }
    }

    @Override
    public void consultarTipos() {
        this.setPais(objeto.getIdCiudad().getIdDepartamento().getIdPais().getIdPais());
        this.setDepartamento(objeto.getIdCiudad().getIdDepartamento().getIdDepartamento());
        this.setEstadoEducacion(objeto.getIdEstadoEducacion().getIdEstadoEducacion());
        this.setMesInicio(objeto.getIdMesInicio().getIdMes());
        this.setNivelEstudios(objeto.getIdNivelEstudios().getIdNivelEstudios());
        this.setAreaEstudios(objeto.getIdAreaEstudios().getIdAreaEstudios());
        this.setCiudad(objeto.getIdCiudad().getIdCiudad());
        this.setModalidad(objeto.getIdModalidad().getIdModalidad());
        
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
        List<ItemLista> listaNivelesEstudios = listas.consultarNivelesEstudiosObligatorioOtrasInst();

        Collection<Long> lista = new ArrayList<>();
        for (EdFormalOtrasInstituciones ed : listaObjetos) {
            lista.add(ed.getIdNivelEstudios().getIdNivelEstudios());
        }

        for (ItemLista nivel : listaNivelesEstudios) {
            if (!lista.contains(nivel.getId())) {
                addActionError(String.format("Ingrese al menos un estudio de tipo %s", nivel.getNombre()));
            }
        }
    }
}