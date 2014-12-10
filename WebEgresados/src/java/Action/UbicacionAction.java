/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Modelo.Contacto;
import Modelo.TipoContacto;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author YURY
 */
public class UbicacionAction extends CrudAction<Contacto> {

    private Map<Long, TipoContacto> listaTiposContacto;
    private long tipoContacto;

    public UbicacionAction() {
        super(Modelo.Contacto.class.getName());
        this.idObjeto = "getIdContacto";
        this.coleccion = "getContactoCollection";
        this.claseConcretaPersistencia = Persistencia.Contacto.class;
    }

    /**
     * @return the listaTiposContacto
     */
    public Collection<TipoContacto> getListaTiposContacto() {
        return listaTiposContacto.values();
    }

    /**
     * @param listaTiposContacto the listaTiposContacto to set
     */
    public void setListaTiposContacto(Map<Long, TipoContacto> listaTiposContacto) {
        this.listaTiposContacto = listaTiposContacto;
    }

    /**
     * @return the tipoContacto
     */
    public long getTipoContacto() {
        return tipoContacto;
    }

    /**
     * @param tipoContacto the tipoContacto to set
     */
    public void setTipoContacto(long tipoContacto) {
        this.tipoContacto = tipoContacto;
    }

    @Override
    public String desplegar() {
        this.setListaTiposContacto(listas.consultarTiposContacto());
        this.obtenerLista();
        this.editar = true;
        return SUCCESS;
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdTipoContacto(listas.consultarTiposContacto().get(this.tipoContacto));
    }

    @Override
    public void consultarTipos() {
        this.setTipoContacto(objeto.getIdTipoContacto().getIdTipoContacto());
    }

    @Override
    public void insertarValoresDefecto() {
        this.objeto.setEstado(true);
        this.objeto.setFechaRegistro(Date.valueOf(LocalDate.now()));
    }

    @Override
    public void validar() {
        if (objeto.getIdTipoContacto() == null)
            addFieldError("tipoContacto", "El tipo de contacto es requerido.");
        else
        {
            if (objeto.getDescripcion().isEmpty())
                addFieldError("descripcion", "La descripción es requerida.");
            else
            {
                if (objeto.getDescripcion().length() > objeto.getIdTipoContacto().getLongitud())
                    addFieldError("descripcion", String.format("La longitud máxima para el tipo de contacto es %d", objeto.getIdTipoContacto().getLongitud()));
                
                switch((int)objeto.getIdTipoContacto().getIdTipoCampo().getIdTipoCampo())
                {
                    case 1:
                        if (!objeto.getDescripcion().matches("[1-9]\\\\d{7}|[1-9]\\\\d{10}")) {
                            addFieldError("descripcion", "Ingrese un teléfono válido.");
                        }
                        break;
                    case 2:
                        if (!objeto.getDescripcion().matches("^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@\"\n+[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$")) {
                            addFieldError("descripcion", "Ingrese un email válido.");
                        }
                        break;
                }
            }
        }
    }

    @Override
    public void validarLista() {
        this.setListaTiposContacto(listas.consultarTiposContacto());
        
        Collection<Long> lista = new ArrayList<>();
        for (Contacto co : listaObjetos.values()) {
            lista.add(co.getIdTipoContacto().getIdTipoContacto());
        }

        for (TipoContacto tipo : listaTiposContacto.values()) {
            if (tipo.isObligatorio() && !lista.contains(tipo.getIdTipoContacto())) {
                addActionError(String.format("Ingrese al menos un contacto de tipo %s", tipo.getNombre()));
            }
        }
    }
}
