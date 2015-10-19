/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controlador.ControladorCrud;
import Controlador.ControladorListas;
import Modelo.ItemLista;
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
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author YURY
 * @param <T>
 */
public abstract class CrudAction<T> extends ActionSupport implements ModelDriven<T> {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EgresadosPU");
    protected List<T> listaObjetos = new ArrayList<>();
    protected T objeto;
    protected boolean editar;
    protected boolean crear;
    protected boolean consultar;
    protected boolean consultar1;
    protected boolean buscar = true;
    protected int cantidadObjetos;
    protected ControladorListas listas;
    protected String getIdObjeto;
    protected String getIdObjetoEn;
    protected String nombreIdObjeto;
    protected String claseModelo;
    protected String entidad;
    protected String baseEntidad;
    protected String consultaTodos;
    protected String consultaIdObjeto;
    protected Map<String, Object> parametros;
    protected final ControladorCrud controladorCrud;
    protected String consultaTodosEn;
    protected String consultaTodosRe;
    protected String consultaTodosPregunta;
    protected String consultaIdObjetoEn;
    protected String entidadEn;
    private List<ItemLista> listaTipoPregunta;
    private List<ItemLista> ListaIdEncuesta;
    private List<ItemLista> ListaPreguntas;
    private String numEncuesta = null;

    public CrudAction(String clase) {
        this.claseModelo = clase;
        objeto = (T) instanciar();
        listas = new ControladorListas();
        controladorCrud = new ControladorCrud();
        System.out.println("jojojo");
        desplegar();
        System.out.println("jojojo11");
    }

    public List<ItemLista> getListaPreguntas() {
        return ListaPreguntas;
    }

    public void setListaPreguntas(List<ItemLista> ListaPreguntas) {
        this.ListaPreguntas = ListaPreguntas;
    }

    public List<ItemLista> getListaIdEncuesta() {
        return ListaIdEncuesta;
    }

    public void setListaIdEncuesta(List<ItemLista> ListaIdEncuesta) {
        this.ListaIdEncuesta = ListaIdEncuesta;
    }

    public List<ItemLista> getListaTipoPregunta() {
        return listaTipoPregunta;
    }

    public void setListaTipoPregunta(List<ItemLista> listaTipoPregunta) {
        this.listaTipoPregunta = listaTipoPregunta;
    }

    public boolean isConsultar() {
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public boolean isConsultar1() {
        return consultar1;
    }

    public void setConsultar1(boolean consultar1) {
        this.consultar1 = consultar1;
    }

    public boolean isBuscar() {
        return buscar;
    }

    public void setBuscar(boolean buscar) {
        this.buscar = buscar;
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

    public String getNumEncuesta() {
        return numEncuesta;
    }

    public void setNumEncuesta(String numEncuesta) {
        this.numEncuesta = numEncuesta;
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

    public String obtenerLista() {
        try {
            if (baseEntidad != null) {
                setListaObjetos((List<T>) controladorCrud.consultarLista(consultaTodos, claseModelo, getParametros(), baseEntidad));
            } else {
                if (claseModelo.equals("Modelo.Encuesta") || claseModelo.equals("Modelo.PreguntaEncuesta")) {
                    setListaObjetos((List<T>) controladorCrud.consultarListaEncuesta(consultaTodos, claseModelo, getParametros()));
                } else {
                    setListaObjetos((List<T>) controladorCrud.consultarLista(consultaTodos, claseModelo, getParametros()));
                }
            }
            this.setCantidadObjetos(this.getListaObjetos().size());
            return SUCCESS;
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(CrudAction.class.getName()).log(Level.SEVERE, null, ex);
            return ERROR;
        }
    }

    public String crear() {
        //this.desplegar();
        this.obtenerLista();
        this.editar = false;
        this.crear = true;
        return SUCCESS;
    }

    public String editar() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        this.obtenerLista();
        this.editar = true;
        this.crear = false;
        System.out.println("oqoqoqoq " + Long.parseLong(request.getParameter("idObjeto")));
        if (baseEntidad != null) {
            this.setObjeto((T) controladorCrud.consultar(consultaIdObjeto, claseModelo, getNombreIdObjeto(),
                    Long.parseLong(request.getParameter("idObjeto")), baseEntidad));
        } else {
            this.setObjeto((T) controladorCrud.consultar(consultaIdObjeto, claseModelo, getNombreIdObjeto(),
                    Long.parseLong(request.getParameter("idObjeto"))));
        }

        this.consultarTipos();
        return "desplegar";
    }

    public String guardar() {
        try {
            insertarTipos();
            validar();
            if (!hasErrors()) {
                insertarValoresDefecto();
                if (baseEntidad != null) {
                    controladorCrud.actualizar(getObjeto(), entidad, getIdObjeto, baseEntidad);
                } else {
                    System.out.println("llllllllllll "+getObjeto());
                    controladorCrud.actualizar(getObjeto(), entidad, getIdObjeto);
                }
                obtenerLista();
                this.setEditar(false);
                return SUCCESS;
            } else {
                obtenerLista();
                this.setEditar(true);
                return ERROR;
            }
        } catch (SecurityException | IllegalArgumentException ex) {
            Logger.getLogger(CrudAction.class.getName()).log(Level.SEVERE, null, ex);
            return ERROR;
        }
    }

    public String borrar() {
        try {
            HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);

            if (baseEntidad != null) {
                this.controladorCrud.borrar(baseEntidad, Long.parseLong(request.getParameter("idObjeto")));
            } else {
                this.controladorCrud.borrar(entidad, Long.parseLong(request.getParameter("idObjeto")));
            }

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
        if (!hasErrors()) {
            return "anterior";
        } else {
            obtenerLista();
            return ERROR;
        }
    }

    public String siguiente() {
        obtenerLista();
        validarLista();
        if (!hasErrors()) {
            return "siguiente";
        } else {
            obtenerLista();
            return ERROR;
        }
    }

    @Override
    public T getModel() {
        return getObjeto();
    }

    public boolean isCrear() {
        return crear;
    }

    public void setCrear(boolean crear) {
        this.crear = crear;
    }
}
