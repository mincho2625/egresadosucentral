/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.DominioLenguaExt;
import Modelo.Idioma;
import Modelo.ItemLista;
import Modelo.LenguaExtranjera;
import com.opensymphony.xwork2.ActionContext;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author YURY
 */
public class LenguaExtranjeraAction extends CrudAction<LenguaExtranjera> {
    private List<ItemLista> listaDominioLenguaExt;
    private List<ItemLista> listaIdiomas;
    private long dominio;
    private long idioma;
    
    public LenguaExtranjeraAction() {
        super(LenguaExtranjera.class.getName());
        this.getIdObjeto = "getIdLenguaExtranjera";
        this.consultaTodos = "LenguaExtranjera.findByIdEgresado";
        this.entidad = LenguaExtranjera.class.getSimpleName();
        this.nombreIdObjeto = "idLenguaExtranjera";
        this.consultaIdObjeto = "LenguaExtranjera.findByIdLenguaExtranjera";
        
        Map session = ActionContext.getContext().getSession();
        long id = (long) session.get("idEgresado");
        this.parametros = new HashMap<>();
        this.parametros.put("idEgresado", id);
        this.objeto.setIdEgresado(id);
    }
    
    /**
     * @return the listaDominioLenguaExt
     */
    public List<ItemLista> getListaDominioLenguaExt() {
        return listaDominioLenguaExt;
    }

    /**
     * @param listaDominioLenguaExt the listaDominioLenguaExt to set
     */
    public void setListaDominioLenguaExt(List<ItemLista> listaDominioLenguaExt) {
        this.listaDominioLenguaExt = listaDominioLenguaExt;
    }

    /**
     * @return the listaIdiomas
     */
    public List<ItemLista> getListaIdiomas() {
        return listaIdiomas;
    }

    /**
     * @param listaIdiomas the listaIdiomas to set
     */
    public void setListaIdiomas(List<ItemLista> listaIdiomas) {
        this.listaIdiomas = listaIdiomas;
    }

    /**
     * @return the dominio
     */
    public long getDominio() {
        return dominio;
    }

    /**
     * @param dominio the dominio to set
     */
    public void setDominio(long dominio) {
        this.dominio = dominio;
    }

    /**
     * @return the idioma
     */
    public long getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(long idioma) {
        this.idioma = idioma;
    }

    @Override
    public void desplegar() {
        this.setListaDominioLenguaExt(listas.consultarDominioLenguaExt());
        this.setListaIdiomas(listas.consultarIdiomas());
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdDominio(new DominioLenguaExt(this.dominio));
        this.objeto.setIdIdioma(new Idioma(this.idioma));
    }

    @Override
    public void consultarTipos() {
        this.setDominio(objeto.getIdDominio().getIdDominioLenguaExt());
        this.setIdioma(objeto.getIdIdioma().getIdIdioma());
    }

    @Override
    public void insertarValoresDefecto() {
        this.objeto.setEstado(true);
        this.objeto.setFechaRegistro(Date.valueOf(LocalDate.now()));
    }

    @Override
    public void validar() {
        if (dominio <= 0)
            addFieldError("dominio", "El dominio es requerido.");
        if (idioma <= 0)
            addFieldError("idioma", "El idioma es requerido.");
    }

    @Override
    public void validarLista() {
        if (cantidadObjetos == 0)
            addActionError("Ingrese al menos una lengua extranjera.");
    }
}