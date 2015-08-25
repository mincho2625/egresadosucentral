/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Modelo.Contacto;
import Modelo.ItemLista;
import Modelo.TipoContacto;
import com.opensymphony.xwork2.ActionContext;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author YURY
 */
public class UbicacionAction extends CrudAction<Contacto> {

    private List<ItemLista> listaTiposContacto;
    private long tipoContacto;

    public UbicacionAction() {
        super(Modelo.Contacto.class.getName());
        this.getIdObjeto = "getIdContacto";
        this.consultaTodos = "Contacto.findByIdEgresado";
        this.entidad = Contacto.class.getSimpleName();
        this.nombreIdObjeto = "idContacto";
        this.consultaIdObjeto = "Contacto.findByIdContacto";
        
        Map session = ActionContext.getContext().getSession();
        long id = (long) session.get("idEgresado");
        this.parametros = new HashMap<>();
        this.parametros.put("idEgresado", id);
        this.objeto.setIdEgresado(id);
    }

    /**
     * @return the listaTiposContacto
     */
    public List<ItemLista> getListaTiposContacto() {
        return listaTiposContacto;
    }

    /**
     * @param listaTiposContacto the listaTiposContacto to set
     */
    public void setListaTiposContacto(List<ItemLista> listaTiposContacto) {
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
    public void desplegar() {
        this.setListaTiposContacto(listas.consultarTiposContacto());
        //this.obtenerLista();
        //this.editar = true;
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdTipoContacto((TipoContacto)controladorCrud.consultar("TipoContacto.findByIdTipoContacto", 
                Modelo.TipoContacto.class.getName(), "idTipoContacto", this.tipoContacto));
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
                
                Pattern pattern;
                Matcher matcher;
                switch((int)objeto.getIdTipoContacto().getIdTipoCampo().getIdTipoCampo())
                {
                    case 1:
                        pattern = Pattern.compile("[0-9]{7}|[0-9]{10}");
                        matcher = pattern.matcher(objeto.getDescripcion());
                        
                        if (!matcher.matches())
                            addFieldError("descripcion", "Ingrese un teléfono válido.");
                        break;
                    case 2:
                        pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                        matcher = pattern.matcher(objeto.getDescripcion());
                        
                        if (!matcher.matches())
                            addFieldError("descripcion", "Ingrese un email válido.");
                        break;
                }
            }
        }
    }

    @Override
    public void validarLista() {        
        List<Long> lista = new ArrayList<>();
        for (Contacto co : listaObjetos) {
            lista.add(co.getIdTipoContacto().getIdTipoContacto());
        }
        
        List<ItemLista> listaObligatorio = listas.consultarTiposContactoObligatorio();
        for (ItemLista tipo : listaObligatorio) {
            if (!lista.contains(tipo.getId())) {
                addActionError(String.format("Ingrese al menos un contacto de tipo %s", tipo.getNombre()));
            }
        }
    }
}
