/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Modelo.Aficiones;
import Modelo.ItemLista;
import Modelo.TipoActividad;
import com.opensymphony.xwork2.ActionContext;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author JERONIMO
 */
public class AficionAction extends CrudAction<Aficiones> {

    private List<ItemLista> listaTiposActividades;
    private long tipoActividad;

    public AficionAction() {
        super(Aficiones.class.getName());
        this.getIdObjeto = "getIdAficion";
        this.consultaTodos = "Aficiones.findByIdEgresado";
        this.entidad = Aficiones.class.getSimpleName();
        this.nombreIdObjeto = "idAficion";        
        this.consultaIdObjeto = "Aficiones.findByIdAficion";
        
        Map session = ActionContext.getContext().getSession();
        long id = (long) session.get("idEgresado");
        this.parametros = new HashMap<>();
        this.parametros.put("idEgresado", id);
        this.objeto.setIdEgresado(id);
    }

    /**
     * @return the listaTiposActividades
     */
    public List<ItemLista> getListaTiposActividades() {
        return listaTiposActividades;
    }

    /**
     * @param listaTiposActividades the listaTiposActividades to set
     */
    public void setListaTiposActividades(List<ItemLista> listaTiposActividades) {
        this.listaTiposActividades = listaTiposActividades;
    }

    /**
     * @return the tipoActividad
     */
    public long getTipoActividad() {
        return tipoActividad;
    }

    /**
     * @param tipoActividad the tipoActividad to set
     */
    public void setTipoActividad(long tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    @Override
    public void desplegar() {
        this.setListaTiposActividades(listas.consultarTiposActividades());
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdTipoActividad(new TipoActividad(this.tipoActividad));
    }

    @Override
    public void consultarTipos() {
        this.setTipoActividad(objeto.getIdTipoActividad().getIdTipoActividad());
    }

    @Override
    public void insertarValoresDefecto() {
        this.objeto.setEstado(true);
        this.objeto.setFechaRegistro(Date.valueOf(LocalDate.now()));
    }

    @Override
    public void validar() {
        if (objeto.getListaActividades().equals("")) {
            addFieldError("listaActividades", "La lista de actividades es requerida");
        }
        
        if (tipoActividad <= 0) {
            addFieldError("tipoActividad", "El tipo de actividad es requerido");
        }
    }

    @Override
    public void validarLista() {
        if (cantidadObjetos == 0)
            addActionError("Ingrese al menos un deporte o afición");
    }
}