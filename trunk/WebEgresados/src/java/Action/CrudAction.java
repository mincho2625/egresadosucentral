/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorEgresado;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Collection;
import java.util.HashMap;
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
    private Map<Long, T> listaObjetos = new HashMap<Long, T>();
    private ControladorEgresado controladorEgresado;
    
    protected T objeto;
    protected String coleccion;
    protected String idObjeto;
    protected String claseModelo;
    protected Class claseBasePersistencia;
    protected Class claseConcretaPersistencia;
    protected boolean editar = false;
    
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
     * @return the listaObjetos
     */
    public Collection<T> getListaObjetos() {
        return listaObjetos.values();
    }

    /**
     * @param listaObjetos the listaObjetos to set
     */
    public void setListaObjetos(Map<Long, T> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }
    
    public CrudAction(String clase)
    {
        this.claseModelo = clase;
        objeto = (T)instanciar();        
        Map session = ActionContext.getContext().getSession();
        String usuario = (String) session.get("usuario");
        controladorEgresado = new ControladorEgresado(usuario);
    }
    
    public abstract String desplegar();
    
    public abstract void insertarTipos();
    
    public abstract void consultarTipos();
    
    public abstract void insertarValoresDefecto();
    
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

    public String guardar()
    {
        try {
            insertarTipos();
            insertarValoresDefecto();
            
            if (claseBasePersistencia != null)
                controladorEgresado.actualizar(objeto, claseConcretaPersistencia.getName(), idObjeto, claseBasePersistencia.getName(), "set" + claseBasePersistencia.getSimpleName());
            else
                controladorEgresado.actualizar(objeto, claseConcretaPersistencia.getName(), idObjeto);
            
            obtenerLista();
            this.setEditar(false);
            return SUCCESS;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(CrudAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return SUCCESS;
    }
    
    public String obtenerLista()
    {
        try {
            controladorEgresado.refrescar();
            if (claseBasePersistencia != null)
                setListaObjetos((Map<Long, T>) controladorEgresado.consultar(coleccion, idObjeto, claseModelo, claseBasePersistencia.getSimpleName()));
            else
                setListaObjetos((Map<Long, T>) controladorEgresado.consultar(coleccion, idObjeto, claseModelo));
            
            return SUCCESS;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(CrudAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return SUCCESS;
    }
    
    public String borrar()
    {
        try {
            HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
            this.controladorEgresado.borrar(claseConcretaPersistencia.getName(), Long.parseLong( request.getParameter("idObjeto")));
            this.obtenerLista();
            this.setEditar(false);
            return SUCCESS;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(CrudAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return SUCCESS;
    }
    
    public String editar()
    {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        this.desplegar();
        this.setObjeto(this.listaObjetos.get(Long.parseLong( request.getParameter("idObjeto"))));
        this.consultarTipos();
        return SUCCESS;
    }

    @Override
    public T getModel() {
        return objeto;
    }
}