/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorCrud;
import Controlador.ControladorListas;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author YURY
 * @param <T>
 */
public abstract class CrudAction<T> extends ActionSupport implements ModelDriven<T> {
    protected List<T> listaObjetos = new ArrayList<>();
    protected T objeto;
    protected boolean editar;
    protected int cantidadObjetos;
    protected ControladorListas listas;
    protected String getIdObjeto;
    protected String nombreIdObjeto;
    protected String claseModelo;
    protected String entidad;
    protected String baseEntidad;
    protected String consultaTodos;
    protected String consultaIdObjeto;
    protected Map<String, Object> parametros;
    protected final ControladorCrud controladorCrud;
    
    public CrudAction(String clase)
    {
        this.claseModelo = clase;
        objeto = (T)instanciar();
        listas = new ControladorListas();
        controladorCrud = new ControladorCrud();
        
        //if (editar)
        desplegar();
    }
    
    /**
     * @return the listaObjetos
     */
    public List<T> getListaObjetos() {
        return listaObjetos;
    }

    /**
     * @param listaObjetos the listaObjetos to set
     */
    public void setListaObjetos(List<T> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    /**
     * @return the objeto
     */
    public T getObjeto() {
        return objeto;
    }

    /**
     * @param objeto the objeto to set
     */
    public void setObjeto(T objeto) {
        this.objeto = objeto;
    }

    /**
     * @return the cantidadObjetos
     */
    public int getCantidadObjetos() {
        return cantidadObjetos;
    }

    /**
     * @param cantidadObjetos the cantidadObjetos to set
     */
    public void setCantidadObjetos(int cantidadObjetos) {
        this.cantidadObjetos = cantidadObjetos;
    }
    
    /**
     * @return the nombreIdObjeto
     */
    public String getNombreIdObjeto() {
        return nombreIdObjeto;
    }

    /**
     * @param nombreIdObjeto the nombreIdObjeto to set
     */
    public void setNombreIdObjeto(String nombreIdObjeto) {
        this.nombreIdObjeto = nombreIdObjeto;
    }

    /**
     * @return the parametros
     */
    public Map<String, Object> getParametros() {
        return parametros;
    }

    /**
     * @param parametros the parametros to set
     */
    public void setParametros(Map<String, Object> parametros) {
        this.parametros = parametros;
    }
    
    /**
     * @return the editar
     */
    public boolean isEditar() {
        return editar;
    }

    /**
     * @param editar the editar to set
     */
    public void setEditar(boolean editar) {
        this.editar = editar;
    }
    
    public abstract void desplegar();
    
    public abstract void insertarTipos();
    
    public abstract void consultarTipos();
    
    public abstract void insertarValoresDefecto();
    
    public abstract void validar();
    
    public abstract void validarLista();
    
    private Object instanciar() {
        try {
            Class<?> clase = Class.forName(this.claseModelo);
            if (clase == null) {
                return null;
            }
            return clase.newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            Logger.getLogger(CrudAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String obtenerLista()
    {
        try {
            if (baseEntidad != null)
                setListaObjetos((List<T>) controladorCrud.consultarLista(consultaTodos, claseModelo, getParametros(), baseEntidad));
            else
                setListaObjetos((List<T>) controladorCrud.consultarLista(consultaTodos, claseModelo, getParametros()));
            
            this.setCantidadObjetos(this.getListaObjetos().size());
            return SUCCESS;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(CrudAction.class.getName()).log(Level.SEVERE, null, ex);
            return ERROR;
        }
    }
    
    public String crear()
    {
        //this.desplegar();
        this.obtenerLista();
        this.editar = true;
        return SUCCESS;
    }
    
    public String editar()
    {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        this.crear();
        
        if (baseEntidad != null) {
            this.setObjeto((T) controladorCrud.consultar(consultaIdObjeto, claseModelo, getNombreIdObjeto(), 
                    Long.parseLong( request.getParameter("idObjeto")), baseEntidad));
        }
        else {
            this.setObjeto((T) controladorCrud.consultar(consultaIdObjeto, claseModelo, getNombreIdObjeto(), 
                    Long.parseLong( request.getParameter("idObjeto"))));
        }
        
        this.consultarTipos();
        return "desplegar";
    }
    
    public String guardar()
    {
        try {
            insertarTipos();
            validar();
            
            if (!hasErrors()){
                insertarValoresDefecto();
                if (baseEntidad != null)
                    controladorCrud.actualizar(getObjeto(), entidad, getIdObjeto, baseEntidad);
                else
                    controladorCrud.actualizar(getObjeto(), entidad, getIdObjeto);

                obtenerLista();
                this.setEditar(false);
                return SUCCESS;
            }
            else
            {
                this.crear();
                return ERROR;
            }
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(CrudAction.class.getName()).log(Level.SEVERE, null, ex);
            return ERROR;
        }
    }
    
    public String borrar()
    {
        try {
            HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
            
            if (baseEntidad != null)
                this.controladorCrud.borrar(baseEntidad, Long.parseLong( request.getParameter("idObjeto")));
            else
                this.controladorCrud.borrar(entidad, Long.parseLong( request.getParameter("idObjeto")));
            
            this.obtenerLista();
            this.editar = false;
            return SUCCESS;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(CrudAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return SUCCESS;
    }
    
    public String anterior() {
        obtenerLista();
        validarLista();
        if (!hasErrors())
            return "anterior";
        else {
            obtenerLista();
            return ERROR;
        }
    }
    
    public String siguiente() {
        obtenerLista();
        validarLista();
        if (!hasErrors())
            return "siguiente";
        else {
            obtenerLista();
            return ERROR;
        }
    }

    @Override
    public T getModel() {
        return getObjeto();
    }
}