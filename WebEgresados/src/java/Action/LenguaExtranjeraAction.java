/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.DominioLenguaExt;
import Modelo.Idioma;
import Modelo.LenguaExtranjera;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author YURY
 */
public class LenguaExtranjeraAction extends CrudAction<LenguaExtranjera> {
    private Map<Long, DominioLenguaExt> listaDominioLenguaExt;
    private Map<Long, Idioma> listaIdiomas;
    private long dominio;
    private long idioma;
    
    public LenguaExtranjeraAction() {
        super(LenguaExtranjera.class.getName());
        this.idObjeto = "getIdLenguaExtranjera";
        this.coleccion = "getLenguaExtranjeraCollection";
        this.claseConcretaPersistencia = Persistencia.LenguaExtranjera.class;
    }
    
    /**
     * @return the listaDominioLenguaExt
     */
    public Collection<DominioLenguaExt> getListaDominioLenguaExt() {
        return listaDominioLenguaExt.values();
    }

    /**
     * @param listaDominioLenguaExt the listaDominioLenguaExt to set
     */
    public void setListaDominioLenguaExt(Map<Long, DominioLenguaExt> listaDominioLenguaExt) {
        this.listaDominioLenguaExt = listaDominioLenguaExt;
    }

    /**
     * @return the listaIdiomas
     */
    public Collection<Idioma> getListaIdiomas() {
        return listaIdiomas.values();
    }

    /**
     * @param listaIdiomas the listaIdiomas to set
     */
    public void setListaIdiomas(Map<Long, Idioma> listaIdiomas) {
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
    public String desplegar() {
        this.setListaDominioLenguaExt(listas.getListaDominioLenguaExt());
        this.setListaIdiomas(listas.getListaIdiomas());
        
        this.obtenerLista();
        this.editar = true;
        return SUCCESS;
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdDominio(listas.getListaDominioLenguaExt().get(this.dominio));
        this.objeto.setIdIdioma(listas.getListaIdiomas().get(this.idioma));
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