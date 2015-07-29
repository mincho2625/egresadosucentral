/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.ItemLista;
import Modelo.TipoCampo;
import Modelo.TipoContacto;
import java.util.List;

/**
 *
 * @author yury
 */
public class TipoContactoAction extends CrudAction<TipoContacto> {
    private List<ItemLista> listaTiposCampos;
    private long tipoCampo;
    
    public TipoContactoAction() {
        super(TipoContacto.class.getName());
        this.getIdObjeto = "getIdTipoContacto";
        this.nombreIdObjeto = "idTipoContacto";
        this.entidad = TipoContacto.class.getSimpleName();
        this.consultaTodos = "TipoContacto.findByEstado";
        this.consultaIdObjeto = "TipoContacto.findByIdTipoContacto";
    }
    
    /**
     * @return the listaTiposCampos
     */
    public List<ItemLista> getListaTiposCampos() {
        return listaTiposCampos;
    }

    /**
     * @param listaTiposCampos the listaTiposCampos to set
     */
    public void setListaTiposCampos(List<ItemLista> listaTiposCampos) {
        this.listaTiposCampos = listaTiposCampos;
    }

    /**
     * @return the tipoCampo
     */
    public long getTipoCampo() {
        return tipoCampo;
    }

    /**
     * @param tipoCampo the tipoCampo to set
     */
    public void setTipoCampo(long tipoCampo) {
        this.tipoCampo = tipoCampo;
    }

    @Override
    public void desplegar() {
        this.setListaTiposCampos(listas.consultarTiposCampos());
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdTipoCampo(new TipoCampo(this.tipoCampo));
    }

    @Override
    public void consultarTipos() {
        this.tipoCampo = this.objeto.getIdTipoCampo().getIdTipoCampo();
    }

    @Override
    public void insertarValoresDefecto() {
        this.objeto.setEstado(true);
        //this.objeto.setFechaRegistro(Date.valueOf(LocalDate.now()));
    }

    @Override
    public void validar() {
        if (objeto.getNombre().isEmpty())
            addFieldError("nombre", "El nombre es requerido");
        if (objeto.getLongitud() < 0)
            addFieldError("longitud", "La longitud del campo es requerida");
        if (this.tipoCampo < 0)
            addFieldError("tipoCampo", "El tipo de campo es requerido");
    }

    @Override
    public void validarLista() {
        if (cantidadObjetos == 0)
            addActionError("Ingrese al menos un tipo de contacto.");
    }
}