/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorEgresado;
import Util.ConvertidorObjetos;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    private T objeto;
    private Map<Long, T> listaObjetos = new HashMap<Long, T>();
    private ControladorEgresado controladorEgresado;
    
    protected String metodoConsultar;
    protected String metodoActualizar;
    protected String metodoBorrar;
    protected String clase;
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
        this.clase = clase;
        objeto = (T)instanciar();        
        Map session = ActionContext.getContext().getSession();
        String usuario = (String) session.get("usuario");
        controladorEgresado = new ControladorEgresado(usuario);
    }
    
    public abstract String desplegar();
    
    private Object instanciar() {
        try {
            Class<?> clase = Class.forName(this.clase);
            if (clase == null) {
                return null;
            }
            return clase.newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            Logger.getLogger(ConvertidorObjetos.class.getName()).log(Level.SEVERE, null, ex);
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
            Method actualizar = controladorEgresado.getClass().getDeclaredMethod(metodoActualizar, objeto.getClass());
            actualizar.invoke(controladorEgresado, objeto);
            obtenerLista();
            this.setEditar(false);
            return SUCCESS;
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(CrudAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return SUCCESS;
    }
    
    public String obtenerLista()
    {
        try {
            controladorEgresado.refrescar();
            Method consultar = controladorEgresado.getClass().getDeclaredMethod(metodoConsultar);            
            setListaObjetos((Map<Long, T>) consultar.invoke(controladorEgresado));
            
            return SUCCESS;
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(CrudAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return SUCCESS;
    }
    
    public String borrar()
    {
        try {
            HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
            
            Method borrar = controladorEgresado.getClass().getDeclaredMethod(metodoBorrar, Long.TYPE);
            borrar.invoke(controladorEgresado, Long.parseLong(request.getParameter("idObjeto")));
            
            //this.controladorEgresado.borrarDatosUbicacion(Long.parseLong( request.getParameter("idContacto")));
            this.obtenerLista();
            this.setEditar(false);
            return SUCCESS;
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(CrudAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return SUCCESS;
    }
    
    public String editar()
    {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        this.desplegar();
        this.setObjeto(this.listaObjetos.get(Long.parseLong( request.getParameter("idObjeto"))));
        return SUCCESS;
    }

    @Override
    public T getModel() {
        return objeto;
    }
}